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

import javax.swing.BoxLayout;
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
  	private JPanel lowerPanel;
  	
  	// Declare label
  	// TODO Lables workgui?
  	private JLabel lblDesc1;
  	private JLabel lblDesc2;
  	private JLabel lblResult;
  	private JLabel lblSpace;
  	
  	// Declare textfield
  	private JTextField txtFront;
  	private JTextField txtBack;
  	
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
		lblResult = new JLabel();
		lblResult.setOpaque(true);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc1 = new JLabel("En:");
		lblDesc1.setOpaque(true);
		lblDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc2 = new JLabel("De:");
		lblDesc2.setOpaque(true);
		lblDesc2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpace = new JLabel();
		lblSpace.setOpaque(true);
  	  	
  	  	// Create textfields and set display options
		txtFront = new JTextField();
		txtFront.setColumns(15);
		txtFront.setEditable(false);
		txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack = new JTextField();
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);

  	  	
  	  	// Create panels
  	  	upperPanel = new JPanel();
  	  	mainPanel = new JPanel();
  	  	lowerPanel = new JPanel();
  	}
  	
  	// Assembles and displays the GUI.
  	public void paint(){
  		
  		setLang();
  		
   		// Neue Logik erstellen
		final Logic logic = new Logic().getInstance();

     	// Set layout of all panels and frames
		upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		// mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    	mainPanel.setLayout(new GridLayout(10, 1));
    	// textPanel.setLayout(new BorderLayout(10, 10));
    	// fieldPanel.setLayout(new BorderLayout(10, 10));
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
    	// mainPanel.add(fieldPanel, BorderLayout.WEST);
    	// mainPanel.add(textPanel, BorderLayout.EAST);
    	
    	// Add combobox to upperPanel
    	upperPanel.add(languagebox);
    	
		// Add textfields to textPanel
    	mainPanel.add(lblDesc1);
		mainPanel.add(txtFront);
		mainPanel.add(lblSpace);
		mainPanel.add(lblDesc2);
		mainPanel.add(txtBack);
		mainPanel.add(lblResult);
		
		// Add labels to fieldPanel
		// fieldPanel.add(lblFront, BorderLayout.NORTH);
		// fieldPanel.add(lblBack, BorderLayout.CENTER);
		// fieldPanel.add(lblResult1, BorderLayout.SOUTH);

	    // Add all panels to frame and set size of frame
	    mainFrame.add(upperPanel, BorderLayout.NORTH);
	    mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.add(lowerPanel, BorderLayout.SOUTH);
	    
        // Set size of window and place it to middle of screen
	    mainFrame.setSize(600, 400);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
        
		// Testkarten hinzufuegen
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
					lblResult.setText("Bitte gib eine Loesung ein!");
				}
				else if(txtBack.getText().equals("") && languages.getLanguage() == "en") {
					lblResult.setText("Please type in an answer!");
				}
				
				else if(check)
				{
					lblResult.setText("richtig");
					lblResult.setBackground(Color.green);
				}
				/*
				 * Wenn false nochmal probieren und "Falsch :-(" ausgeben
				 */
				else
				{
					lblResult.setText("falsch");
					lblResult.setBackground(Color.red);
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = logic.checkInput(txtBack.getText(), txtFront.getText());
				// Wenn textfield back leer, aufforderung zur eingabe anzeigen
				if(txtBack.getText().equals("") && languages.getLanguage() == "de") {
					lblResult.setText("Bitte gib eine Loesung ein!");
				}
				else if(txtBack.getText().equals("") && languages.getLanguage() == "en") {
					lblResult.setText("Please type in an answer!");
				}
				else if(txtBack.getText().equals("") && languages.getLanguage() == "fr") {
					lblResult.setText("Silvous plaits eingeben!");
				}
				else if(txtBack.getText().equals("") && languages.getLanguage() == "it") {
					lblResult.setText("Bitte eingeben IT!");
				}
				// Wenn true textfield back leeren, Resultat OK ausgeben und naechste Karte laden
				else if(check) {
					txtBack.setText("");
					lblResult.setText("OK");
					txtFront.setText(logic.getCard());
				}
				// Wenn false textfield back leeren und als Resultat X ausgeben
				else {
					txtBack.setText("");
					lblResult.setText("X");
				}
			}
		});
  	}
    
    //Method to change language to de,en,fr,it
    private void setLang() {
    	if (languages.getLanguage().equals("de")) {
    		setLangDe();
    	}
    	else if (languages.getLanguage().equals("en")) {
    		setLangEn();
    	}
    	else if (languages.getLanguage().equals("fr")) {
    		setLangFr();
    	}
    	else 
    		setLangIt();	
    }
  	private void setLangDe() {
    	btnCheck.setText("Pruefen");
    	btnNext.setText("Weiter");
    	btnClose.setText("Beenden");
    	languages.setLanguage("de");
    	System.out.println(languages.getLanguage());
    }
    private void setLangEn() {
    	btnCheck.setText("Check");
    	btnNext.setText("Next");
    	btnClose.setText("Close");
    	languages.setLanguage("en");
    	System.out.println(languages.getLanguage());
    }
    private void setLangFr() {
    	btnCheck.setText("Démarrer");
    	btnNext.setText("Sauver/charge");
    	btnClose.setText("Saisie");
    	languages.setLanguage("fr");
    	System.out.println(languages.getLanguage());
    }
    private void setLangIt() {
    	btnCheck.setText("Inizio");
    	btnNext.setText("Salvare/Carico");
    	btnClose.setText("Cattura");
    	languages.setLanguage("it");
    	System.out.println(languages.getLanguage());
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
				setLangDe();
			}
			else if(selectedItem.equals("en")) {
				setLangEn();
			}
			else if(selectedItem.equals("fr")) {
				setLangFr();
			}
			else if(selectedItem.equals("it")) {
				setLangIt();
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