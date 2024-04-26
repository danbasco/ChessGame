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
import player.Player;
import player.Player.GameEndingException;
import colors.*;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Callable;

import javax.swing.ImageIcon;

public class BoardGame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Square[][] board;
	
	private static int turn = 0;
	private Player[] players;
	
	private static boolean leftClicked = false;
	private static Square clickedSquare = null;
	
	private static boolean game = true;
	
	
	
	public BoardGame(Player[] players) {
		
		this.players = players;
				
		this.board = new Square[8][8]; // O TABULEIRO É UMA MATRIZ DE CASAS
             
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 868);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		createBoard();
		frontCabuloso();
				
		
	
	}
	
	private void createBoard() {
		
		// PRETO
		
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
        
		
		// PEOES PRETOS
        
		for(int i = 0; i<8; i++){
			
			board[i][1] = new Square(new Pawn(Cores.BLACK), new Coords<>(i, 1));
			board[i][1].setBounds(i*100+30, 100, 100, 100);
			
			}
		
		// ESPAÇO VAZIO
		for(int y = 2; y<=5; y++){
			for(int x = 0; x<8; x++){
			
				board[x][y] = new Square(new Coords<>(x, y));
				board[x][y].setBounds(100*x+30, 100*y, 100, 100);
			
			}
		}
		
		// PEOES BRANCOS
		
		for(int i = 0; i<8; i++){
			
			board[i][6] = new Square(new Pawn(Cores.WHITE), new Coords<>(i, 6));
			board[i][6].setBounds(i*100+30, 600, 100, 100);
			
			}
		
		// BRANCO
		
		
		
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
        
        
        
        for(int y = 0; y<8; y++) {
        	for(int x = 0; x<8; x++) {
  
        		board[x][y].setOpaque(false);
        		contentPane.add(board[x][y]);
        		board[x][y].addMouseListener(umouseClicked());
        			
        		
        	}
        }
	}
	
	// EVENTO QUANDO CLICA NO TABULEIRO
	
	private MouseAdapter umouseClicked() {
		return new MouseAdapter(){
	        public void mouseClicked(MouseEvent e) {
	        	
	           
	        	if(e.getButton() == MouseEvent.BUTTON1) {
	        		
	        		if(!leftClicked) {
	        				        			

	        			Square sq = Square.class.cast(e.getComponent());
	        			
	        			if(sq.getPiece() != null) {
	        			
	        				if(players[turn%2].getColor() == sq.getPiece().getColor()) {
	        				
	        					clickedSquare = Square.class.cast(e.getComponent());
	        					leftClicked = true;
	        		
	        					clickedSquare.switchSelected();
	        				}
	        			
	        			}
	        		}
	        	
	        		else {
	        			
	        			clickedSquare.switchSelected();
	        			leftClicked = false;
	        			
	        			if(Square.class.cast(e.getComponent()).getPiece() == null) {
	        			
	        				
	        				if(players[turn%2].movePieces(clickedSquare, Square.class.cast(e.getComponent()))) {
	        				turn++;
	        				}
	        			
	        			}
	        			
	        			else {
	        				
	        				try {
								if(players[turn%2].eatPieces(clickedSquare, Square.class.cast(e.getComponent()))) {
								turn++;
								}
								
								
							} catch (GameEndingException e1) { // ASYNCIO EVENT TO FINISH GAME
								System.out.println("andre delicia papai (andre que escreveu isso)");
							}
	        			}
	        			
	        			clickedSquare = null;
	        			
	        		}
	        	
	        	}
	        	
	        	
	        
	        }
	    };
	    
	    
	    
	}
	
    
	
	
	private void frontCabuloso() {
		
		JLabel sideNum = new JLabel("");
		sideNum.setIcon(new ImageIcon(BoardGame.class.getResource("/imgs/boardi/sideNum.png")));
		sideNum.setBounds(0, 0, 30, 800);
		contentPane.add(sideNum);
		
		JLabel downLetters = new JLabel("");
		downLetters.setIcon(new ImageIcon(BoardGame.class.getResource("/imgs/boardi/downLetters.png")));
		downLetters.setBounds(0, 800, 830, 30);
		contentPane.add(downLetters);
		
		JLabel sidePanel = new JLabel("");
		sidePanel.setIcon(new ImageIcon(BoardGame.class.getResource("/imgs/boardi/sidePanel.jpg")));
		sidePanel.setBounds(830, 0, 194, 830);
		contentPane.add(sidePanel);
		
		
		// Painel do tabuleiro
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(30, 0, 800, 800);
		contentPane.add(boardPanel);
		boardPanel.setLayout(null);
		
		JLabel boardLabel = new JLabel("");
		boardLabel.setBounds(0, 0, 800, 800);
		boardLabel.setIcon(new ImageIcon(BoardGame.class.getResource("/imgs/boardi/boardframe.png")));
		boardPanel.add(boardLabel);
	}
	

	
}
