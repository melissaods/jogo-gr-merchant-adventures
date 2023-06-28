import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Jogo {
    Mapa mapa = new Mapa();
    Personagem maxwell = new Personagem();
    Transporte transporte = new Transporte();
    Scanner sc = new Scanner(System.in);
    public boolean jogoAtivo;
    public boolean personagemVivo;


    public Jogo() {
        this.jogoAtivo = true;
        iniciar();
    }

    public void exibeMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(
            "  +--------------------------------------------------------------------+\n" +
            "  |                                                                    |\n" +
            "  |                          MENU PRINCIPAL                            |\n" +
            "  |                                                                    |\n" +
            "  +--------------------------------------------------------------------+\n" +
            "  |                                                                    |\n" +
            "  |   1. EXIBIR CIDADES DO MAPA                                        |\n" +
            "  |   2. EXIBIR MAPA                                                   |\n" +
            "  |   3. REALIZAR TRANSPORTE                                           |\n" +
            "  |   4. SAIR DO JOGO                                                  |\n" +
            "  |                                                                    |\n" +
            "  |                                                                    |\n" +
            "  +--------------------------------------------------------------------+\n" +
            "  |                                                                    |\n" +
            "  |   Por favor, escolha uma opção.                                    |\n" +
            "  |                                                                    |\n" +
            "  +--------------------------------------------------------------------+\n" +
            "  |                                                                    |\n" +
            "  |   Moedas atuais: " + maxwell.getMoedas() + "                                                 |\n" +
            "  |   Poder da Joia: " + maxwell.getPoderJoia() + "                                                 |\n" +
            "  |   Limiar da Joia: " + maxwell.getLimiarJoia() + "                                                |\n" +
            "  |                                                                    |\n" +
            "  +--------------------------------------------------------------------+\n");
            System.out.println();
            System.out.println("CIDADE ATUAL: " + maxwell.getCidadeAtual());
        System.out.println();
        System.out.println();
            

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                mapa.printMapa();
                break;
            case 2:
                mapa.printMapa1();;
                break;
            case 3:
                transporte.iniciarTransporte(maxwell);
                break;
            case 4:
                System.out.println("Deseja realmente encerrar o jogo?");
                System.out.println("1. Sim");
                System.out.println("2. Não");
                int opcao2 = sc.nextInt();
                if (opcao2 == 1) {
                    jogoAtivo = false;
                } else if (opcao2 == 2) {
                    System.out.println("Certo, o menu será exibido novamente.");
                    aguardar(3000);
                    exibeMenu();
                }
        }
    }

    public void statusJogo() {
        if (maxwell.getMoedas() == 0) {
            personagemVivo = false;
            personagemMorrePorMoeda();
        }
        else if (maxwell.getPoderJoia() >= maxwell.getLimiarJoia()) {
            personagemVivo = false;
            personagemMorrePorLimiar();
        }
    }

    public void iniciar() {
        while(jogoAtivo) {
            exibeMenu();
            statusJogo();
        }
    }

    public void personagemMorrePorMoeda() {
        System.out.println(
        "  ________________________________________________________________ \n" +
        " /                                                                \\ \n" +
        "|              Maxwell ficou sem moedas e faleceu,                |\n" +
        "|                         uma pena!                               |\n" +
        "|                                                                 |\n" +
        "|              Deseja recomeçar o jogo?                           |\n" +
        "|                                                                 |\n" +
        " \\________________________________________________________________/\n" +
        "       |                                                          |\n" +
        "       |   1. Sim, quero tentar novamente.                        |\n" +
        "       |   2. Não.                                                |\n" +
        "       |__________________________________________________________|\n"
        );


        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                jogoAtivo = false;
                personagemVivo = false;
                Jogo jogoNovo = new Jogo();
                jogoNovo.iniciar();
                break;
            case 2:
                jogoAtivo = false;
                personagemVivo = false;
                System.out.println("Tchau jogador!");
                break;
        }
    }
    public void personagemMorrePorLimiar() {
        System.out.println(
        "  ________________________________________________________________ \n" +
        " /                                                                \\ \n" +
        "|       A jóia ficou muito poderosa e Maxwell não resistiu,       |\n" +
        "|                         uma pena!                               |\n" +
        "|                                                                |\n" +
        "|              Deseja recomeçar o jogo?                           |\n" +
        "|                                                                |\n" +
        " \\________________________________________________________________/\n" +
        "       |                                                          |\n" +
        "       |   1. Sim, quero tentar novamente.                        |\n" +
        "       |   2. Não.                                                |\n" +
        "       |__________________________________________________________|\n"
        );


        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                jogoAtivo = false;
                personagemVivo = false;
                Jogo jogoNovo = new Jogo();
                jogoNovo.iniciar();
                break;
            case 2:
                jogoAtivo = false;
                personagemVivo = false;
                System.out.println("Tchau jogador!");
                break;
        }
    }

    private static void aguardar(int segundos) {
        try {
            Thread.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
