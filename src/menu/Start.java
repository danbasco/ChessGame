package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import board.BoardGame;
import board.Movements;
import colors.Cores;
import player.Player;
import playsounds.Sounds;

/** Classe do menu de iniciar, é chamada após interação com o menu inicial
 * @version 1.0
 */
public class Start extends JFrame implements MouseListener{
	
	private JTextField name1; 
	private JTextField name2;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel start;
	
	/** Construtor da classe */
	Start(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 712, 738); // Tamanho do Menu
		
		this.setVisible(true);
		this.setResizable(false);
		
		// Jpanel para iniciar o jogo
		start = new JPanel();
		start.setOpaque(false);
		start.setBounds(332, 543, 85, 43);
		start.addMouseListener(this);
		getContentPane().add(start);
		
		/** Ambos os text field para inserir o nome dos jogadores */
		name1 = new JTextField();
		name1.setOpaque(false);
		name1.setBorder(null);
		name1.setBounds(62, 351, 356, 52);
		name1.setForeground(new Color(255, 255, 255));
		name1.setFont(new Font("Javanese Text", Font.PLAIN, 36));
		getContentPane().add(name1);
		
		name2 = new JTextField();
		name2.setBorder(null);
		name2.setOpaque(false);
		name2.setForeground(new Color(255, 255, 255));
		name2.setFont(new Font("Javanese Text", Font.PLAIN, 36));
		name2.setBounds(62, 462, 356, 52);
		getContentPane().add(name2);
		
		// Imagemzinha de fundo
		JLabel playerCreation = new JLabel("");
		playerCreation.setIcon(new ImageIcon(String.format("imgs/%s/menu/playerCreation.png", Menu.THEME))); 
		playerCreation.setBounds(0, 0, 732, 702);
		getContentPane().add(playerCreation);
		
	}
	
	
	
	
	/**
	 * Função para criar os players que irão jogar
	 * @param n1 String - Nome 1
	 * @param n2 String - Nome 2
	 * @return Player[] - Retorna uma arrayList com os dois jogadores criados
	 */
	private Player[] createPlayers(String n1, String n2){ 
		
		
		Player p1 = new Player(n1, Cores.WHITE); // Player 1
		Player p2 = new Player(n2, Cores.BLACK); // Player 2
		
		Player[] ps = new Player[] { // Vetor com os dois players
			p1,
			p2
		};
		
		
		return ps;
		
	}
	
	
	/**
	 * Função para evento do mouse
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// Definindo nome padrão dos jogadores
		String n1 = "Player 1";
		String n2 = "Player 2";
		
		if(!name1.getText().equals(""))n1 = name1.getText();
		if(!name2.getText().equals(""))n2 = name2.getText();
		
		try {
			Player [] ps = createPlayers(n1, n2);
			Sounds.gameStart();
			Movements.criarLog(ps);
			new BoardGame(ps); // Criar jogo
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		super.dispose(); // Fechar o JFrame anterior
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}
