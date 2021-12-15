package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();
    public void push(Object e) {
        stack = stack.addFirst(e);
    }

    public Object pop() {
        Object el = stack.getFirst();
        stack = stack.removeFirst();
        return el;
    }

    public Object peek() {
        return stack.getFirst();
    }
}
