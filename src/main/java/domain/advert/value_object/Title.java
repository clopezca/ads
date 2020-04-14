package domain.advert.value_object;

import domain.advert.exceptions.TooLargeTitleException;

import java.util.Objects;

public class Title {
    private String title;

    public Title(String title) {
        if(title.length() > 50) throw new TooLargeTitleException();
        if(title.trim().equals("")) throw new IllegalArgumentException();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
