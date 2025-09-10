public class ArrayList implements Listable {
    private Object[] data;
    private int head;
    private int tail;
    private int numberElements;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int length) {
        data = new Object[length];
        head = 0;
        tail = -1;
        numberElements = 0;
    }

    @Override
    public boolean isEmpty() {
        return (numberElements == 0);
    }

    @Override
    public boolean isFull() {
        return (numberElements == data.length);
    }

    @Override
    public String print() {
        String result = "";
        int aux = head;
        for (int i = 0; i < numberElements; i++) {
            result += data[aux];
            if (i != numberElements - 1) {
                result += ",";
            }
            aux = next(aux);
        }
        return "[" + result + "]";
    }

    list.select(2);
    list.select(7);
    @Override
    public Object select(int LogicIndex) {
        if (isEmpty()) {
            System.err.println("List is empty!");
        }
        if (LogicIndex < 0 || LogicIndex > numberElements - 1) {
            System.err.println("Invalid Index!");
        }
        int PhysicIndex = map(LogicIndex);

    }

    private int map(int index) {
        (head + index);
    }

    @Override
    public void clear() {
        head = 0;
        tail = -1;
        numberElements = 0;
    }

    private int prior(int index) {
        return (index - 1 + % data.length) % data.length;
    }

    private int next(int index) {
        return (index + 1) % data.length; 
    }
}
