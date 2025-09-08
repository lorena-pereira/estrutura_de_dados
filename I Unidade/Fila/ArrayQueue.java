public class ArrayQueue implements Queuable {
    private Object[] data;
    private int head;
    private int tail;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int length) {
        this.data = new Object[length];
        head = 0;
        tail = -1;
    }

    @Override
    public void enqueue (Object data) {
        if(isFull()) {
            System.err.println("Queue is full!");
        }
        else {
            tail++;
            this.data[tail] = data;;
        }
    }
    
    @Override
    public Object dequeue() {
        Object aux = null;
        if(isEmpty()) {
            System.err.println("Queue is empty!");
        }
        else {
            aux = data[head++];
        }
        return aux;
    }

    @Override
    public Object front() {
        Object aux = null;
        if(isEmpty()) {
            System.err.println("Queue is empty");
        }
        else {
            aux = data[head];
        }
        return aux;
    }

    @Override
    public boolean isEmpty() {
        return (head - 1 == tail);
    }

    @Override
    public boolean isFull() {
        return (tail == data.length - 1);
    }

    public String print() {
		String resultado = "";
		for(int i = head; i <= tail; i++) {
			resultado += data[i];
            if (i != tail) {
				resultado += ",";
			}
		}
		return resultado + "[ " + resultado + "]";
	}

    
}
