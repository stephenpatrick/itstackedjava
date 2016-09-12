package com.itstacked.algorithms.iteration;

public class ReverseIterator<T> implements Iterator<T> {

	private Iterator<T> iterator;

	public ReverseIterator(Iterator<T> iterator) {
		this.iterator = iterator;
		iterator.last();
	}

	public boolean isDone() {
		return iterator.isDone();
	}

	public void first() {
		iterator.last();

	}

	public void last() {
		iterator.first();
	}

	public void next() {
		iterator.previous();

	}

	public void previous() {
		iterator.next();

	}

	public T current() {
		return iterator.current();
	}
}
