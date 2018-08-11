package com.learning.algo.chap1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackLinkedListTest {
	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Test
	public void whenNoElementAddedToStack_IsEmptyCall_ReturnsTrue() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		boolean emptyFlag = stringStack.isEmpty();
		assertThat(emptyFlag, equalTo(true));
	}
	
	@Test
	public void whenElementAddedToStack_IsEmptyCall_ReturnsFalse() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		stringStack.push("KING");
		boolean emptyFlag = stringStack.isEmpty();
		assertThat(emptyFlag, equalTo(false));
	}
	
	@Test
	public void whenPeekOnEmptyStackCalled_ReturnsNull() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		String top = stringStack.peek();
		assertThat(top, equalTo(null));
	}

	@Test
	public void whenPeekOnNonEmptyStack_ReturnsLastAddedElement() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		stringStack.push("KING");
		String top = stringStack.peek();
		assertThat(top, equalTo("KING"));
		stringStack.push("Queen");
		top = stringStack.peek();
		assertThat(top, equalTo("Queen"));
	}
	
	@Test
	public void whenElementAddedToStack_ItAddsInStackOnTop() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		stringStack.push("I");
		boolean emptyCheck = stringStack.isEmpty();
		assertThat(emptyCheck, equalTo(false));
		String top = stringStack.peek();
		assertThat(top, equalTo("I"));
		stringStack.push("am");
		stringStack.push("Legend");
		top = stringStack.peek();
		assertThat(top, equalTo("Legend"));
	}
	
	@Test
	public void whenElementPoped_ElementGetsRemovedFromStack() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		stringStack.push("I");
		stringStack.push("AM");
		stringStack.push("LEGEND");
		String top = stringStack.peek();
		assertThat(top, equalTo("LEGEND"));
		String popedElement = stringStack.pop();
		assertThat(popedElement, equalTo("LEGEND"));
		top = stringStack.peek();
		assertThat(top, equalTo("AM"));
	}
	
	@Test
	public void whenNoElementAddedToStackLinkedList_OperationPopCalled_ThrowsUnsupportedOperationException() {
		StackLinkedList<String> stringStack = new StackLinkedList<>();
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage(startsWith("Can not call pop"));
		stringStack.pop();
	}
}
