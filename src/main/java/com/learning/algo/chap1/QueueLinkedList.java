package com.learning.algo.chap1;

public class QueueLinkedList<T> implements IQueue<T> {

	private Node<T> start;
	private Node<T> end;

	public QueueLinkedList() {
		start = null;
		end = null;
	}

	@Override
	public boolean isEmpty() {
		return start == null && end == null;
	}

	@Override
	public void enqueue(T item) {
		Node<T> node = new Node<>();
		node.item = item;
		if(start==null) {
			node.next = start;
			start = node;
			end = node;
		} else {
			node.next = start;
			start = node;
		}
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	private class Node<I> {
		Node<I> next;
		I item;
	}
}
