package com.dao.repository;

/**
 * Interface que define as operações básicas de uma lista dinâmica
 * Esta interface define os métodos que devem ser implementados por qualquer 
 * classe que represente uma estrutura de dados do tipo lista dinâmica
 *
 * @param <T> o tipo dos elementos armazenados na lista
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @since 27/10-/025
 */
public interface Listable<T> {
    /**
     * Adiciona um elemento no final da lista
     * 
     * @param data o elemento a ser adicionado
     */
    void append(T data);   
    
    /**
     * Adiciona um elemento em uma posição específica da lista,
     * deslocando os elementos subsequentes
     *
     * @param index o índice (posição) onde o elemento será inserido
     * @param data o elemento a ser inserido
     */
    void insert(int index, T data); 

    /**
     * Obtém o elemento em um índice específico da lista
     *
     * @param index o índice do elemento a ser recuperado
     */
    T select(int index);

    /**
     * Obtém todos os elementos da lista e os retorna em um array
     */
    T[] selectAll();    
      
    /**
     * Atualiza o elemento em uma posição específica da lista,
     * substituindo o valor antigo pelo novo
     *
     * @param index o índice do elemento a ser atualizado
     * @param data o novo elemento que substituirá o antigo
     */
    void update(int index, T data); 

    /**
     * Remove o elemento em uma posição específica da lista,
     * deslocando os elementos subsequentes
     *
     * @param index o índice do elemento a ser removido
     */
    T delete(int index);            

    /**
     * Remove todos os elementos da lista
     */
    void clear();                   

    /**
     * Retorna o número de elementos atualmente armazenados na lista
     */
    int size(); 

    /**
     * Verifica se a lista está vazia
     */
    boolean isEmpty(); 

    /**
     * Verifica se a lista está cheia
     */
    boolean isFull();           

    /**
     * Retorna uma representação em String de todos os elementos da lista
     */
    String print();         

}
