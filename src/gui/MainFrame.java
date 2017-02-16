
package gui;

import utilizaveis.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;

import estrutura.BattleChoice;
import estrutura.Book;
import estrutura.Choice;
import estrutura.Engine;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;

public class MainFrame {
	private BufferedImage backgroundImg;
	private BufferedImage backgroundImgText;
	private BufferedImage inventarioImg;
	private BufferedImage nomesImg;
	private JLabel background,lblPocao;
	private JLabel inventarioLabel;
	private JLabel background1;
	private JLabel backgroundText;
	private JLabel[] espacoLabel = new JLabel[6];
	private JFrame frmMudandoOsVentos;
	private Choice[] choices = new Choice[3];
	private Book book = Engine.createBook();
	private Potion potion;
	private int inventarioPos =2,totalPocoes = 3;
	boolean jogando = false;
	private GerenciadorDeItems gerenciador;
	private boolean espaco1Selecionado = false, espaco2Selecionado = true,
			espaco3Selecionado = false, espaco4Selecionado = false, 
			espaco5Selecionado = false, espaco6Selecionado = false,
			primeiraEscolha = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmMudandoOsVentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		gerenciador = new GerenciadorDeItems();
		//0 adaga, 1 sabre, 2 revolver
		book.getPlayer().setInventario(1, gerenciador.getArmas(0));
		book.getPlayer().setArma((Arma)book.getPlayer().getInvetario(1));
		book.getPlayer().setInventario(0, gerenciador.getPotion());
		potion = (Potion) book.getPlayer().getInvetario(0);
		
		frmMudandoOsVentos = new JFrame();
		frmMudandoOsVentos.setTitle("AA comp2");
		frmMudandoOsVentos.setBounds(100, 100, 800, 600);
		frmMudandoOsVentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMudandoOsVentos.getContentPane().setLayout(new CardLayout(0, 0));
		frmMudandoOsVentos.setResizable(false);
		
		//Carrega imagens que serao usadas durante o JFrame
		try {//Caso nao seja encontrada a imagem uma excecao eh lancada
			backgroundImg = ImageIO.read(new File("imgs/background.jpeg"));
			backgroundImgText = ImageIO.read(new File("imgs/fundoTexto.png"));
			nomesImg = ImageIO.read(new File("imgs/nomes.png"));
			inventarioImg = ImageIO.read(new File("imgs/inventory.jpg"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		background = new JLabel(new ImageIcon(backgroundImg));//JLabel que contem a imagem do background
		background.setBounds(0, 0, 800, 600);
		background1 = new JLabel(new ImageIcon(nomesImg));//JLabel que contem a imagem do background
		background1.setBounds(0, 0, 800, 600);
		backgroundText = new JLabel(new ImageIcon(backgroundImgText));//JLabel que contem a imagem do background do texto
		backgroundText.setBounds(120, 16, 564, 167);
		inventarioLabel = new JLabel(new ImageIcon(inventarioImg));
		inventarioLabel.setBounds(12,367,316,206);
		/////////////////////////////////////
		//Panels
		final JPanel mainPanel = new JPanel();
		frmMudandoOsVentos.getContentPane().add(mainPanel, "name_148825179814800");
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);

		final JPanel gamingPanel = new JPanel();
		frmMudandoOsVentos.getContentPane().add(gamingPanel, "name_152510622627787");
		gamingPanel.setLayout(null);
		gamingPanel.setVisible(false);

		////////////////////////////////////////
		//Labels
		final JLabel bookNameLabel = new JLabel("auhaeuaehuae");
		bookNameLabel.setFont(new Font("Liberation Sans", Font.BOLD | Font.ITALIC, 12));
		bookNameLabel.setForeground(Color.DARK_GRAY);
		bookNameLabel.setBackground(Color.WHITE);
		bookNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookNameLabel.setBounds(203, 22, 303, 25);
		gamingPanel.add(bookNameLabel);

		JLabel lblNewLabel = new JLabel("\u00A9 UFRRJ - 2016");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(12, 529, 100, 14);
		mainPanel.add(lblNewLabel);
		
		
		
		JProgressBar vidaProgressBar = new JProgressBar(0,book.getPlayer().getLife());
		vidaProgressBar.setBounds(463, 472, 234, 40);
		vidaProgressBar.setValue(book.getPlayer().getLife());
		vidaProgressBar.setStringPainted(true);
		vidaProgressBar.setForeground(Color.red);
		gamingPanel.add(vidaProgressBar);
		
		JLabel vidaProgressLabel = new JLabel("         life");
		vidaProgressLabel.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 14));
		vidaProgressLabel.setOpaque(true);
		vidaProgressLabel.setForeground(Color.RED);
		vidaProgressLabel.setBackground(Color.GRAY);
		vidaProgressLabel.setBounds(516, 436, 117, 31);
		gamingPanel.add(vidaProgressLabel);
		///////////////////////////////////////////////////////
		//Text area
		final JTextArea historyLabel = new JTextArea();
		historyLabel.setText("historia");
		historyLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
		historyLabel.setBounds(144, 59, 514, 110);
		historyLabel.setEditable(false);
		historyLabel.setLineWrap(true);
		gamingPanel.add(historyLabel);

		/////////////////////////////////////////
		//Buttons
		final JButton playAgainButton = new JButton("Jogar Novamente");
		final JButton playButton = new JButton("novo jogo");
		playButton.setFont(new Font("Monospaced", Font.BOLD, 14));
		final JButton choiceOneButton = new JButton("Escolha 1");
		choiceOneButton.setFont(new Font("Monospaced", Font.BOLD, 12));
		final JButton choiceTwoButton = new JButton("Escolha 2");
		choiceTwoButton.setFont(new Font("Monospaced", Font.BOLD, 12));


		
		
		playButton.setBackground(new Color(51, 102, 255));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				gamingPanel.add(backgroundText);
				gamingPanel.add(inventarioLabel);
				gamingPanel.add(background);
				gamingPanel.setVisible(true);
				//book = Engine.createBook();
				bookNameLabel.setText(book.showHistoryBook());
				historyLabel.setText(book.showHistory());
				int i=0;
	            for(Choice choice:book.nextEvents()) {
	            	choices[i] = choice;
	            	i++;
	            }
	            choiceOneButton.setText(choices[0].getDescription());
	            choiceTwoButton.setText(choices[1].getDescription());

			}
		});
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				playButton.setBackground(new Color(200, 0, 0));
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				playButton.setBackground(new Color(51, 102, 255));
				playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});
		playButton.setBounds(338, 307, 165, 56);
		mainPanel.add(playButton);

        playAgainButton.setBackground(new Color(255, 153, 0));
		playAgainButton.setForeground(Color.WHITE);
		playAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book = Engine.createBook();
				book.getPlayer().setInventario(1, gerenciador.getArmas(0));
				book.getPlayer().setArma((Arma)book.getPlayer().getInvetario(1));
				book.getPlayer().setInventario(0, gerenciador.getPotion());
				espacoLabel[1].setEnabled(true);
				inventarioPos = 2;
				totalPocoes = 3;
				primeiraEscolha = true;
				lblPocao.setText(String.valueOf(totalPocoes));
				//reseta inventario
				for(int index = 2;index<6;index++){
						espacoLabel[index].setIcon(null);
						espacoLabel[index].setEnabled(false);
						book.getPlayer().setInventario(index, null);
				}
				vidaProgressBar.setValue(book.getPlayer().getLife());
				choiceOneButton.setVisible(true);
				choiceTwoButton.setVisible(true);
				playAgainButton.setVisible(false);
				historyLabel.setText(book.showHistory());
				int i=0;
	            for(Choice choice:book.nextEvents()) {
                    choices[i] = choice;
                    i++;
	            }

                choiceOneButton.setText(choices[0].getDescription());
	            choiceTwoButton.setText(choices[1].getDescription());
			}
		});

		playAgainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playAgainButton.setBackground(new Color(255, 102, 0));
				playAgainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				playAgainButton.setBackground(new Color(255, 153, 0));
				playAgainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		playAgainButton.setFont(new Font("Monospaced", Font.BOLD, 12));
		playAgainButton.setBounds(144, 253, 514, 60);
		gamingPanel.add(playAgainButton);
		playAgainButton.setVisible(false);




		mainPanel.add(background1);



		choiceOneButton.setForeground(Color.WHITE);

		choiceOneButton.setBackground(new Color(255, 0, 0));
		choiceOneButton.setBounds(116, 200, 564, 60);
        gamingPanel.add(choiceOneButton);

		choiceOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                if(!book.isTheEnd()){
                	if(primeiraEscolha){
                		primeiraEscolha = false;
                		book.getPlayer().setInventario(5, gerenciador.getArmadura(1));
                		espacoLabel[5].setIcon(new ImageIcon(gerenciador.getArmadura(1).getItemImg()));
                		espacoLabel[5].setEnabled(true);
                	}
                    if( choices[0] instanceof BattleChoice || choices[1] instanceof BattleChoice){
                    	if(inventarioPos -1< 2){
                        	book.getPlayer().setInventario(inventarioPos, gerenciador.getArmas((inventarioPos -1)));
                        	espacoLabel[inventarioPos].setIcon(new ImageIcon(gerenciador.getArmas((inventarioPos -1)).getItemImg()));
                        	inventarioPos++;
                    	}

                    }
                        if(book.nextEvent(0)){
    						historyLabel.setText(book.showHistory());
    						int i=0;
    			            for(Choice choice:book.nextEvents()) {
    			            	choices[i] = choice;
    			            	i++;
    			            }
    			            vidaProgressBar.setValue(book.getPlayer().getLife());
    			            choiceOneButton.setText(choices[0].getDescription());
    			            choiceTwoButton.setText(choices[1].getDescription());
    					}
                    }

				}
		});

		choiceOneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				choiceOneButton.setBackground(new Color(200, 0, 0));
				choiceOneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				choiceOneButton.setBackground(new Color(255, 0, 0));
				choiceOneButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseReleased(MouseEvent arg0) {

			    if(book.isTheEnd()){
                    choiceOneButton.setVisible(false);
                    choiceTwoButton.setVisible(false);
                    playAgainButton.setVisible(true);
			    }
			}

		});

		choiceTwoButton.setForeground(Color.WHITE);
		choiceTwoButton.setBackground(new Color(0, 102, 255));
		choiceTwoButton.setBounds(116, 302, 564, 60);
		gamingPanel.add(choiceTwoButton);
		

		choiceTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!book.isTheEnd()){
                	if(primeiraEscolha){
                		primeiraEscolha = false;
                		book.getPlayer().setInventario(5, gerenciador.getArmadura(0));
                		espacoLabel[5].setIcon(new ImageIcon(gerenciador.getArmadura(0).getItemImg()));
                		espacoLabel[5].setEnabled(true);
                	}
	                if( choices[0] instanceof BattleChoice || choices[1] instanceof BattleChoice){
	                	if(inventarioPos -1< 2){
	                    	book.getPlayer().setInventario(inventarioPos, gerenciador.getArmas((inventarioPos -1)));
	                    	espacoLabel[inventarioPos].setIcon(new ImageIcon(gerenciador.getArmas((inventarioPos -1)).getItemImg()));
	                    	inventarioPos++;
	                	}

	                }
					if(book.nextEvent(1)){
						historyLabel.setText(book.showHistory());
						int i=0;
			            for(Choice choice:book.nextEvents()){
			            	choices[i] = choice;
			            	i++;
			            }
			            choiceOneButton.setText(choices[0].getDescription());
			            choiceTwoButton.setText(choices[1].getDescription());
			            vidaProgressBar.setValue(book.getPlayer().getLife());
					}
				}
			}
		});
		choiceTwoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				choiceTwoButton.setBackground(new Color(0, 71, 176));
				choiceTwoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				choiceTwoButton.setBackground(new Color(0, 102, 255));
				choiceTwoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseReleased(MouseEvent arg0) {

			    if(book.isTheEnd()){
						choiceOneButton.setVisible(false);
						choiceTwoButton.setVisible(false);
						playAgainButton.setVisible(true);
			    }
			}

		});
		// Inventario
		///////////////////////////////////////////////////
		
		lblPocao = new JLabel(String.valueOf(totalPocoes));
		lblPocao.setFont(new Font("Bitstream Vera Sans", Font.BOLD, 14));
		lblPocao.setForeground(Color.WHITE);
		lblPocao.setBounds(91, 374, 70, 15);
		gamingPanel.add(lblPocao);
		
		espacoLabel[0] = new JLabel (new ImageIcon(book.getPlayer().getInvetario(0).getItemImg()));
		espacoLabel[0].setEnabled(true);
		espacoLabel[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				espacoLabel[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(totalPocoes <= 0){
					espacoLabel[0].setEnabled(false);
				}
				espacoLabel[0].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(totalPocoes > 0){
					espacoLabel[0].setEnabled(true);
					//usa potion
					potion.executarAcao(book.getPlayer(), 200);
					totalPocoes--;
					lblPocao.setText(String.valueOf(totalPocoes));
					vidaProgressBar.setValue(book.getPlayer().getLife());

				}else{
					espaco1Selecionado = false;
					espacoLabel[0].setEnabled(false);
					JOptionPane.showMessageDialog(frmMudandoOsVentos,
						    "Não há mais poções!");
				}

			}
		});
		espacoLabel[0].setBounds(16, 369, 98, 98);
		gamingPanel.add(espacoLabel[0]);
		
		espacoLabel[1] = new JLabel(new ImageIcon(book.getPlayer().getInvetario(1).getItemImg()));
		espacoLabel[1].setBounds(120, 369, 98, 98);
		espacoLabel[1].setEnabled(true);
		espacoLabel[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				espacoLabel[1].setEnabled(true);
				espacoLabel[1].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!espaco2Selecionado){
					espacoLabel[1].setEnabled(false);
				}
				espacoLabel[1].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(!espaco2Selecionado){
					if(book.getPlayer().getInvetario(1)!=null)
						book.getPlayer().setArma((Arma)book.getPlayer().getInvetario(1));
					
					espaco2Selecionado = true;
					espaco3Selecionado =false;
					espaco4Selecionado =false;
					espaco5Selecionado =false;
					espaco6Selecionado =false;
					espacoLabel[1].setEnabled(true);
					espacoLabel[2].setEnabled(false);
					espacoLabel[3].setEnabled(false);
					espacoLabel[4].setEnabled(false);
					espacoLabel[5].setEnabled(false);
				}else{
					espaco2Selecionado = false;
					espacoLabel[1].setEnabled(false);
				}

			}
		});
		gamingPanel.add(espacoLabel[1]);
		
		espacoLabel[2] = new JLabel();
		espacoLabel[2].setBounds(225, 369, 98, 98);
		espacoLabel[2].setEnabled(false);
		espacoLabel[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				espacoLabel[2].setEnabled(true);
				espacoLabel[2].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!espaco3Selecionado){
					espacoLabel[2].setEnabled(false);
				}
				espacoLabel[2].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(!espaco3Selecionado){
					if(book.getPlayer().getInvetario(2)!=null)
						book.getPlayer().setArma((Arma)book.getPlayer().getInvetario(2));
					espaco3Selecionado = true;
					espaco2Selecionado =false;
					espaco4Selecionado =false;
					espaco5Selecionado =false;
					espaco6Selecionado =false;
					espacoLabel[2].setEnabled(true);
					espacoLabel[1].setEnabled(false);
					espacoLabel[3].setEnabled(false);
					espacoLabel[4].setEnabled(false);
					espacoLabel[5].setEnabled(false);
				}else{
					espaco3Selecionado = false;
					espacoLabel[2].setEnabled(false);
				}

			}
		});
		gamingPanel.add(espacoLabel[2]);
		
		espacoLabel[3] = new JLabel();
		espacoLabel[3].setBounds(16, 472, 98, 98);
		espacoLabel[3].setEnabled(false);
		espacoLabel[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				espacoLabel[3].setEnabled(true);
				espacoLabel[3].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!espaco4Selecionado){
					espacoLabel[3].setEnabled(false);
				}
				espacoLabel[3].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(!espaco4Selecionado){
					if(book.getPlayer().getInvetario(2)!=null)
						book.getPlayer().setArma((Arma)book.getPlayer().getInvetario(2));
					espaco4Selecionado = true;
					espaco2Selecionado =false;
					espaco3Selecionado =false;
					espaco5Selecionado =false;
					espaco6Selecionado =false;
					espacoLabel[3].setEnabled(true);
					espacoLabel[1].setEnabled(false);
					espacoLabel[2].setEnabled(false);
					espacoLabel[4].setEnabled(false);
					espacoLabel[5].setEnabled(false);
				}else{
					espaco4Selecionado = false;
					espacoLabel[3].setEnabled(false);
				}

			}
		});
		gamingPanel.add(espacoLabel[3]);
		
		espacoLabel[4] = new JLabel();
		espacoLabel[4].setBounds(120, 472, 98, 98);
		espacoLabel[4].setEnabled(false);
		espacoLabel[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				espacoLabel[4].setEnabled(true);
				espacoLabel[4].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!espaco5Selecionado){
					espacoLabel[4].setEnabled(false);
				}
				espacoLabel[4].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(!espaco5Selecionado){
					espaco5Selecionado = true;
					espaco2Selecionado =false;
					espaco3Selecionado =false;
					espaco4Selecionado =false;
					espaco6Selecionado =false;
					espacoLabel[4].setEnabled(true);
					espacoLabel[1].setEnabled(false);
					espacoLabel[2].setEnabled(false);
					espacoLabel[3].setEnabled(false);
					espacoLabel[5].setEnabled(false);
				}else{
					espaco5Selecionado = false;
					espacoLabel[4].setEnabled(false);
				}

			}
		});
		gamingPanel.add(espacoLabel[4]);
		
		espacoLabel[5] = new JLabel();
		espacoLabel[5].setBounds(225, 472, 98, 98);
		espacoLabel[5].setEnabled(false);
		espacoLabel[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!espaco6Selecionado){
					espaco6Selecionado = true;
					espaco2Selecionado =false;
					espaco3Selecionado =false;
					espaco4Selecionado =false;
					espaco5Selecionado =false;
					espacoLabel[5].setEnabled(true);
					espacoLabel[1].setEnabled(false);
					espacoLabel[2].setEnabled(false);
					espacoLabel[3].setEnabled(false);
					espacoLabel[4].setEnabled(false);
				}else{
					espaco6Selecionado = false;
					espacoLabel[5].setEnabled(false);
				}

			}
		});
		gamingPanel.add(espacoLabel[5]);
		

		///////////////////////////////////////////////////////////////////////////////


	}
}
