package com.bhupati.linkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {
	
	//Inner class Node
	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E data) {
			this.data = data;
		}
	}
	
	private static class EmptyDoublyLinkedListException extends RuntimeException {
		
		public EmptyDoublyLinkedListException() {
		}
		
		public EmptyDoublyLinkedListException(String msg) {
			super(msg);
		}
		
	}
	
	//Doubly linked list properties
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	
	//public methods of DoublyLinkedList
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyDoublyLinkedListException("EmptyDoublyLinkedListException");
		}
		
		return head.data;
	}
	
	public void addHead(T data) {
		Node<T> newNode = new Node<T>(data);
		if(size == 0) {
			head = tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public void addTail(T data) {
		Node<T> newNode = new Node<T>(data);
		if(size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}
	
	public T removeHead() {
		if((isEmpty())) {
			throw new EmptyDoublyLinkedListException("EmptyDoublyLinkedListException");
		}
		T data = head.data;
		head = head.next;
		if(head == null) {
			tail = null;
		} else {
			head.prev = null;
		}
		size--;
		return data;
	}
	
	public T removeTail() {
		if((isEmpty())) {
			throw new EmptyDoublyLinkedListException("EmptyDoublyLinkedListException");
		}
		T data = tail.data;
		tail = tail.prev;
		if(tail == null) {
			head = null;
		} else {
			tail.next = null;
		}
		size--;
		return data;
	}
	
	public void print() {
		Node<T> current = head;
		while(current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		
		list.addHead(10);
		list.addTail(25);
		list.addHead(5);
		
		list.print();
		
		list.removeHead();
		list.print();
		
		list.removeTail();
		list.print();
		
		
	}
	

}
