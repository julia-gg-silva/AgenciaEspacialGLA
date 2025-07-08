public class Engenheiro extends Agente{

    private int inteligencia;

    public Engenheiro(String nome, int nivel, int inteligencia) {
        super(nome, nivel);
        if(inteligencia < 0) {
            this.inteligencia = inteligencia;
        }
    }

    @Override
    public int calcularDano() {
        int dano = inteligencia * this.getNivel() + 10;
        return dano;
    }

    @Override
    public String toString() {
        return super.toString() + " - [inteligencia=" + inteligencia + "]";
    }
}