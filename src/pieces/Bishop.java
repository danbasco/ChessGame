package pieces;
import javax.swing.ImageIcon;
import colors.*;

public class Bishop extends Piece{
	
	private static final long serialVersionUID = 1L;
	
	private char symbol;
	private ImageIcon BishopIcon;
	
	public Bishop(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.symbol = '\u2657';
			this.BishopIcon = new ImageIcon(Bishop.class.getResource("/imgs/pieces/white/bishop.png"));
			
		}
		else {
			this.symbol = '\u265D';
			this.BishopIcon = new ImageIcon(Bishop.class.getResource("/imgs/pieces/black/bishop.png"));
		}
	}
	
	@Override
	public char getSym(){
        return this.symbol;
    }
	
	@Override
    public ImageIcon getIcon() {
    	return BishopIcon;
    }
    

}


