public class Queue {

	int size;
	int[] array;

	int stackEnqueue;
	int stackDequeue;

	public Queue(int size) {
		this.size = size;
		this.array = new int[size];
		this.stackEnqueue = 0;
		this.stackDequeue = 0;
	}

	public int getSize() {
		return size;
	}

	public void printQueue() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public boolean enqueue(int value) {
		if (stackEnqueue == stackDequeue && array[stackEnqueue + 1] != 0) {
			System.out.println("Queue is full!");
			return false;
		}

		array[stackEnqueue] = value;
		stackEnqueue += 1;

		if (stackEnqueue == size) {
			stackEnqueue = 0;
		}
		printQueue();
		return true;
	}

	public int dequeue() {
		if (stackEnqueue == stackDequeue && array[stackEnqueue + 1] == 0) {
			System.out.println("Queue is empty!");
			return 0;
		}

		int poppedValue = array[stackDequeue];
		array[stackDequeue] = 0;
		stackDequeue += 1;

		if (stackDequeue == size) {
			stackDequeue = 0;
		}

		printQueue();
		return poppedValue;
	}

	public boolean isEmpty() {
		if (stackEnqueue != stackDequeue) {
			return false;
		} else if (stackEnqueue == stackDequeue && array[size - 1] != 0) {
			return false;
		} else {
			return true;
		}
	}

	public void decreaseStackEnqueue() {
		stackEnqueue = stackEnqueue - 1;
	}
	public void resetZero() {
		stackEnqueue = 0;
		stackDequeue = 0;
	}

	public int getStackEnqueue(int offset) {
		int rez;
		if (stackEnqueue - offset < 0) {
			rez = size - 1;
		} else {
			rez = stackEnqueue;
		}
		return rez;
	}

	public int getStackDequeue() {
		return stackDequeue;
	}
}