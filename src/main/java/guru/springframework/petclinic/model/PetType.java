package guru.springframework.petclinic.model;

public class PetType {

    private String type;

    public PetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}