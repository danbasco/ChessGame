package board;

import javax.swing.JPanel;

import menu.Menu;
import pieces.Piece;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/** Classe para as casas do tabuleiro
 * @version 1.0
 */
public class Square extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel sqrLabel;
	private JLabel pieceLabel;
	private Piece piece; // Cada casa possui uma peça
	
	private static boolean clickedBool = false;
	
	private JLabel clickedIcon;
	
	private Coords<Integer, Integer> coords;
	
	/**
	 * Construtor da classe
	 * @param coords Coords<Integer, Integer> - Coordenadas da casa
	 */
	public Square(Coords<Integer, Integer> coords) {
		
		setCoords(coords);
		this.piece = null;
		startLayout();
		
	}
	
	/**
	 * Construtor da classe
	 * @param piece Piece - Peça da casa
	 * @param coords Coords<Integer, Integer> - Coordenadas da casa
	 */
	public Square(Piece piece, Coords<Integer, Integer> coords) {
		
		setCoords(coords);
		this.piece = piece;
		startLayout();
		
	}
	
	/**
	 * Criação do Panel da casa
	 */
	private void startLayout() {
		
		setLayout(null);
		
		this.sqrLabel = new JLabel("");
		this.clickedIcon = new JLabel("");
		this.pieceLabel = new JLabel("");
		
		setIcons();
		
		this.pieceLabel.setBounds(0, 0, 100, 100);
		add(this.pieceLabel);
		
		this.clickedIcon.setBounds(0,0,100,100);
		add(this.clickedIcon);
		
		this.sqrLabel.setBounds(0, 0, 100, 100);
		add(this.sqrLabel);
		
		
	}
	
	/**
	 * Seta as Label da classe
	 */
	private void setIcons() {
		
		this.sqrLabel.setIcon(null);
		
		if(this.piece != null)this.pieceLabel.setIcon(piece.getIcon());
		else this.pieceLabel.setIcon(null);
		
		this.clickedIcon.setIcon(null);
			
	}
	
	/** Atualiza o icon da peça */
	private void updateIcons() {
		
		if(this.piece != null)this.pieceLabel.setIcon(piece.getIcon());
		else this.pieceLabel.setIcon(null);
	}
	
	
	/**
	 * Função que retorna a peça da casa
	 * @return Piece 
	 */
	public Piece getPiece() {
		return this.piece;
	}
	
	/**
	 * Função que atualiza a peça da casa
	*/
	public void updatePiece(Piece piece) {
		this.piece = piece;
		updateIcons();
	}
	
	/**
	 * Função que retorna as coordenadas da casa
	 * @return Coords<Integer, Integer>
	 */
	public Coords<Integer, Integer> getCoords(){
		return coords;
	}
	
	/**
	 * Função para setar as coordenadas
	 * @param coords
	 */
	private void setCoords(Coords<Integer, Integer> coords) {
		this.coords = coords;
	}
	
	/** Essa função não está sendo utilizada no momento, mas o propósito era ativar  right click
	 * no eventListener do mouse, assim criando uma overlay vermelha com o outro click
	 * @deprecated
	 */
	public void setRightClicked() {
		this.clickedIcon.setIcon(new ImageIcon(String.format("imgs/%s/boardi/red.png", Menu.THEME)));
	}
	
	
	/**
	 * Essa função tem propósito fazer um overlay quando é clicado com o mouse esquerdo,
	 * mostrando a casa selecionada no tabuleiro
	 */
	public void switchSelected() {
		if(!clickedBool) {
			this.clickedIcon.setIcon(new ImageIcon(String.format("imgs/%s/boardi/green.png", Menu.THEME)));
			clickedBool = true;
		
		}
		else {
			
			this.clickedIcon.setIcon(null);
			clickedBool = false;
			
		}
	}
	
}
	

