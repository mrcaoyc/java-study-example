package com.github.datastructure;

/**
 * @author caoyongcheng
 */
public class MyArrayList<T> {
    /**
     * 用数组存储数据
     */
    private Object[] data;

    /**
     * 数组中实际存放的元素个数
     */
    private int size;

    /**
     * @param capacity 数组初始容量，尽可能设置准确，否则后期扩容相当耗费性能
     */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity参数不合法");
        }
        data = new Object[capacity];
    }

    /**
     * 添加元素
     * 时间复杂度 O(1)
     *
     * @param element 元素值
     */
    public void add(T element) {
        if (isFull()) {
            adjustCapacity(data.length * 2);
        }
        data[size] = element;
        size++;
    }

    /**
     * 插入元素
     * 时间复杂度 O(n)
     *
     * @param element 元素值
     * @param index   要插入的下标值
     */
    public void insert(T element, int index) {
        if (isFull()) {
            adjustCapacity(data.length * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    /**
     * 移除指定下标的元素
     * 时间复杂度 O(n)
     *
     * @param index 要插入的下标值
     */
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[index] = data[index + 1];
        }
        data[--size] = null;
    }

    /**
     * 获取指定下标对应的元素
     * 时间复杂度 O(1)
     *
     * @param index 下标值
     */
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /**
     * 获取当前插入了多少个元素
     *
     * @return 元素的个数
     */
    public int getSize() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index参数不合法");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void adjustCapacity(int capacity) {
        Object[] newData = new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
