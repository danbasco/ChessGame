/*
 * Essa classe foi criada para facilitar a manipulação do tabuleiro, sendo que todas as peças vao também ser parte dessa peça, assim
 * com polimorfismo eu posso usufruir de comandos padrões na classe do tabuleiro, e usar @Override para comandos especificos de movimento
 * de peças
 * 
 */


package pieces;

public class Default {
    
    protected int x; //PROTECTED PARA APENAS AS CLASSES QUE USAM EXTENDS POSSAM ACESSAR OS DADOS COM SUPER
    protected int y;
    protected int color; // COR 0 = BRANCO, COR 1 = PRETO


    public Default(int[] cords, int color){
        this.x = cords[0];
        this.y = cords[1];
        this.color = color; 
    }


    public int[] getPos(){
        return new int[]{this.x, this.y}; //FUNÇÃO PADRÃO PARA RETORNAR A POSIÇÃO, ATRAVÉS DE VETORES
    }

    public void setPos(int[] cords){
        this.x = cords[0];
        this.y = cords[1];
    }

    public char getSym(){
        return ' '; //PARA PRINTAR NO TABULEIRO, CADA PEÇA TEM UM SIMBOLO UNICO, QUE USANDO @OVERRIDE ELE CHAMA O SIMBOLO ESPECIFICO DE CADA OBJETO
    }


}
