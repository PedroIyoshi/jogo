package pedroiyoshi.com.github.jogo.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pedroiyoshi.com.github.jogo.logic.Clicked;

@SuppressWarnings("serial")
public class Cartas extends JButton implements ActionListener{
	private String img = "";
	private boolean open, objetivo;
	private int id;
	private final Icon imagemFechada = new ImageIcon("img/cartaFechada.png");
	private final Clicked clicked;
	
	public Cartas(Clicked clicked){
		this.clicked = clicked;
		setIcon(imagemFechada);
		setPreferredSize(new Dimension(100, 150));
		addActionListener(this);
	}
	
	public void reset() {
		img = "";
		id = 0;
		setIcon(imagemFechada);
		open = false;
		objetivo = false;
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
	
	public void fecharCarta() {
		if(!isObjetivoAlcancado()) {
			setIcon(imagemFechada);
			open = false;
		}else {
			open = true;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isObjetivoAlcancado() {
		return objetivo;
	}
	
	public void objetivoAlcancado(boolean objetivo) {
		this.objetivo = objetivo;
	}
	
	public void setOpen() {
		open = true;
		Icon imagem = new ImageIcon("img/Carta" + img + ".png");
		setIcon(imagem);
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
