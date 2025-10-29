package com.dao.repository;
/**
 * Classe que representa uma lista dinâmica duplamente encadeada
 *
 * @param <T> o tipo do dado armazenado na lista
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @since 20/10/2025
 * @see DoubleNode
 * @see Listabel
 */

public class LinkedList<T> implements Listable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int capacity;
    private int amount;

    /**
	 * Construtor padrão que cria uma lista com capacidade para 10 elementos
	 */
    public LinkedList() {
        this(10);
    }

    /**
	 * Construtor que cria uma lista com capacidade personalizada
	 *
	 * @param capacity a capacidade máxima da lista
	 */
    public LinkedList(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        amount = 0;    
    }

    /**
	 * Adiciona um elemento no final da lista
	 *
	 * @param data o elemento a ser adicionado
	 * @throws OverflowException se a lista estiver cheia
	 */
    @Override
    public void append(T data) {
        if(isFull()) {
            throw new OverflowException("List is Full!");
        }
        DoubleNode<T> newData = new DoubleNode<T>(data);
        if(!isEmpty()) {
            tail.setNext(newData);
            newData.setPrevious(tail);
        }
        else {
            head = newData;
        }
        tail = newData;
        amount++;
    } 
    
    /**
	 * Adiciona elemento em posição específica
	 *
	 * @param index a posição onde o elemento será inserido
	 * @param data o elemento a ser adicionado
	 * @throws OverflowException se a lista estiver cheia
	 * @throws IndexOutOfBoundsException se o índice for inválido
	 */
    @Override
    public void insert(int index, T data) {
        if(isFull()) {
            throw new OverflowException("List is Full!");
        }
        if(index < 0 || index > amount) {
             throw new IndexOutOfBoundsException("Invalid Index!");
        }
        if(index == amount) {
            append(data);
        } 
        else if (index == 0) {
            DoubleNode<T> newData = new DoubleNode<T>(data);
            if(head != null) {
                head.setPrevious(newData);
            }
            head = newData;
            if(tail == null) {
                tail = newData;
            }
            amount++;
        } 
        else {
            DoubleNode<T> aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            DoubleNode<T> proximo = aux.getNext();
            DoubleNode<T> newData = new DoubleNode<T>(data);
            aux.setNext(newData);
            if(proximo != null) {
                proximo.setPrevious(newData);
            }
            amount++;
        }
    }

    /**
	 * Obtém um elemento por índice
	 *
	 * @param index o índice do elemento
	 * @return o elemento na posição especificada
	 * @throws IndexOutOfBoundsException se o índice for inválido
	 * @throws UnderflowException se a lista estiver vazia
	 */
    @Override
    public T select(int index) {
        T data = null;
        if(isEmpty()) {
            throw new UnderflowException("List is Empty!");
        }
        if(index < 0 || index >= amount) {
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        DoubleNode<T> aux = head;
        int meio = amount / 2;
        if(index <= meio) {
            aux = getNodeAt(index);
        }
        else {
            aux = getNodeAtbyEnd(index);
        }
        data = aux.getData();
        return data;
    }          
    
    /**
	 * Obtém todos os elementos da lista como um array
	 *
	 * @return array com todos os elementos da lista
	 */
    @Override
    public T[] selectAll() {
        if(isEmpty()) {
			return (T[]) new Object[0];
		}
        T[] temp = (T[]) new Object[amount]; 
        DoubleNode<T> aux = head;
        for(int i = 0; i < amount; i++) {
            temp[i] = aux.getData();
            aux = aux.getNext();
        }
        return (T[]) temp;
    }
    
    /**
	 * Atualiza um elemento em uma posição específica
	 *
	 * @param index a posição do elemento a ser atualizado
	 * @param data o novo elemento
     * @throws UnderflowException se a lista estiver vazia
	 * @throws IndexOutOfBoundsException se o índice for inválido
	 */
    @Override
    public void update(int index, T data) {
        if(isEmpty()) {
            throw new UnderflowException("List is Empty!");
        }
        if(index < 0 || index >= amount) {
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        DoubleNode<T> aux;
        int meio = amount / 2;
        if(index <= meio) {
            aux = getNodeAt(index);
        }
        else {
            aux = getNodeAtbyEnd(index);
            
        }
        aux.setData(data);
    }

    /**
	 * Remove um elemento por índice
	 *
	 * @param index o índice do elemento a ser removido
	 * @return o elemento removido
	 * @throws IndexOutOfBoundsException se o índice for inválido
	 * @throws UnderflowException se a lista estiver vazia
	 */
    @Override
    public T delete(int index) {
        if(isEmpty()) {
            throw new UnderflowException("List is Empty!");
        }
        if(index < 0 || index >= amount) {
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        DoubleNode<T> aux = null;
        int meio = amount / 2;
        if(index <= meio) {
            aux = getNodeAt(index);
        }
        else {
            aux = getNodeAtbyEnd(index);
        }
        
        T data = aux.getData();
        DoubleNode<T> anterior = aux.getPrevious();
        DoubleNode<T> proximo = aux.getNext();
        if(anterior != null) {
            anterior.setNext(proximo);
        }
        else {
            head = head.getNext();
        }
        if(proximo != null) {
            proximo.setPrevious(anterior);
        }
        else {
            tail = tail.getPrevious();
        }
        amount--;
        return aux.getData();
    }

    /**
	 * Limpa toda a lista
	 */
    @Override
    public void clear() {
        head = null;
        tail = null;
        amount = 0;    
    }

    /**
	 * Retorna o tamanho da lista
	 *
	 * @return o número de elementos na lista
	 */
    @Override
    public int size() {
        return amount;
    }   
    
    /**
	 * Verifica se a lista está vazia
	 *
	 * @return true se a lista estiver vazia, false caso contrário
	 */
    @Override
    public boolean isEmpty() {
        return amount == 0;
    }

    /**
	 * Verifica se a lista está cheia
	 *
	 * @return true se a lista estiver cheia, false caso contrário
	 */
    @Override
    public boolean isFull() {
        return (amount == capacity);
    }           

    /**
	 * Retorna uma representação em string da lista
	 * Os elementos são separados por vírgula e delimitados por colchetes
	 *
	 * @return string representando a lista
	 */
    @Override
    public String print() {
        String result = "";
        DoubleNode<T> aux = head;
        for(int i = 0; i < amount; i++) {
                result += aux.getData().toString();
            if(i != amount - 1) {
                result += ",";
            }
            aux = aux.getNext();
        }
        return "[" + result + "]";
    }

    /**
     * Método auxiliar privado para obter o nó em um índice específico,
     * percorrendo a partir do início (head)
     *
     * @param index o índice do nó
     * @return o DoubleNode na posição especificada
     */
    private DoubleNode<T> getNodeAt(int index) {
        DoubleNode<T> aux = head;
        for(int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux;
    }

    /**
     * Método auxiliar privado para obter o nó em um índice específico,
     * percorrendo a partir do fim (tail)
     *
     * @param index o índice do nó
     * @return o DoubleNode na posição especificada
     */
    private DoubleNode<T> getNodeAtbyEnd(int index) {
        DoubleNode<T> aux = tail;
        for(int i = amount - 1; i > index; i--) {
            aux = aux.getPrevious();
        }
        return aux;
    }

}