package menu;
import java.util.Scanner;

import player.*;

import colors.*;

public class Menu {
	
	
	public static Player createPlayers(Cores color) {
		
		System.out.println("Digite o nome do jogador 1:");
		Scanner sc = new Scanner(System.in);
		String name1 = sc.nextLine();
		
		System.out.println("Digite o nome do jogador 2:");
		String name2 = sc.nextLine();
		sc.close();
		
	
		return new Player(name1, color);

		
		
	}
}
