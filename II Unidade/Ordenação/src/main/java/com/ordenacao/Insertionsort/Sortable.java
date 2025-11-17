package com.ordenacao.Insertionsort;

/**
 * Interface que define o contrato para estruturas de dados que podem ser ordenadas.
 * Qualquer classe que implemente esta interface deve fornecer a lógica para
 * ordenação, troca de elementos e impressão dos dados.
 * @author Lorena Pereira Oliveira
 * @version 1.0
 */
public interface Ordenavel {
    void append();
	void sort();
    void swap();
	String imprimir();
}
