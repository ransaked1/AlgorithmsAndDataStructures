public class StackQueue {

  int size;
  Queue queue1;
  Queue queue2;

  public StackQueue(int size) {
    this.size = size;
    queue1 = new Queue(size);
    queue2 = new Queue(size);
  }

  public int getSize() {
    return size;
  }

  public void printStack() {
    System.out.println();
    System.out.println("------------ Stack state --------------");
    queue1.printQueue();
    queue2.printQueue();
    System.out.println("----------------------------------------");
    System.out.println();
  }

  // Because I use the previous queue implementation it will print that both the queue and stack is
  // full. Fixable by using an abstract class for different implementations or an argument to
  // silence the message.
  public boolean push(int value) {
    if (queue1.isEmpty() && queue2.isEmpty()) {
      if (!queue1.enqueue(value)) {
        System.out.println("Stack is full!");
        return false;
      }
      printStack();
      return true;
    } else if (queue1.isEmpty()) {
      if (!queue2.enqueue(value)) {
        System.out.println("Stack is full!");
        return false;
      }
      printStack();
      return true;
    } else {
      if (!queue1.enqueue(value)) {
        System.out.println("Stack is full!");
        return false;
      }
      printStack();
      return true;
    }
  }

  // God please forgive this broken implementation. You get the idea lol.
  public int pop() {
    if (queue1.isEmpty() && queue2.isEmpty()) {
      System.out.println("Stack is empty!");
      return 0;
    } else if (queue1.isEmpty()) {
      while (queue2.getStackDequeue() < queue2.getStackEnqueue(1) - 1) {
        queue1.enqueue(queue2.dequeue());
      }
      int last = queue2.dequeue();
      queue2.resetZero();
      printStack();
      return last;
    } else {
      while (queue1.getStackDequeue() < queue1.getStackEnqueue(1)) {
        queue2.enqueue(queue1.dequeue());
      }
      int last = queue1.dequeue();
      queue1.resetZero();
      printStack();
      return last;
    }
  }
}
