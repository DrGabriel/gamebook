package estrutura;
/**
 * Created by filipebraida on 31/05/16.
 */
public class Enemy extends Character {

	private final int probCritical;
	private final int esquiva;
	private final int precisao;
	
    public Enemy(int life, int attack,int probCritical,int esquiva, int precisao) {
    	super(life, attack);
    	this.esquiva=esquiva;
    	this.precisao=precisao;
    	this.probCritical=probCritical;

    }

	public int getProbCritical() {
		return probCritical;
	}

	public int getEsquiva() {
		return esquiva;
	}

	public int getPrecisao() {
		return precisao;
	}

}
