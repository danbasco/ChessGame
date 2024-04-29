package menu;

import javax.swing.JFrame;

import player.*;

import colors.*;
import javax.swing.JLabel;
import javax.swing.JTextField;

import board.BoardGame;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	
	private JButton button;
	
	private JTextField name1;
	private JTextField name2;
	
	private String names1 = "Player 1";
	private String names2 = "Player 2";
	
	public Menu() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 712, 738);
		
		this.setVisible(true);
		this.setResizable(false);
		
		frontCabuloso2();
		
	}
	
	private static final long serialVersionUID = 1L;

	
	public Player[] createPlayers() throws InterruptedException {
		
	
		Player p1 = new Player(names1, Cores.WHITE, true);
		Player p2 = new Player(names2, Cores.BLACK, false);
		
		Player[] ps = new Player[] {
			p1,
			p2
		};
		
		
		return ps;
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			
			this.names1 = name1.getText();
			this.names2 = name2.getText();
			
		}
		
		try {
			new BoardGame(createPlayers());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
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
		bongasmenu.setIcon(new ImageIcon(Menu.class.getResource("/imgs/Bongasbanner.png")));
		bongasmenu.setBounds(0, 0, 732, 702);
		getContentPane().add(bongasmenu);
		
	}
}
