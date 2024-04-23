/*
 * Todas as subclasses que extendem dessa classe padrão possui os mesmos atributos e funções
 * Porém, utilizamos o @Override de funções para função específica de movimentação e retornar
 * O emoji
 */

package pieces;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import colors.*;

public abstract class Piece extends JLabel{
    

	private static final long serialVersionUID = 1L;

    private Cores color; // COR 0 = BRANCO, COR 1 = PRETO
    public Piece(Cores color){

        this.color = color;

    }

    
    public Cores getColor() {
    	return this.color;
    }
    
    abstract public ImageIcon getIcon();

    abstract public void movePiece();
    
    
}
