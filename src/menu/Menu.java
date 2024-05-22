package menu;

import javax.swing.JFrame;

import player.*;
import playsounds.Sounds;
import colors.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import board.BoardGame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener { 
	 
	private JButton button; // Botão para começar o jogo
	
	private JTextField name1; 
	private JTextField name2;
	
	
	public Menu() { // Construtor do Menu, que vai criar a interface gráfica
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 712, 738); // Tamanho do Menu
		
		this.setVisible(true);
		this.setResizable(false);
		
		frontCabuloso2();
		
	}
	
	private static final long serialVersionUID = 1L;

	/* 
	 * Essa função aqui vai criar os players, Player 1 e Player 2 e vai retornar um vetor
	 * com os dois players criados
	 */
	
	public Player[] createPlayers(String n1, String n2){ 
		
	
		Player p1 = new Player(n1, Cores.WHITE); // Player 1
		Player p2 = new Player(n2, Cores.BLACK); // Player 2
		
		Player[] ps = new Player[] {
			p1,
			p2
		};
		
		
		return ps;
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) { // Evento para quando o botão de iniciar jogo for pressionado
		
		// Nomes default dos players caso nenhum tenha sido inserido
		
		String n1 = "Player 1"; 
		String n2 = "Player 2";
		
		if(e.getSource() == button) {
			
			if(!name1.getText().equals("")) n1 = name1.getText();
			if(!name2.getText().equals("")) n2 = name2.getText();
			
		}
		
		try {
			
			/**
			 * Efeito sonoro especial para quando iniciar o jogo 
			 * {@link playsounds.Sounds}
			 */
			
			Sounds.gameStart();
			new BoardGame(createPlayers(n1, n2));
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		super.dispose();
				
		
	}
	
	
	private void frontCabuloso2() {
		
		
		getContentPane().setLayout(null);
		
		name1 = new JTextField();
		name1.setBackground(new Color(121, 104, 100));
		name1.setBounds(120, 60, 232, 41);
		getContentPane().add(name1);
		
		name2 = new JTextField();
		name2.setBackground(new Color(121, 104, 100));
		name2.setBounds(120, 128, 232, 41);
		getContentPane().add(name2);
		
		button = new JButton("Jogar");
		button.addActionListener(this);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(121, 104, 100));
		button.setBounds(120, 188, 119, 41);
		getContentPane().add(button);
		
		
		JLabel bongasmenu = new JLabel("");
		bongasmenu.setIcon(new ImageIcon("imgs/Bongasbanner.png"));
		bongasmenu.setBounds(0, 0, 732, 702);
		getContentPane().add(bongasmenu);
		
		JPanel olhoDireito = new JPanel();
		olhoDireito.setBounds(536, 177, 52, 66);
		getContentPane().add(olhoDireito);
		
		JPanel olhoEsquerdo = new JPanel();
		olhoEsquerdo.setBounds(445, 177, 52, 66);
		getContentPane().add(olhoEsquerdo);
		
		olhoDireito.addMouseListener(bongasEventDireito());
		olhoEsquerdo.addMouseListener(bongasEventEsquerdo());
		
		
	}
	
	
	// OLHO DIREITO

	
	private MouseAdapter bongasEventDireito() {
		return new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Sounds.plim();
				} catch (Exception e1) {
					System.out.println(e1);
				
			}
			}
		};
	}
	
	
	// OLHO ESQUERDO
	
	
	
	private MouseAdapter bongasEventEsquerdo() {
		return new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					Sounds.boing();
				} catch (Exception e1) {
					System.out.println(e1);
				
			}
			}
		};
	}
}
