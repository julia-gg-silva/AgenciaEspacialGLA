import java.util.ArrayList;

public class Missao {
    private int id;
    private String nome;
    private int dificuldade;
    private ArrayList<Agente> participantes;
    private boolean status = true;
    Gerenciamento ger = new Gerenciamento();


    public Missao(int id, String nome, int dificuldade) {
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

    public void adicionaParticipante(int id, String nome) {

        Agente agente = ger.buscarAgente(nome);
        Missao missao = ger.buscarMissaoID(id);

        if(missao == null) {
            System.out.println("Não existe uma missão com o ID informado!");

        } else if (agente == null) {
            System.out.println("O Agente '" + agente.getNome() + "' não existe!");

        } else if (!agente.getStatus()) {
            System.out.println("O Agente '" + agente.getNome() + "' está morto!");

        } else if (participantes.contains(agente)) {
            System.out.println("O Agente '" + agente.getNome() + "'já está na lista de participantes!");

        } else {
            participantes.add(agente);
            System.out.println("Agente '" + agente.getNome() + "' adicionado à Missão '" + missao.getNome() + "'.");
        }
    }


    public void removerParticipante(int id, String nome) {
        Agente agente = ger.buscarAgente(nome);
        Missao missao = ger.buscarMissaoID(id);
        if(missao == null) {
            System.out.println("Não existe uma missão com o ID informado!");
        }else if(agente == null) {
            System.out.println("O Agente '" + agente.getNome() + "' não existe!");
        }else {
            participantes.remove(agente);
            System.out.println("Agente '" + agente.getNome() + "' removido da Missão '"+ missao.getNome() + "'.");
        }
    }


    public void iniciarMissao(int id) {
        Missao missao = ger.buscarMissaoID(id);
        int minimoParticipantes = this.dificuldade + 1;
        boolean equipamentoTipo = true;

        if(missao != null) {
            if (participantes.size() == minimoParticipantes) {
                System.out.println("Iniciando Missão '" + missao.getNome() + "' (ID"+ missao.getId() + ")...");
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

                    System.out.println("- "+ agente.getNome()+ ": +"+ XP + "XP, recebeu "+ equipamento);

                    this.status = false;
                }
            }
        }else{
            System.out.println("A missão não existe!");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public int getId() {
        return id;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

