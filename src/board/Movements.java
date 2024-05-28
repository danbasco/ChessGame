package board;

/**
 * Essa classe ainda não foi implementada, porém o propósito é utilizar para armazenar os movimentos
 * e apresentar em tela como um registro.
 * @param <X1> - Number
 * @param <X2> - Number
 * @hidden
 */
public class Movements <X1 extends Number, X2 extends Square>{
	
	public X1 xc;
	public X2 clSq;
	
	public Movements(X1 xc, X2 clSq) {
		
        this.xc = xc;
        this.clSq = clSq;
    }
}
