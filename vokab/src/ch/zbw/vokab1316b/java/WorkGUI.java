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
 * Diese Klasse implementiert einen einfachen Lern-GUI.
 * Beim erstellen der Klassen wird der Work-GUI zum lernen mittels Komponenten wie Labels, Textfields, Buttons, etc. angezeigt
 * und reagiert auf User-Befehle wie z.B. das drï¿½cken eines Buttons.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version 1.0 02.02.2015
 */
public class WorkGUI {
	
	String tempsol;
	// Klasse Languages und Logic instanzieren
	Languages languages = new Languages();
	Logic logic = new Logic();
	
	// Frame erstellen und beschriften
	JFrame mainFrame = new JFrame(languages.getProduct() + languages.getVersion());
		
	// Panels, Labels, Textfields und Buttons erstellen, zum Teil auch gleich beschriften.
  	private JPanel upperPanel  = new JPanel();
  	private JPanel mainPanel  = new JPanel();
  	private JPanel mainLeftPanel  = new JPanel();
  	private JPanel mainRightPanel  = new JPanel();
  	private JPanel lowerPanel  = new JPanel();
  	
  	private JLabel lblDesc1 = new JLabel();
  	private JLabel lblDesc2 = new JLabel();
  	private JLabel lblResult1 = new JLabel();
  	private JLabel lblSpaceCenter  = new JLabel();
  	private JLabel lblSpaceLeft  = new JLabel("                                        ");
  	private JLabel lblSpaceRight  = new JLabel("                                        ");

  	private JTextField txtFront = new JTextField();
  	private JTextField txtBack = new JTextField();
  	
	private JButton btnSwitch = new JButton(languages.getLangBtnSwitch());
  	private JButton btnNext = new JButton(languages.getLangBtnNext());
  	private JButton btnClose = new JButton(languages.getLangBtnClose());
	
  	// Combobox (Sprachauswahl) erstellen und mit Objekten abfüllen
    private JComboBox boxLanguage = new JComboBox(new Object[] {"de","en","fr","it"});
    
  	public WorkGUI() {  		
     	// Layout Einstellungen für Frame und Panels
		mainFrame.setTitle(languages.getProduct() + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.setSize(600, 400);
    	upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	mainPanel.setLayout(new GridLayout(10, 1));
    	
        // Labels Layout konfigurieren
		lblResult1.setOpaque(true);
		lblResult1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc1.setOpaque(true);
		lblDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc2.setOpaque(true);
		lblDesc2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceCenter.setOpaque(true);
		lblSpaceLeft.setOpaque(true);
		lblSpaceRight.setOpaque(true);
  	  	
  	  	// Textfelder Layout konfigurieren
		txtFront.setColumns(15);
		txtFront.setEditable(false);
		txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		
    	// Listener für Button Close und die Sprachbox erstellen
    	btnClose.addActionListener(new ButtonListener());
    	boxLanguage.addActionListener(new ComboboxListener());
  	}
  	
  	// Zusammenbauen und anzeigen des Work-GUI.
  	public void paint(String language){
  		this.languages.language = language;
  		this.boxLanguage.setSelectedItem(language);
  		setFocus();
  		
   		// Klasse Logik instanzieren
		final Logic logic = new Logic().getInstance();
        
        // GUI zentral im Bildschirm setzen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
    	
		// Platziert die Elemente in den Panels
    	upperPanel.add(boxLanguage);
    	mainPanel.add(lblDesc1);
		mainPanel.add(txtFront);
		mainPanel.add(lblSpaceCenter);
		mainPanel.add(lblDesc2);
		mainPanel.add(txtBack);
		mainPanel.add(lblResult1);
		mainLeftPanel.add(lblSpaceLeft);
		mainRightPanel.add(lblSpaceRight);
    	lowerPanel.add(btnSwitch);
    	lowerPanel.add(btnNext);
    	lowerPanel.add(btnClose);
		
	    // Alle Panels dem Frame hinzufügen und Layout bestimmen
	    mainFrame.add(upperPanel, BorderLayout.NORTH);
	    mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.add(mainLeftPanel,  BorderLayout.WEST);
	    mainFrame.add(mainRightPanel,  BorderLayout.EAST);
	    mainFrame.add(lowerPanel, BorderLayout.SOUTH);

        // Füllt erstes Wort zum übersetzen in das Front-Textfield und beschriftet die Sprache der Boxen
		txtFront.setText(logic.getCard());
		lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
		lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
		
		
		// Switch Knopf dreht Lernkarten. Wenn false dann true und wenn true dann false. Am Schluss neue Karte laden
		/**
		 * Switch-Button auf Listener setzen. Boolean Switch card side auf false oder true setzen.
		 * Nächste Karte laden.
		 */
		btnSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (logic.isSwitch_card_side() == true) {
					logic.setSwitch_card_side(false);
					System.out.println(logic.isSwitch_card_side());
					txtFront.setText(logic.getCard());
					lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
					lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
				}
				else {
					logic.setSwitch_card_side(true);
					System.out.println(logic.isSwitch_card_side());
					txtFront.setText(logic.getCard());
					lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
					lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
				}
			}
		});
		
		// Listener für Next Button.
		// Prüft Eingabe und reagiert entsprechend.
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tempsol = txtFront.getText();
				boolean check = logic.checkInput(txtBack.getText(), txtFront.getText());
				// Wenn keine Eingabe, Popup mit Aufforderung zur Lösungseingabe und Fokus wieder auf Feld txtBack setzen
				if(txtBack.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							languages.getLangRequest(),
                            languages.getWordAttention(),
	                        JOptionPane.WARNING_MESSAGE);
					setFocus();
				}
				// Wenn Eingabe Richtig (also true): Lösungstext löschen,
				// nächste Karte laden und Fokus wieder auf Feld txtBack setzen
				else if(check) {
					txtBack.setText("");
					txtFront.setText(logic.getCard());
					lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
					lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
					setFocus();
				}
				// Wenn Eingabe Falsch (also false): Lösungstext löschen, Feedback ausgeben,
				// nächste Karte laden und Fokus wieder auf Feld txtBack setzen
				else {
					JOptionPane.showMessageDialog(null, languages.getLangNok1() + languages.getLangNok2() + logic.getSolution(tempsol) + ")", languages.getWordAttention(), JOptionPane.WARNING_MESSAGE);
					txtBack.setText("");
					txtFront.setText(logic.getCard());
					lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
					lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
					setFocus();
				}
				
			}
		});
  	}
    
	// Listener für Close Button.
	// Schliesst mainFrame der Klasse Work-GUI und zeigt die Auswertung an.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClose){
				mainFrame.setVisible(false);
				logic.getOverview();
			}
		}
	}
	
	// Listener für Sprachauswahl.
	// Setzt die in der Combobox gewählte Sprache.
	class ComboboxListener implements ActionListener {
	    // Is called when combobox is selected
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
    	btnSwitch.setText(languages.getLangBtnSwitch());
    	btnNext.setText(languages.getLangBtnNext());
    	btnClose.setText(languages.getLangBtnClose());
    	System.out.println(languages.getLanguage());
    }
  	
    // Setzt Next Button als Standard Button (Enter)
  	// Setzt txtBack Feld aktiv für Eingabe
  	public void setFocus(){
        mainFrame.getRootPane().setDefaultButton(btnNext);
        txtBack.requestFocusInWindow();
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
		
		gui.paint(null);
	}  	
}