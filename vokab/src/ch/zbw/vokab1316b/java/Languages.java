package ch.zbw.vokab1316b.java;

import javax.swing.JOptionPane;
// TODO GUI Sprachen auslagern 

/**
 * Diese Klasse dient als reine Hilfsklasse.
 * In Ihr werden saemtliche Uebersetzungen fuer die GUI-Sprachen deutsch, englisch, franzoesisch und italienisch definiert
 * und koennen via Methoden aus den GUI-Klassen MainGUI, RegisterGUI, WorkGUI und EditGUI aufgerufen werden.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 10.03.2015
 */
public class Languages {
	
	// Definiere Variable für Spracheeinstellung
	String language = "de";
	
	// Definiere Software Details
	String product = "Vokab Trainer";
	String version = "V1.0";
	
	// Definiere Titel für alle Sprachen (für Main-GUI)
	String titleDe = ("Herzlich Willkommen!");
	String titleEn = ("Welcome!");
	String titleFr = ("Bienvenue!");
	String titleIt = ("Benvenuti!");
	
	// Definiere Textinhalt für alle Sprachen (für Main-GUI)
	String contentTextDe = "";
	String contentTextEn = "";
	String contentTextFr = "";
	String contentTextIt = "";
	
	// Definiere Hilfetext für alle Sprachen (für Main-GUI)
    String helpTextDe = "In dieser Hilfe werden die Programmoptionen erklärt."
        		    + "\n\n<html><u>Starten</>: Hier startest du den Lernmodus, also die Wortabfrage beginnt.</html>"
        		    + "\n<html><u>Speichern</>: Diese Auswahl speichert die geladenen Wörter und den aktuellen Lernfortschritt.</html>"
        		    + "\n<html><u>Laden</>: Mittels dem Laden-Knopf kann eine zuvor gespeicherte Wortliste geladen werden.</html>"
        		    + "\n<html><u>Erfassen</>: Eigene oder zusätzliche Wörter zum lernen erfassen.</html>"
        		    + "\n<html><u>Ändern</>: Bestehende Wörter ändern oder löschen.</html>"
        		    + "\n\nFür weitere Fragen bitte Mail an support@vokabtrainer.ch schicken." + "\n\n";
    String helpTextEn = "In this help the program options are explained."
		    		+ "\n\n<html><u>Start</>: Here you start the learning mode, so the word query begins.</html>"
		    		+ "\n<html><u>Save</>: This selection saves the loaded words and the current progress.</html>"
		    		+ "\n<html><u>Load</>: By means of the load button, a previously saved list will be loaded.</html>"
		    		+ "\n<html><u>Register</>: Own or acquire additional words to learn.</html>"
		    		+ "\n<html><u>Edit</>: Modify or delete existing words.</html>"
		    		+ "\n\nFor further questions please mail to support@vokabtrainer.ch." + "\n\n";
    String helpTextFr = "Dans ce aide les options du programme seront expliquées."
    				+ "\n\n<html><u>Début</>: Ici vous démarrez le mode d'apprentissage, de sorte que le mot requête commence.</html>"
    				+ "\n<html><u>Enregistrer</>: Cette sélection permet d'économiser les mots chargés et les progrès en cours.</html>"
    				+ "\n<html><u>Chargement</>: Au moyen de la touche de chargement, une liste sauvegardée auparavant sera chargé.</html>"
    				+ "\n<html><u>Capture</>: Posséder ou acquérir des mots supplémentaires à apprendre.</html>"
    				+ "\n<html><u>Changement</>: Modifier ou supprimer des mots existants.</html>"
    				+ "\n\nPour d'autres questions se il vous plaît mail à support@vokabtrainer.ch." + "\n\n";
    String helpTextIt = "In questo aiuto verranno spiegate le opzioni del programma."
		    		+ "\n\n<html><u>Inizio</>: Qui si avvia la modalità di apprendimento, così inizia la query di parola.</html>"
		    		+ "\n<html><u>Salva</>: Questa selezione consente di risparmiare le parole caricate e lo stato di avanzamento attuale.</html>"
		    		+ "\n<html><u>Caricamento</>: Tramite il pulsante di carico, viene caricato un elenco precedentemente salvato.</html>"
		    		+ "\n<html><u>Cattura</>: Acquistare o acquisire ulteriori parole da imparare.</html>"
		    		+ "\n<html><u>Cambiamento</>: Modificare o eliminare parole esistenti.</html>"
		    		+ "\n\nPer ulteriori domande scrivere a support@vokabtrainer.ch." + "\n\n";
    
    // Übersetzung der Wörter Sprache und Achtung
    String languageDe = "Sprache";
    String languageEn = "Language";    
    String languageFr = "Langue";
    String languageIt = "Lingua";
    String attentionDe = "Achtung!";
    String attentionEn = "Attention!";    
    String attentionFr = "Attention!";
    String attentionIt = "Attento!";
    
    // Übersetzungen für Register-GUI
    String questionDe = "Fragewort";
    String questionEn = "Question word";
    String questionFr = "Question mot";
    String questionIt = "Domanda di parola";
    String answerDe = "Übersetzung";
    String answerEn = "Translation";
    String answerFr = "Traduction";
    String answerIt = "Traduzione";
    String langCodeDe = "Sprachcode";
    String langCodeEn = "Language code";
    String langCodeFr = "Code de langue";
    String langCodeIt = "Codice della lingua";
    
    String errorDe = "Bitte fülle alle Felder aus!";
    String errorEn = "Please fill in all fields!";
    String errorFr = "S'il vous plaît remplir tous les champs!";
    String errorIt = "Si prega di compilare tutti i campi!";
    
    // Beschriftung der Buttons im Main-GUI
    String startDe = ("Starten");
    String startEn = ("Start");
    String startFr = ("Début");
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
    
    String changeDe = ("Ändern");
    String changeEn = ("Edit");
    String changeFr = ("Changement");
    String changeIt = ("Cambiamento");
    
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
    
    // Übersetzung für zur Aufforderung bei Fehlender Lösungseingabe    
    String requestDe = ("Bitte gib eine Lösung ein!");
    String requestEn = ("Please enter a solution!");
    String requestFr = ("S'il vous plait entrer une solution!");
    String requestIt = ("Inserisci una soluzione!");
    
    // Übersetzung Feedback auf korrekt oder falsche Antwort
    String feedbackNokDe1 = ("Letzte Antwort war falsch!");
    String feedbackNokDe2 = ("\n(Auflösung: ");
    String feedbackNokEn1 = ("Last answer was wrong!");
    String feedbackNokEn2 = ("\n(Solution: ");
    String feedbackNokFr1 = ("Dernière réponse était fausse!");
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
	
	// Gib Übersetzung Wort Sprache
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
	
	// Gib Übersetzung Wort Falsch
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
	
	// Gib Übersetzung Titel MainGUI
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
	
	// Gib Übersetzung Inhalt MainGUI
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
	
	// Gib Übersetzung Hilfe
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
	
	// Gib Übersetzung zur Aufforderung der Lösungseingabe
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
	
	// Gib Übersetzung Button start
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
	
	// Gib Übersetzung Button save
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
	
	// Gib Übersetzung Button load
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
	
	// Gib Übersetzung Button register
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
	
	// Gib Übersetzung Button change
		public String getLangBtnChange() {
			if(language == "de"){
				return changeDe;
			}
			if(language == "en"){
				return changeEn;
			}
			if(language == "fr"){
				return changeFr;
			}
			else
				return changeIt;
			}
	
	// Gib Übersetzung Button help
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
	
	// Gib Übersetzung Button check
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
		
		// Gib Übersetzung Button next
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
		
		// Gib Übersetzung Button close
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
		
		// Gib Übersetzung falsche Antwort
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
		
		// Gib Übersetzung falsche Antwort
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
		// Register-GUI: Gib Übersetzung Wort erfassen, Fragewort.
			public String getLangQuestion() {
				if(language == "de"){
					return questionDe;			
				}
				if(language == "en"){
					return questionEn;			
				}
				if(language == "fr"){
					return questionFr;			
				}
				else
					return questionIt;			
				}
		// Register-GUI: Gib Übersetzung Wort erfassen, Fragewort.
			public String getLangAnswer() {
				if(language == "de"){
					return answerDe;			
				}
				if(language == "en"){
					return answerEn;			
				}
				if(language == "fr"){
					return answerFr;			
				}
				else
					return answerIt;			
				}
			
		// Register-GUI: Gib Übersetzung Wort erfassen, Fragewort.
			public String getLangCode() {
				if(language == "de"){
					return langCodeDe;			
				}
				if(language == "en"){
					return langCodeEn;			
				}
				if(language == "fr"){
					return langCodeFr;			
				}
				else
					return langCodeIt;			
				}
			
		// Register-GUI: Gib Übersetzung falsche Spracheingabe "de, en, fr, it".
			public String getInputError() {
				if(language == "de"){
					return errorDe;			
				}
				if(language == "en"){
					return errorEn;			
				}
				if(language == "fr"){
					return errorFr;			
				}
				else
					return errorIt;			
				}
}