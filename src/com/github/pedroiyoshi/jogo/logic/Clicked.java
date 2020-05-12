package com.github.pedroiyoshi.jogo.logic;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import com.github.pedroiyoshi.jogo.gui.Card;

public class Clicked{
	private boolean close;
	private List<Card> deck = Card.getDeck();
	private Card card, category;
	
	public void setCategory(Card category) {
		if(category.isGoalAchieved()) return;
		this.category = category;
	}
	
	public void setCard(Card card) {
		if(card.isGoalAchieved()) return;
		this.card = card;
	}
	
	public void clicked() {
		if(close) {
			deck.forEach(c -> c.closeCard());
		}
		hasMatch();
		close = false;
		if(deck.stream().filter(c -> c.isOpen() && !c.isGoalAchieved()).count() == 1) {
			close = true;
		}
		if(deck.stream().filter(c -> c.isGoalAchieved()).count() == 16) {
			SwingUtilities.invokeLater(() -> {
				JOptionPane.showMessageDialog(null, "Ganhou");
				deck.forEach(c -> c.reset());
				AddCards addC = new AddCards();
				addC.setImage();
			});
		}
	}
	
	private void hasMatch() {
		if(card == null || category == null || 
		    deck.stream().filter(c -> c.isOpen() && !c.isGoalAchieved()).count() != 1)
			return;
		if(card.getId() - category.getId() == 2 || card.getId() - category.getId() == 1) {
			category.setGoal(true);
			card.setGoal(true);
		}
		card = null;
		category = null;
	}
}
