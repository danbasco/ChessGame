package board;

public class Coords <X1 extends Number, Y1 extends Number> {
	
	public X1 xc;
	public Y1 yc;
	
	public Coords(X1 xc, Y1 yc) {
        this.xc = xc;
        this.yc = yc;
    }
	
	public boolean equals(Coords<Integer, Integer> c) {
		
		if(this.xc == c.xc && this.yc == c.yc) return true;
		return false;
	}

}

