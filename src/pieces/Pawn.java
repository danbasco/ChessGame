package pieces;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

import board.BoardGame;
import board.Coords;
import board.Square;
import colors.*;
import menu.Menu;

/** Classe do peão 
 * 
 * A classe do peão é um pouco diferente, pois ele come diferente da movimentação e 
 * possui regras especiais para movimentar, como primeiro movimento, mudar quando chega 
 * do outro lado e en passant por exemplo.
 */
public class Pawn extends Piece{
	
	
	private abstract class MouseAdapter implements MouseListener {
		
		Promo t;
		Square sq;
		protected MouseAdapter(Promo t, Square sq) {
		this.t = t;
		this.sq = sq;
		
	}
	
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
	
	private class Promo extends JWindow{

		private static final long serialVersionUID = 1L;
		
		
		Promo(Square sq, Pawn p){
			
			JPanel Queen = new JPanel();
			Queen.setBounds(0, 0, 100, 100);
			Queen.setOpaque(false);
			this.add(Queen);
			
			JPanel Bishop = new JPanel();
			Bishop.setBounds(0, 200, 100, 100);
			Bishop.setOpaque(false);
			this.add(Bishop);
			
			JPanel Rook = new JPanel();
			Rook.setBounds(0, 300, 100, 100);
			Rook.setOpaque(false);
			this.add(Rook);
			
			JPanel Horse = new JPanel();
			Horse.setBounds(0, 100, 100, 100);
			Horse.setOpaque(false);
			this.add(Horse);
			
			
			// Eventos
			
			
			Queen.addMouseListener(new MouseAdapter(this, sq) {
				
				@Override
				 public void mouseClicked(MouseEvent e) {
					 
					 sq.updatePiece(new Queen(sq.getPiece().getColor()));
					 t.removeAll();
					 t.setVisible(false);
					 BoardGame.setGame(true);
					 BoardGame.switchTimer();
					 
				 }
			});			
			
			Rook.addMouseListener(new MouseAdapter(this, sq) {
				
				@Override
				 public void mouseClicked(MouseEvent e) {
					 
					 sq.updatePiece(new Rook(sq.getPiece().getColor()));
					 t.removeAll();
					 t.setVisible(false);
					 BoardGame.setGame(true);
					 BoardGame.switchTimer();
					 
				 }
			});
			
			Horse.addMouseListener(new MouseAdapter(this, sq) {
				
				@Override
				 public void mouseClicked(MouseEvent e) {
					 
					 sq.updatePiece(new Knight(sq.getPiece().getColor()));
					 t.removeAll();
					 t.setVisible(false);
					 BoardGame.setGame(true);
					 BoardGame.switchTimer();
					 
				 }
			});	
			
			Bishop.addMouseListener(new MouseAdapter(this, sq) {
				
				@Override
				 public void mouseClicked(MouseEvent e) {
					 
					 sq.updatePiece(new Bishop(sq.getPiece().getColor()));
					 t.removeAll();
					 t.setVisible(false);
					 BoardGame.setGame(true);
					 BoardGame.switchTimer();
					 
				 }
			});		
			JLabel background = new JLabel();
			background.setBounds(0, 0, 100, 400);
			
			ImageIcon backIcon = p.getColor() == Cores.WHITE? new ImageIcon(String.format("imgs/%s/pieces/white/promo.png", Menu.THEME)) : new ImageIcon(String.format("imgs/%s/pieces/black/promo.png", Menu.THEME));
			background.setIcon(backIcon);
			this.add(background);
			
			this.setVisible(true);
		}
		
	}
	

	
	private char Letter = 'p';
	
	private static final long serialVersionUID = 1L;
	private boolean firstMove = true; // Verifica se foi movido a peça ou não
	
    private ImageIcon PawnIcon;
    
    public Pawn(Cores color){
        super(color);       
        this.PawnIcon = color==Cores.WHITE? new ImageIcon(String.format("imgs/%s/pieces/white/pawn.png", Menu.THEME)) : new ImageIcon(String.format("imgs/%s/pieces/black/pawn.png", Menu.THEME));
        
    }

    @Override
    public ImageIcon getIcon() {
    	return PawnIcon;
    }

	@Override
	protected boolean checkMove(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2) {
		
		// WHITE
		if(this.firstMove) {
			
			if(this.getColor() == Cores.WHITE) {
				if((c1.yc == (c2.yc +1) || c1.yc == (c2.yc +2)) && c1.xc == c2.xc) {
					this.firstMove = false;
					return true;
				}
			}
			else {
				if((c1.yc == (c2.yc -1) || c1.yc == (c2.yc -2)) && c1.xc == c2.xc) {
					this.firstMove = false;
					return true;
				}
			}
			
		}
		
		else {
			if(this.getColor() == Cores.WHITE) {
				if(c1.yc == (c2.yc +1) && c1.xc == c2.xc) {
				return true;
				}
			}
			else {
				if(c1.yc == (c2.yc -1) && c1.xc == c2.xc) {
					return true;
				}
			}
		}
		
		return false;
	
	}

	@Override
	public ArrayList<Coords<Integer, Integer>> allMoves(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2, BoardGame t) {
		
		ArrayList<Coords<Integer, Integer>> possibleMoves = new ArrayList<>();
		
		if(checkMove(c1, c2)) {
			
			if(c2.yc == 0 || c2.yc == 7) {
				
				JWindow promo = new Promo(t.getSquare(c2), this);
				if(this.getColor() == Cores.BLACK) promo.setBounds(t.getSquare(c2).getLocationOnScreen().x, (t.getSquare(c2).getLocationOnScreen().y - 300), 100, 400);
				else promo.setBounds(t.getSquare(c2).getLocationOnScreen().x, t.getSquare(c2).getLocationOnScreen().y, 100, 400);
				BoardGame.setGame(false);
				
			}
			
			
			
			if(firstMove) {
				if(this.getColor() == Cores.WHITE) {
					
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc-1), (c1.yc-1)));
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc-2), (c1.yc-2)));
				}
				else {
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc+1), (c1.yc+1)));
					possibleMoves.add(new Coords<Integer, Integer>((c1.xc+2), (c1.yc+2)));
					
				}
				
			}
			else {
				
				possibleMoves.add(c2);

			}
				
			return possibleMoves;
			
		}
		

		return null;
	}
	
	/**
	 * Função para verificar se o peão pode comer a peça, pois ele anda diferentemente
	 * de como come
	 * {@link board.Coords}
     * @param c1 Coords<Integer, Integer> - Coordenada Inicial
     * @param c2 Coords<Integer, Integer> - Coordenada Final
	 * @return boolean
	 */
	public boolean checkEat(Coords<Integer, Integer> c1, Coords<Integer, Integer> c2, BoardGame t) {
		
		if(this.getColor() == Cores.WHITE) {
			
			if((c2.xc == (c1.xc + 1) || c2.xc == (c1.xc - 1)) && c2.yc == (c1.yc - 1)) {
				
				if(c2.yc == 0) {
					
					JWindow promo = new Promo(t.getSquare(c2), this);
					promo.setBounds(t.getSquare(c2).getLocationOnScreen().x, t.getSquare(c2).getLocationOnScreen().y, 100, 400);
					BoardGame.setGame(false);
					
					
				}
				return true;
			}
		}
		else {
			if((c2.xc == (c1.xc + 1) || c2.xc == (c1.xc - 1)) && c2.yc == (c1.yc + 1)) {
				
				if(c2.yc == 7) {
					JWindow promo = new Promo(t.getSquare(c2), this);
					promo.setBounds(t.getSquare(c2).getLocationOnScreen().x, (t.getSquare(c2).getLocationOnScreen().y - 300), 100, 400);
					BoardGame.setGame(false);
					
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public char getLetter() {
		return Letter;
	}

     
}
