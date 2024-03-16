package pieces;

public class Pawn extends Default{
    
    private char symbol;
    public Pawn(int[] cords, int color){
        
        super(cords, color);
        
        if(color == 0)this.symbol = '\u2659';
        else{
            this.symbol = '\u265F';
        }

    }
    
    @Override
    public String toString(){
        return "" + this.getSym();
    }

    @Override
    public int[] getPos(){
        return new int[]{super.x, super.y};
    }

    public void setPos(int[] cords){
        super.x = cords[0];
        super.y = cords[1];

    }

    public char getSym(){
        return this.symbol;
    }
}
