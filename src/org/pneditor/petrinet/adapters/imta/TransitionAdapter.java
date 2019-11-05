package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractTransition;

import model.Transition;

public class TransitionAdapter extends AbstractTransition{
	
	private Transition adaptee;
	
	public TransitionAdapter(String label) {
		super(label);
	}

}
