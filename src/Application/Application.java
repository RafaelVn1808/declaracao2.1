package Application;

import Entidades.Declaracao;
import Entidades.DeclaracaoEfetivo;
import Entidades.DeclaracaoEstagio;
import Entidades.DeclaracaoTemporario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("                   DECLARAÇÃO");
        System.out.println();
        System.out.println("1 - Declaração de Estagiário");
        System.out.println("2 - Declaração de Servidor Temporário");
        System.out.println("3 - Declaração de Servidor Efetivo");
        System.out.print("Escolha uma opção: ");

        int opcao = readInt(sc);

        switch (opcao) {
            case 1 -> handleEstagiario(sc);
            case 2 -> handleTemporario(sc);
            case 3 -> handleEfetivo(sc);
            default -> System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }

        sc.close();
    }

    private static void handleEstagiario(Scanner sc) {
        System.out.println("\n--- Dados do Estagiário ---");
        String nome = readString(sc, "Nome: ");
        String curso = readString(sc, "Curso: ");
        int matricula = readInt(sc, "Matrícula: ");
        int vinculo = readInt(sc, "Vínculo: ");
        LocalDate datain = readDate(sc, "Data de início (dd/MM/yyyy): ");
        LocalDate datafin = readDate(sc, "Data de fim (dd/MM/yyyy): ");

        Declaracao declaracao = new DeclaracaoEstagio(nome, matricula, vinculo, datain, datafin, curso);
        System.out.println("\nDeclaração Gerada:\n" + declaracao);
    }

    private static void handleTemporario(Scanner sc) {
        System.out.println("\n--- Dados do Servidor Temporário ---");
        String nome = readString(sc, "Nome: ");
        int matricula = readInt(sc, "Matrícula: ");
        int vinculo = readInt(sc, "Vínculo: ");
        String cargo = readString(sc, "Cargo: ");
        LocalDate datain = readDate(sc, "Data de início (dd/MM/yyyy): ");
        LocalDate datafin = readDate(sc, "Data de fim (dd/MM/yyyy): ");

        Declaracao declaracao = new DeclaracaoTemporario(nome, matricula, vinculo, datain, datafin, cargo);
        System.out.println("\nDeclaração Gerada:\n" + declaracao);
    }

    private static void handleEfetivo(Scanner sc) {
        System.out.println("\n--- Dados do Servidor Efetivo ---");
        String nome = readString(sc, "Nome: ");
        int matricula = readInt(sc, "Matrícula: ");
        int vinculo = readInt(sc, "Vínculo: ");
        String cargo = readString(sc, "Cargo: ");
        LocalDate datain = readDate(sc, "Início de exercício (dd/MM/yyyy): ");
        LocalDate datafin = readDate(sc, "Data de fim (dd/MM/yyyy): ");

        System.out.println("Tipo de Nomeação");
        System.out.println("1 - Portaria");
        System.out.println("2 - Decreto");
        int tipoNomeacao = readInt(sc, "Escolha uma opção: ");

        Declaracao declaracao;
        if (tipoNomeacao == 1) {
            int numeroPortaria = readInt(sc, "Número da Portaria de Nomeação: ");
            LocalDate dataPortaria = readDate(sc, "Data da Portaria (dd/MM/yyyy): ");
            int numeroDoe = readInt(sc, "Número D.O.E: ");
            LocalDate dataDoe = readDate(sc, "Data D.O.E (dd/MM/yyyy): ");
            LocalDate dataPosse = readDate(sc, "Data Posse (dd/MM/yyyy): ");

            declaracao = new DeclaracaoEfetivo(nome, matricula, vinculo, datain, datafin, numeroPortaria,
                    dataPortaria, dataDoe, numeroDoe, cargo, dataPosse);
        } else if (tipoNomeacao == 2) {
            LocalDate dataDecreto = readDate(sc, "Data do Decreto (dd/MM/yyyy): ");
            int numeroDoe = readInt(sc, "Número D.O.E: ");
            LocalDate dataDoe = readDate(sc, "Data D.O.E (dd/MM/yyyy): ");
            LocalDate dataPosse = readDate(sc, "Data Posse (dd/MM/yyyy): ");

            declaracao = new DeclaracaoEfetivo(nome, matricula, vinculo, datain, datafin, dataDecreto,
                    dataDoe, numeroDoe, cargo, dataPosse);
        } else {
            System.out.println("Opção inválida para nomeação.");
            return;
        }

        System.out.println("\nDeclaração Gerada:\n" + declaracao);
    }

    private static String readString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    private static int readInt(Scanner sc) {
        return readInt(sc, "");
    }

    private static LocalDate readDate(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, insira no formato dd/MM/yyyy.");
            }
        }
    }
}
