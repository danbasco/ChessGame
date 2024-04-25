package menu;
import java.util.Scanner;

import player.*;

import colors.*;

public class Menu {
	
	
	public static Player[] createPlayers() {
		
		System.out.println("Digite o nome do jogador 1:");
		Scanner sc = new Scanner(System.in);
		String name1 = sc.nextLine();
		
		System.out.println("Digite o nome do jogador 2:");
		String name2 = sc.nextLine();
		sc.close();
		
		
		Player p1 = new Player(name1, Cores.WHITE);
		Player p2 = new Player(name2, Cores.BLACK);
		
		Player[] ps = new Player[] {
			p1,
			p2
		};
		
		return ps;
		
		
	}
}
