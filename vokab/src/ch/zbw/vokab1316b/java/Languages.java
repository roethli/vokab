package ch.zbw.vokab1316b.java;

import javax.swing.JOptionPane;
// TODO GUI Sprachen auslagern 

public class Languages {
	
	// Definiere Variable f�r Spracheeinstellung
	String language = "de";
	
	// Definiere Software Details
	String product = "Vokab Trainer ";
	String version = "V1.0";
	String author = "Daniel, Habib und Marcel";
	
	// Definiere Titel f�r alle Sprachen (f�r Main-GUI)
	String titleDe = ("Herzlich Willkommen!");
	String titleEn = ("Welcome!");
	String titleFr = ("Bienvenue!");
	String titleIt = ("Benvenuti!");
	
	// Definiere Textinhalt f�r alle Sprachen (f�r Main-GUI)
	String contentTextDe = "";
	String contentTextEn = "";
	String contentTextFr = "";
	String contentTextIt = "";
	
	// Definiere Hilfetext f�r alle Sprachen (f�r Main-GUI)
    String helpTextDe = "In diesem Fenster wird eine einfache Hilfe angeboten."
        		    + "\nFolgende Themen werden bearbeitet:" + "\nThema1" + "\nThema2" + "\nThema3" + "\n\n";
    String helpTextEn = "In this window, a simple help is offered."
        		    + "\nThe following topics are dealt with:" + "\nTopic1"	+ "\nTopic2" + "\nTopic3" + "\n\n";
    String helpTextFr = "Dans cette fenetre, une aide simple est offert."
        		    + "\nLes sujets suivants sont traites:"	+ "\nSujet1" + "\nSujet2" + "\nSujet3" + "\n\n";
    String helpTextIt = "In questa finestra, un semplice aiuto viene offerto."
        		    + "\nI seguenti argomenti sono trattati:" + "\nArgomento1" + "\nArgomento2" + "\nArgomento3" + "\n\n";
    
    // �bersetzung des Wortes Sprache
    String languageDe = ("Sprache");
    String languageEn = ("Language");    
    String languageFr = ("Langue");
    String languageIt = ("Lingua");
    String attentionDe = ("Achtung!");
    String attentionEn = ("Attention!");    
    String attentionFr = ("Attention!");
    String attentionIt = ("Attento!");
    
    // Beschriftung der Buttons im Main-GUI
    String startDe = ("Starten");
    String startEn = ("Start");
    String startFr = ("D�but");
    String startIt = ("Inizio");
    
    String saveDe = ("Speichern");
    String saveEn = ("Save");
    String saveFr = ("Enregistrer");
    String saveIt = ("Salva");
    
    String loadDe = ("Laden");
    String loadEn = ("Load");
    String loadFr = ("Chargement");
    String loadIt = ("Caricamento");
    
    String registerDe = ("Erfassen");
    String registerEn = ("Register");
    String registerFr = ("Capture");
    String registerIt = ("Cattura");
    
    String helpDe = ("Hilfe");
    String helpEn = ("Help");
    String helpFr = ("Aidez-Moi");
    String helpIt = ("Aiuto");
    
    // Beschriften der Buttons im Work-GUI)
    String switchDe = ("Wechseln");
    String switchEn = ("Switch");
    String switchFr = ("Interrupteur");
    String switchIt = ("Interruttore");
    
    String nextDe = ("Weiter");
    String nextEn = ("Next");
    String nextFr = ("Suivant");
    String nextIt = ("Seguente");
    
    String closeDe = ("Beenden");
    String closeEn = ("Close");
    String closeFr = ("Rompre");
    String closeIt = ("Rottura");
    
    // �bersetzung f�r zur Aufforderung bei Fehlender L�sungseingabe    
    String requestDe = ("Bitte gib eine L�sung ein!");
    String requestEn = ("Please enter a solution!");
    String requestFr = ("S'il vous plait entrer une solution!");
    String requestIt = ("Inserisci una soluzione!");
    
    // �bersetzung Feedback auf korrekt oder falsche Antwort
    String feedbackNokDe1 = ("Letzte Antwort war falsch!");
    String feedbackNokDe2 = ("\n(Aufl�sung: ");
    String feedbackNokEn1 = ("Last answer was wrong!");
    String feedbackNokEn2 = ("\n(Solution: ");
    String feedbackNokFr1 = ("Derni�re r�ponse �tait fausse!");
    String feedbackNokFr2 = ("\n(Solution: ");
    String feedbackNokIt1 = ("Lltima risposta era sbagliata!");
    String feedbackNokIt2 = ("\n(Soluzione: ");
    
	// Gib aktuell Spracheinstellung
	public String getLanguage() {
		return language;
	}
	
	// Gib Software Name(Product) und Version
	public String getProduct() {
		return product;
	}
	public String getVersion() {
		return version;
	}
	
	// Setze aktuell Spracheinstellung
	public void setLanguage(String language) {
		this.language = language;
	}
	
	// Gib �bersetzung Wort Sprache
	public String getWordLanguage() {
		if(language == "de"){
			return languageDe;
		}
		if(language == "en"){
			return languageEn;
		}
		if(language == "fr"){
			return languageFr;
		}
		return languageIt;
	}
	
	// Gib �bersetzung Wort Falsch
		public String getWordAttention() {
			if(language == "de"){
				return attentionDe;
			}
			if(language == "en"){
				return attentionEn;
			}
			if(language == "fr"){
				return attentionFr;
			}
			return attentionIt;
		}
	
	// Gib �bersetzung Titel MainGUI
	public String getTitle() {
		if(language == "de"){
			return titleDe;
		}
		if(language == "en"){
			return titleEn;
		}
		if(language == "fr"){
			return titleFr;
		}
		return titleIt;
	}
	
	// Gib �bersetzung Inhalt MainGUI
	public String getContent() {
		if(language == "de"){
			return contentTextDe;
		}
		if(language == "en"){
			return contentTextEn;
		}
		if(language == "fr"){
			return contentTextFr;
		}
		return contentTextIt;
	}
	
	// Gib �bersetzung Hilfe
	public String getLangHelp() {
		if(language == "de"){
			return helpTextDe;
		}
		if(language == "en"){
			return helpTextEn;
		}
		if(language == "fr"){
			return helpTextFr;
		}
		return helpTextIt;
	}
	
	// Gib �bersetzung zur Aufforderung der L�sungseingabe
	public String getLangRequest() {
		if(language == "de"){
			return requestDe;			
		}
		if(language == "en"){
			return requestEn;			
		}
		if(language == "fr"){
			return requestFr;
		}
		else
			return requestIt;
		}
	
	// Gib �bersetzung Button start
	public String getLangBtnStart() {
		if(language == "de"){
			return startDe;			
		}
		if(language == "en"){
			return startEn;			
		}
		if(language == "fr"){
			return startFr;
		}
		else
			return startIt;
		}
	
	// Gib �bersetzung Button save
	public String getLangBtnSave() {
		if(language == "de"){
			return saveDe;			
		}
		if(language == "en"){
			return saveEn;			
		}
		if(language == "fr"){
			return saveFr;			
		}
		else
			return saveIt;
		}
	
	// Gib �bersetzung Button load
	public String getLangBtnLoad() {
		if(language == "de"){
			return loadDe;
		}
		if(language == "en"){
			return loadEn;
		}
		if(language == "fr"){
			return loadFr;
		}
		else
			return loadIt;
		}
	
	// Gib �bersetzung Button register
	public String getLangBtnRegister() {
		if(language == "de"){
			return registerDe;
		}
		if(language == "en"){
			return registerEn;
		}
		if(language == "fr"){
			return registerFr;
		}
		else
			return registerIt;
		}
	
	// Gib �bersetzung Button help
	public String getLangBtnHelp() {
		if(language == "de"){
			return helpDe;
		}
		if(language == "en"){
			return helpEn;
		}
		if(language == "fr"){
			return helpFr;
		}
		else
			return helpIt;
		}
	
	// Gib �bersetzung Button check
		public String getLangBtnSwitch() {
			if(language == "de"){
				return switchDe;			
			}
			if(language == "en"){
				return switchEn;			
			}
			if(language == "fr"){
				return switchFr;			
			}
			else
				return switchIt;			
			}
		
		// Gib �bersetzung Button next
		public String getLangBtnNext() {
			if(language == "de"){
				return nextDe;			
			}
			if(language == "en"){
				return nextEn;			
			}
			if(language == "fr"){
				return nextFr;			
			}
			else
				return nextIt;			
			}
		
		// Gib �bersetzung Button close
		public String getLangBtnClose() {
			if(language == "de"){
				return closeDe;			
			}
			if(language == "en"){
				return closeEn;			
			}
			if(language == "fr"){
				return closeFr;			
			}
			else
				return closeIt;			
			}
		
		// Gib �bersetzung falsche Antwort
		public String getLangNok1() {
			if(language == "de"){
				return feedbackNokDe1;			
			}
			if(language == "en"){
				return feedbackNokEn1;			
			}
			if(language == "fr"){
				return feedbackNokFr1;			
			}
			else
				return feedbackNokIt1;			
			}
		
		// Gib �bersetzung falsche Antwort
			public String getLangNok2() {
				if(language == "de"){
					return feedbackNokDe2;			
				}
				if(language == "en"){
					return feedbackNokEn2;			
				}
				if(language == "fr"){
					return feedbackNokFr2;			
				}
				else
					return feedbackNokIt2;			
				}
}