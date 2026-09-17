import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sistema de Cadastro de Veículos.
 * Armazena os veículos em memória, utilizando uma List<Veiculo>.
 */
public class CadastroVeiculos {

    private static final int ANO_MINIMO = 1900;

    private List<Veiculo> veiculos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CadastroVeiculos sistema = new CadastroVeiculos();
        sistema.executar();
    }

    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    listarVeiculos();
                    break;
                case 3:
                    consultarVeiculo();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();

        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("======= Cadastro de Veículos OO =======");
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Consultar Veículo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número.");
            scanner.next();
            System.out.print("Escolha uma opção: ");
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private void cadastrarVeiculo() {
        System.out.println("\n--- Cadastro de Veículo ---");

        System.out.print("Placa: ");
        String placa = scanner.nextLine().trim();

        if (placaJaCadastrada(placa)) {
            System.out.println("Erro: já existe um veículo cadastrado com essa placa.");
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine().trim();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine().trim();

        int ano = lerAnoValido();
        if (ano == -1) {
            System.out.println("Cadastro cancelado: ano inválido.");
            return;
        }

        Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
        veiculos.add(veiculo);

        System.out.println("Veículo cadastrado com sucesso!");
    }

    private int lerAnoValido() {
        int anoMaximo = LocalDate.now().getYear() + 1;

        System.out.print("Ano (entre " + ANO_MINIMO + " e " + anoMaximo + "): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número.");
            scanner.next();
            System.out.print("Ano (entre " + ANO_MINIMO + " e " + anoMaximo + "): ");
        }
        int ano = scanner.nextInt();
        scanner.nextLine();

        if (ano < ANO_MINIMO || ano > anoMaximo) {
            System.out.println("Ano inválido! Deve estar entre " + ANO_MINIMO + " e " + anoMaximo + ".");
            return -1;
        }

        return ano;
    }

    private boolean placaJaCadastrada(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    private void listarVeiculos() {
        System.out.println("\n--- Lista de Veículos ---");

        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        for (Veiculo v : veiculos) {
            System.out.println(v);
        }
    }

    private void consultarVeiculo() {
        System.out.println("\n--- Consultar Veículo ---");
        System.out.print("Informe a placa: ");
        String placa = scanner.nextLine().trim();

        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println(v);
                return;
            }
        }

        System.out.println("Nenhum veículo encontrado com a placa informada.");
    }
}
