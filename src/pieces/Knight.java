package pieces;
import javax.swing.ImageIcon;

import board.Coords;
import colors.*;

public class Knight extends Piece{

    
	private static final long serialVersionUID = 1L;
	
    private ImageIcon KnightIcon;
    
	public Knight(Cores color) {
		
		super(color);
		
		if(color == Cores.WHITE) {
			this.KnightIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/white/knight.png"));
			
		}
		else {
			
			this.KnightIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/black/knight.png"));
		}
		
	}
	

    @Override
    public ImageIcon getIcon() {
    	return KnightIcon;
    }


	@Override
	public void movePiece() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		// TODO Auto-generated method stub
		return true;
	}


}
