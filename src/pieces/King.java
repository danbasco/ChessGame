package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class King extends Piece{
    
	private static final long serialVersionUID = 1L;
	
	private ImageIcon KingIcon;
	
	public King(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.KingIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/white/king.png"));
		}
		else {
			this.KingIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/black/king.png"));
		}
	}
	
	
	@Override
	public ImageIcon getIcon() {
		return KingIcon;
	}


	@Override
	public void movePiece() {
		// TODO Auto-generated method stub
		
	}
}
