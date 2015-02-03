package ch.zbw.vokab1316b.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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
	
  	// Declare key buttons
  	private JButton starten;
  	private JButton hilfe;
  	private JButton speichernladen;
  	private JButton erfassen;
  
  	// Declare panels
  	private JPanel upperPanel;
  	private JPanel mainPanel;
  	private JPanel lowerPanel;
  	
  	// Declare label
  	private JLabel welcomescreen1;
  	private JLabel welcomescreen2;
  	
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
		mainPanel.setLayout(new BorderLayout(25, 25));
    	
    	// Set design and content of JLabel welcomescreen	
    	Border border = LineBorder.createBlackLineBorder();
    	welcomescreen1.setText("<html><body><h1><strong>Herzlich Willkommen zum Vokabel Trainer V1.0</strong></h1></body></html>");
    	welcomescreen1.setBorder(border);
    	welcomescreen2.setText("<html><body><br> Bitte wähle wie du weiter vorgehen möchtest:<br><br></body></html>");
    	welcomescreen2.setBorder(border);
    	
    	// Add buttons to lowerPanel
    	lowerPanel.add(starten);
    	lowerPanel.add(hilfe);
    	lowerPanel.add(speichernladen);
    	lowerPanel.add(erfassen);
    	
    	// Add label to mainPanel
    	mainPanel.add(welcomescreen1);
    	mainPanel.add(welcomescreen2);
    	
		// Assemble hook/state panel
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
  	
	// Declare listener class for buttons
	// ...
	class ButtonListener implements ActionListener {
	    // Is called when key button is pressed
		public void actionPerformed(ActionEvent e) {
			// Add number to display
			String zahl1 = e.getActionCommand();
			// display.setText(display.getText());
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
