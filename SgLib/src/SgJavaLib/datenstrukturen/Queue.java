/*     */ package SgJavaLib.datenstrukturen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Queue<ContentType>
/*     */ {
/*     */   private QueueNode head;
/*     */   private QueueNode tail;
/*     */   
/*     */   private class QueueNode
/*     */   {
/*  26 */     private ContentType content = null;
/*  27 */     private QueueNode nextNode = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public QueueNode(ContentType pContent) {
/*  36 */       this.content = pContent;
/*  37 */       this.nextNode = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNext(QueueNode pNext) {
/*  47 */       this.nextNode = pNext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public QueueNode getNext() {
/*  56 */       return this.nextNode;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ContentType getContent() {
/*  65 */       return this.content;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Queue() {
/*  81 */     this.head = null;
/*  82 */     this.tail = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  92 */     return (this.head == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void enqueue(ContentType pContent) {
/* 103 */     if (pContent != null) {
/* 104 */       QueueNode newNode = new QueueNode(pContent);
/* 105 */       if (isEmpty()) {
/* 106 */         this.head = newNode;
/* 107 */         this.tail = newNode;
/*     */       } else {
/* 109 */         this.tail.setNext(newNode);
/* 110 */         this.tail = newNode;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dequeue() {
/* 120 */     if (!isEmpty()) {
/* 121 */       this.head = this.head.getNext();
/* 122 */       if (isEmpty()) {
/* 123 */         this.head = null;
/* 124 */         this.tail = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentType front() {
/* 138 */     if (isEmpty()) {
/* 139 */       return null;
/*     */     }
/* 141 */     return this.head.getContent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printQueue() {
/* 148 */     int anzahl = 0;
/* 149 */     Queue<ContentType> save = new Queue();
/*     */     
/* 151 */     System.out.println("Inhalt der Schlange --- Beginn bzw. Vorne");
/*     */     
/* 153 */     while (!isEmpty()) {
/* 154 */       anzahl++;
/* 155 */       System.out.println("     " + anzahl + ": " + front().toString());
/* 156 */       save.enqueue(front());
/* 157 */       dequeue();
/*     */     } 
/*     */     
/* 160 */     System.out.println("Ende des Inhalt (" + anzahl + " Elemente) - Hinten");
/*     */     
/* 162 */     while (!save.isEmpty()) {
/* 163 */       enqueue(save.front());
/* 164 */       save.dequeue();
/*     */     } 
/* 166 */     save = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\Queue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */