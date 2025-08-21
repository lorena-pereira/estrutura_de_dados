public interface Stackable { // Interfaxe Stackable -> intenção de se comportar como uma pilha usando

    Object pop(); // desempilhar/retirar um dado no topo da pilha
    void push(Object data); // empilhar/inserir um dado no topo da pilha
    Object peek(); // "espiar"/ler o dado do topo na pilha

    boolean isFull(); // verifica se a pilha tá cheia, se o topo está na última posição do array
    boolean isEmpty(); // verifica se a pilha está vazia
    String print(); // exibe uma mensagem

}  

