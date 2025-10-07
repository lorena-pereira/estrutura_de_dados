public class DoubleNode<T> { //<T> genérico só armazena o tipo de dado permitido
    T data;
    DoubleNode<T> next;
    DoubleNode<T> previous;

    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }


    //getters e setters
    public T getData() {
        return data;
    }
    public DoubleNode<T> getNext() {
        return next;
    }
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setData(T data) {
        this.data = data; 
    }
    public void setNext(DoubleNode<T> next) {
        this.next = next; 
    }
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous; 
    }
}
