package menu;
import java.util.Scanner;

import player.*;

import colors.*;

public class Menu {
	
	
	public static Player createPlayers(Cores color) {
		
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		sc.close();
		
		return new Player(name, color);
		
	}
}
