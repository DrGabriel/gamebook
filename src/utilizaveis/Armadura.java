
package utilizaveis;

import java.awt.image.BufferedImage;

public class Armadura extends Item{
	private final int protecao;
	private final int esquiva;

	public int getProtecao() {
		return protecao;
	}

	public int getEsquiva() {
		return esquiva;
	}

	public Armadura(int protecao, int esquiva,BufferedImage img) {
		super(img);
		this.protecao = protecao;
		this.esquiva = esquiva;
	}


}
