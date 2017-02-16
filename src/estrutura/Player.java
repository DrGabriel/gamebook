package estrutura;

import utilizaveis.*;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Player extends Character {
	private Armadura armadura;
	private Arma arma;
	private Item[] inventario;
	private int inventarioPos = 1;
	
    public Player(int life, int attack) {
        super(life, attack);
        inventario = new Item[6];
    }

    public void setArmadura(Armadura armadura){
    	this.armadura = armadura;
    }
    public void setInventario(int pos, Item item){
    	this.inventario[pos] = item;
    }
    public Item getInvetario (int pos){
    	return this.inventario[pos];
    }

    public Armadura getArmadura(){
    	return this.armadura;
    }

    public void setArma(Arma arma){
    	this.arma = arma;
    }

    public Arma getArma(){
    
    	return this.arma;
    }

    public void battle(Enemy enemy) {

        System.out.println("BATALHAAA");
        while(this.isAlive() && enemy.isAlive()){
            Batalhar.ataca(enemy,this);
        }
        if(!this.isAlive())
            System.out.println("MORREEEU");
        if (!enemy.isAlive()){
            System.out.println("INIMIGO MORTO");
            System.out.println(enemy.getLife());

       }
    }
}
