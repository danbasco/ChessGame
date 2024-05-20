package board.events;

import java.util.ArrayList;

public class EventListener {
	private ArrayList<Event> eventList;
	
	public EventListener() {
		eventList = new ArrayList<>();
	}
	
	public static void Trigger(Event event) {
		event.EventCallBack();
		
	}
	
	public void addHandler(Event event) {
		eventList.add(event);
	}
	
	

}
