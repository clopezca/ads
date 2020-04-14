package domain.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatalogDTO {
    public List<AdvertDTO> adverts = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogDTO that = (CatalogDTO) o;
        return Objects.equals(adverts, that.adverts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adverts);
    }

    @Override
    public String toString() {
        return "CatalogDTO{" +
                "adverts=" + adverts +
                '}';
    }
}
