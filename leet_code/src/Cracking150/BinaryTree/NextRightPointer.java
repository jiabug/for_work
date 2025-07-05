package Cracking150.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import Cracking150.Node;

public class NextRightPointer {
    public Node connect(Node root) {
        /*
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
        */

        if (root == null) {
            return root;
        }
        Node cur = root;
        Node head = null;
        Node prev = null;

        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                    }
                    if (prev != null) {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                    }
                    if (prev != null) {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
