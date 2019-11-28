package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractPlace;

import imt.model.petrinet.Place;


/**
 * 
 * Adapter class which allows the use of
 * imt.model.petrinet Place in this pne
 * 
 * @author Daniel Santos & Guillem Sanyas
 *
 */
public class PlaceAdapter extends AbstractPlace {
	
	private Place adaptee;

	/**
	 * Constructor for the adapter
	 * @param label
	 */
	public PlaceAdapter(String label) {
		super(label);
		adaptee = new Place(0);
	}

	/**
	 * Method that indicates if this is a place
	 * @return true always
	 */
	@Override
	public boolean isPlace() {
		return true;
	}

	/**
	 * Method that adds one token to the adapted place value
	 */
	@Override
	public void addToken() {
		adaptee.increaseJeton(1);
	}

	/**
	 * Method that removes one token from the adapted place value
	 */
	@Override
	public void removeToken() {
		adaptee.decreaseJeton(1);
	}

	/**
	 * Method that gives the amount of tokens stored in the adapted place
	 * @return the amount of tokens
	 */
	@Override
	public int getTokens() {
		return adaptee.getNumJetons();
	}

	/**
	 * Method that allows a quick modification of the number of tokens in the
	 * adapted place
	 * @param tokens : the new amount of tokens in this place
	 */
	@Override
	public void setTokens(int tokens) {
		adaptee.setNumJetons(tokens);
	}
	
	/**
	 * Method that allows to choose which place is adapted
	 * @param p: the place that will be adapted
	 */
	public void setAdaptee(Place p) {
		this.adaptee = p;
	}

}
