package pieces;

public class Rook extends Piece{
	
	private char symbol;
	public Rook(int color) {
		super( color);
		
		if(color == 0)this.symbol = '\u2656';
		else this.symbol = '\u265C';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    
	
	
	

}
