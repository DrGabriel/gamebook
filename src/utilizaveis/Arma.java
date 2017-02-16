
package utilizaveis;

import java.awt.image.BufferedImage;

public class Arma extends Item {
	private final int dano;
	private final int precisao;
	private final int probCritical;
	
	public Arma(BufferedImage itemImg, int dano, int precisao,int probCritical) {
		super(itemImg);
		this.dano = dano;
		this.precisao = precisao;
		this.probCritical = probCritical;
	}

	public int getDano() {
		return dano;
	}

	public int getPrecisao() {
		return precisao;
	}
	
	public int getProbCritical(){
		return probCritical;
	}


}
