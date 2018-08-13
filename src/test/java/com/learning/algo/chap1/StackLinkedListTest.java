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
	
	private StackLinkedList<String> stringStack = new StackLinkedList<>();

	@Test
	public void whenNoElementAddedToStack_IsEmptyCall_ReturnsTrue() {
		assertThat(stringStack.isEmpty(), equalTo(true));
	}
	
	@Test
	public void whenElementAddedToStack_IsEmptyCall_ReturnsFalse() {
		stringStack.push("KING");
		assertThat(stringStack.isEmpty(), equalTo(false));
	}
	
	@Test
	public void whenPeekOnEmptyStackCalled_ThrowsException() {
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage(startsWith("Stack empty"));
		stringStack.peek();
	}

	@Test
	public void whenPeekOnNonEmptyStack_ReturnsLastAddedElement() {
		stringStack.push("KING");
		assertThat(stringStack.peek(), equalTo("KING"));
		stringStack.push("Queen");
		assertThat(stringStack.peek(), equalTo("Queen"));
	}
	
	@Test
	public void whenElementAddedToStack_ItAddsInStackOnTop() {
		stringStack.push("I");
		assertThat(stringStack.isEmpty(), equalTo(false));
		assertThat(stringStack.peek(), equalTo("I"));
		stringStack.push("am");
		stringStack.push("Legend");
		assertThat(stringStack.peek(), equalTo("Legend"));
	}
	
	@Test
	public void whenElementPoped_ElementGetsRemovedFromStack() {
		stringStack.push("I");
		stringStack.push("AM");
		stringStack.push("LEGEND");
		assertThat(stringStack.peek(), equalTo("LEGEND"));
		assertThat(stringStack.pop(), equalTo("LEGEND"));
		assertThat(stringStack.peek(), equalTo("AM"));
	}
	
	@Test
	public void whenNoElementAddedToStackLinkedList_OperationPopCalled_ThrowsUnsupportedOperationException() {
		thrown.expect(UnsupportedOperationException.class);
		thrown.expectMessage(startsWith("Can not call pop"));
		stringStack.pop();
	}
}
