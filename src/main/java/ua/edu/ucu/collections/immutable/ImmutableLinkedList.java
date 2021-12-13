package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node first;
    private Node last;
    private int length = 0;

    public ImmutableLinkedList(Object[] elements) {
        first = new Node();
        Node cur = first;
        first.setValue(elements[0]);
        length = 1;
        for (int i = 1; i < elements.length; i++){
            Node next = new Node();
            next.setValue(elements[i]);
            cur.setNext(next);
            next.setPrevious(cur);
            cur = next;
            length++;
        }
        last = cur;
    }

    public ImmutableLinkedList() {
        first = new Node();
        last = first;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newAr = new Object[length + c.length];
        Node cur = first;
        for (int i = 0; i < index; i++) {
            newAr[i] = cur.getValue();
            cur = cur.getNext();
        }
        System.arraycopy(c, 0, newAr, index, c.length);

        for(int k = index + c.length; k < length + c.length; k++){
            newAr[k] = cur.getValue();
            cur = cur.getNext();
        }

        return new ImmutableLinkedList(newAr);
    }

    @Override
    public Object get(int index) {
        Node current = first;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (length == 1) {
            return new ImmutableLinkedList();
        }
        Object[] newAr = new Object[length-1];
        Node cur = first;

        for (int i = 0; i < length; i++) {
            if (i < index) {
                newAr[i] = cur.getValue();
            } else if (i > index) {
                newAr[i-1] = cur.getValue();
            }
            cur = cur.getNext();
        }
        return new ImmutableLinkedList(newAr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newAr = new Object[length];
        Node cur = first;
        for (int i = 0; i < length; i++){
            if (i == index) {
                newAr[i] = e;
            } else {
                newAr[i] = cur.getValue();
            }
            cur = cur.getNext();
        }
        return new ImmutableLinkedList(newAr);
    }

    @Override
    public int indexOf(Object e) {
        Node current = first;
        int idx = -1;
        for (int i = 0; i < length; i++){
            if (current.getValue() == e){
                idx = i;
                return idx;
            }
            current = current.getNext();
        }
        return idx;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        Node cur = first;
        for (int i = 0; i < length; i++){
            array[i] = cur.getValue();
            cur = cur.getNext();
        }
        return array;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) addAll(length, new Object[]{e});
    }

    public Node getHead() {
        return first;
    }

    public Node getTail() {
        return last;
    }

    public Object getFirst() {
        return this.getHead().getValue();
    }

    public Object getLast() {
        return this.getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(length-1);
    }
}
