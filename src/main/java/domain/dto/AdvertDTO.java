package domain.dto;

import java.time.LocalDate;
import java.util.Objects;

public class AdvertDTO {
    public TitleDTO title;
    public DescriptionDTO description;
    public LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvertDTO advertDTO = (AdvertDTO) o;
        return Objects.equals(title, advertDTO.title) &&
                Objects.equals(description, advertDTO.description) &&
                Objects.equals(date, advertDTO.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date);
    }

    @Override
    public String toString() {
        return "AdvertDTO{" +
                "title=" + title +
                ", description=" + description +
                ", date=" + date +
                '}';
    }
}
