package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class Pawn extends Piece{//TODO PEAO POSSUI OS ATRIBUTOS PADROES DE UMA PEÇA DEFAULT, Q É O MODELO
    
	
	private static final long serialVersionUID = 1L;
	
	
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
	public void movePiece() {
		// TODO Auto-generated method stub
		
	}
 

    
}
