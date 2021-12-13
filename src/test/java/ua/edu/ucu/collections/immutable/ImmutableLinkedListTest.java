package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableLinkedListTest {
    ImmutableLinkedList linkedList1;
    ImmutableLinkedList linkedList2;

    @Before
    public void setUp() {
        linkedList1 = new ImmutableLinkedList();
        linkedList2 = new ImmutableLinkedList();
    }

    @Test
    public void add() {
        linkedList1.add(1);
        linkedList1 = (ImmutableLinkedList) linkedList1.add(2);
        linkedList2 = (ImmutableLinkedList) linkedList2.add(3);
        assertEquals(linkedList2.indexOf(1), -1);
        assertEquals(linkedList2.indexOf(2), -1);
        assertEquals(linkedList2.indexOf(3), 0);

        linkedList1 = (ImmutableLinkedList) linkedList1.add(10);
        assertEquals(linkedList1.indexOf(11), -1);
        assertEquals(linkedList1.indexOf(10), 1);
    }

    @Test
    public void addIndex() {
        linkedList1 = (ImmutableLinkedList) linkedList1.add(1);
        linkedList1 = (ImmutableLinkedList) linkedList1.add(2);
        linkedList1 = (ImmutableLinkedList) linkedList1.add(4);
        assertEquals(linkedList1.getLast(), 4);
        linkedList1 = (ImmutableLinkedList) linkedList1.add(2,3);
        assertEquals(linkedList1.getLast(), 4);
        assertEquals(linkedList1.indexOf(3), 2);
    }

    @Test
    public void addAll() {
        Object[] toAdd = new Object[]{4,5,6};
        Object[] ref = new Object[]{1, 4, 5, 6};
        linkedList1 = (ImmutableLinkedList) linkedList1.add(1);
        linkedList1 = (ImmutableLinkedList) linkedList1.addAll(toAdd);
        assertArrayEquals(ref, linkedList1.toArray());
    }

    @Test
    public void addAllIndex() {
        Object[] toAdd = new Object[]{4,5,6};
        Object[] ref = new Object[]{4, 5, 6, 1};
        linkedList2 = (ImmutableLinkedList) linkedList2.add(1);
        linkedList2 = (ImmutableLinkedList) linkedList2.addAll(0, toAdd);
        assertArrayEquals(ref, linkedList2.toArray());
    }

    @Test
    public void get() {
        linkedList2 = (ImmutableLinkedList) linkedList1.add(1);
        assertEquals(linkedList2.get(0), 1);
    }

    @Test
    public void remove() {
        linkedList2 = (ImmutableLinkedList) linkedList1.add(1);
        linkedList2 = (ImmutableLinkedList) linkedList2.add(2);
        assertEquals(linkedList2.getLast(), 2);
        linkedList2 = (ImmutableLinkedList) linkedList2.remove(1);
        assertEquals(linkedList2.getLast(), 1);

    }

    @Test
    public void set() {
        linkedList2 = (ImmutableLinkedList) linkedList1.add("I'm");
        linkedList2 = (ImmutableLinkedList) linkedList2.add("okay");
        assertEquals(linkedList2.getLast(), "okay");
        linkedList2 = (ImmutableLinkedList) linkedList2.set(1, "not okay");
        assertEquals(linkedList2.getLast(), "not okay");
    }

    @Test
    public void indexOf() {
        linkedList2 = new ImmutableLinkedList(new Object[]{1, "pupa", 3});
        assertEquals(1, linkedList2.indexOf("pupa"));
        assertEquals(-1, linkedList2.indexOf("lupa"));
    }

    @Test
    public void size() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", 3});
        assertEquals(3, linkedList1.size());
    }

    @Test
    public void clear() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", 3});
        linkedList2 = (ImmutableLinkedList) linkedList1.clear();
        assertEquals(linkedList1.size(), 3);
        assertEquals(linkedList2.size(), 0);
    }

    @Test
    public void isEmpty() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", 3});
        linkedList2 = (ImmutableLinkedList) linkedList1.clear();
        assertTrue(linkedList2.isEmpty());
        assertFalse(linkedList1.isEmpty());
    }

    @Test
    public void toArray() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, 2});
        assertArrayEquals(new Object[]{1, 2}, linkedList1.toArray());
    }

    @Test
    public void addFirst() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", 3});
        linkedList2 = linkedList1.addFirst(4);
        Object[] ref = new Object[]{4, 1, "be", 3};
        assertArrayEquals(ref, linkedList2.toArray());
    }

    @Test
    public void addLast() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", 3});
        linkedList2 = linkedList1.addLast(4);
        Object[] ref = new Object[]{1, "be", 3, 4};
        assertArrayEquals(ref, linkedList2.toArray());
    }

    @Test
    public void getHead() {
        linkedList1 = (ImmutableLinkedList) linkedList1.add(1);
        assertEquals(linkedList1.getHead().getValue(), 1);
    }

    @Test
    public void getTail() {
        linkedList1 = (ImmutableLinkedList) linkedList1.add(1);
        linkedList1 = (ImmutableLinkedList) linkedList1.add(2);
        assertEquals(linkedList1.getTail().getValue(), 2);
    }

    @Test
    public void getFirst() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", "me"});
        assertEquals(linkedList1.getFirst(), 1);
    }

    @Test
    public void getLast() {
        linkedList1 = new ImmutableLinkedList(new Object[]{1, "be", "me"});
        assertEquals(linkedList1.getLast(), "me");

    }

    @Test
    public void removeFirst() {
        linkedList1 = new ImmutableLinkedList(new Object[]{"fe", "be", "me"});
        linkedList2 = linkedList1.removeFirst();
        assertArrayEquals(linkedList2.toArray(), new Object[]{"be", "me"});
    }

    @Test
    public void removeLast() {
        linkedList1 = new ImmutableLinkedList(new Object[]{"fe", "be", "me"});
        linkedList2 = linkedList1.removeLast();
        assertArrayEquals(linkedList2.toArray(), new Object[]{"fe", "be"});
    }
}