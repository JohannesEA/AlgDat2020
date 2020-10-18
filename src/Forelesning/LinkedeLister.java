package Forelesning;

public class LinkedeLister {

    public static void main(String [] args){
    Node head = new Node(5);
    Node nodeB = new Node(4);
    Node nodeC = new Node(3);
    Node nodeD = new Node(2);
    Node nodeE = new Node(1);

    head.next = nodeB;
    nodeB.next = nodeC;
    nodeC.next = nodeD;
    nodeD.next = nodeE;

    System.out.print(countNodes(head));
    }





    static class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value =value;
        }

        Node position(int index){
            if (index == 0){
                return this;
            }
            else {
                return this.next.position(index-1);
            }
        }

        Node position(Node head, int index){
            Node current =head;

            for (int i = 0; i < index; i++ ){
                current = current.next;
            }
            return current;
        }

        void insert(Node p, Node q, Node r){
            p.next = q;
            q.next = r;
            r.prev = q;
            q.prev = p;
        }

        void remove(Node p, Node q, Node r){
            p.next = r;
            r.prev = p;
        }

    }


    //Metode for å telle opp hvor mange verdier som eksisterer i en linked liste/node
    static int countNodes(Node head){
        int count = 1;
        Node current = head;

        while (current.next != null){
            current = current.next;
            count += 1;
        }
        return count;

        }


}




