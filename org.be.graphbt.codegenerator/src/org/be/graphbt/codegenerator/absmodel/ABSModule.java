/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.be.graphbt.codegenerator.absmodel;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.be.graphbt.common.ProjectUtil;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

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
    private String absPath = "abssrc";
    private String javaPath = "src";
    private String name;
    private BTTree bt = null;
    
    private HashMap<String,ABSMethodImplementation> tempM = new HashMap<String,ABSMethodImplementation>();
    private HashMap<String,BTComponent> tempN = new HashMap<String,BTComponent>();
    private HashMap<String,BTComponent> tempMM = new HashMap<String,BTComponent>();
    private boolean trace = false;
    
    ABSModule(String n) {
        this(n,false,"");
    }
    ABSModule(String n,boolean t) {
        this(n,t,"");
    }
    
    ABSModule(String n, boolean t, String path) {
        name = n;
        absPath = path+(path.endsWith("\\")?"":"\\")+absPath;
        this.trace = t;
        javaPath = path+(path.endsWith("\\")?"":"\\")+javaPath;
    }
    
    public void addInterface(ABSInterface i) {
        this.setOfInterface.add(i);
    }
    
    public void setBTTree(BTTree b) {
        bt = b;
    }
    
    public BTTree getBT() {
        return bt;
    }
    
    public boolean addClass(ABSClass i) {
        this.setOfClasses.add(i);
        return true;   
    }
    
    public boolean addEnum(ABSEnum i) {
        if(!setOfEnum.contains(i)) {
            this.setOfEnum.add(i);
            return true;
        }
        return false;
    }
    
    public void addLibrary(ABSLibrary abs) {
        setOfLib.add(abs);
    }
    
    public void check() {
        try {
        	String absbatPath = ProjectUtil.getSharedResource("files/lib/abs.bat").getPath();
            String absFilePath = absPath+"/"+getName()+".abs";
            
           
            Process p = Runtime.getRuntime().exec (absbatPath+" check "+absFilePath);
            p.waitFor();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String temp;
            while((temp=in.readLine())!=null) {
                System.out.println(temp);
            }        
        } catch (Exception ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void execute() {
        try {
            Process p = Runtime.getRuntime().exec ("abs.bat execute "+javaPath+" "+getName());
            p.waitFor();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String temp;
            while((temp=in.readLine())!=null) {
                System.out.println(temp);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void generate() {
        try {
            File file = new File(javaPath);
            if(!file.exists() || !file.isDirectory()) {
                file.mkdirs();
                System.out.println("hai "+file.isDirectory());
            }
            System.out.println("hais "+file.isDirectory()+" "+javaPath);
            String absbatPath = ProjectUtil.getSharedResource("files/lib/absfrontend.jar").getPath();
            String absFilePath = absPath+"/"+getName()+".abs";
            
            //Process p = Runtime.getRuntime().exec (absbatPath+" code "+absFilePath+" "+javaPath);
            File files[] = (new File(absFilePath)).getParentFile().listFiles();
            StringBuffer absfiles = new StringBuffer();
            for(int i = 0; i < files.length; i++) {
            	if(files[i].getName().endsWith(".abs")) {
            		absfiles.append(files[i].getAbsolutePath());
            		absfiles.append(' ');
            	}
            }
        	Process p = Runtime.getRuntime().exec ("java -Xms64m -Xmx256m -cp "+absbatPath+" abs.backend.java.JavaBackend -d "+javaPath+" "+absfiles/**+absFilePath*/);
            p.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String temp;
            while((temp=in.readLine())!=null) {
                System.out.println(temp);
            }
            
            BufferedReader f = null;
            BufferedWriter g = null;
           
           
            for(int ii = 0; ii < listOfFor.size(); ii++) {
                try {
                    String javaCode = listOfFor.get(ii).getJavaCode();
                    f = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(javaCode.getBytes())));
                    String module = listOfFor.get(ii).getModule() == null? getName():listOfFor.get(ii).getModule();
                    File ff = new File(javaPath+"\\"+module+"\\"+listOfFor.get(ii).getName()+"Impl_fli.java");
                    File gg = new File(javaPath+"\\"+module);
                    if(!gg.isDirectory()) {
                    	gg.mkdir();
                    }
                    Logger.getAnonymousLogger().log(Level.INFO, "File "+ff.getName()+" is created");
                    System.out.println(ff);
                    ff.createNewFile();
                    
                    g = new BufferedWriter(new FileWriter(ff));
                    String w = "";
                    while((temp=f.readLine())!=null) {
                        String xx[] = temp.split("\\[P\\]");
                        if(xx.length>1) {
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
                    /*String compilingCommand = "javac -cp "+javaPath+";"+absbatPath+" "+javaPath+"\\"+getName()+"\\"+listOfFor.get(ii).getName()+"_fli.java";
                    p = Runtime.getRuntime().exec (compilingCommand);
                    p.waitFor();
                    in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                    System.out.println(compilingCommand);
                    while((temp=in.readLine())!=null) {
                        System.out.println(temp);
                    }*/
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
    
    public void addForeign(ABSForeign n) {
        listOfFor.add(n);
    }
    
    public ABSInterface getInterface(String name) {
        Iterator<ABSInterface>  i = setOfInterface.iterator();
        while(i.hasNext()) {
            ABSInterface ai = i.next();
            if(name.equals(ai.getName())) {
                return ai;
            }
        }
        return null;
    }
    
    public ABSEnum getEnum(String name) {
        
        Iterator<ABSEnum>  i = setOfEnum.iterator();
        while(i.hasNext()) {
            ABSEnum ai = i.next();
            //System.out.println(ai.getName()+"jshdf");
            if(name.equals(ai.getName())) {
                
                return ai;
            }
        }
        return null;
    }
    
    public boolean containEnum(String name) {
        Iterator<ABSEnum>  i = setOfEnum.iterator();
        while(i.hasNext()) {
            ABSEnum ai = i.next();
            if(name.equals(ai.getName())) {
                return true;
            }
        }
        return false;
    }
    
    
    public ABSClass getClass(String name) {
        Iterator<ABSClass>  i = setOfClasses.iterator();
        while(i.hasNext()) {
            ABSClass ac = i.next();
            if(name.equals(ac.getClassName())) {
                return ac;
            }
        }
        return null;
    }
    
    
    public String getName() {
        return name;
    }
            
    
    public void writeToFile() {
        FileWriter f = null;
        try {
        	File fabs = new File(absPath);
        	if(!fabs.exists()) {
        		fabs.mkdirs();
        	}
        	File ff =new File(absPath+"\\"+getName()+".abs");
        	File tempSource = ProjectUtil.getSharedResource("/files/abs/Array.abs");
        	File tempTarget = new File(absPath+"/Array.abs");
        	ProjectUtil.copy(tempSource, tempTarget);
        	tempSource = ProjectUtil.getSharedResource("/files/abs/BTObject.abs");
        	tempTarget = new File(absPath+"/BTObject.abs");
        	ProjectUtil.copy(tempSource, tempTarget);
        	tempSource = ProjectUtil.getSharedResource("/files/abs/Queue.abs");
        	tempTarget = new File(absPath+"/Queue.abs");
        	ProjectUtil.copy(tempSource, tempTarget);
        	tempSource = ProjectUtil.getSharedResource("/files/abs/Exception.abs");
        	tempTarget = new File(absPath+"/Exception.abs");
        	ProjectUtil.copy(tempSource, tempTarget);
        	
        	System.out.println("file absnya ini "+ ff.getAbsolutePath());
        	if(!ff.exists()) {
        		ff.createNewFile();
        	}
            f = new FileWriter(ff);
            f.append(toString());
            f.flush();
                f.close();
            //OutputStreamWriter o = new OutputStreamWriter(new File(getName()+".abs"));
        } catch (IOException ex) {
            Logger.getLogger(ABSModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setMainBlock(ABSMainBlock m) {
        //System.out.println(m.getStatements().size());
        this.main = m;
    }
    
    
    public ABSMainBlock getMainBlock() {
        return main;
    }
    
    public HashMap<String,ABSMethodImplementation> getMethods() {
        return tempM;
    }
    
    public HashMap<String,BTComponent> getTempMM() {
        return tempMM;
    }
    
    public HashMap<String,BTComponent> getTempN() {
        return tempN;
    }
    
    public boolean isTracing() {
        return trace;
    }
    
    @Override
    public String toString() {
        String temp = "module "+name+";\n";
        Iterator<ABSLibrary> i = setOfLib.iterator();
        while(i.hasNext()) {
            temp+=i.next().toString()+"\n";
        }
        temp+="import * from BTObjects;";
        if(listOfFor.size()>0) {
            temp+="import * from ABS.FLI;\n";
            for(int ii = 0; ii < listOfFor.size(); ii++) {
                temp+=listOfFor.get(ii).toString();
            }
        }
        Iterator<ABSEnum> k = setOfEnum.iterator();
        while(k.hasNext()) {
            temp+=k.next().toString()+"\n";
        }
        Iterator<ABSInterface> j = setOfInterface.iterator();
        //System.out.println(setOfInterface.size()+" dog");
        while(j.hasNext()) {
            temp+=j.next().toString()+"\n";
        }
        temp+="\n\n";
        
        Iterator<ABSClass> l = setOfClasses.iterator();
        while(l.hasNext()) {
            temp+=l.next().toString()+"\n";
        }
        temp+="\n\n";
        if(this.main != null) {
            temp+=main.toString();
        }
        
        return temp;
    }
}
