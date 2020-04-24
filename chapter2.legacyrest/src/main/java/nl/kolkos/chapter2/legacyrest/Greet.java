package nl.kolkos.chapter2.legacyrest;

public class Greet {
    private String message;

    public Greet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
