package pieces;
import colors.*;

public class Knight extends Piece{

    private char symbol;
	public Knight(Cores color) {
		
		super(color);
		
		if(color == Cores.WHITE)this.symbol = '\u2658';
		else this.symbol = '\u265E';
		
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    


}
