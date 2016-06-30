
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
 
/**
 * Created by filipebraida on 31/05/16.
 */
public class Engine {
 
    public static Book createBook() {
       
        Event eventoPirata20 = new BlankEvent("Você matou todos no navio."
                + " Esse massacre se tornou tão famoso   que seu navio agora é conhecido como navio da morte."
                + " Por onde   ele passa todos morrem, restando apenas os navios fantasmas."
                + " Vo-cê se tornou o pirata mais temido dos sete mares pelo resto dos  seus dias.", new ArrayList<Choice>());
       
        Event eventoPirata21 = new BlankEvent("Você pede resgate."
                + " Mas a marinha não faz negócios com piratas."
                + "  Quando o resgate chega eles afundam você junto com toda a tripu-laçao no maior massacre da história."
                + " Você se tornou um mártir   contra o abuso da marinha, inspirando gerações a lutarem contra o governo."
                + " Mesmo sendo um pirata.", new ArrayList<Choice>());
       
       
       
        Collection escolhas20 = new ArrayList<Choice>();
        Choice escolhaPirata20 = new BlankChoice("Matar todos.", eventoPirata20);
        Choice escolhaPirata21 = new BlankChoice("Pedir resgate.", eventoPirata21);
        escolhas20.add(escolhaPirata20);
        escolhas20.add(escolhaPirata21);
       
        Event eventoPirata18 = new BlankEvent("O seu navio tomou uma boa distância e a marinha nunca o alcançou."
                + " Você e os outros marujos viveram o resto da vida como reis com "
                + " todo o saque que obtiveram da marinha.", new ArrayList<Choice>());
       
        Event eventoPirata19 = new BlankEvent("Você captura todos do navio."
                + " Você tem a opção de sequestrá-los e pedir resgate ou"
                + " matar todos.", escolhas20);
   
       
        Collection escolhas19 = new ArrayList<Choice>();
        Choice escolhaPirata18 = new BlankChoice("Você os ignora e segue viagem.", eventoPirata18);
        Choice escolhaPirata19 = new BlankChoice("Dá a volta e os ataca novamente.", eventoPirata19);
        escolhas19.add(escolhaPirata18);
        escolhas19.add(escolhaPirata19);
       
        Event eventoPirata16 = new BlankEvent("Você atracou na ilha, mas a marinha o seguiu."
                + " Eles levam todos  vocês em custódia e recuperam todo o saque."
                + " Você será executado em praça pública pelos seus crimes.", new ArrayList<Choice>());
       
        Event eventoPirata17 = new BlankEvent("Você mostra aos ventos quem é que manda e segue viagem."
                + " Logo    adiante você percebe que aquele mesmo navio da marinha está te  seguindo. "
                + "O que você faz?", escolhas19);
       
       
       
        Collection escolhas18 = new ArrayList<Choice>();
        Choice escolhaPirata16 = new BlankChoice("Aceitar os ventos e atracar.", eventoPirata16);
        Choice escolhaPirata17 = new BlankChoice("Mudar o vento e continuar viagem.", eventoPirata17);
        escolhas18.add(escolhaPirata16);
        escolhas18.add(escolhaPirata17);
       
        Event eventoPirata14 = new BlankEvent("Você incapacita o Almirante, saqueia totalmente o navio e foge  com sucesso."
                + " Os ventos te levam em direção à uma pequena ilha.  Deseja atracar nela?", escolhas18);
       
        Event eventoPirata15 = new BlankEvent("O Almirante se aproveitou e atirou em você.", new ArrayList<Choice>());
       
       
       
        Collection escolhas17 = new ArrayList<Choice>();
        Choice escolhaPirata14 = new BlankChoice("Você atira.", eventoPirata14);
        Choice escolhaPirata15 = new BattleChoice("Você o ignora.", eventoPirata15, new Enemy(20,20));
        escolhas17.add(escolhaPirata14);
        escolhas17.add(escolhaPirata15);
       
        Event eventoPirata12 = new BlankEvent("Você invade o navio com sua tripulação e encontra o Almirante do navio conversando com alguém."
                + " Você tem a oportunidade de atirar nele, porém se você ignorá-lo as chances são grandes dele perceber a invasão"
                + " e te assassinar.", escolhas17);
       
        Event eventoPirata13 = new BlankEvent("Você ignora o navio."
                + " Eles percebem essa brecha e invadem o navio."
                + " Você e todos os outros marujos passarão a vida na cadeia.", new ArrayList<Choice>());
       
       
       
        Collection escolhas16 = new ArrayList<Choice>();
        Choice escolhaPirata12 = new BlankChoice("Atacar.", eventoPirata12);
        Choice escolhaPirata13 = new BlankChoice("Ignorar.", eventoPirata13);
        escolhas16.add(escolhaPirata12);
        escolhas16.add(escolhaPirata13);
       
        Event eventoPirata10 = new BlankEvent("Você luta contra os outros marujos mostrando que é o melhor do  navio."
                + " Eles concordam em te deixar ser o capitão."
                + " Logo após se  tornar capitão você avista um navio da marinha."
                + " Você pode       ignorá-lo ou atacá-lo.", escolhas16);
       
        Event eventoPirata11 = new BlankEvent("Um marujo qualquer vira capitão."
                + " Em pouco tempo todos ficam insatisfeitos e ocorre outro motim."
                + " Você fica preso nesse ciclo até que não sobrou mais ninguém"
                + " para ser capitão do navio e ele se  tornou um navio fantasma.", new ArrayList<Choice>());
       
       
       
        Collection escolhas15 = new ArrayList<Choice>();
        Choice escolhaPirata10 = new BattleChoice("Se voluntariar para ser o capitão.", eventoPirata10, new Enemy(1,1));
        Choice escolhaPirata11 = new BlankChoice("Deixar qualquer um ser o capitão.", eventoPirata11);
        escolhas15.add(escolhaPirata10);
        escolhas15.add(escolhaPirata11);
       
        Event eventoPirata8 = new BlankEvent("Você se recusa a participar."
                + " Os marujos sugerem então que você  saia do navio."
                + " Você sai do navio e tenta um se alistar na mari- nha. "
                + " Porém descobrem que você foi um pirata e você passa o res-to da vida na cadeia.", new ArrayList<Choice>());
       
        Event eventoPirata9 = new BlankEvent("Você participou do motim e despos o Capitão."
                + " Agora o navio está sem Capitão e um novo é necessário.", escolhas15);
       
       
       
        Collection escolhas14 = new ArrayList<Choice>();
        Choice escolhaPirata8 = new BlankChoice("Não participar.", eventoPirata8);
        Choice escolhaPirata9 = new BlankChoice("Participar.", eventoPirata9);
        escolhas14.add(escolhaPirata8);
        escolhas14.add(escolhaPirata9);
       
        Event eventoPirata6 = new BlankEvent("Eles falam sobre um motim."
                + " Um plano para tirar o antigo capitão do poder."
                + " Eles querem que você participe.", escolhas14);
       
        Event eventoPirata7 = new BlankEvent("Você ignora eles."
                + "Pouco tempo depois ocorre um motim e eles      sequestram o navio e entregam"
                + " você e o capitão às autoridades.", new ArrayList<Choice>());
       
       
       
        Collection escolhas13 = new ArrayList<Choice>();
        Choice escolhaPirata6 = new BlankChoice("Ouvir o que eles tem a dizer.", eventoPirata6);
        Choice escolhaPirata7 = new BlankChoice("Não ouvir.", eventoPirata7);
        escolhas13.add(escolhaPirata6);
        escolhas13.add(escolhaPirata7);
       
        Event eventoPirata4 = new BlankEvent("Você foi pegar a cerveja. Os outros parecem estar começando a   gostar de você."
                + " Eles te chamam para conversar sobre algo.", escolhas13);
       
        Event eventoPirata5 = new BlankEvent("Os marujos ficam irritados coma resposta e te jogam no mar."
                + " Você é atacado por um tubarão e morre.", new ArrayList<Choice>());
       
       
       
        Collection escolhas12 = new ArrayList<Choice>();
        Choice escolhaPirata4 = new BlankChoice("Ir buscar a cerveja.", eventoPirata4);
        Choice escolhaPirata5 = new BlankChoice("Mandar eles mesmos pegarem.", eventoPirata5);
        escolhas12.add(escolhaPirata4);
        escolhas12.add(escolhaPirata5);
       
        Event eventoPirata2 = new BlankEvent("Você desobedeçeu o capitão."
                + " Ele puxou uma pistola e atirou em   você."
                + " Você morreu.", new ArrayList<Choice>());
       
        Event eventoPirata3 = new BlankEvent("Você limpou o chão."
                + " O capitão riu e disse que você não fez mais do que a sua obrigação."
                + " Os outros marujos estão querendo que vo-cê busque mais cerveja.", escolhas12);
       
       
       
        Collection escolhas11 = new ArrayList<Choice>();
        Choice escolhaPirata2 = new BlankChoice("Se recusar.", eventoPirata2);
        Choice escolhaPirata3 = new BlankChoice("Limpar.", eventoPirata3);
        escolhas11.add(escolhaPirata2);
        escolhas11.add(escolhaPirata3);
       
        Event eventoMarinha18 = new BlankEvent("Sua busca por vingança finalmente acabou."
                + " O Almirante foi vinga-do."
                + " Você se tornou o Almirante mais renomado de toda a marinha"
                + " e será lembrado como o Almirante que matou o pirata Alma Negra.", new ArrayList<Choice>());
       
        Event eventoMarinha19 = new BlankEvent("Você levou ele para o interrogatório."
                + " Ao interrogá-lo você des- cobriu onde todos os seus saques estavam."
                + " Recuperando mais de 2 bilhões perdidos em roubos."
                + " Seu ato de nobreza mostrou que nem  sempre matar é a melhor opção.", new ArrayList<Choice>());
       
       
       
        Collection escolhas10 = new ArrayList<Choice>();
        Choice escolhaMarinha18 = new BlankChoice("Matar o Capitão.", eventoMarinha18);
        Choice escolhaMarinha19 = new BlankChoice("Levar em custódia.", eventoMarinha19);
        escolhas10.add(escolhaMarinha18);
        escolhas10.add(escolhaMarinha19);
       
        Event eventoMarinha16 = new BlankEvent("Eles te avistaram e atiaram na direção do seu navio o naufragan-do-o."
                + " Todos morreram com o ataque.", new ArrayList<Choice>());
       
        Event eventoMarinha17 = new BlankEvent("Você ataca todos e chega no capitão do Navio. Você o confronta  diretamente."
                + " Você pode capturar ele e o levar para interrogató- rio"
                + " ou pode matá-lo e vingar a morte do Almirante.", escolhas10);
       
       
        Collection escolhas9 = new ArrayList<Choice>();
        Choice escolhaMarinha16 = new BlankChoice("Fazer emboscada.", eventoMarinha16);
        Choice escolhaMarinha17 = new BattleChoice("Atacar diretamente.", eventoMarinha17, new Enemy(1,1));
        escolhas9.add(escolhaMarinha16);
        escolhas9.add(escolhaMarinha17);
       
        Event eventoMarinha14 = new BlankEvent("Você decidiu seguir os piratas."
                + " Você os segue até eles atracarem em uma ilha. Você pode atacar diretamente"
                + " ou fazer uma embosca-da.", escolhas9);
       
        Event eventoMarinha15 = new BlankEvent("Você manteve o navio em ordem e foi um excelente almirante"
                + " por  muitos anos. Até que você decidiu se aposentar e viver uma"
                + " vida tranquila no campo.", new ArrayList<Choice>());
       
       
       
        Collection escolhas8 = new ArrayList<Choice>();
        Choice escolhaMarinha14 = new BlankChoice("Seguir os piratas.", eventoMarinha14);
        Choice escolhaMarinha15 = new BlankChoice("Continuar com a rotina do navio.", eventoMarinha15);
        escolhas8.add(escolhaMarinha14);
        escolhas8.add(escolhaMarinha15);
       
       
        Event eventoMarinha12 = new BlankEvent("Você recusa o cargo e outro almirante assume o cargo."
                + " Ele não   gosta de você e utiliza do seu poder para te tirar da marinha."
                + "  Você agora não consegue mais emprego na marinha.", new ArrayList<Choice>());
       
        Event eventoMarinha13 = new BlankEvent("Você se tornou o novo Almirante."
                + " Você observa que o navio dos   piratas não está muito distante.", escolhas8);
       
       
       
        Collection escolhas7 = new ArrayList<Choice>();
        Choice escolhaMarinha12 = new BlankChoice("Recusar.", eventoMarinha12);
        Choice escolhaMarinha13 = new BlankChoice("Aceitar.", eventoMarinha13);
        escolhas7.add(escolhaMarinha12);
        escolhas7.add(escolhaMarinha13);
       
        Event eventoMarinha10 = new BlankEvent("Você defendeu o navio contra o ataque, fazendo os piratas recua-rem."
                + " Porém o Almirante ficou debilitado, o impedindo de manter o cargo."
                + " Ao observar suas habilidades os outros marinheiros pedem para que você"
                + " assuma o lugar do Almirante.", escolhas7);
       
        Event eventoMarinha11 = new BlankEvent("Você se escondeu até que um pirata te achou e atirou em você.", new ArrayList<Choice>());
       
       
       
        Collection escolhas6 = new ArrayList<Choice>();
        Choice escolhaMarinha10 = new BattleChoice("Lutar.", eventoMarinha10, new Enemy(1,1));
        Choice escolhaMarinha11 = new BattleChoice("Se esconder. Grandes chances de um inimigo te achar.", eventoMarinha11, new Enemy(20,20));
        escolhas6.add(escolhaMarinha10);
        escolhas6.add(escolhaMarinha11);
       
        Event eventoMarinha8 = new BlankEvent("O Almirante explica suas funções."
                + " No meio da conversa o Navio é atacado por piratas."
                + " O Almirante é atingido e fica debilitado.", escolhas6);
       
        Event eventoMarinha9 = new BlankEvent("Você recusou, então você executou seu cargo muito mal e foi des-pachado da marinha."
                + " Você agora é um pescador que  vive do que    consegue fisgar.", new ArrayList<Choice>());
       
       
       
        Collection escolhas5 = new ArrayList<Choice>();
        Choice escolhaMarinha8 = new BlankChoice("Ir conversar com o Almirante.", eventoMarinha8);
        Choice escolhaMarinha9 = new BlankChoice("Não ir conversar com o Almirante.", eventoMarinha9);
        escolhas5.add(escolhaMarinha8);
        escolhas5.add(escolhaMarinha9);
       
        Event eventoMarinha6 = new BlankEvent("O Almirante ficou feliz com sua escolha."
                + "Você foi promovido à suboficial."
                + " O Almirante te chama na sala dele para te explicar suas novas funções.", escolhas5);
       
        Event eventoMarinha7 = new BlankEvent("O Almirante fica chateado, mas entende."
                + "Você serve a marinha até que você sofre um acidente no convés"
                + " e fica debilitado. Você fi-ca incapaz de continuar na marinha para sempre.", new ArrayList<Choice>());
       
       
       
        Collection escolhas4 = new ArrayList<Choice>();
        Choice escolhaMarinha6 = new BlankChoice("Aceitar o cargo.", eventoMarinha6);
        Choice escolhaMarinha7 = new BlankChoice("Recusar o cargo.", eventoMarinha7);
        escolhas4.add(escolhaMarinha6);
        escolhas4.add(escolhaMarinha7);
       
        Event eventoMarinha4 = new BlankEvent("O Almirante te diz que gostou da sua determinação e te ofereceu um cargo melhor.", escolhas4);
       
        Event eventoMarinha5 = new BlankEvent("Você manteve o seu cargo por 30 anos até se aposentar e viver   uma vida "
                + "medíocre com o dinheiro que você guardou.", new ArrayList<Choice>());
       
       
       
        Collection escolhas3 = new ArrayList<Choice>();
        Choice escolhaMarinha4 = new BlankChoice("Conversar.", eventoMarinha4);
        Choice escolhaMarinha5 = new BlankChoice("Não conversar.", eventoMarinha5);
        escolhas3.add(escolhaMarinha4);
        escolhas3.add(escolhaMarinha5);
             
       
        Event eventoMarinha3 = new BlankEvent("Você não esfregou o chão. Por desacatar a ordem de um superior  no primeiro dia,"
                + " você foi despachado da marinha e viveu uma vida triste longe do mar.", new ArrayList<Choice>());
       
        Event eventoMarinha2 = new BlankEvent("Você limpou o chão. O Almirante viu a sua dedicação e o chamou  para conversar.", escolhas3);
       
        Collection escolhas2 = new ArrayList<Choice>();
        Choice escolhaMarinha3 = new BlankChoice("Não limpar o convés.", eventoMarinha3);
        Choice escolhaMarinha2 = new BlankChoice("Limpar o convés.", eventoMarinha2);
        escolhas2.add(escolhaMarinha2);
        escolhas2.add(escolhaMarinha3);
       
        Event eventoPirata1 = new BlankEvent("Você entrou para um grupo de piratas."
                + " O Capitão mandou você     esfregar o chão.", escolhas11);
       
        Event eventoMarinha1 = new BlankEvent("Você se alistou na marinha.O Almirante mandou você esfregar o   convés.", escolhas2);
       
        Collection escolhasIniciais = new ArrayList<Choice>();
        Choice escolhaMarinha1 = new BlankChoice("Alistar na marinha", eventoMarinha1);
        Choice escolhaPirata1 = new BlankChoice("Conversar com o homem", eventoPirata1);
        escolhasIniciais.add(escolhaMarinha1);
        escolhasIniciais.add(escolhaPirata1);
 
        Event eventoInitial = new BlankEvent("Você sempre gostou do mar. " +
                "Sempre quis estar a bordo de um navi-o. " +
                "Você vê um homem da marinha recrutando e um outro homem um   pouco distante, dizendo que precisa de uma tripulação.", escolhasIniciais);
 
        Book livro = new Book("Piranha", eventoInitial, new Player(10, 10));
 
        return livro;
    }
}