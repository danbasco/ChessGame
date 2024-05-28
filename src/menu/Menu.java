package menu;

import javax.swing.JFrame;
import playsounds.Sounds;
import javax.swing.JLabel;

import javax.swing.ImageIcon;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**Classe principal do menu inicial
 * @version 1.1
 */


public class Menu extends JFrame {
	
	/** Inner class customizada para criar um MouseAdapter e conseguir receber
	 * como parâmetro o Menu
	 */
	private abstract class MouseAdapter implements MouseListener {
		public Menu menu;
		protected MouseAdapter(Menu menu) {
			
			this.menu = menu;
		}
		
	    public void mouseClicked(MouseEvent e) {}
	    public void mousePressed(MouseEvent e) {}
	    public void mouseReleased(MouseEvent e) {}
	    public void mouseEntered(MouseEvent e) {}
	    public void mouseExited(MouseEvent e) {}
	}
	
	public static String THEME = "default";  // Tema default - atlantic
	private static final long serialVersionUID = 1L;

	/** Construtor do Menu, que vai criar a interface gráfica*/
	public Menu() { 
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 712, 738); // Tamanho do Menu
		
		this.setVisible(true);
		this.setResizable(false);
		
		frontSinistro2();
		
	}
	
	/** Função para fechar o Menu */
	public void clearMenu() {
		super.dispose();
	}
	
	/** Função para reiniciar o Menu e atualizar */
	public void repaintMenu() {
		super.dispose();
		new Menu();
	}
	/** Parte Visual do menu */
	private void frontSinistro2() {
		
		
		getContentPane().setLayout(null);
		
		/**
		 *  Como os botões do JLabel são feios, criamos um design diferente no
		 *  Photoshop e colocamos um JPanel transparente sobre o botão para ter
		 *  a interação
		 */
		
		// Botão de iniciar Jogo
		JPanel startGame = new JPanel();
		startGame.setBounds(275, 498, 154, 79);
		startGame.setOpaque(false);
		startGame.addMouseListener(new MouseAdapter(this) {
			@Override	
			public void mouseClicked(MouseEvent e) {
				try {
					Sounds.onCapture();
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				new Start();
				menu.clearMenu();
			}
		});
		getContentPane().add(startGame);
		
		// Botão para alterar o tema do Jogo
		JPanel options = new JPanel();
		options.setBounds(288, 605, 123, 61);
		options.setOpaque(false);
		options.addMouseListener(new MouseAdapter(this) {
			@Override	
			public void mouseClicked(MouseEvent e) {
				try {
					Sounds.onCapture(); /** {@link playsounds.Sounds#onCapture()} */
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				Menu.THEME = Menu.THEME == "atlantic" ? "default" : "atlantic";
				menu.repaintMenu();
			}
		});
		getContentPane().add(options);
		
		
		//Banner de fundo do menu
		JLabel bongasmenu = new JLabel("");
		bongasmenu.setIcon(new ImageIcon(String.format("imgs/%s/menu/Bongasbanner.png", Menu.THEME))); 
		bongasmenu.setBounds(0, 0, 732, 702);
		getContentPane().add(bongasmenu);
		
	}
	
}
