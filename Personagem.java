public class Personagem {
    private int moedas;
    private int poderJoia;
    private int limiarJoia;
    private boolean estaVivo;
    private String cidadeAtual;

    public String getCidadeAtual() {
        return cidadeAtual;
    }

    public void setCidadeAtual(String cidadeAtual) {
        this.cidadeAtual = cidadeAtual;
    }

    public Personagem() {
        this.moedas = 3;
        this.poderJoia = 0;
        this.limiarJoia = 7;
        this.estaVivo = true;
        this.cidadeAtual = "Ubud";
    }

    public boolean checaStatusPersonagem() {
        return estaVivo;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        if (moedas < 0) {
            this.moedas = 0;
            estaVivo = false;
        } else {
            this.moedas = moedas;
        }
    }

    public int getPoderJoia() {
        return poderJoia;
    }

    public void setPoderJoia(int poderJoia) {
        if (poderJoia < 0){
            poderJoia = 0;
        }
        this.poderJoia = poderJoia;
    }

    public int getLimiarJoia() {
        return limiarJoia;
    }

    public void setLimiarJoia(int limiarJoia) {
        this.limiarJoia = limiarJoia;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }
}
