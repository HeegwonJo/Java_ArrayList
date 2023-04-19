package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<String> list;
    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void 사이즈테스트() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals(3, list.size());
    }

    @Test
    void add테스트() {
        assertTrue(list.add("Element1"));
        assertEquals(1, list.size());
        assertEquals("Element1", list.get(0));
    }

    @Test
    void get테스트() {
        list.add("Element1");
        list.add("Element2");
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));
    }

    @Test
    void remove테스트() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("Element2", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void isEmpty테스트() {
        assertEquals(true,list.isEmpty());
        list.add("Element1");
        assertEquals(false,list.isEmpty());
    }

    @Test
    void clear테스트(){
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.clear();
        assertEquals(0, list.size());
    }
    @Test
    void testIndexOf() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        assertEquals(0, list.indexOf("Element1"));
        assertEquals(1, list.indexOf("Element2"));
        assertEquals(-1, list.indexOf("Element3"));
    }


}