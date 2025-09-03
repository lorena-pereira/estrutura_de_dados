public class CircleQueue implements Queuable {
  private Object[] data;
  private int head;
  private int tail;
  private int quantity;

  public CircleQueue(int length) {
    data = new Object[length];
    head = 0;
    tail = -1;
    quantity = 0;
  }

  @Override
  public boolean isEmpty() {
    return (quantity == 0);
  }

  @Override
  public boolean isFull() {
    return quantity == data.length;
  }

  @Override
  public void enqueue(Object data) {
    if (isFull()) {
      System.err.println("Queue is full!");
    } else {
      tail = next(tail);
      this.data[tail] = data;
      quantity++;
    }
  }

  @Override
  public Object dequeue() {
    Object aux = null;
    if (isEmpty()) {
      System.err.println("Queue is empty!");
    } else {
      aux= data[head];
      head = next(head);
      quantity--;
    }

    return aux;
  }

  private int next(int head) {
    return (head + 1) % data.length;
  }

  @Override
  public Object front() {
    Object aux = null;
    if (isEmpty()) {
      System.err.println("Queue is empty.");
    } else {
      aux = data[head];
    }

    return aux;
  }

  @Override
  public String print() {
    String result = "";
    int temp = head;
    for (int i = 0; i < quantity; i++) {
      result += data[temp];
      temp = next(temp);
      if (i != quantity - 1) {
        result += ", ";
      }
    }
    return "[" + result + "]";
  }
}
