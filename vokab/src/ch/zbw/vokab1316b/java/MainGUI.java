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
 * Diese Klasse implementiert ein System zum erlernen von Vokabeln. Das System kommuniziert mit dem Benutzer ueber den GUI (MainGUI).
 * Diese Klasse benutzt ein Exemplar der Klasse WorkGUI und RegisterGUI, um aus dem Startprogramm das Lernprogramm und das Programm
 * zum erfassen von neuen Vokabeln zu oeffnen. Ebenfalls benutzt diese Klasse eine Klasse Languages, von der alle Sprachuebersetzungen
 * bezogen werden.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */
public class MainGUI {

	// Datenfelder
	Languages languages = new Languages();
    JFrame mainFrame = new JFrame();
	
    private JButton btnStart = new JButton(languages.getLangBtnStart());
  	private JButton btnSave = new JButton(languages.getLangBtnSave());
  	private JButton btnLoad = new JButton(languages.getLangBtnLoad());
  	private JButton btnRegister = new JButton(languages.getLangBtnRegister());
  	private JButton btnChange = new JButton(languages.getLangBtnEdit());
  	private JButton btnHelp = new JButton(languages.getLangBtnHelp());
  
  	private JPanel northPanel = new JPanel();
  	private JPanel centerPanel = new JPanel();
  	private JPanel southPanel = new JPanel();
  	
  	private JLabel lblTitle  = new JLabel(languages.getTitle());
  	ImageIcon picture = new ImageIcon(getClass().getResource("/ch/zbw/vokab1316b/java/vokablogo.png"));
  	private JLabel lblContent  = new JLabel(picture);
  	
    private JComboBox boxLanguage = new JComboBox(new Object[] {"de","en","fr","it"});
    
    // Definiere Schriftarten fuer Buttons und Texte
 	Font buttonFont = new Font("arial", Font.TRUETYPE_FONT, 15);
 	Font titleFont = new Font("arial", Font.BOLD, 25);
 	Font contentFont = new Font("arial", Font.TRUETYPE_FONT, 12);
 		
 	
 	/**
     * Erzeuge einen Hauptschirm (MainGUI) und zeige seine GUI auf
     * dem Bildschirm an.
     */
    public MainGUI() {
    	
    	// MainGUI Design und Einstellungen
  		mainFrame.setTitle(languages.getProduct() + " " + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setSize(800, 600);
    	centerPanel.setLayout(new BorderLayout(25, 25));
    	northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	
    	btnStart.setFont(buttonFont);
    	btnSave.setFont(buttonFont);
    	btnLoad.setFont(buttonFont);
    	btnRegister.setFont(buttonFont);
    	btnChange.setFont(buttonFont);
    	btnHelp.setFont(buttonFont);
    	lblContent.setFont(contentFont);
    	lblTitle.setFont(titleFont);
    	
    	lblContent.setText(languages.getContent());
    	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	lblContent.setHorizontalAlignment(SwingConstants.CENTER);
    	  	
    	// Listener fuer die Buttons und Combobox erstellen
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
		logic.addCard("strasse", "street", 1, "de", "en");
  	}
    
	/**
	 *  Zusammenbauen und anzeigen des MainGUI.
	 */
  	public void paint(){
  		
  	    // Bildschirmaufloesung berechnen und dann GUI zentral ausrichten
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
        
  	    // Baut GUI zusammen.
  		northPanel.add(boxLanguage);
    	centerPanel.add(lblTitle);
    	centerPanel.add(lblContent);
    	centerPanel.add(lblTitle, BorderLayout.NORTH);
		centerPanel.add(lblContent, BorderLayout.CENTER);
		southPanel.add(btnStart);
    	southPanel.add(btnSave);
    	southPanel.add(btnLoad);
    	southPanel.add(btnRegister);
    	southPanel.add(btnChange);
    	southPanel.add(btnHelp);
		
	    mainFrame.add(northPanel, BorderLayout.NORTH);
	    mainFrame.add(centerPanel, BorderLayout.CENTER);
	    mainFrame.add(southPanel, BorderLayout.SOUTH);
  	}

	// Listener fuer Buttons.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Wird aufgerufen, wenn der Hilfe Button gedrueckt wird
			if (e.getSource() == btnHelp){
				getHelp();
			}
			// Wird aufgerufen, wenn der Starten Button gedrueckt wird
			if (e.getSource() == btnStart){
				WorkGUI workGUI = new WorkGUI();
				workGUI.paint(languages.getLanguage());
				workGUI.setFocus();
			}
			// Wird aufgerufen, wenn der Erfassen Button gedrueckt wird
			if (e.getSource() == btnRegister) {
				RegisterGUI registerGUI = new RegisterGUI();
				registerGUI.paint(languages.getLanguage());
				registerGUI.setFocus();
			}
			// Wird aufgerufen, wenn der aendern Button gedrueckt wird
		    if (e.getSource() == btnChange) {
		    	EditGUI editGUI = new EditGUI();
		    	editGUI.paint(languages.getLanguage());
		    	editGUI.setFocus();
		    	
//				Success overview = new Success();
//	            overview.setVisible(true);
//	            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//			      overview.setLocation(d.width/2 - overview.getWidth()/2, d.height/2 - overview.getHeight()/2);
			}
			// Wird aufgerufen, wenn der Speichern Button gedrueckt wird
			if (e.getSource() == btnSave) {

				// Neuen File Dialog instanzieren
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(mainFrame);
				// user hat Speichern im File Dialog geklickt
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					// eine File-Instanz erzeugen mit dem Pfad, der vom File Dialog zurueck gegeben wurde
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
					// Benutzer hat im File Dialog auf abbrechen geklickt
					System.out.println("Save command cancelled by user.");
				}
			}
			// Wird aufgerufen, wenn der Laden Button gedrueckt wird
			else if (e.getSource() == btnLoad) {
				
				// neuer File-Dialog wird instanziert
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(mainFrame);

				// Benutzer hat im File-Dialog auf oeffnen geklickt
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// eine File-Instanz erzeugen mit dem Pfad, der vom 
					// File Dialog zurueck gegeben wurde					
					File file = fc.getSelectedFile();
					// Resultat ausgeben (nur fuer's Debugging)
					System.out.println("Opening: " + file.getName() + ".");

					// Logic-Instance abholen durch Aufruf der getInstance()-Singleton-Methode
					final Logic logic = new Logic().getInstance();

					// Importer-Instanz erzeugen
					Importer imp = new Importer();

					// Vocabulary-Liste ersetzen in der Logik durch die ArrayList, welche vom Importer zurueck gegeben wird.
					logic.setVocabularylist(imp.importFromFile(file));
				}
				// Benutzer hat auf abbrechen geklickt
				else {
					System.out.println("Open command cancelled by user.");
				}
			}
		}
	}
	
	// Listener fuer Sprachauswahl. Setzt die in der Combobox gewaehlte Sprache.
	class ComboboxListener implements ActionListener {
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
	
  	/**
	* Aendert die Beschriftung der Labels und Buttons auf die gewaehlte Sprache.
	* Uebersetzungen werden aus der Hilfsklasse Languages geholt.
	*/
  	private void setLang() {
    	lblTitle.setText(languages.getTitle());
    	lblContent.setText(languages.getContent());
    	btnStart.setText(languages.getLangBtnStart());
    	btnSave.setText(languages.getLangBtnSave());
    	btnLoad.setText(languages.getLangBtnLoad());
    	btnRegister.setText(languages.getLangBtnRegister());
    	btnChange.setText(languages.getLangBtnEdit());
    	btnHelp.setText(languages.getLangBtnHelp());
    }
  	
    /**
     * Das Hilfe-Menue erzeugen.
     * Erscheint als Popup Fenster.
     */
    private void getHelp() {
        JOptionPane.showMessageDialog(mainFrame, languages.getLangHelp(), languages.getLangBtnHelp() + "!", JOptionPane.QUESTION_MESSAGE);
    }
	
    /**
  	 * Hauptmethode um das Program selbstaendig zu starten.
  	 * @param args arguments
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
