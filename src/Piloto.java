public class Piloto extends Agente{

    private int reflexos;

    public Piloto(String nome, int nivel, int reflexos) {
        super(nome, nivel);
        if(reflexos > 0){
            this.reflexos = reflexos;
        }
    }

    @Override
    public int calcularDano() {
        int dano = this.reflexos * this.getNivel();
        return dano;
    }

    @Override
    public String toString() {
        return super.toString() + " - [reflexos=" + reflexos + "]";
    }

    public int getReflexos() {
        return reflexos;
    }
}