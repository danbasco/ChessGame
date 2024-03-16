package pieces;

public abstract class Default {
    
    protected int x;
    protected int y;
    protected int color; // COR 0 = BRANCO, COR 1 = PRETO

    public Default(int[] cords, int color){
        this.x = cords[0];
        this.y = cords[1];
        this.color = color;
    }


    abstract int[] getPos();
    abstract void setPos(int[] cords);


}
