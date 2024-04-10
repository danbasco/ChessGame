package board;
import javax.swing.JFrame;

import pieces.*;


public class Board extends JFrame{

    private Square[][] board;

    public Board(){
        this.board = new Square[8][8]; // O TABULEIRO É UMA MATRIZ DE CASAS
        createBoard();
    }


    private void createBoard(){
        
        //PEÕES
        for(int i = 0; i<8; i++){board[1][i] = new Square(new Pawn(1));}
        for(int i = 0; i<8; i++){board[6][i] = new Square(new Pawn(0));}

        //ESPAÇO VAZIO
        for(int i = 0; i<8; i++){for(int j = 2; j<=5; j++){board[j][i] = new Square();}}

        //PRETO

        board[0][0] = new Square(new Rook(1)); //Criando manualmente cada posição do quadrado no tabuleiro
        board[0][7] = new Square(new Rook(1));

        board[0][1] = new Square(new Knight(1));
        board[0][6] = new Square(new Knight(1));

        board[0][2] = new Square(new Bishop(1));
        board[0][5] = new Square(new Bishop(1));

        board[0][3] = new Square(new Queen(1));
        board[0][4] = new Square(new King(1));


        board[7][0] = new Square(new Rook(0));
        board[7][7] = new Square(new Rook(0));

        board[7][1] = new Square(new Knight(0));
        board[7][6] = new Square(new Knight(0));

        board[7][2] = new Square(new Bishop(0));
        board[7][5] = new Square(new Bishop(0));

        board[7][3] = new Square(new Queen(0));
        board[7][4] = new Square(new King(0));


    }
    
    //TODO getPiece

    public void printBoard(){ //Função básica de printar o tabuleiro
        
        System.out.println("| 0 1 2 3 4 5 6 7");
        for(int i = 0; i < 8; i++){
           
            System.out.print(i + " ");

            for(int j = 0; j < 8; j++){
        
                if(this.board[i][j].getPiece() == null)System.out.print("."); //Pega a peça que está no tabuleiro e printa . se estiver vazia, caso contrario printa o emoji da peça
                else System.out.print(this.board[i][j].getPiece().getSym());
                System.out.print(" ");

            }
            System.out.println();
    
        }
        
    }

    public Square getSquare(int[] coords){
        return board[coords[0]][coords[1]]; //Pega a casa especifica quando passar as coordenadas
    }


    public void printSquare(int[] coords){
        
        
        Piece piece = getSquare(coords).getPiece();
        if(piece == null)System.out.println("Não tem nenhuma peça nessa coordenada!"); //printa uma peça especifica na coordenada

        else System.out.println(piece.getSym());
    }

    

}
