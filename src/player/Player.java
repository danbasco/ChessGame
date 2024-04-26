package player;
import board.Square;
import colors.Cores;
import pieces.King;

public class Player {


    private Cores color; // COR 0 = BRANCO, COR 1 = PRETO
    private String name;

    public Player(String name, Cores color){
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return name;

    }


    public Cores getColor(){
        return color;
    }

    //TODO move pieces
    
    public boolean movePieces(Square sq1, Square sq2) {
    	
    	if(sq1.getPiece().checkMove(sq1.getCoords(), sq2.getCoords()) && sq1.getCoords() != sq2.getCoords()) {
    		
    		
    		sq2.updatePiece(sq1.getPiece());
    		sq1.updatePiece(null);
    		return true;
    	}
    	else return false;
    }
    
    
    

    public boolean eatPieces(Square sq1, Square sq2) throws GameEndingException {
    	
    	
    	if(sq2.getPiece().getClass() == King.class) {
    		throw new Player.GameEndingException("teste");
    	}
    	
    	return false;
    }

    
    
    public class GameEndingException extends Exception {
    	public GameEndingException(String errorMessage) {
    		super(errorMessage);
    	}
    }

}
