public class Main {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        System.out.println("Queue: " + queue.print());
        System.out.println("Front of queue: " + queue.front());

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Queue after remove: " + queue.print());

        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println("Final queue: " + queue.print());

        // Exemplo de CircleQueue
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.enqueue("1");
        circleQueue.enqueue("2");
        circleQueue.enqueue("3");

        System.out.println("CircleQueue: " + circleQueue.print());
        System.out.println("Front of CircleQueue: " + circleQueue.front());

        System.out.println("Removed from CircleQueue: " + circleQueue.dequeue());
        System.out.println("CircleQueue after remove: " + circleQueue.print());

        circleQueue.enqueue("4");
        circleQueue.enqueue("5");
        System.out.println("Final CircleQueue: " + circleQueue.print());

        // Exemplo de Dequeue
        Dequeue deq = new Dequeue(5);
        deq.beginEnqueue("A");
        deq.beginEnqueue("B");
        deq.endEnqueue("1");
        deq.endEnqueue("2");

        System.out.println("DEQueue front to rear: " + deq.printFrontToRear());
        System.out.println("DEQueue rear to front: " + deq.printRearToFront());
        System.out.println("Front element: " + deq.front());
        System.out.println("Rear element: " + deq.rear());

        System.out.println("Removed from front: " + deq.beginDequeue());
        System.out.println("Removed from rear: " + deq.endDequeue());
        System.out.println("DEQueue after removals (front to rear): " + deq.printFrontToRear());
        System.out.println("DEQueue after removals (rear to front): " + deq.printRearToFront());
    }
}