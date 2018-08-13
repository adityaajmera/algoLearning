package com.learning.algo.chap1;

public interface IQueue<T> {
	public boolean isEmpty();
	public void enqueue(T item);
	public T dequeue();
}
