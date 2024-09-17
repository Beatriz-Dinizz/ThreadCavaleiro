package view;

import controller.ThreadCavaleiro;

public class Principal {

	public static void main(String[] args) {
		ThreadCavaleiro cavaleiroUm = new ThreadCavaleiro("Cavaleiro 1");
		ThreadCavaleiro cavaleiroDois = new ThreadCavaleiro("Cavaleiro 2");
		ThreadCavaleiro cavaleiroTres = new ThreadCavaleiro("Cavaleiro 3");
		ThreadCavaleiro cavaleiroQuatro = new ThreadCavaleiro("Cavaleiro 4");
		
		cavaleiroUm.start();
		cavaleiroDois.start();
		cavaleiroTres.start();
		cavaleiroQuatro.start();
	}
}
