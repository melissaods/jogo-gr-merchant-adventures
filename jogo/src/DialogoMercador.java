public class DialogoMercador {
    public int moedasMaxwell, moedas, distancia, moedasAtual;
    public boolean querTrocar;

    public DialogoMercador(Personagem maxwell, int moedas,int distancia, boolean querTrocar) {
        this.moedas = moedas;
        this.distancia = distancia;
        this.querTrocar = querTrocar;
        this.moedasAtual = 0;
    }

    public void atualizarBens(Personagem maxwell) {
        if (moedas < 5) {
//      Tem menos de 5 moedas
            if (distancia < 3) {
//              Distancia menor que 3
                if (querTrocar) {
//                  Quer trocar
                     System.out.println("Você perdeu uma moeda e ganhou 1 ponto de limiar.");
                     aguardar(3000);
                     limparTela();
                     maxwell.setMoedas(maxwell.getMoedas() - 1);
                     maxwell.setLimiarJoia(maxwell.getLimiarJoia() + 1);
                } else {
//                  Não quer trocar
                    System.out.println("Você perdeu uma moeda.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() - 1);
                }
            } else {
//              Distancia maior que 3
                if (querTrocar) {
//                  Quer trocar
                    System.out.println("Você perdeu uma moeda e ganhou 2 pontos de limiar.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() - 1);
                    maxwell.setLimiarJoia(maxwell.getLimiarJoia() + 2);
                } else {
//                  Não quer trocar
                    System.out.println("Você ganhou duas moedas.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() + 2);
                }
            }
        } else {
//      Tem mais de 5 moedas
            if (distancia < 3) {
//              Distancia menor que 3
                if (querTrocar) {
//                  Quer trocar
                    System.out.println("Você perdeu três moedas e ganhou 2 pontos de limiar.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() - 3);
                    maxwell.setLimiarJoia(maxwell.getLimiarJoia() + 2);
                } else {
//                  Não quer trocar
                    System.out.println("Você perdeu duas moedas.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() - 2);
                }
            } else {
//              Distancio maior que 3
                if (querTrocar) {
//                  Quer trocar
                    System.out.println("Você perdeu uma moeda e ganhou 3 pontos de limiar.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() - 1);
                    maxwell.setLimiarJoia(maxwell.getLimiarJoia() + 3);
                } else {
//                  Nao quer trocar
                    System.out.println("Você perdeu três moedas.");
                    aguardar(3000);
                    limparTela();
                    maxwell.setMoedas(maxwell.getMoedas() - 3);
                }
            }
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
