package com.grammer.frames;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;

import com.grammer.general.Imagen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class itConcluido extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel lblConcluido = new JLabel();
	JLabel lblProvecho = new JLabel();
	
	Imagen lblImagen_1= new Imagen();
	Imagen lblImagen_2= new Imagen();
	
	JButton btnAceptar = new JButton();
	
	Color color1=new Color(38,76,114);
	

	private JPanel contentPane = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itConcluido frame = new itConcluido();
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
	public itConcluido() {
		
		setBounds(500,350,494,196);
		setVisible(true);
		contentPane.setBackground(color1);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Aceptado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(itConcluido.class.getResource("/com/grammer/it/images/logoVacaciones.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lblImagen_2 = new Imagen("correccion.png", 3, 750, 750);
		lblImagen_2.setBounds(10, 11, 136, 130);
		contentPane.add(lblImagen_2);
		
		JLabel lblSeHaConcluido = new JLabel("Se ha concluido su registro");
		lblSeHaConcluido.setForeground(Color.WHITE);
		lblSeHaConcluido.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblSeHaConcluido.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeHaConcluido.setBounds(166, 36, 288, 14);
		contentPane.add(lblSeHaConcluido);
		btnAceptar.setText("Aceptar");
		
		btnAceptar.setBounds(230, 102, 150, 30);
		contentPane.add(btnAceptar);
		
		JLabel lblProvecho_1 = new JLabel("Actualizado!");
		lblProvecho_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvecho_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		lblProvecho_1.setForeground(Color.GREEN);
		lblProvecho_1.setBounds(224, 61, 176, 14);
		contentPane.add(lblProvecho_1);
		
		getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GREEN));
		
		
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	
	
}
