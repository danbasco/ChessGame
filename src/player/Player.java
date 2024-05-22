package player;
import board.BoardGame;
import board.Coords;
import board.Square;
import board.events.*;
import colors.Cores;

import java.util.ArrayList;


import pieces.King;
import pieces.Pawn;
import playsounds.Sounds;


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

    public boolean movePieces(Square sq1, Square sq2, BoardGame t) {
        
    	boolean possible = false;
    	
        if(sq1.getCoords() != sq2.getCoords()) {
            
        	ArrayList<Coords<Integer, Integer>> possibleMoves = sq1.getPiece().allMoves(sq1.getCoords(), sq2.getCoords());
        	
        	if(possibleMoves != null) {

        		possible = true;
        		
        		for(Coords<Integer, Integer> c: possibleMoves)  {
        			
        			if(!c.equals(sq2.getCoords())) {
        				
        				if(!t.checkSquare(c)){
        				
        					possible = false;
        					break;
        				}
        			}
            	}
        		
        	}
            
        	if(possible) {
        		
        		if(sq2.getPiece() != null && sq2.getPiece().getClass() == King.class)EventListener.Trigger(new EndGameEvent().event());
        		
        		sq2.updatePiece(sq1.getPiece());
        		sq1.updatePiece(null);
        		
        		try {
					Sounds.onMove();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
        		
        		return true;
        	}
        	
        	else return false;
        	
        }
        else return false;
    }
    

    public boolean eatPieces(Square sq1, Square sq2, BoardGame t) {
        
        if(sq1.getPiece().getColor() == sq2.getPiece().getColor()) return false;	
        if(this.movePieces(sq1, sq2, t)) return true;
    
        	else if(sq1.getPiece().getClass() == Pawn.class) { // CONDIÇÃO ÚNICA PARA O PEÃO, COME DIFERENTE
        		
        		
        		Pawn p1 = (Pawn)sq1.getPiece();
        		
        		if(p1.checkEat(sq1.getCoords(), sq2.getCoords())) {
        			
        			if(sq2.getPiece().getClass() == King.class) {
            			EventListener.Trigger(new EndGameEvent().event());
            		}
        			
        			try {
    					Sounds.onCapture();
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} 
        			
        			sq2.updatePiece(sq1.getPiece());
            		sq1.updatePiece(null);
        			
        			return true;
        			
        		}
        			
        		
        	}
        	
        	return false;
        	
    }
           
    
}