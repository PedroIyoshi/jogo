package pedroiyoshi.com.github.jogo.gui;

import javax.swing.JPanel;
import pedroiyoshi.com.github.jogo.logic.AddCards;

@SuppressWarnings("serial")
public class Painel extends JPanel{
	private final AddCards addC = new AddCards();
	
	Painel(){
		setSize(500, 500);  
		for(int i = 0; i < 16; i++) {
			add(addC.createButton());
		}
		addC.setImage();
	}
	
}
