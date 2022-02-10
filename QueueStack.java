public class QueueStack {

	int size;
	int[] array;

	int stackPosition1;
	int stackPosition2;

	public QueueStack(int size) {
		this.size = size * 2;
		this.array = new int[size * 2];
		this.stackPosition1 = 0;
		this.stackPosition2 = size * 2  - 1;
	}

	public int getSize() {
		return size;
	}

	public void printStack() {
		for (int i = 0; i < size; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public boolean enqueue(int value) {
		if (pushToStack(1, value)) {
			printStack();
			return true;
		}
		System.out.println("Queue is full!");
		return false;
	}

	public boolean dequeue() {

		if (stackPosition1 == 0) {
			System.out.println("Queue is empty!");
			return false;
		}

		while(stackPosition1 > 0) {
			int value = popFromStack(1);
			if (value != 0) {
				pushToStack(2, value);
			}
		}

		popFromStack(2);

		while(stackPosition2 <= size - 2) {
			int value = popFromStack(2);
			if (value != 0) {
				pushToStack(1, value);
			}
		}

		printStack();
		return true;
	}

	public boolean pushToStack(int stackNumber, int value) {
		if (stackPosition1 > size / 2 - 1) {
			//System.out.println("Stack array is full!");
			return false;
		}
		if (stackNumber == 1) {
			array[stackPosition1] = value;
			stackPosition1 += 1;
		} else {
			array[stackPosition2] = value;
			stackPosition2 -= 1;
		}
		//printStack();
		return true;
	}

	// Popping from stack now gives us the value popped so we can now push it to the other stack
	public int popFromStack(int stackNumber) {
		int poppedValue;

		if (stackNumber == 1) {
			if (stackPosition1 - 1 < 0) {
				//System.out.println("Stack" + stackNumber + " is empty!");
				return 0;
			}
			stackPosition1 -= 1;
			poppedValue = array[stackPosition1];
			array[stackPosition1] = 0;
		} else {
			if (stackPosition2 + 1 >= size) {
				//System.out.println("Stack" + stackNumber + " is empty!");
				return 0;
			}
			stackPosition2 += 1;
			poppedValue = array[stackPosition2];
			array[stackPosition2] = 0;
		}
		return poppedValue;
	}
}