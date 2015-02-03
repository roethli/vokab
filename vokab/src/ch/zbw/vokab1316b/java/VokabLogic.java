package ch.zbw.vokab1316b.java;

import java.util.ArrayList;

/**
 * @author Daniel Röthlisberger, ZbW
 * @version 1.0 02.02.2015
 */

public class VokabLogic {

	private ArrayList<Vocabulary> vocabularylist;

	public VokabLogic() {

		this.vocabularylist = new ArrayList<Vocabulary>();
	}
	/*
	 * addCard with frontside backside and category
	 * 
	 */
	
	public void addCard(String frontside, String backside, int category) {
		vocabularylist.add(new Vocabulary(frontside, backside, category));
	}

	public void moveCard(int index) {
		// Move Category of Card + 1 or - 1
	}

	public String showCardFrontside(String backside) {
		for (Vocabulary v : vocabularylist) {
			if (backside.equals(v.getBackside()))
				return v.getFrontside();

		}
		return null;
	}

	public String showCardBackside(String frontside) {
		for (Vocabulary v : vocabularylist) {
			if (frontside.equals(v.getFrontside()))
				return v.getBackside();

		}
		return null;
	}

}
