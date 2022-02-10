public class Stack {

	int size;
	int[] array;

	int stackPosition1;
	int stackPosition2;

	public Stack(int size) {
		this.size = size;
		this.array = new int[size];
		this.stackPosition1 = 0;
		this.stackPosition2 = size - 1;
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

	public boolean pushToStack(int stackNumber, int value) {
		if (stackPosition1 > stackPosition2) {
			System.out.println("Stack array is full!");
			return false;
		}
		if (stackNumber == 1) {
			array[stackPosition1] = value;
			stackPosition1 += 1;
		} else {
			array[stackPosition2] = value;
			stackPosition2 -= 1;
		}
		printStack();
		return true;
	}

	public boolean popFromStack(int stackNumber) {
		if (stackNumber == 1) {
			if (stackPosition1 - 1 < 0) {
				System.out.println("Stack" + stackNumber + " is empty!");
				return false;
			}
			stackPosition1 -= 1;
			array[stackPosition1] = 0;
		} else {
			if (stackPosition2 + 1 >= size) {
				System.out.println("Stack" + stackNumber + " is empty!");
				return false;
			}
			stackPosition2 += 1;
			array[stackPosition2] = 0;
		}
		printStack();
		return true;
	}
}