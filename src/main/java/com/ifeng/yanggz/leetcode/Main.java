package com.ifeng.yanggz.leetcode;


public class Main {

    private int[] stacks;
    private int[] top;
    private int stackSize;

    public Main(int stackSize) {
        stacks = new int[3*stackSize];
        top = new int[]{0,1,2};
    }

    public void push(int stackNum, int value) {
        if(top[stackNum] / 3 == stackSize) {
            return;
        }
        stacks[top[stackNum]] = value;
        top[stackNum] += 3;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)) {
            return -1;
        }
        int value = stacks[top[stackNum]-3];
        top[stackNum] -= 3;
        return value;
    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)) {
            return -1;
        }
        return stacks[top[stackNum] - 3];
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum] < 3;
    }

}
