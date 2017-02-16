package estrutura;

import java.util.Random;

public class Batalhar{

    public static void ataca(Enemy enemy, Player player){
            turnoJogador(enemy,player);
            turnoInimigo(enemy,player);
    }

    private static boolean calcSucesso(int prob){
        Random gerador = new Random();
        int altr = gerador.nextInt(100);
        if(altr < prob)
            return true;
        else
            return false;
    }

    private static void turnoInimigo(Enemy enemy,Player player){
        boolean acerto = calcSucesso(enemy.getPrecisao());
        acerto = acerto && !(calcSucesso(player.getArmadura().getEsquiva()));
        boolean crit = calcSucesso(enemy.getProbCritical());

        if(acerto && crit)
            player.takeDamage(2*enemy.getAttack()- player.getArmadura().getProtecao());
        else if(acerto)
            player.takeDamage(enemy.getAttack()-player.getArmadura().getProtecao());

    }

    private static void turnoJogador(Enemy enemy,Player player){
        boolean acerto = calcSucesso(player.getArma().getPrecisao());
        acerto = acerto && !(calcSucesso(enemy.getEsquiva()));
        boolean crit = calcSucesso(player.getArma().getProbCritical());

        if(acerto && crit){
            enemy.takeDamage(2*(player.getArma().getDano()+player.getAttack()));
            System.out.println(2*(player.getArma().getDano()+player.getAttack()));
        }
        else if(acerto){
            enemy.takeDamage(player.getArma().getDano()+player.getAttack());
            System.out.println(player.getArma().getDano()+player.getAttack());
        }
    }
}
