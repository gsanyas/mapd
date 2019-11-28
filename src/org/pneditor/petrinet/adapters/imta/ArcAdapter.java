package org.pneditor.petrinet.adapters.imta;

import org.hamcrest.core.IsInstanceOf;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import imt.model.petrinet.Arc;
import imt.model.petrinet.ArcCleaner;
import imt.model.petrinet.ArcRegular;
import imt.model.petrinet.ArcZero;
import imt.model.petrinet.Place;

/**
 * 
 * Adapter class which allows the use of
 * imt.model.petrinet Arc in this pne
 * 
 * @author Daniel Santos & Guillem Sanyas
 *
 */
public class ArcAdapter extends AbstractArc {

	private Arc adaptee;

	/**
	 * Method that returns the
	 * source node of the adapted arc
	 */
	@Override
	public AbstractNode getSource() {
		// in our model the source and destination are
		// defined in a different way
		if (adaptee.isInTransition()) {
			// if the adapted arc goes from a place to a transition
			PlaceAdapter pa = new PlaceAdapter("");
			pa.setAdaptee(adaptee.getP());
			return pa;
		}
		else {
			// if the adapted arc goes from a transition to a place
			TransitionAdapter ta = new TransitionAdapter("");
			ta.setAdaptee(adaptee.getT());
			return ta;
		}
	}

	/**
	 * Method that returns the destination
	 * node of the adapted arc
	 */
	@Override
	public AbstractNode getDestination() {
		// the problem is similar to getSource method
		if (adaptee.isInTransition()) {
			TransitionAdapter ta = new TransitionAdapter("");
			ta.setAdaptee(adaptee.getT());
			return ta;
		}
		else {
			PlaceAdapter pa = new PlaceAdapter("");
			pa.setAdaptee(adaptee.getP());
			return pa;
		}
	}

	/**
	 * Method to get the type of arc
	 * @return true if adapted arc is cleaner/reset arc
	 * @return false if it is not
	 */
	@Override
	public boolean isReset() {
		return adaptee instanceof ArcCleaner;
	}

	/**
	 * Method to get the type of arc
	 * @return true if the adapted arc is regular
	 * @return false if it is not
	 */
	@Override
	public boolean isRegular() {
		return adaptee instanceof ArcRegular;
	}

	/**
	 * Method to get the type of arc
	 * @return true if the adapted arc is inhibitory/zero arc
	 * @return false if it is not
	 */
	@Override
	public boolean isInhibitory() {
		return adaptee instanceof ArcZero;
	}

	/**
	 * Method that returns the multiplicity of an arc
	 * @throws ResetArcMultiplicityException if the arc is a reset/cleaner arc
	 * @return the multiplicity of a regular arc, and zero if it is a zero/inhibitory arc
	 */
	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		if (this.isReset()) {
			throw new ResetArcMultiplicityException();
		}
		else {
			if (this.isRegular()) {
				ArcRegular ar = (ArcRegular)adaptee;
				return ar.getValue();
			}
			else {
				return 0;
			}
		}
	}

	/**
	 * Method that allows the choice of the multiplicity of the adapted arc
	 * @param int multiplicity : the multiplicity to apply
	 * @throws ResetArcMultiplicityException if the arc is a reset/cleaner arc
	 */
	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		if (this.isReset()) {
			throw new ResetArcMultiplicityException();
		}
		else if (this.isRegular()) {
				ArcRegular ar = (ArcRegular)adaptee;
				ar.setValue(multiplicity);;
		}
	}
	

}
