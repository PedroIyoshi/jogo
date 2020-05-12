package com.github.pedroiyoshi.jogo.gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Jogo extends JFrame{
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
		add(new Painel());
	}
}
