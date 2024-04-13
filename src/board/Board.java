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

import java.awt.Color;
import colors.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;

public class Board extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Square[][] board;

	/**
	 * Create the frame.
	 */
	public Board() {
		
		this.board = new Square[8][8]; // O TABULEIRO É UMA MATRIZ DE CASAS
             
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 839);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		frontEndHorrorosomePerdoeSoussa();
		
		createBoard();
		
	
	}
	
	private void createBoard() {
		
		// PRETO
		
        board[0][0] = new Square(new Rook(Cores.BLACK)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][0].setBounds(0, 0, 100, 100);
        
        board[1][0] = new Square(new Knight(Cores.BLACK));
        board[1][0].setBounds(100, 0, 100, 100);
        
        board[2][0] = new Square(new Bishop(Cores.BLACK));
        board[2][0].setBounds(200, 0, 100, 100);
        
        board[3][0] = new Square(new Queen(Cores.BLACK));
        board[3][0].setBounds(300, 0, 100, 100);
        
        board[4][0] = new Square(new King(Cores.BLACK));
        board[4][0].setBounds(400, 0, 100, 100);
        
        board[5][0] = new Square(new Bishop(Cores.BLACK));
        board[5][0].setBounds(500, 0, 100, 100);
        
        board[6][0] = new Square(new Knight(Cores.BLACK));
        board[6][0].setBounds(600, 0, 100, 100);
        
        board[7][0] = new Square(new Rook(Cores.BLACK));
        board[7][0].setBounds(700, 0, 100, 100);
        
		
		// PEOES PRETOS
        
		for(int i = 0; i<8; i++){
			
			board[i][1] = new Square(new Pawn(Cores.BLACK));
			board[i][1].setBounds(i*100, 100, 100, 100);
			
			}
		
		// ESPAÇO VAZIO
		for(int y = 2; y<=5; y++){
			for(int x = 0; x<8; x++){
			
				board[x][y] = new Square();
				board[x][y].setBounds(100*x, 100*y, 100, 100);
			
			}
		}
		
		// PEOES BRANCOS
		
		for(int i = 0; i<8; i++){
			
			board[i][6] = new Square(new Pawn(Cores.WHITE));
			board[i][6].setBounds(i*100, 600, 100, 100);
			
			}
		
		// BRANCO
		
		
		
        board[0][7] = new Square(new Rook(Cores.WHITE)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][7].setBounds(0, 700, 100, 100);
        
        board[1][7] = new Square(new Knight(Cores.WHITE));
        board[1][7].setBounds(100, 700, 100, 100);
        
        board[2][7] = new Square(new Bishop(Cores.WHITE));
        board[2][7].setBounds(200, 700, 100, 100);
        
        board[3][7] = new Square(new Queen(Cores.WHITE));
        board[3][7].setBounds(300, 700, 100, 100);
        
        board[4][7] = new Square(new King(Cores.WHITE));
        board[4][7].setBounds(400, 700, 100, 100);
        
        board[5][7] = new Square(new Bishop(Cores.WHITE));
        board[5][7].setBounds(500, 700, 100, 100);
        
        board[6][7] = new Square(new Knight(Cores.WHITE));
        board[6][7].setBounds(600, 700, 100, 100);
        
        board[7][7] = new Square(new Rook(Cores.WHITE));
        board[7][7].setBounds(700, 700, 100, 100);
        
        
        
        for(int y = 0; y<8; y++) {
        	for(int x = 0; x<8; x++) {
        		
        		contentPane.add(board[x][y]);
        		
        	}
        }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Por favor soussa, não consegui outro jeito de colocar os números bonitinhos ali em baixo no tabuleiro :( front end é muito ruim, por favor entenda
	private void frontEndHorrorosomePerdoeSoussa(){

		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(103, 83, 71));
		sidePanel.setBounds(800, 0, 195, 800);
		contentPane.add(sidePanel);
		
		JLabel sidePanelIMG = new JLabel("");
		sidePanelIMG.setIcon(new ImageIcon(Board.class.getResource("/imgs/boardi/SidePanel.png")));
		sidePanel.add(sidePanelIMG);
		
		JLabel bNum = new JLabel("b");
		bNum.setForeground(new Color(199, 175, 150));
		bNum.setHorizontalAlignment(SwingConstants.CENTER);
		bNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		bNum.setToolTipText("");
		bNum.setVerticalAlignment(SwingConstants.BOTTOM);
		bNum.setBounds(172, 771, 28, 29);
		contentPane.add(bNum);
		
		JLabel aNum = new JLabel("a");
		aNum.setVerticalAlignment(SwingConstants.BOTTOM);
		aNum.setToolTipText("");
		aNum.setHorizontalAlignment(SwingConstants.CENTER);
		aNum.setForeground(new Color(100, 57, 57));
		aNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		aNum.setBounds(72, 771, 28, 29);
		contentPane.add(aNum);
		
		JLabel cNum = new JLabel("c");
		cNum.setVerticalAlignment(SwingConstants.BOTTOM);
		cNum.setToolTipText("");
		cNum.setHorizontalAlignment(SwingConstants.CENTER);
		cNum.setForeground(new Color(100, 57, 57));
		cNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		cNum.setBounds(272, 771, 28, 29);
		contentPane.add(cNum);
		
		JLabel dNum = new JLabel("d");
		dNum.setVerticalAlignment(SwingConstants.BOTTOM);
		dNum.setToolTipText("");
		dNum.setHorizontalAlignment(SwingConstants.CENTER);
		dNum.setForeground(new Color(199, 175, 150));
		dNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		dNum.setBounds(372, 771, 28, 29);
		contentPane.add(dNum);
		
		JLabel eNum = new JLabel("e");
		eNum.setVerticalAlignment(SwingConstants.BOTTOM);
		eNum.setToolTipText("");
		eNum.setHorizontalAlignment(SwingConstants.CENTER);
		eNum.setForeground(new Color(100, 57, 57));
		eNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		eNum.setBounds(472, 771, 28, 29);
		contentPane.add(eNum);
		
		JLabel fNum = new JLabel("f");
		fNum.setVerticalAlignment(SwingConstants.BOTTOM);
		fNum.setToolTipText("");
		fNum.setHorizontalAlignment(SwingConstants.CENTER);
		fNum.setForeground(new Color(199, 175, 150));
		fNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		fNum.setBounds(572, 771, 28, 29);
		contentPane.add(fNum);
		
		JLabel gNum = new JLabel("g");
		gNum.setVerticalAlignment(SwingConstants.BOTTOM);
		gNum.setToolTipText("");
		gNum.setHorizontalAlignment(SwingConstants.CENTER);
		gNum.setForeground(new Color(100, 57, 57));
		gNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		gNum.setBounds(672, 771, 28, 29);
		contentPane.add(gNum);
		
		JLabel hNum = new JLabel("h");
		hNum.setVerticalAlignment(SwingConstants.BOTTOM);
		hNum.setToolTipText("");
		hNum.setHorizontalAlignment(SwingConstants.CENTER);
		hNum.setForeground(new Color(199, 175, 150));
		hNum.setFont(new Font("Cambria", Font.PLAIN, 24));
		hNum.setBounds(772, 771, 28, 29);
		contentPane.add(hNum);
		
		JLabel num1 = new JLabel("   1\r\n\r\n");
		num1.setVerticalAlignment(SwingConstants.TOP);
		num1.setToolTipText("");
		num1.setHorizontalAlignment(SwingConstants.LEFT);
		num1.setForeground(new Color(100, 57, 57));
		num1.setFont(new Font("Cambria", Font.PLAIN, 24));
		num1.setBounds(0, 700, 28, 29);
		contentPane.add(num1);
		
		JLabel num2 = new JLabel("   2");
		num2.setVerticalAlignment(SwingConstants.TOP);
		num2.setToolTipText("");
		num2.setHorizontalAlignment(SwingConstants.LEFT);
		num2.setForeground(new Color(199, 175, 150));
		num2.setFont(new Font("Cambria", Font.PLAIN, 24));
		num2.setBounds(0, 600, 28, 29);
		contentPane.add(num2);
		
		JLabel num3 = new JLabel("   3\r\n\r\n");
		num3.setVerticalAlignment(SwingConstants.TOP);
		num3.setToolTipText("");
		num3.setHorizontalAlignment(SwingConstants.LEFT);
		num3.setForeground(new Color(100, 57, 57));
		num3.setFont(new Font("Cambria", Font.PLAIN, 24));
		num3.setBounds(0, 500, 28, 29);
		contentPane.add(num3);
		
		JLabel num4 = new JLabel("   4");
		num4.setVerticalAlignment(SwingConstants.TOP);
		num4.setToolTipText("");
		num4.setHorizontalAlignment(SwingConstants.LEFT);
		num4.setForeground(new Color(199, 175, 150));
		num4.setFont(new Font("Cambria", Font.PLAIN, 24));
		num4.setBounds(0, 400, 28, 29);
		contentPane.add(num4);
		
		JLabel num5 = new JLabel("   5");
		num5.setVerticalAlignment(SwingConstants.TOP);
		num5.setToolTipText("");
		num5.setHorizontalAlignment(SwingConstants.LEFT);
		num5.setForeground(new Color(100, 57, 57));
		num5.setFont(new Font("Cambria", Font.PLAIN, 24));
		num5.setBounds(0, 300, 28, 29);
		contentPane.add(num5);
		
		JLabel num6 = new JLabel("   6");
		num6.setVerticalAlignment(SwingConstants.TOP);
		num6.setToolTipText("");
		num6.setHorizontalAlignment(SwingConstants.LEFT);
		num6.setForeground(new Color(199, 175, 150));
		num6.setFont(new Font("Cambria", Font.PLAIN, 24));
		num6.setBounds(0, 200, 28, 29);
		contentPane.add(num6);
		
		JLabel num7 = new JLabel("   7");
		num7.setVerticalAlignment(SwingConstants.TOP);
		num7.setToolTipText("");
		num7.setHorizontalAlignment(SwingConstants.LEFT);
		num7.setForeground(new Color(100, 57, 57));
		num7.setFont(new Font("Cambria", Font.PLAIN, 24));
		num7.setBounds(0, 100, 28, 29);
		contentPane.add(num7);
		
		JLabel num6_1 = new JLabel("   8");
		num6_1.setVerticalAlignment(SwingConstants.TOP);
		num6_1.setToolTipText("");
		num6_1.setHorizontalAlignment(SwingConstants.LEFT);
		num6_1.setForeground(new Color(199, 175, 150));
		num6_1.setFont(new Font("Cambria", Font.PLAIN, 24));
		num6_1.setBounds(0, 0, 28, 29);
		contentPane.add(num6_1);
	}
}

