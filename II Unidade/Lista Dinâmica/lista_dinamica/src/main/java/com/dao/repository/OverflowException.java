package com.dao.repository;

/**
 * Exceção lançada quando uma operação tenta inserir elementos em
 * uma estrutura de dados que já está cheia
 *
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @since 20/10/2025
 */
public class OverflowException extends RuntimeException {
	/**
	 * Construtor que cria uma exceção com a mensagem especificada
	 *
	 * @param mensagem a mensagem de erro
	 */
	public OverflowException(String mensagem) {
        super(mensagem);
    }
}
