package impl;

public interface List<E> {
    /** appends the specified element at the end of a list */
    void add(E element);

    /** inserts the specified element at the specified position in a list */
    void add(E element, int index);

    /** fetches the element from the particular position of the list */
    E get(int index);

    /** appends all the elements in the specified collection to the end of this list */
    void addAll(List<E> list);

    /** removes the element present at the specified position in the list */
    E remove(int index);

    /** removes the first occurrence of the specified element */
    E remove(E element);

    /** returns the number of elements present in the list */
    int size();

    /** returns true if the list is empty, otherwise false */
    boolean isEmpty();
}
