package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {

    private Node head = new Node();
    private Node tail;
    private int length = this.toArray().length;


    public ImmutableLinkedList(Object[] elements) {
        this.length = elements.length;
        if (elements.length == 0){
            this.head = null;
            this.tail = null;
            this.length = 0;
            return;
        }

        Node current = new Node();
        current.setValue(elements[0]);
        this.head = current;

        if (elements.length == 1){
            this.head.setNext(null);
            this.head.setPrevious(null);
            this.tail = current;
            this.tail.setPrevious(null);
            this.tail.setNext(null);
            return;
        }

        for (int i = 1; i < elements.length; i++) {

            Node newNode = new Node();
            newNode.setValue(elements[i]);
            this.head.setNext(newNode);

            newNode.setPrevious(current);
            current = newNode;

            if (i == elements.length - 1) {
                this.tail = newNode;
            }
        }
    }

    public ImmutableLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] el = new Object[]{e};
        return this.addAll(el);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] el = new Object[]{e};

        return this.addAll(index, el);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }


    @Override
    public ImmutableList addAll(int index, Object[] c) {

        Object[] newArr = new Object[size() + c.length];
        Node current = this.head;
        int ind = 0;
        int i = 0;

        while (ind <= index) {
            newArr[ind] = current.getValue();
            current = current.getNext();
            ind = ind + 1;
        }

        while (ind < c.length + index) {
            newArr[ind] = c[i];
            i = i + 1;
        }

        while (current != null) {
            newArr[ind] = current.getValue();
            current = current.getNext();
            ind = ind + 1;
        }
        this.length = newArr.length;
        return new ImmutableLinkedList(newArr);

    }

    @Override
    public Object get(int index) {

        Node cur = this.head;

        for (int i = 0; i < index; i++){
            cur = cur.getNext();
            i += 1;
        }

        return cur.getValue();
    }


    @Override
    public ImmutableList remove(int index) {

        Object[] newArr = new Object[this.length - 1];
        Object[] arr = Arrays.copyOf(this.toArray(), this.length);

        int j = 0;
        for (int i = 0; i < this.length; i++) {
            if (i == index) {
                continue;
            }
            newArr[j] = arr[i];
            j += 1;
        }
        return new ImmutableLinkedList(newArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] changed = Arrays.copyOf(this.toArray(), this.length);
        changed[index] = e;
        return new ImmutableLinkedList(changed);
    }

    @Override
    public int indexOf(Object e) {
        int idx = 0;
        Node current = this.head;

        while (current != null) {
            if (current.getValue() == e) {
                return idx;
            }
            current = current.getNext();
            idx += 1;

        }

        throw new InputMismatchException();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        Node cur = this.head;
        int idx = 0;
        Object[] newArr = new Object[this.length];

        while (cur != null) {
            newArr[idx] = cur.getValue();
            cur = cur.getNext();
            idx += 1;
        }
        return newArr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) this.addAll(0, new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] newArr = new Object[this.length + 1];
        Object[] arr = Arrays.copyOf(this.toArray(), this.length);

        int j = 0;
        for (int i = 0; i < this.length; i++) {
            newArr[j] = arr[i];
            j += 1;
        }
        newArr[this.length] = e;
        return new ImmutableLinkedList(newArr);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) this.remove(this.length - 1);
    }
}
