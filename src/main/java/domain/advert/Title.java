package domain.advert;

import domain.advert.exceptions.TooLargeTitleException;

public class Title {
    private String title;

    public Title(String title) {
        if(title.length() > 50) throw new TooLargeTitleException();
        if(title.trim().equals("")) throw new IllegalArgumentException();
        this.title = title;
    }
}
