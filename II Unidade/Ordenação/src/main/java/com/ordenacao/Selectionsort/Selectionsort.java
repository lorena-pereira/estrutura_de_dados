package com.ordenacao.Selectionsort;

/**
 * Implementação do algoritmo de ordenação Selection Sort (Ordenação por Seleção)
 * utilizando uma estrutura de Lista Duplamente Encadeada.
 * O algoritmo divide a lista em duas partes: a ordenada (esquerda) e a não ordenada (direita).
 * A cada iteração, ele busca o menor elemento da parte não ordenada e o move para o final da parte ordenada.
 *
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @see DoubleNode
 * @see Sortable
 */
public class Selectionsort implements Sortable {
    private DoubleNode head;
    private DoubleNode tail;
    private int quantity;

    /**
     * Construtor padrão.
     * Inicializa a lista vazia.
     */
    public Selectionsort() {
        this.quantity = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * Adiciona um novo elemento ao final da lista.
     * Complexidade: O(1).
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
     * Executa a ordenação utilizando o Selection Sort.
     * O loop externo define a posição atual (indexI) que deve receber o menor valor restante.
     * O loop interno percorre o restante da lista para encontrar o nó com o menor valor (minor).
     * Ao final do loop interno, troca o conteúdo do nó atual com o nó do menor valor encontrado.
     * 
     * Complexidade de Tempo: O(N²) em todos os casos (melhor, médio e pior),
     * pois ele sempre percorre o restante da lista para garantir que encontrou o mínimo.
     */
    @Override
    public void swap() {
        DoubleNode indexI = head;

        for (int i = 0; i < quantity; i++) {
            DoubleNode minor = indexI;
            DoubleNode indexJ = indexI.getNext();

            for (int j = i + 1; j < quantity; j++) {
                if ((Integer) indexJ.getData() < (Integer) minor.getData()) {
                    minor = indexJ; 
                }
                indexJ = indexJ.getNext();
            }
            swap(indexI, minor);
            
            indexI = indexI.getNext();
        }
    }

    /**
     * Método auxiliar para trocar o conteúdo (data) de dois nós.
     * 
     * @param a O nó que receberá o valor de b.
     * @param b O nó que receberá o valor de a.
     */
    private void swap(DoubleNode a, DoubleNode b) {
        Object aux = a.getData();
        a.setData(b.getData());
        b.setData(aux);
    }

    /**
     * Retorna a representação da lista em formato de String.
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
