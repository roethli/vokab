package ch.zbw.vokab1316b.java;

import java.util.ArrayList;

public class VokabLogic {

	private ArrayList<Vocabulary> vocabularylist;

	public VokabLogic() {
		
		this.vocabularylist = new ArrayList<Vocabulary>();
	}
	
	public void addCard(String frontside, String backside, int category)
	{
		vocabularylist.add(new Vocabulary(frontside, backside, category));
	}
	
	public void moveCard(int index)
	{
		//Move Category of Card + 1 or - 1
	}
	
	public String showCardFrontside(String backside)
	{
		for(Vocabulary v : vocabularylist)
		{
		if(backside.equals(v.getFrontside()))
			System.out.println(v.getFrontside());
		
		}
		return null;
	}
	
	public String showCardBackside(String frontside)
	{
		for(Vocabulary v : vocabularylist)
		{
		if(frontside.equals(v.getFrontside()))
			System.out.println(v.getFrontside());
		
		}
		return null;
	}
	
	public String showCardSolution(String frontside)
	
	{
		for(Vocabulary v : vocabularylist)
		{
			if(frontside.equals(v.getFrontside()))
			{
				System.out.println(v.getBackside());
			}
		}
		return null;	 
	}
	
	
	
	
	
	
	
	
	
}
