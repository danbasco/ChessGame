package pieces;
import javax.swing.ImageIcon;

import board.Coords;
import colors.*;
import java.math.*;

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
	public boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		int XAbsolute = Math.abs(c2.xc - c1.xc);
		int YAbsolute = Math.abs(c2.yc - c1.yc);
		if((XAbsolute == 2 && YAbsolute == 1) || (XAbsolute == 1 && YAbsolute == 2)) 
 {
			return true;
		}
		
		
		return false;
		
	}


}
