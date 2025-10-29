package com.dao.repository;

import java.util.NoSuchElementException;

/**
 * Implementação de uma Fila com dupla terminação dinâmica 
 * 
 * @param <T> o tipo de elementos armazenados na Fila
 * 
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @since 20/10/2025
 * @see DoubleNode
 * @see DEQuable
 */

public class LinkedDEqueue<T> {
    private int amount;
    private int capacity;
    private DoubleNode<T> head;
    private Double Node<T> tail;

    /** Construtor com o máximo de elementos com 10 */
    public LinkedDEqueue() {
        this(10);
    }

    /**
     * Construtor que cria uma fila com capacidade personalizada
     *
     * @param capacity a capacidade máxima da fila
     */
    public LinkedDEqueue(int capacity) {
        amount = 0;
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    /**
     * Adiciona um elemento ao início da fila
     *
     * @param dado o elemento a ser adicionado
     * @throws java.util.NoSuchElementException se a fila estiver cheia
     */
    @Override
    public void beginEnqueue(T data) {
        if (isFull()) {
            throw new NoSuchElementException("Queue is full!");
        }
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.setData(data);
        if (isEmpty()) {
            tail = newNode;
            head = newNode;
        }
        else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = head.getPrevious();
        }
        amount++;
    }

    /**
     * Adiciona um elemento ao final da fila
     *
     * @param dado o elemento a ser adicionado
     * @throws java.util.NoSuchElementException se a fila estiver cheia
    */
    @Override
    public void endEnqueue(T data) {
        if (isFull()) {
            throw new NoSuchElementException("Queue is full!");
        }
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.setData(data);
        if (isEmpty()) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        amount++;
    }

    /**
     * Remove e retorna o elemento do início da fila
     *
     * @return o elemento removido do início
     * @throws java.util.NoSuchElementException se a fila estiver vazia
     */
    @Override
    public T beginDequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        T auxData = head.getData();
        head = head.getNext();
        amount--;
        if (!isEmpty()) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        return auxData;
    }

    /**
     * Remove e retorna o elemento do final da fila
     *
     * @return o elemento removido do fim
     * @throws java.util.NoSuchElementException se a fila estiver vazia
     */
    @Override
    public T endDequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        amount--;
        T auxData = tail.getData();
        tail = tail.getPrevious();
        if (!isEmpty()) {
            tail.setNext(null);
        } else {
            head = null;
        }
        return auxData;
    }

    /**
     * Retorna o elemento do início da fila sem removê-lo
     *
     * @return o elemento do início
     * @throws java.util.NoSuchElementException se a fila estiver vazia
     */
    @Override
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }

        return head.getData();
    }

    /**
     * Retorna o elemento do final da fila sem removê-lo
     *
     * @throws java.util.NoSuchElementException se a fila estiver vazia
     */
    @Override
    public T rear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }

        return tail.getData();
    }

    /**
     * Verifica se a fila está cheia
     * 
     * @return true se a fila está cheia e false caso contrário
     */
    @Override
    public boolean isFull() {
        return amount == capacity;
    }

    /**
     * Verifica se a fila está vazia
     * 
     * @return true se a fila está vazia e false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    /**
	 * Retorna uma representação em string da fila do final para o início
	 *
	 * @return string representando a fila do final para o início
	 */
    public String printFrontToRear() {
        String result = "";
        DoubleNode<T> auxPointer = head;
        for(int i = 0; i < amount; i++) {
            result += auxPointer.getData();
            if(i != amount - 1) {
                result += ",";
            }
            auxPointer = auxPointer.getNext();    
        }
        return  "[]" + result + "]";
        
    }

    /**
	 * Retorna uma representação em string da fila do início para o final
	 *
	 * @return string representando a fila do início para o final
	 */
    public String printRearToFront() {
        String result = "";
        DoubleNode<T> auxPointer = tail;
        for(int i = 0; i < amount; i++) {
            result += auxPointer.getData();
            if(i != amount-1) {
                result += ",";
            }
            auxPointer = auxPointer.getPrevious();    
        }
        return  "[" + result + "]";
    }

}
