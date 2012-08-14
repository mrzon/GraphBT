package bt.model;

/***
 * Task in this class 
 * - collecting variables (in case of qualifiers, e.g state, input, output, guard, selection)
 * - defining List and Set property
 */

import java.util.*;

/**
 * <code>BTComponent</code> defines the component of Node. It has information
 * about :
 * <ol>
 * <li>Reference Name</li>
 * <li>Component Name</li>
 * <li>Its Behavior List</li>
 * <li>Set of its integer variable</li>
 * <li>Set of its boolean variable</li>
 * <li>Set of its undefined variable</li>
 * <li>HashMap of definition of its statement</li>
 * <li>flag <code>isPrimitive</code></li>
 * <li>Its Component Number</li>
 * </ol>
 * 
 * @emerson
 */
public class BTComponent {
	private ArrayList<BTBehavior> behaviorList = new ArrayList<BTBehavior>();

	private Set<String> intVar = new HashSet<String>();
	private Set<String> boolVar = new HashSet<String>();
	private Set<String> undefVar = new HashSet<String>();

//	private HashMap<String, String> defStmnts = new HashMap<String, String>();
	private String ref;
	private String name;

	/** component primitive */
	public static final BTComponent LIST = new BTComponent("CLIST", "LIST");
	public static final BTComponent SET = new BTComponent("CSET", "SET");
	public static final BTComponent DATA = new BTComponent("CDATA", "DATA");

	private boolean isPrimitive = false;

//	private int componentNumber = 0;

	/**
	 * Default constructor
	 * 
	 * @param ref
	 *            reference of the component
	 * @param name
	 *            component name
	 */
	public BTComponent(String ref, String name) {
		this.ref = ref;
		this.name = name;
		/* handle primitive component */
		if (ref.equals("CLIST") && name.equals("LIST")) {
			String var = "[a-zA-Z]+[a-zA-Z0-9]*";
			isPrimitive = true;
			String num = "[0-9]+";
			String varnum = var + "|" + num;

			/* handle LIST notation */
//			defStmnts.put("\\{\\}", "V1 = Nil"); // empty list
//			defStmnts.put("\\{" + varnum + "(\\," + varnum + "*\\}",
//					"split;\\(\\)\\,"); // initialization
//			defStmnts.put(varnum + ":" + var, "contains(" + var + "," + num
//					+ ")"); // check is member or is not a member
//			defStmnts.put("|" + var + "|", " = length(" + var + ")"); // length
//																		// of
//																		// list
//			defStmnts.put(varnum + "\\+" + varnum, varnum + " = concatenate("
//					+ varnum + "," + varnum + ")"); // concate list
//			defStmnts.put(varnum + ":=" + varnum + "@" + varnum, varnum
//					+ " = nth(" + varnum + "," + varnum + ")"); // get nth
//																// member
//			defStmnts.put("\\{" + varnum + "\\}\\+" + varnum, varnum
//					+ " = appendright(" + varnum + "," + varnum + ")"); // append
//																		// element
//																		// to
//																		// list
//			defStmnts.put(varnum + ":=\\{" + varnum + "..\\}", varnum
//					+ " = head(" + varnum + ")"); // get head element of list
//			defStmnts.put("\\{.." + varnum + "\\}", varnum + " = tail("
//					+ varnum + ")"); // get tail list

			// defStmnts.put("SORTED","sort(V1)");

		} else if (ref.equals("CSET") && name.equals("SET")) {
			isPrimitive = true;
			/* handle LIST notation */
			// added some time
		} else if (ref.equals("CDATA") && name.equals("DATA")) {
			isPrimitive = true;
		}
		/** kalo bukan primitive, maka bisa dijadiin interface dan class */
		else {
			behaviorList = new ArrayList<BTBehavior>();
		}
	}

	public String getRef() {
		return ref;
	}

	public boolean isPrimitive() {
		return isPrimitive;
	}

	public String getName() {
		return name;
	}

	/**
	 * method getBehavior will return reference to Behavior which its name match
	 * with the given name
	 * 
	 * @param referenceNumber
	 *            reference yang mau dicari
	 * @return reference dari BTBehaviornya
	 */
	public BTBehavior getBehavior(String referenceNumber) {
		for (int i = 0; i < behaviorList.size(); i++) {
			if (behaviorList.get(i).getReferenceNumber()
					.equals(referenceNumber)) {
				return behaviorList.get(i);
			}
		}
		return null;
	}

	public void addBehavior(BTBehavior b) {
		behaviorList.add(b);
	}

	/**
	 * Check whether the component is could be defined as "Data" or not
	 * 
	 * @return True if Data, and False if not
	 */
	public boolean isData() {
		if (isPrimitive)
			return false;
		for (int i = 0; i < behaviorList.size(); i++) {
			if (!(behaviorList.get(i) instanceof BTBehaviorStateRealisation && behaviorList
					.get(i).getRelations().isEmpty())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * method toString
	 * 
	 * @return BT text representation of the component
	 */
	@Override
	public String toString() {
		String temp = "#C " + ref + " " + name;
		for (int i = 0; i < behaviorList.size(); i++) {
			temp = temp + "\n" + behaviorList.get(i).getReferenceNumber() + " "
					+ behaviorList.get(i).toString();
		}
		return temp;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BTComponent) {
			BTComponent bo = (BTComponent) o;
			return bo.getRef().equals(this.ref);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + (this.ref != null ? this.ref.hashCode() : 0);
		return hash;
	}

	public void collectVariables() {
		System.out.println("BT COMPONENT NAME : "+getName() +" -------------------------");
		System.out.println("UndefVar awal :"+Arrays.toString(undefVar.toArray()));
//		if (!isPrimitive() && !isData() && !getName().equalsIgnoreCase("List")
//				&& !getName().equalsIgnoreCase("SET")) {
		if(!getName().equalsIgnoreCase("LIST") && !getName().equalsIgnoreCase("SET")
				&& !getName().equalsIgnoreCase("DATA")){
			for (int i = 0; i < behaviorList.size(); i++) {
				BTBehavior behavior = behaviorList.get(i);
				
				// handle relation
				if (!behavior.getRelations().isEmpty()) {
					
				}
				if (behavior.getType() == BTBehaviorType.STATE) {
					boolean isI = false;
					boolean isB = false;
					String behaviorName = behavior.getName().toLowerCase();
					System.out.println("Behavior Name: STATE "+behaviorName+" --------------");
					
					if (behaviorName.contains("random()")) {
						System.out.println("Not supported random()");
					} else if (behaviorName.contains(":=")) {
						
						String vars[] = behaviorName.split(":=|[\\+\\-\\*\\/\\%]");
						System.out.println(Arrays.toString(vars));
						
						for (int ii = 0; ii < vars.length; ii++) {
							if (vars[ii].matches("[0-9]+")) {
								isI = true;
								break;
							}
							if (intVar.contains(vars[ii])) {
								isI = true;
								break;
							} else if (boolVar.contains(vars[ii])) {
								isB = true;
								break;
							}
						}
						//Integer type
						if(isI){
							System.out.println("Integer type");
							for (int ii = 0; ii < vars.length; ii++) {
								if (!vars[ii].matches("[0-9]+")) {
									intVar.add(vars[ii]);
									undefVar.remove(vars[ii]);
								}
							}
						}
						else if(isB){
							System.out.println("Boolean type");
							for (int ii = 0; ii < vars.length; ii++) {
								boolVar.add(vars[ii]);
								undefVar.remove(vars[ii]);
							}
						}else{
							System.out.println("Undef type");
							for(int ii = 0; ii < vars.length; ii++){
								undefVar.add(vars[ii]);
							}
						}
					} else if (behaviorName.indexOf("[") > 0) {
						System.out.println("Not supported");
					}
					// case n not assignment, n won't be considered as Integer and treat it as boolean value
					else {
						// case n starts with "not", then parse the '(' and ')'
						if (behaviorName.startsWith("not")) {
							String aa[] = behaviorName.split("[\\(\\)]");
							System.out.println(Arrays.toString(aa));
							boolVar.add(aa[1].trim());
							undefVar.remove(aa[1].trim());
						} 
						else{
							boolVar.add(behaviorName);
							undefVar.remove(behaviorName);
						}
						System.out.println("boolean type");
					}
				} else if (behavior.getType() == BTBehaviorType.SELECTION || behavior.getType() ==  BTBehaviorType.GUARD) {
					String behaviorName = behavior.getName().toLowerCase();
					System.out.println("Behavior Name: SELECTION "+behaviorName+" --------------");
					
					if (behaviorName.startsWith("not")) {
						String aa[] = behaviorName.split("[\\(\\)]");
						System.out.println(Arrays.toString(aa));
						
						if (!this.boolVar.contains(aa[1].trim())) {
							// jika dia terdapat equality, maka cek party sebelah kanan dan kiri
							if (aa[1].indexOf("=") > 0) {
								boolean isInteger = false;
								boolean isBoolean = false; 
								String cond[] = aa[1].split("[=\\+\\-]");
								for (int ii = 0; ii < cond.length; ii++) {
									if (cond[ii].matches("[0-9]+")) {
										isInteger = true;
										break;
									}
									if (intVar.contains(cond[ii])) {
										isInteger = true;
										break;
									} else if (boolVar.contains(cond[ii])) {
										isBoolean = true;
										break;
									}
								}
								//Integer type
								if(isInteger){
									System.out.println("Integer type");
									for (int ii = 0; ii < cond.length; ii++) {
										if (!cond[ii].matches("[0-9]+")) {
											intVar.add(cond[ii]);
											undefVar.remove(cond[ii]);
										}
									}
								}
								else if(isBoolean){
									System.out.println("Boolean type");
									for (int ii = 0; ii < cond.length; ii++) {
										boolVar.add(cond[ii]);
										undefVar.remove(cond[ii]);
									}
								}else{
									System.out.println("Undef type");
									for(int ii = 0; ii < cond.length; ii++){
										undefVar.add(cond[ii]);
									}
								}
							}else // jika dia boolean biasa saja, yaitu tidak ada operator equality
							{
								boolVar.add(aa[1].trim());
								undefVar.remove(aa[1].trim());
							}
						}
					} else { //jika tidak distart dari not
						//jika terdapat equality = sign
						if (behaviorName.indexOf("=") > 0) {
							boolean isInteger = false;
							boolean isBoolean = false; 
							String cond[] = behaviorName.split("[=\\+\\-]");
							for (int ii = 0; ii < cond.length; ii++) {
								if (cond[ii].matches("[0-9]+")) {
									isInteger = true;
									break;
								}
								if (intVar.contains(cond[ii])) {
									isInteger = true;
									break;
								} else if (boolVar.contains(cond[ii])) {
									isBoolean = true;
									break;
								}
							}
							//Integer type
							if(isInteger){
								System.out.println("Integer type");
								for (int ii = 0; ii < cond.length; ii++) {
									if (!cond[ii].matches("[0-9]+")) {
										intVar.add(cond[ii]);
										undefVar.remove(cond[ii]);
									}
								}
							}
							else if(isBoolean){
								System.out.println("Boolean type");
								for (int ii = 0; ii < cond.length; ii++) {
									boolVar.add(cond[ii]);
									undefVar.remove(cond[ii]);
								}
							}else{
								System.out.println("Undef type");
								for(int ii = 0; ii < cond.length; ii++){
									undefVar.add(cond[ii]);
								}
							}
						}else // jika dia boolean biasa saja, yaitu tidak ada operator equality
						{
							boolVar.add(behaviorName.trim());
							undefVar.remove(behaviorName.trim());
						}
					}
				} else if (behavior.getType() == BTBehaviorType.INTERNALINPUT) {
					String m[] = behavior.getName().toLowerCase().split("[\\(\\)]");
					System.out.println(Arrays.toString(m));
					if(m.length>1 && !m[1].equalsIgnoreCase("CDATA")){
						String varName = m[1].toLowerCase().trim();
						if(!intVar.contains(varName) && !boolVar.contains(varName))
							undefVar.add(varName);
					}
					System.out.println("Behavior Name : INTERNAL_INPUT "+behavior.getName());
				} else if (behavior.getType() == BTBehaviorType.INTERNALOUTPUT) {
					String m[] = behavior.getName().toLowerCase().split("[\\(\\)]");
					if(m.length>1 && !m[1].equalsIgnoreCase("CDATA")){
						String varName = m[1].toLowerCase().trim();
						if(!intVar.contains(varName) && !boolVar.contains(varName))
							undefVar.add(varName);
					}
					System.out.println("Behavior Name : INTERNALOUTPUT "+behavior.getName());
				} else if (behavior.getType() == BTBehaviorType.EXTERNALINPUT) {
					System.out.println("Behavior Name : EXTERNALINPUT "+behavior.getName());
					String varName = behavior.getName().toLowerCase();
					if(!varName.equalsIgnoreCase("CDATA") && 
							!intVar.contains(varName) && !boolVar.contains(varName))
						undefVar.add(varName);
				} else if (behavior.getType() == BTBehaviorType.EXTERNALOUTPUT) {
					System.out.println("Behavior Name : EXTERNALOUTPUT "+behavior.getName());
					String varName = behavior.getName().toLowerCase();
					if(!varName.equalsIgnoreCase("CDATA") && !varName.contains("string_") &&
							!intVar.contains(varName) && !boolVar.contains(varName))
						undefVar.add(varName);
				}
			}
		}else{ //jika CDATA, CLIST, dan CSET
			String componentName = getName();
			if(componentName.equalsIgnoreCase("DATA")){
				intVar.add("cdata");
			}else if(componentName.equalsIgnoreCase("LIST")){
				intVar.add("size");
				undefVar.add("value");
			}else if(componentName.equalsIgnoreCase("SET")){
				intVar.add("size");
				undefVar.add("value");
			}else{
				throw new IllegalStateException("Not supported ComponentName: "+componentName);
			}
		}
		System.out.println("UNDEF AKHIR : "+Arrays.toString(undefVar.toArray()));
		System.out.println("INT AKHIR : "+Arrays.toString(intVar.toArray()));
		System.out.println("BOOL AKHIR : "+Arrays.toString(boolVar.toArray()));
		System.out.println("=======================================================\n\n");
	}

	public ArrayList<BTBehavior> getBehaviorList() {
		return behaviorList;
	}

	public Set<String> getIntVar() {
		return intVar;
	}

	public void setIntVar(Set<String> intVar) {
		this.intVar = intVar;
	}

	public Set<String> getBoolVar() {
		return boolVar;
	}

	public void setBoolVar(Set<String> boolVar) {
		this.boolVar = boolVar;
	}

	public Set<String> getUndefVar() {
		return undefVar;
	}

	public void setUndefVar(Set<String> undefVar) {
		this.undefVar = undefVar;
	}

}



