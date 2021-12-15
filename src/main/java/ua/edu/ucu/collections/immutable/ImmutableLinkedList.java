package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {

    private Node head = new Node();
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length == 0){
            new ImmutableLinkedList();
        }
        else {
            this.head = new Node();
            this.head.setValue(elements[0]);
            this.head.setNext(null);
            this.length = elements.length;
            Node current = this.head;
            for (int i = 1; i < elements.length; i++) {
                Node temp = new Node();
                temp.setValue(elements[i]);
                temp.setPrevious(current);
                temp.setNext(null);
                current.setNext(temp);
                current = temp;
            }
            this.tail = current;
        }
    }


//    public ImmutableLinkedList(Object[] elements) {
//        this.length = elements.length;
//        if (elements.length == 0){
//            this.head = null;
//            this.tail = null;
//            this.length = 0;
//            return;
//        }
//
//        Node current = new Node();
//        current.setValue(elements[0]);
//        this.head = current;
//
//        if (elements.length == 1){
//            this.head.setNext(null);
//            this.head.setPrevious(null);
//            this.tail = current;
//            this.tail.setPrevious(null);
//            this.tail.setNext(null);
//            return;
//        }
//
//        for (int i = 1; i < elements.length; i++) {
//
//            Node newNode = new Node();
//            newNode.setValue(elements[i]);
//            this.head.setNext(newNode);
//
//            newNode.setPrevious(current);
//            current = newNode;
//
//            if (i == elements.length - 1) {
//                this.tail = newNode;
//            }
//        }
//    }

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
        Node current = this.head;
        Object[] arr = new Object[this.length+c.length];

        int counter = 0;
        for (int i =0;i<this.length+c.length;i++){
            if (i >= index && counter<c.length){
                arr[i] = c[counter];
                counter += 1;
            }
            else{
                arr[i] = current.getValue();
                current = current.getNext();
            }
        }

        return new ImmutableLinkedList(arr);
    }

    @Override
    public Object get(int index) {
        if (index > this.length || index <0 || this.head == null){
            throw new IndexOutOfBoundsException();
        }

        Node cur = this.head;

        for (int i = 0; i <= index; i++){
            if (i == index){
                return cur.getValue();
            }
            if (cur.getNext() != null ){
            cur = cur.getNext();
                    }}

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

        for (int i=0;i<this.length;i++){
            newArr[i] = cur.getValue();
            cur = cur.getNext();
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

    public static void main(String[] args) {
        Object[] arr = {1,2,3,4,5};
        ImmutableLinkedList llist = new ImmutableLinkedList(arr);
        ImmutableLinkedList temp = (ImmutableLinkedList) llist.remove(2);
        System.out.println(temp.get(3));
    }
}
