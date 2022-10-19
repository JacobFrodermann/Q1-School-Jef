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














































import java.util.Stack;
class useless {
    class Card{
        String color,val;
        Card(String color, String val){
            this.color = color;
            this.val = val;
        }
        public String getColor() {
            return color;
        }
        public String getVal() {
            return val;
        }
    }
    class Stapel{
        private Stack<Card> stack = new Stack<>();
        private int index;
        Stapel() {

        }
        void auflegen(String color, String val){
            stack.push(new Card(color, val));
            index ++;
        }
        Card anschauen(){
            return stack.peek();
        }
        Card nehmen(){index --;return stack.pop(); }
    }
}