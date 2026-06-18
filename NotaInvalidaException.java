/**
 * Classe abstrata base que representa uma Pessoa.
 * Demonstra: abstração, encapsulamento e herança.
 */
public abstract class Pessoa {

    private String nome;

    public Pessoa(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        }
        this.nome = nome.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio ou nulo.");
        }
        this.nome = nome.trim();
    }

    /**
     * Método abstrato — cada subclasse deve fornecer
     * sua própria representação em String.
     * Demonstra: polimorfismo (método abstrato).
     */
    public abstract String exibirInformacoes();

    @Override
    public String toString() {
        return exibirInformacoes();
    }
}
