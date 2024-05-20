package pieces;
import javax.swing.ImageIcon;

import board.Coords;
import colors.*;
import java.math.*;

public class Queen extends Piece{

	private static final long serialVersionUID = 1L;
	
	private ImageIcon QueenIcon;
	
	public Queen(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.QueenIcon = new ImageIcon(Queen.class.getResource("/imgs/pieces/white/queen.png"));
		}
		else {
			this.QueenIcon = new ImageIcon(Queen.class.getResource("/imgs/pieces/black/queen.png"));
		}
	}
	

	
	@Override
	public ImageIcon getIcon() {
		return QueenIcon;
	}


	@Override
	public boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		int XAbsolute = Math.abs(c2.xc - c1.xc);
		int YAbsolute = Math.abs(c2.yc - c1.yc);
		
		if((( c2.xc > c1.xc || c2.xc < c1.xc) && c2.yc == c1.yc) || (c2.xc == c1.xc && (c2.yc > c1.yc || c2.yc < c1.yc)) || (XAbsolute == YAbsolute)) {
			return true;
		}
		
		
		return false;
		
	}

}
