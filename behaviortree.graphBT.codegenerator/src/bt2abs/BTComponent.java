package bt2abs;
/***
 * Task in this class 
 * - collecting variables (in case of qualifiers, e.g state, input, output, guard, selection)
 * - defining List and Set property
 */


import java.util.*;
public class BTComponent {
    private ArrayList<BTBehavior> behaviorList = new ArrayList<BTBehavior>();
    private Set<ABSVariable> set = new HashSet<ABSVariable> ();
    private Set<ABSMethod> setM = new HashSet<ABSMethod> ();
    private Set<String> intVar = new HashSet<String> ();
    private Set<String> boolVar = new HashSet<String> ();
    private Set<String> undefVar = new HashSet<String> ();
    
    private HashMap<String,String> defStmnts = new HashMap<String,String>();
    private String ref;
    private String name;
    /**component primitive*/
    public static final BTComponent LIST = new BTComponent("CLIST", "List");
    public static final BTComponent SET = new BTComponent("CSET", "Set");
    public static final BTComponent DATA = new BTComponent("CDATA", "Data");
    private ABSInterface ab;
    private ABSClass ac;
    private boolean prim = false;
    
    private int xx = 0;
    /**
     * Default constructor
     * @param ref reference of the component
     * @param name component name
     */
    public BTComponent(String ref, String n)
    {
        this.ref = ref;
        
        StringBuffer strB = new StringBuffer(n);
		strB.setCharAt(0,(n.substring(0, 1).toUpperCase().charAt(0)));
		this.name = strB.toString();
        /* handle primitive component*/
        if(ref.equals("CLIST")&& name.equals("List"))
        {
            String var = "[a-zA-Z]+[a-zA-Z0-9]*";
            prim = true;
            String num = "[0-9]+";
            String varnum = var+"|"+num;
            
            /*handle LIST notation*/
            defStmnts.put("\\{\\}","V1 = Nil");     //empty list
            defStmnts.put("\\{"+varnum+"(\\,"+varnum+"*\\}","split;\\(\\)\\,"); //initialization
            defStmnts.put(varnum+":"+var,"contains("+var+","+num+")");  //check is member or is not a member
            defStmnts.put("|"+var+"|"," = length("+var+")");        //length of list
            defStmnts.put(varnum+"\\+"+varnum,varnum+" = concatenate("+varnum+","+varnum+")");  //concate list
            defStmnts.put(varnum+":="+varnum+"@"+varnum,varnum+" = nth("+varnum+","+varnum+")");    //get nth member
            defStmnts.put("\\{"+varnum+"\\}\\+"+varnum,varnum+" = appendright("+varnum+","+varnum+")"); //append element to list
            defStmnts.put(varnum+":=\\{"+varnum+"..\\}",varnum+" = head("+varnum+")");  //get head element of list
            defStmnts.put("\\{.."+varnum+"\\}",varnum+" = tail("+varnum+")");   //get tail list
            
            //defStmnts.put("SORTED","sort(V1)");
            
        }
        else if(ref.equals("CSET")&&name.equals("Set"))
        {
            prim = true;
            /*handle LIST notation*/
            // added some time
        }
        else if(ref.equals("CDATA")&&name.equals("Data"))
        {
            prim = true;
        }
        /**kalo bukan primitive, maka bisa dijadiin interface dan class*/
        else 
        {
            behaviorList = new ArrayList<BTBehavior> ();
            ab = new ABSInterface(name+"_Int");
            ac = new ABSClass(ab,name+"_Class");
        }
    }

    public String getRef()
    {
        return ref;
    }

    public boolean isPrimitive()
    {
        return prim;
    }
    public String getName()
    {
        return name;
    }

    /**
     * method getBehavior will return reference to Behavior which its name match 
     * with the given name
     * @param r reference yang mau dicari
     * @return reference dari BTBehaviornya
     */
    public BTBehavior getBehavior(String r)
    {
        for(int i = 0; i < behaviorList.size(); i++)
        {
            if(behaviorList.get(i).getRef().equals(r))
            {
                return behaviorList.get(i);
            }
        }
        return null;
    }
    
    public void addBehavior(BTBehavior b)
    {
        behaviorList.add(b);
    }
    
    /**
     * Check whether the component is could be defined as "Data" or not
     * @return True if Data, and False if not
     */
    public boolean isData()
    {
        if(prim)
            return false;
        for(int i = 0; i < behaviorList.size(); i++)
        {
            if(!(behaviorList.get(i) instanceof BTStateRealization && behaviorList.get(i).getRelations().isEmpty()))
            {
                return false;
            }
        }
        return false;
    }
    
    /**
     * method toString
     * @return BT text representation of the component
     */
    @Override
    public String toString()
    {
        String temp = "#C "+ref+" "+name;
        for(int i = 0; i < behaviorList.size(); i++)
        {
            temp = temp+"\n"+behaviorList.get(i).getRef()+" "+behaviorList.get(i).toString();
        }
        return temp;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof BTComponent)
        {
            BTComponent bo = (BTComponent)o;
            return bo.getRef().equals(this.ref);
        }
        return false;
    }
    
    
    /**
     * 
     * @param module
     * @return 
     */
    public Set<ABSVariable> collectABSVariables(ABSModule module)
    {
        if(!isPrimitive()&&!isData()&&!getName().equalsIgnoreCase("List")&&!getName().equalsIgnoreCase("SET"))
        {   
            module.addInterface(ab);
            module.addClass(ac);
            
            //add IO handler to each class as parameter
            ac.addParameter(new ABSParameter(new ABSDataType("IO"), "i","i"));
            
            //get reference of interface "Component"
            ABSInterface hh = module.getInterface("Component");
            //set the component
            ab.setParent(hh);
            //temporary list to contain parameter of the method
            ArrayList<ABSParameter> temp = new ArrayList<ABSParameter>();
            temp.add(new ABSParameter(ABSDataType.STRING,"command"));
            
            ABSMethod runM = new ABSMethod(ABSDataType.UNIT,"runMethod",temp);
            ABSMethod isT = new ABSMethod(ABSDataType.BOOL,"isTerminate",new ArrayList<ABSParameter>());
            ABSMethod run = new ABSMethod(ABSDataType.UNIT,"run",new ArrayList<ABSParameter>());
            //ABSMethod getData = new ABSMethod(new ABSDataType("Data"),"getData",new ArrayList<ABSParameter>());
            ABSMethodImplementation runMI = new ABSMethodImplementation(runM);
            ABSMethodImplementation runI = new ABSMethodImplementation(run);
            ABSMethodImplementation isTI = new ABSMethodImplementation(isT);
            //ABSMethodImplementation getDataI = new ABSMethodImplementation(getData);
            //ab.add(runM);
            //ab.add(isT);
            //ab.add(getData);
            //ab.add(run);
            ac.addMethodImplementation(runMI);
            ac.addMethodImplementation(runI);
            ac.addMethodImplementation(isTI);
            //ac.addMethodImplementation(getDataI);
            //getDataI.addStatement(new ABSStatement(ABSStatementType.RETURN,"return Val(4)"));
            ABSVariable io = new ABSVariable("io");
            io.setDataType(new ABSDataType("IO"));
            io.setValue("i");
            runI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"io=new IOImpl()"));
            isTI.addStatement(new ABSStatement(ABSStatementType.RETURN,"return terminate"));
            ac.addVariable(io);
            _ABSIfGroup ab = new _ABSIfGroup();
            ac.addVariable(new ABSVariable(ABSDataType.BOOL,"terminate"));
            runMI.addStatement(ab);
            for(int i = 0; i < behaviorList.size(); i++)
            {
                BTBehavior b = behaviorList.get(i);       
                //if(b.getType() == BTType.INTERNALINPUT||b.getType() == BTType.INTERNALOUTPUT)
                //    continue;
                ABSMethod absM = new ABSMethod(ABSDataType.UNIT,"method"+b.getRef());
                ABSMethodImplementation absMI = new ABSMethodImplementation(absM);
                _ABSIf aif = new _ABSIf(new _ABSCondition("command==\"method"+b.getRef()+"\""));
                ab.addCondition(aif);
                aif.addStatement(new ABSStatement(ABSStatementType.CALL,"this.method"+b.getRef()+"()"));
                this.ab.add(absM);
                this.ac.addMethodImplementation(absMI);
                boolean isI = false;
                boolean isB = false;
                
                if(module.isTracing())
                {
                    absMI.addStatement(new ABSStatement(ABSStatementType.CALL,"io.print(\"on "+getName()+", "+absM.toString()+" called\")"));
                }
                
                //handle relation
                if(!b.getRelations().isEmpty())
                {
                    for(int ii = 0; ii < b.getRelations().size(); ii++)
                    {
                        BTComponent relComp = module.getBT().getComponent(b.getRelations().get(ii).getComponentRef());
                        
                        if(!isVarExist(relComp.getRef().toLowerCase()+"_var"))
                        {
                            ABSVariable av = new ABSVariable(relComp.asDataType(),relComp.getRef().toLowerCase()+"_var");
                            av.setValue("v"+xx);
                            set.add(av);
                            ac.addVariable(av);
                            ac.addParameter(new ABSParameter(av.getDataType(),"v"+xx,relComp.getRef().toLowerCase()+"_var"));
                            System.out.println(ac.getClassName()+" "+av.getDataType());
                            xx++;
                        }
                        System.out.println();
                        if(relComp.getName().equalsIgnoreCase("List"))
                        {
                            if(b.getName().equalsIgnoreCase("ADD"))
                            {
                                absMI.addStatement(new ABSStatement(ABSStatementType.CALL,"clist_var = appendright(clist_var,cdata_var)"));
                            }
                            else if(b.getName().trim().equalsIgnoreCase("REMOVE"))
                            {
                                absMI.addStatement(new ABSStatement(ABSStatementType.CALL,"cdata_var = head(clist_var)"));
                                absMI.addStatement(new ABSStatement(ABSStatementType.CALL,"clist_var = tail(clist_var)"));
                            }
                        }
                    }
                }
                if(b.getType()==BTType.STATE)
                {
                    String n = b.getName();
                    if(n.contains("random()"))
                    {
                        String []p = n.split(":=");
                        absMI.addStatement(new ABSStatement(ABSStatementType.DECLARATION,"Math_ m = new Math()"));
                        absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,p[0].toLowerCase()+"_var = m.random()"));
                    }
                    else if(n.indexOf(":=") > 0)
                    {
                        String vars[] = n.split(":=|[\\+\\-]");
                        for(int ii = 0; ii < vars.length; ii++)
                        {
                            if(vars[ii].matches("[0-9]+"))
                            {
                                isI = true;
                                break;
                            }
                            if(intVar.contains(vars[ii]))
                            {
                                isI = true;
                                break;
                            }
                            else if(intVar.contains(vars[ii]))
                            {
                                isB = true;
                                break;
                            }
                        }
                        for(int ii = 0; isI&&ii < vars.length; ii++)
                        {
                            if(!vars[ii].matches("[0-9]+")&&!intVar.contains(vars[ii]))
                            {
                                intVar.add(vars[ii]);
                            }
                        }
                        for(int ii = 0; isB&&ii < vars.length; ii++)
                        {
                            if(!boolVar.contains(vars[ii]))
                            {
                                boolVar.add(vars[ii]);
                            }
                        }
                        String stat = n.replaceAll(":=", "=");
                        for(int ii = 0; ii < vars.length; ii++)
                        {
                            if(!vars[ii].matches("[0-9]+|False|True"))
                            {
                                stat = stat.replaceAll(vars[ii], vars[ii].toLowerCase()+"_var");
                            }
                        }
                        ABSStatement t = new ABSStatement(ABSStatementType.ASSIGNMENT,stat);
                        absMI.addStatement(t);
                    }
                    else if(n.indexOf("[")>0)
                    {
                        String []m = n.split("[\\[\\]]");
                        if(!module.containEnum(m[0]))
                        {
                            module.addEnum(new ABSEnum(m[0]));
                        }
                        module.getEnum(m[0]).addValue(m[1]);
                        if(!this.isVarExist(m[0]))
                        {
                            ABSVariable av = new ABSVariable(module.getEnum(m[0]),m[0].toLowerCase()+"_var");
                            set.add(av);
                            ac.addVariable(av);
                        }
                        absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,m[0].toLowerCase()+"_var = "+m[1]));
                    }
                    //case n not assignment, n won't be considered as Integer, 
                    else
                    {
                        //case n starts with "not"
                        if(n.toLowerCase().startsWith("not"))
                        {
                            String aa[] = n.split("[\\(\\)]");
                            if(!this.boolVar.contains(aa[1].trim()))
                            {
                                boolVar.add(aa[1].trim());
                            }
                            String stat = aa[1].trim().toLowerCase()+"_var = False";
                            absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,stat));
                        }
                        else
                        {
                            if(undefVar.contains(n))
                            {
                                undefVar.remove(n);
                                boolVar.add(n);
                            }
                            if(!boolVar.contains(n))
                            {
                                boolVar.add(n);
                            }
                            String stat = n.toLowerCase()+"_var = True";
                            absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,stat));
                        }
                    }
                }
                else if(b.getType() == BTType.SELECTION)
                {
                    //ABSVariable abs = new ABSVariable();
                    String n = b.getName().toLowerCase();
                    
                    if(n.startsWith("not"))
                    {
                        String aa[] = n.split("[\\(\\)]");
                        if(!this.boolVar.contains(aa[1].trim()))
                        {
                            String stat="";
                            //jika dia terdapat equality
                            if(aa[1].indexOf("=")>0)
                            {
                                String tmp = n;
                                String cond[] = aa[1].split("[=\\+\\-]");
                                
                                String gr = aa[1];
                                gr = gr.replaceAll("=", "==");
                                for(int ii = 0; ii < cond.length&&!cond[ii].matches("[0-9]"); ii++)
                                {
                                    String g = cond[ii]+"_var";
                                    if(!this.isVarExist(g))
                                    {
                                        ABSVariable te = new ABSVariable(ABSDataType.INT,g);
                                        set.add(te);
                                        if(!ac.getVariables().contains(te));
                                        ac.addVariable(te);
                                        if(intVar.contains(cond[ii]))
                                        {
                                            intVar.remove(cond[ii]);
                                        }
                                    }
                                    gr = gr.replaceAll(cond[ii], cond[ii]+"_var");
                                }
                                gr = tmp.replaceAll(aa[1], gr);
                                stat = gr;
                            }
                            else //jika dia boolean biasa saja
                            {
                                stat = aa[1]+"_var";
                                if(!this.isVarExist(stat))
                                {
                                    //boolVar.add(aa[1]);
                                    set.add(new ABSVariable(ABSDataType.BOOL,stat));
                                }
                            }
                            _ABSIfGroup aw = new _ABSIfGroup();
                            _ABSIf af = new _ABSIf(new _ABSCondition("not("+stat+")"));
                            aw.addCondition(af);
                            absMI.addStatement(aw);
                            af.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"terminate=True"));
                        }
                    }
                    else
                    {
                        String aa = n;
                        if(!this.boolVar.contains(aa.trim()))
                        {
                        	this.boolVar.add(aa.trim());
                            String stat="";
                            //jika dia terdapat equality
                            if(aa.indexOf("=")>0)
                            {
                                String tmp = n;
                                String cond[] = aa.split("[=\\+\\-]");
                                
                                String gr = aa;
                                gr = gr.replaceAll("=", "==");
                                for(int ii = 0; ii < cond.length&&!cond[ii].matches("[0-9]"); ii++)
                                {
                                    String g = cond[ii]+"_var";
                                    if(!this.isVarExist(g))
                                    {
                                        ABSVariable te = new ABSVariable(ABSDataType.INT,g);
                                        set.add(te);
                                        if(ac.getVariables().contains(te));
                                        ac.addVariable(te);
                                        
                                        if(intVar.contains(cond[ii]))
                                        {
                                            intVar.remove(cond[ii]);
                                        }
                                    }
                                    gr = gr.replaceAll(cond[ii], cond[ii]+"_var");
                                }
                                gr = tmp.replaceAll(aa, gr);
                                stat = gr;
                            }
                            else //jika dia boolean biasa saja
                            {
                                stat = aa+"_var";
                                if(!this.isVarExist(stat))
                                {
                                    //boolVar.add(aa[1]);
                                    set.add(new ABSVariable(ABSDataType.BOOL,stat));
                                }
                            }
                            _ABSIfGroup aw = new _ABSIfGroup();
                            _ABSIf af = new _ABSIf(new _ABSCondition("not("+stat+")"));
                            aw.addCondition(af);
                            absMI.addStatement(aw);
                            af.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"terminate=True"));
                        }
                    }
                }
                else if(b.getType() == BTType.GUARD)
                {
                    String n = b.getName().toLowerCase();
                    
                    if(n.startsWith("not"))
                    {
                        String aa[] = n.split("[\\(\\)]");
                        if(!this.boolVar.contains(aa[1].trim()))
                        {
                            String stat="";
                            //jika dia terdapat equality
                            if(aa[1].indexOf("=")>0)
                            {
                                String tmp = n;
                                String cond[] = aa[1].split("[=\\+\\-]");
                                
                                String gr = aa[1];
                                gr = gr.replaceAll("=", "==");
                                for(int ii = 0; ii < cond.length&&!cond[ii].matches("[0-9]"); ii++)
                                {
                                    String g = cond[ii]+"_var";
                                    if(!this.isVarExist(g))
                                    {
                                        ABSVariable te = new ABSVariable(ABSDataType.INT,g);
                                        set.add(te);
                                        if(ac.getVariables().contains(te));
                                        ac.addVariable(te);
                                        
                                        if(intVar.contains(cond[ii]))
                                        {
                                            intVar.remove(cond[ii]);
                                        }
                                    }
                                    gr = gr.replaceAll(cond[ii], cond[ii]+"_var");
                                }
                                gr = tmp.replaceAll(aa[1], gr);
                                stat = "not("+gr+")";
                            }
                            else //jika dia boolean biasa saja
                            {
                                stat = aa[1]+"_var";
                                if(!this.isVarExist(stat))
                                {
                                    //boolVar.add(aa[1]);
                                    set.add(new ABSVariable(ABSDataType.BOOL,stat));
                                }
                            }
                            _ABSWhile aw = new _ABSWhile(new _ABSCondition(""+stat+""));
                            absMI.addStatement(aw);
                            aw.addStatement(new ABSStatement(ABSStatementType.ADDON,"suspend"));
                        }
                    }
                    else {
                        String aa = n;
                        if(!this.boolVar.contains(aa.trim()))
                        {
                            String stat="";
                            this.boolVar.add(aa.trim());
                            //jika dia terdapat equality
                            if(aa.indexOf("=")>0)
                            {
                                String tmp = n;
                                String cond[] = aa.split("[=\\+\\-]");
                                
                                String gr = aa;
                                gr = gr.replaceAll("=", "==");
                                for(int ii = 0; ii < cond.length&&!cond[ii].matches("[0-9]"); ii++)
                                {
                                    String g = cond[ii]+"_var";
                                    if(!this.isVarExist(g))
                                    {
                                        ABSVariable te = new ABSVariable(ABSDataType.INT,g);
                                        set.add(te);
                                        if(ac.getVariables().contains(te));
                                        ac.addVariable(te);
                                
                                        if(intVar.contains(cond[ii]))
                                        {
                                            intVar.remove(cond[ii]);
                                        }
                                    }
                                    gr = gr.replaceAll(cond[ii], cond[ii]+"_var");
                                }
                                gr = tmp.replaceAll(aa, gr);
                                stat = gr;
                            }
                            else //jika dia boolean biasa saja
                            {
                                stat = aa+"_var";
                                if(!this.isVarExist(stat))
                                {
                                    //boolVar.add(aa[1]);
                                    set.add(new ABSVariable(ABSDataType.BOOL,stat));
                                }
                            }
                            _ABSWhile aw = new _ABSWhile(new _ABSCondition("not("+stat+")"));
                            absMI.addStatement(aw);
                            aw.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"terminate=True"));
                        }
                    }
                }
                else if(b.getType() == BTType.INTERNALINPUT)
                {
                    String m[] = b.getName().toLowerCase().split("[\\(\\)]");
                    String n;
                    if(m.length<2)
                    {
                        n = m[0];
                    }
                    else
                    {
                        n = m[1]+"_var";
                    }
                    
                    if(!this.isVarExist(n))
                    {
                        ABSVariable v = new ABSVariable(ABSDataType.INT,n);
                        ac.addVariable(v);
                        set.add(v);
                    }
                    ABSVariable var = getVar(n);
                    ABSMethod tM = new ABSMethod(ABSDataType.UNIT, "set_"+n);
                    ABSMethodImplementation tMI = new ABSMethodImplementation(tM);
                    tM.addParam(new ABSParameter(var.getDataType(),var.getName().toLowerCase().charAt(0)+""));
                    
                    this.ab.add(tM);
                    this.ac.addMethodImplementation(tMI);
                    tMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,n+" = "+var.getName().toLowerCase().charAt(0)));
                    if(module.getTempMM().containsKey(b.getName().toLowerCase()))
                    {
                        ABSMethodImplementation ami = module.getTempM().get(b.getName().toLowerCase());
                        String o = module.getTempMM().get(b.getName().toLowerCase()).getRef().toLowerCase()+"_var";
                        BTComponent acc = module.getTempMM().get(b.getName().toLowerCase());
                        if(isVarExist(acc.getRef().toLowerCase()+"_var"))
                        {
                            absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"Int i = "+acc.getRef().toLowerCase()+"_var"+".get_"+n+"()"));
                            absMI.addStatement(new ABSStatement(ABSStatementType.CALL,"this.set_"+n+"(i)"));
                        }
                        else
                        if(!acc.isVarExist(getRef().toLowerCase()+"_var"))
                        {
                            ABSVariable av = new ABSVariable(asDataType(),getRef().toLowerCase()+"_var");
                            av.setValue("v"+acc.xx);
                            acc.set.add(av);
                            acc.ac.addVariable(av);
                            acc.ac.addParameter(new ABSParameter(av.getDataType(),"v"+acc.xx,getRef().toLowerCase()+"_var"));
                            System.out.println("ii "+acc.ac.getClassName()+" "+av.getDataType());
                            acc.xx++;
                            ami.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"Int i = this.get_"+n+"()"));
                            ami.addStatement(new ABSStatement(ABSStatementType.CALL,getRef().toLowerCase()+"_var.set_"+n+"(i)"));
                        }
                    }
                    else
                    {
                        module.getTempN().put(b.getName().toLowerCase(), this);
                    }
                    
                    ABSVariable v = getVar(n);
                }
                else if(b.getType() == BTType.INTERNALOUTPUT)
                {
                    //absMI.addStatement(ab);
                    String n = b.getName().toLowerCase();
                    String m[] = n.split("[\\(\\)]");
                    String mn;
                    if(m.length < 2)
                    {
                        mn = m[0];
                    }
                    else
                    {
                        mn = m[1];
                    }
                    if(module.getTempN().containsKey(n))
                    {
                        String o = module.getTempN().get(n).getRef().toLowerCase()+"_var";
                        if(!isVarExist(o))
                        {
                            ABSVariable av = new ABSVariable(module.getTempN().get(n).asDataType(),module.getTempN().get(n).getRef().toLowerCase()+"_var");
                            av.setValue("v"+xx);
                            set.add(av);
                            
                            ac.addVariable(av);
                            ac.addParameter(new ABSParameter(av.getDataType(),"v"+xx,module.getTempN().get(n).getRef().toLowerCase()+"_var"));
                            System.out.println("io"+ac.getClassName()+" "+av.getDataType());
                            xx++;
                            absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"Int i = this.get_"+mn+"_var()"));
                            absMI.addStatement(new ABSStatement(ABSStatementType.CALL,module.getTempN().get(n).getRef().toLowerCase()+"_var.set_"+mn+"_var(i)"));      
                        }
                        else
                        {
                            absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,"Int i = this.get_"+mn+"_var()"));
                            absMI.addStatement(new ABSStatement(ABSStatementType.CALL,o+".set_"+mn+"_var(i)"));                      
                        }
                    }
                    else
                    {   
                        module.getTempM().put(n, absMI);
                        module.getTempMM().put(n, this);
                    }
                }
                else if(b.getType() == BTType.EXTERNALINPUT)
                {
                    String n = b.getName().toLowerCase()+"_var";                    
                    if(!this.isVarExist(n))
                    {
                        ABSVariable v = new ABSVariable(ABSDataType.INT,n);
                        ac.addVariable(v);
                        set.add(v);
                    }
                    
                    ABSVariable v = getVar(n);
                    if(v.getDataType().equals(ABSDataType.STRING))
                    {
                        absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,v.getName()+"=io.readString()"));
                    }
                    else// if(v.getDataType().equals(ABSDataType.INT))
                    {
                        absMI.addStatement(new ABSStatement(ABSStatementType.ASSIGNMENT,v.getName()+"=io.readInt()"));
                    }
                }
                else if(b.getType() == BTType.EXTERNALOUTPUT)
                {
                    String m[] = b.getName().toLowerCase().split("\\+");
                    String print = "";
                    if(!m[0].startsWith("string"))
                    {
                        String n = m[0]+"_var";
                        if(!this.isVarExist(n))
                        {
                            ABSVariable v = new ABSVariable(ABSDataType.INT,n);
                            ac.addVariable(v);
                            set.add(v);
                        }
                        String op = "String "+m[0]+"_tmp = intToString("+n+")";
                        absMI.addStatement(new ABSStatement(ABSStatementType.CALL,op));
                        print = m[0]+"_tmp";
                    }
                    else
                    {
                        String str = m[0].replace("string", "");
                        str = str.replace("_", " ").trim();
                        print+="\""+str+"\"";
                    }
                    
                    for(int ii = 1; ii < m.length; ii++)
                    {
                        if(!m[ii].startsWith("string"))
                        {
                            
                            String n = m[ii]+"_var";
                            if(!this.isVarExist(n))
                            {
                                ABSVariable v = new ABSVariable(ABSDataType.INT,n);
                                ac.addVariable(v);
                                set.add(v);
                            }
                            String op = "String "+m[ii]+"_tmp"+ii+" = intToString("+n+")";
                            absMI.addStatement(new ABSStatement(ABSStatementType.CALL,op));
                            print += "+"+m[ii]+"_tmp"+ii;
                        }
                        else
                        {
                            String str = m[ii].replace("string", "");
                            str = str.replace("_", " ").trim();
                            print+="\""+str+"\"";
                        }
                    }
                    absMI.addStatement(new ABSStatement(ABSStatementType.CALL,"io.print("+print+")"));
                }
            }
            Iterator<String> ii = intVar.iterator();
            while(ii.hasNext())
            {
                ABSVariable at = new ABSVariable(ii.next().toLowerCase()+"_var");
                at.setDataType(ABSDataType.INT);
                set.add(at);
                ac.addVariable(at);
            }
            ii = boolVar.iterator();
            while(ii.hasNext())
            {
                ABSVariable at = new ABSVariable(ii.next().toLowerCase()+"_var");
                at.setDataType(ABSDataType.BOOL);
                set.add(at);
                ac.addVariable(at);
            }
            Iterator<ABSVariable> i = ac.getVariables().iterator();
            while(i.hasNext())
            {
                ABSVariable av = i.next();
                ABSMethod amv = new ABSMethod(av.getDataType(),"get_"+av.getName());
                ABSMethodImplementation amiv = new ABSMethodImplementation(amv);
                amiv.addStatement(new ABSStatement(ABSStatementType.RETURN, "return "+av.getName()));
                this.ab.add(amv);
                this.ac.addMethodImplementation(amiv);
            }
            return set;
        }
        else
        {
            ABSEnum a = new ABSEnum(getName()+"_Data");
            module.addEnum(a);
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.ref != null ? this.ref.hashCode() : 0);
        return hash;
    }
    
    private boolean isVarExist(String name)
    {
        Iterator<ABSVariable> i = set.iterator();
        
        while(i.hasNext())
        {
            ABSVariable a = i.next();
            if(a.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }
    
    private ABSVariable getVar(String name)
    {
        Iterator<ABSVariable> i = set.iterator();
        while(i.hasNext())
        {
            ABSVariable a = i.next();
            if(a.getName().equals(name))
            {
                return a;
            }
        }
        return null;
    }
    
    public ABSInterface getComponentInterface()
    {
        return ab;
    }
    
    public ABSDataType asDataType()
    {
        if(getName().equalsIgnoreCase("SET"))
        {
            return ABSDataType.SET;
        }
        if(getName().equalsIgnoreCase("LIST"))
        {
            return ABSDataType.LIST;
        }
        if(getName().equalsIgnoreCase("DATA"))
        {
            return ABSDataType.DATA;
        }
        return new ABSDataType(getName()+"_Int","null");
    }
    
    public ABSClass getComponentClass()
    {
        return ac;
    }
}
