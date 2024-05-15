package board.events;

import board.BoardGame;

public class EndGameEvent{
	
	private EventListener eventListener;
	private Event event;

	public EndGameEvent() {
		
		eventListener = new EventListener();

		this.event = new Event() {
			
			@Override
			public void EventCallBack(){

				System.out.println("Fim de jogo!");
				BoardGame.setGame(false);
				BoardGame.stopTimers();
				
			}

		};
		eventListener.addHandler(event);
	}

	public Event event(){
		return this.event;
	}
}
