import java.util.Deque;
import java.util.LinkedList;
class Stacksusingdeque1 {
    int sizes1;
    int sizes2;
    Deque<Integer> d;
    // Constructor initialisation.
public Stacksusingdeque1(int sizes1, int sizes2) {
    this.sizes1 = sizes1;
    this.sizes2 = sizes2;
    this.d = new LinkedList<Integer>();
}
// Push Function to push data into Deque
public void push(int Stack, int data) {
    // If the Stack is 1 then we will add the data at first side of Deque and increment the size.
    if(Stack == 1) {
        d.addFirst(data);
        sizes1++;
        // If the Stack is 2 then we will add the data at last side of Deque and increment the size.
    } else if(Stack == 2) {
        d.addLast(data);
        sizes2++;
    }
    
}
// pop Function to pop the data from Deque
public int pop(int Stack) {
    // If the size is not 0 and and Stack is 1 them remove the data from first.
        if(sizes1 != 0 && Stack == 1) {
            return d.removeFirst();
    //  If the size is not 0 and and Stack is 2 them remove the data from Last.
        } else if(sizes2 != 0 && Stack == 2) {
            return d.removeLast();
        }
        return -1;
    }

}
public class Stacksusingdeque {
    public static void main(String[] args) {
        Stacksusingdeque1 s = new Stacksusingdeque1(3,3);
        s.push(1,4);
        s.push(1,2);
        s.push(1,3);
        s.push(2,5);
        s.push(2,6);
        s.push(2,8);
        System.out.println("===============The Output=================");
        System.out.println("      "+s.pop(1));
        System.out.println("      "+s.pop(1));
        System.out.println("      "+s.pop(1));
        System.out.println("      "+s.pop(2));
        System.out.println("      "+s.pop(2));
        System.out.println("      "+s.pop(2));

        


    }
}

    




