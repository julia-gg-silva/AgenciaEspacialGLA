
import java.util.ArrayList;

public abstract class Agente {

    private String nome;
    private String classe;
    private int nivel;
    private int vidaAtual;
    private int vidaMaxima;
    int experiencia;
    private boolean status;
    private ArrayList<Equipamento> inventario;

    public Agente(String nome,  int nivel){
        this.nome = nome;
        this.nivel = nivel;
        this.vidaAtual = nivel * 100;
        this.vidaMaxima = nivel * 100;
        this.experiencia = 0;
        this.status = true;

    }

    public abstract int calcularDano();

    public void receberDano(int dano){
        this.vidaAtual -= dano;
        if(vidaAtual <= 0){
            this.status = false;
        }
    }

    public void ganharExperiencia(int XP){
        this.experiencia += XP;
        if(this.experiencia >= 100){
            this.experiencia -= 100;
            this.nivel ++;
            this.vidaMaxima = this.nivel * 100;
            this.vidaAtual = this.vidaMaxima;
        }
    }

    public void adicionarEquipamento(Equipamento equipamento){
        inventario.add(equipamento);
        System.out.println("Equipamento '" + equipamento + "' adicionado ao inventário com sucesso!");
    }

    public void listarInventario(){
        System.out.println("--- Inventário ---");
        for(Equipamento equipamento : inventario){
            System.out.println(equipamento);
        }
    }

    public String toString(){
        return "Nome: " + this.nome + "- Classe: " + this.classe +
                " - Nível: " + this.nivel + " - Vida Atual: " + this.vidaAtual +
                " - Experiência: " + this.experiencia;

    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public boolean getStatus() {
        return status;
    }

    public void setVidaAtual(int vidaAtual) {
        int i = this.vidaAtual + vidaAtual;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Equipamento> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Equipamento> inventario) {
        this.inventario = inventario;
    }
}
