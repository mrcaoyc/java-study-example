package com.github.datastructure;

import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    @Test
    public void when_add() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Assert.assertEquals(7, list.getSize());
        Assert.assertEquals("[1,2,3,4,5,6,7]", list.toString());
    }

    @Test
    public void when_insert() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.insert(10, 2);
        Assert.assertEquals(6, list.getSize());
        Assert.assertEquals("[1,2,10,3,4,5]", list.toString());
    }

    @Test
    public void when_remove() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(3);
        Assert.assertEquals(4, list.getSize());
        Assert.assertEquals("[1,2,3,5]", list.toString());
    }

    @Test
    public void when_get() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assert.assertEquals(5, list.getSize());
        Assert.assertEquals("[1,2,3,5]", list.toString());
        Assert.assertEquals(2, list.get(1).intValue());
    }
}