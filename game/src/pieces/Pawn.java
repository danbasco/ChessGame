package pieces;

public class Pawn extends Piece{ //POLIMORFISMO, TODO PEAO POSSUI OS ATRIBUTOS PADROES DE UMA PEÇA DEFAULT, Q É O MODELO
    
    private char symbol;
    public Pawn(int[] coords, int color){
        
        super(coords, color);
        
        if(color == 0)this.symbol = '\u2659'; //CARACTERES EM UNICODE PARA PRINTAR O EMOJI DAS PEÇAS
        else{
            this.symbol = '\u265F';
        }

    }


    @Override
    public char getSym(){
        return this.symbol;
    }
    
   
    
    @Override
    public void movePos(int[] coords){  //NA HORA DE PASSAR AS COORDENADAS, PASSE O Y COMO PRIMEIRO PARÂMETRO E DEPOIS O X
    	
    	//VERIFICA SE É A VEZ DA COR BRANCA OU DA COR PRETA
    	// 0 = BRANCO, 1 = PRETO
    	
    	System.out.println(getColor());
    	System.out.printf("X: %d, Y: %d\n", coords[1], coords[0]);
    	
    	switch(getColor()) {
    	
    	case 1:
    		if(coords[0] != this.getPos()[0] + 1 || coords[1] != this.getPos()[1]){
            
    			System.out.println("Esse movimento não é permitido!");

    			try{
    				Thread.sleep(5000); 

    			}
    			catch(Exception InterruptedException){
    				System.out.println("Erro.");
    			}
    			return;

    		}
    		setPos(coords);
    		
    	case 0:
    		
    		if(coords[0] != this.getPos()[0] - 1 || coords[1] != this.getPos()[1]){
                
    			System.out.println("Esse movimento não é permitido!");

    			try{
    				Thread.sleep(5000); 

    			}
    			catch(Exception InterruptedException){
    				System.out.println("Erro.");
    			}
    			return;

    		}
    		setPos(coords);
        
    	}

    }
}
