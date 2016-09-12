package com.itstacked.algorithms.iteration;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;

public class BaseListIteratorTest {

	protected void assertIteration(Iterator<? extends Object> iterator,
			boolean forward, boolean listForward, List<? extends Object> list) {

		int testIndex = listForward ? 0 : list.size() - 1;

		while (!iterator.isDone()) {
			Assert.assertFalse("Expected not to be done", iterator.isDone());
			Assert.assertEquals(iterator.current(), list.get(testIndex));
			if (forward) {
				iterator.next();
			} else {
				iterator.previous();
			}

			testIndex = listForward ? testIndex + 1 : testIndex - 1;
		}

		Assert.assertTrue("Expected to be done", iterator.isDone());
	}

	protected void assertIndexOutOfBounds(Iterator<? extends Object> iterator) {
		try {
			iterator.current();
		} catch (IndexOutOfBoundsException e) {
			return;
		}

		fail("Expected Index Out Of Bounds Exception");
	}

}
