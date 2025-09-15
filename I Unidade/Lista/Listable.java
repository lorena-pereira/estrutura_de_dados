public interface Listable {

    // Create
    void insert(Object data, int LogicIndex);
    void append(Object data);

    // Read
    Object select(int LogicIndex);
    Object[] selectAll();

    // Update
    void update(Object data, int LogicIndex);
    
    // Delete
    Object delete(int LogicIndex);
    void clear();

    boolean isEmpty();
    boolean isFull();
    String print();
}