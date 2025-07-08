import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static Gerenciamento ger = new Gerenciamento();
    private static Missao missao;

    public static void Menu() {
        int opcao = 0;

        do {
            System.out.println("=== AGÊNCIA ESPACIAL INTERPLANETÁRIA ===");
            System.out.println("1. Gerenciar Agentes");
            System.out.println("2. Gerencias Missões");
            System.out.println("3. Paticipação de Missões");
            System.out.println("4. Consultas e Relatórios");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção:_");
            opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                gerenciarAgentes();
                break;
            case 2:
                gerenciarMissoes();
                break;
            case 3:
                participacaoEmMissoes();
                break;
            case 4:
                consultasRelatorios();
                break;
            case 5:
                System.out.println("Obrigada por participar! Até a próxima missão espacial!");
                System.exit(0);
                break;
        }
        } while (opcao != 5);

    }

    private static void consultasRelatorios() {
        int opcao;

        do {
            System.out.println("--- Consultas e Relatórios ---");
            System.out.println("1. Listar Agentes");
            System.out.println("2. Listar Missões");
            System.out.println("3. Buscar Agente por Nome");
            System.out.println("4. Exibir Inventário de Agente");
            System.out.println("5. Agrupar Agentes por Nível");
            System.out.println("6. Agrupar Missões por Dificuldade");
            System.out.println("7. Voltar ao Menu Principal");
            System.out.println("Escolha:_");
            opcao = sc.nextInt();
            switch (opcao) {
//            case 1: listarAgentes();
//                break;
//            case 2: listarMissoes();
//                break;
            }

        } while (opcao != 7);

    }

    private static void participacaoEmMissoes() {
        int opcao;

        do {
            System.out.println("--- Participação em Missões ---");
            System.out.println("1. Adicionar Agente a Missão");
            System.out.println("2. Remover Agente de Missão");
            System.out.println("3. Iniciar Missão");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.println("Escolha:_");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    adicionarAgenteMissao();
                    break;
                case 2:
                    removerAgenteMissao();
                    break;
                case 3:
                    iniciarMissaoMain();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal");
                    return;
            }
        } while (opcao != 4);

    }

    private static void iniciarMissaoMain() {
        System.out.println("--- Iniciando Missão ---");

        System.out.println("Informe o ID da missão que deseja iniciar: ");
        int id = sc.nextInt();

        missao.iniciarMissao(id);
    }

    private static void removerAgenteMissao() {
        System.out.println("--- Removendo Agente da Missão ---");
        System.out.println("Informe o ID da missão que deseja remover o Agente: ");
        int id = sc.nextInt();

        System.out.println("Informe o nome da Agente que deseja remover da missão: ");
        String nome = sc.nextLine();

        missao.removerParticipante(id, nome);

    }

    private static void adicionarAgenteMissao() {
        System.out.println("--- Adicioanar Agente a Missão ---");
        System.out.println("Informe o ID da missão que deseja adicionar o Agente: ");
        int id = sc.nextInt();

        System.out.println("Informe o nome da Agente que deseja adicionar a missão: ");
        String nome = sc.nextLine();

        missao.adicionaParticipante(id, nome);

    }

    private static void gerenciarMissoes() {
        int opcao;

        do {
            System.out.println("--- Gerenciar Missões ---");
            System.out.println("1. Criar Missão");
            System.out.println("2. Atualizar Missão");
            System.out.println("3. Excluir Missão");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.println("Escolha:_");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    criarMissao();
                    break;
                case 2:
                    atualizarMissao();
                    break;
                case 3:
                    excluirMissao();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
                    break;
            }
        } while (opcao != 4);

    }

    private static void excluirMissao() {
        System.out.println("--- Excluir Missão ---");

        System.out.println("Informe o ID da missão que deseja excluir: ");
        int id = sc.nextInt();

        Missao missao = ger.buscarMissaoID(id);

        if (missao != null) {
            ger.removerMissaoGer(missao);

        } else {
            System.out.println("Missão não encontrada! Tente novamente.");
            return;
        }
    }

    private static void atualizarMissao() {
        System.out.println("--- Atualizar Missão ---");

        System.out.println("Informe o ID da missão que deseja atualizar: ");
        int id = sc.nextInt();

        if (ger.buscarMissaoID(id) != null) {
            System.out.println("Informe o novo nome da missão: ");
            String nome = sc.nextLine();

            System.out.println("Informe a nova dificuldade da missão(1-3): ");
            int dificuldade = sc.nextInt();

            ger.atualizarMissaoGer(nome, dificuldade);
        } else {
            System.out.println("Missão não encontrada! Tente novamente.");
            return;
        }

    }

    private static void criarMissao() {
        System.out.println("--- Criar Missão ---");

        sc.nextLine();

        System.out.println("Informe o nome da missão: ");
        String nome = sc.nextLine();

        System.out.println("Informe a dificuldade(1-3): ");
        int dificuldade = sc.nextInt();

        ger.criarMissaoGer(nome, dificuldade);
    }

    private static void gerenciarAgentes() {
        int opcao;
        do {
            System.out.println("--- Gerenciar Agentes ---");
            System.out.println("1. Criar Agente");
            System.out.println("2. Atualizar Agente");
            System.out.println("3. Excluir Agente");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.println("Escolha:_");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    criarAgente();
                    break;
                case 2:
                    atualizarAgente();
                    break;
                case 3:
                    removerAgente();
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
                    break;
            }
        } while (opcao != 4);

    }

    private static void removerAgente() {
        System.out.println("--- Remover Agente ---");
        System.out.println("Informe o nome do agente: ");
        String nome = sc.next();

        ger.removerAgenteGer(nome);

    }

    private static void atualizarAgente() {
        System.out.println("--- Atualizar Agente ---");
        System.out.println("Informe o nome do agente: ");
        String nome = sc.next();

        Agente agente = ger.buscarAgente(nome);

        if (agente == null) {
            System.out.println("O Agente não existe!");
            return;
        } else {
            System.out.println("-- Atualizando Agente " + nome + " --");
            System.out.println("Informe o novo nível: ");
            int nivel = sc.nextInt();

            System.out.println("Informe a nova vida Atual: ");
            int vida = sc.nextInt();

            ger.atualizarAgenteGer(agente,nivel, vida);
        }


    }

    private static void criarAgente() {
        int atributo = 0;
        System.out.println("--- Criar Agente ---");
        System.out.println("Informe o nome do agente: ");
        String nome = sc.next();

        if (ger.buscarAgente(nome) != null) {
            System.out.println("Já existe um agente com esse nome! Tente novamente!");
            return;
        } else {
            System.out.println("Informe a classe do agente: (1-Piloto, 2-Engenheiro, 3-Cientista)");
            int classe = sc.nextInt();

            System.out.println("Informe o nível inicial do agente: ");
            int nivel = sc.nextInt();

            if (classe == 1) {

                System.out.println("Informe o valor do Reflexo: ");
                atributo = sc.nextInt();

            } else if (classe == 2) {
                System.out.println("Informe o valor da Inteligência: ");
                atributo = sc.nextInt();
            } else if (classe == 3) {
                System.out.println("Informe o valor da Criatividade: ");
                atributo = sc.nextInt();
            }

            ger.adicionarAgente(nome, classe, nivel, atributo);
        }

    }


    public static void main(String[] args) {
        Menu();
    }

}