package board;

import java.io.*;
import player.Player;
import pieces.*;
/**
 * Essa classe ainda não foi implementada, porém o propósito é utilizar para armazenar os movimentos
 * e apresentar em tela como um registro.
 * @param <X1> - Number
 * @param <X2> - Number
 * @hidden
 */
public class Movements <X1 extends Number, X2 extends Square>{
	public static int match = new File("logs/").list().length;
	public X1 xc;
	public X2 clSq;
	
	public Movements(X1 xc, X2 clSq) {
		
        this.xc = xc;
        this.clSq = clSq;
    }
	
	public static void gravaDisco(Player p, Piece piece, Coords<Integer, Integer> c1) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("logs/" + match + ".txt", true));
		 bw.write("\n");
		 bw.write(p.getName() + " --- " + piece.getLetter() + (char)(c1.xc + 97) + (8 - c1.yc));
		 bw.write("\n");
		 bw.close();
	}
	
	public static void criarLog(Player[] ps) throws IOException{
	File arq = new File("logs/"+ String.format("%d", (match +1)) + ".txt");

	

		
		if(arq.createNewFile()) {
			match++;
		}
		else {
			System.out.println("deu merda");
			return;
		}
		 BufferedWriter bw = new BufferedWriter(new FileWriter("logs/" + match + ".txt", true));
		 bw.write(ps[0].getName() + " X " +ps[1].getName());
		 bw.write("\n\n");
		 bw.close();
		 
	}
}
