import java.util.*;

public class Transporte {
    private Mapa mapa;
    Scanner sc = new Scanner(System.in);
    public boolean transporteRealizado;
    MIssaoKingdomKalb missaoKalb = new MIssaoKingdomKalb();
    MissaoDefalsia missaoDefalsia = new MissaoDefalsia();
    MissaoVunese missaoVunese = new MissaoVunese();

    public Transporte (){
        this.mapa = new Mapa();
    }

    public void iniciarTransporte(Personagem maxwell) {
        transporteRealizado = false;
        List<String> cidadesVizinhas = mapa.getVizinhos(maxwell.getCidadeAtual());
            System.out.println(
            "  ___________________________________________\n" +
            " /                                           \\\n" +
            "|       Para qual cidade deseja ir?:         |\n" +
            " \\___________________________________________/\n");
            System.out.println();

        for (int i = 0; i < cidadesVizinhas.size(); i++) {
            System.out.println((i + 1) + ". " + cidadesVizinhas.get(i));
        }

        int opcao = sc.nextInt();

        if (opcao >= 1 && opcao <= cidadesVizinhas.size()) {
            String cidadeDestino = cidadesVizinhas.get(opcao - 1);
            realizarTransporte(cidadeDestino, maxwell);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            iniciarTransporte(maxwell);
        }
    }

    public void realizarTransporte(String cidadeDestino, Personagem maxwell) {
        if (maxwell.checaStatusPersonagem() && maxwell.getMoedas()>1) {
            maxwell.setCidadeAtual(cidadeDestino);
            maxwell.setMoedas(maxwell.getMoedas()-1);
            transporteRealizado = true;
            atualizaBens(cidadeDestino, maxwell);
            fazDesenho();
            exibeDialogo(maxwell);
        } else if (maxwell.getMoedas() == 1){
            System.out.println(
            "  ________________________________________________________________ \n" +
            " /                                                                \\ \n" +
            "|       Moedas insuficientes. Maxwell tem apenas uma moeda,       |\n" +
            "|                ele morrerá se realizar a viagem.                |\n" +
            "|                                                                 |\n" +
            "|             Deseja falar novamente com o mercador               |\n" +
            "|                  ou continuar o transporte?                     |\n" +
            "|                                                                 |\n" +
            " \\________________________________________________________________/\n" +
            "       |                                                          |\n" +
            "       |   1. Falar com o mercador                               |\n" +
            "       |   2. Ignorar e continuar o transporte                   |\n" +
            "       |__________________________________________________________|\n"
            );


            int opcao = sc.nextInt();

            switch(opcao) {
                case 1:
                    exibeDialogo(maxwell);
                    break;
                case 2:
                    maxwell.setCidadeAtual(cidadeDestino);
                    maxwell.setMoedas(maxwell.getMoedas()-1);
                    transporteRealizado = true;
                    atualizaBens(cidadeDestino, maxwell);
                    fazDesenho();
                    break;
            }
        }
    }

    public void atualizaBens(String cidadeDestino, Personagem maxwell) {

        switch (cidadeDestino) {
            case "Ubud":
                maxwell.setPoderJoia(0);
                missaoDefalsia.finalizarMissao(maxwell);
                break;
            case "Kingdom Of Legmod":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 2);
                break;
            case "Principality Of Nekikh":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 1);
                break;
            case "Principality Of Gritestar":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 5);
                break;
            case "Protectorate Of Dogrove":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 3);
                break;
            case "Kingdom Of Lastwatch":
                maxwell.setPoderJoia(maxwell.getPoderJoia() - 2);
                break;
            case "GrandDuchy Of Smalia":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 1);
                missaoKalb.finalizarMissao(maxwell);
                break;
            case "Kingdom Of Oldcalia":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 4);
                break;
            case "Kingdom Of Kalb":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 2);
                missaoKalb.oferecerMissao(maxwell);
                break;
            case "Aymar League":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 1);
                break;
            case "Defalsia":
                maxwell.setPoderJoia(maxwell.getPoderJoia() - 3);
                missaoDefalsia.oferecerMissao(maxwell);
                break;
            case "Vunese Empire":
                maxwell.setPoderJoia(maxwell.getPoderJoia());
                missaoVunese.oferecerMissao(maxwell);
                break;
            case "Principality Of Karhora":
                maxwell.setPoderJoia(maxwell.getPoderJoia() - 2);
                break;
            case "Chandir Sultanate":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 1);
                break;
            case "Bun":
                maxwell.setPoderJoia(maxwell.getPoderJoia() + 5);
                break;
            case "Principality Of Kasya":
                maxwell.setPoderJoia(maxwell.getPoderJoia() - 7);
                missaoDefalsia.finalizarMissao(maxwell);
                break;
            case "Nargumun":
                maxwell.setPoderJoia(maxwell.getPoderJoia());
                break;
        }
    }

    public void exibeDialogo(Personagem maxwell) {
        System.out.println();
        System.out.println("Maxwell chegou em uma nova cidade...");
        System.out.println("Cidade: " + maxwell.getCidadeAtual());
        System.out.println();
        int moedas = 0;
        System.out.println("MERCADOR:");
        System.out.println();
        System.out.println("       .-\"\"-.\n" + //
                "      /-.{}  \\\n" + //
                "      | _\\__.|\n" + //
                "      \\/^)^ \\/\n" + //
                "       \\ =  /\n" + //
                "  .---./`--`\\.--._\n" + //
                " /     `;--'`     \\\n" + //
                ";        /`       ;\n" + //
                "|       |*        |\n" + //
                "/   |   |     |    \\\n" + //
                "|    \\  |*    /    |\n" + //
                "\\_   |\\_|____/|  __/\n" + //
                "  \\__//======\\\\__/\n" + //
                "  / //_      _\\\\ \\\n" + //
                "  -'  |`\"\"\"\"`|  `-\n" + //
                "      |  L   |\n" + //
                "      >_ || _<\n" + //
                "      |  ||  |\n" + //
                "      |  ||  |\n" + //
                "     /   ||   \\\n" + //
                "    /    /,    \\\n" + //
                "     `|\"|`\"|\"|\"`\n" + //
                "     /  )  /  )  \n" + //
                "    /__/  /__/");
                System.out.println();
        System.out.println(
        "  ________________________________________________________________ \n" +
        " /                                                                \\ \n" +
        "|    Olá viajante! Tenho algumas perguntas para você!              |\n" +
        "|    Quantas moedas de transporte você tem?                        |\n" +
        " \\________________________________________________________________/\n" +
        "       |                                                          |\n" +
        "       |   1. Mentir para o mercador                              |\n" +
        "       |   2. Falar a verdade                                     |\n" +
        "       |__________________________________________________________|\n"
        );

        int escolha1 = sc.nextInt();

        if (escolha1 == 1) {
            System.out.println(
            "  ___________________________________________\n" +
            " /                                           \\\n" +
            "|       Digite a quantidade de moedas:       |\n" +
            " \\___________________________________________/\n");
            System.out.println();
            moedas = sc.nextInt();
        } else if (escolha1 == 2) {
            moedas = maxwell.getMoedas();
            System.out.println(
            "  ___________________________________________\n" +
            " /                                           \\\n" +
            "|         Eu tenho " + moedas + " moedas.                 \n" +
            " \\___________________________________________/\n");
            System.out.println();
        }
        else {
            System.out.println("Opção inválida");
            exibeDialogo(maxwell);
        }

        System.out.println(
        "  ________________________________________________________________ \n" +
        " /                                                                \\ \n" +
        "|    Interessante! De onde você vem?                               |\n" +
        " \\________________________________________________________________/\n" +
        "       |                                                          |\n" +
        "       |   Digite a sua escolha e pressione Enter:                |\n" +
        "       |__________________________________________________________|\n"
        );

        System.out.println();
        System.out.println();
        List<String> cidades = mapa.getCidades();

        for (int i = 0; i < cidades.size(); i++) {
            String cidade = cidades.get(i);
            System.out.println((i + 1) + ". " + cidade);
        }

        int escolha2 = sc.nextInt();
        if (escolha2 > 17) {
            System.out.println("Opção inválida.");
            exibeDialogo(maxwell);
        } else {
            aguardar(500);
            limparTela();
            String cidadeOrigem = cidades.get(escolha2 - 1);

            System.out.println();
            System.out.println(
                "  ___________________________________________\n" +
                " /                                           \\\n" +
                "|         Eu venho de " + cidadeOrigem + "     \n" +
                " \\___________________________________________/\n");
            System.out.println();

            System.out.println(
            "  ________________________________________________________________ \n" +
            " /                                                                \\ \n" +
            "|    Para onde você vai?                                           |\n" +
            " \\________________________________________________________________/\n" +
            "       |                                                          |\n" +
            "       |   Digite a sua escolha e pressione Enter:                |\n" +
            "       |__________________________________________________________|\n"
            );

        for (int i = 0; i < cidades.size(); i++) {
            String cidade = cidades.get(i);
            System.out.println((i + 1) + ". " + cidade);
        }

        int escolha3 = sc.nextInt();

        if (escolha3 > 17) {
            System.out.println("Opção inválida.");
            exibeDialogo(maxwell);
        }
        else {
            aguardar(500);
            limparTela();
            String cidadeDestino = cidades.get(escolha3 - 1);
            System.out.println();
            System.out.println(
                "  ___________________________________________\n" +
                " /                                           \\\n" +
                "|         Eu vou para " + cidadeDestino + "           \n" +
                " \\___________________________________________/\n");
            System.out.println();


            int distancia = mapa.calcularDistancia(cidadeOrigem, cidadeDestino);
            System.out.println();
            System.out.println();
            aguardar(500);
            limparTela();
            System.out.println(
            "  ________________________________________________________________ \n" +
            " /                                                                \\ \n" +
            "|                Última pergunta, viajante...                     |\n" +
            "|                                                                 |\n" +
            "|    Deseja trocar suas moedas por limiar na jóia?                |\n" +
            "|                                                                 |\n" +
            " \\________________________________________________________________/\n" +
            "       |                                                          |\n" +
            "       |   Moedas: " + maxwell.getMoedas() + "                                              |\n" +
            "       |   Poder da jóia: " + maxwell.getPoderJoia() + "                                       |\n" +
            "       |   Limiar da jóia: " + maxwell.getLimiarJoia() + "                                      |\n" +
            "       |__________________________________________________________|\n" +
            "       |                                                          |\n" +
            "       |   1. Sim, quero trocar                                   |\n" +
            "       |   2. Não, não quero trocar                               |\n" +
            "       |__________________________________________________________|\n"
            );
            System.out.println();
            System.out.println();

            int escolha4 = sc.nextInt();
            boolean querTrocar = false;

            if (escolha4 == 1) {
                querTrocar = true;
            } else if (escolha4 == 2) {
                querTrocar = false;
            } else {
                System.out.println("Opção inválida");
                exibeDialogo(maxwell);
            }

            DialogoMercador dialogo = new DialogoMercador(maxwell, moedas, distancia, querTrocar);
            dialogo.atualizarBens(maxwell);}}
    }

    public void fazDesenho(){
        int numFrames = 4;

        // Exibe a animação da viagem
        for (int i = 0; i < numFrames; i++) {
            exibirFrameViagem();
            aguardar(1000);
            limparTela();
        }
    }

    public void exibirFrameViagem(){
        System.out.println("Viajando... aguarde!");
        System.out.println();
        System.out.println("   _____                 . . . . . o o o o o\n" + //
                "  __|[_]|__ ___________ _______    ____      o\n" + //
                " |[] [] []| [] [] [] [] [_____(__  ][]]_n_n__][.\n" + //
                "_|________|_[_________]_[________]_|__|________)<\n" + //
                "  oo    oo 'oo      oo ' oo    oo 'oo 0000---oo\\_\n" + //
                " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

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
