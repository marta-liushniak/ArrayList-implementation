package impl;

import java.util.NoSuchElementException;

public class CustomArrayList<E> implements List<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_RATE = 1.5;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];

    @Override
    public void add(E element) {
        grow();
        elements[size] = element;
        size++;
    }

    @Override
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException("Index " + index
                    + " is out of range.");
        }
        grow();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public void addAll(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        E removedElement = elements[index];
        if (index != elements.length - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        } else {
            elements[index] = null;
        }
        size--;
        return removedElement;
    }

    @Override
    public E remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element == null && elements[i] == null
                || elements[i] != null
                    && elements[i].equals(element)) {
                return remove(i);
            }
        }
        throw new NoSuchElementException("There is no element " + element);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        if (elements.length == size) {
            E[] newArray = (E[]) new Object[(int) (size() * GROWTH_RATE)];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("Index " + index
                    + " is out of range.");
        }
    }
}
