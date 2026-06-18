import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal — ponto de entrada do sistema.
 * Demonstra: tratamento de exceções (try-catch-finally, exceções customizadas).
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("   SISTEMA DE NOTAS E MÉDIAS DE ALUNOS");
        System.out.println("================================================\n");

        Turma turma = null;

        try {
            // Lê nome da turma
            System.out.print("Nome da turma: ");
            String nomeTurma = scanner.nextLine();
            turma = new Turma(nomeTurma);

            // Lê quantidade de alunos
            int n = lerInteiroPositivo("Número de alunos: ");

            // Lê quantidade de notas por aluno
            int qtdNotas = lerInteiroPositivo("Quantidade de notas por aluno: ");

            System.out.println();

            // Cadastra cada aluno
            for (int i = 1; i <= n; i++) {
                System.out.println("─── Aluno " + i + " ───────────────────────");
                Aluno aluno = cadastrarAluno(qtdNotas);
                turma.adicionarAluno(aluno);
                System.out.println("  ✔ Aluno cadastrado com sucesso!\n");
            }

            // Gera relatório — polimorfismo: RelatorioTurma é tratado como Relatorio
            Relatorio relatorio = new RelatorioTurma(turma);
            relatorio.gerar();

        } catch (IllegalArgumentException e) {
            System.err.println("\n[ERRO DE CONFIGURAÇÃO] " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Sistema encerrado.");
        }
    }

    /**
     * Cadastra um aluno lendo nome e notas do console.
     * Demonstra: tratamento de NotaInvalidaException com reentrada.
     */
    private static Aluno cadastrarAluno(int qtdNotas) {
        Aluno aluno = null;

        // Lê nome com validação
        while (aluno == null) {
            try {
                System.out.print("  Nome do aluno: ");
                String nome = scanner.nextLine();
                aluno = new Aluno(nome);
            } catch (IllegalArgumentException e) {
                System.err.println("  [ERRO] " + e.getMessage() + " Tente novamente.");
            }
        }

        // Lê notas com validação
        for (int j = 1; j <= qtdNotas; j++) {
            boolean notaValida = false;
            while (!notaValida) {
                try {
                    System.out.printf("  Nota %d (0.0 a 10.0): ", j);
                    double nota = scanner.nextDouble();
                    aluno.adicionarNota(nota);   // lança NotaInvalidaException se inválida
                    notaValida = true;
                } catch (NotaInvalidaException e) {
                    // Exceção de domínio específica
                    System.err.println("  [NOTA INVÁLIDA] " + e.getMessage());
                } catch (InputMismatchException e) {
                    // Entrada não numérica
                    System.err.println("  [ERRO] Digite um número válido (ex: 7.5).");
                    scanner.nextLine(); // limpa buffer
                }
            }
            scanner.nextLine(); // consome o '\n' após nextDouble()
        }

        return aluno;
    }

    /**
     * Lê um inteiro positivo com tratamento de exceção.
     */
    private static int lerInteiroPositivo(String mensagem) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor <= 0) {
                    System.err.println("  [ERRO] O valor deve ser maior que zero.");
                } else {
                    valido = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("  [ERRO] Digite um número inteiro válido.");
                scanner.nextLine(); // limpa buffer
            }
        }
        return valor;
    }
}
