/*
 * Essa classe foi criada para facilitar a manipulação do tabuleiro, sendo que todas as peças vao também ser parte dessa peça, assim
 * com polimorfismo eu posso usufruir de comandos padrões na classe do tabuleiro, e usar @Override para comandos especificos de movimento
 * de peças
 * 
 */

package pieces;
import javax.swing.JLabel;

public class Piece extends JLabel{
    
    private int x; //PROTECTED PARA APENAS AS CLASSES QUE USAM EXTENDS POSSAM ACESSAR OS DADOS COM SUPER
    private int y;
    private int color; // COR 0 = BRANCO, COR 1 = PRETO

    public Piece(int[] cords, int color){

        setPos(cords);
        this.color = color; 

    }

    public Piece(){

    }

    public int[] getPos(){
        return new int[]{this.x, this.y}; //FUNÇÃO PADRÃO PARA RETORNAR A POSIÇÃO, ATRAVÉS DE VETORES
    }

    
    public void setPos(int[] coords){
        this.x = coords[0];
        this.y = coords[1];
    }

    
    public void movePos(int[] coords){
        this.x = coords[0];
        this.y = coords[1];
    }

    public char getSym(){
        return ' '; //PARA PRINTAR NO TABULEIRO, CADA PEÇA TEM UM SIMBOLO UNICO, QUE USANDO @OVERRIDE ELE CHAMA O SIMBOLO ESPECIFICO DE CADA OBJETO
    }
    
    
    public int getColor() {
    	return this.color;
    }

    //TODO eatpiece


}
