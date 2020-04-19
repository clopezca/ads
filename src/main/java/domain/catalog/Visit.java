package domain.catalog;

import java.util.Objects;

public class Visit {
    private int visits;

    public int getVisits() {
        return this.visits;
    }

    public void addVisit() {
        this.visits++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return visits == visit.visits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(visits);
    }

    public int addOneVisit(int actualVisits) {
        return actualVisits + 1;
    }
}
