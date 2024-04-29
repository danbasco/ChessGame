package player;


import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Timer extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel timelabel = new JLabel();
	private boolean timeRunning = true;
	private int timeMin;
	private int timeSec;
	
	
	public Timer(boolean timeRunning) throws InterruptedException {
		
		this.timeRunning = timeRunning;
		// setBackground(Color.WHITE);
		
		
		timelabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		timelabel.setForeground(Color.WHITE);
		timelabel.setText("10:00");
		add(timelabel);
		
		startTimer();
	}
	
	

	private Runnable time = new Runnable() {
		
		
		@Override
		public void run() {
		final int totalT = 600;
		
		for(int x = totalT; x >= 0; x--) {
			
			if(!timeRunning) {
				synchronized(this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			updateTime(x);			
			System.out.println(String.format("%02d", timeMin) + ":" + String.format("%02d", timeSec));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
		
		
	};
	
	
	
	private void updateTime(int seconds) {
		
		timeMin = ((seconds%86400)%3600)/60;
		timeSec = ((seconds%86400)%3600)%60;
				
		timelabel.setText(String.format("%02d", timeMin) + ":" + String.format("%02d", timeSec));
	}
	
	
	
	
	public void startTimer() throws InterruptedException {
		
		Thread t1 = new Thread(time);
		t1.start();
		
	}
	
	public void PauseTimer() throws InterruptedException {
		timeRunning = false;
		
	}
	
	
	
	public void ResumeTimer() {
		timeRunning = true;
		
		synchronized(time) {
			time.notify();
		}
		
	}
	
}