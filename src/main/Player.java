package main;
//import pieces.*;

public class Player {


    private int color; // COR 0 = BRANCO, COR 1 = PRETO
    private String name;

    Player(String name, int color){
        this.color = color;
        this.name = name;
    }

    public String getName(){
        return name;

    }


    public int getColor(){
        return color;
    }

    //TODO move pieces


    

}
