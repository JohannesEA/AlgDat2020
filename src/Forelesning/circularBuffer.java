package Forelesning;

public class circularBuffer {

    char [] buffer; //Alle verdiene
    int size;  //Størrelsen til rekken
    int head; //Peker på den første i rekken
    int tail; //Peker på den siste i rekken
    int count; //Antall elementer som er i køen nå

    public circularBuffer(int size){
        this.buffer = new char[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;


    }

    void pushBack(char value){
        if (count+1 > size){
            throw new IndexOutOfBoundsException();
        }
        buffer[tail] = value;
        tail = (tail+1) %size;
        count = count+1;

    }

    char popFront(){
        if (count<=0 ){
            throw new IndexOutOfBoundsException();
        }
        char retval = buffer[head];
        System.out.print(head);
        head = (head+1)%size;
        count = count-1;
        return retval;

    }

    int count(){
        return count;
    }

    public static void main(String [] args){
circularBuffer buffer = new circularBuffer(7);
char [] values = "ABCDEFGHIJKLMNOPQRFT".toCharArray();


for (int i = 0; i < values.length;){
    //Legger inn 3 verdier i bufferet
    for (int j = 0; j < 6; j++){
        if (values.length > i+j){
            buffer.pushBack(values[i+j]);
        }
    }

    while (buffer.count() > 0){
        System.out.print(buffer.popFront());

    }
    System.out.println();

    i = i+6;
}
    }

}


