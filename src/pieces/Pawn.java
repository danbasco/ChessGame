package pieces;

public class Pawn extends Default{ //POLIMORFISMO, TODO PEAO POSSUI OS ATRIBUTOS PADROES DE UMA PEÇA DEFAULT, Q É O MODELO
    
    private char symbol;
    public Pawn(int[] cords, int color){
        
        super(cords, color);
        
        if(color == 0)this.symbol = '\u2659'; //CARACTERES EM UNICODE PARA PRINTAR O EMOJI DAS PEÇAS
        else{
            this.symbol = '\u265F';
        }

    }


    @Override
    public char getSym(){
        return this.symbol;
    }
}
