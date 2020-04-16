package domain.advert;

import domain.advert.exceptions.SameTitleAndDescriptionException;
import domain.advert.value_object.AdvertId;
import domain.advert.value_object.Description;
import domain.advert.value_object.Title;
import domain.dto.AdvertDTO;

import java.time.LocalDate;
import java.util.Objects;

public class Advert {

    private final AdvertId id;
    private final Title title;
    private final Description description;
    private final LocalDate publicationDate;

    public Advert(AdvertBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.publicationDate = builder.publicationDate;
    }

    public AdvertId getId() {
        return id;
    }

    public boolean isPublicationDateOlder(LocalDate expirationDate) {
        return this.publicationDate.compareTo(expirationDate) < 0;
    }

    public static class AdvertBuilder {

        private AdvertId id;
        private Title title;
        private Description description;
        private LocalDate publicationDate;

        public AdvertBuilder title(Title title){
            this.title = title;
            return this;
        }

        public AdvertBuilder description(Description description) {
            this.description = description;
            return this;
        }

        public AdvertBuilder date(LocalDate date) {
            publicationDate = date;
            return this;
        }

        public Advert build() {
            this.id = new AdvertId();
            if (this.title == null) throw new IllegalStateException("advert must have a title");
            if (this.description == null) throw new IllegalStateException("advert must have a description");
            if (this.publicationDate == null) throw new IllegalStateException("advert must have a date");
            if (isTitleSameAsDescription()) throw new SameTitleAndDescriptionException();
            return new Advert(this);
        }

        private boolean isTitleSameAsDescription() {
            return this.title.getTitle().equals(this.description.getDescription());
        }
    }

    public AdvertDTO createDTO(){
        AdvertDTO advertDTO = new AdvertDTO();
        advertDTO.title = title.createDTO();
        advertDTO.description = description.createDTO();
        advertDTO.date = publicationDate;
        return advertDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return Objects.equals(title, advert.title) &&
                Objects.equals(description, advert.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }
}
