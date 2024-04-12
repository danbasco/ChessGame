package main;
import java.awt.EventQueue;

import board.Board;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try { // main
					
					
					
					Board frame = new Board();
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
