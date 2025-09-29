public class MaxBinaryTreeHeap implements Queueable {
    private int tail;
    private Object[] data;

    public MaxBinaryTreeHeap() {
        this(15);
    }

    public MaxBinaryTreeHeap(int length) {
        tail = -1;
        data =  new Object[length];
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }

    private int leftChild(int parent) {
        return (parent * 2 + 1);
    }

    private int rightChild(int parent) {
        return (parent * 2 + 1) + 1;
    }

    @Override
    public boolean isEmpty() {
        return (tail == -1);
    }

    @Override
    public boolean isFull() {
        return tail == data.length - 1;
    }

    @Override
    public Object front() {
        Object temp = null;
        if(isEmpty()) {
            System.err.println("Heap is empty!");
        }
        else {
            temp = data[0];
        }
        return temp;    
    }

    @Override
    public void enqueue(Object data) {
        if(isFull()) {
            System.err.println("Heap is full!");
        }
        else {
            tail++;
            this.data[tail] = data;
            heapifyUp(tail);
        }    
    }
    
    @Override
    public Object dequeue() {
        Object temp = null;
        if (isEmpty()) {
            System.out.println("Heap is Empty!");
        }
        else {
            temp = data[0];
            data[0] = data[tail];
            tail--;
            heapifyDown(0);
        }

        return temp;
    }

    @Override
    public String print() {
        String result = "";
        for (int i = 0; i <= tail; i++) {
            result += data[i];
            if (i != tail) {
                result += ", ";
            }     
        }   
        return "[" + result + "]";
    }

    private void swap(int index1, int index2) {
        Object temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private void heapifyUp(int index) {
        int temp = parent(index);
        while (index > 0 && (Integer) data[index] > (Integer) data[temp]) {
            swap(index, temp);
            index = temp;
            temp = parent(index);
        }
    }

    private void heapifyDown(int index) {
        boolean ajustado = false;
        while (!ajustado) {
            int left = leftChild(index);
            int right = rightChild(index);
            int maior = index;
            if((Integer) data[left] > (Integer) data[maior] && left <= tail) {
                maior = left;
            }
            if ((Integer) data[left] > (Integer) data[maior] && right <= tail) {
                maior = right;
            }
            if (maior != index) {
                swap(maior, index);
                index = maior;
            }
            else {
                ajustado = true;
            }
        }
    }

    public long ajustePrioridade(int prioridadeInicial) {
        long hour = System.currentTimeMillis();
        long novaPrioridade = 99_999_999_999_999L - hour;
        return prioridadeInicial * 100_000_000_000_000L + novaPrioridade;
    }

}