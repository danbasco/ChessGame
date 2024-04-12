package pieces;
import colors.*;

public class Bishop extends Piece{
	
	private char symbol;
	public Bishop(Cores color) {
		super(color);
		
		if(color == Cores.WHITE)this.symbol = '\u2657';
		else this.symbol = '\u265D';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    

}


