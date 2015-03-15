package ch.zbw.vokab1316b.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.Position;

/**
 * Diese Klasse implementiert den Bildschrim zum erstellen von erlernbaren Wortpaaren und deren Uebersetzungen (RegisterGUI).
 * Beim Erstellen der Klasse wird der RegisterGUI mittels Komponenten wie Labels, Textfields, Buttons, etc. aufgebaut
 * und reagiert auf User-Befehle wie z.B. das Druecken eines Buttons.
 * 
 * @author Marcel Baumgartner, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */
public class EditGUI {

	// Datenfelder
	Languages languages = new Languages();
	Logic logic = new Logic().getInstance();
	JFrame mainFrame = new JFrame();
		
	private JPanel northPanel  = new JPanel();
  	private JPanel centerPanel  = new JPanel();
  	private JPanel westPanel  = new JPanel();
  	private JPanel eastPanel  = new JPanel();
  	private JPanel southPanel  = new JPanel();
  	
  	private JLabel lblDesc1 = new JLabel(languages.getLangQuestion() + ": ");
  	private JLabel lblDesc2 = new JLabel(languages.getLangCode() + " " + languages.getLangQuestion() + ": ");
  	private JLabel lblDesc3 = new JLabel(languages.getLangAnswer() + ": ");
  	private JLabel lblDesc4 = new JLabel(languages.getLangCode() + " " + languages.getLangAnswer() + ": ");
  	private JLabel lblSpaceCenter  = new JLabel();
  	private JLabel lblSpaceLeft  = new JLabel("                                        ");
  	private JLabel lblSpaceRight  = new JLabel("                                        ");

  	private JTextField txtFront = new JTextField();
  	private JTextField txtBack = new JTextField();
  	private JTextField txtLang1 = new JTextField();
  	private JTextField txtLang2 = new JTextField();
  	
  	private JButton btnSave = new JButton(languages.getLangBtnSave());
  	private JButton btnClose = new JButton(languages.getLangBtnClose());
	
    private JComboBox boxLanguage = new JComboBox(new Object[] {"de","en","fr","it"});
    private JComboBox boxFrotsideList = new JComboBox();
    
    /**
     * Erzeuge ein Fenster zum Woerter erfassen (RegisterGUI)
     * und zeige seine GUI auf dem Bildschirm an.
     */
  	public EditGUI() {
  		
  	    // RegisterGUI Design und Einstellungen
		mainFrame.setTitle(languages.getProduct() + " " + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.setSize(600, 400);
    	northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	centerPanel.setLayout(new GridLayout(10, 1));
    	
        lblDesc1.setOpaque(true);
		lblDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc2.setOpaque(true);
		lblDesc2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc3.setOpaque(true);
		lblDesc3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc4.setOpaque(true);
		lblDesc4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceCenter.setOpaque(true);
		lblSpaceLeft.setOpaque(true);
		lblSpaceRight.setOpaque(true);
  	  	
  	  	txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		txtLang1.setHorizontalAlignment(SwingConstants.CENTER);
		txtLang2.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Listener fuer Button Close und Combobox erstellen
    	btnClose.addActionListener(new ButtonListener());
    	boxLanguage.addActionListener(new ComboboxListener());
    	boxFrotsideList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String selected = e.getItem().toString();
				logic.getCardInformations(selected, txtFront, txtBack, txtLang1, txtLang2, boxFrotsideList);
			}
		});
  	}
		
  	
  	
  	/**
	 *  Zusammenbauen und anzeigen des RegisterGUI.
	 *  Beim aufbauen wird die Sprache des MainGUI uebernommen.
	 *  @param language die gewaehlte Spracheinstellung.
	 */
  	public void paint(String language){
  		this.languages.language = language;
  		this.boxLanguage.setSelectedItem(language);
  		final Logic logic = new Logic().getInstance();
  		setFocus();
        
		// Bildschirmaufloesung berechnen und dann GUI zentral ausrichten
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(d.width/2 - mainFrame.getWidth()/2, d.height/2 - mainFrame.getHeight()/2);
        mainFrame.setVisible(true);
    	
        // Baut GUI zusammen.
        northPanel.add(boxFrotsideList);
        northPanel.add(boxLanguage);
    	centerPanel.add(lblDesc1);
		centerPanel.add(txtFront);
		centerPanel.add(lblDesc2);
		centerPanel.add(txtLang1);
		centerPanel.add(lblDesc3);
		centerPanel.add(txtBack);
		centerPanel.add(lblDesc4);
		centerPanel.add(txtLang2);
		westPanel.add(lblSpaceLeft);
		eastPanel.add(lblSpaceRight);
    	southPanel.add(btnSave);
    	southPanel.add(btnClose);
		
	    mainFrame.add(northPanel, BorderLayout.NORTH);
	    mainFrame.add(centerPanel, BorderLayout.CENTER);
	    mainFrame.add(westPanel,  BorderLayout.WEST);
	    mainFrame.add(eastPanel,  BorderLayout.EAST);
	    mainFrame.add(southPanel, BorderLayout.SOUTH);
	    this.boxFrotsideList.addItem("Bitte wähle ein Wort aus");
		logic.getAllFront(boxFrotsideList);
		logic.getCardInformations((String) boxFrotsideList.getSelectedItem(), txtFront, txtBack, txtLang1, txtLang2, boxFrotsideList);
        // Listener fuer Speichern Button.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Prueft ob leere Felder vorhanden sind und gibt Warnmeldung aus.
				if (txtFront.getText().equals("") || txtBack.getText().equals("") || txtLang1.getText().equals("") || txtLang2.getText().equals("")) {
					JOptionPane.showMessageDialog(mainFrame, languages.getInputError(), languages.getWordAttention(), JOptionPane.WARNING_MESSAGE);			
				}
				//Wenn nicht wird Karte gespeichert.
				else {
					logic.addCard(txtFront.getText(), txtBack.getText(), 1, txtLang1.getText(), txtLang2.getText());
					txtFront.setText("");
					txtBack.setText("");
					txtLang1.setText("");
					txtLang2.setText("");
					setFocus();	
				}
			}
		});
  	}
    
	// Listener fuer Beenden Button und schliesst mainFrame des WorkGUI.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClose){
				mainFrame.setVisible(false);
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
	* Aendert die Beschriftung der Labels und Buttons auf die gewaehlte Sprache.
	* Uebersetzungen werden aus der Hilfsklasse Languages geholt.
	*/
  	private void setLang() {
    	btnSave.setText(languages.getLangBtnSave());
    	btnClose.setText(languages.getLangBtnClose());
    	lblDesc1.setText(languages.getLangQuestion() + ": ");
      	lblDesc2.setText(languages.getLangCode() + " " + languages.getLangQuestion() + ": ");
      	lblDesc3.setText(languages.getLangAnswer() + ": ");
      	lblDesc4.setText(languages.getLangCode() + " " + languages.getLangAnswer() + ": ");
    	System.out.println(languages.getLanguage());
    }
  	
  	/**
	* Methode setzt den Button "Speichern" als Fokus, damit schneller via Enter-Taste zur naechsten Eingabe gelangt werden kann.
	* Ebenfalls wird nach dem Betaetigen des Button "Speichern" wieder das Textfeld fuer das naechste zu erfassende Wort ausgewaehlt.
	*/
  	public void setFocus(){
        mainFrame.getRootPane().setDefaultButton(btnSave);
        txtFront.requestFocusInWindow();
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
		RegisterGUI gui = new RegisterGUI();
		gui.paint(null);
	}  	
}