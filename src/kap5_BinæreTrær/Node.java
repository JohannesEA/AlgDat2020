package kap5_BinæreTrær;

public class Node {
    Node left, right;
    int data;
    public Node(int data){
        this.data = data;
    }

    public void insert(int value){
        if (value <= data){
            if (left == null){
                left = new Node(value);
            }
            else left.insert(value);
        }
        else {
            if (right == null){
                right = new Node(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value){
     if (value == data){
         return true;
     }
     else if (value < data){
         if (left == null){
             return false;
         }
         else return left.contains(value);
     }
     else if (right == null){
         return false;
     }
     else return right.contains(value);
    }

    public void printInOrder(){
        if (left != null){
            left.printInOrder();
        }
        System.out.print(data+" ");

        if (right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.print(data+" ");

        if (left != null){
            left.printInOrder();
        }
        if (right != null){
            right.printInOrder();
        }
    }

    public void printPostOrder(){
        if (left != null){
            left.printInOrder();
        }
        if (right != null){
            right.printInOrder();
        }
        System.out.print(data+" ");
    }


    public static void main(String [] args){
        Node root = new Node(5);
        root.insert(3);
        root.insert(7);
        root.insert(1);
        System.out.print("InOrder: ");
        root.printInOrder();
        System.out.print("\nPreorder: ");
        root.printPreOrder();
        System.out.print("\nPostOrder: ");
        root.printPostOrder();
    }
}
