package com.aboruo.algorithm.exercise;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class TreeList<E> extends AbstractSequentialList<E> implements List<E>, Cloneable, Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7654971086622483355L;
	transient int size = 0;
	/** treelist‘s root node */
	transient Node<E> root;
	transient Node<E> depthestNode;
	
	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Constructs an empty treelist.
     */
	public TreeList() {
	}
	@Override
	public int size() {
		return size;
	}
	private static class Node<E> {
        E item;
        Node<E> parent;
        Node<E> leftChild;
        Node<E> rightChild;

        Node(Node<E> parent, Node<E> leftChild, E element, Node<E> rightChild) {
            this.item = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
	public boolean add(E e) {
		Node<E> node = new Node<>(root, null, e, null);
		root.leftChild = node;
		return true;
	}
}
