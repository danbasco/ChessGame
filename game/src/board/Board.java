package board;
import javax.swing.JFrame;

import pieces.*;


public class Board extends JFrame{

    private Piece[][] board;
    public Board(){
        this.board = new Piece[8][8]; // O TABULEIRO É UMA MATRIZ 
    }

    private void setPiece(Piece piece){

        this.board[piece.getPos()[0]][piece.getPos()[1]] = piece; //GETPOS RETORNA UM VETOR, POR ISSO PODE PEGAR A POSIÇÃO DESSA FORMA SEM CRIAR NOVA VARIAVEL

    }

    private void clearPiece(int[] coords){//Limpa a casa do tabuleiro
        
        this.board[coords[0]][coords[1]] = null;

    }

    private Piece getPiece(int[] coords){ //Retorna a peça da casa especifica do tabuleiro
        return board[coords[0]][coords[1]];

    }

    public void createBoard(){

        for(int i = 0; i<8; i++)this.setPiece(new Pawn(new int[]{1,i}, 1)); //CRIANDO OS PEOES
        for(int i = 0; i<8; i++)this.setPiece(new Pawn(new int[]{6,i}, 0));
        this.setPiece(new Rook(new int[] {0, 0}, 0));

    }
    
    //TODO getPiece

    public void printBoard(){ //Função básica de printar o tabuleiro
        
        System.out.println("| 0 1 2 3 4 5 6 7");
        for(int i = 0; i < 8; i++){
           
            System.out.print(i + " ");

            for(int j = 0; j < 8; j++){
        
                if(this.board[i][j] == null)System.out.print(".");
                else System.out.print(this.board[i][j].getSym());
                System.out.print(" ");

            }
            System.out.println();
    
        }
        
    }

    public boolean movePiece(int[] coords, int[] final_pos, int turn){

        Piece piece = getPiece(coords);

        if(piece == null){

            System.out.println("Não foi possível encontrar a peça! tente novamente.");
            try{Thread.sleep(5000);}
            catch(Exception e){}

            return false;

        }
        
        if(getPiece(final_pos) == null){ //Verifica se a casa que vai mover está livre, caso contrário chama a função de comer peça e verifica se é possivel
        	
        	if(turn%2 == piece.getColor()) {
        		
        		piece.movePos(final_pos);
        		clearPiece(coords);
        		setPiece(piece);
        		
        	}
        	else {
        		
        		 System.out.println("Você não pode mover essa peça!");
        		 System.out.println("Cor: " + piece.getColor());
        		 System.out.println("Vez: " + turn);

                 try{
                     Thread.sleep(5000); 

                 }
                 catch(Exception InterruptedException){
                     System.out.println("Erro.");
                 }
                 return false;
        	}

        }

        //TODO eat piece
        
        
        return true;
    }


}
