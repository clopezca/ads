package domain.advert;

import java.time.LocalDate;

public class Advert {

    public Advert(AdvertBuilder advertBuilder) {
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
            if (this.title == null) throw new IllegalStateException("title cannot be empty");
            return new Advert(this);
        }
    }
}
