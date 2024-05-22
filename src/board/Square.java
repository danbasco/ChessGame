package board;

import javax.swing.JPanel;
import pieces.Piece;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Square extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel sqrLabel;
	private JLabel pieceLabel;
	private Piece piece;
	
	private static boolean clickedBool = false;
	
	private JLabel clickedIcon;
	
	Coords<Integer, Integer> coords;
	
	public Square(Coords<Integer, Integer> coords) {
		
		setCoords(coords);
		this.piece = null;
		startLayout();
		
	}
	
	
	public Square(Piece piece, Coords<Integer, Integer> coords) {
		
		setCoords(coords);
		this.piece = piece;
		startLayout();
		
	}
	
	// INICIALIZA E CONFIGURA A PARTE GRÁFICA
	
	private void startLayout() {
		
		setLayout(null);
		
		this.sqrLabel = new JLabel("");
		this.clickedIcon = new JLabel("");
		this.pieceLabel = new JLabel("");

		
		setIcons();
		
		this.pieceLabel.setBounds(0, 0, 100, 100);
		add(this.pieceLabel);
		
		this.clickedIcon.setBounds(0,0,100,100);
		add(this.clickedIcon);
		
		this.sqrLabel.setBounds(0, 0, 100, 100);
		add(this.sqrLabel);
		
		// qtSquare++;
		
	}
	private void setIcons() {
		
		this.sqrLabel.setIcon(null);
		
		if(this.piece != null)this.pieceLabel.setIcon(piece.getIcon());
		else this.pieceLabel.setIcon(null);
		
		this.clickedIcon.setIcon(null);
			
	}
	
	private void updateIcons() {
		
		if(this.piece != null)this.pieceLabel.setIcon(piece.getIcon());
		else this.pieceLabel.setIcon(null);
	}
	
	
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void updatePiece(Piece piece) {
		this.piece = piece;
		updateIcons();
	}
	
	
	
	
	public Coords<Integer, Integer> getCoords(){
		return coords;
	}
	
	public void setCoords(Coords<Integer, Integer> coords) {
		this.coords = coords;
	}
	
	
	
	public void switchSelected() {
		if(!clickedBool) {
			this.clickedIcon.setIcon(new ImageIcon("imgs/boardi/green.png"));
			clickedBool = true;
		
		}
		else {
			
			this.clickedIcon.setIcon(null);
			clickedBool = false;
			
		}
	}
	
}
	

