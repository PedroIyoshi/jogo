package pedroiyoshi.com.github.jogo.logic;

import java.util.ArrayList;
import java.util.List;

import pedroiyoshi.com.github.jogo.gui.Cartas;

public class AddCards {
	private final String[] options = {
			"Metal", "Lata", "Lata2",
			"Papel", "Folha", "Livro", 
			"Plastico", "Garrafa", "Copo",
			"Organico", "Maca", "Banana",
			"NaoReciclavel", "Seringa", "PapelHigienico",
			"Vidro", "Lampada", "Taca"
	};
	private List<Cartas> deck = new ArrayList<>();
	private int c, t;
	private final Clicked clicked = new Clicked();
	
	public Cartas createButton() {
		Cartas card = new Cartas(clicked);
		deck.add(card);
		return card;
	}
	
	public void setDeck(List<Cartas> deck) {
		this.deck = deck;
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
		clicked.setDeck(deck);
	}
	
	private int randomPlace() {
		int number;
		do {
			number = (int) Math.floor(Math.random() * 16);
		}while(!deck.get(number).getImagem().equals(""));
		return number;
	}
}
