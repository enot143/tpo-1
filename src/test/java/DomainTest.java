import domain.Coordinates;
import domain.Person;
import domain.Room;
import domain.Thing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DomainTest {


    Person andrey;
    Person boris;
    Person vlad;
    Person denis;

    Thing chair;
    Thing table;
    Thing spoon;
    Thing fork;

    Room room1;
    Room room2;
    Room room3;

    @BeforeEach
    void init() throws Exception {
        andrey = new Person("Andrey", 100, 190);
        boris = new Person("Boris", 200, 170);
        vlad = new Person("Vlad", 300, 400);
        denis = new Person("Denis", 50, 170);


        chair = new Thing("Chair");
        table = new Thing("Table");
        spoon = new Thing("Spoon");
        fork = new Thing("Fork");


        room1 = new Room(new Coordinates(-100, -100), new Coordinates(100, 100));
        room2 = new Room(new Coordinates(0, 0), new Coordinates(200, 200));
        room3 = new Room(new Coordinates(-200, -200), new Coordinates(0, 0));

        room1.addObj(vlad, new Coordinates(55, 55));
        room1.addObj(boris, new Coordinates(70, 90));
        room1.addObj(chair, new Coordinates(99, 55));

    }

    @Nested
    class PersonConstructorTest {

        @Test
        @DisplayName("check valid constructor")
        void basicTest() throws Exception {
            Person person = new Person("Andrey", 100, 190);
            assertEquals(person, andrey);
        }

        @Test
        @DisplayName("person constructor test (height)")
        void testWithNegativeHeight() {
            Exception e = assertThrows(Exception.class, () -> new Person("TestE", 100, -100));
            assertEquals("Height must be more than zero!", e.getMessage());
        }

        @Test
        @DisplayName("person constructor test (weight)")
        void testWithNegativeWeight() {
            Exception e = assertThrows(Exception.class, () -> new Person("TestE", -100, 100));
            assertEquals("Weight must be more than zero!", e.getMessage());
        }
    }

    @Nested
    class RoomTests {

        @Test
        @DisplayName("Test with room constructor (coordinate)")
        void testWithRoomConstructor() throws Exception {
            Room room = new Room(new Coordinates(1, 2), new Coordinates(1, 1));
            Exception roomE = assertThrows(Exception.class, () -> new Room(new Coordinates(1, 1), new Coordinates(1, 1)));
            assertEquals("Coordinate dots must be in different places!", roomE.getMessage());
        }

        @Test
        @DisplayName("Test with adding")
        void testWithObjAdd() throws Exception {
            Room testRoom = new Room(new Coordinates(-100, -100), new Coordinates(100, 100));
            testRoom.addObj(vlad, new Coordinates(55, 55));
            testRoom.addObj(boris, new Coordinates(70, 90));
            testRoom.addObj(chair, new Coordinates(99, 55));

            assertEquals(room1, testRoom);
        }

        @Test
        @DisplayName("Test with adding (Exception)")
        void testWithObjAddException(){
            Exception e = assertThrows(Exception.class, () -> room1.addObj(vlad, new Coordinates(99, 99)));
            assertEquals("This object is already existed", e.getMessage());

            Exception e1 = assertThrows(Exception.class, () -> room1.addObj(vlad, new Coordinates(111, 111)));
            assertEquals("Object is out of room", e1.getMessage());
        }

        @Test
        @DisplayName("Test with moving")
        void testWithObjMove() throws Exception {
            vlad = room1.movePerson(vlad, chair);
            assertEquals(vlad.getCoords(), chair.getCoords());
        }

        @Test
        @DisplayName("Test with moving (Exception)")
        void testWithObjMoveException() {
            Exception e = assertThrows(Exception.class, () -> room1.movePerson(vlad, table));
            assertEquals("Objects are not in the same room!", e.getMessage());
        }

        @Test
        @DisplayName("Test with length calculation")
        void testWithLength() {
            assertEquals(5, Coordinates.getLengthBetweenDots(new Coordinates(0, 3), new Coordinates(4, 0)));
        }
    }

}
