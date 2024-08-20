package com.grammer.frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.grammer.general.Imagen;

public class itDenegado extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Imagen lblImagen_1 = new  Imagen();
	Imagen lblImagen_2 = new  Imagen();
	
	JLabel lblDenegado = new JLabel();
	JLabel lblError = new JLabel();
	JButton btnRegresar = new JButton();

	
	Color color1=new Color(38,76,114);
	
	private JPanel contentPane = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itDenegado frame = new itDenegado("Error");
					frame.setLocationRelativeTo(null);
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
	public itDenegado(String mensage) {
		
		Timer timer1= new Timer(2000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
			
		});
		
		timer1.start();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Denegado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(itDenegado.class.getResource("/com/grammer/it/images/cancelar.png")));
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
     	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,350,494,190);
		setVisible(true);
		contentPane.setBackground(color1);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblImagen_1 = new Imagen("cancelar.png", 3, 750, 750);
		lblImagen_1.setBounds(36, 11, 124, 114);
		contentPane.add(lblImagen_1);
		
		JLabel lblDenegado = new JLabel(mensage);
		lblDenegado.setForeground(Color.WHITE);
		lblDenegado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDenegado.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblDenegado.setBounds(168, 50, 288, 14);
		contentPane.add(lblDenegado);
		
		JLabel lblError = new JLabel("Registro no actualizado");
		lblError.setForeground(Color.RED);
		lblError.setBounds(200, 70, 236, 15);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Monospaced", Font.BOLD, 17));
		contentPane.add(lblError);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}

}
