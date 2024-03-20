package board;
import pieces.*;


public class Board{

    private Default[][] board;
    public Board(){
        this.board = new Default[8][8]; // O TABULEIRO É UMA MATRIZ 
    }

    private void setPiece(Default piece){

        this.board[piece.getPos()[0]][piece.getPos()[1]] = piece; //GETPOS RETORNA UM VETOR, POR ISSO PODE PEGAR A POSIÇÃO DESSA FORMA SEM CRIAR NOVA VARIAVEL

    }

    public void createBoard(){

        for(int i = 0; i<8; i++)this.setPiece(new Pawn(new int[]{1,i}, 1)); //CRIANDO OS PEOES
        for(int i = 0; i<8; i++)this.setPiece(new Pawn(new int[]{6,i}, 0));



    }
    
    //TODO getPiece

    public void printBoard(){

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                if(this.board[i][j] == null)System.out.print(".");
                else System.out.print(this.board[i][j].getSym());
            }
            System.out.println();
    
        }
        
    }

}
