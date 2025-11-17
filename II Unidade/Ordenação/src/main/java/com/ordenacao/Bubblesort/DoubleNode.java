package com.ordenacao.Bubblesort;


/**
 * Classe que representa um nó duplamente encadeado
 *
 * @param <T> o tipo do dado armazenado no nó
 * @author Lorena Pereira Oliveira
 * @version 1.0
 */

public class DoubleNode<T> { 
    T data;
    DoubleNode<T> next;
    DoubleNode<T> previous;

    /**
	 * Já cria um nó com o dado
	 *
	 * @param data o dado a ser armazenado no nó
	 */
    public DoubleNode(T data) {
        this.data = data;
    }

    /**
	 * Construtor completo
	 */
    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    //getters e setters

    /**
	 * Retorna o dado armazenado no nó
	 *
	 * @return o dado do nó
	 */
    public T getData() {
        return data;
    }

    /**
	 * Retorna a referência para o próximo nó
	 *
	 * @return o próximo nó
	 */
    public DoubleNode<T> getNext() {
        return next;
    }

     /**
	 * Retorna a referência para o nó anterior
	 *
	 * @return o nó anterior
	 */
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    /**
	 * Define o dado a ser armazenado no nó
	 *
	 * @param data o novo dado
	 */
    public void setData(T data) {
        this.data = data; 
    }

    /**
	 * Define a referência para o próximo nó
	 *
	 * @param next o novo próximo nó
	 */
    public void setNext(DoubleNode<T> next) {
        this.next = next; 
    }

    /**
	 * Define a referência para o nó anterior
	 *
	 * @param previous o novo nó anterior
	 */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous; 
    }
}
