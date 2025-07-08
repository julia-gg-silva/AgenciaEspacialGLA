import java.util.ArrayList;

public class Gerenciamento {

    private ArrayList<Agente> agentes = new ArrayList<>();
    Agente agente;

    public Agente buscarAgente(String nome) {
        for(Agente agente : agentes){
            if(agente.getNome().contains(nome)){
                return agente;
            }
        }
        return null;
    }

    public void adicionarAgente(String nome, int classe, int nivel, int atributo) {
        if(classe == 1) {
            Piloto piloto = new Piloto(nome, nivel, atributo);
            System.out.println("Agente '" + nome + "' (Piloto) criado com sucesso! Nivel: " + nivel + ", Vida: " + agente.getVidaAtual()+ ", Reflexos: "+ atributo);
            agentes.add(piloto);

        }else if(classe == 2) {
            Engenheiro engenheiro = new Engenheiro(nome, nivel, atributo);
            System.out.println("Agente '" + nome + "' (Engenheiro) criado com sucesso! Nivel: " + nivel + ", Vida: " + agente.getVidaAtual()+ ", Inteligência: "+ atributo);
            agentes.add(engenheiro);

        }else if(classe == 3) {
            Cientista cientista = new Cientista(nome, nivel, atributo);
            System.out.println("Agente '" + nome + "' (Cientista) criado com sucesso! Nivel: " + nivel + ", Vida: " + agente.getVidaAtual()+ ", Criatividade: "+ atributo);
            agentes.add(cientista);
        }
    }

    public ArrayList<Agente> getAgentes() {
        return agentes;
    }

    public void atualizarAgenteGer(int nivel, int vida) {

        agente.setNivel(nivel);
        agente.setVidaAtual(vida);

        System.out.println("Nível de '"+ agente.getNivel()+ "' atualizado para "+ agente.getNivel() + ". Vida máxima ajustada para " + agente.getNivel()*100);
    }
}