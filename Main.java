public class Main {
  public static void main(String[] args) {
    // ArrayStackDemo();
    // ArrayQueueDemo();
    // QueueWithStackDemo();
    // StackWithQueuesDemo();

    Node start = setupLinkedList();
    printLinkedList(start);
    start = removeNode(5, start);
    printLinkedList(start);
    start = addNode(0, 3, start);
    printLinkedList(start);
    start = reverseList(start);
  }

  private static Node setupLinkedList() {
    Node start = new Node(0);
    Node node1 = new Node(0);
    Node node2 = new Node(0);

    for (int i = 1; i <= 10; i++) {
      if (i == 1) {
        start = new Node(i);
        node1 = start;
      } else {
        node2 = new Node(i);
        node1.setNextNode(node2);
        node1 = node2;
      }
    }

    return start;
  }

  private static void printLinkedList(Node start) {
    Node index = start;
    while (index.getNextNode() != null) {
      index.print();
      index = index.getNextNode();
    }
    index.print();
    System.out.println();
  }

  private static Node removeNode(int value, Node start) {
    Node index = start;
    Node previous = index;
    if (index.getData() == value) {
      return index.getNextNode();
    } else {
      previous = index;
      index = index.getNextNode();
    }
    while (index.getNextNode() != null) {
      if (index.getData() == value) {
        previous.setNextNode(index.getNextNode());
        return start;
      } else {
        previous = index;
        index = index.getNextNode();
      }
    }
    return index;
  }

  // This is with simple linked lists. For double linked you will have to also update the pointers
  // for previous node.
  private static Node addNode(int value, int pos, Node start) {
    Node index1 = start;
    Node index2 = index1.getNextNode();

    if (pos == 1) {
      Node newNode = new Node(value);
      newNode.setNextNode(start);
      return newNode;
    }

    for (int i = 1; i < pos - 1; i++) {
      index1 = index1.getNextNode();
      index2 = index2.getNextNode();
    }

    Node newNode = new Node(value);
    index1.setNextNode(newNode);
    newNode.setNextNode(index2);

    return start;
  }

  private static void StackWithQueuesDemo() {
    StackQueue stackQueue = new StackQueue(10);

    System.out.println();
    System.out.println("<------- Stack with queues behaviour demo ------->");
    System.out.println("Pushing 11 values to stack until full");
    stackQueue.push(1);
    stackQueue.push(2);
    stackQueue.push(3);
    stackQueue.push(4);
    stackQueue.push(5);
    stackQueue.push(6);
    stackQueue.push(7);
    stackQueue.push(8);
    stackQueue.push(9);
    stackQueue.push(10);
    stackQueue.push(11);
    System.out.println();

    System.out.println("Popping 2 values from stack (broken if more than 2)");
    stackQueue.pop();
    stackQueue.pop();
    System.out.println();
  }

  private static void QueueWithStackDemo() {
    QueueStack queueStack = new QueueStack(10);
    System.out.println();
    System.out.println("<------- Queue using stacks behaviour demo ------->");
    System.out.println("Queuing 7 values to queue");
    queueStack.enqueue(1);
    queueStack.enqueue(2);
    queueStack.enqueue(3);
    queueStack.enqueue(4);
    queueStack.enqueue(5);
    queueStack.enqueue(6);
    queueStack.enqueue(7);
    System.out.println();

    System.out.println("Dequeing 3 values from queue");
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    System.out.println();

    System.out.println("Queuing values to until full");
    queueStack.enqueue(8);
    queueStack.enqueue(9);
    queueStack.enqueue(10);
    queueStack.enqueue(11);
    queueStack.enqueue(12);
    queueStack.enqueue(13);
    queueStack.enqueue(14);
    System.out.println();

    System.out.println("Dequeing values from queue until empty");
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
    queueStack.dequeue();
  }

  private static void ArrayQueueDemo() {
    Queue queue = new Queue(10);

    System.out.println();
    System.out.println("<------- Queue behaviour demo ------->");
    System.out.println("Queuing 7 values to queue");
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.enqueue(6);
    queue.enqueue(7);
    System.out.println();

    System.out.println("Dequeing 3 values from queue");
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    System.out.println();

    System.out.println("Queuing values to until full");
    queue.enqueue(8);
    queue.enqueue(9);
    queue.enqueue(10);
    queue.enqueue(11);
    queue.enqueue(12);
    queue.enqueue(13);
    queue.enqueue(14);
    System.out.println();

    System.out.println("Dequeing values from queue until empty");
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
  }

  private static void ArrayStackDemo() {
    Stack stack = new Stack(10);

    System.out.println();
    System.out.println("<------- Stack behaviour demo ------->");
    System.out.println("Pushing 7 values to stack1");
    stack.pushToStack(1, 2);
    stack.pushToStack(1, 3);
    stack.pushToStack(1, 4);
    stack.pushToStack(1, 5);
    stack.pushToStack(1, 6);
    stack.pushToStack(1, 7);
    stack.pushToStack(1, 8);
    System.out.println();

    System.out.println("Pushing 4 values to stack2 until array is full");
    stack.pushToStack(2, 3);
    stack.pushToStack(2, 2);
    stack.pushToStack(2, 1);
    stack.pushToStack(2, 9);
    System.out.println();

    System.out.println("Popping 3 values from stack1");
    stack.popFromStack(1);
    stack.popFromStack(1);
    stack.popFromStack(1);
    System.out.println();

    System.out.println("Popping 4 values from stack2 until it's empty");
    stack.popFromStack(2);
    stack.popFromStack(2);
    stack.popFromStack(2);
    stack.popFromStack(2);
    System.out.println();

    System.out.println("Popping 5 values from stack1 until it's empty");
    stack.popFromStack(1);
    stack.popFromStack(1);
    stack.popFromStack(1);
    stack.popFromStack(1);
    stack.popFromStack(1);
  }
}
