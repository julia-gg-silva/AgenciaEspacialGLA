import java.util.ArrayList;

public class Missao {
    private int id;
    private String nome;
    private int dificuldade;
    private ArrayList<Agente> participantes;
    private boolean status = true;
    Gerenciamento ger = new Gerenciamento();


    public void adicionaParticipante(int id, String nome) {
        Agente agente = ger.buscarAgente(nome);
        if (agente == null) {
            System.out.println("O Agente '" + agente.getNome() + "' não existe!");

        } else if (!agente.getStatus()) {
            System.out.println("O Agente '" + agente.getNome() + "' está morto!");

        } else if (participantes.contains(agente)) {
            System.out.println("O Agente '" + agente.getNome() + "'já está na lista de participantes!");

        } else {
            participantes.add(agente);
            System.out.println("O Agente '" + agente.getNome() + "' adicionado com sucesso!");
        }
    }


    public void removerParticipante(int id, String nome) {
        Agente agente = ger.buscarAgente(nome);
        if (agente != null) {
            participantes.remove(agente);
            System.out.println("Agente '" + agente.getNome() + "' removido com sucesso!");
        }
    }


    public void iniciarMissao() {
        int minimoParticipantes = this.dificuldade + 1;
        boolean equipamentoTipo = true;

        if (participantes.size() == minimoParticipantes) {
            for (Agente agente : participantes) {
                int nivelAntes = agente.getNivel();

                int dano = agente.calcularDano();

                int nivelDepois = agente.getNivel();

                int XP = this.dificuldade * 50;
                agente.ganharExperiencia(XP);


                Equipamento equipamento;

                if (equipamentoTipo) {
                    equipamento = new KitReparacao("Kit Reparação", 30);

                } else {
                    equipamento = new CanhaoPlasma("Canyon Plasma", 7);
                }

                agente.getInventario().add(equipamento);
                equipamentoTipo = !equipamentoTipo;

                if (equipamento instanceof KitReparacao) {
                    int restaurandoVida = equipamento.getBonus() + agente.getVidaAtual();
                    agente.setVidaAtual(restaurandoVida);
                } else {
                    int aumentaDano = agente.calcularDano() + equipamento.getBonus();
                }

                this.status = false;
            }
        }
    }

}

