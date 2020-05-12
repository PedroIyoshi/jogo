package com.github.pedroiyoshi.jogo.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.pedroiyoshi.jogo.logic.AddCards;

@SuppressWarnings("serial")
public class Painel extends JPanel implements ActionListener{
	private final AddCards addC = new AddCards();
	
	Painel(){
		setSize(400, 665);
		painelMain();
	}
	
	private void painelGame() {
		setLayout(new GridLayout(4, 4));
		for(int i = 0; i < 16; i++) {
			add(addC.createButton());
		}
		addC.setImage();
	}
	
	private JButton addButton(String text) {
		JButton btn = new JButton(text);
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Arial", Font.BOLD, 30));
		btn.setMaximumSize(new Dimension(250, 50));
		btn.setBackground(new Color(150, 150, 150));
		return btn;
	}
	
	private void painelMain(){
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBackground(new Color(50, 50, 50));
		JButton btnPlay = addButton("Play");
		JButton btnHow = addButton("Como jogar");
		JLabel lblReciclagem = new JLabel("Reciclagem");
		lblReciclagem.setForeground(Color.WHITE);
		lblReciclagem.setFont(new Font("Arial", Font.BOLD, 70));
		lblReciclagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel lblSimbolo = new JLabel(new ImageIcon("img/SimboloReciclagem.png"));
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPlay.addActionListener(this);
		btnHow.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnHow.addActionListener(this);
		lblSimbolo.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(lblReciclagem);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(btnPlay);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(btnHow, lblSimbolo);
		add(Box.createVerticalGlue());
		add(lblSimbolo);
	}
	
	private void how() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JButton voltar = addButton("Voltar");
		JLabel explicacao = new JLabel(new ImageIcon("img/explicacao.png"));
		voltar.setAlignmentX(Component.CENTER_ALIGNMENT);
		voltar.addActionListener(this);
		explicacao.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(explicacao);
		add(Box.createVerticalGlue());
		add(voltar);
		add(Box.createRigidArea(new Dimension(0, 25)));
	}
	
	public void actionPerformed(ActionEvent e) {
		removeAll();
		repaint();
		if(e.getActionCommand().equals("Play")) {
			painelGame();
		}else if(e.getActionCommand().equals("Voltar")){
			painelMain();
		}else {
			how();
		}
		validate();
	}
}
