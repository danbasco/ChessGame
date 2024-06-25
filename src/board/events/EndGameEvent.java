package board.events;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import javax.swing.*;

import board.BoardGame;
import board.Movements;
import menu.Menu;
import player.Player;
import playsounds.Sounds;

/**
 * Evento para ser chamado ao fim do jogo
 * @version 1.0
 */
public class EndGameEvent extends JWindow{
	
	
	private abstract class MouseAdapter implements MouseListener {
		BoardGame b;
		EndGameEvent end;
		
		protected MouseAdapter(BoardGame b, EndGameEvent end) {
			this.b = b;
			this.end = end;
		}
	
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
	private static final long serialVersionUID = 1L;
	private EventListener eventListener;
	private Event event;
	
	/**
	 * Construtor da Classe
	 * @param b BoardGame - Recebe o tabuleiro como parâmetro o evento
	 */
	public EndGameEvent(Player p, BoardGame b) {
		
		
		this.setVisible(true);
		this.setBounds(0, 0, 600, 300);
		this.setLocationRelativeTo(null);
		
		
		JLabel Winner = new JLabel(p.getName());
		Winner.setForeground(new Color(255, 255, 255));
		Winner.setBounds(50, 91, 480, 55);
		Winner.setFont(new Font("Javanese Text", Font.PLAIN, 36));
		
		this.add(Winner);
		
		
		
		JPanel StartGame = new JPanel();
		StartGame.setBounds(42, 160, 200, 100);
		StartGame.setOpaque(false);
		this.add(StartGame);
		
		
		JPanel viewLog = new JPanel();
		viewLog.setBounds(327, 160, 200, 100);
		viewLog.setOpaque(false);
		this.add(viewLog);
		
		
		JLabel Background = new JLabel();
		Background.setIcon(new ImageIcon(String.format("imgs/%s/boardi/endgame.png", Menu.THEME)));
		this.add(Background);
		
		
		// MouseEvents
		
		StartGame.addMouseListener(new MouseAdapter(b, this) {
			@Override
			 public void mouseClicked(MouseEvent e) {
				b.restartBoard();
				end.removeAll();
				end.setVisible(false);
				BoardGame.resetTurn();
				try {
					Movements.criarLog(b.getPlayers());
					Sounds.gameStart();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		viewLog.addMouseListener(new MouseAdapter(b, this) {
			@Override
			 public void mouseClicked(MouseEvent e) {
				
				try {
					lerPartida();
					Sounds.onCastle();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
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
	
	private void lerPartida() throws IOException {
		
		 BufferedReader b = new BufferedReader(new FileReader("logs/" + Movements.match + ".txt"));
	        String line = "----------";
	        System.out.println(line);
	        
	        while((line = b.readLine()) != null)
	            System.out.println(line);
	        b.close();
	   }
	
	
    private void printVencedor(Player p) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("logs/" + Movements.match + ".txt", true));
		bw.write("\n");
		bw.write("Vencedor: "+ p.getName());
		bw.close();
    }
}
