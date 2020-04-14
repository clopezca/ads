package domain.advert.value_object;

import java.util.Objects;

public class Description {
    private final String description;

    public Description(String description) {
        if(description.trim().equals("")) throw new IllegalArgumentException();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}
