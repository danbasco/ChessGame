package pieces;
import javax.swing.ImageIcon;

import board.BoardGame;
import board.Coords;
import colors.*;
import menu.Menu;

import java.util.ArrayList;

/** Classe do Cavalo */
public class Knight extends Piece{

	private char Letter = 'Q';
	
	private static final long serialVersionUID = 1L;
	
    private ImageIcon KnightIcon;
    
	public Knight(Cores color) {
		
		super(color);
		this.KnightIcon = color == Cores.WHITE? new ImageIcon(String.format("imgs/%s/pieces/white/knight.png", Menu.THEME)) : new ImageIcon(String.format("imgs/%s/pieces/black/knight.png", Menu.THEME));
				
	}
	

    @Override
    public ImageIcon getIcon() {
    	return KnightIcon;
    }


	@Override
	protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		int XAbsolute = Math.abs(c2.xc - c1.xc);
		int YAbsolute = Math.abs(c2.yc - c1.yc);
		if((XAbsolute == 2 && YAbsolute == 1) || (XAbsolute == 1 && YAbsolute == 2)) 
 {
			return true;
		}
		
		
		return false;
		
	}


	@Override
	public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2, BoardGame t) {
		
		ArrayList<Coords<Integer, Integer>> possibleMoves = new ArrayList<>();
		if(checkMove(c1, c2)) {
			
			possibleMoves.add(c2);
			return possibleMoves;
		
		}
		return null;
	}
	
	@Override
	public char getLetter() {
		return Letter;
	}



}
