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


/** Classe para manipular os jogadores do jogo de Xadrez 
 * @version 1.2
 */


public class Player {

    private Cores color; 
    private String name;
    
    // Construtor
    public Player(String name, Cores color){
    	
        this.color = color;
        this.name = name;
        
    }
    
    /**
     * Função para pegar o nome do jogador
     * @return String - name
     */
    public String getName(){
        return name;

    }

    /**
     * Função para pegar a cor do jogador
     * @return Enum - Cores
     */
    public Cores getColor(){
        return color;
    }
    
    
    /**
     * Essa função verifica se o movimento da casa inicial até a casa final é valido, 
     * e se for, ele faz uma permutação e move as peças.
     * @param sq1 Square - Casa inicial {@link package.board.Square}
     * @param sq2 Square - Casa final {@link package.board.Square}
     * @param t - {@link package.board.BoardGame}
     * @return boolean
     */
    public boolean movePieces(Square sq1, Square sq2, BoardGame t) {
        
    	boolean possible = false;
    	
        if(sq1.getCoords() != sq2.getCoords()) { // O jogador é forçado a sair da casa
            
        	/** ArrayList com todos os movimentos possíveis */
        	ArrayList<Coords<Integer, Integer>> possibleMoves = sq1.getPiece().allMoves(sq1.getCoords(), sq2.getCoords());
        	
        	
        	if(possibleMoves != null) {

        		possible = true;
        		
        		for(Coords<Integer, Integer> c: possibleMoves)  { // Aqui ele vai verificar por todos os movimentos possíveis até a casa específica
        			
        			if(!c.equals(sq2.getCoords())) { // Ele não verifica a última casa, até porquê o movimento já foi validado.
        				
        				if(!t.checkSquare(c)){ // Se a casa não estiver vazia retorna false.
        				
        					possible = false;
        					break;
        				}
        			}
            	}
        		
        	}
            
        	if(possible) {
        		
        		/** Verifica se a casa não está vazia e é um rei, para chamar o evento
        		 * {@link board.events.EndGameEvent}
        		 */
        		if(sq2.getPiece() != null && sq2.getPiece().getClass() == King.class)EventListener.Trigger(new EndGameEvent(t).event());
        		
        		try {
        			/** {@link playsounds.Sounds#onMove()}
        			 *  {@link playsounds.Sounds#onCapture()}
        			 */
        			if(sq2.getPiece() != null)Sounds.onCapture();
        			else Sounds.onMove();
        			
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        		// Permutação simples para mover a peça de uma casa para outra
        		sq2.updatePiece(sq1.getPiece());
        		sq1.updatePiece(null);
        		
        		 
        		return true;
        	}
        	else return false;    	
        }
        else return false;
    }
    
    /**
     * Função para comer a peça, essa função evita que o jogador possa pular casa na hora de movimentar para comer
     * e também tem uma exceção para o peão, que come diferente de como move
     * @param sq1 Square - Casa inicial {@link package.board.Square}
     * @param sq2 Square - Casa final {@link package.board.Square}
     * @param t - {@link package.board.BoardGame}
     * @return boolean
     */
    public boolean eatPieces(Square sq1, Square sq2, BoardGame t) {
        
        if(sq1.getPiece().getColor() == sq2.getPiece().getColor()) return false;	
        if(sq1.getPiece().getClass() != Pawn.class && this.movePieces(sq1, sq2, t)) return true;
    
        else if(sq1.getPiece().getClass() == Pawn.class) { // Condição única para o peão pois ele come diferente da movimentação
        		
        		
        	Pawn p1 = (Pawn)sq1.getPiece(); // Downcasting
        	
        	/** Verifica se é válido para o peão comer a peça na casa designada*/
        	if(p1.checkEat(sq1.getCoords(), sq2.getCoords())) {
        			
        		if(sq2.getPiece().getClass() == King.class) { // Se o peão comeu o rei
            		EventListener.Trigger(new EndGameEvent(t).event());
            	}
        		try {
        			/** {@link playsounds.Sounds#onCapture()} */
    				Sounds.onCapture();
    			} catch (Exception e) {

    				e.printStackTrace();
    			}        		
        		// Permutação simples para mover a peça de uma casa para outra
        		
        		sq2.updatePiece(sq1.getPiece());
            	sq1.updatePiece(null);
        			
        		return true;       			
        		}			
        	}
        	return false;  	
    }
            
}