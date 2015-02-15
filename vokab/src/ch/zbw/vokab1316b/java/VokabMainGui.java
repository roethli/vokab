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
 * This class implements a simple phone GUI. When creating a new object of this
 * class the GUI components, such as buttons, labels, etc. are displayed and
 * react on user actions, such as pressing a button.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 02.02.2015
 */
public class VokabMainGui{
	
	VokabWorkGui workGui = new VokabWorkGui();
	
	// Main frame
	JFrame mainFrame;
	
	// Klassenvariabeln
	String languagestatus = "de";
	
	// Set welcome text
	String welcometext1DE = ("<html><body><h1><strong>Herzlich Willkommen zum Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2DE = ("<html><body><h3>Bitte w�hle wie du weiter vorgehen m�chtest:</h3><br><br>"
	    	+ "Starten: Hiermit startest du das Lernprogramm Vokab V1.0<br>"
	    	+ "Speichern\\Laden: Laden oder speichern von Karteien!<br>"
	    	+ "Erfassen: Hinzuf�gen von Lernkarteien!<br>"
	    	+ "Hilfe: Kurzhilfe zu den wichtigesten Themen</body></html>");
	
	String welcometext1EN = ("<html><body><h1><strong>Welcome to Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2EN = ("<html><body><br> Please choose how you want to proceed further:<br><br></body></html>");
	
	String welcometext1FR = ("<html><body><h1><strong>Bienvenue � Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2FR = ("<html><body><br> S'il vous pla�t choisir la fa�on dont vous voulez aller plus loin:<br><br></body></html>");
	
	String welcometext1IT = ("<html><body><h1><strong>Benvenuti a Vokabel Trainer V1.0</strong></h1></body></html>");
	String welcometext2IT = ("<html><body><br>Si prega di scegliere come si vuole procedere ulteriormente:<br><br></body></html>");
	
  	// Declare key buttons
  	private JButton starten;
  	private JButton speichern;
  	private JButton laden;
  	private JButton erfassen;
  	private JButton hilfe;
  
  	// Declare panels
  	private JPanel upperPanel;
  	private JPanel mainPanel;
  	private JPanel lowerPanel;
  	
  	// Declare label
  	private JLabel welcomescreen1;
  	private JLabel welcomescreen2;
  	
  	// Declare and create combobox
    private JComboBox languagebox = new JComboBox(new Object[] {"de","en","fr","it"});
  	
    // Get languagestatus
	public String getLanguagestatus() {
		return languagestatus;
	}

	// Set languagestatus
	public void setLanguagestatus(String languagestatus) {
		this.languagestatus = languagestatus;
	}

	public VokabMainGui() {
  		// Main frame
  		mainFrame = new JFrame("Vokabel Trainer V1.0");
  		
  		// Create key buttons
  	  	starten = new JButton("Starten");
  	  	speichern = new JButton("Speichern");
  	    laden = new JButton("Laden");
  	    erfassen = new JButton("Erfassen");
  	    hilfe = new JButton("Hilfe");
  	  
  	  	// Create other GUI elements
  	  	welcomescreen1 = new JLabel();
  	  	welcomescreen2 = new JLabel();
  	  	
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
    	welcomescreen1.setHorizontalAlignment(SwingConstants.CENTER);
    	welcomescreen2.setHorizontalAlignment(SwingConstants.CENTER);
    
    	// Set layout of all panels and frames
    	//mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.setLayout(new BorderLayout(25, 25));
		upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		    	
    	// Set design and content of JLabel welcomescreen	
    	Border border = LineBorder.createBlackLineBorder();
    	welcomescreen1.setText(welcometext1DE);
    	welcomescreen1.setBorder(border);
    	welcomescreen2.setText(welcometext2DE);
    	welcomescreen2.setBorder(border);
    	
    	// Listener
    	starten.addActionListener(new ButtonListener());
    	speichern.addActionListener(new ButtonListener());
    	laden.addActionListener(new ButtonListener());
    	erfassen.addActionListener(new ButtonListener());
    	hilfe.addActionListener(new ButtonListener());
    	languagebox.addActionListener(new ComboboxListener());
    	  	
    	// Add buttons to lowerPanel
    	lowerPanel.add(starten);
    	lowerPanel.add(speichern);
    	lowerPanel.add(laden);
    	lowerPanel.add(erfassen);
    	lowerPanel.add(hilfe);
    	
    	// Add label to mainPanel
    	mainPanel.add(welcomescreen1);
    	mainPanel.add(welcomescreen2);
    	
    	// Add combobox to upperPanel
    	upperPanel.add(languagebox);
    	
		// Assemble welcome screens to mainPanel
		mainPanel.add(welcomescreen1, BorderLayout.NORTH);
		mainPanel.add(welcomescreen2, BorderLayout.CENTER);
		

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
        	    	+ "\nSprache: " + languagestatus,
        	    	"Hilfe!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpEN()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In this window, a simple help is offered."
        		    + "\nThe following topics are dealt with:" + "\nTopic1"	+ "\nTopic2" + "\nTopic3" + "\n"
        	    	+ "\nLanguage: " + languagestatus,
        	    	"Help!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpFR()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "Dans cette fen�tre, une aide simple est offert."
        		    + "\nLes sujets suivants sont abord�s:"	+ "\nSujet1" + "\nSujet2" + "\nSujet3" + "\n"
        	    	+ "\nLangue: " + languagestatus,
        	    	"Aidez!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpIT()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In questa finestra, un semplice aiuto viene offerto."
        		    + "\nI seguenti argomenti sono trattati:" + "\nArgomento1" + "\nArgomento2" + "\nArgomento3" + "\n"
        	    	+ "\nLingua: " + languagestatus,
        	    	"Aiuto!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    
    //Method to change language to german
    private void changeLanguageDE()
    {
    	welcomescreen1.setText(welcometext1DE);
    	welcomescreen2.setText(welcometext2DE);
    	starten.setText("Starten");
    	speichern.setText("Speichern");
    	laden.setText("Laden");
    	erfassen.setText("Erfassen");
    	hilfe.setText("Hilfe");
    	languagestatus = "de";
    }
    
    //Method to change language to english
    private void changeLanguageEN()
    {
    	welcomescreen1.setText(welcometext1EN);
    	welcomescreen2.setText(welcometext2EN);
    	starten.setText("Start");
    	speichern.setText("Save");
    	laden.setText("Load");
    	erfassen.setText("Register");
    	hilfe.setText("Help");
    	languagestatus = "en";
    }
    
    //Method to change language to french
    private void changeLanguageFR()
    {
    	welcomescreen1.setText(welcometext1FR);
    	welcomescreen2.setText(welcometext2FR);
    	starten.setText("D�marrer");
    	speichern.setText("Sauver");
    	laden.setText("Charge");
    	erfassen.setText("Saisie");
    	hilfe.setText("Aidez");
    	languagestatus = "fr";
    }
    
    //Method to change language to italian
    private void changeLanguageIT()
    {
    	welcomescreen1.setText(welcometext1IT);
    	welcomescreen2.setText(welcometext2IT);
    	starten.setText("Inizio");
    	speichern.setText("Salvare");
    	laden.setText("Carico");
    	erfassen.setText("Cattura");
    	hilfe.setText("Aiuto");
    	languagestatus = "it";
    }

	// Declare listener class for buttons
	class ButtonListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == hilfe){
				if(e.getActionCommand().equals("Hilfe")) showHelpDE();
				else if(e.getActionCommand().equals("Help")) showHelpEN();
				else if(e.getActionCommand().equals("Aidez")) showHelpFR();
				else if(e.getActionCommand().equals("Aiuto")) showHelpIT();
			}
			if (e.getSource() == starten){
				if(e.getActionCommand().equals("Starten")) workGui.paint();
				else if(e.getActionCommand().equals("Start")) workGui.paint();
				else if(e.getActionCommand().equals("D�marrer")) workGui.paint();
				else if(e.getActionCommand().equals("Inizio")) workGui.paint();
			}
			if (e.getSource() == speichern) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(mainFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					System.out.println("Saving: " + file.getName() + ".");
					final VokabLogic logic = new VokabLogic().getInstance();
					logic.addCard("Hallo", "hello", 1);
					logic.addCard("Nein", "no", 2);
					logic.addCard("Tier", "animal", 3);
					logic.addCard("Hund", "dog", 4);
					logic.addCard("Katze", "cat", 5);

					Exporter ex = new Exporter();
					ex.exportToFile(logic.getVocabularylist(), file);
				}
				else {
					System.out.println("Save command cancelled by user.");
				}
			}
			else if (e.getSource() == laden) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(mainFrame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					System.out.println("Opening: " + file.getName() + ".");
					final VokabLogic logic = new VokabLogic().getInstance();
					Importer imp = new Importer();
					logic.setVocabularylist(imp.importFromFile(file));
				}
				else {
					System.out.println("Open command cancelled by user.");
				}
			}
			else if (e.getSource() == erfassen) {
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
		
		VokabMainGui gui = new VokabMainGui();
		gui.paint();
	}  	
}
