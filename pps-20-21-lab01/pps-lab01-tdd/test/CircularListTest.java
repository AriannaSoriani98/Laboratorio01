import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final Integer CIRCULAR_LIST_SIZE = 10;
    public static final Integer NUMBER_TO_STRESS_TEST_ADD = 100;
    public static final Integer NUMBER_TO_STRESS_TEST_NEXT = 10;
    private static final Integer NUMBER_TO_STRESS_TEST_PREVIOUS = 10;
    private CircularListImpl circularList;
    private Integer next_by_strategy;
    private Integer next;
    private Integer previous;
    private Integer indexOfElementRemoved;
    private ArrayList <Integer> circularList_old = new ArrayList<>();
    private ArrayList<Integer> ArrayListOfInteger = new ArrayList<>();
    //TODO: test implementation

    @Disabled
    @Test
    void testTodo(){
        Assertions.fail();
    }

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl(ArrayListOfInteger);
        circularList.InitializeCircularList(CIRCULAR_LIST_SIZE);
    }


    @Test
    void testAdd() {
        for(int i = CIRCULAR_LIST_SIZE +1; i<= NUMBER_TO_STRESS_TEST_ADD; i++){
            circularList.add(i);
            assertEquals(i,circularList.getElementFromIndex(i));
        }

    }

    @Test
    void testSize() {
        assertEquals(circularList.size(), CIRCULAR_LIST_SIZE +1);
    }

    @Test
    void testIsEmpty() {
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testNext() {
        for(int i=0; i<=NUMBER_TO_STRESS_TEST_NEXT;i++) {
            for (int index = 0; index < CIRCULAR_LIST_SIZE; index++) {
                next = circularList.next();
                assertEquals(index + 1, next);
            }
            next = circularList.next();
            assertEquals(0, next);
        }
    }

    @Test
    void testPrevious() {
        for(int i=0; i<=NUMBER_TO_STRESS_TEST_PREVIOUS;i++) {
            for (int index = 0; index <= CIRCULAR_LIST_SIZE; index++) {
                previous = circularList.previous();

                if (index == 0) {
                    assertEquals(CIRCULAR_LIST_SIZE, previous);
                } else {
                    assertEquals(index - 1, previous);
                }
            }

        }
    }

    @Test
    void testReset() {
        for(int i = 0; i<= CIRCULAR_LIST_SIZE; i++){
            circularList_old.add(i);
        }
        for(int i=0;i<CIRCULAR_LIST_SIZE;i++){
            circularList_old.set(i, circularList.getElementFromIndex(i));
        }
        indexOfElementRemoved = circularList.reset();
        assertFalse(circularList_old.get(indexOfElementRemoved) == circularList.getElementFromIndex(indexOfElementRemoved));
        assertTrue(circularList.getElementFromIndex(0) == indexOfElementRemoved);
    }

    @Test
    void testNextWithStrategy() {
        for(int i=0;i<=circularList.size()-1;i++){
            next_by_strategy = circularList.nextByStrategy("pari");
            assertFalse(next_by_strategy %2 != 0);
        }
        for(int i=0;i<=circularList.size()-1;i++){
            next_by_strategy = circularList.nextByStrategy("dispari");
            assertFalse(next_by_strategy %2 == 0);
        }

    }
}
