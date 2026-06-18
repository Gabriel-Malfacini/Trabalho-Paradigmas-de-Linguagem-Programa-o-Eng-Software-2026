/**
 * Exceção personalizada para notas inválidas.
 * Demonstra: tratamento de exceções com classe própria.
 */
public class NotaInvalidaException extends Exception {

    private double notaInformada;

    public NotaInvalidaException(double notaInformada) {
        super(String.format(
            "Nota inválida: %.2f. As notas devem estar entre 0.0 e 10.0.",
            notaInformada
        ));
        this.notaInformada = notaInformada;
    }

    public double getNotaInformada() {
        return notaInformada;
    }
}
