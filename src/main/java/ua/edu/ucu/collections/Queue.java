package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList;
    public Queue(){
        linkedList = new ImmutableLinkedList();
    }


    public Object peek() {
        return linkedList.getFirst();
    }

    public Object dequeue() {
        Object firstel = linkedList.getFirst();
        linkedList = linkedList.removeFirst();
        return firstel;
    }

    public void enqueue(Object e) {
        linkedList = linkedList.addLast(e);
    }

}
