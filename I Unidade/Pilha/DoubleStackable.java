public interface DoubleStackable {
    
    //// Métodos principais
    Object peek1();
    void push1(Object data);
    Object pop1();

    Object peek2();
    void push2(Object data);
    Object pop2();

    // Métodos auxiliares
    boolean isFull1();
    boolean isEmpty1();
    String print1();

    boolean isFull2();
    boolean isEmpty2();
    String print2();
}
    
