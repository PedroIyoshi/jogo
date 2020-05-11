package com.github.pedroiyoshi.jogo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Jogo extends JFrame implements ActionListener{
	private Jogo() {
		setSize(440, 665);
		setTitle("Jogo");
		organizarLayout();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Jogo();
	}
	
	private void organizarLayout() {
		Painel painel = new Painel();
		add(painel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
