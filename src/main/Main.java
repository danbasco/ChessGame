package main;

import java.awt.EventQueue;

import board.BoardGame;
import menu.Menu;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try { // main				
					
					BoardGame frame = new BoardGame(Menu.createPlayers());
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("BongasChess");
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
