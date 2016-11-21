package com.radulov.study;

import java.util.ArrayList;

/**
 * Created by golova on 11/2/16.
 */
public class Reconstruction {

    public static String reconstruct(Node head)
    {
        String result = "";
        if (head.leftChild == null)
        {
            result += head.message;
            if (head.rightChild != null)
            {
                result += reconstruct(head.rightChild);
            }
        }
        else
        {
            result += reconstruct(head.leftChild);
            result += head.message;
            if (head.rightChild != null)
            {
                result += reconstruct(head.rightChild);
            }
        }
        return result;
    }

    public static Node construct(Node[] array) {
        int terminalCount = 0;
        for (Node node : array) { if (node.terminal) { terminalCount++;}}
        int terminalIndex = -1;
        if (terminalCount > 0) {
            for (int i = 0, terminalCounter = 0; i < array.length; i++) {
                if (array[i].terminal) {
                    terminalCounter++;
                    if (terminalCounter == terminalCount / 2) {
                        terminalIndex = i;
                    }
                }
            }
        }
        int index = 0, headIndex = 0;
        System.out.println(Reconstruction.reconstruct(array[terminalIndex]));
        for (int i = terminalIndex, j = terminalIndex; i < array.length - 1; i += 2, j -= 2)
        {
            if (array[i + 1].terminal) {
                array[i].rightChild = array[i + 1];
            } else if (array[i + 2].terminal || i == array.length - 2) {
                array[i].rightChild = array[i + 2];
            } else {
                System.out.println("wrong syntax");
            }
            if (!array[i - 1].terminal) {
                array[i].leftChild = array[i - 1];
            }

            if (j > 1) {
                if (array[j - 1].terminal) {
                    array[j].leftChild = array[j - 1];
                } else if (array[j - 2].terminal || j == 3) {
                    array[j].leftChild = array[j - 2];
                } else {
                    System.out.println("wrong syntax");
                }

            }
            if (j >= 0 && j != terminalIndex) {
                array[j].rightChild = array[j + 1];
            }
        }
        System.out.println(Reconstruction.reconstruct(array[terminalIndex]));
        return array[headIndex];
    }

}
