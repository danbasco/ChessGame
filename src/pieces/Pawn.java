package pieces;
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
	public boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		// WHITE
		if(firstMove) {
			this.firstMove = false;
			if(this.getColor() == Cores.WHITE) {
				if((c1.yc == (c2.yc +1) || c1.yc == (c2.yc +2)) && c1.xc == c2.xc) {
				return true;
				}
			}
			else {
				if((c1.yc == (c2.yc -1) || c1.yc == (c2.yc -2)) && c1.xc == c2.xc) {
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
 

    
}
