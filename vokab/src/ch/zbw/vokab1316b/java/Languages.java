package ch.zbw.vokab1316b.java;

import javax.swing.JOptionPane;

/**
 * Languages ist eine kleine Hilfsklasse mit Methoden zum Laden von Texten in verschiedenen Sprachen.
 * 
 * In Ihr werden saemtliche Uebersetzungen fuer die GUI-Sprachen deutsch, englisch, franzoesisch und italienisch definiert
 * und koennen via Methoden aus den GUI-Klassen MainGUI, RegisterGUI, WorkGUI und EditGUI aufgerufen werden.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */
public class Languages {
	
	// Datenfelder allgemein
	String language = "de";
	String product = "VokabTrainer";
	String version = "V1.0";
	
	String attentionDe = "Achtung!";
	String attentionEn = "Attention!";    
	String attentionFr = "Attention!";
	String attentionIt = "Attento!";
    String errorDe = "Bitte fuelle alle Felder aus!";
    String errorEn = "Please fill in all fields!";
    String errorFr = "S'il vous plaît remplir tous les champs!";
    String errorIt = "Si prega di compilare tutti i campi!";
	
	// Datenfelder allgemein Klasse MainGUI
	String titleDe = ("Herzlich Willkommen!");
	String titleEn = ("Welcome!");
	String titleFr = ("Bienvenue!");
	String titleIt = ("Benvenuti!");
	String contentDe = "";
	String contentEn = "";
	String contentFr = "";
	String contentIt = "";
	
    String helpDe = "In dieser Hilfe werden die Programmoptionen erklaert."
        		    + "\n\n<html><u>Starten</>: Hier startest du den Lernmodus, also die Wortabfrage beginnt.</html>"
        		    + "\n<html><u>Speichern</>: Diese Auswahl speichert die geladenen Woerter und den aktuellen Lernfortschritt.</html>"
        		    + "\n<html><u>Laden</>: Mittels dem Laden-Knopf kann eine zuvor gespeicherte Wortliste geladen werden.</html>"
        		    + "\n<html><u>Erfassen</>: Eigene oder zusaetzliche Woerter zum lernen erfassen.</html>"
        		    + "\n<html><u>Aendern</>: Bestehende Woerter aendern oder loeschen.</html>"
        		    + "\n\nFuer weitere Fragen bitte Mail an support@vokabtrainer.ch schicken." + "\n\n";
    String helpEn = "In this help the program options are explained."
		    		+ "\n\n<html><u>Start</>: Here you start the learning mode, so the word query begins.</html>"
		    		+ "\n<html><u>Save</>: This selection saves the loaded words and the current progress.</html>"
		    		+ "\n<html><u>Load</>: By means of the load button, a previously saved list will be loaded.</html>"
		    		+ "\n<html><u>Register</>: Own or acquire additional words to learn.</html>"
		    		+ "\n<html><u>Edit</>: Modify or delete existing words.</html>"
		    		+ "\n\nFor further questions please mail to support@vokabtrainer.ch." + "\n\n";
    String helpFr = "Dans ce aide les options du programme seront expliquées."
    				+ "\n\n<html><u>Début</>: Ici vous démarrez le mode d'apprentissage, de sorte que le mot requête commence.</html>"
    				+ "\n<html><u>Enregistrer</>: Cette sélection permet d'économiser les mots chargés et les progrès en cours.</html>"
    				+ "\n<html><u>Chargement</>: Au moyen de la touche de chargement, une liste sauvegardée auparavant sera chargé.</html>"
    				+ "\n<html><u>Capture</>: Posséder ou acquérir des mots supplémentaires à apprendre.</html>"
    				+ "\n<html><u>Changement</>: Modifier ou supprimer des mots existants.</html>"
    				+ "\n\nPour d'autres questions se il vous plaît mail à support@vokabtrainer.ch." + "\n\n";
    String helpIt = "In questo aiuto verranno spiegate le opzioni del programma."
		    		+ "\n\n<html><u>Inizio</>: Qui si avvia la modalità di apprendimento, così inizia la query di parola.</html>"
		    		+ "\n<html><u>Salva</>: Questa selezione consente di risparmiare le parole caricate e lo stato di avanzamento attuale.</html>"
		    		+ "\n<html><u>Caricamento</>: Tramite il pulsante di carico, viene caricato un elenco precedentemente salvato.</html>"
		    		+ "\n<html><u>Cattura</>: Acquistare o acquisire ulteriori parole da imparare.</html>"
		    		+ "\n<html><u>Cambiamento</>: Modificare o eliminare parole esistenti.</html>"
		    		+ "\n\nPer ulteriori domande scrivere a support@vokabtrainer.ch." + "\n\n";
    
    // Datenfelder Buttons Klasse MainGUI
    String btnStartDe = ("Starten");
    String btnStartEn = ("Start");
    String btnStartFr = ("Début");
    String btnStartIt = ("Inizio");
    String btnSaveDe = ("Speichern");
    String btnSaveEn = ("Save");
    String btnSaveFr = ("Enregistrer");
    String btnSaveIt = ("Salva");
    String btnLoadDe = ("Laden");
    String btnLoadEn = ("Load");
    String btnLoadFr = ("Chargement");
    String btnLoadIt = ("Caricamento");
    String btnRegisterDe = ("Erfassen");
    String btnRegisterEn = ("Register");
    String btnRegisterFr = ("Capture");
    String btnRegisterIt = ("Cattura");
    String btnEditDe = ("Aendern");
    String btnEditEn = ("Edit");
    String btnEditFr = ("Changement");
    String btnEditIt = ("Cambiamento");
    String btnHelpDe = ("Hilfe");
    String btnHelpEn = ("Help");
    String btnHelpFr = ("Aidez-Moi");
    String btnHelpIt = ("Aiuto");
    
    // Datenfelder allgemein Klasse RegisterGUI
    String questionDe = "Fragewort";
    String questionEn = "Question word";
    String questionFr = "Question mot";
    String questionIt = "Domanda di parola";
    String answerDe = "Uebersetzung";
    String answerEn = "Translation";
    String answerFr = "Traduction";
    String answerIt = "Traduzione";
    String langCodeDe = "Sprachcode";
    String langCodeEn = "Language code";
    String langCodeFr = "Code de langue";
    String langCodeIt = "Codice della lingua";

    // Datenfelder allgemein Klasse WorkGUI
    String feedbackNokDe1 = ("Letzte Antwort war falsch!");
    String feedbackNokDe2 = ("\n(Aufloesung: ");
    String feedbackNokEn1 = ("Last answer was wrong!");
    String feedbackNokEn2 = ("\n(Solution: ");
    String feedbackNokFr1 = ("Dernière réponse était fausse!");
    String feedbackNokFr2 = ("\n(Solution: ");
    String feedbackNokIt1 = ("Lltima risposta era sbagliata!");
    String feedbackNokIt2 = ("\n(Soluzione: ");
    
    // Datenfelder Buttons Klasse WorkGUI)
    String btnSwitchDe = ("Wechseln");
    String btnSwitchEn = ("Switch");
    String btnSwitchFr = ("Interrupteur");
    String btnSwitchIt = ("Interruttore");
    String btnNextDe = ("Weiter");
    String btnNextEn = ("Next");
    String btnNextFr = ("Suivant");
    String btnNextIt = ("Seguente");
    String btnCloseDe = ("Beenden");
    String btnCloseEn = ("Close");
    String btnCloseFr = ("Rompre");
    String btnCloseIt = ("Rottura");
    
    /**
	 * Liefere die aktuell gesetzte Spracheinstellung des GUI.
	 * Zum Beispiel "de" oder "fr".
	 * @return die aktuelle Spracheinstellung des GUI.
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Liefere den Produktename der Software im Fromat.
	 * Zum Beispiel "VokabTrainer".
	 * @return den aktuellen Namen der Software.
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * Liefere die Versionierung der Software.
	 * Zum Beispiel "V1.0".
	 * @return die aktuelle Version der Software.
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * Setze die im GUI gewaehlte Spracheinstellung.
	 * @param language die gewaehlte Spracheinstellung.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Liefere die richtige Uebersetzung zum Wort "Achtung".
	 * @return das Wort "Achtung" in der richtigen Sprache.
	 */
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
		
	/**
	 * Liefere den Titel des MainGUI in aktuell gewaehlten Spracheinstellung.
	 * Zum Beispiel: "Herzlich Willkommen!".
	 * @return den Titel des MainGUI in der richtigen Sprache.
	 */
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
	
	/**
	 * Liefere den Textinhalt des MainGUI in aktuell gewaehlten Spracheinstellung.
	 * Zum Beispiel: "Bitte waehlen Sie eine der folgenden Optionen: ".
	 * Achtung: Aktuell nur ein Platzhalter.
	 * @return den Textinhalt des MainGUI in der richtigen Sprache.
	 */
	public String getContent() {
		if(language == "de"){
			return contentDe;
		}
		if(language == "en"){
			return contentEn;
		}
		if(language == "fr"){
			return contentFr;
		}
		return contentIt;
	}
	
	/**
	 * Liefere den Hilfeinhalt des MainGUI in aktuell gewaehlten Spracheinstellung.
	 * Zum Beispiel: "In dieser Hilfe werden...".
	 * @return die Hilfe im MainGUI in der richtigen Sprache.
	 */
	public String getLangHelp() {
		if(language == "de"){
			return helpDe;
		}
		if(language == "en"){
			return helpEn;
		}
		if(language == "fr"){
			return helpFr;
		}
		return helpIt;
	}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Starten".
	 * @return die Button-Beschriftung "Starten" in der richtigen Sprache.
	 */
	public String getLangBtnStart() {
		if(language == "de"){
			return btnStartDe;			
		}
		if(language == "en"){
			return btnStartEn;			
		}
		if(language == "fr"){
			return btnStartFr;
		}
		else
			return btnStartIt;
		}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Speichern".
	 * @return die Button-Beschriftung "Speichern" in der richtigen Sprache.
	 */
	public String getLangBtnSave() {
		if(language == "de"){
			return btnSaveDe;			
		}
		if(language == "en"){
			return btnSaveEn;			
		}
		if(language == "fr"){
			return btnSaveFr;			
		}
		else
			return btnSaveIt;
		}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Laden".
	 * @return die Button-Beschriftung "Laden" in der richtigen Sprache.
	 */
	public String getLangBtnLoad() {
		if(language == "de"){
			return btnLoadDe;
		}
		if(language == "en"){
			return btnLoadEn;
		}
		if(language == "fr"){
			return btnLoadFr;
		}
		else
			return btnLoadIt;
		}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Erfassen".
	 * @return die Button-Beschriftung "Erfassen" in der richtigen Sprache.
	 */
	public String getLangBtnRegister() {
		if(language == "de"){
			return btnRegisterDe;
		}
		if(language == "en"){
			return btnRegisterEn;
		}
		if(language == "fr"){
			return btnRegisterFr;
		}
		else
			return btnRegisterIt;
		}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Aendern".
	 * @return die Button-Beschriftung "Aendern" in der richtigen Sprache.
	 */
	public String getLangBtnEdit() {
		if(language == "de"){
			return btnEditDe;
		}
		if(language == "en"){
			return btnEditEn;
		}
		if(language == "fr"){
			return btnEditFr;
		}
		else
			return btnEditIt;
		}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Hilfe".
	 * @return die Button-Beschriftung "Hilfe" in der richtigen Sprache.
	 */
	public String getLangBtnHelp() {
		if(language == "de"){
			return btnHelpDe;
		}
		if(language == "en"){
			return btnHelpEn;
		}
		if(language == "fr"){
			return btnHelpFr;
		}
		else
			return btnHelpIt;
		}
	
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Wechseln".
	 * @return die Button-Beschriftung "Wechseln" in der richtigen Sprache.
	 */
	public String getLangBtnSwitch() {
		if(language == "de"){
			return btnSwitchDe;			
		}
		if(language == "en"){
			return btnSwitchEn;			
		}
		if(language == "fr"){
			return btnSwitchFr;			
		}
		else
			return btnSwitchIt;			
		}
		
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Weiter".
	 * @return die Button-Beschriftung "Weiter" in der richtigen Sprache.
	 */
	public String getLangBtnNext() {
		if(language == "de"){
			return btnNextDe;			
		}
		if(language == "en"){
			return btnNextEn;			
		}
		if(language == "fr"){
			return btnNextFr;			
		}
		else
			return btnNextIt;			
		}
		
	/**
	 * Liefere die richtige Uebersetzung fuer den Button "Hilfe".
	 * @return die Button-Beschriftung "Hilfe" in der richtigen Sprache.
	 */
	public String getLangBtnClose() {
		if(language == "de"){
			return btnCloseDe;			
		}
		if(language == "en"){
			return btnCloseEn;			
		}
		if(language == "fr"){
			return btnCloseFr;			
		}
		else
			return btnCloseIt;			
		}
		
	/**
	 * Liefere die richtige Uebersetzung zum Satz "Letzte Antwort war falsch!".
	 * @return den Satz "Letzte Antwort war falsch!" in der richtigen Sprache.
	 */
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
	
	/**
	 * Liefere die richtige Uebersetzung zum Satz "Aufloesung: ".
	 * @return den Satz "Aufloesung: " in der richtigen Sprache.
	 */
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
	
	/**
	 * Liefere die richtige Uebersetzung zum Wort "Fragewort".
	 * @return das Wort "Fragewort" in der richtigen Sprache.
	 */
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
	
	/**
	 * Liefere die richtige Uebersetzung zum Wort "Uebersetzung".
	 * @return das Wort "Uebersetzung" in der richtigen Sprache.
	 */
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
		
	/**
	 * Liefere die richtige Uebersetzung zum Wort "Sprachcode".
	 * @return das Wort "Sprachcode" in der richtigen Sprache.
	 */
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
			
	/**
	 * Liefere die richtige Uebersetzung zum Satz "Bitte fuelle alle Felder aus!".
	 * @return den Satz "Bitte fuelle alle Felder aus!" in der richtigen Sprache.
	 */
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