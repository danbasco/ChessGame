package pieces;
import javax.swing.ImageIcon;

import board.Coords;
import colors.*;

public class Rook extends Piece{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon RookIcon;
	
	public Rook(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.RookIcon = new ImageIcon(Rook.class.getResource("/imgs/pieces/white/rook.png"));
		}
		else {
			this.RookIcon = new ImageIcon(Rook.class.getResource("/imgs/pieces/black/rook.png"));
		}
	}
	

	@Override
	public ImageIcon getIcon() {
		return RookIcon;
	}


	@Override
	public boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		
		// WHITE
		
		
		
		// BLACK
		
		
		return true;
		
	}
	
	

}
