package pedroiyoshi.com.github.jogo.logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import pedroiyoshi.com.github.jogo.gui.Cartas;

public class Clicked{
	private boolean close;
	private List<Cartas> deck = new ArrayList<>();
	private Cartas card, category;
	
	public void setDeck(List<Cartas> deck) {
		this.deck = deck;
	}
	
	public void setCategory(Cartas category) {
		this.category = category;
	}
	
	public void setCard(Cartas card) {
		this.card = card;
	}
	
	public void clicked() {
		if(close) {
			close = false;
			deck.forEach(c -> c.fecharCarta());
		}
		if(deck.stream().filter(c -> c.isOpen() && !c.isObjetivoAlcancado()).count() == 1) {
			close = true;
		}
		hasMatch();
		if(deck.stream().filter(c -> c.isObjetivoAlcancado()).count() == 16) {
			SwingUtilities.invokeLater(() -> {
				JOptionPane.showMessageDialog(null, "Ganhou");
			});
		}
	}
	
	private void hasMatch() {
		if(card == null || category == null) return;
		if(card.getId() - category.getId() == 2 || card.getId() - category.getId() == 1) {
			category.objetivoAlcancado(true);
			card.objetivoAlcancado(true);
		}
		card = null;
		category = null;
	}
}
