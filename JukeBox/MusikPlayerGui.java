import SgJavaLib.gui.EgJavaApp;
import SgJavaLib.gui.Etikett;
import SgJavaLib.gui.Knopf;
import SgJavaLib.gui.Textfeld; 

public class MusikPlayerGui extends EgJavaApp {
    //GuiObjekte
    Etikett dasEtikett = new Etikett("Music Player 2022", 170,0, 250, 30);
    Etikett runningSongEtikett = new Etikett("Es läuft gerade: ", 10,70, 250, 30);
    Etikett wartezimmerEtikett = new Etikett("Wiedergabe Queue", 150,120, 250, 30);
    Textfeld wartezimmerTextfeld = new Textfeld("Warteschlange der Songs", 130,150,250,300);
    Knopf playKnopf = new Knopf("Play",20,500,90,50);
    Knopf nextKnopf = new Knopf("Next",120,500,90,50);
    Knopf stopKnopf = new Knopf("Stop",220,500,90,50);
    Knopf addSongKnopf = new Knopf("Add Song",320,500,120,50);
    
    
    // Attribute

    
    
    // Konstruktor
    public MusikPlayerGui(){
        super("Musik Player 2017");
        meinFenster.setzeGroesse(530,600);
        dasEtikett.setzeSchriftgroesse(20);
        runningSongEtikett.setzeSchriftgroesse(16);
    }
    
    //Ereignis-Methode: Wird automatisch aufgerufen, wenn ein Mausklick erfolgte..
    public void mausGedrueckt(){
        if(meinFenster.gibZuletztAngeklickt() == playKnopf){
            Player.INSTANCE.play();
        }
        else if(meinFenster.gibZuletztAngeklickt() == nextKnopf){
            Player.INSTANCE.skip();
        }
        else if(meinFenster.gibZuletztAngeklickt() == stopKnopf){
            Player.INSTANCE.interrupt();
        }
        else if(meinFenster.gibZuletztAngeklickt() == addSongKnopf){
            
        }
    }
    
    
    
}
