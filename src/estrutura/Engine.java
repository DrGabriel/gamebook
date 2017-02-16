
package estrutura;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import utilizaveis.*;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Engine {

    public static Book createBook() {
        Player p = new Player(1000,10);
       p.setArmadura(new Armadura(5,2,null));
        Event eventoPirata20 = new BlankEvent("Voc� matou todos no navio."
                + " Esse massacre se tornou t�o famoso   que seu navio agora � conhecido como navio da morte."
                + " Por onde   ele passa todos morrem, restando apenas os navios fantasmas."
                + " Vo-c� se tornou o pirata mais temido dos sete mares pelo resto dos  seus dias.", new ArrayList<Choice>());

        Event eventoPirata21 = new BlankEvent("Voc� pede resgate."
                + " Mas a marinha n�o faz neg�cios com piratas."
                + "  Quando o resgate chega eles afundam voc� junto com toda a tripu-la�ao no maior massacre da hist�ria."
                + " Voc� se tornou um m�rtir   contra o abuso da marinha, inspirando gera��es a lutarem contra o governo."
                + " Mesmo sendo um pirata.", new ArrayList<Choice>());



        Collection escolhas20 = new ArrayList<Choice>();
        Choice escolhaPirata20 = new BlankChoice("Matar todos.", eventoPirata20);
        Choice escolhaPirata21 = new BlankChoice("Pedir resgate.", eventoPirata21);
        escolhas20.add(escolhaPirata20);
        escolhas20.add(escolhaPirata21);

        Event eventoPirata18 = new BlankEvent("O seu navio tomou uma boa dist�ncia e a marinha nunca o alcan�ou."
                + " Voc� e os outros marujos viveram o resto da vida como reis com "
                + " todo o saque que obtiveram da marinha.", new ArrayList<Choice>());

        Event eventoPirata19 = new BlankEvent("Voc� captura todos do navio."
                + " Voc� tem a op��o de sequestr�-los e pedir resgate ou"
                + " matar todos.", escolhas20);


        Collection escolhas19 = new ArrayList<Choice>();
        Choice escolhaPirata18 = new BlankChoice("Voc� os ignora e segue viagem.", eventoPirata18);
        Choice escolhaPirata19 = new BlankChoice("D� a volta e os ataca novamente.", eventoPirata19);
        escolhas19.add(escolhaPirata18);
        escolhas19.add(escolhaPirata19);

        Event eventoPirata16 = new BlankEvent("Voc� atracou na ilha, mas a marinha o seguiu."
                + " Eles levam todos  voc�s em cust�dia e recuperam todo o saque."
                + " Voc� ser� executado em pra�a p�blica pelos seus crimes.", new ArrayList<Choice>());

        Event eventoPirata17 = new BlankEvent("Voc� mostra aos ventos quem � que manda e segue viagem."
                + " Logo    adiante voc� percebe que aquele mesmo navio da marinha est� te  seguindo. "
                + "O que voc� faz?", escolhas19);



        Collection escolhas18 = new ArrayList<Choice>();
        Choice escolhaPirata16 = new BlankChoice("Aceitar os ventos e atracar.", eventoPirata16);
        Choice escolhaPirata17 = new BlankChoice("Mudar o vento e continuar viagem.", eventoPirata17);
        escolhas18.add(escolhaPirata16);
        escolhas18.add(escolhaPirata17);

        Event eventoPirata14 = new BlankEvent("Voc� incapacita o Almirante, saqueia totalmente o navio e foge  com sucesso."
                + " Os ventos te levam em dire��o � uma pequena ilha.  Deseja atracar nela?", escolhas18);

        Event eventoPirata15 = new BlankEvent("O Almirante se aproveitou e atirou em voc�.", new ArrayList<Choice>());



        Collection escolhas17 = new ArrayList<Choice>();
        Choice escolhaPirata14 = new BattleChoice("Você ataca.", eventoPirata14, new Almirante(500,500,15,20,90));
        Choice escolhaPirata15 = new BattleChoice("Voc� o ignora.", eventoPirata15, new Almirante(10000,10000,15,20,90));
        escolhas17.add(escolhaPirata14);
        escolhas17.add(escolhaPirata15);

        Event eventoPirata12 = new BlankEvent("Você invade o navio com sua tripulação e encontra o Almirante do navio conversando com algu�m."
                + " Voc� tem a oportunidade de atacar ele desprevinido, por�m se voc� ignor�-lo as chances s�o grandes dele perceber a invas�o"
                + " e te assassinar.", escolhas17);

        Event eventoPirata13 = new BlankEvent("Voc� ignora o navio."
                + " Eles percebem essa brecha e invadem o navio."
                + " Voc� e todos os outros marujos passar�o a vida na cadeia.", new ArrayList<Choice>());



        Collection escolhas16 = new ArrayList<Choice>();
        Choice escolhaPirata12 = new BlankChoice("Atacar.", eventoPirata12);
        Choice escolhaPirata13 = new BlankChoice("Ignorar.", eventoPirata13);
        escolhas16.add(escolhaPirata12);
        escolhas16.add(escolhaPirata13);

        Event eventoPirata10 = new BlankEvent("Voc� luta contra os outros marujos mostrando que � o melhor do  navio."
                + " Eles concordam em te deixar ser o capit�o."
                + " Logo ap�s se  tornar capit�o voc� avista um navio da marinha."
                + " Voc� pode       ignor�-lo ou atac�-lo.", escolhas16);

        Event eventoPirata11 = new BlankEvent("Um marujo qualquer vira capit�o."
                + " Em pouco tempo todos ficam insatisfeitos e ocorre outro motim."
                + " Voc� fica preso nesse ciclo at� que n�o sobrou mais ningu�m"
                + " para ser capit�o do navio e ele se  tornou um navio fantasma.", new ArrayList<Choice>());



        Collection escolhas15 = new ArrayList<Choice>();
        Choice escolhaPirata10 = new BattleChoice("Se voluntariar para ser o capit�o.", eventoPirata10, new Marujo(500,500,15,20,90));
        Choice escolhaPirata11 = new BlankChoice("Deixar qualquer um ser o capit�o.", eventoPirata11);
        escolhas15.add(escolhaPirata10);
        escolhas15.add(escolhaPirata11);

        Event eventoPirata8 = new BlankEvent("Voc� se recusa a participar."
                + " Os marujos sugerem ent�o que voc�  saia do navio."
                + " Voc� sai do navio e tenta um se alistar na mari- nha. "
                + " Por�m descobrem que voc� foi um pirata e voc� passa o res-to da vida na cadeia.", new ArrayList<Choice>());

        Event eventoPirata9 = new BlankEvent("Voc� participou do motim e despos o Capit�o."
                + " Agora o navio est� sem Capit�o e um novo � necess�rio.", escolhas15);



        Collection escolhas14 = new ArrayList<Choice>();
        Choice escolhaPirata8 = new BlankChoice("N�o participar.", eventoPirata8);
        Choice escolhaPirata9 = new BlankChoice("Participar.", eventoPirata9);
        escolhas14.add(escolhaPirata8);
        escolhas14.add(escolhaPirata9);

        Event eventoPirata6 = new BlankEvent("Eles falam sobre um motim."
                + " Um plano para tirar o antigo capit�o do poder."
                + " Eles querem que voc� participe.", escolhas14);

        Event eventoPirata7 = new BlankEvent("Voc� ignora eles."
                + "Pouco tempo depois ocorre um motim e eles      sequestram o navio e entregam"
                + " voc� e o capit�o �s autoridades.", new ArrayList<Choice>());



        Collection escolhas13 = new ArrayList<Choice>();
        Choice escolhaPirata6 = new BlankChoice("Ouvir o que eles tem a dizer.", eventoPirata6);
        Choice escolhaPirata7 = new BlankChoice("N�o ouvir.", eventoPirata7);
        escolhas13.add(escolhaPirata6);
        escolhas13.add(escolhaPirata7);

        Event eventoPirata4 = new BlankEvent("Voc� foi pegar a cerveja. Os outros parecem estar come�ando a   gostar de voc�."
                + " Eles te chamam para conversar sobre algo.", escolhas13);

        Event eventoPirata5 = new BlankEvent("Os marujos ficam irritados coma resposta e te jogam no mar."
                + " Voc� � atacado por um tubar�o e morre.", new ArrayList<Choice>());



        Collection escolhas12 = new ArrayList<Choice>();
        Choice escolhaPirata4 = new BlankChoice("Ir buscar a cerveja.", eventoPirata4);
        Choice escolhaPirata5 = new BlankChoice("Mandar eles mesmos pegarem.", eventoPirata5);
        escolhas12.add(escolhaPirata4);
        escolhas12.add(escolhaPirata5);

        Event eventoPirata2 = new BlankEvent("Voc� desobede�eu o capit�o."
                + " Ele puxou uma pistola e atirou em   voc�."
                + " Voc� morreu.", new ArrayList<Choice>());

        Event eventoPirata3 = new BlankEvent("Voc� limpou o ch�o."
                + " O capit�o riu e disse que voc� n�o fez mais do que a sua obriga��o."
                + " Os outros marujos est�o querendo que vo-c� busque mais cerveja.", escolhas12);



        Collection escolhas11 = new ArrayList<Choice>();
        Choice escolhaPirata2 = new BlankChoice("Se recusar.", eventoPirata2);
        Choice escolhaPirata3 = new BlankChoice("Limpar.", eventoPirata3);
        escolhas11.add(escolhaPirata2);
        escolhas11.add(escolhaPirata3);

        Event eventoMarinha18 = new BlankEvent("Sua busca por vingan�a finalmente acabou."
                + " O Almirante foi vinga-do."
                + " Voc� se tornou o Almirante mais renomado de toda a marinha"
                + " e ser� lembrado como o Almirante que matou o pirata Alma Negra.", new ArrayList<Choice>());

        Event eventoMarinha19 = new BlankEvent("Voc� levou ele para o interrogat�rio."
                + " Ao interrog�-lo voc� des- cobriu onde todos os seus saques estavam."
                + " Recuperando mais de 2 bilh�es perdidos em roubos."
                + " Seu ato de nobreza mostrou que nem  sempre matar � a melhor op��o.", new ArrayList<Choice>());



        Collection escolhas10 = new ArrayList<Choice>();
        Choice escolhaMarinha18 = new BlankChoice("Matar o Capit�o.", eventoMarinha18);
        Choice escolhaMarinha19 = new BlankChoice("Levar em cust�dia.", eventoMarinha19);
        escolhas10.add(escolhaMarinha18);
        escolhas10.add(escolhaMarinha19);

        Event eventoMarinha16 = new BlankEvent("Eles te avistaram e atiaram na dire��o do seu navio o naufragan-do-o."
                + " Todos morreram com o ataque.", new ArrayList<Choice>());

        Event eventoMarinha17 = new BlankEvent("Voc� ataca todos e chega no capit�o do Navio. Voc� o confronta  diretamente."
                + " Voc� pode capturar ele e o levar para interrogat�- rio"
                + " ou pode mat�-lo e vingar a morte do Almirante.", escolhas10);


        Collection escolhas9 = new ArrayList<Choice>();
        Choice escolhaMarinha16 = new BlankChoice("Fazer emboscada.", eventoMarinha16);
        Choice escolhaMarinha17 = new BattleChoice("Atacar diretamente.", eventoMarinha17, new CapitaoPirata(100,100,15,20,90));
        escolhas9.add(escolhaMarinha16);
        escolhas9.add(escolhaMarinha17);

        Event eventoMarinha14 = new BlankEvent("Voc� decidiu seguir os piratas."
                + " Voc� os segue at� eles atracarem em uma ilha. Voc� pode atacar diretamente"
                + " ou fazer uma embosca-da.", escolhas9);

        Event eventoMarinha15 = new BlankEvent("Voc� manteve o navio em ordem e foi um excelente almirante"
                + " por  muitos anos. At� que voc� decidiu se aposentar e viver uma"
                + " vida tranquila no campo.", new ArrayList<Choice>());



        Collection escolhas8 = new ArrayList<Choice>();
        Choice escolhaMarinha14 = new BlankChoice("Seguir os piratas.", eventoMarinha14);
        Choice escolhaMarinha15 = new BlankChoice("Continuar com a rotina do navio.", eventoMarinha15);
        escolhas8.add(escolhaMarinha14);
        escolhas8.add(escolhaMarinha15);


        Event eventoMarinha12 = new BlankEvent("Voc� recusa o cargo e outro almirante assume o cargo."
                + " Ele n�o   gosta de voc� e utiliza do seu poder para te tirar da marinha."
                + "  Voc� agora n�o consegue mais emprego na marinha.", new ArrayList<Choice>());

        Event eventoMarinha13 = new BlankEvent("Voc� se tornou o novo Almirante."
                + " Voc� observa que o navio dos   piratas n�o est� muito distante.", escolhas8);



        Collection escolhas7 = new ArrayList<Choice>();
        Choice escolhaMarinha12 = new BlankChoice("Recusar.", eventoMarinha12);
        Choice escolhaMarinha13 = new BlankChoice("Aceitar.", eventoMarinha13);
        escolhas7.add(escolhaMarinha12);
        escolhas7.add(escolhaMarinha13);

        Event eventoMarinha10 = new BlankEvent("Voc� defendeu o navio contra o ataque, fazendo os piratas recua-rem."
                + " Por�m o Almirante ficou debilitado, o impedindo de manter o cargo."
                + " Ao observar suas habilidades os outros marinheiros pedem para que voc�"
                + " assuma o lugar do Almirante.", escolhas7);

        Event eventoMarinha11 = new BlankEvent("Voc� se escondeu at� que um pirata te achou e atirou em voc�.", new ArrayList<Choice>());



        Collection escolhas6 = new ArrayList<Choice>();
        Choice escolhaMarinha10 = new BattleChoice("Lutar.", eventoMarinha10, new PirataInimigo(100,100,15,20,90));
        Choice escolhaMarinha11 = new BattleChoice("Se esconder. Grandes chances de um inimigo te achar.", eventoMarinha11, new PirataInimigo(20,1,15,20,90));
        escolhas6.add(escolhaMarinha10);
        escolhas6.add(escolhaMarinha11);

        Event eventoMarinha8 = new BlankEvent("O Almirante explica suas fun��es."
                + " No meio da conversa o Navio � atacado por piratas."
                + " O Almirante � atingido e fica debilitado.", escolhas6);

        Event eventoMarinha9 = new BlankEvent("Voc� recusou, ent�o voc� executou seu cargo muito mal e foi des-pachado da marinha."
                + " Voc� agora � um pescador que  vive do que    consegue fisgar.", new ArrayList<Choice>());



        Collection escolhas5 = new ArrayList<Choice>();
        Choice escolhaMarinha8 = new BlankChoice("Ir conversar com o Almirante.", eventoMarinha8);
        Choice escolhaMarinha9 = new BlankChoice("N�o ir conversar com o Almirante.", eventoMarinha9);
        escolhas5.add(escolhaMarinha8);
        escolhas5.add(escolhaMarinha9);

        Event eventoMarinha6 = new BlankEvent("O Almirante ficou feliz com sua escolha."
                + "Voc� foi promovido � suboficial."
                + " O Almirante te chama na sala dele para te explicar suas novas fun��es.", escolhas5);

        Event eventoMarinha7 = new BlankEvent("O Almirante fica chateado, mas entende."
                + "Voc� serve a marinha at� que voc� sofre um acidente no conv�s"
                + " e fica debilitado. Voc� fi-ca incapaz de continuar na marinha para sempre.", new ArrayList<Choice>());



        Collection escolhas4 = new ArrayList<Choice>();
        Choice escolhaMarinha6 = new BlankChoice("Aceitar o cargo.", eventoMarinha6);
        Choice escolhaMarinha7 = new BlankChoice("Recusar o cargo.", eventoMarinha7);
        escolhas4.add(escolhaMarinha6);
        escolhas4.add(escolhaMarinha7);

        Event eventoMarinha4 = new BlankEvent("O Almirante te diz que gostou da sua determina��o e te ofereceu um cargo melhor.", escolhas4);

        Event eventoMarinha5 = new BlankEvent("Voc� manteve o seu cargo por 30 anos at� se aposentar e viver   uma vida "
                + "med�ocre com o dinheiro que voc� guardou.", new ArrayList<Choice>());



        Collection escolhas3 = new ArrayList<Choice>();
        Choice escolhaMarinha4 = new BlankChoice("Conversar.", eventoMarinha4);
        Choice escolhaMarinha5 = new BlankChoice("N�o conversar.", eventoMarinha5);
        escolhas3.add(escolhaMarinha4);
        escolhas3.add(escolhaMarinha5);


        Event eventoMarinha3 = new BlankEvent("Voc� n�o esfregou o ch�o. Por desacatar a ordem de um superior  no primeiro dia,"
                + " voc� foi despachado da marinha e viveu uma vida triste longe do mar.", new ArrayList<Choice>());

        Event eventoMarinha2 = new BlankEvent("Voc� limpou o ch�o. O Almirante viu a sua dedica��o e o chamou  para conversar.", escolhas3);

        Collection escolhas2 = new ArrayList<Choice>();
        Choice escolhaMarinha3 = new BlankChoice("N�o limpar o conv�s.", eventoMarinha3);
        Choice escolhaMarinha2 = new BlankChoice("Limpar o conv�s.", eventoMarinha2);
        escolhas2.add(escolhaMarinha2);
        escolhas2.add(escolhaMarinha3);

        Event eventoPirata1 = new BlankEvent("Você entrou para um grupo de piratas."
                + " O Capit�o mandou voc�     esfregar o ch�o.", escolhas11);

        Event eventoMarinha1 = new BlankEvent("Voc� se alistou na marinha.O Almirante mandou voc� esfregar o   conv�s.", escolhas2);

        Collection escolhasIniciais = new ArrayList<Choice>();
        Choice escolhaMarinha1 = new BlankChoice("Alistar na marinha", eventoMarinha1);
        Choice escolhaPirata1 = new BlankChoice("Conversar com o homem", eventoPirata1);
        escolhasIniciais.add(escolhaMarinha1);
        escolhasIniciais.add(escolhaPirata1);

        Event eventoInitial = new BlankEvent("Voc� sempre gostou do mar. " +
                "Sempre quis estar a bordo de um navi-o. " +
                "Voc� v� um homem da marinha recrutando e um outro homem um   pouco distante, dizendo que precisa de uma tripula��o.", escolhasIniciais);

        Book livro = new Book("Piranha", eventoInitial, p);

        return livro;
    }
}
