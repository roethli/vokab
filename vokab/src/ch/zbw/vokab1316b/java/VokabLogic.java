package ch.zbw.vokab1316b.java;

import java.util.ArrayList;

/**
 * @author Daniel Röthlisberger, ZbW
 * @version 1.0 02.02.2015
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
	 * addCard with frontside backside and category
	 * 
	 */
	
	public void addCard(String frontside, String backside, int category) {
		vocabularylist.add(new Vocabulary(frontside, backside, category));
	}

	public void moveCard(String frontside) {
		for(Vocabulary v : vocabularylist)
		{
			if(frontside.equals(v.getFrontside()) && success && v.getCategory()<category_max)
			{
				int category_temp = v.getCategory();
				v.setCategory(category_temp +1);
			}
			else
			{
				v.setCategory(1);
			}
		}
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
	
	public void showNextCard()
	{
		
	}
	
	public void showPrevCard()
	{
		
	}
	
	
}
