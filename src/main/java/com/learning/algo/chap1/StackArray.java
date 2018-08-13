package com.learning.algo.chap1;

public class StackArray<T> implements IStack<T> {

	private T[] arr;
	private int top;

	@SuppressWarnings("unchecked")
	public StackArray() {
		arr = (T[]) new Object[1];
		top = -1;
	}

	@Override
	public void push(T item) {
		int size = arr.length;
		if(top>=(size/2)) {
			resize(size*2);
		}
		arr[++top] = item;
	}

	@Override
	public T pop() {
		int size = arr.length;
		if(top>1 && top==(size/4)) {
			resize(size/2);
		}
		if(top>-1) {
			T item = arr[top--];
			arr[top+1]=null;
			return item;
		}
		throw new UnsupportedOperationException("Stack empty");
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	public T peek() {
		if (top != -1) {
			return arr[top];
		}
		throw new UnsupportedOperationException("Stack empty");
	}
	
	private void resize(int len) {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) new Object[len];
		for(int i=0; i<=top; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
}
