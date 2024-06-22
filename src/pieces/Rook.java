package pieces;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import board.Coords;
import colors.*;
import menu.Menu;

/** Classe da torre */
public class Rook extends Piece{
	
	private char Letter = 'R';
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon RookIcon;
	
	public Rook(Cores color) {
		
		super(color);
		this.RookIcon = color == Cores.WHITE?new ImageIcon(String.format("imgs/%s/pieces/white/rook.png", Menu.THEME)):new ImageIcon(String.format("imgs/%s/pieces/black/rook.png", Menu.THEME));
		
	}
	

	@Override
	public ImageIcon getIcon() {
		return RookIcon;
	}


	@Override
	protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
			if((( c2.xc > c1.xc || c2.xc < c1.xc) && c2.yc == c1.yc) || (c2.xc == c1.xc && (c2.yc > c1.yc || c2.yc < c1.yc))) {
				return true;
			}
		return false;
		
	}


	@Override
	public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		ArrayList<Coords<Integer, Integer>> possibleMoves = new ArrayList<>();
		
		if(checkMove(c1, c2)) {
			
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
	
	@Override
	public char getLetter() {
		return Letter;
	}


}
