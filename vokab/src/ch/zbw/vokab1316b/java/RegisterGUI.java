package ch.zbw.vokab1316b.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

// TODO GUI für die Erfassung von Karten erstellen
public class RegisterGUI {

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
  	
  	private JLabel lblDesc1 = new JLabel("Wort1:");
  	private JLabel lblDesc2 = new JLabel("Sprache Wort1:");
  	private JLabel lblDesc3 = new JLabel("Wort2:");
  	private JLabel lblDesc4 = new JLabel("Sprache Wort2:");
  	private JLabel lblSpaceCenter  = new JLabel();
  	private JLabel lblSpaceLeft  = new JLabel("                                        ");
  	private JLabel lblSpaceRight  = new JLabel("                                        ");

  	private JTextField txtFront = new JTextField();
  	private JTextField txtBack = new JTextField();
  	private JTextField txtLang1 = new JTextField();
  	private JTextField txtLang2 = new JTextField();
  	
  	private JButton btnSave = new JButton(languages.getLangBtnSave());
  	private JButton btnClose = new JButton(languages.getLangBtnClose());
	
  	// Combobox (Sprachauswahl) erstellen und mit Objekten abfüllen
    private JComboBox boxLanguage = new JComboBox(new Object[] {"de","en","fr","it"});
    
  	public RegisterGUI() {
  		
     	// Layout Einstellungen für Frame und Panels
		mainFrame.setTitle(languages.getProduct() + languages.getVersion());
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.setSize(600, 400);
    	upperPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	mainPanel.setLayout(new GridLayout(10, 1));
    	
        // Labels Layout konfigurieren
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
  	  	
  	  	// Textfelder Layout konfigurieren
		txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtFront.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		txtLang1.setHorizontalAlignment(SwingConstants.CENTER);
		txtLang2.setHorizontalAlignment(SwingConstants.CENTER);
		
    	// Listener für Button Close und die Sprachbox erstellen
    	btnClose.addActionListener(new ButtonListener());
    	boxLanguage.addActionListener(new ComboboxListener());
  	}
  	
  	// Zusammenbauen und anzeigen des Register-GUI.
  	public void paint(String language){
  		this.languages.language = language;
  		this.boxLanguage.setSelectedItem(language);
  		setLang();
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
		mainPanel.add(lblDesc2);
		mainPanel.add(txtLang1);
		mainPanel.add(lblDesc3);
		mainPanel.add(txtBack);
		mainPanel.add(lblDesc4);
		mainPanel.add(txtLang2);
		mainLeftPanel.add(lblSpaceLeft);
		mainRightPanel.add(lblSpaceRight);
    	lowerPanel.add(btnSave);
    	lowerPanel.add(btnClose);
		
	    // Alle Panels dem Frame hinzufügen und Layout bestimmen
	    mainFrame.add(upperPanel, BorderLayout.NORTH);
	    mainFrame.add(mainPanel, BorderLayout.CENTER);
	    mainFrame.add(mainLeftPanel,  BorderLayout.WEST);
	    mainFrame.add(mainRightPanel,  BorderLayout.EAST);
	    mainFrame.add(lowerPanel, BorderLayout.SOUTH);
	    		
        // Listener für Save Button.
		// Prüft Eingabe und reagiert entsprechend.
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.addCard(txtFront.getText(), txtBack.getText(), 1, txtLang1.getText(), txtLang2.getText());
				System.out.println(logic.checkInput("ape", "affe"));
				//Alle Eingabefelder wieder löschen damit bereit für nächste Karte
				txtFront.setText("");
				txtBack.setText("");
				txtLang1.setText("");
				txtLang2.setText("");
				setFocus();
			}
		});
  	}
    
	// Listener für Close Button.
	// Schliesst mainFrame der Klasse Work-GUI und zeigt die Auswertung an.
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClose){
				mainFrame.setVisible(false);
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
    	btnSave.setText(languages.getLangBtnSave());
    	btnClose.setText(languages.getLangBtnClose());
    	System.out.println(languages.getLanguage());
    }
  	
    // Setzt Next Button als Standard Button (Enter)
  	// Setzt txtFront Feld aktiv für Eingabe
  	public void setFocus(){
        mainFrame.getRootPane().setDefaultButton(btnSave);
        txtFront.requestFocusInWindow();
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
		
		RegisterGUI gui = new RegisterGUI();
		gui.paint(null);
	}  	
}