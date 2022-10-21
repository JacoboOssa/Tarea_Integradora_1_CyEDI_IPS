package model.Implementations;
public class Node<T> {
    private int value;
    private T element;

    public Node(int priorityValue, T element) {
        this.value = priorityValue;
        this.element = element;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
