package ch.zbw.vokab1316b.java;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import java.awt.Font;

/**
 * Diese Klasse implementiert eine Einfach Erfolgsuebersicht bzw. bekommt der Benutzer eine Tendenz welchen 
 * Fortschritt sein Lernerfolg macht. 
 * @author Daniel Roethlisberger, ZbW
 * @version <b>1.0</b> (10.03.2015)
 */
public class Success extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Success frame = new Success();
					frame.setVisible(true);
					Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(d.width / 2 - frame.getWidth() / 2,
							d.height / 2 - frame.getHeight() / 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Zeichne das Fenster fuer die Uebersicht.
	 */
	public Success() {
		setTitle("Erfolgs\u00FCbersicht");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel chartpanel = new JPanel();
		chartpanel.setBounds(10, 11, 211, 249);
		contentPane.add(chartpanel);
		// Logic Instanz uebernehmen
		Logic logic = new Logic().getInstance();
		// Ein Datenset fuer ein 3d Kuchendiagramm erstellen
		DefaultPieDataset result = new DefaultPieDataset();
		result.setValue("Falsch", logic.getFaultcounter());
		result.setValue("Richtig", logic.getSuccesscounter());
		JFreeChart chart = ChartFactory.createPieChart3D("",result,true,true, false);
		PiePlot3D plot = (PiePlot3D) chart.getPlot(); // Plot erstellen
		plot.setNoDataMessage("noch keine Daten"); // Wird ausgegeben wenn keine Daten verfuegbar sind.
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		Dimension size = new Dimension(220, 220);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(size);
		chartPanel.setZoomTriggerDistance(2);
		chartPanel.setDismissDelay(2000);
		chartPanel.setMaximumDrawHeight(750);

		
		JLabel lbl_sucess_smiles = new JLabel("");
		
		/**
		 * Hier erfolgt die Abfrage der Erfolgs bzw. Misserfolgszahlen.
		 * Je nach Prozentzahl wird ein anderer Text oder ein anderes Bild (Pokal, Smile usw.)
		 * angezeigt um dem Benutzer eine gewissen Motivation zu geben.
		 *
		 */
		   
		if (logic.getPercentSuccess() > logic.getPercentFault()
				&& logic.getPercentSuccess() < 60) {
			lbl_sucess_smiles.setIcon(new ImageIcon(Success.class
					.getResource("/ch/zbw/vokab1316b/java/smile_learn.png")));
			JLabel lblgoodLuck = new JLabel("\"You are on a good way!\"");
			lblgoodLuck.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblgoodLuck.setBounds(307, 61, 120, 21);
			contentPane.add(lblgoodLuck);
			;
		} else if (logic.getPercentSuccess() < logic.getPercentFault()) {
			lbl_sucess_smiles.setIcon(new ImageIcon(Success.class
					.getResource("/ch/zbw/vokab1316b/java/smile_hi.png")));
			JLabel lblgoodLuck = new JLabel("\"don't give up!\"");
			lblgoodLuck.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblgoodLuck.setBounds(307, 61, 120, 21);
			contentPane.add(lblgoodLuck);
			;
		} else if (logic.getPercentSuccess() > 60
				&& logic.getPercentSuccess() < 90) {
			lbl_sucess_smiles.setIcon(new ImageIcon(Success.class
					.getResource("/ch/zbw/vokab1316b/java/smile_good.png")));
			JLabel lblgoodLuck = new JLabel("\"WOW,good job!\"");
			lblgoodLuck.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblgoodLuck.setBounds(307, 61, 120, 21);
			contentPane.add(lblgoodLuck);
			;
			JLabel lvltrophy1 = new JLabel(
					new ImageIcon(
							Success.class
									.getResource("/ch/zbw/vokab1316b/java/trophy_silver.png")));
			lvltrophy1.setBounds(273, 129, 135, 126);
			contentPane.add(lvltrophy1);
			lblgoodLuck.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblgoodLuck.setBounds(307, 61, 120, 21);
			contentPane.add(lblgoodLuck);
			;

		} else if (logic.getPercentSuccess() > 90) {
			lbl_sucess_smiles.setIcon(new ImageIcon(Success.class
					.getResource("/ch/zbw/vokab1316b/java/smile_perfect.png")));
			JLabel lblgoodLuck = new JLabel("\"Congraturlations!\"");

			ImageIcon trophyGold = new ImageIcon(
					"/vokab/src/ch/zbw/vokab1316b/java/trophy_gold.png");

			JLabel lvltrophy1 = new JLabel(
					new ImageIcon(
							Success.class
									.getResource("/ch/zbw/vokab1316b/java/trophy_gold.png")));
			lvltrophy1.setBounds(273, 129, 135, 126);
			contentPane.add(lvltrophy1);
			lblgoodLuck.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblgoodLuck.setBounds(307, 61, 120, 21);
			contentPane.add(lblgoodLuck);
			;
		} else {
			lbl_sucess_smiles.setIcon(new ImageIcon(Success.class
					.getResource("/ch/zbw/vokab1316b/java/smile_learn.png")));
			JLabel lblgoodLuck = new JLabel("\"good luck!\"");
			lblgoodLuck.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblgoodLuck.setBounds(307, 61, 120, 21);
			contentPane.add(lblgoodLuck);
			;
		}

		lbl_sucess_smiles.setBounds(239, 44, 65, 61);
		contentPane.add(lbl_sucess_smiles);

		chartpanel.add(chartPanel);

	}
}
