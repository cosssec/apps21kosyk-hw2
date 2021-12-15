package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {
    ImmutableLinkedList linkedlst;
    Object[] arr;

    @Before
    public void setUp() {
        arr = new Object[]{1, 2, 3, 4, 5};
        linkedlst = new ImmutableLinkedList(arr);
    }

    @Test
    public void testAddSimple() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6}, linkedlst.add(6).toArray());
    }


    @Test
    public void testAddAllSimple() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5, 6, 7, 8}, linkedlst.addAll(new Object[]{6, 7, 8}).toArray());
    }

    @Test
    public void testAddAllIndex() {
        Object[] arr1 = new Object[]{6, 7, 8};

        assertEquals(6, linkedlst.addAll(2, arr1).get(2));
        assertEquals(7, linkedlst.addAll(2, arr1).get(3));
        assertEquals(8, linkedlst.addAll(2, arr1).get(4));

    }

    @Test
    public void testGet() {
        assertEquals(1, linkedlst.get(0));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{1, 2, 3, 4}, linkedlst.remove(4).toArray());
    }

    @Test
    public void testSet() {
        ImmutableList arr = linkedlst.set(3, 0);
        assertEquals(0, arr.get(3));
    }


    @Test
    public void testIndexOff() {
        assertEquals(2, linkedlst.indexOf(3));
    }

    @Test
    public void testEmpty() {
        assertEquals(false, linkedlst.isEmpty());
    }

    @Test
    public void testClear() {
        assertEquals(0, linkedlst.clear().size());
    }


}