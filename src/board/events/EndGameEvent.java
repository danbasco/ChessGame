package board.events;

import board.BoardGame;
import playsounds.Sounds;

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
	public EndGameEvent(BoardGame b) {
		
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
}
