package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class Queen extends Piece{

	private static final long serialVersionUID = 1L;
	
	private char symbol;
	private ImageIcon QueenIcon;
	
	public Queen(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.symbol = '\u2655';
			this.QueenIcon = new ImageIcon(Queen.class.getResource("/imgs/pieces/white/queen.png"));
		}
		else {
			this.symbol = '\u265B';
			this.QueenIcon = new ImageIcon(Queen.class.getResource("/imgs/pieces/black/queen.png"));
		}
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
	
	@Override
	public ImageIcon getIcon() {
		return QueenIcon;
	}

}
