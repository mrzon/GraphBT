package bt2abs;

/**
*  This code is provided only for Tutorial Purpose. For More details,
*  please refer to Terms Of Usage as defined at http://www.javacommerce.com
*  The Latest Version of code for this Tutorial can be downloaded from
*  Http://www.JavaCommerce.com
*
*  @Author Sudhir Ancha
**/

import java.io.*;
import java.util.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class BTParser extends DefaultHandler
{
	//protected static final String XML_FILE_NAME = "D:\\Semester7\\TA\\Simulation\\v.1\\ProducerConsumer.xml";
        private BTTree bt = new BTTree(null);
        private BTNode tempNode = null;
        private BTNode parentTempNode = null;
        private Stack <BTNode> stack = new Stack<BTNode>();
        private String uri;
        private String modName;
        private String pathABS;
        private BTBehavior behaviorTemp;
        private BTComponent componentTemp;
        private ABSModule mod;
        private boolean trace = false;
        static private Writer  out;

        public BTParser(String modName) {
            this(modName,false);
        }

        public BTParser(String modName, boolean trace) {
            this.modName = modName;
            this.trace = trace;
        }

	//===========================================================
	// Methods in SAX DocumentHandler
	//===========================================================

        public BTParser(String modName2, String path, boolean trace2) {
			this.modName = modName2;
			this.pathABS = path;
			this.trace=trace2;
		}

		@Override
	public void startElement (String uri, String localName, String qName, Attributes attrs)
	throws SAXException
	{
            if(qName.equals("components"))
            {
                if(attrs.getLength()==0)
                {
                
                }
                else 
                {
                    if(attrs.getValue("ref").equals("CLIST"))
                    {
                        componentTemp = BTComponent.LIST;
                    }
                    else if(attrs.getValue("ref").equals("CSET"))
                    {
                        componentTemp = BTComponent.SET;
                    }
                    else if(attrs.getValue("ref").equals("CDATA"))
                    {
                       
                        componentTemp = BTComponent.DATA;
                    }
                    else {
                    	
                        componentTemp = new BTComponent(attrs.getValue("ref"),attrs.getValue("val"));
                    }
                    
                    
                }
            }
            else if(qName.equals("behaviors"))
            {
                if(attrs.getValue("xsi:type").equalsIgnoreCase("textbt:State"))
                {
                    behaviorTemp = new BTStateRealization(attrs.getValue("ref"),attrs.getValue("val"));
                }
                else if(attrs.getValue("xsi:type").equalsIgnoreCase("textbt:Guard"))
                {
                    behaviorTemp = new BTGuard(attrs.getValue("ref"),attrs.getValue("val"));
                }
                else if(attrs.getValue("xsi:type").equalsIgnoreCase("textbt:Selection"))
                {
                    behaviorTemp = new BTSelection(attrs.getValue("ref"),attrs.getValue("val"));
                }
                else
                {
                    behaviorTemp = new BTBehavior(attrs.getValue("xsi:type"),attrs.getValue("ref"),attrs.getValue("val"));
                }
            }
            else if(qName.equalsIgnoreCase("relations"))
            {
                behaviorTemp.addRelation(attrs.getValue("question"), attrs.getValue("componentRef"), attrs.getValue("preposition"));
            }
            else if(qName.equalsIgnoreCase("behaviorTree"))
            {
                //System.out.println("membuat tree.. hihuiii");
            }
            else if(qName.equalsIgnoreCase("rootNode"))
            {
                BTComponent temp = bt.getComponent(attrs.getValue("componentRef"));
                BTNode b = new BTNode(temp,temp.getBehavior(attrs.getValue("behaviorRef")));
                bt.setRoot(b);
                parentTempNode = b;
                stack.push(b);
                bt.addBTNode(b);
            }
            else if(qName.equalsIgnoreCase("childNode"))
            {
                String type = attrs.getValue("xsi:type");
                if(type == null || (type != null && !type.toLowerCase().endsWith("block"))){
                    BTComponent c = bt.getComponent(attrs.getValue("componentRef"));
                    BTBehavior b = c.getBehavior(attrs.getValue("behaviorRef"));
                    String op = attrs.getValue("operator");
                    tempNode = new BTNode(type,op,c,b);
                }
                else
                {
                    tempNode = new BTNode(type);
                }
                bt.addBTNode(tempNode);
                stack.peek().addChild(tempNode);
                stack.push(tempNode);
                parentTempNode = tempNode;
            }
	}
        
        private void assignPC(BTNode root)
        {
            assignPC(root,"0");
        }
        
        private void assignPC(BTNode node,String pc)
        {
            node.setPC(pc);
            for(int i = 0; i < node.getChilds().size(); i++)
            {
                assignPC(node.getChilds().get(i),node.getPC()+i);
            }
        }
        
        @Override   
        public void endElement(String uri, String localName, String qName)
        {
            if(qName.equals("components")){
                if(componentTemp != null)
                {
                    bt.addComponent(componentTemp);
                    componentTemp = null;
                }
                else 
                {
                }
            }
            else if(qName.equalsIgnoreCase("behaviors"))
            {
                componentTemp.addBehavior(behaviorTemp);
            }
            else if(qName.equalsIgnoreCase("childNode"))
            {
                try{
                    stack.pop();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else if(qName.equalsIgnoreCase("rootNode"))
            {
                try{
                    parentTempNode = stack.pop();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        @Override
        public void endDocument()
        {
            assignPC(this.bt.getRoot()); //assign BT order number
            mod = new ABSModule(modName,trace,pathABS); //create new ABS Module with module name and trace option
            ABSInterface ai = new ABSInterface("Component");    //create interface named 'Component'
            ArrayList<ABSParameter> temp = new ArrayList<ABSParameter>(); //create 'Component'`s parameters
            temp.add(new ABSParameter(ABSDataType.STRING,"command"));
            ABSMethod runM = new ABSMethod(ABSDataType.UNIT,"runMethod",temp);
            ABSMethod isT = new ABSMethod(ABSDataType.BOOL,"isTerminate",new ArrayList<ABSParameter>());
            
            ai.add(runM);
            ai.add(isT);
            mod.addInterface(ai);   //add 'Component' to the module
            mod.setBTTree(bt);      //assign the BT to the module
            mod.addForeign(ABSForeign.IO);  //add foreign class 'IO'
            mod.addForeign(ABSForeign.MATH);//add foreign class 'Math'
            if(bt.getComponents()!=null)    //get one component
            {
                Iterator<BTComponent> i = bt.getComponents().iterator();
                while(i.hasNext())
                {
                    BTComponent b = i.next();
                    b.collectABSVariables(mod);//get all the variable
                }
            }
            ABSMainBlock main = new ABSMainBlock();
            main.addStatement(new ABSStatement(ABSStatementType.DECLARATION,"IO i = new IOImpl()"));
            Iterator<BTComponent> ii = bt.getComponents().iterator();
            ArrayList<BTComponent> undVar = new ArrayList<BTComponent> (); //create bag for undefined variable
            while(ii.hasNext())
            {
                BTComponent component = ii.next();
                String stat = "";
                String var = "";
                boolean skip = false;
                if(component.isPrimitive())
                {   
                    stat = component.asDataType().toString()+ " "+component.getRef().toLowerCase()+"_var = "+component.asDataType().getDefaultValue();
                    var = component.getRef().toLowerCase()+"_var";
                }
                else if(component.isData())
                {
                    stat = component.getName()+ "_Data "+component.getRef().toLowerCase()+"_var = "+component.getName()+"_Data_Default";
                    var = component.getRef().toLowerCase()+"_var";
                }
                else
                {
                    System.out.println("ini bukan data dan bukan primitive :D "+component.getName());
                    if(component.getComponentClass()!=null)
                    {
                        if(component.getComponentClass().getParameters() != null)
                        {
                            
                            String a[] = new String[component.getComponentClass().getParameters().size()];
                            System.out.println("jumlah param "+a.length);
                            for(int i = 0; i < a.length; i++)
                            {
                                a[i] = component.getComponentClass().getParameters().get(i).getDefault();
                                
                                if(!main.isDeclared(a[i]))
                                {
                                    System.out.println("yang belom dideclare "+a[i]);
                                    skip = true;
                                    break;
                                }
                            }
                            stat = component.getComponentClass().initialize(component.getRef().toLowerCase()+"_var",a);
                            var = component.getRef().toLowerCase()+"_var";
                            System.out.println(stat);
                        }
                    }
                }
                //if(!component.getName().equalsIgnoreCase("SET") && !component.getName().equalsIgnoreCase("LIST"))
                if(skip)
                {
                    undVar.add(component);
                }
                else
                {
                    main.addDeclaredVariable(var);
                    main.addStatement(new ABSStatement(ABSStatementType.DECLARATION,stat));
                }
            }
            System.out.println(undVar.size());
            int j = 0;
            while(!undVar.isEmpty() && j++ < 1000)
            {
                System.out.println("as");
                BTComponent bb = undVar.remove(0);
                String stat = null;
                boolean skip = false;
                if(bb.getComponentClass()!=null)
                {
                    if(bb.getComponentClass().getParameters() != null)
                    {
                        String a[] = new String[bb.getComponentClass().getParameters().size()];
                        for(int i = 0; i < a.length; i++)
                        {
                            a[i] = bb.getComponentClass().getParameters().get(i).getDefault();
                            if(!main.isDeclared(a[i]))
                            {
                                skip = true;
                                break;
                            }
                        }
                        stat = bb.getComponentClass().initialize(bb.getRef().toLowerCase()+"_var",a);
                    }
                }
                if(skip)
                {
                    undVar.add(bb);
                }
                else
                {
                    main.addDeclaredVariable(bb.getRef().toLowerCase()+"_var");
                    main.addStatement(new ABSStatement(ABSStatementType.DECLARATION,stat));
                }
            }
            main.addStatement(new ABSStatement(ABSStatementType.BLOCK,bt.toStringABS(bt.getRoot())));
            main.addStatement(new ABSStatement(ABSStatementType.DECLARATION,"T t = new Tree(node0)"));
            main.addStatement(new ABSStatement(ABSStatementType.CALL,"t.execute()"));
            mod.setMainBlock(main);
            mod.writeToFile();
            mod.check();
            mod.generate();
        }

	//===========================================================
	// Helpers Methods
	//===========================================================

	// Wrap I/O exceptions in SAX exceptions, to
	// suit handler signature requirements
	private void showData (String s)
	throws SAXException
	{
		try {
			out.write (s);
			out.flush ();
		} catch (IOException e) {
			throw new SAXException ("I/O error", e);
		}
	}

	// Start a new line
	private void newLine ()
	throws SAXException
	{
		String lineEnd =  System.getProperty("line.separator");
		try {
			out.write (lineEnd);
		} catch (IOException e) {
			throw new SAXException ("I/O error", e);
		}
	}
        
        //check whether we should trace the ABSModel
        public boolean isTracing()
        {
            return trace;
        }
}
