package pieces;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import board.Coords;
import colors.*;

public class Pawn extends Piece{//TODO PEAO POSSUI OS ATRIBUTOS PADROES DE UMA PEÇA DEFAULT, Q É O MODELO
    
	
	private static final long serialVersionUID = 1L;
	private boolean firstMove = true;
	
    private ImageIcon PawnIcon;
    
    public Pawn(Cores color){
        super(color);
        
        if(color == Cores.WHITE) {
        	this.PawnIcon = new ImageIcon(Pawn.class.getResource("/imgs/pieces/white/pawn.png"));
        	
        }
        else {
        	
        	this.PawnIcon = new ImageIcon(Pawn.class.getResource("/imgs/pieces/black/pawn.png"));
        }
        
    }

    @Override
    public ImageIcon getIcon() {
    	return PawnIcon;
    }

	@Override
	protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		// WHITE
		if(this.firstMove) {
			
			if(this.getColor() == Cores.WHITE) {
				if((c1.yc == (c2.yc +1) || c1.yc == (c2.yc +2)) && c1.xc == c2.xc) {
					this.firstMove = false;
					return true;
				}
			}
			else {
				if((c1.yc == (c2.yc -1) || c1.yc == (c2.yc -2)) && c1.xc == c2.xc) {
					this.firstMove = false;
					return true;
				}
			}
			
		}
		
		else {
			if(this.getColor() == Cores.WHITE) {
				if(c1.yc == (c2.yc +1) && c1.xc == c2.xc) {
				return true;
				}
			}
			else {
				if(c1.yc == (c2.yc -1) && c1.xc == c2.xc) {
					return true;
				}
			}
		}
		
		return false;
	
	}

	@Override
	public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		ArrayList<Coords<Integer, Integer>> possibleMoves = new ArrayList<>();
		
		if(checkMove(c1, c2)) {

			
			if(firstMove) {
				if(this.getColor() == Cores.WHITE) {
					
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc-1), (c1.yc-1)));
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc-2), (c1.yc-2)));
				}
				else {
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc+1), (c1.yc+1)));
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc+2), (c1.yc+2)));
					
				}
				
			}
			else {
				
				possibleMoves.add(c2);

			}
				
			return possibleMoves;
			
		}
		

		return null;
	}
	
	
	public boolean checkEat(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		if(this.getColor() == Cores.WHITE) {
			if((c2.xc == (c1.xc + 1) || c2.xc == (c1.xc - 1)) && c2.yc == (c1.yc - 1)) return true;
		}
		else {
			if((c2.xc == (c1.xc + 1) || c2.xc == (c1.xc - 1)) && c2.yc == (c1.yc + 1)) return true;
		}
		return false;
	}
     
}
