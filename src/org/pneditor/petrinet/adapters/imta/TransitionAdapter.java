package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractTransition;

import imt.model.petrinet.Transition;

public class TransitionAdapter extends AbstractTransition{
	
	private Transition adaptee;
	
	public TransitionAdapter(String label) {
		super(label);
	}
	
	public void setAdaptee(Transition t) {
		adaptee = t;
	}

}
