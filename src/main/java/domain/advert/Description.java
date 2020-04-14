package domain.advert;

public class Description {
    private final String description;

    public Description(String description) {
        if(description.trim().equals("")) throw new IllegalArgumentException();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
