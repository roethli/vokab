package ch.zbw.vokab1316b.java;

import ch.zbw.vokab1316b.java.Exporter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.*;

/**
 * Diese Klasse implementiert einen einfachen Start-GUI (Main-GUI).
 * Beim Erstellen der Klasse wird der MainGUI mittels Komponenten wie Labels, Textfields, Buttons, etc. aufgebaut
 * und reagiert auf User-Befehle wie z.B. das Druecken eines Buttons.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 10.03.2015
 */
public class MainGUI {

	// Instanziere Klasse WorkGUI, RegisterGUI und Languages
	WorkGUI workGUI = new WorkGUI();
	RegisterGUI registerGUI = new RegisterGUI();
	Languages languages = new Languages();
	
    // Schriftarten definieren
	Font buttonFont = new Font("arial", Font.TRUETYPE_FONT, 15);
	Font titleFont = new Font("arial", Font.BOLD, 25);
	Font contentFont = new Font("arial", Font.TRUETYPE_FONT, 12);
		
	// Bild laden
	ImageIcon picture = new ImageIcon("vokablogo.png");
    
	// Main frame
	JFrame mainFrame = new JFrame(languages.getProduct() + languages.getVersion());
	
  	// Erstellen und beschriften der Buttons
  	private JButton btnStart = new JButton(languages.getLangBtnStart());
  	private JButton btnSave = new JButton(languages.getLangBtnSave());
  	private JButton btnLoad = new JButton(languages.getLangBtnLoad());
  	private JButton btnRegister = new JButton(languages.getLangBtnRegister());
  	private JButton btnChange = new JButton(languages.getLangBtnChange());
  	private JButton btnHelp = new JButton(languages.getLangBtnHelp());
  
  	// Erstellen der Panels
  	private JPanel upperPanel = new JPanel();
  	private JPanel mainPanel = new JPanel();
  	private JPanel lowerPanel = new JPanel();
  	
  	// Erstellen der Labels
  	private JLabel lblTitle  = new JLabel(languages.getTitle());
  	private JLabel lblContent  = new JLabel(picture);
  	// private JLabel lblContent  = new JLabel(languages.getContent());
  	
  	// Deklarieren und erstellen der Combobox
    private JComboBox boxLanguage = new JComboBox(new Object[] {"de","en","fr","it"});
  	
    /**
	 * Konstruktor Klasse MainGUI
	 * 
	 * @param text 
	 * @return text
	 */
    public MainGUI() {
    	
    	// Layout Einstellungen für Frame und Panels
  		mainFrame.setTitle(languages.getProduct() + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setSize(800, 600);
    	mainPanel.setLayout(new BorderLayout(25, 25));
    	upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	
    	// Schriftart für Buttons und Labels definieren
    	btnStart.setFont(buttonFont);
    	btnSave.setFont(buttonFont);
    	btnLoad.setFont(buttonFont);
    	btnRegister.setFont(buttonFont);
    	btnChange.setFont(buttonFont);
    	btnHelp.setFont(buttonFont);
    	lblContent.setFont(contentFont);
    	lblTitle.setFont(titleFont);
    	
    	
    	// Labels Layout konfigurieren
    	lblContent.setText(languages.getContent());
    	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	lblContent.setHorizontalAlignment(SwingConstants.CENTER);
    	  	
    	// Listener für alle Buttons und die Sprachbox erstellen
    	btnStart.addActionListener(new ButtonListener());
    	btnSave.addActionListener(new ButtonListener());
    	btnLoad.addActionListener(new ButtonListener());
    	btnRegister.addActionListener(new ButtonListener());
    	btnChange.addActionListener(new ButtonListener());
    	btnHelp.addActionListener(new ButtonListener());
    	boxLanguage.addActionListener(new ComboboxListener());
    	
		// Testkarten hinzufuegen
    	final Logic logic = new Logic().getInstance();
		logic.addCard("haus", "house", 1, "de", "en");
		logic.addCard("spiel", "game", 1, "de", "en");

  	}
    
	// Zusammenbauen und anzeigen des Main-GUI.
  	public void paint(){
  		
  	    // GUI zentral im Bildschirm setzen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
        
  	    // Platziert die Elemente in den Panels
  		upperPanel.add(boxLanguage);
    	mainPanel.add(lblTitle);
    	mainPanel.add(lblContent);
    	mainPanel.add(lblTitle, BorderLayout.NORTH);
		mainPanel.add(lblContent, BorderLayout.CENTER);
		lowerPanel.add(btnStart);
    	lowerPanel.add(btnSave);
    	lowerPanel.add(btnLoad);
    	lowerPanel.add(btnRegister);
    	lowerPanel.add(btnChange);
    	lowerPanel.add(btnHelp);
		
    	// Alle Panels dem Frame hinzufügen und Layout bestimmen
	    mainFrame.add(upperPanel, BorderLayout.NORTH);
	    mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.add(lowerPanel, BorderLayout.SOUTH);
	    
  	}

	// Listener für Buttons.
	// Startet Lern-GUI, In- oder Exportiert Karteikarten, startet Erfassen-GUI und ruft Hilfe auf.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Wird aufgerufen, wenn der Help Button gedrückt wird
			if (e.getSource() == btnHelp){
				getHelp();
			}
			// Wird aufgerufen, wenn der Starten Button gedrückt wird
			if (e.getSource() == btnStart){
				workGUI.paint(languages.getLanguage());
				workGUI.setFocus();
			}
			// Wird aufgerufen, wenn der Erfassen Button gedrückt wird
			if (e.getSource() == btnRegister) {
				registerGUI.paint(languages.getLanguage());
				registerGUI.setFocus();
			}
			// Wird aufgerufen, wenn der Ändern Button gedrückt wird
						if (e.getSource() == btnChange) {
							//Text
						}
			// Wird aufgerufen, wenn der Speichern Button gedrückt wird
			if (e.getSource() == btnSave) {

				// Neuen File Dialog instanzieren
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(mainFrame);
				// user hat 'save' im File Dialog geklickt
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					// eine File-Instanz erzeugen mit dem Pfad, der vom 
					// File Dialog zurück gegeben wurde
					File file = fc.getSelectedFile();
					System.out.println("Saving: " + file.getName() + ".");

					// Logic-Instance abholen durch Aufruf der getInstance()-Singleton-Methode
					final Logic logic = new Logic().getInstance();					

					// Instanz der Exporter-Klasse erzeugen
					Exporter ex = new Exporter();

					// Alle Vocabulary-Objekte exportieren, Liste dazu von Logic-Instanz holen
					ex.exportToFile(logic.getVocabularylist(), file);
				}
				else {
					// Benutzer hat im File Dialog auf 'cancel' geklickt
					System.out.println("Save command cancelled by user.");
				}
			}
			// Wird aufgerufen, wenn der Laden Button gedrückt wird
			else if (e.getSource() == btnLoad) {

				// neuer File-Dialog wird instanziert
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(mainFrame);

				// Benutzer hat im File-Dialog auf 'open' geklickt
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// eine File-Instanz erzeugen mit dem Pfad, der vom 
					// File Dialog zurück gegeben wurde					
					File file = fc.getSelectedFile();
					// Resultat ausgeben (nur für's Debugging)
					System.out.println("Opening: " + file.getName() + ".");

					// Logic-Instance abholen durch Aufruf der getInstance()-Singleton-Methode
					final Logic logic = new Logic().getInstance();

					// Importer-Instanz erzeugen
					Importer imp = new Importer();

					// Vocabulary-Liste ersetzen in der Logik durch die ArrayList, welche
					// vom Importer zurück gegeben wird.
					logic.setVocabularylist(imp.importFromFile(file));
				}
				// Benutzer hat auf 'cancel' geklickt
				else {
					System.out.println("Open command cancelled by user.");
				}
			}
		}
	}
	
	// Listener für Sprachauswahl.
	// Setzt die in der Combobox gewählte Sprache.
	class ComboboxListener implements ActionListener {
		// Wird aufgerufen, when der 'Help'-Button angeklickt wird
		public void actionPerformed(ActionEvent e) {
			String selectedItem = (String)boxLanguage.getSelectedItem();
			if(selectedItem.equals("de")) {
				languages.setLanguage("de");
				setLang();
			}
			else if(selectedItem.equals("en")) {
				languages.setLanguage("en");
				setLang();
			}
			else if(selectedItem.equals("fr")) {
				languages.setLanguage("fr");
				setLang();
			}
			else if(selectedItem.equals("it")) {
				languages.setLanguage("it");
				setLang();
			}
		}
	}
	
  	// Methode setzt die via Combobox gewählte Sprache
  	private void setLang() {
    	lblTitle.setText(languages.getTitle());
    	lblContent.setText(languages.getContent());
    	btnStart.setText(languages.getLangBtnStart());
    	btnSave.setText(languages.getLangBtnSave());
    	btnLoad.setText(languages.getLangBtnLoad());
    	btnRegister.setText(languages.getLangBtnRegister());
    	btnChange.setText(languages.getLangBtnChange());
    	btnHelp.setText(languages.getLangBtnHelp());
    	System.out.println(languages.getLanguage());
    }
  	
    // Methode zum anzeigen der Hilfefunktion
    private void getHelp() {
        JOptionPane.showMessageDialog(mainFrame, languages.getLangHelp(), languages.getLangBtnHelp() + "!", JOptionPane.QUESTION_MESSAGE);
    }
	
  	/**
  	 * Main method to start the application
  	 */
	public static void main(String[] args) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		MainGUI gui = new MainGUI();
		gui.paint();
	}  	
}
