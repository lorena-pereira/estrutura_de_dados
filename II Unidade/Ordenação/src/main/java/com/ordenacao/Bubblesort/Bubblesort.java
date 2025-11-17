package com.ordenacao.Bubblesort;

/**
 * Classe que implementa o algoritmo de ordenação Bubble Sort de forma dinâmica.
 * Utiliza uma estrutura de Lista Duplamente Encadeada para armazenar os dados.
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @see DoubleNode
 * @see Sortable
 */
public class Bubblesort implements Sortable {
    private DoubleNode head;
    private DoubleNode tail;
    private int quantity;

    /**
     * Construtor padrão. Inicializa a lista vazia.
     */
    public Bubblesort() {
        this.quantity = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Adiciona um novo elemento ao final da lista duplamente encadeada.
     * Complexidade: O(1) - pois temos o ponteiro para o fim.
     * * @param data O objeto a ser armazenado no nó.
     */
    public void append(Object data) {
        DoubleNode tempNode = new DoubleNode();
        tempNode.setData(data);

        if (quantity == 0) {
            head = tempNode;
        } else {
            tail.setNext(tempNode);
            tempNode.setPrevious(tail);
        }
        tail = tempNode;
        quantity++;
    }

    /**
     * Executa o algoritmo Bubble Sort para ordenar a lista.
     * A ordenação é feita trocando o conteúdo dos nós, não os nós em si.
     * Este método assume que os objetos armazenados são do tipo Integer.
     * Complexidade de Tempo: O(N^2)
     */
    @Override
    public void sort() {
        for (int i = 0; i < (quantity - 1); i++) {
            
            DoubleNode current = head;
            DoubleNode next = current.getNext();

            for (int j = 0; j < (quantity - 1) - i; j++) {
                if ((Integer) current.getdata() > (Integer) next.getData()) {
                    swap(current, next);
                }
                current = current.getNext();
                next = current.getNext(); 
            }
        }
    }

    /**
     * Método auxiliar para trocar o conteúdo de dois nós.
     * Não altera os ponteiros 'previous' e 'next', apenas o 'data'.
     * * @param a Primeiro nó.
     * @param b Segundo nó.
     */
    private void swap(DoubleNode a, DoubleNode b) {
        Object aux = a.getData();
        a.setData(b.getData());
        b.setData(aux);
    }

    /**
     * Percorre a lista do início ao fim e retorna uma representação em String.
     * * @return String contendo todos os elementos da lista.
     */
    @Override
    public String print() {
        String result = "[";
        DoubleNode auxPointer = head;

        for (int i = 0; i < quantity; i++) {
            if (i == quantity - 1) {
                result += auxPointer.getData();
            } else {
                result += auxPointer.getData() + ",";
            }
            auxPointer = auxPointer.getNext();
        }
        return result + "]";
    }
}
