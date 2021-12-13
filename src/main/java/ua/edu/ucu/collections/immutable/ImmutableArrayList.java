package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] arraylist;

    public ImmutableArrayList(Object[] elements) {
        this.arraylist = elements.clone();
    }

    public ImmutableArrayList() {
        this.arraylist = new Object[]{};
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(arraylist.length - 1, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(arraylist.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArray = new Object[arraylist.length + c.length];

        if (index >= 0) System.arraycopy(arraylist, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        if (arraylist.length - index >= 0)
            System.arraycopy(arraylist, index, newArray, index + c.length, arraylist.length - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        return arraylist[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArray = new Object[arraylist.length - 1];
        for (int i = 0; i < arraylist.length; i++) {
            if (i < index) {
                newArray[i] = arraylist[i];
            } else if (i > index){
                newArray[i-1] = arraylist[i];
            }
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArray = new Object[arraylist.length];
        System.arraycopy(arraylist, 0, newArray, 0, arraylist.length);
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }

    @Override
    public int indexOf(Object e) {
        int idx = -1;
        for (int i = 0; i < arraylist.length; i++) {
            if (arraylist[i] == e){
                idx = i;
                break;
            }
        }
        return idx;
    }

    @Override
    public int size() {
        return arraylist.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return arraylist.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[arraylist.length];
        System.arraycopy(arraylist, 0, newArray, 0, arraylist.length);
        return newArray;
    }
}
