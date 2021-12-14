package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {
    ImmutableArrayList arr1;


    @Before
    public void setUp() {
        arr1 = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});
    }

    @Test
    public void testAddSimple() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, arr1.add(6).toArray());
    }

//    @Test
//    public void testAddIndex() {
//        assertArrayEquals(new Object[]{1, 2, 15, 3, 4, 5, 6}, arr1.add(2, 15).toArray());
//    }

    @Test
    public void testAddAllSimple() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8}, arr1.addAll(new Object[]{6, 7, 8}).toArray());
    }

    @Test
    public void testAddAllIndex() {
        assertArrayEquals(new Object[]{1, 6, 7, 8, 2, 3, 4, 5}, arr1.addAll(1, new Object[]{6, 7, 8}).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(1, arr1.get(0));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{2, 3, 4, 5}, arr1.remove(0).toArray());
    }

    @Test
    public void testSet() {
        ImmutableList arr = arr1.set(3, 0);
        assertEquals(0, arr.get(3));
    }


    @Test
    public void testIndexOff() {
        assertEquals(2, arr1.indexOf(3));
    }

    @Test
    public void testEmpty() {
        assertEquals(false, arr1.isEmpty());
    }

    @Test
    public void testClear() {
        assertEquals(0, arr1.clear().size());
    }


}