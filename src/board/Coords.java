package board;

/**
 * Esse Pair foi criado para facilitar a manipulação das coordenadas,
 * passando como dois valores o X e o Y
 * @param <X1> - Number
 * @param <Y1> - Number
 */
public class Coords <X1 extends Number, Y1 extends Number> {
	
	public X1 xc;
	public Y1 yc;
	
	/**
	 * Construtor
	 * @param xc - X1 (Coordenada X)
	 * @param yc - Y1 (Coordenada Y)
	 */
	public Coords(X1 xc, Y1 yc) {
        this.xc = xc;
        this.yc = yc;
    }
	
	/**
	 * Função para comparar as posições de duas coordenadas e verificar se são iguais
	 * @param c Coords<Integer, Integer> - Coordenadas para comparar
	 * @return boolean
	 */
	public boolean equals(Coords<Integer, Integer> c) {
		
		if(this.xc == c.xc && this.yc == c.yc) return true;
		return false;
	}

}

