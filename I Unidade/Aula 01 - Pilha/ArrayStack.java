//Aula 1 -> 19/08/2025

public class ArrayStack implements Stackable {
  private Object[] data; // array para armazenar os elementos da pilha
  private int pointerTop; // índice do topo da pilha

  // construtor padrão que chama outro construtor inicializando a pilha com tamanho 10
  public ArrayStack(){
    this(10);
}
  //construtor para definir o tamanho da pilha
  public ArrayStack(int length) {
    data = new Object[length];
    pointerTop = -1; // indica a posição do 0, ou seja, a pilha está vazia
  }

  // verifica se a pilha está vazia
  boolean isEmpty() {
    return pointerTop == -1;
  }

  // verifica se a pilha está cheia
  boolean isFull() {
    return pointerTop == data.length - 1;
  }

  // remove e retorna o dado do topo
  void pop (Object data) {
    if (!isEmpty()) {
      // posso desempilhar
    }
  }

  // adiciona um novo dado no topo
  void push (Object data) {
    if (!isFull()) {
      // posso empilhar
    }
  }

  // retorna o dado do topo sem removê-lo
  Object peek () {
    if (!isEmpty()) {
      return data[pointerTop];
    }
    return null;
  }
}


