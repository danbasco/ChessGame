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
	private JLabel lblNewLabel;
	
	private JLabel pieceIcon;
	private Piece piece;
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
		
		this.lblNewLabel = new JLabel("");
		this.lblNewLabel.addMouseListener(this);
		this.pieceIcon = new JLabel("");
		this.pieceIcon.addMouseListener(this);
		
		setIcons();
		
		this.pieceIcon.setBounds(0, 0, 100, 100);
		add(this.pieceIcon);
		
		this.lblNewLabel.setBounds(0, 0, 100, 100);
		add(this.lblNewLabel);
		
		qtSquare++;
		
	}
	private void setIcons() {
		
		if(qtSquare == 8) {
			qtSquare = 0;
			qtLines++;
		}
		
		
		switch(qtLines%2) {
		case 0:
		
			if(qtSquare%2 == 0)this.lblNewLabel.setIcon(new ImageIcon(Square.class.getResource("/imgs/board/dark.png"))); 
			else this.lblNewLabel.setIcon(new ImageIcon(Square.class.getResource("/imgs/board/light.png")));
			break;
			
		case 1:
			
			if(qtSquare%2 == 0)this.lblNewLabel.setIcon(new ImageIcon(Square.class.getResource("/imgs/board/light.png"))); 
			else this.lblNewLabel.setIcon(new ImageIcon(Square.class.getResource("/imgs/board/dark.png")));
			break;
			
		}
		
		if(this.piece != null)this.pieceIcon.setIcon(piece.getIcon());
		else this.pieceIcon.setIcon(null);
			
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(piece != null)System.out.println(piece.getSym());
		else System.out.println("Casa vazia!");
		
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
