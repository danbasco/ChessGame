package pieces;
import javax.swing.ImageIcon;

import board.Coords;
import colors.*;
import java.util.ArrayList;


public class King extends Piece{
    
	private static final long serialVersionUID = 1L;
	
	private ImageIcon KingIcon;
	
	public King(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.KingIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/white/king.png"));
		}
		else {
			this.KingIcon = new ImageIcon(Knight.class.getResource("/imgs/pieces/black/king.png"));
		}
	}
	
	
	@Override
	public ImageIcon getIcon() {
		return KingIcon;
	}


	@Override
	protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		int XAbsolute = Math.abs(c2.xc - c1.xc);
		int YAbsolute = Math.abs(c2.yc - c1.yc);

		if ((XAbsolute == 1 && YAbsolute == 0) || (XAbsolute == 0 && YAbsolute == 1) || (XAbsolute == YAbsolute && XAbsolute == 1)){
				return true;
		}
		
		
		return false;
		
	}


	@Override
	public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		ArrayList<Coords<Integer, Integer>> possibleMoves = new ArrayList<>();
		if(checkMove(c1, c2)) {
			return possibleMoves;
		}
		
		return null;
		
	}
}
