package ch.zbw.vokab1316b.java;

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

import ch.zbw.vokab1316b.java.*;

/**
 * This class implements a simple phone GUI. When creating a new object of this
 * class the GUI components, such as buttons, labels, etc. are displayed and
 * react on user actions, such as pressing a button.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 02.02.2015
 */
public class VokabMainGui{
	
	// Main frame
	JFrame mainFrame;
	
	// Variables (1=de, 2=en, 3=fr, 4=it)
	int languagestatus = 1;
	
  	// Declare key buttons
  	private JButton starten;
  	private JButton speichernladen;
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
  	
  	public VokabMainGui() {
  		// Main frame
  		mainFrame = new JFrame("Vokabel Trainer V1.0");
  		
  		// Create key buttons
  	  	starten = new JButton("starten");
  	  	hilfe = new JButton("hilfe");
  	    speichernladen = new JButton("speichern/laden");
  	    erfassen = new JButton("erfassen");
  	      	  
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
    	welcomescreen1.setText("<html><body><h1><strong>Herzlich Willkommen zum Vokabel Trainer V1.0</strong></h1></body></html>");
    	welcomescreen1.setBorder(border);
    	welcomescreen2.setText("<html><body><br> Bitte wähle wie du weiter vorgehen möchtest:<br><br></body></html>");
    	welcomescreen2.setBorder(border);
    	
    	// Listener
    	starten.addActionListener(new ButtonListener());
    	speichernladen.addActionListener(new ButtonListener());
    	erfassen.addActionListener(new ButtonListener());
    	hilfe.addActionListener(new ButtonListener());
    	languagebox.addActionListener(new ComboboxListener());
    	  	
    	// Add buttons to lowerPanel
    	lowerPanel.add(starten);
    	lowerPanel.add(speichernladen);
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
        	        "Would you like some green eggs to go "
        	    	+ "with that ham?",
        	    	"A Silly Question",
                    JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpEN()
    {
        JOptionPane.showMessageDialog(mainFrame, 
    	        "Would you like some green eggs to go "
    	    	+ "with that ham?",
    	    	"A Silly Question",
                JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpFR()
    {
        JOptionPane.showMessageDialog(mainFrame, 
    	        "Would you like some green eggs to go "
    	    	+ "with that ham?",
    	    	"A Silly Question",
                JOptionPane.QUESTION_MESSAGE);
    }
    private void showHelpIT()
    {
        JOptionPane.showMessageDialog(mainFrame, 
    	        "Would you like some green eggs to go "
    	    	+ "with that ham?",
    	    	"A Silly Question",
                JOptionPane.QUESTION_MESSAGE);
    }
    
    //Method to change language to german
    private void changeLanguageDE()
    {
    	welcomescreen1.setText("<html><body><h1><strong>Herzlich Willkommen zum Vokabel Trainer V1.0</strong></h1></body></html>");
    	welcomescreen2.setText("<html><body><br> Bitte wähle wie du weiter vorgehen möchtest:<br><br></body></html>");
    	starten.setText("starten");
    	speichernladen.setText("speichern/laden");
    	erfassen.setText("erfassen");
    	hilfe.setText("hilfe");
    	languagestatus = 1;
    }
    
    //Method to change language to english
    private void changeLanguageEN()
    {
    	welcomescreen1.setText("<html><body><h1><strong>Welcome to Vokabel Trainer V1.0</strong></h1></body></html>");
    	welcomescreen2.setText("<html><body><br> Please choose how you want to proceed further:<br><br></body></html>");
    	starten.setText("start");
    	speichernladen.setText("save/load");
    	erfassen.setText("register");
    	hilfe.setText("help");
    	languagestatus = 2;
    }
    
    //Method to change language to french
    private void changeLanguageFR()
    {
    	welcomescreen1.setText("<html><body><h1><strong>Bienvenue à Vokabel Trainer V1.0</strong></h1></body></html>");
    	welcomescreen2.setText("<html><body><br> S'il vous plaît choisir la façon dont vous voulez aller plus loin:<br><br></body></html>");
    	starten.setText("démarrer");
    	speichernladen.setText("sauver/charge");
    	erfassen.setText("saisie");
    	hilfe.setText("aidez");
    	languagestatus = 3;
    }
    
    //Method to change language to italian
    private void changeLanguageIT()
    {
    	welcomescreen1.setText("<html><body><h1><strong>Benvenuti a Vokabel Trainer V1.0</strong></h1></body></html>");
    	welcomescreen2.setText("<html><body><br>Si prega di scegliere come si vuole procedere ulteriormente:<br><br></body></html>");
    	starten.setText("inizio");
    	speichernladen.setText("salvare/carico");
    	erfassen.setText("cattura");
    	hilfe.setText("aiuto");
    	languagestatus = 4;
    }

	// Declare listener class for buttons
	// ...
	class ButtonListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("hilfe")) {
	    showHelpDE();}
		else if(e.getActionCommand().equals("help")) {
		showHelpEN();}
		else if(e.getActionCommand().equals("aidez")) {
	    showHelpFR();}
		else if(e.getActionCommand().equals("aiuto")) {
	    showHelpIT();
		}
	}
}
	
	// Declare listener class for combobox
	// ...
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