package board.events;

import java.util.ArrayList;

/**
 * Classe do EventListener, utilizado para evocar o evento quando for chamado
 * @version 1.0
 */
public class EventListener {
	private ArrayList<Event> eventList; // Arraylist contendo todos os eventos
	
	/** Construtor */
	public EventListener() {
		eventList = new ArrayList<>();
	}
	
	/**
	 * Função para chamar o evento
	 * @param event Event - {@link board.events.Event}
	 */
	public static void Trigger(Event event) {
		event.EventCallBack();
		
	}
	
	/**
	 * Função para adicionar o evento na ArrayList
	 * @param event Event - {@link board.events.Event}
	 */
	public void addHandler(Event event) {
		eventList.add(event);
	}
	
	

}
