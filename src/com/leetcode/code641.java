package com.leetcode;

/**
 * @Author tjy
 * @Date 2020/5/15 12:47
 */


/**
 *
 */
public class code641 {

    private int[] queue;
    private int front;
    private int rear;
    private  int size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public  code641(int k) {
        queue = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())return false;
        if (isEmpty()){
            queue[front] = value;
            size++;
            return true;
        }
        if (front == 0)front = queue.length-1;
        else front = front - 1;
        queue[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())return false;
        if (isEmpty()){
            queue[rear] = value;
            size++;
            return true;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())return false;
        front = (front+1) % queue.length;
        if (isEmpty())rear = front;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())return false;
        if (rear == 0)rear = queue.length - 1;
        else rear = rear - 1;
        if (isEmpty())front = rear;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())return -1;
        return queue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty())return -1;
        return queue[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }

}
class x{
    /**
     * "insertFront","deleteLast","isFull","insertFront","isFull","deleteFront","deleteFront","deleteLast",
     * "isEmpty","insertLast","deleteLast","deleteFront","insertLast","getRear","getRear","deleteLast",
     * "deleteFront","insertFront","deleteLast","getFront","getRear","getRear","getFront","insertLast",
     * "getFront","isEmpty","getFront","insertFront","insertFront","getRear","insertFront","insertLast",
     * "deleteFront","getRear","deleteLast","deleteFront","insertFront","getRear","insertLast","insertLast",
     * "getRear","getFront","insertLast",
     * "isFull","deleteFront","insertFront","getFront","getFront","getFront","isEmpty","insertLast","insertLast",
     * @param args
     */
    public static void main(String[] args) {
        new code641(10);
    }
}
