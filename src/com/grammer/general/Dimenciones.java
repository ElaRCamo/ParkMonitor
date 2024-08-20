package com.grammer.general;

public class Dimenciones {

	public int getAnchura(int longitud) {
		int j = 140;
		for (int i = 1; i < longitud; i++) {
			j = j - 4;
			System.out.println("J = " + j);
		}
		return j;
	}
	
	public int getAltura(int longitud) {
		int j = 160;
		for (int i = 1; i < longitud; i++) {
			j = j - 4;
			System.out.println("J = " + j);
		}
		return j;
	}
	
	public int getSize(int anchura) {
		System.out.println("anchura: " + anchura);
		if (anchura > 17) { 
			return 2; 
		} 
		
		if (anchura == 17) {
			return 3;
		}
		else {
			return 4; 
		}
	}
	
	public static void main(String [] agrs) {
		//alto(17);
	}
	
	public int getAnchuraW(int longitud) {
		int j = 100;
		for (int i = 1; i < longitud; i++) {
			j = j - 4;
			System.out.println("J = " + j);
		}
		return j;
	}
	
	public int getAlturaW(int longitud) {
		int j = 120;
		for (int i = 1; i < longitud; i++) {
			j = j - 4;
			System.out.println("J = " + j);
		}
		return j;
	}
	
	public int getSizeW(int anchura) {
		System.out.println("anchura: " + anchura);
		if (anchura > 17) { 
			return 2; 
		} 
		
		if (anchura == 17) {
			return 3;
		}
		else {
			return 4; 
		}
	}
	
	public int getAnchuraWIndividual(int longitud) {
		int j = 100;
		for (int i = 1; i < longitud; i++) {
			j = j - 4;
			System.out.println("J = " + j);
		}
		return j;
	}
	
	public int getPosicionIndividual(int longitud) {
		int aux = (longitud * 9) / 2;
		System.out.println("300 - " + aux);
		return 180 - aux;
	}
}
