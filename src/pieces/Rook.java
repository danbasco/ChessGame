package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class Rook extends Piece{
	
	private static final long serialVersionUID = 1L;
	
	private char symbol;
	private ImageIcon RookIcon;
	
	public Rook(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.symbol = '\u2656';
			this.RookIcon = new ImageIcon(Rook.class.getResource("/imgs/pieces/white/rook.png"));
		}
		else {
			this.symbol = '\u265C';
			this.RookIcon = new ImageIcon(Rook.class.getResource("/imgs/pieces/black/rook.png"));
		}
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    
	@Override
	public ImageIcon getIcon() {
		return RookIcon;
	}
	
	

}
