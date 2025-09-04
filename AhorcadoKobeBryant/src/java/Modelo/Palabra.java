package modelo;

public class Palabra {
    private int codigoPalabra;
    private String palabra;

    // Constructor vacío
    public Palabra() {}

    // Constructor con parámetros
    public Palabra(int codigoPalabra, String palabra) {
        this.codigoPalabra = codigoPalabra;
        this.palabra = palabra;
    }

    // Getters y Setters
    public int getCodigoPalabra() {
        return codigoPalabra;
    }

    public void setCodigoPalabra(int codigoPalabra) {
        this.codigoPalabra = codigoPalabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    // Para debug
    @Override
    public String toString() {
        return "Palabra{" +
                "codigoPalabra=" + codigoPalabra +
                ", palabra='" + palabra + '\'' +
                '}';
    }
}
