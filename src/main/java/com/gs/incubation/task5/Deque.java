package com.gs.incubation.task5;

class Node<T> {

    public final T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T data) {
        this.data = data;
    }

}

public class Deque<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Deque() {
        this.size = 0;
    }

    public void addAtFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
        }
        if (head == tail && head == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public T removeAtFront() {
        if (head != null) {
            T val = head.data;
            Node<T> newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            head.prev = null;
            head.next = null;
            size--;
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                head = newHead;
            }
            return val;
        } else {
            return null;
        }
    }

    public void addAtBack(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
        }
        if (head == tail && tail == null) {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public T removeAtBack() {
        if (tail != null) {
            T val = head.data;
            Node<T> newHead = tail.prev;
            if (newHead != null) {
                newHead.next = null;
            }
            tail.prev = null;
            tail.next = null;
            size--;
            if (size == 0) {
                head = null;
                tail = null;
            } else {
                tail = newHead;
            }
            return val;
        } else {
            return null;
        }
    }

    public T getFirst() {
        if (head != null) {
            return head.data;
        } else {
            return null;
        }
    }

    public T getLast() {
        if (tail != null) {
            return tail.data;
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }
}
