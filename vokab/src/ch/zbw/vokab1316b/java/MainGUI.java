package ch.zbw.vokab1316b.java;

import ch.zbw.vokab1316b.java.Exporter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
 * This class implements a simple learning main GUI. When creating a new object of this
 * class the GUI components, such as buttons, labels, etc. are displayed and
 * react on user actions, such as pressing a button.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 02.02.2015
 */
public class MainGUI{
	
	WorkGUI workGui = new WorkGUI();
	
	// Main frame
	JFrame mainFrame;
	
	// Klassenvariabeln
	String language = "de";
	
	// Set welcome text
	String welcometext1DE = ("<html><body><h1><strong>Herzlich Willkommen zum Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2DE = ("<html><body><h3>Bitte waehle wie du weiter vorgehen moechtest:</h3><br><br>"
	    	+ "Starten: Hiermit startest du das Lernprogramm Vokab V1.0<br>"
	    	+ "Speichern\\Laden: Laden oder speichern von Karteien!<br>"
	    	+ "Erfassen: Hinzufuegen von Lernkarteien!<br>"
	    	+ "Hilfe: Kurzhilfe zu den wichtigesten Themen</body></html>");
	
	String welcometext1EN = ("<html><body><h1><strong>Welcome to Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2EN = ("<html><body><br> Please choose how you want to proceed further:<br><br></body></html>");
	
	String welcometext1FR = ("<html><body><h1><strong>Bienvenue � Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2FR = ("<html><body><br> S'il vous pla�t choisir la fa�on dont vous voulez aller plus loin:<br><br></body></html>");
	
	String welcometext1IT = ("<html><body><h1><strong>Benvenuti a Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2IT = ("<html><body><br>Si prega di scegliere come si vuole procedere ulteriormente:<br><br></body></html>");
	
  	// Declare key buttons
  	private JButton btnStart;
  	private JButton btnSave;
  	private JButton btnLoad;
  	private JButton btnRegister;
  	private JButton btnHelp;
  
  	// Declare panels
  	private JPanel upperPanel;
  	private JPanel mainPanel;
  	private JPanel lowerPanel;
  	
  	// Declare label
  	private JLabel lblTitle;
  	private JLabel lblContent;
  	
  	// Declare and create combobox
    private JComboBox languagebox = new JComboBox(new Object[] {"de","en","fr","it"});
  	
    // Get languagestatus
	public String getLanguagestatus() {
		return language;
	}

	// Set languagestatus
	public void setLanguagestatus(String languagestatus) {
		this.language = languagestatus;
	}

	public MainGUI() {
  		// Main frame
  		mainFrame = new JFrame("Vokabel Trainer V1.0");
  		
  		// Create key buttons
  	  	btnStart = new JButton("Starten");
  	  	btnSave = new JButton("Speichern");
  	    btnLoad = new JButton("Laden");
  	    btnRegister = new JButton("Erfassen");
  	    btnHelp = new JButton("Hilfe");
  	  
  	  	// Create other GUI elements
  	  	lblTitle = new JLabel();
  	  	lblContent = new JLabel();
  	  	
  	  	// Create panels
  	  	upperPanel = new JPanel();
  	  	mainPanel = new JPanel();
  	  	lowerPanel = new JPanel();
  	}
  	
  	// Assembles and displays the GUI.
  	public void paint(){
  		
    	// Initialise frame and GUI elements
  		mainFrame.setTitle("Vokabel Trainer V1.0");
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	lblContent.setHorizontalAlignment(SwingConstants.CENTER);
    
    	// Set layout of all panels and frames
    	//mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setLayout(new BorderLayout(25, 25));
		upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		    	
    	// Set design and content of JLabel welcomescreen	
    	Border border = LineBorder.createBlackLineBorder();
    	lblTitle.setText(welcometext1DE);
    	lblTitle.setBorder(border);
    	lblContent.setText(welcometext2DE);
    	lblContent.setBorder(border);
    	
    	// Listener
    	btnStart.addActionListener(new ButtonListener());
    	btnSave.addActionListener(new ButtonListener());
    	btnLoad.addActionListener(new ButtonListener());
    	btnRegister.addActionListener(new ButtonListener());
    	btnHelp.addActionListener(new ButtonListener());
    	languagebox.addActionListener(new ComboboxListener());
    	  	
    	// Add buttons to lowerPanel
    	lowerPanel.add(btnStart);
    	lowerPanel.add(btnSave);
    	lowerPanel.add(btnLoad);
    	lowerPanel.add(btnRegister);
    	lowerPanel.add(btnHelp);
    	
    	// Add label to mainPanel
    	mainPanel.add(lblTitle);
    	mainPanel.add(lblContent);
    	
    	// Add combobox to upperPanel
    	upperPanel.add(languagebox);
    	
		// Assemble welcome screens to mainPanel
		mainPanel.add(lblTitle, BorderLayout.NORTH);
		mainPanel.add(lblContent, BorderLayout.CENTER);
		

	    // Add all panels to frame
	    mainFrame.add(upperPanel, BorderLayout.NORTH);
	    mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.add(lowerPanel, BorderLayout.SOUTH);
	    mainFrame.setSize(800, 600);
	    
        // Set window into the the middle of screen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
  	}
  	
    //Help window in different languages
    private void showHelpDE()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In diesem Fenster wird eine einfache Hilfe angeboten."
        		    + "\nFolgende Themen werden bearbeitet:" + "\nThema1" + "\nThema2" + "\nThema3" + "\n"
        	    	+ "\nSprache: " + language,
        	    	"Hilfe!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpEN()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In this window, a simple help is offered."
        		    + "\nThe following topics are dealt with:" + "\nTopic1"	+ "\nTopic2" + "\nTopic3" + "\n"
        	    	+ "\nLanguage: " + language,
        	    	"Help!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpFR()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "Dans cette fen�tre, une aide simple est offert."
        		    + "\nLes sujets suivants sont abord�s:"	+ "\nSujet1" + "\nSujet2" + "\nSujet3" + "\n"
        	    	+ "\nLangue: " + language,
        	    	"Aidez!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpIT()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In questa finestra, un semplice aiuto viene offerto."
        		    + "\nI seguenti argomenti sono trattati:" + "\nArgomento1" + "\nArgomento2" + "\nArgomento3" + "\n"
        	    	+ "\nLingua: " + language,
        	    	"Aiuto!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    
    //Method to change language to german
    private void changeLanguageDE()
    {
    	lblTitle.setText(welcometext1DE);
    	lblContent.setText(welcometext2DE);
    	btnStart.setText("Starten");
    	btnSave.setText("Speichern");
    	btnLoad.setText("Laden");
    	btnRegister.setText("Erfassen");
    	btnHelp.setText("Hilfe");
    	language = "de";
    }
    
    //Method to change language to english
    private void changeLanguageEN()
    {
    	lblTitle.setText(welcometext1EN);
    	lblContent.setText(welcometext2EN);
    	btnStart.setText("Start");
    	btnSave.setText("Save");
    	btnLoad.setText("Load");
    	btnRegister.setText("Register");
    	btnHelp.setText("Help");
    	language = "en";
    }
    
    //Method to change language to french
    private void changeLanguageFR()
    {
    	lblTitle.setText(welcometext1FR);
    	lblContent.setText(welcometext2FR);
    	btnStart.setText("D�marrer");
    	btnSave.setText("Sauver");
    	btnLoad.setText("Charge");
    	btnRegister.setText("Saisie");
    	btnHelp.setText("Aidez");
    	language = "fr";
    }
    
    //Method to change language to italian
    private void changeLanguageIT()
    {
    	lblTitle.setText(welcometext1IT);
    	lblContent.setText(welcometext2IT);
    	btnStart.setText("Inizio");
    	btnSave.setText("Salvare");
    	btnLoad.setText("Carico");
    	btnRegister.setText("Cattura");
    	btnHelp.setText("Aiuto");
    	language = "it";
    }

	// Declare listener class for buttons
	class ButtonListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnHelp){
				if(e.getActionCommand().equals("Hilfe")) showHelpDE();
				else if(e.getActionCommand().equals("Help")) showHelpEN();
				else if(e.getActionCommand().equals("Aidez")) showHelpFR();
				else if(e.getActionCommand().equals("Aiuto")) showHelpIT();
			}
			if (e.getSource() == btnStart){
				if(e.getActionCommand().equals("Starten")) workGui.paint();
				else if(e.getActionCommand().equals("Start")) workGui.paint();
				else if(e.getActionCommand().equals("D�marrer")) workGui.paint();
				else if(e.getActionCommand().equals("Inizio")) workGui.paint();
			}
			if (e.getSource() == btnSave) {

				// instantiate a new file dialog
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(mainFrame);
				// user clicked 'save' in file dialog
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					// instantiate file from path returned from file dialog
					File file = fc.getSelectedFile();
					System.out.println("Saving: " + file.getName() + ".");

					// get instance of VocabLogik by calling getInstance-singleton-method
					final Logic logic = new Logic().getInstance();

					// adding some dummy-Vocabulary-objects to verify exporting works the way we expect it to 
					logic.addCard("Hallo", "hello", 1, "de", "en");
					logic.addCard("Nein", "no", 2, "de", "en");
					logic.addCard("Tier", "animal", 3, "de", "en");
					logic.addCard("Hund", "dog", 4, "de", "en");
					logic.addCard("Katze", "cat", 5, "de", "en");
					

					// create instance of Exporter
					Exporter ex = new Exporter();

					// export all vocabs, get list from logic
					ex.exportToFile(logic.getVocabularylist(), file);
				}
				else {
					// user clicked on 'cancel' in file dialog
					System.out.println("Save command cancelled by user.");
				}
			}
			else if (e.getSource() == btnLoad) {

				// instantiate a new file dialog
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(mainFrame);

				// user clicked 'open' in file dialog
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// create instance of file using path returned from file dialog
					File file = fc.getSelectedFile();
					// output result (just for debugging purposes)
					System.out.println("Opening: " + file.getName() + ".");

					// get instance of VocabLogik by calling getInstance-singleton-method
					final Logic logic = new Logic().getInstance();

					// create instance of Importer
					Importer imp = new Importer();

					// replace vocab-list in logic by arraylist returned from Importer 
					logic.setVocabularylist(imp.importFromFile(file));
				}
				// user clicked 'cancel'
				else {
					System.out.println("Open command cancelled by user.");
				}
			}
			else if (e.getSource() == btnRegister) {
				System.out.println("erfassen");
			}
		}
	}
	
	// Declare listener class for combobox
	class ComboboxListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
			String selectedItem = (String)languagebox.getSelectedItem();
			if(selectedItem.equals("de")) {
				changeLanguageDE();
			}
			else if(selectedItem.equals("en")) {
				changeLanguageEN();
			}
			else if(selectedItem.equals("fr")) {
				changeLanguageFR();
			}
			else if(selectedItem.equals("it")) {
				changeLanguageIT();
			}
		}
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
