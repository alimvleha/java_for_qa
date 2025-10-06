package ru.alimqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestsCollections {
    @Test
    void testArray() {
        var array = new String[]{"a","b", "c"};
//        var array = new String[3];
        Assertions.assertEquals(3, array.length);
        array[0] = "a";
        Assertions.assertEquals("a", array[0]);

        array[0] = "d";
        Assertions.assertEquals("d", array[0]);

    }

    @Test
    void  testList() {
        var list = new ArrayList<>(List.of("a","b", "c"));
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));
    }
}
