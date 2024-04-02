package main;
import java.util.Scanner;

import board.Board;

public class Main {
    public static void main(String[] args){
        
        boolean game = true;

        Board board = new Board();
        board.createBoard();
        

        Scanner sc = new Scanner(System.in);
        
        int turn = 0;
        
        do{

            System.out.print("\033[H\033[2J"); 
            board.printBoard();

            int[] posi = new int[2];
            int[] posf = new int[2];

            posi[1] = sc.nextInt(); //TODO verificar a posição X e Y dos vetores
            posi[0] = sc.nextInt();
            posf[1] = sc.nextInt();
            posf[0] = sc.nextInt();

            if(board.movePiece(posi, posf, turn)) {
            	turn++;
            }
            

        }
        while(game);
        sc.close();

    }
}
