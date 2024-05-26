package player;

import board.events.*;

import javax.swing.JPanel;


import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

/** Classe do timer do player
 * @version 1.0
 */
public class Timer extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel timelabel = new JLabel();
	private boolean timeRunning = true;
	
	private int timeMin; // Tempo em minutos
	private int timeSec; // Tempo em segundos
	
	/**
	 * Construtor do Timer
	 * @param timeRunning Boolean - Se o timer vai estar correndo ou não
	 * @throws InterruptedException
	 */
	public Timer(boolean timeRunning) throws InterruptedException {
		
		this.timeRunning = timeRunning; //Verifica se o timer está rodando ou parado inicialmente
		
		
		timelabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		timelabel.setForeground(Color.WHITE);
		timelabel.setText("10:00"); // Parte inicial do Timer, para aparecer na interface gráfica
		add(timelabel);
		
		startTimer(); 
	}
	
	
	/** 
	 * Classe anônima para criar um evento assíncrono de timer,
	 * que executa independente do código ou movimentação.											
	 */
	private Runnable time = new Runnable() { 
		@Override
		public void run() {
		final int totalT = 600; // Tempo em segundos
		
		for(int x = totalT; x >= 0; x--) {
			
			if(!timeRunning) { // Caso o tempo pare, pausar o Runnable
				synchronized(this) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			updateTime(x);// Aqui passa o timer atual e a função faz a conversão para {minutos:segundos}		
			
			try {
				Thread.sleep(1000); //Espera 1 segundo para atualizar novamente
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// Fim do Tempo, da Trigger no Evento de EndGame
		
		EventListener.Trigger(new EndGameEvent(null).event());
		
		}
		
		
	};
	
	
	/**
	 * Essa função faz a conversão do tempo em segundos para 
	 * minutos:segundos e atualiza a label visual já no formato
	 * de String
	 * @param seconds int - Tempo em segundos
	 */
	private void updateTime(int seconds) {
		
		timeMin = ((seconds%86400)%3600)/60;
		timeSec = ((seconds%86400)%3600)%60;
				
		timelabel.setText(String.format("%02d", timeMin) + ":" + String.format("%02d", timeSec));
	}
	
	
	
	/**
	 * Função para iniciar o Runnable
	 * @throws InterruptedException
	 */
	public void startTimer() throws InterruptedException {
		
		Thread t1 = new Thread(time);
		t1.start();
		
	}
	
	/**
	 * Função para pausar o Runnable
	 * @throws InterruptedException
	 */
	public void PauseTimer() throws InterruptedException {
		timeRunning = false;
		
	}
	
	
	/**
	 * Função para continuar o Runnable
	 */
	public void ResumeTimer() {
		timeRunning = true;
		
		synchronized(time) {
			time.notify();
		}
		
	}
	
}