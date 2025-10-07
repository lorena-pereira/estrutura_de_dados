package com.estruturas_de_dados;

public interface Stackable<T> {
    //métodos principais
    T pop();
    void push(T data);
    void update(T newData);
    T peek();

    //métodos auxiliares
    boolean isEmpty();
    boolean isFull();
    String print();
}
