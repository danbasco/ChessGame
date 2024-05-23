/**Projeto de POO do 3 semestre do SENAI CIMATEC -- Jogo de Xadrez
 * 
 *  @author Artur Gouveia
 *  @author André Rezende
 *  @author Daniel Vasconcelos
 *  @author Guilherme Rios
 *  @version 1.01
 */


package main;


import java.awt.EventQueue;

import menu.*;


public class Main {
	
	
	public static void main(String[] args) { // Função main
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
							
				new Menu();	// Cria um novo JFrame do Menu			
							
				
			}
		});
		
		
	}
	
	
}
