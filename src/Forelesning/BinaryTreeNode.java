package Forelesning;

import java.util.ArrayDeque;

public class BinaryTreeNode {
    char value;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    BinaryTreeNode(char value){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    BinaryTreeNode addLeftChild(char value){
        this.leftChild = new BinaryTreeNode(value);
        return  this.leftChild;

    }

  BinaryTreeNode addRightChild(char value){
        this.rightChild = new BinaryTreeNode(value);
        return this.rightChild;
    }

    static void printLevelOrder(BinaryTreeNode root){
        ArrayDeque<BinaryTreeNode> queu = new ArrayDeque<>();//ArrayDeque er en god datastruktur for stakker og køer

        //LEgger til rot-node
        queu.addLast(root);

        while (!queu.isEmpty()){
            //  1. Ta ut noden først i køen
            BinaryTreeNode current = queu.removeFirst();

            //2. Legg til current sine to barn til køen
            if (current.leftChild != null){
                queu.addLast(current.leftChild);
            }
            if (current.rightChild != null){
                queu.addLast(current.rightChild);
            }

            //3. Skriv ut
            System.out.println(current.value+" ");
        }
    }

    static void printPreOrder(BinaryTreeNode node){
        //Stanser når vi ikke har noen node
        if (node == null){
            return;
        }

        System.out.print(node.value+" ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);


    }

    static void printInOrder(BinaryTreeNode node){
        //Stanser når vi ikke har noen node
        if (node == null){
            return;
        }


        printInOrder(node.leftChild);
        System.out.print(node.value+" ");
        printInOrder(node.rightChild);
    }

    static void printPostOrder(BinaryTreeNode node){
        //Stanser når vi ikke har noen node
        if (node == null){
            return;
        }
        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.print(node.value+" ");
    }

    //Ikke rekursiv metode --> iterativ
    static void printPreOrderIterative(BinaryTreeNode root){
        if (root == null){
            return;
        }
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();
        //Legger til root i stakken
        stack.addLast(root);

        while (!stack.isEmpty()){
            BinaryTreeNode current = stack.removeLast();
            if (current.rightChild != null) {
                stack.addLast(current.rightChild);
            }
            if (current.leftChild != null) {
                stack.addLast(current.leftChild);
            }

            System.out.print(current.value+" ");
        }


    }

    public static void main(String [] args){
        //Lager rot-node (nivå 0)
        BinaryTreeNode root = new BinaryTreeNode('A');

        //LEgg inn resterende noder nivå 1
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');

        //LEgg inn resterende noder nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        //Kall funksjonen vår
        //printLevelOrder(root);
        System.out.print("preorder: ");
        printPreOrder(root);
        System.out.print("\nInOrder: ");
        printInOrder(root);
        System.out.print("\nPostOrder: ");
        printPostOrder(root);

        System.out.print("\nPreOrder Iterative: ");
        printPreOrderIterative(root);


    }
}
