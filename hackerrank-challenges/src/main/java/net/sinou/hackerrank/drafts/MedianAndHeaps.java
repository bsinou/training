package net.sinou.hackerrank.drafts;

import java.util.Arrays;

public class MedianAndHeaps {

	static private IntHeap mins = new IntHeap(IntHeap.MAX_HEAP);
	static private IntHeap maxs = new IntHeap(IntHeap.MIN_HEAP);

	public static void main(String[] args) {

		if (args.length == 0)
			return;

		int n = new Integer(args[0]);

		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = new Integer(args[a_i + 1]);
		}

		boolean odd = true;
		for (int currItem : a) {
			if (odd) {
				if (maxs.isEmpty())
					mins.add(currItem);
				else {
					int maxsMin = maxs.peek();
					if (maxsMin >= currItem)
						mins.add(currItem);
					else {
						maxs.add(currItem);
						mins.add(maxs.poll());
					}
				}
				// System.out.println("" + mins.peek());
				System.out.format("%.1f\n", (float)mins.peek());
			} else {
				int minsMax = mins.peek();
				if (minsMax <= currItem)
					maxs.add(currItem);
				else {
					mins.add(currItem);
					maxs.add(mins.poll());
				}
				double result = ((double) mins.peek() + (double) maxs.peek()) / 2.0d;
				// System.out.println("" + result);
				System.out.format("%.1f\n", result);
			}
			odd = !odd;
		}
	}

	private static class IntHeap {

		private int capacity = 10;
		private int size = 0;

		int[] items = new int[capacity];

		public final static int MIN_HEAP = 1;
		public final static int MAX_HEAP = -1;

		private final int type;

		public IntHeap(int type) {
			this.type = type;
		}

		private int getLeftChildIndex(int parentIndex) {
			return 2 * parentIndex + 1;
		}

		private int getRightChildIndex(int parentIndex) {
			return 2 * parentIndex + 2;
		}

		private int getParentIndex(int childIndex) {
			return (childIndex - 1) / 2;
		}

		private boolean hasLeftChild(int index) {
			return getLeftChildIndex(index) < size;
		}

		private boolean hasRightChild(int index) {
			return getRightChildIndex(index) < size;
		}

		private boolean hasParent(int index) {
			return getParentIndex(index) >= 0;
		}

		private int leftChild(int index) {
			return items[getLeftChildIndex(index)];
		}

		private int rightChild(int index) {
			return items[getRightChildIndex(index)];
		}

		private int parent(int index) {
			return items[getParentIndex(index)];
		}

		private void swap(int indexOne, int indexTwo) {
			int temp = items[indexOne];
			items[indexOne] = items[indexTwo];
			items[indexTwo] = temp;

		}

		private void ensureExtraCapacity() {
			if (size == capacity) {
				items = Arrays.copyOf(items, capacity * 2);
				capacity *= 2;
			}
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int peek() {
			if (size == 0)
				throw new IllegalStateException("Heap is empty");
			return items[0];
		}

		public int poll() {
			if (size == 0)
				throw new IllegalStateException("Heap is empty");
			int item = items[0];
			items[0] = items[size - 1];
			size--;
			heapifyDown();
			return item;
		}

		public void add(int item) {
			ensureExtraCapacity();
			items[size] = item;
			size++;
			heapifyUp();
		}

		public void heapifyUp() {
			int index = size - 1;
			while (hasParent(index) && parent(index) * type > items[index] * type) {
				swap(getParentIndex(index), index);
				index = getParentIndex(index);
			}
		}

		public void heapifyDown() {
			int index = 0;
			while (hasLeftChild(index)) {
				int smallerChildIndex = getLeftChildIndex(index);
				if (hasRightChild(index) && rightChild(index) * type < leftChild(index) * type) {
					smallerChildIndex = getRightChildIndex(index);
				}

				if (items[index] * type < items[smallerChildIndex] * type)
					break;
				else
					swap(index, smallerChildIndex);
				index = smallerChildIndex;
			}
		}
	}

}