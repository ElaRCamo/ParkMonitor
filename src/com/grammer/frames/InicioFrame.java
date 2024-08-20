package com.grammer.frames;

import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.grammer.frames.Login;

public class InicioFrame {
	public static void main(String[] args) throws MalformedURLException, InterruptedException, UnsupportedLookAndFeelException {
		JFrame childFrame;
		UIManager.setLookAndFeel( new FlatIntelliJLaf() );
		childFrame = new Login();
		childFrame.setResizable(false);
		childFrame.setLocationRelativeTo(null);
	}

}
