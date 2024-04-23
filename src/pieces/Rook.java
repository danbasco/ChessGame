package pieces;
import javax.swing.ImageIcon;

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
	public void movePiece() {
		// TODO Auto-generated method stub
		
	}
	
	

}
