package com.ifeng.yanggz.day5.heap;

public interface Queue<E> {

    E peek();

    E dequeue();

    void inqueue(E data);

    boolean isEmpty();

    int getSize();
}
