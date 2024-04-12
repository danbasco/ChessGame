package pieces;
import colors.*;

public class Rook extends Piece{
	
	private char symbol;
	public Rook(Cores color) {
		super(color);
		
		if(color == Cores.WHITE)this.symbol = '\u2656';
		else this.symbol = '\u265C';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    
	
	
	

}
