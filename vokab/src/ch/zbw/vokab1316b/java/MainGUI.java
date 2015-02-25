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
public class MainGUI {

	// Instanziere Klasse WorkGUI und Languages
	WorkGUI workGUI = new WorkGUI();
	Languages languages = new Languages();
	
	// Main frame
	JFrame mainFrame;
	
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
  	
	public MainGUI() {
  		// Main frame
  		mainFrame = new JFrame(languages.getProduct() + languages.getVersion());
  		
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
  		mainFrame.setTitle(languages.getProduct() + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	lblContent.setHorizontalAlignment(SwingConstants.CENTER);
    
    	// Set layout of all panels and frames
		mainPanel.setLayout(new BorderLayout(25, 25));
		upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		    	
    	// Set design and content of JLabel welcomescreen	
    	Border border = LineBorder.createBlackLineBorder();
    	lblTitle.setText(languages.getTitleDe());
    	lblTitle.setBorder(border);
    	lblContent.setText(languages.getContentDe());
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
    private void getHelpDe() {
        JOptionPane.showMessageDialog(mainFrame, languages.getHelptextDe() + "Sprache: " + languages.getLanguage(), "Hilfe!", JOptionPane.QUESTION_MESSAGE);
    }
    
    private void getHelpEn() {
        JOptionPane.showMessageDialog(mainFrame, languages.getHelptextEn() + "Language: " + languages.getLanguage(), "Help!", JOptionPane.QUESTION_MESSAGE);
    }
    
    private void getHelpFr() {
        JOptionPane.showMessageDialog(mainFrame, languages.getHelptextFr() + "Langue: " + languages.getLanguage(), "Aidez!", JOptionPane.QUESTION_MESSAGE);
    }
    
    private void getHelpIt() {
        JOptionPane.showMessageDialog(mainFrame, languages.getHelptextIt() + "Lingua: " + languages.getLanguage(), "Aiuto!", JOptionPane.QUESTION_MESSAGE);
    }
    
    //Method to change language to german
    private void setLangDe() {
    	lblTitle.setText(languages.getTitleDe());
    	lblContent.setText(languages.getContentDe());
    	btnStart.setText("Starten");
    	btnSave.setText("Speichern");
    	btnLoad.setText("Laden");
    	btnRegister.setText("Erfassen");
    	btnHelp.setText("Hilfe");
    	languages.setLanguage("de");
    	System.out.println(languages.getLanguage());
    }
    
    //Method to change language to english
    private void setLangEn() {
        lblTitle.setText(languages.getTitleEn());
    	lblContent.setText(languages.getContentEn());
    	btnStart.setText("Start");
    	btnSave.setText("Save");
    	btnLoad.setText("Load");
    	btnRegister.setText("Register");
    	btnHelp.setText("Help");
    	languages.setLanguage("en");
    	System.out.println(languages.getLanguage());
    }
    
    //Method to change language to french
    private void setLangFr() {
    	lblTitle.setText(languages.getTitleFr());
    	lblContent.setText(languages.getContentFr());
    	btnStart.setText("Demarrer");
    	btnSave.setText("Sauver");
    	btnLoad.setText("Charge");
    	btnRegister.setText("Saisie");
    	btnHelp.setText("Aidez");
    	languages.setLanguage("fr");
    	System.out.println(languages.getLanguage());
    }
    
    //Method to change language to italian
    private void setLangIt() {
    	lblTitle.setText(languages.getTitleIt());
    	lblContent.setText(languages.getContentIt());
    	btnStart.setText("Inizio");
    	btnSave.setText("Salvare");
    	btnLoad.setText("Carico");
    	btnRegister.setText("Cattura");
    	btnHelp.setText("Aiuto");
    	languages.setLanguage("it");
    	System.out.println(languages.getLanguage());
    }

	// Declare listener class for buttons
	class ButtonListener implements ActionListener {
	    // Is called when help button is pressed
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnHelp){
				if(e.getActionCommand().equals("Hilfe")) getHelpDe();
				else if(e.getActionCommand().equals("Help")) getHelpEn();
				else if(e.getActionCommand().equals("Aidez")) getHelpFr();
				else if(e.getActionCommand().equals("Aiuto")) getHelpIt();
			}
			if (e.getSource() == btnStart){
				if(e.getActionCommand().equals("Starten")) workGUI.paint();
				else if(e.getActionCommand().equals("Start")) workGUI.paint();
				else if(e.getActionCommand().equals("Demarrer")) workGUI.paint();
				else if(e.getActionCommand().equals("Inizio")) workGUI.paint();
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
		
		MainGUI gui = new MainGUI();
		gui.paint();
	}  	
}
