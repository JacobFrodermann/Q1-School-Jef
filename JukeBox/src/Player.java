import SgJavaLib.datenstrukturen.Queue;
class Player {
    Thread t = Thread.currentThread();
    Queue<Title> queue = new Queue<Title>(); 
    
    void add( Title title) {
        queue.enqueue(title);
    }
    void play(){
        while (!queue.isEmpty()) {
            Title t = queue.front();
            System.out.println("Es läuft:" + t.title + " von " + t.artist);
            try{Thread.sleep(t.duration);} catch (Exception e){}
            queue.dequeue();
        }
    }
    
    void skip(){
        t.interrupt();
        queue.dequeue();
    }
    void vote(int rating) {
        queue.front().vote(rating);
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
