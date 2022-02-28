import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BtreeTest {

    private BTree firstBTree;
    private BTree secondBTree;
    private BTree thirdBTree;
    private  ArrayList<Integer> expected;
    private ArrayList<Integer> actual;

    @BeforeEach
    void setUp() {
        firstBTree = new BTree(3);
        secondBTree = new BTree(3);
        firstBTree.init(new int[]{1, 2, 3});
        secondBTree.init(new int[]{8, 9, 10, 11, 15, 20});
    }

    @Test
    void insert1() {
        firstBTree.insert(4);
        expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        actual = new ArrayList<>();
        firstBTree.show(actual);
        assertEquals(expected, actual);
    }

    @Test
    void insert2(){
        secondBTree.insert(17);
        expected = new ArrayList<>(Arrays.asList(10, 8, 9, 11, 15, 17, 20));
        actual = new ArrayList<>();
        secondBTree.show(actual);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }


    @Test
    void remove1() {
        firstBTree.remove(3);
        expected = new ArrayList<>(Arrays.asList(1, 2));
        actual = new ArrayList<>();
        firstBTree.show(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void remove2(){
        secondBTree.remove(10);
        expected = new ArrayList<>(Arrays.asList(11, 8, 9, 15, 20));
        actual = new ArrayList<>();
        secondBTree.show(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void remove3(){
        secondBTree.remove(8);
        expected = new ArrayList<>(Arrays.asList(11, 9, 10, 15, 20));
        actual = new ArrayList<>();
        secondBTree.show(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void find1() {
        assertTrue(firstBTree.findKey(3));
    }
    @Test
    void find2() {
        assertTrue(secondBTree.findKey(11));
    }
    @Test
    void find3() {
        assertFalse(secondBTree.findKey(51));
    }
}