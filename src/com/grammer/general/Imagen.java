package com.grammer.general;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Imagen extends javax.swing.JPanel {
	
	private static final long serialVersionUID = 1L;
	public String ruta;
	public int place = 0;
		
	public Imagen(String ruta, int place, int width, int height) {
		//this.setSize(121, 168);
		this.setSize(width, height);
		this.place = place;
		this.ruta = ruta;
	}
	 
	public void paint(Graphics grafico) {
			Dimension height = getSize();
			if (place == 1) {
				ImageIcon img = new ImageIcon();
				img = new ImageIcon(ruta);
				grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
				setOpaque(false);
				super.paintComponent(grafico);
			}
			if (place == 2) {
				//System.out.println("Dosss");
				ImageIcon img = new ImageIcon();
				img = new ImageIcon(ruta);
				grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
				setOpaque(false);
				super.paintComponent(grafico);
			}
			
			if (place == 3) {
				//System.out.println("Dosss");
				ImageIcon img = new ImageIcon();
				img = new ImageIcon(getClass().getResource("/com/grammer/imgs/"+ruta)); 
				grafico.drawImage(img.getImage(), 0, 0, height.width, height.height, null);
				setOpaque(false);
				super.paintComponent(grafico);
			}
			
		}
	
	public Image getImageIcon(String newRuta) {
		ImageIcon img = new ImageIcon();
		img = new ImageIcon(ruta);
		
		return img.getImage();
		//grafico.drawImage(img.getImage(), 0, 0, 121, 168, null);
		//setOpaque(false);
	}
	

	
	public Imagen() {
	}
}