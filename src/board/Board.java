package board;
import pieces.*;


public class Board{

    private Default[][] board;
    public Board(){
        this.board = new Default[8][8];
    }

    private void setPiece(Default piece, int[] coords){

        this.board[coords[0]][coords[1]] = piece;

    }

    public void createBoard(){

        for(int i = 0; i<8; i++)this.setPiece(new Pawn(new int[]{1,i}, 1), new int[]{1,i});
        for(int i = 0; i<8; i++)this.setPiece(new Pawn(new int[]{6,i}, 0), new int[]{6,i});
    }
    

    //TODO getPiece

    public void printBoard(){

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){

                if(this.board[i][j] == null)System.out.print(".");
                else System.out.print(this.board[i][j].toString());
            }
            System.out.println();
    
        }
        
    }

}
