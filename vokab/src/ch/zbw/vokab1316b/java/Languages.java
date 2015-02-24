package ch.zbw.vokab1316b.java;

import javax.swing.JOptionPane;
// TODO GUI Sprachen auslagern 

public class Languages {
	
	// Definiere Variable f�r Spracheeinstellung
	String language = "de";
	
	// Definiere Titel f�r alle Sprachen
	String titleDe = ("<html><body><h1><strong>Herzlich Willkommen zum Vokabel Trainer V1.0</strong></h1></body></html>");
	String titleEn = ("<html><body><h1><strong>Welcome to Vokabel Trainer V1.0</strong></h1></body></html>");
	String titleFr = ("<html><body><h1><strong>Bienvenue � Vokabel Trainer V1.0</strong></h1></body></html>");
	String titleIt = ("<html><body><h1><strong>Benvenuti a Vokabel Trainer V1.0</strong></h1></body></html>");
	
	// Definiere Textinhalt f�r alle Sprachen
	String contentDe = ("<html><body><h3>Bitte waehle wie du weiter vorgehen moechtest:</h3><br><br>"
	    	+ "Starten: Hiermit startest du das Lernprogramm Vokab V1.0<br>"
	    	+ "Speichern\\Laden: Laden oder speichern von Karteien!<br>"
	    	+ "Erfassen: Hinzufuegen von Lernkarteien!<br>"
	    	+ "Hilfe: Kurzhilfe zu den wichtigesten Themen</body></html>");
	String contentEn = ("<html><body><br> Please choose how you want to proceed further:<br><br></body></html>");
	String contentFr = ("<html><body><br> S'il vous pla�t choisir la fa�on dont vous voulez aller plus loin:<br><br></body></html>");
	String contentIt = ("<html><body><br>Si prega di scegliere come si vuole procedere ulteriormente:<br><br></body></html>");
	
	// Definiere Textinhalt Hilfefunktion f�r alle Sprachen
    String helpDe = "In diesem Fenster wird eine einfache Hilfe angeboten."
        		    + "\nFolgende Themen werden bearbeitet:" + "\nThema1" + "\nThema2" + "\nThema3" + "\n"
        	    	+ "\nSprache: " + getLanguage();
    String helpEn = "In this window, a simple help is offered."
        		    + "\nThe following topics are dealt with:" + "\nTopic1"	+ "\nTopic2" + "\nTopic3" + "\n"
        	    	+ "\nLanguage: " + getLanguage();
    String helpFr = "Dans cette fen�tre, une aide simple est offert."
        		    + "\nLes sujets suivants sont abord�s:"	+ "\nSujet1" + "\nSujet2" + "\nSujet3" + "\n"
        	    	+ "\nLangue: " + getLanguage();
    String helpIt = "In questa finestra, un semplice aiuto viene offerto."
        		    + "\nI seguenti argomenti sono trattati:" + "\nArgomento1" + "\nArgomento2" + "\nArgomento3" + "\n"
        	    	+ "\nLingua: " + getLanguage();
	
	// Gib Spracheinstellung
	public String getLanguage() {
		return language;
	}
	
	// Setze Spracheinstellung
	public void setLanguage(String language) {
		this.language = language;
	}
	
	// Gib Titel MainGUI f�r alle Sprachen
	public String getTitleDe() {
		return titleDe;
	}
	public String getTitleEn() {
		return titleEn;
	}
	public String getTitleFr() {
		return titleFr;
	}
	public String getTitleIt() {
		return titleIt;
	}
	
	// Gib Textinhalt MainGUI f�r alle Sprachen
	public String getContentDe() {
		return contentDe;
	}
	public String getContentEn() {
		return contentEn;
	}
	public String getContentFr() {
		return contentFr;
	}
	public String getContentIt() {
		return contentIt;
	}
	
	// Gib Textinhalt Hilfefunktion f�r alle Sprachen
	public String getHelptextDe() {
		return helpDe;
	}
	public String getHelptextEn() {
		return helpEn;
	}
	public String getHelptextFr() {
		return helpFr;
	}
	public String getHelptextIt() {
		return helpIt;
	}
}