

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class MainFrame {
	private BufferedImage backgroundImg;
	private BufferedImage backgroundImgText;
	private BufferedImage nomesImg;
	private JLabel background;
	private JLabel background1;
	private JLabel backgroundText;
	private JFrame frmMudandoOsVentos;
	private Choice[] choices = new Choice[3];
	private Book book;
	boolean jogando = false;

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
		frmMudandoOsVentos = new JFrame();
		frmMudandoOsVentos.setTitle("AA comp2");
		frmMudandoOsVentos.setBounds(100, 100, 600, 400);
		frmMudandoOsVentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMudandoOsVentos.getContentPane().setLayout(new CardLayout(0, 0));
		frmMudandoOsVentos.setResizable(false);
		//Carrega imagens que serao usadas durante o JFrame
		try {//Caso nao seja encontrada a imagem uma excecao eh lancada
			backgroundImg = ImageIO.read(new File("imgs/background.jpg"));
			backgroundImgText = ImageIO.read(new File("imgs/fundoTexto.png"));
			nomesImg = ImageIO.read(new File("imgs/nomes.png"));
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		background = new JLabel(new ImageIcon(backgroundImg));//JLabel que contem a imagem do background
		background.setBounds(0, 0, 600, 400);
		background1 = new JLabel(new ImageIcon(nomesImg));//JLabel que contem a imagem do background
		background1.setBounds(0, 0, 600, 400);
		backgroundText = new JLabel(new ImageIcon(backgroundImgText));//JLabel que contem a imagem do background do texto
		backgroundText.setBounds(10, 11, 564, 167);
		
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
		bookNameLabel.setBounds(136, 29, 303, 25);
		gamingPanel.add(bookNameLabel);
		
		JLabel lblNewLabel = new JLabel("\u00A9 UFRRJ - 2016");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 346, 100, 14);
		mainPanel.add(lblNewLabel);
		///////////////////////////////////////////////////////
		//Text area
		final JTextArea historyLabel = new JTextArea();
		historyLabel.setText("historia");
		historyLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 13));
		historyLabel.setBounds(38, 60, 514, 110);
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
		
		
		playAgainButton.setBackground(new Color(255, 153, 0));
		playAgainButton.setForeground(Color.WHITE);
		playAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				book.resetHistory();
				book.revive();//reseta life
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
		playAgainButton.setBounds(38, 230, 514, 60);
		gamingPanel.add(playAgainButton);
		playAgainButton.setVisible(false);

		

		playButton.setBackground(new Color(51, 102, 255));
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				gamingPanel.add(backgroundText);
				gamingPanel.add(background);
				gamingPanel.setVisible(true);
				book = Engine.createBook();
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
		playButton.setBounds(43, 232, 165, 56);
		mainPanel.add(playButton);
		mainPanel.add(background1);
		

				
		choiceOneButton.setForeground(Color.WHITE);

		choiceOneButton.setBackground(new Color(255, 0, 0));
		choiceOneButton.setBounds(10, 203, 564, 60);
		gamingPanel.add(choiceOneButton);
		
		choiceOneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!book.isTheEnd()){
					if(book.nextEvent(0)){
						historyLabel.setText(book.showHistory());
						int i=0;
			            for(Choice choice:book.nextEvents()) {
			            	choices[i] = choice;
			            	i++;
			            }
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
		choiceTwoButton.setBounds(10, 274, 564, 60);
		gamingPanel.add(choiceTwoButton);
		
		choiceTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!book.isTheEnd()){
					if(book.nextEvent(1)){
						historyLabel.setText(book.showHistory());
						int i=0;
			            for(Choice choice:book.nextEvents()) {
			            	choices[i] = choice;
			            	i++;
			            }
			            choiceOneButton.setText(choices[0].getDescription());
			            choiceTwoButton.setText(choices[1].getDescription());
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
	
	}
}
