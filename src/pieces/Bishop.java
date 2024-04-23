package pieces;
import javax.swing.ImageIcon;
import colors.*;

public class Bishop extends Piece{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon BishopIcon;
	
	public Bishop(Cores color) {
		super(color);
		
		if(color == Cores.WHITE) {
			this.BishopIcon = new ImageIcon(Bishop.class.getResource("/imgs/pieces/white/bishop.png"));
			
		}
		else {
			this.BishopIcon = new ImageIcon(Bishop.class.getResource("/imgs/pieces/black/bishop.png"));
		}
	}
	
	
	@Override
    public ImageIcon getIcon() {
    	return BishopIcon;
    }


	@Override
	public void movePiece() {
		// TODO Auto-generated method stub
		
	}
    

}


