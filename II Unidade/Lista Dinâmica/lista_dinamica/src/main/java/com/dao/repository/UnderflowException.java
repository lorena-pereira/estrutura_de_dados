package com.dao.repository;

/**
 * Exceção lançada quando uma operação tenta acessar ou remeover
 * elementos em uma estrutura de dados que está vazia
 *
 * @author Lorena Pereira Oliveira
 * @version 1.0
 * @since 20/10/2025
 */
public class UnderflowException extends RuntimeException {
    /**
	 * Construtor que cria uma exceção com a mensagem especificada
	 *
	 * @param mensagem a mensagem de erro
	 */
    public UnderflowException(String mensagem) {
        super(mensagem);
    }
}
