package com.itstacked.algorithms.iteration;

public interface Iterator<T> {
	boolean isDone();

	void first();

	void last();

	void next();

	void previous();

	T current();
}
