package domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Room {

    public Room(Coordinates firstDot, Coordinates secondDot) throws Exception {

        if (firstDot.equals(secondDot)) {
            throw new Exception("Coordinate dots must be in different places!");
        }

        this.firstDot = firstDot;
        this.secondDot = secondDot;
    }

    @Setter @Getter
    private Coordinates firstDot;
    @Setter @Getter
    private Coordinates secondDot;

    @Getter
    private List<DomainObject> objs_list = new ArrayList<>();

    public void addObj(DomainObject obj, Coordinates coordinates) throws Exception {
        if (!checkRoomArea(coordinates)) throw new Exception("Object is out of room");
        obj.setCoords(coordinates);

        if(objs_list.contains(obj)) throw new Exception("This object is already existed");

        objs_list.add(obj);
    }

    public Person movePerson(Person person, DomainObject anotherObj) throws Exception {
        if (!checkObjInRoom(person, anotherObj)) {
            throw new Exception("Objects are not in the same room!");
        }

        if (person == null)
            throw new Exception("Only persons can move!");

        person.getCoords().setCoords(anotherObj.getCoords().getCoord_x(), anotherObj.getCoords().getCoord_y());

        return person;
    }

    public double getLengthBetweenObjs(DomainObject o1, DomainObject o2) throws Exception {
        if (!checkObjInRoom(o1, o2)) {
            throw new Exception("Objects are not in the same room!");
        }

        return Coordinates.getLengthBetweenDots(o1.getCoords(), o2.getCoords());
    }


    private boolean checkObjInRoom(DomainObject o1, DomainObject o2){
        return objs_list.contains(o1) && objs_list.contains(o2);
    }

    private boolean checkRoomArea(Coordinates c) {

        double x_min = Math.min(this.firstDot.getCoord_x(), this.secondDot.getCoord_x());
        double x_max = Math.max(this.firstDot.getCoord_x(), this.secondDot.getCoord_x());
        double y_min = Math.min(this.firstDot.getCoord_y(), this.secondDot.getCoord_y());
        double y_max = Math.max(this.firstDot.getCoord_y(), this.secondDot.getCoord_y());

        return x_min <= c.getCoord_x()
                && c.getCoord_x() <= x_max
                && y_min <= c.getCoord_y()
                && c.getCoord_y() <= y_max;
    }

}
