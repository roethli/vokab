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
	
	// Definiere Variable f�r Spracheeinstellung
	String language = "de";
	
	// Definiere Software Details
	String product = "Vokab Trainer";
	String version = "V1.0";
	
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
    String helpTextDe = "In dieser Hilfe werden die Programmoptionen erkl�rt."
        		    + "\n\n<html><u>Starten</>: Hier startest du den Lernmodus, also die Wortabfrage beginnt.</html>"
        		    + "\n<html><u>Speichern</>: Diese Auswahl speichert die geladenen W�rter und den aktuellen Lernfortschritt.</html>"
        		    + "\n<html><u>Laden</>: Mittels dem Laden-Knopf kann eine zuvor gespeicherte Wortliste geladen werden.</html>"
        		    + "\n<html><u>Erfassen</>: Eigene oder zus�tzliche W�rter zum lernen erfassen.</html>"
        		    + "\n<html><u>�ndern</>: Bestehende W�rter �ndern oder l�schen.</html>"
        		    + "\n\nF�r weitere Fragen bitte Mail an support@vokabtrainer.ch schicken." + "\n\n";
    String helpTextEn = "In this help the program options are explained."
		    		+ "\n\n<html><u>Start</>: Here you start the learning mode, so the word query begins.</html>"
		    		+ "\n<html><u>Save</>: This selection saves the loaded words and the current progress.</html>"
		    		+ "\n<html><u>Load</>: By means of the load button, a previously saved list will be loaded.</html>"
		    		+ "\n<html><u>Register</>: Own or acquire additional words to learn.</html>"
		    		+ "\n<html><u>Edit</>: Modify or delete existing words.</html>"
		    		+ "\n\nFor further questions please mail to support@vokabtrainer.ch." + "\n\n";
    String helpTextFr = "Dans ce aide les options du programme seront expliqu�es."
    				+ "\n\n<html><u>D�but</>: Ici vous d�marrez le mode d'apprentissage, de sorte que le mot requ�te commence.</html>"
    				+ "\n<html><u>Enregistrer</>: Cette s�lection permet d'�conomiser les mots charg�s et les progr�s en cours.</html>"
    				+ "\n<html><u>Chargement</>: Au moyen de la touche de chargement, une liste sauvegard�e auparavant sera charg�.</html>"
    				+ "\n<html><u>Capture</>: Poss�der ou acqu�rir des mots suppl�mentaires � apprendre.</html>"
    				+ "\n<html><u>Changement</>: Modifier ou supprimer des mots existants.</html>"
    				+ "\n\nPour d'autres questions se il vous pla�t mail � support@vokabtrainer.ch." + "\n\n";
    String helpTextIt = "In questo aiuto verranno spiegate le opzioni del programma."
		    		+ "\n\n<html><u>Inizio</>: Qui si avvia la modalit� di apprendimento, cos� inizia la query di parola.</html>"
		    		+ "\n<html><u>Salva</>: Questa selezione consente di risparmiare le parole caricate e lo stato di avanzamento attuale.</html>"
		    		+ "\n<html><u>Caricamento</>: Tramite il pulsante di carico, viene caricato un elenco precedentemente salvato.</html>"
		    		+ "\n<html><u>Cattura</>: Acquistare o acquisire ulteriori parole da imparare.</html>"
		    		+ "\n<html><u>Cambiamento</>: Modificare o eliminare parole esistenti.</html>"
		    		+ "\n\nPer ulteriori domande scrivere a support@vokabtrainer.ch." + "\n\n";
    
    // �bersetzung der W�rter Sprache und Achtung
    String languageDe = "Sprache";
    String languageEn = "Language";    
    String languageFr = "Langue";
    String languageIt = "Lingua";
    String attentionDe = "Achtung!";
    String attentionEn = "Attention!";    
    String attentionFr = "Attention!";
    String attentionIt = "Attento!";
    
    // �bersetzungen f�r Register-GUI
    String questionDe = "Fragewort";
    String questionEn = "Question word";
    String questionFr = "Question mot";
    String questionIt = "Domanda di parola";
    String answerDe = "�bersetzung";
    String answerEn = "Translation";
    String answerFr = "Traduction";
    String answerIt = "Traduzione";
    String langCodeDe = "Sprachcode";
    String langCodeEn = "Language code";
    String langCodeFr = "Code de langue";
    String langCodeIt = "Codice della lingua";
    
    String errorDe = "Bitte f�lle alle Felder aus!";
    String errorEn = "Please fill in all fields!";
    String errorFr = "S'il vous pla�t remplir tous les champs!";
    String errorIt = "Si prega di compilare tutti i campi!";
    
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
    
    String changeDe = ("�ndern");
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
	
	// Gib �bersetzung Button change
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
		// Register-GUI: Gib �bersetzung Wort erfassen, Fragewort.
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
		// Register-GUI: Gib �bersetzung Wort erfassen, Fragewort.
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
			
		// Register-GUI: Gib �bersetzung Wort erfassen, Fragewort.
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
			
		// Register-GUI: Gib �bersetzung falsche Spracheingabe "de, en, fr, it".
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