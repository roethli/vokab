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
public class WorkGUI {
	
	Languages languages = new Languages();
	Logic logic = new Logic();
	
	// Main frame
	JFrame mainFrame;
	
  	// Declare key buttons
  	private JButton btnCheck;
  	private JButton btnNext;
  	private JButton btnClose;
  
  	// Declare panels
  	private JPanel upperPanel;
  	private JPanel mainPanel;
  	private JPanel textPanel;
  	private JPanel fieldPanel;
  	private JPanel lowerPanel;
  	
  	// Declare label
  	// TODO Lables workgui?
  	private JLabel lblFront;
  	private JLabel lblBack;
  	private JLabel lblResult;
  	
  	// Declare textfield
  	private JTextField txtFront;
  	private JTextField txtBack;
  	private JTextField txtResult;
  	
  	// Declare and create combobox
    private JComboBox languagebox = new JComboBox(new Object[] {"de","en","fr","it"});
  	
  	public WorkGUI() {
  		// Main frame
  		mainFrame = new JFrame(languages.getProduct() + languages.getVersion());
  		
  		// Create key buttons
  	  	btnCheck = new JButton("Pruefen");
  	  	btnNext = new JButton("Weiter");
  	    btnClose = new JButton("Beenden");
  	  
  	  	// Create labels and set display options
  	  	lblFront = new JLabel("Frage:");
  	  	lblBack = new JLabel("Antwort:");
  	  	lblResult = new JLabel("Resultat:");
  	  	
  	  	// Create textfields and set display options
		txtFront = new JTextField();
		txtFront.setColumns(15);
		txtFront.setEditable(false);
		txtBack = new JTextField();
		txtResult = new JTextField();
		txtResult.setEditable(false);
  	  	
  	  	// Create panels
  	  	upperPanel = new JPanel();
  	  	mainPanel = new JPanel();
  	  	textPanel = new JPanel();
  	  	fieldPanel = new JPanel();
  	  	lowerPanel = new JPanel();
  	}
  	
  	String language = "de";
    
  	// Assembles and displays the GUI.
  	public void paint(){
  		
  		// Neue Logik erstellen
		final Logic logic = new Logic().getInstance();

     	// Set layout of all panels and frames
		upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	textPanel.setLayout(new BorderLayout(10, 10));
    	fieldPanel.setLayout(new BorderLayout(10, 10));
  		mainFrame.setTitle(languages.getProduct() + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	
    	// Buttons einem Listener hinzufuegen
    	btnClose.addActionListener(new ButtonListener());
    	languagebox.addActionListener(new ComboboxListener());
    	  	
    	// Add buttons to Panels
    	lowerPanel.add(btnCheck);
    	lowerPanel.add(btnNext);
    	lowerPanel.add(btnClose);
    	
    	// Add Panels to mainPanel
    	mainPanel.add(fieldPanel, BorderLayout.WEST);
    	mainPanel.add(textPanel, BorderLayout.EAST);
    	
    	// Add combobox to upperPanel
    	upperPanel.add(languagebox);
    	
		// Add textfields to textPanel
		textPanel.add(txtFront, BorderLayout.NORTH);
		textPanel.add(txtBack, BorderLayout.CENTER);
		textPanel.add(txtResult, BorderLayout.SOUTH);
		
		// Add labels to fieldPanel
		fieldPanel.add(lblFront, BorderLayout.NORTH);
		fieldPanel.add(lblBack, BorderLayout.CENTER);
		fieldPanel.add(lblResult, BorderLayout.SOUTH);

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
		 * Testkarten hinzufuegen
		 */
		logic.addCard("Hallo", "hello", 1, "de", "en");
		logic.addCard("Nein", "no", 2, "de", "en");
		logic.addCard("Tier", "animal", 3, "de", "en");
		logic.addCard("Hund", "dog", 4, "de", "en");
		logic.addCard("Katze", "cat", 5, "de", "en");
		
        // Setze erstes Wort in Front Textfield
		txtFront.setText(logic.getCard());
		
		/**
		 * Pruefen-Button auf Listener setzen und Karten auf Richtigkeit pruefen
		 */
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = logic.checkInput(txtBack.getText(), txtFront.getText());
				/*
				 * wenn true naechste Karte anzeigen und "Richtig :-)" ausgeben - txtfield_ty clearen usw.
				 */
				if(txtBack.getText().equals("") && languages.getLanguage() == "de") {
					txtResult.setText("Bitte gib eine Loesung ein!");
				}
				else if(txtBack.getText().equals("") && languages.getLanguage() == "en") {
					txtResult.setText("Please type in an answer!");
				}
				
				else if(check)
				{
					txtResult.setText("richtig");
					txtResult.setBackground(Color.green);
				}
				/*
				 * Wenn false nochmal probieren und "Falsch :-(" ausgeben
				 */
				else
				{
					txtResult.setText("falsch");
					txtResult.setBackground(Color.red);
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = logic.checkInput(txtBack.getText(), txtFront.getText());
				/*
				 * Immer Ergebnis von letzter Karte loeschen
				 */
				txtResult.setBackground(Color.white);
				txtResult.setText("");
				/*
				 * Wenn true naechste Karte laden ohne Resultat zeigen
				 */
				if(txtBack.getText().equals("") && languages.getLanguage() == "de") {
					txtResult.setText("Bitte gib eine Loesung ein!");
				}
				else if(txtBack.getText().equals("") && languages.getLanguage() == "en") {
					txtResult.setText("Please type in an answer!");
				}
				else if(check)
				{
					txtBack.setText("");
					txtFront.setText(logic.getCard());
				}
				/*
				 * Wenn false nochmal probieren und "Falsch :-(" ausgeben
				 */
				else
				{
					txtResult.setBackground(Color.white);
				}
			}
		});
  	}
    
    //Method to change language to de,en,fr,it
    private void changeLanguageDE() {
    	btnCheck.setText("Pruefen");
    	btnNext.setText("Weiter");
    	btnClose.setText("Beenden");
    	languages.setLanguage("de");
    }
    private void changeLanguageEN() {
    	btnCheck.setText("Check");
    	btnNext.setText("Next");
    	btnClose.setText("Close");
    	language = "en";
    }
    private void changeLanguageFR() {
    	btnCheck.setText("Démarrer");
    	btnNext.setText("Sauver/charge");
    	btnClose.setText("Saisie");
    	language = "fr";
    }
    private void changeLanguageIT() {
    	btnCheck.setText("Inizio");
    	btnNext.setText("Salvare/Carico");
    	btnClose.setText("Cattura");
    	language = "it";
    }
    
	// Declare listener class for buttons
	// ...
	class ButtonListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClose){
				mainFrame.setVisible(false);
				logic.getOverview();
				
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
		
		WorkGUI gui = new WorkGUI();
		gui.paint();
	}  	
}