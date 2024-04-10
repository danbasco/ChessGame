package pieces;

public class Knight extends Piece{

    private char symbol;
	public Knight(int color) {
		super(color);
		
		if(color == 0)this.symbol = '\u2658';
		else this.symbol = '\u265E';
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
    


}
