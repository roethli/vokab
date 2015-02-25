package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * @author Daniel Röthlisberger, ZbW
 * @version 1.0 07s.02.2015
 */

public class Logic {

	private static Logic instance = null;
	private ArrayList<Card> vocabularylist; // Arraylist for the words
	private int category_max; // category maximum
	boolean success; // success?
	private int successcounter; // Simple counter for success
	private int faultcounter; // Simple counter for faults
	private boolean switch_card_side;

	// only here to avoid instantiation, for getting an instace 'getInstance'
	// needs to be called
	protected Logic() {

	}

	// always returns the same instance of VocabLogik, no matter from which
	// class this is called
	public Logic getInstance() {
		if (instance == null) {
			instance = new Logic();
			instance.vocabularylist = new ArrayList<Card>(); // initialize
																// Arraylist
			instance.category_max = 5; // initialize maximum of categories 5
			instance.success = false; // initialize success
			instance.switch_card_side = false; // initalize cardside - TRUE is
												// backside FALSE is frontside
		}
		return instance;

	}

	/*
	 * addCard with front side, back side and category
	 */

	public void addCard(String frontside, String backside, int category,
			String lang_frontside, String lang_backside) {
		vocabularylist.add(new Card(frontside, backside, category,
				lang_backside, lang_frontside));
	}

	/*
	 * moveCard category, if success and the category is not on maximum + 1
	 * moveCard category, if not success - 1 If Card category is on maximum and
	 * success change nothing
	 */

//	public void moveCard(String frontside, boolean success) {
//		for (Card v : vocabularylist) {
//			if (frontside.equals(v.getFront()) && success
//					&& v.getCategory() < this.category_max) {
//				int category_temp = v.getCategory();
//				v.setCategory(category_temp + 1);
//			}
//
//		}
//	}

	/*
	 * @return return a string with the voc. on the front side of the vocabulary
	 * card
	 */
	public String showFront(String back) {
		for (Card v : vocabularylist) {
			if (back.equals(v.getBack()))
				return v.getFront();

		}
		return null;
	}

	

	/*
	 * Check card if solution is right or wrong!
	 */
	public boolean checkInput(String input, String front) {

		for (Card v : vocabularylist) {
			if (v.getFront().equals(front)) {
				if (v.getBack().equals(input)) {
					if (v.getCategory() < getCategory_max())
						v.setCategory(v.getCategory() + 1);
						setSuccesscounter();
					return true;					
				} else {
					if (v.getCategory() > 1) {
						v.setCategory(v.getCategory() - 1);
						System.out.println(v.getCategory());
						setFaultcounter();
						return false;
					}
				}
			}
		}
		return false;

	}

	/*
	 * main logic
	 */
	public String getCard() {
		Random r = new Random();
		int low = 1;
		int high = 100;
		int random = r.nextInt(high - low) + low;

		{
			for (Card v : vocabularylist) {
				if (v.getCategory() == 1 && random > 0 && random <= 50) {
					if (!this.switch_card_side) {
						return v.getFront();
					} else {
						return v.getBack();
					}
				} else if (v.getCategory() == 2 && random > 50 && random <= 70) {
					if (!this.switch_card_side) {
						return v.getFront();
					} else {
						return v.getBack();
					}
				} else if (v.getCategory() == 3 && random > 70 && random <= 85) {
					if (!this.switch_card_side) {
						return v.getFront();
					} else {
						return v.getBack();
					}
				} else if (v.getCategory() == 4 && random > 85 && random <= 95) {
					if (!this.switch_card_side) {
						return v.getFront();
					} else {
						return v.getBack();
					}
				} else if (v.getCategory() == 5 && random > 95 && random <= 100) {
					if (!this.switch_card_side) {
						return v.getFront();
					} else {
						return v.getBack();
					}

				}

			}
		}
		return getCard();
	}

	// TODO switch_card_side ?
	public boolean isSwitch_card_side() {
		return switch_card_side;
	}

	public void setSwitch_card_side(boolean switch_card_side) {
		this.switch_card_side = switch_card_side;
	}

	/*
	 * Getter for Vocabulary Arraylist...
	 */
	// TODO getVocabularlist used?
	public ArrayList<Card> getVocabularylist() {
		return vocabularylist;
	}

	/*
	 * Setter for a Arraylist
	 */
	// TODO setVocabularylist used?
	public void setVocabularylist(ArrayList<Card> vocabularylist) {
		this.vocabularylist = vocabularylist;
	}

	/*
	 * Getter to find out the Category maximum
	 */
	public int getCategory_max() {
		return category_max;
	}

	/*
	 * setter to set the Category Maximum.... ACHTUNG NICHT BENUTZEN
	 */
	public void setCategory_max(int category_max) {
		this.category_max = category_max;
	}

	/*
	 * get the actual INT for succeeded cards
	 */
	public int getSuccesscounter() {
		return successcounter;
	}

	/*
	 * get the actual INT for succeeded cards + 1
	 */
	// TODO sucess counter
	public void setSuccesscounter() {
		this.successcounter = this.successcounter + 1;
	}

	/*
	 * get the actual INT for Fault cards
	 */
	// TODO fault counter

	public int getFaultcounter() {
		return faultcounter;
	}

	/*
	 * set the actual INT for Fault cards +1
	 */

	// TODO fault counter setter
	public void setFaultcounter() {
		this.faultcounter = this.faultcounter + 1;
	}
	
	/**
	 * Erfolgsübersicht Einfach - anzahl falsche / richtige
	 */
	 public void getOverview(){
	        JOptionPane.showMessageDialog(
	        	        null, "Anzahl Richtig: "+ getSuccesscounter() + "\n" + "Anzahl Falsche: " + getFaultcounter() ,
	        	    	"Erfolgsübersicht",
	                    JOptionPane.INFORMATION_MESSAGE);
	    }
	
	
	
}
