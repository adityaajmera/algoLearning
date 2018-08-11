package com.learning.algo.chap1;

public class StackLinkedList<T> implements IStack<T> {

	private Node<T> root;
	
	public StackLinkedList() {
		root = null;
	}
	
	@Override
	public void push(T item) {
		Node<T> node = new Node<T>();
		node.item = item;
		node.next = root;
		root = node;
	}

	@Override
	public T pop() {
		if(root==null) {
			throw new UnsupportedOperationException("Can not call pop on empty stack");
		}
		T item = root.item;
		root = root.next;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}
	
	public T peek() {
		if(root!=null) {
			return root.item;			
		}
		throw new UnsupportedOperationException("Stack empty");
	}

	private class Node<I> {
		I item;
		Node<I> next;
	}
}
