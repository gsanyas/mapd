package org.pneditor.petrinet.adapters.imta;

import org.pneditor.petrinet.AbstractPlace;

import model.Place;



public class PlaceAdapter extends AbstractPlace {
	
	private Place adaptee;

	public PlaceAdapter(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isPlace() {
		return true;
	}

	@Override
	public void addToken() {
		adaptee.increaseJeton(1);
	}

	@Override
	public void removeToken() {
		adaptee.decreaseJeton(1);
	}

	@Override
	public int getTokens() {
		return adaptee.getNumJetons();
	}

	@Override
	public void setTokens(int tokens) {
		adaptee.setNumJetons(tokens);
	}

}
