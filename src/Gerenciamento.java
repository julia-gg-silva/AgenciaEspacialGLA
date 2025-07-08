import java.util.ArrayList;

public class Gerenciamento {

    private ArrayList<Missao> missoes = new ArrayList<>();
    Missao missao;
    private ArrayList<Agente> agentes = new ArrayList<>();
    Agente agente;

    public ArrayList<Agente> getAgentes() {
        return agentes;
    }

    public Agente buscarAgente(String nome) {
        for (Agente agente : agentes) {
            if (agente.getNome().equalsIgnoreCase(nome)) {
                return agente;
            }
        }
        return null;
    }

    public Missao buscarMissao(String nome) {
        for(Missao missao : missoes) {
            if(missao.getNome().equalsIgnoreCase(nome)){
                return missao;
            }
        }
        return null;
    }

    public Missao buscarMissaoID(int id){
        for(Missao missao : missoes) {
            if(missao.getId() == id){
                return missao;
            }
        }
        return null;
    }

    public void adicionarAgente(String nome, int classe, int nivel, int atributo) {
        if (classe == 1) {
            Piloto piloto = new Piloto(nome, nivel, atributo);
            System.out.println("Agente '" + nome + "' (Piloto) criado com sucesso! Nivel: " + nivel + ", Vida: " + piloto.getVidaAtual() + ", Reflexos: " + atributo);
            agentes.add(piloto);

        } else if (classe == 2) {
            Engenheiro engenheiro = new Engenheiro(nome, nivel, atributo);
            System.out.println("Agente '" + nome + "' (Engenheiro) criado com sucesso! Nivel: " + nivel + ", Vida: " + engenheiro.getVidaAtual() + ", Inteligência: " + atributo);
            agentes.add(engenheiro);


        } else if (classe == 3) {
            Cientista cientista = new Cientista(nome, nivel, atributo);
            System.out.println("Agente '" + nome + "' (Cientista) criado com sucesso! Nivel: " + nivel + ", Vida: " + cientista.getVidaAtual() + ", Criatividade: " + atributo);
            agentes.add(cientista);
        }
    }

    public void atualizarAgenteGer(Agente agente, int nivel, int vida) {

        int nivelAntes = agente.getNivel();

        agente.setNivel(nivel);
        agente.setVidaAtual(vida);

        System.out.println("Nível de '" + nivelAntes+ "' atualizado para " + agente.getNivel() + ". Vida máxima ajustada para " + agente.getNivel() * 100);
    }

    public void removerAgenteGer(String nome) {

        Agente agente = buscarAgente(nome);

        if (agente == null) {
            System.out.println("O Agente não existe! Tente novamente!");
            return;
        } else {
            agentes.remove(agente);
            System.out.println("Agente '" + agente.getNome() + "' removido com sucesso!");

        }
    }

    public void criarMissaoGer(String nome, int dificuldade){
        int contadorId = 0;

        if(buscarMissao(nome) == null){
            contadorId++;

            Missao missao = new Missao(contadorId,nome, dificuldade);

            System.out.println("Missão '" + nome +"' criada com ID " + contadorId + ", Dificuldade: " + dificuldade +
                    (dificuldade == 1 ? "(Fácil)" : dificuldade == 2 ? "(Médio)"
                            : dificuldade==3? "(Dificil)" : ""));
            missoes.add(missao);
        }else{
            System.out.println("Este nome já é utilizado! Tente novamente!");
            return;
        }
    }

    public void atualizarMissaoGer(String nome, int dificuldade) {

        missao.setNome(nome);
        missao.setDificuldade(dificuldade);

        System.out.println("Dificuldade de '" + nome + "' alterada para " + dificuldade +
                (dificuldade == 1 ? "(Fácil)" : dificuldade == 2 ? "(Médio)"
                        : dificuldade==3? "(Dificil)" : ""));

    }

    public void removerMissaoGer(Missao missao){

        missoes.remove(missao);

        System.out.println("Missao '" + missao.getNome() + "' removido com sucesso!");

    }
}