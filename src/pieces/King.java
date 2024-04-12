package pieces;
import colors.*;

public class King extends Piece{
    
    private char symbol;
	public King(Cores color) {
		super(color);
		
		if(color == Cores.WHITE)this.symbol = '\u2654';
		else this.symbol = '\u265A';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }

}
