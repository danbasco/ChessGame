package pieces;

public class King extends Piece{
    
    private char symbol;
	public King(int color) {
		super(color);
		
		if(color == 0)this.symbol = '\u2654';
		else this.symbol = '\u265A';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }

}
