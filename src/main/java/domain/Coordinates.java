package domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Coordinates {

    private double coord_x;
    private double coord_y;

    public void setCoords(double coord_x, double coord_y) {
        this.coord_x = coord_x;
        this.coord_y = coord_y;
    }

    public static double getLengthBetweenDots(Coordinates c1, Coordinates c2){
        return Math.sqrt(Math.pow(c1.coord_x - c2.coord_x, 2) + Math.pow(c1.coord_y - c2.coord_y, 2));
    }

}
