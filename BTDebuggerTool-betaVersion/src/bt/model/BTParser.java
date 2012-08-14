package bt.model;

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
        public BTTree getBt() {
			return bt;
		}

		private BTNode tempNode = null;
        private BTNode parentTempNode = null;
        private Stack <BTNode> stack = new Stack<BTNode>();
        private String uri;
        private String modName;
        private BTBehavior behaviorTemp;
        private BTComponent componentTemp;
//        private ABSModule mod;
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
                    behaviorTemp = new BTBehaviorStateRealisation(attrs.getValue("ref"),attrs.getValue("val"));
                }
                else if(attrs.getValue("xsi:type").equalsIgnoreCase("textbt:Guard") || attrs.getValue("xsi:type").equalsIgnoreCase("textbt:Event"))
                {
                    behaviorTemp = new BTBehaviorGuard(attrs.getValue("ref"),attrs.getValue("val"));
                }
                else if(attrs.getValue("xsi:type").equalsIgnoreCase("textbt:Selection"))
                {
                    behaviorTemp = new BTBehaviorSelection(attrs.getValue("ref"),attrs.getValue("val"));
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
        
        private void assignNodeNumber(BTNode root)
        {
            assignNodeNumber(root,"0");
        }
        
        private void assignNodeNumber(BTNode node,String pc)
        {
            node.setNodeNumber(pc);
            for(int i = 0; i < node.getDirectChilds().size(); i++)
            {
                assignNodeNumber(node.getDirectChilds().get(i),node.getNodeNumber()+i);
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
        public void endDocument() throws SAXException {
//        	System.out.println(this.bt.toString());
        	if(bt.getComponents()!=null)
            {
                Iterator<BTComponent> i = bt.getComponents().iterator();
                while(i.hasNext())
                {
                    BTComponent b = i.next();
                    b.collectVariables();
                }
                assignNodeNumber(bt.getRoot());
                bt.giveBTTNumberForBTNode();
            }
        }
		//===========================================================
		// Helpers Methods
		//===========================================================
	
		// Wrap I/O exceptions in SAX exceptions, to
		// suit handler signature requirements
		private void showData ( String s) throws SAXException
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

