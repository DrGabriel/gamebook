package utilizaveis;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GerenciadorDeItems {
	private Arma[] armasDoJogo;
	private Armadura[] armadurasDoJogo;
	private BufferedImage potionImg;
	public GerenciadorDeItems(){
        BufferedImage sabreImg = null;
        BufferedImage revolverImg = null;
        BufferedImage armaduraPirata = null;
        BufferedImage armaduraMarinha = null;
        potionImg = null;
        armasDoJogo = new Arma[2];
        armadurasDoJogo = new Armadura[2];
		try {
			sabreImg = ImageIO.read(new File("imgs/sabre.png"));
			revolverImg = ImageIO.read(new File("imgs/revolver.png"));
			potionImg = ImageIO.read(new File("imgs/potion.jpg"));
			armaduraPirata = ImageIO.read(new File("imgs/roupaPirata.png"));
			armaduraMarinha = ImageIO.read(new File("imgs/roupaMarinha.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		armasDoJogo[0] = new Sabre(sabreImg);
		armasDoJogo[1] = new Revolver(revolverImg);
		armadurasDoJogo[0] = new ArmaduraPirata(armaduraPirata);
		armadurasDoJogo[1] = new ArmaduraMarinha(armaduraMarinha);
	}
	public Arma getArmas(int pos){
		if(pos > 1 || pos < 0){
			System.out.println("Utilize numeros dentro do intervalo 0-2 para selecionar os items do jogo!");
			return null;
		}
		return armasDoJogo[pos];
	}
	public Armadura getArmadura(int pos){
		if(pos > 1 || pos < 0){
			System.out.println("Utilize numeros dentro do intervalo 0-2 para selecionar os items do jogo!");
			return null;
		}
		return armadurasDoJogo[pos];
	}
	public Potion getPotion(){
		return new Potion(potionImg);
	}
}
