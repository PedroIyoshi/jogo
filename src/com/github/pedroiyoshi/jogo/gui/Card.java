package com.github.pedroiyoshi.jogo.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.github.pedroiyoshi.jogo.logic.Clicked;

@SuppressWarnings("serial")
public class Card extends JButton implements ActionListener{
	private String img = "";
	private static List<Card> deck = new ArrayList<>();
	private boolean open, goal;
	private int id;
	private final Icon imgClosed = new ImageIcon("img/cartaFechada.png");
	private static final Clicked clicked = new Clicked();
	
	public Card(){
		deck.add(this);
		setIcon(imgClosed);
		setPreferredSize(new Dimension(100, 150));
		addActionListener(this);
	}
	
	public static List<Card> getDeck(){
		return deck;
	}
	
	public String getImagem() {
		return img;
	}
	
	public void setImagem(String img, int id) {
		this.img = img;
		this.id = id;
	}
	
	public boolean isOpen() {
		return open;
	}

	public int getId() {
		return id;
	}
	
	public boolean isGoalAchieved() {
		return goal;
	}
	
	public void setGoal(boolean objetivo) {
		this.goal = objetivo;
	}

	private void setOpen() {
		open = true;
		Icon imagem = new ImageIcon("img/Carta" + img + ".png");
		setIcon(imagem);
	}

	public void reset() {
		img = "";
		id = 0;
		setIcon(imgClosed);
		open = false;
		goal = false;
	}
	
	public void closeCard() {
		if(!isGoalAchieved()) {
			setIcon(imgClosed);
			open = false;
		}else {
			open = true;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(id % 3 == 0) {
			clicked.setCategory(this);
		}else {
			clicked.setCard(this);
		}
		clicked.clicked();
		setOpen();
	}
}
