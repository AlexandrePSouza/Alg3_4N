import java.util.*;
import javax.swing.*;

public class Principal {
	public static void main(String[] args) {

		String[] naipe = { "C", "E", "O", "P" };
		String[] numer = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X",
				"J", "Q", "K" };

		ArrayList<String> baralho = new ArrayList<String>();

		for (int a = 0; a < 13; a++) {
			for (int b = 0; b < 4; b++) {
				baralho.add(numer[a] + naipe[b]);
			}
		}

		// Mostra o array
		System.out.println(baralho);

		//
		Collections.shuffle(baralho);
		System.out.println(baralho);

		ArrayList<String> jogador1 = new ArrayList<String>();
		ArrayList<String> jogador2 = new ArrayList<String>();
		ArrayList<String> jogador3 = new ArrayList<String>();
		ArrayList<String> jogador4 = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			jogador1.add(baralho.remove(0));
			jogador2.add(baralho.remove(0));
			jogador3.add(baralho.remove(0));
			jogador4.add(baralho.remove(0));
		}

		String cartaMesa = baralho.remove(0);

		System.out.println("Cartas do jogador 1..: " + jogador1);
		System.out.println("Cartas do jogador 2..: " + jogador2);
		System.out.println("Cartas do jogador 3..: " + jogador3);
		System.out.println("Cartas do jogador 4..: " + jogador4);
		System.out.println("Cartas monte compra..: " + baralho);
		System.out.println("Cartas monte descarte: " + cartaMesa);

		String cartaMao = "";
		boolean descartou = false;

		
		
		
		
		
		
		
		
		while (baralho.size() > 0) {

			descartou = false;
			for (int i = 0; i < jogador1.size(); i++) {
				cartaMao = jogador1.get(i);
				if ((cartaMesa.charAt(0) == cartaMao.charAt(0))	|| (cartaMesa.charAt(1) == cartaMao.charAt(1))) {
					descartou = true;
					cartaMesa = cartaMao;
					jogador1.remove(i);
					System.out.println("(---) O jogador 1 descartou a carta: "+ cartaMao);
					if (jogador1.size() == 0){
						System.out.println("O jogador 1 ganhou o jogo");
						System.exit(0);
					}
					break;
				}
			}

			if (descartou == false) {
				System.out.println("(+++) O jogador 1 teve que comprar uma carta");
				jogador1.add(baralho.remove(0));
			} 
			else{
				
			}

			descartou = false;
			for (int i = 0; i < jogador2.size(); i++) {
				cartaMao = jogador2.get(i);
				if ((cartaMesa.charAt(0) == cartaMao.charAt(0))	|| (cartaMesa.charAt(1) == cartaMao.charAt(1))) {
					descartou = true;
					cartaMesa = cartaMao;
					jogador2.remove(i);
					System.out.println("(---) O jogador 2 descartou a carta: "+ cartaMao);
					if (jogador2.size() == 0){
						System.out.println("O jogador 2 ganhou o jogo");
						System.exit(0);
					}
					break;
				}
			}

			if (descartou == false) {
				System.out.println("(+++) O jogador 2 teve que comprar uma carta");
				jogador2.add(baralho.remove(0));
			}

			
			descartou = false;
			for (int i = 0; i < jogador3.size(); i++) {
				cartaMao = jogador3.get(i);
				if ((cartaMesa.charAt(0) == cartaMao.charAt(0))	|| (cartaMesa.charAt(1) == cartaMao.charAt(1))) {
					descartou = true;
					cartaMesa = cartaMao;
					jogador3.remove(i);
					System.out.println("(---) O jogador 3 descartou a carta: "+ cartaMao);
					if (jogador3.size() == 0){
						System.out.println("O jogador 3 ganhou o jogo");
						System.exit(0);
					}
					break;
				}
			}

			if (descartou == false) {
				System.out.println("(+++) O jogador 3 teve que comprar uma carta");
				jogador3.add(baralho.remove(0));
			} 
			
			descartou = false;
			for (int i = 0; i < jogador4.size(); i++) {
				cartaMao = jogador4.get(i);
				if ((cartaMesa.charAt(0) == cartaMao.charAt(0))	|| (cartaMesa.charAt(1) == cartaMao.charAt(1))) {
					descartou = true;
					cartaMesa = cartaMao;
					jogador4.remove(i);
					System.out.println("(---) O jogador 4 descartou a carta: "+ cartaMao);
					if (jogador4.size() == 0){ 
						System.out.println("O jogador 4 ganhou o jogo");
						System.exit(0);
					}
					break;
				}
			}

			if (descartou == false) {
				System.out.println("(+++) O jogador 4 teve que comprar uma carta");
				jogador4.add(baralho.remove(0));
			} 
	
			System.out.println("----------------------------------------------");
			System.out.println("Cartas do jogador 1..: " + jogador1);
			System.out.println("Cartas do jogador 2..: " + jogador2);
			System.out.println("Cartas do jogador 3..: " + jogador3);
			System.out.println("Cartas do jogador 4..: " + jogador4);
			System.out.println("Cartas monte compra..: " + baralho);
			System.out.println("Cartas monte descarte: " + cartaMesa);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException ex) {
			}
		}
		
	}
}
