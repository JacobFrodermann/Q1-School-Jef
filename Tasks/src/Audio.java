import javax.swing.text.AbstractDocument.Content;

import com.oracle.webservices.internal.api.message.ContentType;

/*import SgJavaLib.datenstrukturen.Queue;

class JukeBox{
    Queue<Song> queue = new Queue<Song>();

    void add(String name,int duration){
        queue.enqueue(new Song(name, duration));
    }
    void skip(){
        queue.dequeue();
    }
    void play(){

        System.out.println("Es läuft "+queue.front().name);
        try{
           Thread.sleep(queue.front().duration); 
        } catch(Exception e){}
        queue.dequeue();
    }
    class Song{
        String name;
        int duration;
        Song(String name, int duration){
            this.name = name;
            this.duration = duration;
        }
    }
}*/





































//import SgJavaLib.datenstrukturen.Stack;


/* 





import java.util.Stack;
class useless {
    class Card{
        String color,val;
        Card(String color, String val){
            this.color = color;
            this.val = val;
        }
        public String getColor() {return color;}
        public String getVal() {return val;}
    }
    class Stapel{
        private Stack<Card> stack = new Stack<>();
        private int index;
        Stapel() {}
        void auflegen(String color, String val){stack.push(new Card(color, val));index ++;}
        Card anschauen(){return stack.peek();}
        Card nehmen(){index --;return stack.pop();}
    }
}


*/

class Stack extends SgJavaLib.datenstrukturen.Stack {
    
    public int length = 0; 

    @Override
    public ContentType pop() {
        if (!isEmpty())
          this.head = this.head.getNext(); 
          length --;
      }
    @Override
    public void push(ContentType pContent) {
        length ++;
        if (pContent != null) {
          StackNode node = new StackNode(pContent);
          node.setNext(this.head);
          this.head = node;
        } 
    }
    
    public Stack clone(){
        Stack<ContentType> tmp = new Stack<ContentType>(), tmp2 = new Stack<ContentType>();

        while (length != 0){
            ContentType h = pop();
            tmp.push(h);
            tmp2.push(h);
        }
        while (tmp2.length != 0) {
            push(tmp2.pop());
        }
        return tmp;
    }

    public ContentType[] toArray(){
        ContentType[] tmp = new ContentType[length];
        Stack<ContentType> tmp2 = clone();
        int l = tmp2.length;
        while (tmp2.length != 0) {
            tmp[l-tmp2.length] = tmp2.pop();
        }
    }

    public Stack(ContentType[] arr){
        super();
        for (ContentType c : arr) {
            push(c);
        }
    }
}

class Radio{
    Stack<Alert> myStack = new Stack<Alert>();
    class Alert{ String where; int length; Alert(String where,int length) { this.where = where;  this.length = length;}}
    void add(String where, int length){ myStack.push(new Alert(where, length)); }

    void read(){
        while (myStack.length != 0) {
            Alert tmp = myStack.pop();
            System.out.println("Bei " + tmp.where + "werden sie " + tmp.length + " Stunden warten müssen");
        }
    }
    Alert longest() {
        int max = 0;
        String where;
        for (Alert i : myStack.toArray()) {
            if (i.length < max) {
                max = i.length;
                where = i.where;
            }
        }
    }
    int ask(String where) {
        for (Alert i : myStack.toArray()) {
            if (i.where.compareTo(where)) {return i.length;}
        }
        return 0;
    }
}




