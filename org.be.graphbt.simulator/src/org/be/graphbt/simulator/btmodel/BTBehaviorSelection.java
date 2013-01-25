package org.be.graphbt.simulator.btmodel;

public class BTBehaviorSelection extends BTBehavior{
    public BTBehaviorSelection(String ref, String name) {
        super(BTBehaviorType.SELECTION, ref, name);
    }
    
    @Override
    public String toString() {
        return "?"+this.getName()+"?";
    }
}