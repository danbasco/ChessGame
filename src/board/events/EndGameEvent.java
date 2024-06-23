package board.events;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import board.BoardGame;
import board.Movements;
import player.Player;
import playsounds.Sounds;
import java.io.*;

/**
 * Evento para ser chamado ao fim do jogo
 * @version 1.0
 */
public class EndGameEvent{
	
	private EventListener eventListener;
	private Event event;
	
	/**
	 * Construtor da Classe
	 * @param b BoardGame - Recebe o tabuleiro como parâmetro o evento
	 */
	public EndGameEvent(Player p) {
		
		eventListener = new EventListener();
		
		/** Criando o evento utilizando classe anônima */
		this.event = new Event() {
			
			@Override
			public void EventCallBack(){

				try {
					/**{@link playsounds.Sounds#gameEnd()} */
					Sounds.gameEnd();
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
				BoardGame.setGame(false); // Parar o jogo
				BoardGame.stopTimers(); // Parar o tabuleiro
				try {
					printVencedor(p);
				}
				catch (IOException e){
					System.out.println("erro ao gravar o vencedor");
				}
				
				// BoardGame.newGame(b);
				
			}

		};
		eventListener.addHandler(event); // Adicionando o evento no handler
	}
	
	/**
	 * Retorna o evento da classe
	 * @return Event - Event {@link board.events.Event}
	 */
	public Event event(){
		return this.event;
	}
	
    private void printVencedor(Player p) throws IOException{
    	System.out.println("Vencedor: " + p.getName());
		BufferedWriter bw = new BufferedWriter(new FileWriter("logs/" + Movements.match + ".txt", true));
		bw.write("\n");
		bw.write("Vencedor: "+ p.getName());
		bw.close();
    }
}
