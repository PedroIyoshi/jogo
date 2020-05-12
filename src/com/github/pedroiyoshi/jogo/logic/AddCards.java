package com.github.pedroiyoshi.jogo.logic;

import java.util.List;
import com.github.pedroiyoshi.jogo.gui.Card;

public class AddCards {
	private final String[] options = {
			"Metal", "Lata", "Lata2",
			"Papel", "Folha", "Livro", 
			"Plastico", "Garrafa", "Copo",
			"Organico", "Maca", "Banana",
			"NaoReciclavel", "Seringa", "PapelHigienico",
			"Vidro", "Lampada", "Taca"
	};
	private int c, t;
	private final List<Card> deck = Card.getDeck();
	
	public Card createButton() {
		Card card = new Card();
		return card;
	}
	
	public void setImage(){
		for(int i = 0; i < 8; i++) {
			do {
				t =(int) Math.floor(Math.random() * 6) * 3;
				c =(int) Math.floor(Math.random() * 2) + 1 + t;
			}while(deck.stream().filter(carta -> carta.getImagem().equals(options[c])).count() != 0);
			deck.get(randomPlace()).setImagem(options[c], c);
			deck.get(randomPlace()).setImagem(options[t], t);
		}
	}
	
	private int randomPlace() {
		int number;
		do {
			number = (int) Math.floor(Math.random() * 16);
		}while(!deck.get(number).getImagem().equals(""));
		return number;
	}
}
