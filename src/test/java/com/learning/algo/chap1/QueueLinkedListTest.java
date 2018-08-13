package com.learning.algo.chap1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class QueueLinkedListTest {

	private QueueLinkedList<String> stringQueue = new QueueLinkedList<>();

	@Test
	public void whenQueueIsEmty_IsEmpty_ReturnTrue() {
		assertThat(stringQueue.isEmpty(), equalTo(true));
	}
	
	@Test
	public void whenQueueIsNotEmpty_IsEmpty_ReturnFalse() {
		stringQueue.enqueue("KING");
		assertThat(stringQueue.isEmpty(), equalTo(false));
	}

	@Test
	public void whenElementAdded_QueueStartPointChange() {
		stringQueue.enqueue("KING");
		stringQueue.enqueue("QUEEN");
//		assertThat(stringQueue,hasItem("KING"));
//		assertThat(stringQueue, containsString("KING"));
//		assertThat(stringQueue, containsString("QUEEN"));
	}
}
