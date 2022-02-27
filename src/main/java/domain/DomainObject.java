package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class DomainObject {

    private String name;

    private Coordinates coords;

    public DomainObject(String name) {
        this.name = name;
    }

    public void setCoords(double coord_x, double coord_y) {
        this.coords = new Coordinates(coord_x, coord_y);
    }

}
