package main.java;

class Main{
    public static void main(String[] args) {
        SgJavaLib.datenstrukturen.Queue<String> queue = new SgJavaLib.datenstrukturen.Queue<String>(), tmp = new SgJavaLib.datenstrukturen.Queue<String>();

        queue.enqueue("Max");
        queue.enqueue("Anna");
        queue.enqueue("Moritz");
        queue.enqueue("Frida");
        queue.enqueue("Luisa");
        queue.enqueue("Frank");
        queue.enqueue("Eva");

        while (!queue.isEmpty()) {
            System.out.println("Schlange: \n" + queue + "\n");
            System.out.println("Tmp: \n"+ tmp + "\n");
            String c1 = queue.front();
            queue.dequeue();

            if (!queue.isEmpty()) {
                tmp.enqueue(queue.front());
                queue.dequeue();
            }

            tmp.enqueue(c1);
        }
    }
}