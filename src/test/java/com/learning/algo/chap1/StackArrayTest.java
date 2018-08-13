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
		assertThat(stringStack.isEmpty(), equalTo(true));
	}

	@Test
	public void whenIsEmptyCalled_OnUbnmptyStack_ReturnsFalse() {
		stringStack.push("I");
		assertThat(stringStack.isEmpty(), equalTo(false));
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
		assertThat(stringStack.peek(), equalTo("I"));
		stringStack.push("AM");
		assertThat(stringStack.peek(), equalTo("AM"));
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
		assertThat(stringStack.peek(), equalTo("LEGEND"));
		assertThat(stringStack.pop(), equalTo("LEGEND"));
		assertThat(stringStack.peek(), equalTo("AM"));
		assertThat(stringStack.pop(), equalTo("AM"));
		assertThat(stringStack.peek(), equalTo("I"));
	}
}