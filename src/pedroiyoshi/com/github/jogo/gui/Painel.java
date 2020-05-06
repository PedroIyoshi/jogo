package pedroiyoshi.com.github.jogo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painel extends JPanel implements ActionListener{
	private final String[] opcoes = {
			"Metal", "Lata", "Lata2",
			"Papel", "Folha", "Livro", 
			"Plastico", "Garrafa", "Copo",
			"Organico", "Maca", "Banana",
			"NaoReciclavel", "Seringa", "PapelHigienico",
			"Vidro", "Lampada", "Taca"
	};
	private List<Cartas> cartas = new ArrayList<>();
	private int c, t, aberto=-1;
	Painel(){
		setSize(500, 500);
		for(int i = 0; i < 16; i++) {
			adicionarCarta();
		}
		for(int i = 0; i < 8; i++) {
			do {
				t =(int) Math.floor(Math.random() * 6) * 3;
				c =(int) Math.floor(Math.random() * 2) + 1 + t;
			}while(cartas.stream().filter(carta -> carta.getImagem().equals(opcoes[c])).count() != 0);
			cartas.get(casaAleatorio()).setImagem(opcoes[c]);
			cartas.get(casaAleatorio()).setImagem(opcoes[t]);
		}
	}
	
	private int casaAleatorio() {
		int numero;
		do {
			numero = (int) Math.floor(Math.random() * 16);
		}while(!cartas.get(numero).getImagem().equals(""));
		System.out.println(numero);
		return numero;
	}
	
	private void adicionarCarta() {
		Cartas carta = new Cartas();
		carta.addActionListener(this);
		cartas.add(carta);
		add(carta);
	}
	
	public void actionPerformed(ActionEvent e) {
		aberto++;
		if(aberto == 2) {
			cartas.forEach(c -> c.fecharCarta());
			aberto = 0;
		}
	}
}
