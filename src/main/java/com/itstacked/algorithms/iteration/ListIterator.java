package com.itstacked.algorithms.iteration;

import java.util.Collections;
import java.util.List;

public class ListIterator<T> implements Iterator<T> {

	private List<T> list;
	private int current = 0;

	public ListIterator(List<T> list) {
		this.list = Collections.unmodifiableList(list);
	}

	public boolean isDone() {
		if (current < 0 || current >= list.size()) {
			return true;
		}

		return false;
	}

	public void first() {
		current = 0;
	}

	public void next() {
		setCurrent(1);
	}

	public void previous() {
		setCurrent(-1);
	}

	protected void setCurrent(int step) {
		current = current += step;
	}

	public void last() {
		current = list.size() - 1;
	}

	public T current() {
		if (isDone()) {
			throw new IndexOutOfBoundsException("Iterator index out of bounds");
		}

		return list.get(current);
	}
}
