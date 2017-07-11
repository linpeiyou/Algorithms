package com.algo.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.algo.util.StdOut;

public class Queue<T> implements Iterable<T> {

	private int 	N;
	private Node 	first;
	private Node 	last;
	
	private class Node {
		private T 		item;
		private Node 	next;
	}
	
	public Queue() {
		N = 0;
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public int length() {
		return N;
	}
	
	public void enqueue(T value) {
		if(isEmpty()) {
			first = new Node();
			first.item = value;
			last = first;
		}
		else {
			Node node = new Node();
			node.item = value;
			last.next = node;
			last = node;
		}
		++N;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		T value = first.item;
		first = first.next;
		--N;
		if(isEmpty())
			last = null;
		return value;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		return first.item;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if(!hasNext()) 
				throw new NoSuchElementException();
			T value = current.item;
			current = current.next;
			return value;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(T t : this) {
			sb.append(t + " "); 
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = "where there is a will, there is a way".split(" ");
		Queue<String> queue = new Queue<>();
		for(String s : strs) {
			queue.enqueue(s);
		}
		while(!queue.isEmpty()) {
			StdOut.print(queue.dequeue() + "-");
		}
		StdOut.println();
		//===========================================
		for(String s : strs) {
			queue.enqueue(s);
		}
		System.out.println(queue);
	}
	
}


















