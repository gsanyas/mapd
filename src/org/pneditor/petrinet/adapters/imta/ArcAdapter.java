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

public class ArcAdapter extends AbstractArc {

	private Arc adaptee;

	@Override
	public AbstractNode getSource() {
		if (adaptee.isInTransition()) {
			PlaceAdapter pa = new PlaceAdapter("");
			pa.setAdaptee(adaptee.getP());
			return pa;
		}
		else {
			TransitionAdapter ta = new TransitionAdapter("");
			ta.setAdaptee(adaptee.getT());
			return ta;
		}
	}

	@Override
	public AbstractNode getDestination() {
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

	@Override
	public boolean isReset() {
		return adaptee instanceof ArcCleaner;
	}

	@Override
	public boolean isRegular() {
		return adaptee instanceof ArcRegular;
	}

	@Override
	public boolean isInhibitory() {
		return adaptee instanceof ArcZero;
	}

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
