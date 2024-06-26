package board;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import player.*;
import colors.*;
import menu.Menu;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

/** Classe do tabuleiro, contém o JFrame principal e os eventos de MouseListener
 * @version 1.0
 */

public class BoardGame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// Painel principal + matriz das casas
	private JPanel contentPane;
	private Square[][] board;
	
	private static int turn = 0; // Turnos alternando para verificar de quem é a vez de jogar
	private Player[] players; // Jogadores
	
	private static boolean leftClicked = false;
	private static Square clickedSquare = null;

	private static boolean game; // Status do game, se está finalizado ou não
	
	private static Timer timerW; // Timer do Jogador 1
	private static Timer timerB; // Timer do jogador 2
	
	/**
	 * Constutor 
	 * @param players Player[] - Matriz dos jogadores
	 * @throws InterruptedException
	 */
	public BoardGame(Player[] players) throws InterruptedException {
		
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("BongasChess");
		this.setBounds(0, 0, 1050, 868);
		this.setLocationRelativeTo(null);
		
		this.players = players;
		game = true; // Jogo rolando
		this.board = new Square[8][8];
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		createBoard();
		
	
	}
	
	/**
	 * Função para criar as casas juntamente com as peças;
	 * Cada casa possui uma coordenada específica e um tamanho no contentPane,
	 * que foi medido e planejado com tamanhos exatos para facilitar a posição
	 */
	private void createBoard() {
		
		// Preto
		
		
        board[0][0] = new Square(new Rook(Cores.BLACK), new Coords<>(0, 0)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][0].setBounds(30, 0, 100, 100);
        
        board[1][0] = new Square(new Knight(Cores.BLACK), new Coords<>(1, 0));
        board[1][0].setBounds(130, 0, 100, 100);
        
        board[2][0] = new Square(new Bishop(Cores.BLACK), new Coords<>(2, 0));
        board[2][0].setBounds(230, 0, 100, 100);
        
        board[3][0] = new Square(new Queen(Cores.BLACK), new Coords<>(3, 0));
        board[3][0].setBounds(330, 0, 100, 100);
        
        board[4][0] = new Square(new King(Cores.BLACK), new Coords<>(4, 0));
        board[4][0].setBounds(430, 0, 100, 100);
        
        board[5][0] = new Square(new Bishop(Cores.BLACK), new Coords<>(5, 0));
        board[5][0].setBounds(530, 0, 100, 100);
        
        board[6][0] = new Square(new Knight(Cores.BLACK), new Coords<>(6, 0));
        board[6][0].setBounds(630, 0, 100, 100);
        
        board[7][0] = new Square(new Rook(Cores.BLACK), new Coords<>(7, 0));
        board[7][0].setBounds(730, 0, 100, 100);
        
        
		
		// Peões Pretos
        
		for(int i = 0; i<8; i++){
			
			board[i][1] = new Square(new Pawn(Cores.BLACK), new Coords<>(i, 1));
			board[i][1].setBounds(i*100+30, 100, 100, 100);
			
			}
		
		// Espaço vazio
		
		for(int y = 2; y<=5; y++){
			for(int x = 0; x<8; x++){
			
				board[x][y] = new Square(new Coords<>(x, y));
				board[x][y].setBounds(100*x+30, 100*y, 100, 100);
			
			}
		}
		
		// Peões Brancos
		
		for(int i = 0; i<8; i++){
			
			board[i][6] = new Square(new Pawn(Cores.WHITE), new Coords<>(i, 6));
			board[i][6].setBounds(i*100+30, 600, 100, 100);
			
			}
		
		// Branco
		
        board[0][7] = new Square(new Rook(Cores.WHITE), new Coords<>(0, 7)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][7].setBounds(30, 700, 100, 100);
        
        board[1][7] = new Square(new Knight(Cores.WHITE), new Coords<>(1, 7));
        board[1][7].setBounds(130, 700, 100, 100);
        
        board[2][7] = new Square(new Bishop(Cores.WHITE), new Coords<>(2, 7));
        board[2][7].setBounds(230, 700, 100, 100);
        
        board[3][7] = new Square(new Queen(Cores.WHITE), new Coords<>(3, 7));
        board[3][7].setBounds(330, 700, 100, 100);
        
        board[4][7] = new Square(new King(Cores.WHITE), new Coords<>(4, 7));
        board[4][7].setBounds(430, 700, 100, 100);
        
        board[5][7] = new Square(new Bishop(Cores.WHITE), new Coords<>(5, 7));
        board[5][7].setBounds(530, 700, 100, 100);
        
        board[6][7] = new Square(new Knight(Cores.WHITE), new Coords<>(6, 7));
        board[6][7].setBounds(630, 700, 100, 100);
        
        board[7][7] = new Square(new Rook(Cores.WHITE), new Coords<>(7, 7));
        board[7][7].setBounds(730, 700, 100, 100);
        
        
        // Adicionando no contentPane e colocando o EventListener
        
        for(int y = 0; y<8; y++) {
        	for(int x = 0; x<8; x++) {
  
        		board[x][y].setOpaque(false);
        		contentPane.add(board[x][y]);
        		board[x][y].addMouseListener(umouseClicked());
        			
        		
        	}
        }
        
        frontSinistro();
	}
	
	/**
	 * Função para reiniciar o Jogo após o término, não foi implementada ainda
	 */
	public void restartBoard() {
		
		contentPane.removeAll();
		
		
		for(int y = 0; y<8; y++) {
			for(int x = 0; x<8; x++) {
				
				board[x][y].updatePiece(null);
				
				
			}
		}
		super.repaint();
		game = true;
		createBoard();
		
		System.out.println("Novo jogo criado.");
	}
	
	/**
	 * Função para retornar o MouseAdapter e fazer o evento de mover as peças
	 * @return MouseAdapter
	 */
	private MouseAdapter umouseClicked() {
		return new MouseAdapter(){
			
			@Override
	        public void mousePressed(MouseEvent e) {
	        	
	        	if(!game) return;
	        	
	        	// Verifica se foi clicado com o botão esquerdo do mouse
	        	if(e.getButton() == MouseEvent.BUTTON1) {
	        		
	        		if(!leftClicked) { // variável estática para verificar se já tem uma casa selecionada ou não
	        				        			
	        			Square sq = (Square)e.getComponent();
	        			
	        			if(sq.getPiece() != null) { // Verifica se a casa está vazia
	        			
	        				if(players[turn%2].getColor() == sq.getPiece().getColor()) { // Evitar que players Brancos movam peças pretas
	        				
	        					clickedSquare = sq; // Salva a casa selecionada em uma variável Square estática
	        					leftClicked = true;
	        					clickedSquare.switchSelected(); // Muda a cor da casa selecionada para um verde
	        				}
	        			
	        			}
	        		}
	        	
	        		else {
	        			// Se já tiver uma casa selecionada
	        			clickedSquare.switchSelected();
	        			leftClicked = false;
	        			
	        			if(((Square) e.getComponent()).getPiece() == null) { 
	        			
	        				// Se a casa estiver vazia, ele vai mover a casa
	        				if(players[turn%2].movePieces(clickedSquare, Square.class.cast(e.getComponent()), getGame())) {
	        					turn++;
	        					switchTimer();
	        				}
	        			
	        			}
	        			
	        			else {
	        				
	        				// Se não estiver vazia, vai comer a peça	
	        				if(players[turn%2].eatPieces(clickedSquare, Square.class.cast(e.getComponent()), getGame())) {
	        					turn++;
	        					switchTimer();
      							        					
	        				}
								
							
	        			}
	        			
	        			clickedSquare = null;
	        		}
	        	
	        	}
	        	// Verifica se foi clicado com o botão esquerdo do mouse
	        	
	        	/*
	        	else if(e.getButton() == MouseEvent.BUTTON3) {
	        		Square sq = Square.class.cast(e.getComponent());
	        		sq.setRightClicked();
	        	}
	        	*/
			}	
	    };  
	}
	
	/**
	 * Função que retorna o estado da casa selecionada, verificar se está vazia ou não
	 * @param c2 Coords<Integer, Integer> - Par de coordenadas
	 * @return boolean 
	 */
	public boolean checkSquare(Coords<Integer, Integer> c2) {
        if(board[c2.xc][c2.yc].getPiece() == null) {
            return true;
        }
        return false;
    }
	
	public Square getSquare(Coords<Integer, Integer> c) {
		return board[c.xc][c.yc];
	}
	
	public void addPanel(JPanel panel) {
		panel.setBounds(0, 0, 200, 200);
		panel.setVisible(true);
		contentPane.add(panel);
		
		super.repaint();
	}
	
	
	/**
	 * retorna o próprio BoardGame, criado para implementar no MouseListener
	 * @return BoardGame
	 */
	private BoardGame getGame() {
		return this;
	}
	
	/**
	 * Função para alterar o timer entre o jogador 1 e o jogador 2
	 */
	public static void switchTimer() {
		
		
		if(!game) return; // Se não tiver o jogo acontecendo, retorna
		
		switch(turn%2) {
		
		case 0:
			timerW.ResumeTimer();
			try {
				timerB.PauseTimer();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			break;
			
		case 1:
			try {
				timerW.PauseTimer();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			timerB.ResumeTimer();
		}
	}
	
	/** Parte visual do código, incluindo a criação das Labels e Panels
	 *
	 */
	private void frontSinistro() {
		
		
		// Painel Lateral
		
		JLabel name1 = new JLabel(players[0].getName());
		name1.setForeground(new Color(255, 255, 255));
		name1.setFont(new Font("Corbel", Font.BOLD, 15));
		name1.setBounds(860, 695, 108, 30);
		contentPane.add(name1);
		
		JLabel name2 = new JLabel(players[1].getName());
		name2.setForeground(Color.WHITE);
		name2.setFont(new Font("Corbel", Font.BOLD, 15));
		name2.setBounds(860, 15, 108, 30);
		contentPane.add(name2);
		
		// Criação do Timer
		try {
			timerW = new Timer(true);
			timerW.setForeground(new Color(255, 255, 255));
			timerW.setBounds(860, 715, 150, 50);
			contentPane.add(timerW);
			timerW.setOpaque(false);
			
			timerB = new Timer(false);
			timerB.setForeground(Color.WHITE);
			timerB.setBounds(860, 35, 150, 50);
			contentPane.add(timerB);
			// timerB.setLayout(null);
			timerB.setOpaque(false);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		// Visual do Timer
		JLabel timerWIc = new JLabel("");
		timerWIc.setBounds(860, 40, 150, 50);
		timerWIc.setIcon(new ImageIcon(String.format("imgs/%s/boardi/TimerIc.png", Menu.THEME)));
		contentPane.add(timerWIc);
		
		JLabel timerBIc = new JLabel("");
		timerBIc.setBounds(860, 720, 150, 50);
		timerBIc.setIcon(new ImageIcon(String.format("imgs/%s/boardi/TimerIc.png", Menu.THEME)));
		contentPane.add(timerBIc);
		
		
		// Barra lateral com os números
		
		JPanel uVariables = new JPanel();
		uVariables.setBounds(860, 180, 150, 460);
		contentPane.add(uVariables);
		uVariables.setLayout(null);
		uVariables.setOpaque(false);
		
		JLabel uVarIcon = new JLabel("");
		uVarIcon.setBounds(0, 0, 150, 460);
		uVarIcon.setIcon(new ImageIcon(String.format("imgs/%s/boardi/uVariables.png", Menu.THEME)));
		uVariables.add(uVarIcon);
		
		
		JLabel sideNum = new JLabel("");
		sideNum.setIcon(new ImageIcon(String.format("imgs/%s/boardi/sideNum.png", Menu.THEME)));
		sideNum.setBounds(0, 0, 30, 800);
		contentPane.add(sideNum);
		
		JLabel downLetters = new JLabel("");
		downLetters.setIcon(new ImageIcon(String.format("imgs/%s/boardi/downLetters.png", Menu.THEME)));
		downLetters.setBounds(0, 800, 830, 30);
		contentPane.add(downLetters);
		
		JLabel sidePanel = new JLabel("");
		sidePanel.setIcon(new ImageIcon(String.format("imgs/%s/boardi/sidePanel.jpg", Menu.THEME)));
		sidePanel.setBounds(840, 0, 194, 830);
		contentPane.add(sidePanel);
		
		
		
		
		// Painel principal do tabuleiro
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(30, 0, 800, 800);
		contentPane.add(boardPanel);
		boardPanel.setLayout(null);
		
		JLabel boardLabel = new JLabel("");
		boardLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		boardLabel.setBounds(0, 0, 800, 800);
		boardLabel.setIcon(new ImageIcon(String.format("imgs/%s/boardi/boardframe.png", Menu.THEME)));
		boardPanel.add(boardLabel);
		
		JLabel divs = new JLabel("");
		divs.setIcon(new ImageIcon(String.format("imgs/%s/boardi/temp.png", Menu.THEME)));
		divs.setBounds(830, 0, 10, 830);
		contentPane.add(divs);
		
	
		
	}
	
	/**
	 * Atualiza o status do jogo
	 * @param gameSt boolean: game
	 */
	public static void setGame(boolean gameSt){
		game = gameSt;
	}
	
	
	public Player[] getPlayers() {
		return this.players;
	}
	
	/** Função de pausar os dois timers */
	public static void stopTimers(){

		try{
			
			timerB.PauseTimer();
			timerW.PauseTimer();
			
			}
			
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void resetTurn() {
		turn = 0;
	}
	
}

