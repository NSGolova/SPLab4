package com.radulov.study;

/**
 * Created by golova on 11/2/16.
 */
public class Node
{
    public Node(Node leftChild, Node rightChild, String message, boolean terminal) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.message = message;
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return message;
    }

    Node leftChild, rightChild;
    String message;
    boolean terminal;
}
