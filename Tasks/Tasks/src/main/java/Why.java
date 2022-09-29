package main.java;

import SgJavaLib.datenstrukturen.Queue;

public class Why {
    public static void main(String[] args) {
        Queue<String> tmp = new Queue<String>(), og = new Queue<String>();
            
        og.enqueue("Anna");
        og.enqueue("Max");
        og.enqueue("Frida");
        og.enqueue("Moritz");
        og.enqueue("Frank");
        og.enqueue("Luisa");
        og.enqueue("Eva");


        while ( !og.isEmpty()) {

            System.out.println("warteschlange:");
            for (int i = 0; i < 7; i++) {
                Queue<String> h = new Queue<String>();
                System.arraycopy(og, 0, h, 0, 7);
                System.out.println(h.front());
                h.dequeue();       
            } 

            
            System.out.println("tmp:");

            for (int i = 0; i < 7; i++) {
                Queue<String> h = new Queue<String>();
                System.arraycopy(tmp, 0, h, 0, 7);
                System.out.println(h.front());
                h.dequeue();       
            } 


            String c = og.front();
            og.dequeue();

            if (!og.isEmpty()) {
                tmp.enqueue(og.front());
                og.dequeue(); 
            }

            tmp.enqueue(c);
        }
    }
}
