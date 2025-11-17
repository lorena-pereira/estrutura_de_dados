import java.util.NoSuchElementException;

/**
 * Implementação de uma Pilha Dinâmica 
 * 
 * @param <T> o tipo de elementos armazenados na Pilha
 * 
 * @author Lorena Pereira Oliveira
 * @version 1.0
 */

public class LinkedStack<T> implements Stackable<T>{
    /** Aponta para o topo da pilha*/
    private DoubleNode<T> topPointer;
    /**Indica o número atual de dados da pilha*/
    private int numberElements; 
    /**Indica o número máximo de elementos que a pilha pode ter*/
    private int maxElements;

    /** Construtor com o máximo de elementos com 10 */
    public LinkedStack() {
        this(10);
    }
    
    public LinkedStack(int maxElements){
        this.topPointer = null;
        this.numberElements = 0;
        this.maxElements = maxElements ;
    }

    @Override
    public void push(T data) {
        if(isFull()) {
            throw new NoSuchElementException("Stack is full!");
        }
        DoubleNode<T> newNode = new DoubleNode<T>();
        newNode.setData(data);
        newNode.setPrevious(topPointer);
        if(! isEmpty()) {
            topPointer.setNext(newNode);
        }
        topPointer = newNode;
        numberElements++;
    }

    /**
	 * Remove e retorna o elemento do topo da pilha.
	 *
	 * @return o elemento removido do topo
	 * @throws NoSuchElementException se a pilha estiver vazia
	 */
    @Override
    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
       
        T auxData = topPointer.getData();
        if (topPointer.getPrevious() == null) {
            topPointer = null;
        } else {
            topPointer = topPointer.getPrevious();
            topPointer.setNext(null);
        }
        
        numberElements--;
        return auxData;
    }

    /**
	 * Retorna o elemento do topo da pilha sem removê-lo.
	 *
	 * @return o elemento do topo
	 * @throws NoSuchElementException se a pilha estiver vazia
	 */
    @Override
    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        return topPointer.getData();
    }

    /**
     * Atualizar na pilha
     *
     * @param newData, novo dado a ser inserido
     * @throws NoSuchElementException, quando a pilha está vazia
     */
    @Override
    public void update(Object newData) {
        if(isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        topPointer.setData(newData);
    }


    /**
     * Verifica se a Pilha está cheia
     *
     * @return retorna True se a pilha estiver cheia
     */
    @Override
    public boolean isFull() {
        return numberElements == maxElements;
    }

    /**
     * Verifica se a Pilha está vazia
     *
     * @return retorna True se a pilha estiver vazia
     */
    @Override
    public boolean isEmpty() {
        return numberElements == 0;
    }

    /**
	 * Retorna uma representação em string da pilha.
	 * Os elementos são separados por vírgula e delimitados por colchetes.
	 * @return string representando a pilha
	 */
    @Override
    public String print() {
        String result = "";
        DoubleNode<T> auxPointer= topPointer;
        //iterar os elementos da minha pilha
        for(int i = 0; i < numberElements; i++) {
            result += topPointer.getData();
            auxPointer = auxPointer.getPrevious();
            if(i != numberElements - 1) {
                result += ",";
            }
        }
        return "[" + result + "]";
    }
}