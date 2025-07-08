public abstract class Equipamento {

    private String nome;
    private int bonus;

    public Equipamento(String nome, int bonus) {
        this.nome = nome;
        this.bonus = bonus;
    }

    public String getNome() {
        return nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBonus(int bonus) {
        this.bonus = this.bonus;
    }

    public String toString() {
        return "Nome: " + nome + " - Bonus: " + bonus;
    }
}