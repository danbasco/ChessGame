package board;

import javax.swing.JPanel;

import pieces.Piece;

import javax.swing.JLabel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class Square extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	
	private static int qtSquare;
	private static int qtLines;
	
	private JLabel sqrIcon;
	
	private JLabel pieceIcon;
	private Piece piece;
	
	// private static boolean clickedBool;
	
	private JLabel clickedIcon;
	/**
	 * Create the panel.
	 */
	
	public Square() {
		
		this.piece = null;
		startLayout();
		
	}
	
	
	
	public Square(Piece piece) {
		
		this.piece = piece;
		startLayout();
		
	}
	
	
	
	// INICIALIZA E CONFIGURA A PARTE GRÁFICA
	
	
	private void startLayout() {
		
		setLayout(null);
		
		this.sqrIcon = new JLabel("");
		this.sqrIcon.addMouseListener(this);
		
		this.clickedIcon = new JLabel("");
		this.clickedIcon.addMouseListener(this);
		
		this.pieceIcon = new JLabel("");
		this.pieceIcon.addMouseListener(this);
		
		setIcons();
		
		this.pieceIcon.setBounds(0, 0, 100, 100);
		add(this.pieceIcon);
		
		this.clickedIcon.setBounds(0,0,100,100);
		add(this.clickedIcon);
		
		this.sqrIcon.setBounds(0, 0, 100, 100);
		add(this.sqrIcon);
		
		qtSquare++;
		
	}
	private void setIcons() {
		
		if(qtSquare == 8) {
			qtSquare = 0;
			qtLines++;
		}
		
		
		switch(qtLines &1) {
		
		case 0:
		
			if(qtSquare%2 == 0)this.sqrIcon.setIcon(new ImageIcon(Square.class.getResource("/imgs/boardi/light.png"))); 
			else this.sqrIcon.setIcon(new ImageIcon(Square.class.getResource("/imgs/boardi/dark.png")));
			break;
			
		case 1:
			
			if(qtSquare%2 == 0)this.sqrIcon.setIcon(new ImageIcon(Square.class.getResource("/imgs/boardi/dark.png"))); 
			else this.sqrIcon.setIcon(new ImageIcon(Square.class.getResource("/imgs/boardi/light.png")));
			break;
			
		}
		
		if(this.piece != null)this.pieceIcon.setIcon(piece.getIcon());
		else this.pieceIcon.setIcon(null);
		
		this.clickedIcon.setIcon(null);
			
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
