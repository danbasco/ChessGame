package pieces;
import colors.*;

public class Queen extends Piece{

    private char symbol;
	public Queen(Cores color) {
		super(color);
		
		if(color == Cores.WHITE)this.symbol = '\u2655';
		else this.symbol = '\u265B';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }

}
