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

  // método auxiliar que verifica se a pilha está vazia
  public boolean isEmpty() {
    return (pointerTop == -1);
  }

  // método auxiliar que verifica se a pilha está cheia
  public boolean isFull() {
    return (pointerTop == data.length - 1);
  }


  // Aula 02 -> 25/08/2025

  // adiciona um novo dado no topo
  @Override
  public void push (Object data) {
    if (!isFull()) {
      pointerTop++;
      this.data[pointerTop] = data;
    }
    else {
      System.err.println("Stack is full");
    }
  }

  // retorna o dado do topo sem removê-lo
  @Override
  public Object peek () {
    if (isEmpty()) {
      System.out.println ("Stack is empty");
    }
    else {
      return data[pointerTop];
    }
    return null;
  }

  @Override
  public Object pop () {
    Object temp = null;
    if (isEmpty()) {
      System.out.println("Stack is empty");
    }
    else {
      temp = data[pointerTop];
      pointerTop--;
    }
    return temp;
  }
  
  @Override
  public String print() {
		String resultado = "[";
		for(int i = pointerTop; i >= 0; i++) {
			if (i == 0) {
				resultado += data[i];
			}
			else {
				resultado += data[i] + ",";
			}
		}
		return resultado + "]";
	}


}


