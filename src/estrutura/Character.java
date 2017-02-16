package estrutura;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(int life, int attack) {
        this.life = life;
        this.attack = attack;
    }

    public boolean isAlive() {
        if(this.life > 0)
            return true;

        return false;
    }

    public void takeDamage(int attack) {
        this.life -= attack;
    }

    public int getAttack() {
        return this.attack;
    }
    public void setLife(int life){
    	this.life = life;
    }
    public int getLife(){
        return this.life;
    }
    private int life;
    private int attack;
}

