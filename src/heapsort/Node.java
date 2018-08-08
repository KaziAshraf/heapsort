/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

/**
 *
 * @author User
 */
public class Node {

    private int value;
    private Node left_child;
    private Node right_child;
    private Node next;
    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public void setLeft_child(Node left_child) {
        this.left_child = left_child;
    }

    public Node getRight_child() {
        return right_child;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRight_child(Node right_child) {
        this.right_child = right_child;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node() {
        this.left_child = null;
        this.right_child = null;
        this.value = -1;
    }

}
