package domain.dto;

import java.util.Objects;

public class TitleDTO {
    public String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleDTO titleDTO = (TitleDTO) o;
        return Objects.equals(title, titleDTO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
