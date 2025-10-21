package com.dao.repository;

/**
 * Interface que define as operações básicas de uma fila genérica
 *
 * @param <T> o tipo dos elementos armazenados na fila
 * @author Lorena Pereira Oliviera
 * @version 1.0
 * @since 20/10/2025
 */
public interface Stackable<T> {
	
	/**
	 * Adiciona um elemento ao início da fila
	 */
	void beginEnqueue(T dado);
	
	/**
	 * Adiciona um elemento ao final da fila
	 */
	void endEnqueue(T dado);
	
	/**
	 * Retorna o elemento do início da fila sem removê-lo
	 */
	T front();
	
	/**
	 * Retorna o elemento do final da fila sem removê-lo
	 */
	T rear();
	
	/**
	 * Remove e retorna o elemento do início da fila
	 */
	T beginDequeue();
	
	/**
	 * Remove e retorna o elemento do final da fila
	 */
	T endDequeue();
	
	/**
	 * Verifica se a fila está cheia
	 */
	boolean isFull();
	
	/**
	 * Verifica se a fila está vazia
	 */
	boolean isEmpty();
	
	/**
	 * Retorna uma representação em string da fila do final para o início
	 */
	String printFrontToRear();
	
	/**
	 * Retorna uma representação em string da fila do início para o final
	 */
	String printRearToFront();
}
