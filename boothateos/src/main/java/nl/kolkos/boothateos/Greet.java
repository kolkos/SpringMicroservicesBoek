package nl.kolkos.boothateos;

import org.springframework.hateoas.RepresentationModel;

public class Greet extends RepresentationModel {
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
