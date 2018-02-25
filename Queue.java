package BST;

public class Queue {
    QItem rear;
    QItem front;

    public QItem dequeue() {
        QItem n = null;
        if (front != null) {
            n = front;
            front = front.next;
        }
        return n;
    }

    public void enqueue(QItem n) {
        if (front != null) {
            rear.next = n;
            rear = n;
        }else{
            front = n;
            rear = front;
        }
    }

    public boolean isEmpty(){
        return front== null;
    }
}
