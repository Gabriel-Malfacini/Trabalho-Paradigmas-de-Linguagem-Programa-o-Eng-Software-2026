/**
 * Classe abstrata que define o contrato para geração de relatórios.
 * Demonstra: abstração e polimorfismo via método template.
 */
public abstract class Relatorio {

    protected Turma turma;

    public Relatorio(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("Turma não pode ser nula.");
        }
        this.turma = turma;
    }

    /**
     * Gera e exibe o relatório.
     * Padrão Template Method: define o esqueleto e delega partes às subclasses.
     */
    public final void gerar() {
        exibirCabecalho();
        exibirCorpo();
        exibirRodape();
    }

    protected abstract void exibirCabecalho();
    protected abstract void exibirCorpo();
    protected abstract void exibirRodape();

    // Utilitário compartilhado
    protected void linha(char caractere, int tamanho) {
        System.out.println(String.valueOf(caractere).repeat(tamanho));
    }
}
