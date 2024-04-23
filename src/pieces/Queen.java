package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class Queen extends Piece{

	private static final long serialVersionUID = 1L;
	
	private ImageIcon QueenIcon;
	
	public Queen(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.QueenIcon = new ImageIcon(Queen.class.getResource("/imgs/pieces/white/queen.png"));
		}
		else {
			this.QueenIcon = new ImageIcon(Queen.class.getResource("/imgs/pieces/black/queen.png"));
		}
	}
	

	
	@Override
	public ImageIcon getIcon() {
		return QueenIcon;
	}



	@Override
	public void movePiece() {
		// TODO Auto-generated method stub
		
	}

}
