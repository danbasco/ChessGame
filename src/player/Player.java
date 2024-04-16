package player;
//import pieces.*;
import colors.Cores;

public class Player {


    private Cores color; // COR 0 = BRANCO, COR 1 = PRETO
    private String name;

    public Player(String name, Cores color){
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return name;

    }


    public Cores getColor(){
        return color;
    }

    //TODO move pieces


    

}
