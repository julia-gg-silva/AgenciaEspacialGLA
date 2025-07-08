public class Cientista extends Agente{

    int criatividade;

    public Cientista(String nome, int nivel, int criatividade) {
        super(nome, nivel);
        this.criatividade = criatividade;
    }

    @Override
    public int calcularDano() {
        int dano = this.criatividade + this.getNivel() + 5;
        return dano;
    }

    @Override
    public String toString() {
        return super.toString() + " - [criatividade=" + criatividade + "]";
    }
}