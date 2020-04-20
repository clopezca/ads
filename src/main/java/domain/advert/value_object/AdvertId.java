package domain.advert.value_object;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class AdvertId {
    private String id;

    public AdvertId() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertId advertId = (AdvertId) o;
        return Objects.equals(id, advertId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AdvertId{" +
                "id='" + id + '\'' +
                '}';
    }
}