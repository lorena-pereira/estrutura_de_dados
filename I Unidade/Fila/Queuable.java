public interface Queuable {
    void enqueue(Object data);
    Object dequeue();
    Object front();

    boolean isEmpty();
    boolean isFull();
    String print();
    
}