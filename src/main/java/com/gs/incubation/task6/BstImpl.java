package com.gs.incubation.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BstImpl {

    static class BST {
        private Node root;

        public BST() {
        }

        public void put(int value) {
            this.root = insert(root, value);
        }

        private Node insert(Node root, int value) {
            if (root == null) {
                root = new Node(value);
            } else {
                if (root.val < value)
                    root.right = insert(root.right, value);
                else
                    root.left = insert(root.left, value);
            }
            return root;
        }


        public boolean contains(int value) {
            Node head = this.root;
            while (head != null) {
                if (head.val > value) {
                    head = head.left;
                } else if (head.val < value) {
                    head = head.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            acc.add(node.val);
            inOrderTraversal(node.right, acc);

        }

        private static class Node {
            Integer val;
            Node left;
            Node right;

            Node(int val) {
                this.val = val;
            }

            Node() {
            }
        }
    }

    public static void testBST() {
        final BST searchTree = new BST();
        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);
        assertFalse(searchTree.contains(0));
        assertTrue(searchTree.contains(1));
        assertTrue(searchTree.contains(5));
        assertFalse(searchTree.contains(6));
        assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
    }


    private static void assertFalse(boolean rez) {
        if (rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }


    private static void assertTrue(boolean rez) {
        if (!rez) {
            throw new RuntimeException("Test failed");
        } else {
            System.out.println("Test passed");
        }
    }


    private static void assertEquals(List<Integer> expected, List<Integer> result) {
        if (!expected.equals(result)) {
            System.out.println(String.format("Test failed \"%s\" not equeals to \"%s\"", expected, result));
        } else {
            System.out.println("Test passed");
        }
    }


    // TODO: write some more tests
    public static void main(String[] args) {
        testBST();
    }
}
