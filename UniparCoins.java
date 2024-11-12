import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CarteiraDigital {
    private double saldo;
    private List<String> historico;

    // Construtor
    public CarteiraDigital() {
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    // Método para adicionar saldo
    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Adição: " + valor);
            System.out.println("Saldo adicionado com sucesso!");
        } else {
            System.out.println("Valor inválido. Não foi possível adicionar saldo.");
        }
    }

    // Método para realizar pagamento
    public void realizarPagamento(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            historico.add("Pagamento: " + valor);
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        }
    }

    // Método para verificar saldo
    public void verificarSaldo() {
        System.out.println("Seu saldo atual é: " + saldo);
    }

    // Método para exibir histórico de transações
    public void historicoTransacoes() {
        if (historico.isEmpty()) {
            System.out.println("Nenhuma transação realizada até o momento.");
        } else {
            System.out.println("Histórico de Transações:");
            for (String transacao : historico) {
                System.out.println(transacao);
            }
        }
    }
}

public class Main {

    // Função para exibir o menu de opções
    public static void menu() {
        System.out.println("\nBem-vindo à sua Carteira Digital!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Saldo");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Verificar Saldo");
        System.out.println("4 - Exibir Histórico de Transações");
        System.out.println("5 - Sair");
    }

    // Função para ler a entrada do usuário
    public static int lerEntradaUsuario(Scanner scanner) {
        while (true) {
            System.out.print("Usuário: ");
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 5) {
                    return opcao;
                } else {
                    System.out.println("Opção inválida. Por favor, escolha entre 1 e 5.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número entre 1 e 5.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
    }

    // Função principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarteiraDigital carteira = new CarteiraDigital();
        
        while (true) {
            menu();  // Exibe o menu
            int opcao = lerEntradaUsuario(scanner);  // Lê a opção do usuário
            
            switch (opcao) {
                case 1: // Adicionar saldo
                    System.out.print("Digite o valor para adicionar ao saldo: ");
                    double valorAdicionar = scanner.nextDouble();
                    carteira.adicionarSaldo(valorAdicionar);
                    break;

                case 2: // Realizar pagamento
                    System.out.print("Digite o valor do pagamento: ");
                    double valorPagamento = scanner.nextDouble();
                    carteira.realizarPagamento(valorPagamento);
                    break;

                case 3: // Verificar saldo
                    carteira.verificarSaldo();
                    break;

                case 4: // Exibir histórico de transações
                    carteira.historicoTransacoes();
                    break;

                case 5: // Sair
                    System.out.println("Obrigado por usar a sua Carteira Digital!");
                    scanner.close();
                    return;
            }
        }
    }
}