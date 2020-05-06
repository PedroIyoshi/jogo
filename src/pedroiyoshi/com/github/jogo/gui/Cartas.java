package pedroiyoshi.com.github.jogo.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Cartas extends JButton implements ActionListener{
	private String img = "";
	private boolean open;
	private final Icon imagemFechada = new ImageIcon("img/cartaFechada.png");
	Cartas(){
		setIcon(imagemFechada);
		setPreferredSize(new Dimension(100, 150));
		addActionListener(this);
	}
	
	public String getImagem() {
		return img;
	}
	
	public void setImagem(String img) {
		this.img = img;
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public void fecharCarta() {
		setIcon(imagemFechada);
		open = false;
	}
	
	public void actionPerformed(ActionEvent e) {
		Icon imagem = new ImageIcon("img/Carta" + img + ".png");
		open = true;
		setIcon(imagem);
	}
}
