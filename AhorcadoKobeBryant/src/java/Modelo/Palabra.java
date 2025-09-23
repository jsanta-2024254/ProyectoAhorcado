package modelo;

public class Words {
    private int code_word;
    private String word;
    private String hint;

    // Constructor vacío
    public Words() {
    }

    // Constructor con parámetros
    public Words(int code_word, String word, String hint) {
        this.code_word = code_word;
        this.word = word;
        this.hint = hint;
    }

    // Getters y Setters

    public int getCode_word() {
        return code_word;
    }

    public void setCode_word(int code_word) {
        this.code_word = code_word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "Words{" + "code_word=" + code_word + ", word=" + word + ", hint=" + hint + '}';
    }
    
}
