package main;
import java.util.Scanner;

import board.Board;

public class Main {
    public static void main(String[] args){
        

        Board board = new Board();//Criando o tabuleiro   
        board.printBoard();

        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("Digite as coordenadas da casa que deseja imprimir a peça. Digite numero negativo em qualquer coordenada para sair");

            int x = sc.nextInt();
            if(x < 0)break;
            int y = sc.nextInt();
            if(y <0)break;

            board.printSquare(new int[]{y, x});

        }

        sc.close();
        
       
    }
}
