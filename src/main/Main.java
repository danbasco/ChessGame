package main;

import java.awt.EventQueue;

import board.BoardGame;
import menu.Menu;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
							
					
					// try {
					BoardGame chessgame = new BoardGame(Menu.createPlayers());
					chessgame.setVisible(true);
					chessgame.setResizable(false);
					chessgame.setTitle("BongasChess");
					
					// catch()
					
					
					
				
				
			}
		});

	}

}
