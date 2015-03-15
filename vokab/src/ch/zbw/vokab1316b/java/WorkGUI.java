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
 * Diese Klasse implementiert den wichtigsten aller GUIs, denjenigen zum lernen der Woerter. (WorkGUI).
 * Beim erstellen der Klasse wird der WorkGUI mittels Komponenten wie Labels, Textfields, Buttons, etc. angezeigt
 * und reagiert auf User-Befehle wie z.B. das Druecken eines Buttons.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */
public class WorkGUI {
	
	// Datenfelder
	Languages languages = new Languages();
	Logic logic = new Logic();
	JFrame mainFrame = new JFrame();
	
  	private JPanel northPanel  = new JPanel();
  	private JPanel centerPanel  = new JPanel();
  	private JPanel westPanel  = new JPanel();
  	private JPanel eastPanel  = new JPanel();
  	private JPanel southPanel  = new JPanel();
  	
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
	
    private JComboBox boxLanguage = new JComboBox(new Object[] {"de","en","fr","it"});
    
    /**
     * Erzeuge ein Fenster zum lernen der Woerter (WorkGUI)
     * und zeige seine GUI auf dem Bildschirm an.
     */
  	public WorkGUI() {  
  		
  	    // RegisterGUI Design und Einstellungen
		mainFrame.setTitle(languages.getProduct() + " " + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.setSize(600, 400);
    	northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	centerPanel.setLayout(new GridLayout(10, 1));
    	
		lblResult1.setOpaque(true);
		lblResult1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc1.setOpaque(true);
		lblDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc2.setOpaque(true);
		lblDesc2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceCenter.setOpaque(true);
		lblSpaceLeft.setOpaque(true);
		lblSpaceRight.setOpaque(true);
  	  	
		txtFront.setColumns(15);
		txtFront.setEditable(false);
		txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Listener fuer Button Close und Combobox erstellen
    	btnClose.addActionListener(new ButtonListener());
    	boxLanguage.addActionListener(new ComboboxListener());
  	}
  	
  	/**
	 *  Zusammenbauen und anzeigen des WorkGUI.
	 *  Beim aufbauen wird die Sprache des MainGUI uebernommen.
	 *  @param language die gewaehlte Spracheinstellung.
	 */
  	public void paint(String language){
  		
  		this.languages.language = language;
  		this.boxLanguage.setSelectedItem(language);
  		setFocus();
		final Logic logic = new Logic().getInstance();
        
		// Bildschirmaufloesung berechnen und dann GUI zentral ausrichten
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
    	
        // Baut GUI zusammen.
    	northPanel.add(boxLanguage);
    	centerPanel.add(lblDesc1);
		centerPanel.add(txtFront);
		centerPanel.add(lblSpaceCenter);
		centerPanel.add(lblDesc2);
		centerPanel.add(txtBack);
		centerPanel.add(lblResult1);
		westPanel.add(lblSpaceLeft);
		eastPanel.add(lblSpaceRight);
    	southPanel.add(btnSwitch);
    	southPanel.add(btnNext);
    	southPanel.add(btnClose);
		
	    mainFrame.add(northPanel, BorderLayout.NORTH);
	    mainFrame.add(centerPanel, BorderLayout.CENTER);
	    mainFrame.add(westPanel,  BorderLayout.WEST);
	    mainFrame.add(eastPanel,  BorderLayout.EAST);
	    mainFrame.add(southPanel, BorderLayout.SOUTH);

        // Fuellt erstes Abfragewort in das Front Textfeld und beschriftet den Sprachcode
		txtFront.setText(logic.getCard());
		lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
		lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
		
		
		// Switch Knopf dreht Lernkarten betreffend Sprachabfrage. Am Schluss neue Karte laden
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
		
		// Listener fuer Next Button.
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = logic.checkInput(txtBack.getText(), txtFront.getText());
				//Prueft ob leere Felder vorhanden sind und gibt Warnmeldung aus.
				if(txtBack.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							languages.getInputError(),
                            languages.getWordAttention(),
	                        JOptionPane.WARNING_MESSAGE);
					setFocus();
				}
				// Wenn richtig Loesungstext loeschen, naechste Karte laden und Fokus wieder auf Feld Loesungseingabe setzen
				else if(check) {
					txtBack.setText("");
					txtFront.setText(logic.getCard());
					lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
					lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
					setFocus();
				}
				// Wenn falsch Loesungstext loeschen, Feedback ausgeben, naechste Karte laden und Fokus wieder auf Feld Loesungseingabe setzen
				else {
					JOptionPane.showMessageDialog(null, languages.getLangNok1() + languages.getLangNok2() + logic.getSolution(txtFront.getText()) + ")", languages.getWordAttention(), JOptionPane.WARNING_MESSAGE);
					txtBack.setText("");
					txtFront.setText(logic.getCard());
					lblDesc1.setText(logic.getCardLangFront(txtFront.getText()));
					lblDesc2.setText(logic.getCardLangBack(txtFront.getText()));
					setFocus();
				}
				
			}
		});
  	}
    
	// Listener fuer Beenden Button. Schliesst mainFrame des WorkGUI und zeigt eine Erfolgsuebersicht an.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClose){
				mainFrame.setVisible(false);
				Success overview = new Success();
	            overview.setVisible(true);
	            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			    overview.setLocation(d.width/2 - overview.getWidth()/2, d.height/2 - overview.getHeight()/2);
			}
		}
	}
	
	// Listener fuer Sprachauswahl .Setzt die in der Combobox gewaehlte Sprache.
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
	* Aendert Beschriftung der Labels und Buttons auf die gewaehlte Sprache.
	* Uebersetzungen werden aus der Hilfsklasse Languages geholt.
	*/
  	private void setLang() {
    	btnSwitch.setText(languages.getLangBtnSwitch());
    	btnNext.setText(languages.getLangBtnNext());
    	btnClose.setText(languages.getLangBtnClose());
    	System.out.println(languages.getLanguage());
    }
  	
  	/**
	* Setzt den Button "Weiter" als Fokus, damit schneller via Enter-Taste zum nachesten Wort gelangt werden kann.
	* Ebenfalls wird nach dem Betaetigen des Button "Weiter" wieder das Textfeld zur Loesungseingabe ausgewaehlt.
	*/
  	public void setFocus(){
        mainFrame.getRootPane().setDefaultButton(btnNext);
        txtBack.requestFocusInWindow();
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
		WorkGUI gui = new WorkGUI();
		gui.paint(null);
	}  	
}