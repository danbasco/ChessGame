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

import colors.*;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class Board extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Square[][] board;

	/**
	 * Create the frame.
	 */
	public Board() {
		
		this.board = new Square[8][8]; // O TABULEIRO É UMA MATRIZ DE CASAS
             
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 868);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frontCabuloso();
		
		createBoard();
		
	
	}
	
	private void createBoard() {
		
		// PRETO
		
        board[0][0] = new Square(new Rook(Cores.BLACK)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][0].setBounds(30, 0, 100, 100);
        
        board[1][0] = new Square(new Knight(Cores.BLACK));
        board[1][0].setBounds(130, 0, 100, 100);
        
        board[2][0] = new Square(new Bishop(Cores.BLACK));
        board[2][0].setBounds(230, 0, 100, 100);
        
        board[3][0] = new Square(new Queen(Cores.BLACK));
        board[3][0].setBounds(330, 0, 100, 100);
        
        board[4][0] = new Square(new King(Cores.BLACK));
        board[4][0].setBounds(430, 0, 100, 100);
        
        board[5][0] = new Square(new Bishop(Cores.BLACK));
        board[5][0].setBounds(530, 0, 100, 100);
        
        board[6][0] = new Square(new Knight(Cores.BLACK));
        board[6][0].setBounds(630, 0, 100, 100);
        
        board[7][0] = new Square(new Rook(Cores.BLACK));
        board[7][0].setBounds(730, 0, 100, 100);
        
		
		// PEOES PRETOS
        
		for(int i = 0; i<8; i++){
			
			board[i][1] = new Square(new Pawn(Cores.BLACK));
			board[i][1].setBounds(i*100+30, 100, 100, 100);
			
			}
		
		// ESPAÇO VAZIO
		for(int y = 2; y<=5; y++){
			for(int x = 0; x<8; x++){
			
				board[x][y] = new Square();
				board[x][y].setBounds(100*x+30, 100*y, 100, 100);
			
			}
		}
		
		// PEOES BRANCOS
		
		for(int i = 0; i<8; i++){
			
			board[i][6] = new Square(new Pawn(Cores.WHITE));
			board[i][6].setBounds(i*100+30, 600, 100, 100);
			
			}
		
		// BRANCO
		
		
		
        board[0][7] = new Square(new Rook(Cores.WHITE)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][7].setBounds(30, 700, 100, 100);
        
        board[1][7] = new Square(new Knight(Cores.WHITE));
        board[1][7].setBounds(130, 700, 100, 100);
        
        board[2][7] = new Square(new Bishop(Cores.WHITE));
        board[2][7].setBounds(230, 700, 100, 100);
        
        board[3][7] = new Square(new Queen(Cores.WHITE));
        board[3][7].setBounds(330, 700, 100, 100);
        
        board[4][7] = new Square(new King(Cores.WHITE));
        board[4][7].setBounds(430, 700, 100, 100);
        
        board[5][7] = new Square(new Bishop(Cores.WHITE));
        board[5][7].setBounds(530, 700, 100, 100);
        
        board[6][7] = new Square(new Knight(Cores.WHITE));
        board[6][7].setBounds(630, 700, 100, 100);
        
        board[7][7] = new Square(new Rook(Cores.WHITE));
        board[7][7].setBounds(730, 700, 100, 100);
        
        
        
        for(int y = 0; y<8; y++) {
        	for(int x = 0; x<8; x++) {
        		
        		board[x][y].addMouseListener(umouseClicked());
        		contentPane.add(board[x][y]);
        		
        	}
        }
	}
	
	private void frontCabuloso() {
		
		JLabel sideNum = new JLabel("");
		sideNum.setIcon(new ImageIcon(Board.class.getResource("/imgs/boardi/sideNum.png")));
		sideNum.setBounds(0, 0, 30, 800);
		contentPane.add(sideNum);
		
		JLabel downLetters = new JLabel("");
		downLetters.setIcon(new ImageIcon(Board.class.getResource("/imgs/boardi/downLetters.png")));
		downLetters.setBounds(0, 800, 830, 30);
		contentPane.add(downLetters);
		
		JLabel sidePanel = new JLabel("");
		sidePanel.setIcon(new ImageIcon(Board.class.getResource("/imgs/boardi/sidePanel.jpg")));
		sidePanel.setBounds(830, 0, 194, 830);
		contentPane.add(sidePanel);
	}
	


	public MouseAdapter umouseClicked() {
		
		return new MouseAdapter() {
			
			
	        public void mouseClicked(MouseEvent e) {
	            e.getSource();
	            // TODO Implements Pair to get OBJ coordinates
	        }

	    };
	    
	}
}

