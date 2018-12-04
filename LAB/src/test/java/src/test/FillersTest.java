
package src.test;

import fillers.Fillers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FillersTest {

    @Test
    void arrayLength() {

        Integer[] expext = new Integer[3];
        assertEquals(expext.length, Fillers.sorted(3).length);
        assertEquals(expext.length, Fillers.sortedWhithX(3).length);
        assertEquals(expext.length, Fillers.reverseSorted(3).length);
        assertEquals(expext.length, Fillers.randomNumbers(3).length);

    }

    @Test
    void checkNullLength() throws NullPointerException{

        Assertions.assertThrows(NullPointerException.class,() -> {Fillers.sorted(0);});
        Assertions.assertThrows(NullPointerException.class,() -> {Fillers.sortedWhithX(0);});
        Assertions.assertThrows(NullPointerException.class,() -> {Fillers.reverseSorted(0);});
        Assertions.assertThrows(NullPointerException.class,() -> {Fillers.randomNumbers(0);});
    }

}