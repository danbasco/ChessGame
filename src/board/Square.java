package board;

import javax.swing.JLabel;
import pieces.*;

public class Square extends JLabel{ //Classe das casas

    // private JLabel label;
    private Piece piece; //Cada casa possui uma peça


    public Square(){ //se não passar a peça no construtor, a casa está vazia

        this.piece = null;
    }

    public Square(Piece piece){
        this.piece = piece;
    
    }

    

    public Piece getPiece(){
        return piece;
    }

    

}
