package pieces;

public class Queen extends Piece{

    private char symbol;
	public Queen(int color) {
		super(color);
		
		if(color == 0)this.symbol = '\u2655';
		else this.symbol = '\u265B';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }

}
