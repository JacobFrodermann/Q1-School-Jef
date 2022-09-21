import SgJavaLib.datenstrukturen.Queue;

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
}