import java.util.List;

/**
 * Relatório completo da turma.
 * Demonstra: herança e polimorfismo (estende Relatorio e implementa métodos abstratos).
 */
public class RelatorioTurma extends Relatorio {

    public RelatorioTurma(Turma turma) {
        super(turma);
    }

    @Override
    protected void exibirCabecalho() {
        linha('=', 80);
        System.out.printf("%35s%n", "SISTEMA DE NOTAS E MÉDIAS");
        System.out.printf("  Turma : %s%n", turma.getNomeTurma());
        System.out.printf("  Total de alunos: %d%n", turma.getTotalAlunos());
        linha('=', 80);
    }

    @Override
    protected void exibirCorpo() {
        System.out.println("\n  LISTAGEM DE ALUNOS (ordenada por nome)\n");
        linha('-', 80);

        List<Aluno> ordenados = turma.getAlunosOrdenados();

        if (ordenados.isEmpty()) {
            System.out.println("  Nenhum aluno cadastrado.");
        } else {
            for (int i = 0; i < ordenados.size(); i++) {
                // Polimorfismo: chama exibirInformacoes() de Aluno via toString() de Pessoa
                System.out.printf("  %2d. %s%n", i + 1, ordenados.get(i));
            }
        }

        linha('-', 80);
    }

    @Override
    protected void exibirRodape() {
        System.out.println("\n  ESTATÍSTICAS DA TURMA\n");
        linha('-', 80);
        System.out.printf("  %-30s %.2f%n", "Média Geral da Turma:", turma.calcularMediaGeral());
        System.out.printf("  %-30s %.2f%n", "Maior Nota:", turma.getMaiorNotaTurma());
        System.out.printf("  %-30s %.2f%n", "Menor Nota:", turma.getMenorNotaTurma());
        System.out.printf("  %-30s %d aluno(s)%n", "Total Aprovados:", turma.getTotalAprovados());
        System.out.printf("  %-30s %d aluno(s)%n", "Total Reprovados:", turma.getTotalReprovados());
        linha('=', 80);
        System.out.println();
    }
}
