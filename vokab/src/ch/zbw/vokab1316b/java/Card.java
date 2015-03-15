package ch.zbw.vokab1316b.java;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Die Klasse implementiert den Inhalt einer Lernkarte welcher spaeter in der Logic Klasse 
 * fuer die ArrayList bzw. die Wortliste verwendet wird.
 * 
 * @author Daniel Roethlisberger, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */

@XmlRootElement
public class Card {

	// Datenfelder
	private String front;
	private String back;
	private int category;
	private String langFront;
	private String langBack;
	private int faults;
	private int successful;

	/*
	 * Konstruktor ohne Parameter. Wird fuer das XML-Mashalling gebraucht.
	 */
	public Card() {

	}
	
	/**
	 * Konstruktior der Klasse Card
	 * @param front hier wird ein Parameter fuer die Vorderseite einer Lernkarte erwartet.
	 * @param back hier wird ein Parameter fuer die Rueckseite einer Lernkarte erwartet.
	 * @param category Es wird ein Parameter fuer die Kategorie erwartet.
	 * @param langFront Es wird ein Parameter fuer die Sprache der Vorderseite einer Lernkartei erwartet.
	 * @param langBack Es wird ein Parameter fuer die Sprache der Rueckseite erwartet.
	 */
	public Card(String front, String back, int category, String langFront,
			String langBack) {
		// declare variable frontside
		this.front = front;
		// declare variable backside
		this.back = back;
		// declare variable category
		this.category = category;
		this.langBack = langBack;
		this.langFront = langFront;
		this.faults = 0;
		this.successful = 0;
	}


	/**
	 * Methode zur Ermittlung der Lernkarten Vorderseite.
	 * @return gibt die Vorderseite einer Lernkarte zurueck.
	 */
	@XmlElement
	public String getFront() {
		return front;
	}

	/**
	 * Methode zum setzten einer Lernkarten Vorderseite.
	 * @param erwartet einen Wert welcher als Kartenvorderseite gespeichert wird.
	 */

	public void setFront(String front) {
		this.front = front;
	}

	/**
	 * Methode zum ermitteln einer Lernkarten Rueckseite.
	 * @return gibt die Rueckseite einer Lernkarte zurueck.
	 */
	@XmlElement
	public String getBack() {
		return back;
	}

	/**
	 * Methode zum setzten einer Lernkarten Ruckseite.
	 * @param erwartet einen Wert welcher als Kartenrueckseite gespeichert wird.
	 */
	public void setBack(String back) {
		this.back = back;
	}

	/**
	 * Methode zum ermitteln der Kategorie welche die Lernkarte hat.
	 * @return gibt eine Zahl zurueck welche der Kategorie entspricht.
	 */
	@XmlElement
	public int getCategory() {
		return category;
	}

	/**
	 * Methode zum setzten der Kategorie der Lernkarte.
	 * @param category erwartet einen Wert welcher der Kategorie der Karte entspricht.
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * Methode zum ermitteln der Kartensprache. (Vorderseite)
	 * @return gibt die Kartensprache zurueck. (Vorderseite)
	 */
	@XmlElement
	public String getLangFront() {
		return langFront;
	}

	/**
	 * Methode zum setzten der Kartensprache. (Vorderseite)
	 * @param langFront erwaret einen Wert welcher der Sprache der Karten Vorderseite entspricht.
	 */
	public void setLangFront(String langFront) {
		this.langFront = langFront;
	}
	/**
	 * Methode zum ermitteln der Kartensprache. (Rueckseite)
	 * @return gibt die Kartensprache zurueck. (Rueckseite)
	 */
	@XmlElement
	public String getLangBack() {
		return langBack;
	}
	/**
	 * Methode zum setzten der Kartensprache. (Rueckseite)
	 * @param langBack erwartet einen Wert welcher der Sprache der Karten Rueckseite entspricht.
	 */
	public void setLangBack(String langBack) {
		this.langBack = langBack;
	}
	
	

}
