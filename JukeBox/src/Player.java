import SgJavaLib.datenstrukturen.Queue;
class Player {

    public static Player INSTANCE = new Player();

    public int totalDuration = 0, count = 0;
    Thread t = Thread.currentThread();
    Queue<Title> queue = new Queue<Title>(); 
    
    void add( Title title) {
        queue.enqueue(title);
        count++;
        totalDuration += title.duration;
    }
    void play(){
        while (!queue.isEmpty()) {
            Title t = queue.front();
            System.out.println("Es läuft:" + t.title + " von " + t.artist);
            try{Thread.sleep(t.duration);} catch (Exception e){}
            dequeue(t);
        }
    }
    
    void skip(){
        t.interrupt();
        dequeue(queue.front());
    }
    void vote(int rating) {
        queue.front().vote(rating);
    }
    void dequeue(Title t) {
        queue.dequeue();
        count --;
        totalDuration -= t.duration;
    }

    void interrupt() {
        t.interrupt();
        dequeue(queue.front());
    }

    class Title {
        String artist,genre,title;
        private int duration,votes,score;
        double rating;
        Title(String title,String artist, String genre, int duration){
            this.title=title;this.artist = artist;this.genre = genre; this.duration = duration;
            votes = 0;
            score = 0;
            rating = 2.5;
        }
        void vote(int i) {
            i = i%5;
            score += i;
            votes ++;
            rating = score/votes;
        }
    }
}
