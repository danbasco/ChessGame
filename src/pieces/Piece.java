/*
 * Todas as subclasses que extendem dessa classe padrão possui os mesmos atributos e funções
 * Porém, utilizamos o @Override de funções para função específica de movimentação e retornar
 * O emoji
 */

package pieces;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import colors.*;

public class Piece extends JLabel{
    

	private static final long serialVersionUID = 1L;

	private ImageIcon icon;

    private Cores color; // COR 0 = BRANCO, COR 1 = PRETO
    public Piece(Cores color){

        this.color = color;

    }

   
    public char getSym(){
        return ' '; //PARA PRINTAR NO TABULEIRO, CADA PEÇA TEM UM SIMBOLO UNICO, QUE USANDO @OVERRIDE ELE CHAMA O SIMBOLO ESPECIFICO DE CADA OBJETO
    }
    
    
    public Cores getColor() {
    	return this.color;
    }
    
    public ImageIcon getIcon() {
    	return icon;
    }
    //TODO eatpiece


}
