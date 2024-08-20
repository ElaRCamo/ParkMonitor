package com.grammer.general;

import java.io.IOException;
import java.net.InetAddress;

/*
 * JPing permite verificar si una máquina en la red responde a un ping, 
 * tanto en un método de prueba principal (main) como en un método reutilizable (validaPing).
 */

public class JPing {
	public static void main(String[] args) {
		InetAddress ping;
		String ip = "10.83.21.18"; // Ip de la máquina remota
		try {
			ping = InetAddress.getByName(ip);
			if(ping.isReachable(5000)){
			//System.out.println(ip+" - responde!");
			}else {
			System.out.println(ip+" - no responde!");
			}
		} catch (IOException ex) { System.out.println(ex); }
		}
	
	
	public boolean validaPing(String ip) {
		InetAddress ping;
		try {
			ping = InetAddress.getByName(ip);
			if(ping.isReachable(5000)){
				//System.out.println(ip+" - responde!");
				return true;
			}
		} catch (IOException ex) { 
			return false;
			//System.out.println("Error de conexión");
			//System.out.println(ex); 
			
		}
		System.out.println("Error de conexión dos");
		return false;
	}
}