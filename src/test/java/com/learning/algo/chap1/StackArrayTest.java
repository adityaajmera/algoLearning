package com.learning.algo.chap1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackArrayTest {

	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	StackArray<String> stringStack = new StackArray<>();
	
	@Test
	public void whenIsEmptyCalled_OnEmptyStack_ReturnsTrue() {
		boolean status = stringStack.isEmpty();
		assertThat(status, equalTo(true));
	}

	@Test
	public void whenIsEmptyCalled_OnUbnmptyStack_ReturnsFalse() {
		stringStack.push("I");
		boolean status = stringStack.isEmpty();
		assertThat(status, equalTo(false));
	}
	
	@Test
	public void whenStackIsEmtpy_OnCallingPeek_ThrowsException() {
		expected.expect(UnsupportedOperationException.class);
		expected.expectMessage(startsWith("Stack empty"));
		stringStack.peek();
	}
	
	@Test
	public void whenStackIsNotEmpty_OnCallingPeek_ReturnsLatestElementAdded() {
		stringStack.push("I");
		String element = stringStack.peek();
		assertThat(element, equalTo("I"));
		stringStack.push("AM");
		element = stringStack.peek();
		assertThat(element, equalTo("AM"));
	}
	
	@Test
	public void whenStackIsEmpty_OnCallingPop_ThrowsException() {
		expected.expect(UnsupportedOperationException.class);
		expected.expectMessage(startsWith("Stack empty"));
		stringStack.pop();
	}
	
	@Test
	public void whenStackIsNotEmtpy_OnCallingPop_ReturnsElementLastAdded() {
		stringStack.push("I");
		stringStack.push("AM");
		stringStack.push("LEGEND");
		String topElement = stringStack.peek();
		assertThat(topElement, equalTo("LEGEND"));
		String popElement = stringStack.pop();
		assertThat(popElement, equalTo("LEGEND"));
		topElement = stringStack.peek();
		assertThat(topElement, equalTo("AM"));
		popElement = stringStack.pop();
		assertThat(popElement, equalTo("AM"));
		topElement = stringStack.peek();
		assertThat(topElement, equalTo("I"));
	}
}