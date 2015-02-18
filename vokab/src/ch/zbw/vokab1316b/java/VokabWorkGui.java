package ch.zbw.vokab1316b.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
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
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.*;

import ch.zbw.vokab1316b.java.*;

/**
 * This class implements a simple learning work GUI. When creating a new object of this
 * class the GUI components, such as buttons, labels, etc. are displayed and
 * react on user actions, such as pressing a button.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 02.02.2015
 */
public class VokabWorkGui {
	
	// Main frame
	JFrame mainFrame;
	
  	// Declare key buttons
  	private JButton pruefen;
  	private JButton weiter;
  	private JButton beenden;
  	private JButton hilfe;
  
  	// Declare panels
  	private JPanel upperPanel;
  	private JPanel mainPanel;
  	private JPanel textPanel;
  	private JPanel fieldPanel;
  	private JPanel lowerPanel;
  	
  	// Declare label
  	private JLabel frontsidelabel;
  	private JLabel backsidelabel;
  	private JLabel resultlabel;
  	
  	private JTextField frontside;
  	private JTextField backside;
  	private JTextField result;
  	
  	// Declare and create combobox
    private JComboBox languagebox = new JComboBox(new Object[] {"de","en","fr","it"});
  	
  	public VokabWorkGui() {
  		// Main frame
  		mainFrame = new JFrame("Vokabel Trainer V1.0");
  		
  		// Create key buttons
  	  	pruefen = new JButton("Pruefen");
  	  	weiter = new JButton("Weiter");
  	    beenden = new JButton("Beenden");
  	    hilfe = new JButton("Hilfe");
  	      	  
  	  	// Create labels and set display options
  	  	frontsidelabel = new JLabel("Frage:");
  	  	backsidelabel = new JLabel("Antwort:");
  	  	resultlabel = new JLabel("Resultat:");
  	  	
  	  	// Create textfields and set display options
		frontside = new JTextField();
		frontside.setColumns(15);
		frontside.setEditable(false);
		backside = new JTextField();
		result = new JTextField();
		result.setEditable(false);
  	  	
  	  	// Create panels
  	  	upperPanel = new JPanel();
  	  	mainPanel = new JPanel();
  	  	textPanel = new JPanel();
  	  	fieldPanel = new JPanel();
  	  	lowerPanel = new JPanel();
  	}
  	
  	String languagestatus = "de";
    
  	// Assembles and displays the GUI.
  	public void paint(){
  		
  		//Neue Logik erstellen
		final VokabLogic logic = new VokabLogic().getInstance();
		final VokabMainGui mainGui = new VokabMainGui();
		
		// Variables
	    		
		languagestatus = mainGui.getLanguagestatus();
		
     	// Set layout of all panels and frames
		upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	textPanel.setLayout(new BorderLayout(10, 10));
    	fieldPanel.setLayout(new BorderLayout(10, 10));
  		mainFrame.setTitle("Vokabel Trainer V1.0");
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	
    	// Buttons einem Listener hinzufï¿½gen
    	beenden.addActionListener(new ButtonListener());
    	hilfe.addActionListener(new ButtonListener());
    	languagebox.addActionListener(new ComboboxListener());
    	  	
    	// Add buttons to Panels
    	lowerPanel.add(pruefen);
    	lowerPanel.add(weiter);
    	lowerPanel.add(beenden);
    	lowerPanel.add(hilfe);
    	
    	// Add Panels to mainPanel
    	mainPanel.add(fieldPanel, BorderLayout.WEST);
    	mainPanel.add(textPanel, BorderLayout.EAST);
    	
    	// Add combobox to upperPanel
    	upperPanel.add(languagebox);
    	
		// Add textfields to textPanel
		textPanel.add(frontside, BorderLayout.NORTH);
		textPanel.add(backside, BorderLayout.CENTER);
		textPanel.add(result, BorderLayout.SOUTH);
		
		// Add labels to fieldPanel
		fieldPanel.add(frontsidelabel, BorderLayout.NORTH);
		fieldPanel.add(backsidelabel, BorderLayout.CENTER);
		fieldPanel.add(resultlabel, BorderLayout.SOUTH);

	    // Add all panels to frame and set size of frame
	    mainFrame.add(upperPanel, BorderLayout.NORTH);
	    mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.add(lowerPanel, BorderLayout.SOUTH);
	    
        // Set size of window and place it to middle of screen
	    mainFrame.setSize(600, 400);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
        
		/**
		 * Testkarten hinzufï¿½gen
		 */
		logic.addCard("Hallo", "hello", 1);
		logic.addCard("Nein", "no", 2);
		logic.addCard("Tier", "animal", 3);
		logic.addCard("Hund", "dog", 4);
		logic.addCard("Katze", "cat", 5);
		
		/**
		 * Erster Eintrag in Textfeld
		 */
		frontside.setText(logic.cardLogicByRandom());
		
		/**
		 * Prï¿½fen-Button auf Listener setzen und Karten auf Richtigkeit prï¿½fen
		 */
		pruefen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = logic.checkCard(backside.getText(), frontside.getText());
				/*
				 * wenn true nï¿½chste Karte anzeigen und "Richtig :-)" ausgeben - txtfield_ty clearen usw.
				 */
				if(check)
				{
					result.setText("richtig");
					result.setBackground(Color.green);
				}
				/*
				 * Wenn false nochmal probieren und "Falsch :-(" ausgeben
				 */
				else
				{
					result.setText("falsch");
					result.setBackground(Color.red);
				}
			}
		});
		
		weiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = logic.checkCard(backside.getText(), frontside.getText());
				/*
				 * Immer Ergebnis von letzter Karte lï¿½schen
				 */
				result.setBackground(Color.white);
				result.setText("");
				/*
				 * Wenn true nï¿½chste Karte laden ohne Resultat zeigen
				 */
				if(check)
				{
					backside.setText("");
					frontside.setText(logic.cardLogicByRandom());
				}
				/*
				 * Wenn false nochmal probieren und "Falsch :-(" ausgeben
				 */
				else
				{
					result.setBackground(Color.white);
				}
			}
		});
  	}
  	
    //Help window in different languages
    private void showHelpDE()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In diesem Fenster wird eine einfache Hilfe angeboten."
        		    + "\nFolgende Themen werden bearbeitet:" + "\nThema1" + "\nThema2" + "\nThema3" + "\n"
        	    	+ "\nSprache: " + languagestatus + " (1=de, 2=en, 3=fr, 4=it)",
        	    	"Hilfe!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpEN()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In this window, a simple help is offered."
        		    + "\nThe following topics are dealt with:" + "\nTopic1"	+ "\nTopic2" + "\nTopic3" + "\n"
        	    	+ "\nLanguage: " + languagestatus + " (1=de, 2=en, 3=fr, 4=it)",
        	    	"Help!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpFR()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "Dans cette fenï¿½tre, une aide simple est offert."
        		    + "\nLes sujets suivants sont abordï¿½s:"	+ "\nSujet1" + "\nSujet2" + "\nSujet3" + "\n"
        	    	+ "\nLangue: " + languagestatus + " (1=de, 2=en, 3=fr, 4=it)",
        	    	"Aidez!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpIT()
    {
        JOptionPane.showMessageDialog(mainFrame, 
        	        "In questa finestra, un semplice aiuto viene offerto."
        		    + "\nI seguenti argomenti sono trattati:" + "\nArgomento1" + "\nArgomento2" + "\nArgomento3" + "\n"
        	    	+ "\nLingua: " + languagestatus + " (1=de, 2=en, 3=fr, 4=it)",
        	    	"Aiuto!",
                    JOptionPane.QUESTION_MESSAGE);
    }
    
    //Method to change language to de,en,fr,it
    private void changeLanguageDE()
    {
    	pruefen.setText("Pruefen");
    	weiter.setText("Weiter");
    	beenden.setText("Beenden");
    	hilfe.setText("Hilfe");
    	languagestatus = "de";
    }
    private void changeLanguageEN()
    {
    	pruefen.setText("Check");
    	weiter.setText("Next");
    	beenden.setText("Close");
    	hilfe.setText("Help");
    	languagestatus = "en";
    }
    private void changeLanguageFR()
    {
    	pruefen.setText("Démarrer");
    	weiter.setText("Sauver/charge");
    	beenden.setText("Saisie");
    	hilfe.setText("Aidez");
    	languagestatus = "fr";
    }
    private void changeLanguageIT()
    {
    	pruefen.setText("Inizio");
    	weiter.setText("Salvare/Carico");
    	beenden.setText("Cattura");
    	hilfe.setText("Aiuto");
    	languagestatus = "it";
    }
    
	// Declare listener class for buttons
	// ...
	class ButtonListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == hilfe){
				if(e.getActionCommand().equals("Hilfe")) showHelpDE();
				else if(e.getActionCommand().equals("Help")) showHelpEN();
				else if(e.getActionCommand().equals("Aidez")) showHelpFR();
				else if(e.getActionCommand().equals("Aiuto")) showHelpIT();
			}
			else if(e.getSource() == beenden){
				mainFrame.setVisible(false);
			}
	}
}
	
	// Declare listener class for combobox
	class ComboboxListener implements ActionListener {
	    // Is called when combobox is selected
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
		
		VokabWorkGui gui = new VokabWorkGui();
		gui.paint();
	}  	
}