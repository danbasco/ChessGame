package pieces;
import javax.swing.ImageIcon;

import board.Square;
import colors.*;

public class Knight extends Piece{

    private char symbol;
    private ImageIcon KnightIcon;
    
	public Knight(Cores color) {
		
		super(color);
		
		if(color == Cores.WHITE) {
			this.symbol = '\u2658';
			this.KnightIcon = new ImageIcon(Square.class.getResource("/imgs/pieces/white/knight.png"));
			
		}
		else {
			
			this.symbol = '\u265E';
			this.KnightIcon = new ImageIcon(Square.class.getResource("/imgs/pieces/black/knight.png"));
		}
		
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    

    @Override
    public ImageIcon getIcon() {
    	return KnightIcon;
    }


}
