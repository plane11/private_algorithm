package baekjoon.S1927;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] tree = null;
    static int position = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new int[1<<18];

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                removeTopNode();
            } else {
                addNode(num);
            }
        }
    }

    private static void addNode(int num) {
        tree[++position] = num;
        orderLeafNode();
    }

    private static void removeTopNode() {
        if(position == 0) {
            System.out.println(0);
        } else{
            System.out.println(tree[1]);

            tree[1] = tree[position];
            tree[position] = 0;
            position--;

            orderTopNode();
        }
    }

    private static void swapNode(int index1, int index2) {
        int temp = tree[index1];
        tree[index1] = tree[index2];
        tree[index2] = temp;
    }

    private static void orderLeafNode() {
        int nodePosition = position;
        while(nodePosition > 1 && tree[nodePosition / 2] > tree[nodePosition]) {
            // bigger child ?
            swapNode(nodePosition, nodePosition / 2);
            nodePosition = nodePosition / 2;
        }
    }

    private static void orderTopNode() {
        int nodePosition = 1;
        while(true) {
            if(nodePosition * 2 + 1 <= position) { // has 2 children
                if(tree[nodePosition * 2] <= tree[nodePosition * 2 + 1]) {
                    // first child is bigger
                    nodePosition = compareWithFirstChild(nodePosition);
                } else{
                    nodePosition = compareWithSecondChild(nodePosition);
                }
            }else if(nodePosition * 2 <= position){ // has 1 child
                nodePosition = compareWithFirstChild(nodePosition);
            } else {
                nodePosition = -1;
            }

            if(nodePosition == -1) {
                break;
            }
        }
    }

    private static int compareWithFirstChild(int nodePosition) {
        if(tree[nodePosition] > tree[nodePosition * 2]) {
            swapNode(nodePosition, nodePosition * 2);
            return nodePosition * 2;
        }else{
            return -1;
        }
    }

    private static int compareWithSecondChild(int nodePosition) {
        if(tree[nodePosition] > tree[nodePosition * 2 + 1]) {
            swapNode(nodePosition, nodePosition * 2 + 1);
            return nodePosition * 2 + 1;
        }else{
            return -1;
        }
    }

}