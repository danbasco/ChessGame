package player;
import board.Square;
import board.events.EndGameEvent;
import board.events.EventListener;
import colors.Cores;
import pieces.King;

public class Player {


    private Cores color; 
    private String name;
    
    

    public Player(String name, Cores color, boolean starting) throws InterruptedException{
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
    
    
    

    public boolean eatPieces(Square sq1, Square sq2) {
        
        /*
        if(sq1.getPiece().getColor() == sq2.getPiece().getColor()) return false;
        if(sq2.getPiece().getClass() == King.class) {
            
            sq2.updatePiece(sq1.getPiece());
            sq1.updatePiece(null);

            EventListener.Trigger(new EndGameEvent().event());
        }
        
        sq2.updatePiece(sq1.getPiece());
        sq1.updatePiece(null);
        
        */
        return false;
    }
           
    
}