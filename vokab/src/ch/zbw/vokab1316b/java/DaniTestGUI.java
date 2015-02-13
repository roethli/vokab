package ch.zbw.vokab1316b.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;

public class DaniTestGUI {

	private JFrame frame;
	private JTextField txtfield_frontside;
	private JTextField txtfield_try;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaniTestGUI window = new DaniTestGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DaniTestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		/**
		 * Neue Logik erstellen
		 */
		final VokabLogic logic = new VokabLogic();
		
		/**
		 * Testkarten hinzufügen
		 */
		logic.addCard("Hallo", "hello", 1);
		logic.addCard("Nein", "no", 2);
		logic.addCard("Tier", "animal", 3);
		logic.addCard("Hund", "dog", 4);
		logic.addCard("Katze", "cat", 5);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextPane txtPaneResult = new JTextPane();
		txtPaneResult.setBackground(SystemColor.control);
		txtPaneResult.setBounds(251, 139, 106, 85);
		frame.getContentPane().add(txtPaneResult);
		
		/**
		 * Karte prüfen. D.h. Eingabe checken und Resultat im txtpane ausgeben....
		 * 
		 */
		
		JButton btnPrfen = new JButton("pr\u00FCfen");
		btnPrfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			boolean check = logic.checkCard(txtfield_try.getText(), txtfield_frontside.getText());
			/*
			 * wenn true nächste Karte anzeigen und "Richtig :-)" ausgeben - txtfield_ty clearen usw.
			 */
			if(check)
			{
				txtPaneResult.setText("RICHTIG :-)");
				txtfield_try.setText("");
				txtfield_frontside.setText(logic.cardLogicByRandom());
			}
			/*
			 * Wenn false nochmal probieren und "Falsch :-(" ausgeben
			 */
			else
			{
				txtPaneResult.setText("Falsch :-(");
				txtfield_try.setText("Huera Tubel probiers nomol");
			}
			
			
			
			}
		});
		
		
		
		btnPrfen.setBounds(58, 191, 89, 23);
		frame.getContentPane().add(btnPrfen);
		
		txtfield_frontside = new JTextField();
		txtfield_frontside.setEditable(false);
		txtfield_frontside.setBounds(58, 34, 273, 35);
		frame.getContentPane().add(txtfield_frontside);
		txtfield_frontside.setColumns(10);
		
		txtfield_try = new JTextField();
		txtfield_try.setBounds(58, 93, 273, 35);
		frame.getContentPane().add(txtfield_try);
		txtfield_try.setColumns(10);
		
		/**
		 * erster Eintrag in Textfeld
		 */
		txtfield_frontside.setText(logic.cardLogicByRandom());
	}
}
