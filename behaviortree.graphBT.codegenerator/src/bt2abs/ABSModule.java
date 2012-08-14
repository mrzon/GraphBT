/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2abs;


import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import codegenerator.helper.Helper;

/**
 *
 * @author Emerson  
 */
public class ABSModule {
    private Set<ABSInterface> setOfInterface = new HashSet<ABSInterface> ();
    private Set<ABSClass> setOfClasses = new HashSet<ABSClass> ();
    private Set<ABSLibrary> setOfLib = new HashSet<ABSLibrary>();
    private Set<ABSEnum> setOfEnum = new HashSet<ABSEnum>();
    private ArrayList<ABSForeign> listOfFor = new ArrayList<ABSForeign>();
    private ABSMainBlock main = null;
    private String absPath = "";
    private String javaPath = "src";
    private String name;
    private BTTree bt = null;
    
    private HashMap<String,ABSMethodImplementation> tempM = new HashMap<String,ABSMethodImplementation>();
    private HashMap<String,BTComponent> tempN = new HashMap<String,BTComponent>();
    private HashMap<String,BTComponent> tempMM = new HashMap<String,BTComponent>();
    private boolean trace = false;
    
    ABSModule(String n)
    {
        this(n,false,"");
    }
    ABSModule(String n,boolean t)
    {
        this(n,t,"");
    }
    
    ABSModule(String n, boolean t, String path)
    {
        name = n;
        absPath = path;
        this.trace = t;
        javaPath = path+(path.endsWith("\\")?"":"\\")+javaPath;
    }
    
    public void addInterface(ABSInterface i)
    {
        this.setOfInterface.add(i);
    }
    
    public void setBTTree(BTTree b)
    {
        bt = b;
    }
    
    public BTTree getBT()
    {
        return bt;
    }
    
    public boolean addClass(ABSClass i)
    {
        this.setOfClasses.add(i);
        return true;   
    }
    
    public boolean addEnum(ABSEnum i)
    {
        if(!setOfEnum.contains(i))
        {
            this.setOfEnum.add(i);
            return true;
        }
        return false;
    }
    
    public void addLibrary(ABSLibrary abs)
    {
        setOfLib.add(abs);
    }
    
    public void check()
    {
        try {
        	String absbatPath = Helper.getURL("lib\\abs.bat").getPath();
            String absFilePath = absPath+"/"+getName()+".abs";
            
           
            Process p = Runtime.getRuntime().exec (absbatPath+" check "+absFilePath);
            p.waitFor();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String temp;
            while((temp=in.readLine())!=null)
            {
                System.out.println(temp);
            }        
        } catch (Exception ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void execute()
    {
        try {
            Process p = Runtime.getRuntime().exec ("abs.bat execute "+javaPath+" "+getName());
            p.waitFor();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String temp;
            while((temp=in.readLine())!=null)
            {
                System.out.println(temp);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void generate()
    {
        try {
            File file = new File(javaPath);
            if(!file.exists() || !file.isDirectory())
            {
                file.mkdirs();
                System.out.println("hai "+file.isDirectory());
            }
            System.out.println("hais "+file.isDirectory()+" "+javaPath);
            String absbatPath = Helper.getURL("lib\\absfrontend.jar").getPath();
            String absFilePath = absPath+"/"+getName()+".abs";
            
            //Process p = Runtime.getRuntime().exec (absbatPath+" code "+absFilePath+" "+javaPath);
            
            Process p = Runtime.getRuntime().exec ("java -Xms64m -Xmx256m -cp "+absbatPath+" abs.backend.java.JavaBackend -d "+javaPath+" "+absFilePath);
            p.waitFor();
            System.out.println("asd");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String temp;
            while((temp=in.readLine())!=null)
            {
                System.out.println(temp);
            }
            
            BufferedReader f = null;
            BufferedWriter g = null;
            File classpath = new File(absPath+"\\.classpath");
            String strClasspath = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
"<classpath>\n"+
	"<classpathentry kind=\"src\" path=\"src\"/>\n"+
	"<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7\"/>\n"+
	"<classpathentry kind=\"lib\" path=\""+absbatPath+"\"\n/>"+
	"<classpathentry kind=\"output\" path=\"bin\"/>\n"+
"</classpath>";
            classpath.createNewFile();
            File project = new File(absPath+"\\.project");
            project.createNewFile();
            String strProject = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
"<projectDescription>"+
	"<name>"+getName()+"</name>"+
	"<comment></comment>"+
	"<projects>"+
	"</projects>"+
	"<buildSpec>"+
		"<buildCommand>"+
			"<name>org.eclipse.jdt.core.javabuilder</name>"+
			"<arguments>"+
			"</arguments>"+
		"</buildCommand>"+
	"</buildSpec>"+
	"<natures>"+
		"<nature>org.eclipse.jdt.core.javanature</nature>"+
	"</natures>"+
"</projectDescription>";
            FileWriter fw = new FileWriter(classpath);
            fw.append(strClasspath);
            fw.flush();
            fw.close();
            fw = new FileWriter(project);
            fw.append(strProject);
            fw.flush();
            fw.close();
            
            for(int ii = 0; ii < listOfFor.size(); ii++){
                try {
                    f = new BufferedReader(new InputStreamReader(Helper.getURL("lib\\template_java\\"+listOfFor.get(ii).getJavaCode()).openStream()));
                    File ff = new File(javaPath+"\\"+getName()+"\\"+listOfFor.get(ii).getJavaCode()+".java");
                    File gg = new File(javaPath+"\\"+getName());
                    if(!gg.isDirectory())
                    {
                    	gg.mkdir();
                    }
                    ff.createNewFile();
                    
                    g = new BufferedWriter(new FileWriter(ff));
                    String w = "";
                    while((temp=f.readLine())!=null)
                    {
                        String xx[] = temp.split("\\[P\\]");
                        if(xx.length>1){
                            w+=xx[0]+getName()+xx[1]+"\n";
                        }
                        else
                        {
                            w+=temp+"\n";
                        }
                    }
                    g.write(w);
                    g.flush();
                    g.close();
                    long heapSize = Runtime.getRuntime().totalMemory();
                    
                    //Print the jvm heap size.
                    System.out.println("Heap Size = " + heapSize);
                    //p = Runtime.getRuntime().exec (absbatPath+" compile "+javaPath+" "+getName()+" "+listOfFor.get(ii).getJavaCode()+".java");
                    p = Runtime.getRuntime().exec ("javac -cp "+javaPath+";"+absbatPath+" "+javaPath+"\\"+getName()+"\\"+listOfFor.get(ii).getJavaCode()+".java");
                    p.waitFor();
                    in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    
                    while((temp=in.readLine())!=null)
                    {
                        System.out.println(temp);
                    }
                } catch (Exception ex) {
                        Logger.getLogger(ABSForeign.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                finally {
                    try {
                        f.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ABSForeign.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addForeign(ABSForeign n)
    {
        listOfFor.add(n);
    }
    
    public ABSInterface getInterface(String name)
    {
        Iterator<ABSInterface>  i = setOfInterface.iterator();
        while(i.hasNext())
        {
            ABSInterface ai = i.next();
            if(name.equals(ai.getName()))
            {
                return ai;
            }
        }
        return null;
    }
    
    public ABSEnum getEnum(String name)
    {
        
        Iterator<ABSEnum>  i = setOfEnum.iterator();
        while(i.hasNext())
        {
            ABSEnum ai = i.next();
            //System.out.println(ai.getName()+"jshdf");
            if(name.equals(ai.getName()))
            {
                
                return ai;
            }
        }
        return null;
    }
    
    public boolean containEnum(String name)
    {
        Iterator<ABSEnum>  i = setOfEnum.iterator();
        while(i.hasNext())
        {
            ABSEnum ai = i.next();
            if(name.equals(ai.getName()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    public ABSClass getClass(String name)
    {
        Iterator<ABSClass>  i = setOfClasses.iterator();
        while(i.hasNext())
        {
            ABSClass ac = i.next();
            if(name.equals(ac.getClassName()))
            {
                return ac;
            }
        }
        return null;
    }
    
    
    public String getName()
    {
        return name;
    }
            
    
    public void writeToFile()
    {
        FileWriter f = null;
        try {
        	File fabs = new File(absPath);
        	if(!fabs.exists())
        	{
        		fabs.mkdirs();
        	}
        	File ff =new File(absPath+"\\"+getName()+".abs");
        	System.out.println("file absnya ini "+ ff.getAbsolutePath());
        	if(!ff.exists())
        	{
        		ff.createNewFile();
        	}
            f = new FileWriter(ff);
            f.append(toString());
            f.flush();
            //OutputStreamWriter o = new OutputStreamWriter(new File(getName()+".abs"));
        } catch (IOException ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void setMainBlock(ABSMainBlock m)
    {
        //System.out.println(m.getStatements().size());
        this.main = m;
    }
    
    
    public ABSMainBlock getMainBlock()
    {
        return main;
    }
    
    public HashMap<String,ABSMethodImplementation> getTempM()
    {
        return tempM;
    }
    
    public HashMap<String,BTComponent> getTempMM()
    {
        return tempMM;
    }
    
    public HashMap<String,BTComponent> getTempN()
    {
        return tempN;
    }
    
    public boolean isTracing()
    {
        return trace;
    }
    
    @Override
    public String toString()
    {
        String temp = "module "+name+";\n";
        Iterator<ABSLibrary> i = setOfLib.iterator();
        while(i.hasNext())
        {
            temp+=i.next().toString()+"\n";
        }
        if(listOfFor.size()>0)
        {
            temp+="import * from ABS.FLI;\n";
            for(int ii = 0; ii < listOfFor.size(); ii++)
            {
                temp+=listOfFor.get(ii).toString();
            }
        }
        
        temp+="\n"+
"interface N{\n"+
"Bool runNode();\n"+
"String getPC();\n"+
"List<N> getNodes();\n"+
"Unit addNode(N node);\n"+
"}\n"+
"class Node(Component c, String cmd, String t, String qt, String op, String pc) implements N\n"+
"{\n"+
"	Component comp = c;\n"+
"	String command = cmd;\n"+
"	String tipe = t;\n"+
"	String qtipe = qt;\n"+
"	String operator = op;\n"+
"	String pC= pc;\n"+
"       List<N> nodes= Nil;\n"+
"	List<N> getNodes()\n"+
"	{\n"+
"		return nodes;\n"+
"	}                \n"+
"	Unit addNode(N node)\n"+
"	{\n"+
"		nodes = appendright(nodes,node);\n"+
"	}                \n"+
"	Bool runNode()\n"+
"	{\n"+
"		Bool ret = False;\n"+
"               if(comp == null)\n"+
"		{\n"+
"		\n"+
"		}\n"+
"		else if(qtipe==\"SELECTION\")\n"+
"		{\n"+
"                       comp.runMethod(command);\n"+
"			ret = comp.isTerminate();\n"+
"		}\n"+
"		else if(qtipe==\"STATE\")\n"+
"		{\n"+
"			comp.runMethod(command);	\n"+
"		}\n"+
"		else if(qtipe==\"EXTERNALINPUT\")\n"+
"		{\n"+
"			comp.runMethod(command);	\n"+
"		}\n"+
"		else if(qtipe==\"INTERNALINPUT\")\n"+
"		{\n"+
"			comp.runMethod(command);	\n"+
"		}\n"+
"		else if(qtipe==\"INTERNALOUTPUT\")\n"+
"		{\n"+
"			comp.runMethod(command);	\n"+
"		}\n"+
"		else if(qtipe==\"EXTERNALOUTPUT\")\n"+
"		{\n"+
"			comp.runMethod(command);	\n"+
"		}\n"+                
"		else if(qtipe==\"GUARD\")\n"+
"		{\n"+
"			Fut<Unit> b = comp!runMethod(command);\n"+
"			await b?;\n"+
"		}\n"+
"		return ret;\n"+
"	}\n"+
"	String getPC()\n"+
"	{\n"+
"		return pC;\n"+
"	}\n"+
"}\n"+
"interface T{\n"+
"	Unit execute();\n"+
"	Unit setRoot(N n);\n"+
"}\n"+
"class Tree(N r) implements T\n"+
"{\n"+
"	N rt = r;\n"+
"	Unit execute()\n"+
"	{\n"+
"		this.executes(r);\n"+	
"	}\n"+
"	Unit executes(N r)\n"+
"	{\n"+
"		Bool b = r.runNode();\n"+
"		if(not(b))\n"+
"		{\n"+
"			List<N> nodes = r.getNodes();\n"+
"			Int i = 0;\n"+
"			while(i < length(nodes))\n"+
"			{\n"+
"				N node = nth(nodes,i);\n"+
"				i = i+1;\n"+
"				this!executes(node);\n"+
"			}\n"+
"			\n"+
"		}\n"+
"	}\n"+
"	Unit setRoot(N n)\n"+
"	{\n"+
"		this.rt = n;\n"+
"	}\n"+
"}	                \n"+
"	\n";
        
        Iterator<ABSEnum> k = setOfEnum.iterator();
        while(k.hasNext())
        {
            temp+=k.next().toString()+"\n";
        }
        Iterator<ABSInterface> j = setOfInterface.iterator();
        //System.out.println(setOfInterface.size()+" dog");
        while(j.hasNext())
        {
            temp+=j.next().toString()+"\n";
        }
        temp+="\n\n";
        
        Iterator<ABSClass> l = setOfClasses.iterator();
        while(l.hasNext())
        {
            temp+=l.next().toString()+"\n";
        }
        temp+="\n\n";
        if(this.main != null)
        {
            temp+=main.toString();
        }
        
        return temp;
    }
}
