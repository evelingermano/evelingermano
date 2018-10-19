package br.com.evegermano.semafaro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Semafarotela extends JFrame {

	private JPanel contentPane;
	private static JLabel label;
	 private ThreadSemaforo semaforo = new ThreadSemaforo();
	/**
	 * Launch the application.
	 */
//  public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Semafarotela frame = new Semafarotela();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

		public static void main(String[] args) {

			ThreadSemaforo semaforo = new ThreadSemaforo();
			Semafarotela sem = new Semafarotela();
			sem.setVisible(true);
			for(int i=1; i<=12; i++) {
//				Semafarotela sem = new Semafarotela(semaforo.getCor());
//				sem.setVisible(true);
				switch (semaforo.getCor()){
				case VERDE:
					label.setIcon(new ImageIcon("C:\\Users\\evelin.santos\\Pictures\\traffic-light-149580_960_720.png"));
				
					break;
				case AMARELO:
					label.setIcon(new ImageIcon("C:\\Users\\evelin.santos\\Pictures\\Yellow-Stoplight.png"));
					
					break;
				case VERMELHO:
					label.setIcon(new ImageIcon("C:\\Users\\evelin.santos\\Pictures\\traffic-light-149581_960_720.png"));
				
					break;
				default:;
				}
				

				semaforo.esperaCorMudar();
			}

			semaforo.desligarSemaforo();
		}

	public Semafarotela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label = new JLabel("");
		

		label.setBounds(10, 32, 299, 199);
		contentPane.add(label);
		


	}
  	
}
