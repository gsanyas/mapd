package org.pneditor.petrinet.adapters.imta;

import org.hamcrest.core.IsInstanceOf;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.ResetArcMultiplicityException;

import model.Arc;
import model.ArcRegular;
import model.Place;

public class ArcAdapter extends AbstractArc {

	private Arc adaptee;
	private AbstractNode source;
	private AbstractNode target;
	/**
	 *  Factory method to do the adapter with our types of arcs
	 * @param source
	 * @param target
	 * @param arcType
	 */
	public ArcAdapter(NodeAdapter source,NodeAdapter target,String arcType) {	
		this.source = source;
		this.target = target;
		if ( arcType == "regular" ) {
			//if( source instanceof AbstractPlace ) {}
		}
		else if ( arcType == "zero") {
			adaptee = new ArcRegular(null);
		}
		else if ( arcType == "regular") {
			adaptee = new ArcRegular(null);
		}
		
	}	
	
	@Override
	public AbstractNode getSource() {
		return this.source;
	}

	@Override
	public AbstractNode getDestination() {
		return this.target;
	}

	@Override
	public boolean isReset() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRegular() {
		return ( this.adaptee instanceof ArcRegular) ;
	}

	@Override
	public boolean isInhibitory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		// TODO Auto-generated method stub
		
	}

}
