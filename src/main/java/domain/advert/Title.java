package domain.advert;

import domain.advert.exceptions.TooLargeTitleException;

public class Title {
    private String title;

    public Title(String title) {
        if(title.length() > 50) throw new TooLargeTitleException();
        this.title = title;
    }
}
