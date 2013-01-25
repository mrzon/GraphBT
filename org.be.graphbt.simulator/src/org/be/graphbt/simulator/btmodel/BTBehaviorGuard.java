package org.be.graphbt.simulator.btmodel;

public class BTBehaviorGuard extends BTBehavior{
	public BTBehaviorGuard(String ref, String name) {
        super(BTBehaviorType.GUARD, ref, name);
    }
        
    @Override
    public String toString() {
        return "???"+this.getName()+"???";
    }
}