package board;

public class Movements <X1 extends Number, X2 extends Square>{
	
	public X1 xc;
	public X2 yc;
	
	public Movements(X1 xc, X2 yc) {
		
        this.xc = xc;
        this.yc = yc;
    }
}
