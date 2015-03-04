package ch.zbw.vokab1316b.java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class EditGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFront;
	private JTextField txtBack;
	private JTextField txt_frontLang;
	private JTextField txtBackLang;

	/**
	 * Launch the application.
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
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditGUI frame = new EditGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditGUI() {
		final Logic logic = new Logic().getInstance();	
		
		logic.addCard("hallo", "hi", 1, "de", "en");
		logic.addCard("Nein", "no", 1, "de", "en");
		logic.addCard("Hund", "dog", 1, "de", "en");
		logic.addCard("Ja", "yes", 1, "de", "en");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("Bitte wähle das gewünschte Wort aus");
		
		comboBox.setBounds(47, 11, 355, 28);
		contentPane.add(comboBox);
		
		txtFront = new JTextField();
		txtFront.setBounds(60, 72, 161, 28);
		contentPane.add(txtFront);
		txtFront.setColumns(10);
		
		txtBack = new JTextField();
		txtBack.setColumns(10);
		txtBack.setBounds(231, 72, 161, 28);
		contentPane.add(txtBack);
		
		txt_frontLang = new JTextField();
		txt_frontLang.setColumns(10);
		txt_frontLang.setBounds(11, 73, 39, 26);
		contentPane.add(txt_frontLang);
		
		txtBackLang = new JTextField();
		txtBackLang.setColumns(10);
		txtBackLang.setBounds(402, 73, 39, 26);
		contentPane.add(txtBackLang);
		
		JButton btnndern = new JButton("\u00C4ndern");
		
		btnndern.setBounds(11, 128, 89, 23);
		contentPane.add(btnndern);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setBounds(110, 128, 89, 23);
		contentPane.add(btnLschen);
		
		for(Card i : logic.getVocabularylist())
		{
			comboBox.addItem(i.getFront());
			
		}
		
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (Card i : logic.getVocabularylist())
				{
					
					String front = i.getFront();
					String back = i.getBack();
					String frontLang = i.getLangFront();
					String backLang = i.getLangBack();
					
					if(comboBox.getSelectedItem() == i.getFront())
					{
						txtFront.setText(front);
						txtBack.setText(back);
						txt_frontLang.setText(frontLang);
						txtBackLang.setText(backLang);
					}}
				
				
			}
		});
		
		btnndern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Card i : logic.getVocabularylist())
				{
					
					String front = i.getFront();
					String back = i.getBack();
					String frontLang = i.getLangFront();
					String backLang = i.getLangBack();
					
					if(comboBox.getSelectedItem() == i.getFront())
					{
						i.setFront(txtFront.getText());
						i.setBack(txtBack.getText());
						i.setLangFront(txt_frontLang.getText());
						i.setLangBack(txtBackLang.getText());
						
					}}
				
			}
		});
		

		
	}
	
	
}
