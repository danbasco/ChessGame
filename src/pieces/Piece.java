package pieces;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import board.BoardGame;
import board.Coords;
import colors.*;

/**
 * Classe abstrata de modelo para todas as classes que vão herdar.
 * Esse modelo é o padrão para as peças de xadrez.
 * @version 1.4
 */
public abstract class Piece extends JLabel{ // Todas as peças possuem uma JLabel, um ícone associado
    
	
	private static final long serialVersionUID = 1L;

    private Cores color; // Enum das cores
    
    /**
     * Construtor padrão da peça
     * @param color Cores - Enum {@link colors.Cores}
     */
    public Piece(Cores color){

        this.color = color;

    }

    /**
     * Função que retorna a cor da peça
     * @return Cores - Enum {@link colors.Cores}
     */
    public Cores getColor() {
    	return this.color;
    }
    
    abstract public char getLetter();
    
    /** Função abstrata para pegar o icon da peça
     * @return ImageIcon
     */
    abstract public ImageIcon getIcon();
    
    /**
     * Função que vai pegar as duas coordenadas e verificar se esse movimento é possível para 
     * as peças
     * {@link board.Coords}
     * @param c1 Coords<Integer, Integer> - Coordenada Inicial
     * @param c2 Coords<Integer, Integer> - Coordenada Final
     * @return boolean
     */
    abstract protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2);
    
    /**
     * Essa função retorna todos os movimentos possíveis de uma peça até chegar na coordenada,
     * utilizada para verificar se a peça vai acabar encontrando uma peça no caminho ou não
     * @param c1 Coords<Integer, Integer> - Coordenada Inicial
     * @param c2 Coords<Integer, Integer> - Coordenada Final
     * @return ArrayList<Coords<Integer, Integer>>
     */
    abstract public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2, BoardGame t);
    
    
}
