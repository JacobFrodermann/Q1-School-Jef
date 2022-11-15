import java.util.ArrayList;
import java.util.List;

public class Playlist {
    List<Song> list = new ArrayList<Song>();
    int current = 0;
    
    void toLast() {current = list.size()-1;}
    void toFirst(){current  = 0;}
    void insertSong(Song s){list.add(current, s);}
    void next(){current++;}
    void previous(){current--;}
    void shiftToNext() {
        Song s = list.get(current);
        list.add(current +1,s);
    }
    void shiftToPrev(){
        Song s = list.get(current);
        list.remove(s);
        list.add(current + 1,s);
    }
    int getIndex(){return list.size();}
    void removeCurrent(){list.remove(current);}
    Song getCurrent() {return list.get(current);}
    void addLast(Song s){list.add(s);}
    void addFirst(Song s) {list.add(0,s);}
    void empty(){list.clear();}
    private class Song{
        String artist = "",title = "";
        Song(String artist, String title){
            this.artist = artist;
            this.title = title;
        }
        public String getTitle() {
            return title;
        }
        public String getArtist() {
            return artist;
        }
    }
}
