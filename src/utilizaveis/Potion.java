package utilizaveis;

import java.awt.image.BufferedImage;
import estrutura.Player;
public class Potion extends Item {
    public Potion(BufferedImage img){
        super(img);
    }
    public static void executarAcao(Player player, int vida){
        player.setLife(player.getLife()+ vida );
    }

} 
