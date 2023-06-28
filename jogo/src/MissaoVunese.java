import java.util.Scanner;

public class MissaoVunese {

    private String nome;
    private String descricao;
    boolean statusConcluida;
    private boolean aceitou, finalizou, emAndamento;
    private int premioMoedaAceitar;
    private int premioLimiar;
    private int premioMoedaFinalizar;
    Scanner sc = new Scanner(System.in);

    public MissaoVunese() {
        this.popularMissao();
    }

    public void oferecerMissao(Personagem maxwell) {
        System.out.println("Olá jogador, essa cidade tem uma missão. Deseja aceitar a missão?");
        System.out.println("Ao finalizar essa missão, você ganhará 10 moedas de transporte\r\n"
                + "e o limiar da joia diminuirá em 4 pontos");

        System.out.println("1. Sim");
        System.out.println("2. Não");
        int resposta1 = sc.nextInt();

        if (resposta1 == 1) {
            this.aceitou = true;
            this.emAndamento = true;
            this.finalizou = false;
            atualizarBensAceitarMissao(maxwell);
        } else {
            this.aceitou = false;
            this.emAndamento = false;
            this.finalizou = false;
        }

        if (aceitou) {

            System.out.println("Certo! Boa escolha!");
            System.out.println(this.descricao);
            System.out.println("Aqui estão " + this.premioMoedaAceitar + " para lhe ajudar a realizar a missão." );

            System.out.println("Após aceitar essa missão, este é o seu total de:\n "
                    + " Moedas de transporte:" + maxwell.getMoedas()
                    + "\n Limiar da Joia: " + maxwell.getLimiarJoia() );
            System.out.println("Boa sorte!");
        } else {
            System.out.println("Uma pena! Até mais.");
        }
    }

    public void popularMissao() {
        this.nome = "Missão na cidade Vunese";
        this.descricao = "Vá até Ubud e receba a Glória dos Retornados";
        this.statusConcluida = false;
        this.premioMoedaAceitar = 1;
        this.premioLimiar = 4;
        this.premioMoedaFinalizar = 10;
    }



    public boolean podeRealizarMissao(Personagem maxwell) {
        if (!maxwell.checaStatusPersonagem()) {
            // Verifica se o jogador está vivo
            return false;
        }

        if (!statusConcluida) {
            // Verifica se a missão está pendente
            return false;
        }

        return true; // O jogador pode realizar a missão

    }

    public void finalizarMissao(Personagem maxwell) {
        if (statusConcluida) {
            finalizou = true;
            emAndamento = false;
            atualizarBensFinalizarMissao(maxwell);
            System.out.println("Parabéns por finalizar a missão!");
            System.out.println("Após o término dessa missão, este é o seu total de:\n "
                    + " Moedas de transporte:" + maxwell.getMoedas()
                    + "\n Limiar da Joia: " + maxwell.getLimiarJoia() );
        } else {
            if (aceitou) {

                System.out.println("Você não finalizou a missão.");
            } else {
                return;
            }
        }
    }
    public void atualizarBensAceitarMissao(Personagem maxwell) {
        if(podeRealizarMissao(maxwell) == true ) {
            maxwell.setMoedas(maxwell.getMoedas() +1 );

        }else {
            System.out.println("Você não tem o pré-requisitos necessários para realizar a missão");
        }
    }
    public void atualizarBensFinalizarMissao(Personagem maxwell) {
        if(podeRealizarMissao(maxwell) == true ) {
            maxwell.setMoedas(maxwell.getMoedas() + 10 );
            maxwell.setLimiarJoia(maxwell.getLimiarJoia() - 4);
        }else {
            System.out.println("Você não tem os pré-requisitos necessários para realizar a missão");
        }
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getDescricao() {
        return descricao;
    }



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public boolean isStatusConcluida() {
        return statusConcluida;
    }



    public void setStatusConcluida(boolean statusConcluida) {
        this.statusConcluida = statusConcluida;
    }



    public boolean isAceitou() {
        return aceitou;
    }



    public void setAceitou(boolean aceitou) {
        this.aceitou = aceitou;
    }



    public boolean isFinalizou() {
        return finalizou;
    }



    public void setFinalizou(boolean finalizou) {
        this.finalizou = finalizou;
    }



    public boolean isEmAndamento() {
        return emAndamento;
    }



    public void setEmAndamento(boolean emAndamento) {
        this.emAndamento = emAndamento;
    }



    public int getPremioMoedaAceitar() {
        return premioMoedaAceitar;
    }



    public void setPremioMoedaAceitar(int premioMoedaAceitar) {
        this.premioMoedaAceitar = premioMoedaAceitar;
    }



    public int getPremioLimiar() {
        return premioLimiar;
    }



    public void setPremioLimiar(int premioLimiar) {
        this.premioLimiar = premioLimiar;
    }



    public int getPremioMoedaFinalizar() {
        return premioMoedaFinalizar;
    }



    public void setPremioMoedaFinalizar(int premioMoedaFinalizar) {
        this.premioMoedaFinalizar = premioMoedaFinalizar;
    }



    public Scanner getSc() {
        return sc;
    }



    public void setSc(Scanner sc) {
        this.sc = sc;
    }


}
