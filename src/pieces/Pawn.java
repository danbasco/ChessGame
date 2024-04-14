package pieces;
import javax.swing.ImageIcon;

import colors.*;

public class Pawn extends Piece{//TODO PEAO POSSUI OS ATRIBUTOS PADROES DE UMA PEÇA DEFAULT, Q É O MODELO
    
	
	private static final long serialVersionUID = 1L;
	
	
	private char symbol;
    private ImageIcon PawnIcon;
    
    public Pawn(Cores color){
        super(color);
        
        if(color == Cores.WHITE) {
        	this.symbol = '\u2659'; //CARACTERES EM UNICODE PARA PRINTAR O EMOJI DAS PEÇAS
        	this.PawnIcon = new ImageIcon(Pawn.class.getResource("/imgs/pieces/white/pawn.png"));
        	
        }
        else {
        	
        	this.symbol = '\u265F';
        	this.PawnIcon = new ImageIcon(Pawn.class.getResource("/imgs/pieces/black/pawn.png"));
        }
        
    }

    @Override
    public char getSym(){
        return this.symbol; //retorna o simbolo especifico de cada peça
    }
    
    @Override
    public ImageIcon getIcon() {
    	return PawnIcon;
    }
 

    
}
