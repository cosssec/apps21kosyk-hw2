package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {

    private final Object[] elementArrayList;

    public ImmutableArrayList(Object[] elements) {
        this.elementArrayList = elements;
    }

    public ImmutableArrayList() {
        this.elementArrayList = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(this.elementArrayList.length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.elementArrayList.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArr = new Object[size() + c.length];
        System.arraycopy(c, 0, newArr, index, c.length);
        System.arraycopy(this.elementArrayList, 0, newArr, 0, index);

        if (this.elementArrayList.length - index >= 0) {
            System.arraycopy(this.elementArrayList, index, newArr, index
                    + c.length, this.elementArrayList.length - index);
        }

        ImmutableArrayList newArr1 = new ImmutableArrayList(newArr);
        return newArr1;
    }

    @Override
    public Object get(int index) {
        return this.elementArrayList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newElementArray = new Object[this.elementArrayList.length - 1];

        for (int i = 0, k = 0; i < this.elementArrayList.length; i++) {
            if (i == index) {
                continue;
            }
            newElementArray[k++] = this.elementArrayList[i];
        }
        ImmutableArrayList newElementArray1 = new ImmutableArrayList(newElementArray);
        return newElementArray1;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newElementArray = new Object[this.elementArrayList.length + 1];
        int k = 0;
        for (int i = 0; i < this.elementArrayList.length; i++) {
            if (i == index) {
                newElementArray[i] = e;
                i -= 1;
                index -= 2;
                k += 1;
                continue;
            }
            newElementArray[k] = this.elementArrayList[i];
            k += 1;
        }
        ImmutableArrayList newElementArray1 = new ImmutableArrayList(newElementArray);
        return newElementArray1;
    }

    @Override
    public int indexOf(Object e) {
        int index = -1;
        for (int i = 0; i < this.elementArrayList.length; i++) {
            if (this.elementArrayList[i].equals(e)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    @Override
    public int size() {
        return this.elementArrayList.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return (elementArrayList.length == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] newElementArray = Arrays.copyOf(this.elementArrayList, this.elementArrayList.length);
        return newElementArray;

    }

//    public static void main(String[] args) {
//        Object[] arr = {1, 2, 3, 4, 5};
//        ImmutableArrayList arr1 = new ImmutableArrayList(arr);
////        Object [] newarr = {6, 7, 8};
////        arr1.addAll(newarr);
//        arr1.set(2, 14);
//    }

    public static void main(String[] args){
        ;
    }
}
