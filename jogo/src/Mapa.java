import java.util.*;

public class Mapa {
    private Map<String, List<String>> vizinhanca;

    public Mapa() {
        vizinhanca = new HashMap<>();
        popularMapa();
    }

    public void addCidade(String cidade) {
        vizinhanca.put(cidade, new ArrayList<>());
    }

    public void addVizinho(String cidade, String vizinho){
        List<String> vizinhos = vizinhanca.get(cidade);
        //Se Aymar League é vizinha de Bun, Bun é vizinha de Aymar League
        vizinhos.add(vizinho);
    }

    public int calcularDistancia(String cidadeOrigem, String cidadeDestino) {
        if (!vizinhanca.containsKey(cidadeOrigem) || !vizinhanca.containsKey(cidadeDestino)) {
            // Verificar se as cidades existem no mapa
            return -1;
        }

        if (cidadeOrigem.equals(cidadeDestino)) {
            System.out.println("As cidades são iguais, a distância é zero.");
            return 0;
        }

        Set<String> visitadas = new HashSet<>();
        Queue<String> fila = new LinkedList<>();
        Map<String, Integer> distancia = new HashMap<>();

        fila.offer(cidadeOrigem);
        distancia.put(cidadeOrigem, 0);

        while (!fila.isEmpty()) {
            String cidadeAtual = fila.poll();
            visitadas.add(cidadeAtual);

            List<String> vizinhas = vizinhanca.get(cidadeAtual);

            for (String vizinha : vizinhas) {
                if (!visitadas.contains(vizinha)) {
                    fila.offer(vizinha);
                    distancia.put(vizinha, distancia.get(cidadeAtual) + 1);

                    if (vizinha.equals(cidadeDestino)) {
                        return distancia.get(vizinha);
                    }
                }
            }
        }
        return -1;
    }

    public List<String> getVizinhos(String cidade) {
        return vizinhanca.get(cidade);
    }

    public List<String> getCidades() {
        List<String> cidades = new ArrayList<>();
        for (String cidade : vizinhanca.keySet()) {
            cidades.add(cidade);
        }
        return cidades;
    }

    public void printMapa1() {
        System.out.println();
        System.out.println();
        System.out.println(
    "GrandDuchy Of Smalia (+1)  ______________________\n" +
    "                    \\                            \\\n" +
    "                     \\                            |\n" +
    "    ________  Kingdom Of Oldcalia (+4)            |\n" +
    "  / /                    |     \\                  |\n" +
    " |  |                    |      \\                 |\n" +
    " |  |                    |       \\                |\n" +
    " |  |                    |        \\               |\n" +
    " |\\_|__ Kingdom Of Lastwatch (-2)   Defalsia  ____|_____\n" +
    " |  |                   \\    \\                    |     \\\n" +
    " |  |                    \\    \\___________________/     |\n" +
    " |  |                     \\                        \\    | \n" +
    " |  |\\________________ Protectorate Of Dogrove (+3) \\   |\n" +
    " |  |                   /        |                   |  | \n" +
    " |  \\__ Kingdom Of Legmod (+2)   |                   |  |  \n" +
    " |   _____|    \\                /                    |  |     \n" +
    " |  | |         \\              /                     |  |     \n" +
    " |  | |          \\            /                      |  |        \n" +
    " |  | |           \\          /                       |  |         \n" +
    " |  | |            \\        /                        |  |          \n" +
    " |  | |    Principality Of Gritestar (+5) __________ /  |  \n" +
    " |  | |       |                                         |        \n" +
    " |  | |       |            Principality Of Karhora (-2)_|________ \n" +
    " |  | |       |                     |                   |        \\\n" +
    " |  | |       |                     |                   |        |\n" +
    " |  | \\       |                     |                   |        |\n" +
    " |  | Principality Of Nekikh (+1)   |                   |        |\n" +
    " |  |         \\                     |                   |        |\n" +
    " |  |          \\                    |                   |        |\n" +
    " |  \\_____  Ubud (0)                /                  /         |\n" +
    " |\\_________________  Aymar League (+1) ______________/          |\n" +
    " |      _______________/ / | |  \\                                |\n" +
    " |     /                /  | |   \\                               |\n" +
    " |    |                /   | |    \\                              |\n" +
    " |    |               /    | |     \\                             /\n" +
    " |    |   Nargumun (0) ____/_|______\\ __________________________/\n" +
    " |    |   /               /  |       \\\n" +
    " |    |  /               /  _|___ Vunese Empire (0)\n" +
    " |    | /               /  | |                  \\\n" +
    " |    |/               /   | |                   |\n" +
    " |   Bun (+5)         /    | |                   |\n" +
    " |     |             /    /   \\                  |\n" +
    " |     |            /    /     |                 |\n" +
    " |  Chandir Sultanate (+1) ____|_________________|__ Principality Of Kasya (-7)\n" +
    " |                             |                /\n" +
    " \\___Kingdom Of Kalb (+2)_____/_______________ /"
);
System.out.println();
System.out.println();
System.out.println();
    }

    public void printMapa() {

        System.out.println();
        System.out.println();
        System.out.println("------------------------ MAPA -----------------------------");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("Cidade                     | Variação de limiar da jóia");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("Aymar League               |   +1");
        System.out.println("Bun                        |   +5");
        System.out.println("Chandir Sultanate          |   +1");
        System.out.println();
        System.out.println("-------- MISSÃO AQUI --------------------------------------");
        System.out.println("Defalsia                   |   -3");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("GrandDuchy Of Smalia       |   +1");
        System.out.println();
        System.out.println("-------- MISSÃO AQUI --------------------------------------");
        System.out.println("Kingdom Of Kalb            |   +2");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("Kingdom Of Legmod          |   +2");
        System.out.println("Kingdom Of Lastwatch       |   -2");
        System.out.println("Kingdom Of Oldcalia        |   +4");
        System.out.println("Nargumun                   |    0");
        System.out.println("Principality Of Gritestar  |   +5");
        System.out.println("Principality Of Karhora    |   -2");
        System.out.println("Principality Of Kasya      |   -7");
        System.out.println("Principality Of Nekikh     |   +1");
        System.out.println("Protectorate Of Dogrove    |   +3");
        System.out.println("Ubud                       |    0");
        System.out.println();
        System.out.println("-------- MISSÃO AQUI --------------------------------------");
        System.out.println("Vunese Empire              |    0");
        System.out.println("-----------------------------------------------------------");
        System.out.println();

    }

    public void popularMapa() {
        addCidade("Aymar League");
        addCidade("Bun");
        addCidade("Chandir Sultanate");
        addCidade("Defalsia");
        addCidade("GrandDuchy Of Smalia");
        addCidade("Kingdom Of Kalb");
        addCidade("Kingdom Of Legmod");
        addCidade("Kingdom Of Lastwatch");
        addCidade("Kingdom Of Oldcalia");
        addCidade("Nargumun");
        addCidade("Principality Of Gritestar");
        addCidade("Principality Of Karhora");
        addCidade("Principality Of Kasya");
        addCidade("Principality Of Nekikh");
        addCidade("Protectorate Of Dogrove");
        addCidade("Ubud");
        addCidade("Vunese Empire");

        addVizinho("Aymar League", "Defalsia");
        addVizinho("Aymar League", "Kingdom Of Oldcalia");
        addVizinho("Aymar League", "Kingdom Of Kalb");
        addVizinho("Aymar League", "Vunese Empire");
        addVizinho("Aymar League", "Chandir Sultanate");
        addVizinho("Aymar League", "Bun");
        addVizinho("Aymar League", "Nargumun");
        addVizinho("Aymar League", "Principality Of Karhora");
        addVizinho("Bun", "Nargumun");
        addVizinho("Bun", "Aymar League");
        addVizinho("Bun", "Chandir Sultanate");
        addVizinho("Chandir Sultanate", "Principality Of Kasya");
        addVizinho("Chandir Sultanate", "Bun");
        addVizinho("Chandir Sultanate", "Aymar League");
        addVizinho("Chandir Sultanate", "Vunese Empire");
        addVizinho("Defalsia", "Aymar League");
        addVizinho("Defalsia", "Kingdom Of Oldcalia");
        addVizinho("GrandDuchy Of Smalia", "Kingdom Of Oldcalia");
        addVizinho("GrandDuchy Of Smalia", "Kingdom Of Lastwatch");
        addVizinho("Kingdom Of Kalb", "Kingdom Of Oldcalia");
        addVizinho("Kingdom Of Kalb", "Aymar League");
        addVizinho("Kingdom Of Kalb", "Vunese Empire");
        addVizinho("Kingdom Of Legmod", "Ubud");
        addVizinho("Kingdom Of Legmod", "Kingdom Of Oldcalia");
        addVizinho("Kingdom Of Legmod", "Protectorate Of Dogrove");
        addVizinho("Kingdom Of Legmod", "Principality Of Gritestar");
        addVizinho("Kingdom Of Legmod", "Principality Of Nekikh");
        addVizinho("Kingdom Of Lastwatch", "GrandDuchy Of Smalia");
        addVizinho("Kingdom Of Lastwatch", "Kingdom Of Oldcalia");
        addVizinho("Kingdom Of Lastwatch", "Protectorate Of Dogrove");
        addVizinho("Kingdom Of Lastwatch", "Principality Of Gritestar");
        addVizinho("Kingdom Of Oldcalia", "GrandDuchy Of Smalia");
        addVizinho("Kingdom Of Oldcalia", "Kingdom Of Lastwatch");
        addVizinho("Kingdom Of Oldcalia", "Protectorate Of Dogrove");
        addVizinho("Kingdom Of Oldcalia", "Kingdom Of Legmod");
        addVizinho("Kingdom Of Oldcalia", "Kingdom Of Kalb");
        addVizinho("Kingdom Of Oldcalia", "Aymar League");
        addVizinho("Kingdom Of Oldcalia", "Defalsia");
        addVizinho("Nargumun", "Principality Of Karhora");
        addVizinho("Nargumun", "Aymar League");
        addVizinho("Nargumun", "Bun");
        addVizinho("Principality Of Gritestar", "Kingdom Of Lastwatch");
        addVizinho("Principality Of Gritestar", "Protectorate Of Dogrove");
        addVizinho("Principality Of Gritestar", "Kingdom Of Legmod");
        addVizinho("Principality Of Gritestar", "Principality Of Nekikh");
        addVizinho("Principality Of Karhora", "Aymar League");
        addVizinho("Principality Of Karhora", "Nargumun");
        addVizinho("Principality Of Kasya", "Chandir Sultanate");
        addVizinho("Principality Of Nekikh", "Ubud");
        addVizinho("Principality Of Nekikh", "Kingdom Of Legmod");
        addVizinho("Principality Of Nekikh", "Principality Of Gritestar");
        addVizinho("Protectorate Of Dogrove", "Kingdom Of Lastwatch");
        addVizinho("Protectorate Of Dogrove", "Principality Of Gritestar");
        addVizinho("Protectorate Of Dogrove", "Kingdom Of Legmod");
        addVizinho("Protectorate Of Dogrove", "Kingdom Of Oldcalia");
        addVizinho("Ubud", "Principality Of Nekikh");
        addVizinho("Ubud", "Kingdom Of Legmod");
        addVizinho("Vunese Empire", "Kingdom Of Kalb");
        addVizinho("Vunese Empire", "Aymar League");
        addVizinho("Vunese Empire", "Chandir Sultanate");
    }

    public boolean saoVizinhas(String cidadeAtual, String cidadeDestino, Mapa mapa) {
        List<String> vizinhos = mapa.getVizinhos(cidadeAtual);
        if (vizinhos.contains(cidadeDestino)){
            System.out.println(cidadeAtual + " e " + cidadeDestino + " são cidades vizinhas.");
            return true;
        } else {
            System.out.println(cidadeAtual + " e " + cidadeDestino + " não são cidades vizinhas.");
            return false;
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
