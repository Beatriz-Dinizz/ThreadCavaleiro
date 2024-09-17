package controller;

import java.util.Random;

public class ThreadCavaleiro extends Thread {
	private String nomeCavaleiro;
	private int distanciaMetros = 0;
	private int velocidadeMS;
	private static boolean pegouTocha = false;
	private static boolean pegouPedra = false;
	int tempo = 100;
	
	public ThreadCavaleiro(String nomeCavaleiro) {
		this.nomeCavaleiro = nomeCavaleiro;
		this.velocidadeMS = new Random().nextInt(3) + 2;
	}
	
	@Override
	public void run() {
		try {
			while (distanciaMetros < 2000) {
				distanciaMetros += velocidadeMS;
				
				System.out.println(nomeCavaleiro + " percorreu " + distanciaMetros + " metros.");
				
				if (distanciaMetros >= 500 && !pegouTocha) {
					pegouTocha = true;
					
					velocidadeMS += 2;
					
					System.out.println(nomeCavaleiro + " pegou a tocha! Sua nova velocidade é de: " + velocidadeMS);
				}
				
				if(distanciaMetros >= 1500 && !pegouPedra && !pegouTocha) {
					pegouPedra = true;
					
					velocidadeMS += 2;
					
					System.out.println(nomeCavaleiro + " pegou a pedra brilhante! Sua nova velocidade é de: " + velocidadeMS);
				}
				
				Thread.sleep(tempo);
			}
			
			System.out.println(nomeCavaleiro + " chegou ao final do corredor.");
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void abrirPorta() {
		Random random = new Random();
		int portaEscolhida = random.nextInt(4) + 1;
		
		if (portaEscolhida == 2) {
			System.out.println(nomeCavaleiro + " escolheu a porta " + portaEscolhida + " e escapou do monstro!");
		} else {
			System.out.println(nomeCavaleiro + " escolheu a porta " + portaEscolhida + " e foi devorado pelo monstro!");
		}
	}
}
