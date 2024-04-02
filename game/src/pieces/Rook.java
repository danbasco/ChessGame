package pieces;

public class Rook extends Piece{
	
	private char symbol;
	public Rook(int[] coords, int color) {
		super(coords, color);
		
		if(color == 0)this.symbol = '\u265C';
		else this.symbol = '\u2656';
	}
	
	public char getSym(){
        return this.symbol;
    }
    
	
	
	

}
