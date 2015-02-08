package ch.zbw.vokab1316b.java;

import java.util.ArrayList;

/**
 * @author Daniel R�thlisberger, ZbW
 * @version 1.0 07s.02.2015
 */

public class VokabLogic {

	private ArrayList<Vocabulary> vocabularylist;
	private int category_max;
	boolean success;

	public VokabLogic() {

		this.vocabularylist = new ArrayList<Vocabulary>();
		this.category_max = 5;
		this.success = false;
	}

	/*
	 * addCard with front side, back side and category
	 */

	public void addCard(String frontside, String backside, int category) {
		vocabularylist.add(new Vocabulary(frontside, backside, category));
	}

	/*
	 * moveCard category, if success and the category is not on maximum + 1
	 * moveCard category, if not success - 1 If Card category is on maximum and
	 * success change nothing
	 */

	public void moveCard(String frontside, boolean success) {
		for (Vocabulary v : vocabularylist) {
			if (frontside.equals(v.getFrontside()) && success
					&& v.getCategory() < this.category_max) {
				int category_temp = v.getCategory();
				v.setCategory(category_temp + 1);
			} else {
				v.setCategory(1);
			}

		}
	}

	/*
	 * @return return a string with the voc. on the front side of the vocabulary
	 * card
	 */
	public String showCardFrontside(String backside) {
		for (Vocabulary v : vocabularylist) {
			if (backside.equals(v.getBackside()))
				return v.getFrontside();

		}
		return null;
	}

	/*
	 * @return return a string with the voc. on the back side of the vocabulary
	 * card
	 */
	public String showCardBackside(String frontside) {
		for (Vocabulary v : vocabularylist) {
			if (frontside.equals(v.getFrontside()))
				return v.getBackside();
		}
		return null;
	}

	public String showNextCard(String frontside) {

		if (getIndex(frontside) + 1 < vocabularylist.size()) {
			Vocabulary index1 = vocabularylist.get(getIndex(frontside) + 1);
			int success = index1.getSucesses();
			index1.setSucesses(success +1);
			return index1.getFrontside();
		} else {
			return null;
		}

	}

	public String showPrevCard(String frontside) {

		if (getIndex(frontside) - 1 >= 0) {
			Vocabulary index1 = vocabularylist.get(getIndex(frontside) - 1);
			return index1.getFrontside();
		} else {
			return null;
		}

	}
	
	public int getIndex(String frontside)
	{
	    for (int i = 0; i < vocabularylist.size(); i++)
	    {
	        Vocabulary voc_temp = vocabularylist.get(i);
	        if (frontside.equals(voc_temp.getFrontside()))
	        {
	            return i;
	        }
	    } 

	    return -1;
	}
	
}
