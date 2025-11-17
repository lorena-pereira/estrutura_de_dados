package com.ordenacao.Insertionsort;

/**
 * Implementação do algoritmo de ordenação Insertion Sort (Ordenação por Inserção)
 * aplicada sobre uma estrutura de Lista Duplamente Encadeada.
 * 
 * O Insertion Sort constrói a lista ordenada um elemento de cada vez, 
 * comparando o elemento atual com os anteriores e movendo-o para a posição correta.
 *
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @see DoubleNode
 * @see Sortable
 */
public class Insertionsortimplements Sortable {
    private DoubleNode head;
    private DoubleNode tail;
    private int quantity;

    /**
     * Construtor padrão.
     * Inicializa uma nova lista vazia.
     */
    public Insertionsort() {
        this.quantity = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Adiciona um novo elemento ao final da lista.
     * Complexidade de Tempo: O(1) - Inserção direta pelo ponteiro de fim.
     * * @param data O objeto a ser armazenado.
     */
    public void append(Object data) {
        DoubleNode tempNode = new DoubleNode();
        tempNode.setData(data);

        if (quantity == 0) {
            head = tempNode;
        } else {
            tail.setNext(tempNode);
        }
        
        tempNode.setPrevious(tail);
        tail = tempNode;
        quantity++;
    }

    /**
     * Ordena a lista utilizando o algoritmo Insertion Sort.
     * Percorre a lista a partir do segundo elemento (i=1).
     * Para cada elemento, verifica os antecessores (loop while); se o antecessor for maior,
     * realiza a troca e recua o ponteiro, "inserindo" o valor na posição ordenada correta.
     *
     * Complexidade de Tempo: 
     * Melhor caso (já ordenado): O(N)
     * Pior caso (inverso): O(N^2)
     */
    @Override
    public void sort() {
        DoubleNode indexI = head.getNext();

        for (int i = 1; i < quantity; i++) {
            DoubleNode indexJ = indexI;

            while (!(indexJ.equals(head)) && ((Integer) indexJ.getdata() < (Integer) (indexJ.getPrevious()).getdata())) {
                swap(indexJ, indexJ.getPrevious());
                indexJ = indexJ.getPrevious();
            }
            indexI = indexI.getNext();
        }
    }

    /**
     * Método auxiliar privado para trocar o conteúdo de dois nós.
     * Troca apenas os valores (data), mantendo as referências de memória dos nós intactas.
     * 
     * @param a O nó atual.
     * @param b O nó anterior (ou outro nó alvo).
     */
    private void swap(DoubleNode a, DoubleNode b) {
        Object aux = a.getdata();
        a.setData(b.getdata());
        b.setData(aux);
    }

    /**
     * Retorna uma representação textual da lista completa.
     *
     * * @return String contendo todos os dadoss da lista.
     */
    @Override
    public String print() {
        String result = "[";
        DoubleNode auxPointer = head;

        for (int i = 0; i < quantity; i++) {
            if (i == quantity - 1) {
                result += auxPointer.getdata();
            } else {
                result += auxPointer.getdata() + ",";
            }
            auxPointer = auxPointer.getNext();
        }
        return result + "]";
    }
}