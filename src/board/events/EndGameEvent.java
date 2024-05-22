/*  */


package board.events;

import board.BoardGame;
import playsounds.Sounds;

public class EndGameEvent{
	
	private EventListener eventListener;
	private Event event;

	public EndGameEvent() {
		
		eventListener = new EventListener();

		this.event = new Event() {
			
			@Override
			public void EventCallBack(){

				try {
					Sounds.gameEnd();
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
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
