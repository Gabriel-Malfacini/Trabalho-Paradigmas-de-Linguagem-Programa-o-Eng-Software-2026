import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma Turma com uma coleção de Alunos.
 * Encapsula a lógica de estatísticas da turma.
 * Demonstra: encapsulamento e composição.
 */
public class Turma {

    private String nomeTurma;
    private List<Aluno> alunos;

    public Turma(String nomeTurma) {
        if (nomeTurma == null || nomeTurma.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da turma não pode ser vazio.");
        }
        this.nomeTurma = nomeTurma.trim();
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        alunos.add(aluno);
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public int getTotalAlunos() {
        return alunos.size();
    }

    /**
     * Retorna lista de alunos ordenada por nome.
     */
    public List<Aluno> getAlunosOrdenados() {
        List<Aluno> ordenados = new ArrayList<>(alunos);
        Collections.sort(ordenados);
        return ordenados;
    }

    /**
     * Calcula a média geral de todos os alunos da turma.
     */
    public double calcularMediaGeral() {
        if (alunos.isEmpty()) return 0.0;
        double soma = 0.0;
        for (Aluno a : alunos) {
            soma += a.calcularMedia();
        }
        return soma / alunos.size();
    }

    /**
     * Retorna a maior nota registrada na turma.
     */
    public double getMaiorNotaTurma() {
        if (alunos.isEmpty()) return 0.0;
        double maior = Double.MIN_VALUE;
        for (Aluno a : alunos) {
            if (!a.getNotas().isEmpty() && a.getMaiorNota() > maior) {
                maior = a.getMaiorNota();
            }
        }
        return maior == Double.MIN_VALUE ? 0.0 : maior;
    }

    /**
     * Retorna a menor nota registrada na turma.
     */
    public double getMenorNotaTurma() {
        if (alunos.isEmpty()) return 0.0;
        double menor = Double.MAX_VALUE;
        for (Aluno a : alunos) {
            if (!a.getNotas().isEmpty() && a.getMenorNota() < menor) {
                menor = a.getMenorNota();
            }
        }
        return menor == Double.MAX_VALUE ? 0.0 : menor;
    }

    /**
     * Conta quantos alunos foram aprovados.
     */
    public long getTotalAprovados() {
        long count = 0;
        for (Aluno a : alunos) {
            if (a.isAprovado()) count++;
        }
        return count;
    }

    /**
     * Conta quantos alunos foram reprovados.
     */
    public long getTotalReprovados() {
        return alunos.size() - getTotalAprovados();
    }
}
