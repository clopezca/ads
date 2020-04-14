package domain.advert;

import java.util.UUID;

public class AdvertId {
    private String id;

    public AdvertId() {
        this.id = UUID.randomUUID().toString();
    }
}