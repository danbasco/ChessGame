package pieces;

public class Bishop extends Piece{
	
	private char symbol;
	public Bishop(int color) {
		super(color);
		
		if(color == 0)this.symbol = '\u2657';
		else this.symbol = '\u265D';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    

}


