package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractTransition;

import imt.model.petrinet.Transition;

/**
 * 
 * Adapter class which allows the use of
 * imt.model.petrinet Transition in this pne
 * 
 * @author Daniel Santos & Guillem Sanyas
 *
 */
public class TransitionAdapter extends AbstractTransition{
	
	private Transition adaptee;
	
	/**
	 * Constructor for the adapter
	 * @param label
	 */
	public TransitionAdapter(String label) {
		super(label);
		adaptee = new Transition();
	}
	
	/**
	 * Method that allows to choose which transition will be adapted
	 * @param t: the transition that will be adapted
	 */
	public void setAdaptee(Transition t) {
		adaptee = t;
	}

}
