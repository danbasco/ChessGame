package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class King extends Piece{
    
	private static final long serialVersionUID = 1L;
	
	private char symbol;
	private ImageIcon KingIcon;
	
	public King(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.symbol = '\u2654';
			this.KingIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/white/king.png"));
		}
		else {
			this.symbol = '\u265A';
			this.KingIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/black/king.png"));
		}
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
	
	@Override
	public ImageIcon getIcon() {
		return KingIcon;
	}
}
