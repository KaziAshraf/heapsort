/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsort;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Heapsort {

    private static int iteration = 0;

    public static void heapsort(Node root, int n) {
        Node temp;
        System.err.println("Sort: ");
        int tmp = n;
        for (int i = 1; i <= n; i++) {
            temp = root;
            System.err.print(temp.getValue() + " ");
            while (temp.getValue() != -1 && temp.getNext() != null) {
                temp = temp.getNext();
            }
            swap(temp, root);
            temp.setValue(-1);
            build_heap(root, n);
        }
    }

    public static void build_heap(Node root, int n) {
        Node node = root;
        for (int i = 1; i <= n / 2; i++) {
            heapify(node, i);
            node = node.getNext();
        }
    }

    public static void heapify(Node node, int i) {
        int left_child = 2 * i;
        int right_child = 2 * i + 1;
        Node temp = node;
        for (int j = i; j < left_child; j++) {
            temp = temp.getNext();
        }
        if (temp != null) {
            node.setLeft_child(temp);
            temp.setParent(node);
        }
        temp = node;
        for (int j = i; j < right_child; j++) {
            temp = temp.getNext();
        }
        if (temp != null) {
            node.setRight_child(temp);
            temp.setParent(node);
        }
        shift_down(node);
    }

    public static void shift_down(Node node) {
        Node left_child = node.getLeft_child();
        Node right_child = node.getRight_child();
        Node max = node;
        if (left_child != null && left_child.getValue() > node.getValue()) {
            iteration++;
            max = left_child;
            swap(max, node);
            if (node.getParent() != null) {
                shift_down(node.getParent());
            }
        }
        if (right_child != null && right_child.getValue() > node.getValue()) {
            iteration++;
            max = right_child;
            swap(max, node);
            if (node.getParent() != null) {
                shift_down(node.getParent());
            }

        }

    }

    public static void swap(Node child, Node parent) {
        int temp = child.getValue();
        child.setValue(parent.getValue());
        parent.setValue(temp);

    }

    public static void addNode(Node node, Node root) {
        while (root.getNext() != null) {
            root = root.getNext();
        }
        root.setNext(node);
    }

    public static void print_heap(Node root) {
        Node temp = root;
        while (temp != null) {
            System.err.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.err.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter no. of Nodes: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("Enter Nodes: ");
        Node root = new Node();
        for (int i = 1; i <= n; i++) {
            Scanner nodes_value = new Scanner(System.in);
            addNode(new Node(nodes_value.nextInt()), root);
        }
        root = root.getNext();
        build_heap(root, n);
        System.out.println("Iteration: " + iteration);
        print_heap(root);
        iteration = 0;
        heapsort(root, n);
        System.out.println("Iteration: " + iteration);

    }

}
