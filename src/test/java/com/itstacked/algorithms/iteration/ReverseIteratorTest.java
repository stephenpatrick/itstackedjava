package com.itstacked.algorithms.iteration;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.itstacked.algorithms.iteration.Iterator;
import com.itstacked.algorithms.iteration.ListIterator;
import com.itstacked.algorithms.iteration.ReverseIterator;

public class ReverseIteratorTest extends BaseListIteratorTest {

    private List<Integer> sampleList;

    @Before
    public void setUp() {
        sampleList = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {
            sampleList.add(i + 1);
        }

        sampleList = Collections.unmodifiableList(sampleList);
    }

    @Test
    public void first() {
        Iterator<Integer> iterator = createTestIterator();
        
        iterator.first();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        Assert.assertEquals(iterator.current(), sampleList.get(sampleList.size() -1));
    }

    @Test
    public void last() {
        Iterator<Integer> iterator = createTestIterator();
        iterator.last();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        Assert.assertEquals(iterator.current(),
                sampleList.get(0));
    }

    @Test
    public void IsDone() {
        Iterator<Integer> iterator = createTestIterator();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        iterator.next();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        iterator.next();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        iterator.next();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        iterator.next();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        iterator.next();
        Assert.assertTrue("Expected to be done", iterator.isDone());
    }

    @Test
    public void IsDone_emptyList() {
        Iterator<Integer> iterator = new ReverseIterator<Integer>(
                new ListIterator<Integer>(new LinkedList<Integer>()));
        Assert.assertTrue("Expected to be done", iterator.isDone());
    }

    @Test
    public void next() {
        Iterator<Integer> iterator = createTestIterator();

        Assert.assertFalse("Expected not to be done", iterator.isDone());
        assertIteration(iterator, true, false, sampleList);
        Assert.assertTrue("Expected to be done", iterator.isDone());
    }

    @Test
    public void previous() {
        Iterator<Integer> iterator = createTestIterator();

        iterator.last();
        Assert.assertFalse("Expected not to be done", iterator.isDone());
        assertIteration(iterator, false, true, sampleList);
        Assert.assertTrue("Expected to be done", iterator.isDone());
    }

    @Test
    public void previous_IndexOutBounds() {
        Iterator<Integer> iterator = createTestIterator();

        Assert.assertEquals(iterator.current(), Integer.valueOf(5));
        iterator.previous();
        assertIndexOutOfBounds(iterator);
    }

    @Test
    public void next_IndexOutBounds() {
        Iterator<Integer> iterator = createTestIterator();
        iterator.last();

        Assert.assertFalse("Expected not to be done", iterator.isDone());
        iterator.next();
        assertIndexOutOfBounds(iterator);
    }

    private Iterator<Integer> createTestIterator() {
        return new ReverseIterator<Integer>(new ListIterator<Integer>(
                sampleList));
    }

}
