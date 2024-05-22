package pieces;
import javax.swing.ImageIcon;

import board.Coords;
import colors.*;
import java.util.ArrayList;

public class Queen extends Piece{

	private static final long serialVersionUID = 1L;
	
	private ImageIcon QueenIcon;
	
	public Queen(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.QueenIcon = new ImageIcon("imgs/pieces/white/queen.png");
		}
		else {
			this.QueenIcon = new ImageIcon("imgs/pieces/black/queen.png");
		}
	}
	

	
	@Override
	public ImageIcon getIcon() {
		return QueenIcon;
	}


	@Override
	protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		int XAbsolute = Math.abs(c2.xc - c1.xc);
		int YAbsolute = Math.abs(c2.yc - c1.yc);
		
		if((( c2.xc > c1.xc || c2.xc < c1.xc) && c2.yc == c1.yc) || (c2.xc == c1.xc && (c2.yc > c1.yc || c2.yc < c1.yc)) || (XAbsolute == YAbsolute)) {
			return true;
		}
		
		
		return false;
		
	}



	@Override
	public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		ArrayList<Coords<Integer, Integer>> possibleMoves = new ArrayList<>();
		
		if(checkMove(c1, c2)) {
			if(c2.xc > c1.xc && c2.yc > c1.yc) {
				int z = c1.yc;
				for(int k = (c1.xc+1); k<= c2.xc; k++) {
					z++;
					possibleMoves.add(new Coords<Integer, Integer>(k, z));
				}
			}
			
			
			if(c2.xc < c1.xc && c2.yc < c1.yc) {
				int z = c1.yc;
				for(int k = (c1.xc-1); k>= c2.xc; k--) {
					z--;
					possibleMoves.add(new Coords<Integer, Integer>(k, z));
				}
			}
			
			if(c2.xc < c1.xc && c2.yc > c1.yc) {
				int z = c1.yc;
				for(int k = (c1.xc-1); k>= c2.xc; k--) {
					z++;
					possibleMoves.add(new Coords<Integer, Integer>(k, z));
				}
			}
			
			if(c2.xc > c1.xc && c2.yc < c1.yc) {
				int z = c1.yc;
				for(int k = (c1.xc+1); k<= c2.xc; k++) {
					z--;
					possibleMoves.add(new Coords<Integer, Integer>(k, z));
				}
			}
			
			
			if(c2.xc > c1.xc && c2.yc == c1.yc) {
				for(int k = (c1.xc+1); k<= c2.xc; k++) {
					possibleMoves.add(new Coords<Integer, Integer>(k, c1.yc));
				}
			}
			
			
			if(c2.xc < c1.xc && c2.yc == c1.yc) {
				for(int k = (c1.xc-1); k>= c2.xc; k--) {
					possibleMoves.add(new Coords<Integer, Integer>(k, c1.yc));
				}
			}
			
			if(c2.yc > c1.yc && c2.xc == c1.xc) {
				for(int k = (c1.yc+1); k<= c2.yc; k++) {
					possibleMoves.add(new Coords<Integer, Integer>(c1.xc, k));
				}
			}
			
			if(c2.yc < c1.yc && c2.xc == c1.xc) {
				for(int k = (c1.yc-1); k>= c2.yc; k--) {
					possibleMoves.add(new Coords<Integer, Integer>(c1.xc, k));
				}
			}
			
			return possibleMoves;
		}
		
		return null;
	}

}
