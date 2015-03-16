package ch.zbw.vokab1316b.java;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Diese Klasse implementiert ein System zum erlernen von Vokabeln. Sie implementiert die komplette Logik der Lernsoftware
 * zum erlenen von Wortpaaren.
 * 
 * @author Daniel Roethlisberger, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */

public class Logic {
	// Datenfelder
	private static Logic instance = null;
	private ArrayList<Card> vocabularylist; // ArrayList fuer die Wortpaare
	private int category_max; // Maximum an Kategorien
	boolean success; // Abfrage ob erfolgreich oder nicht
	private int successcounter; // Counter welcher hochgezaehlt wird wenn erfolgreich
	private int faultcounter; // Counter welcher hochgezaehlt wird wenn nicht erfolgreich
	private boolean switch_card_side; // Boolean zur Auswahl der Kartenseite welche der Benutzer erlernen moechte.


	/**
	 * Ist hier um die Instanzierung zu verhindern. Um eine Instanz der Logic-Klasse
	 * zu erhalten, muss getInstance() aufgerufen werden
	 */
	protected Logic() {

	}

	/**
	 * Gibt immer die exakt gleiche Instanz der Logic-Klasse zurück, unabhängig davon
	 * aus welcher Klasse diese aufgerufen wird. Somit kann sicher gestellt werden, 
	 * dass alle aufrufenden Klassen mit den gleichen Karten arbeiten bzw. diese manipulieren.
	 * @return Gibt eine Instanz der Klasse Logic zurueck.
	 */
	public Logic getInstance() {
		if (instance == null) {
			instance = new Logic();
			instance.vocabularylist = new ArrayList<Card>(); // initialisiere ArrayList
			instance.category_max = 5; // initialize maximum of categories 5
			instance.success = false; // initialize success
			instance.switch_card_side = false; // initalize cardside - TRUE is
												// backside FALSE is frontside
		}
		return instance;

	}

	/**
	 * Methode zum hinzufuegen einer Karte bzw. eines Wortpaares.
	 * @param frontside Vorderseite der Lernkarte
	 * @param backside Rueckseite der Lernkarte
	 * @param category Kategorie der Lernkarte
	 * @param lang_frontside Sprache der Vorderseite der Lernkarte
	 * @param lang_backside Sprache der Rueckseite der Lernkarte
	 */

	public void addCard(String frontside, String backside, int category,
			String lang_frontside, String lang_backside) {
		vocabularylist.add(new Card(frontside, backside, category,
				lang_frontside, lang_backside));
	}
	
	/**
	 * Methode zum Anzeigen der Vorderseite der Lernkarte.
	 * @param back Rueckseite der Lernkarte.
	 * @return gibt die Vorderseite der Lernkarte zurueck.
	 */
	public String showFront(String back) {
		for (Card v : vocabularylist) {
			if (back.equals(v.getBack()))
				return v.getFront();

		}
		return null;
	}

	/**
	 * Methode zur Ueberpruefung bzw. dem Vergleich der eingegebenen Loesung. 
	 * @param input Eingabe des benutzers
	 * @param front Bekannte Vorgegebene Seite der Karte der Karte
	 * @return Gibt richtig oder falsch zurueck.
	 */
	public boolean checkInput(String input, String front) {

		if (!switch_card_side) {
			return checkInputNormal(input, front);
		} else {
			return checkInputTurned(input, front);
		}

	}
	
	/**
	 * Hilfsmethode fuer checkInput() zur ueberpruefung der Usereingabe.
	 * Wenn im Normalen Modus gearbeitet wird (Vorderseite wird angezeigt).
	 * @param input Usereingabe
	 * @param front Vorderseite der Lernkartei
	 * @return Gibt richtig oder falsch zurueck.
	 */
	private boolean checkInputNormal(String input, String front) {

		for (Card v : vocabularylist) {
			if (v.getFront().equalsIgnoreCase(front)) {
				if (v.getBack().equalsIgnoreCase(input)) {
					if (v.getCategory() < getCategory_max())
						v.setCategory(v.getCategory() + 1);
					setSuccesscounter();
					return true;
				} else {
					
						v.setCategory(1);
						System.out.println(v.getCategory());
						setFaultcounter();
						return false;
				}
			}

		}
		return false;
	}
	
	/**
	 * Hilfsmethode fuer checkInput() zur ueberpruefung der Usereingabe.
	 * Wenn im "gewechselten" Modus gearbeitet wird (Rueckseite wird angezeigt).
	 * @param input Usereingabe
	 * @param front Rueckseite der Lernkartei
	 * @return Gibt richtig oder falsch zurueck.
	 */
	
	private boolean checkInputTurned(String input, String back) {

		for (Card v2 : vocabularylist) {
			if (v2.getBack().equalsIgnoreCase(back)) {
				if (v2.getFront().equalsIgnoreCase(input)) {
					if (v2.getCategory() < getCategory_max())
						v2.setCategory(v2.getCategory() + 1);
					setSuccesscounter();
					return true;
				} else {
					if (v2.getCategory() > 1) {
						v2.setCategory(v2.getCategory() - 1);
						System.out.println(v2.getCategory());
						setFaultcounter();
						return false;
					}
				}
			}

		}
		return false;
	}

	/**
	 * Eine Methode welche eine Karte nach einer Bestimmten Gewichtung ausgewaehlt wird.
	 * Karten der Kategorie 1 werden am meisten angezeigt und Karten der Kategorie 5 am wenigsten.
	 * So ist gewaehrleistet das in einem Sinnvollen Lernrythums gelernt wird. 
	 * 
	 * @return gibt eine Karte zurueck.
	 */
	public String getCard()  {
		
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
	
	/**
	 * Methode zur ausgabe der Wort-Sprache der Vorderseite einer Lernkarte.
	 * @param text Text welcher zur Bestimmung der Sprache benoetigt wird.
	 * @return Gibt die Sprache der Lernkartei zurueck.
	 */
	public String getCardLangFront(String text) {

		for (Card v : vocabularylist) {
			if (v.getFront().equals(text)
					&& v.getLangFront().equals(v.getLangFront())) {
				return v.getLangFront();
			} else if (v.getBack().equals(text)
					&& v.getLangBack().equals(v.getLangBack())) {
				return v.getLangBack();
			}  
			

		}
		return null;
	}

	/**
	 * Methode zur ausgabe der Wort-Sprache der Rueckseite einer Lernkarte.
	 * @param text Text welcher zur Bestimmung der Sprache benoetigt wird.
	 * @return Gibt die Sprache der Lernkartei zurueck.
	 */
	public String getCardLangBack(String text) {

		for (Card v : vocabularylist) {
			if (v.getFront().equals(text)
					&& v.getLangFront().equals(v.getLangFront())) {
				return v.getLangBack();
			} else if (v.getBack().equals(text)
					&& v.getLangBack().equals(v.getLangBack())) {
				return v.getLangFront();
			}  
			

		}
		return null;
	}
	
	/**
	 * Methode zur ermittlung der Loesung bzw. des Loesungswortes.
	 * @param text Usereingabe
	 * @return gibt die Loesung zurueck.
	 */
	public String getSolution(String text)
	{
		for(Card v : vocabularylist)
		{
			if(v.getFront().equals(text))
			{
				if(!switch_card_side)
				{
				return v.getBack();
				}
				else
				return v.getFront();
			}
			
		}
		return null;
	}
	
	
	/**
	 * Methode zur ermittlung der aktuellen Lernkarteiseite welche angezeigt wird.
	 * @return git den boolean zurueck auf welcher Kartenseite gearbeitet wird.
	 */
	public boolean isSwitch_card_side() {
		return switch_card_side;
	}
	
	/**
	 * Methode zum Setzten der Lernkarteiseite mit welcher man lernen moechte.
	 * @param switch_card_side True fuer Vorderseite / False fuer Rueckseite.
	 */
	public void setSwitch_card_side(boolean switch_card_side) {
		this.switch_card_side = switch_card_side;
	}

	/**
	 * Methode zum ermitteln der Wortliste.
	 * @return gibt die vocabularylist zurueck.
	 */

	public ArrayList<Card> getVocabularylist() {
		return vocabularylist;
	}

	/**
	 * Methode zum Hinzufuegen einer Arraylist / Wortliste.
	 * @param vocabularylist erwartet eine ArrayList des Typs Card
	 */

	public void setVocabularylist(ArrayList<Card> vocabularylist) {
		this.vocabularylist = vocabularylist;
	}

	/**
	 * Methode zum Ermitteln des Maximums an Kategorien.
	 * @return gibt eine Zahl zurueck welche das Maximum der Kategorien ist.
	 */
	public int getCategory_max() {
		return category_max;
	}

	/**
	 * Methode setzten des Maximums an Kategorien.
	 * @param category_max Zahl welche das Maximum an Kategorien angibt.
	 */
	public void setCategory_max(int category_max) {
		this.category_max = category_max;
	}

	/**
	 * Methode zum ermitteln wie viele Lernkarten richtig beantwortet wurden.
	 * @return Zahl welche den aktuellen Erfolgszaehler zurueck gibt.
	 */
	public int getSuccesscounter() {
		return successcounter;
	}

	/**
	 * Methode zum hochzaehlen des Erfolgszaehlers.
	 */
	public void setSuccesscounter() {
		this.successcounter = this.successcounter + 1;
	}

	/**
	 * Methode zum ermitteln wie viele Lernkarten falsch beantwortet wurden.
	 * @return Zahl welche den aktuellen Misserfolgszaehler zurueck gibt.
	 */
	public int getFaultcounter() {
		return faultcounter;
	}

	/**
	 * Methode zum hochzaehlen des Misserfolgszaehlers.
	 */

	public void setFaultcounter() {
		this.faultcounter = this.faultcounter + 1;
	}
	
	/**
	 * Methode zur Ermittlung wie viel Prozent Lernkarten falsch beantwortet wurden.
	 * @return gibt die Prozentzahl an falsch beantworteten Lernkarten zurueck.
	 */
	public int getPercentFault() {
		int tempsum =  getFaultcounter() + getSuccesscounter() ;
		if(tempsum > 0)
		{
		int tempsum2 = 100 / tempsum;
		int percent = tempsum2 * getFaultcounter();
		
		return percent;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * Methode zur Ermittlung wie viel Prozent Lernkarten richtig beantwortet wurden.
	 * @return gibt die Prozentzahl an richtig beantworteten Lernakrten zurueck.
	 */
	public int getPercentSuccess() {
		
		int tempsum =  getFaultcounter() + getSuccesscounter() ;
		if(tempsum > 0)
		{
		int tempsum2 = 100 / tempsum;
		int percent = tempsum2 * getSuccesscounter();
		
		return percent;
		}
		else
		return 0;
	}
	
	/**
	 * Methode zur Ermittlung aller Kartenvorderseiten. Diese wird zum abfuellen einer JComboBox benoetigt. (EditGUI)
	 * @param box erwartet eine JCombobox welche abgefuellt wird.
	 */
	public void getAllFront(JComboBox box)
	{
		for(Card v : vocabularylist)
		{
			box.addItem(v.getFront());
		}
	}
	
	/**
	 * Methode zur Ermittlung aller Lernkarteninformationen um anschliessend Textfelder damit zu befuellen. (EditGUI)
	 * @param choosen erwartet einen String mit dem Ausgewaehlten Wort.
	 * @param front erwartet ein Textfeld fuer den Text der Vorderseite einer Lernkarte.
	 * @param back erwartet ein Textfeld fuer den Text der Rueckseite einer Lernkarte.
	 * @param langfront erwartet ein Textfeld fuer den Text der Sprache einer Vorderseite von einer Lernkarte.
	 * @param langback erwartet ein Textfeld fuer den Text der Sprache einer Rueckseite von einer Lernkarte.
	 * @param box erwartet eine JComboBox.
	 */
	public void getCardInformations(String choosen,JTextField front, JTextField back,
			JTextField langfront, JTextField langback, JComboBox box)
	{
		for(Card v : vocabularylist)
		{
			if(v.getFront().equals(choosen))
			{
				front.setText(v.getFront());
				back.setText(v.getBack());
				langfront.setText(v.getLangFront());
				langback.setText(v.getLangBack());
			}
		}
	}
	
	/**
	 * Methode zum Loeschen von Lernkarten.
	 * @param front erwartet einen Text zur Ermittlung welche Karte geloescht werden soll.
	 * @param box erwartet eine JComboBox um diese zu leeren damit diese anschliessend wieder im 
	 *        EditGUI befuellt werden kann. 
	 */
	public void deleteCard(String front, JComboBox box)
	{
		for(int i=0;i<vocabularylist.size();i++) {
		     
		    if(vocabularylist.get(i).getFront().equals(front) )
		    		{ 
		       vocabularylist.remove(i);
		        i--;
		        box.removeAllItems();
		        
		    }
		}
	}
	
	
	

}
