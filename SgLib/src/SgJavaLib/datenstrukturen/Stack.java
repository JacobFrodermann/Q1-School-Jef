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
/*     */ 
/*     */ 
/*     */ public class Stack<ContentType>
/*     */ {
/*     */   private StackNode head;
/*     */   
/*     */   private class StackNode
/*     */   {
/*  27 */     private ContentType content = null;
/*  28 */     private StackNode nextNode = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackNode(ContentType pContent) {
/*  37 */       this.content = pContent;
/*  38 */       this.nextNode = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNext(StackNode pNext) {
/*  48 */       this.nextNode = pNext;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public StackNode getNext() {
/*  56 */       return this.nextNode;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ContentType getContent() {
/*  63 */       return this.content;
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
/*     */   public Stack() {
/*  76 */     this.head = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  86 */     return (this.head == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(ContentType pContent) {
/*  97 */     if (pContent != null) {
/*  98 */       StackNode node = new StackNode(pContent);
/*  99 */       node.setNext(this.head);
/* 100 */       this.head = node;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pop() {
/* 109 */     if (!isEmpty()) {
/* 110 */       this.head = this.head.getNext();
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
/*     */   public ContentType top() {
/* 122 */     if (!isEmpty()) {
/* 123 */       return this.head.getContent();
/*     */     }
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printStack() {
/* 133 */     int anzahl = 0;
/* 134 */     Stack<ContentType> save = new Stack();
/*     */     
/* 136 */     System.out.println("Inhalt des Stapels --- Beginn bzw. Oben");
/*     */     
/* 138 */     while (!isEmpty()) {
/* 139 */       anzahl++;
/* 140 */       System.out.println("     " + anzahl + ": " + top().toString());
/* 141 */       save.push(top());
/* 142 */       pop();
/*     */     } 
/*     */     
/* 145 */     System.out.println("Ende des Inhalt (" + anzahl + " Elemente) - Boden");
/*     */     
/* 147 */     while (!save.isEmpty()) {
/* 148 */       push(save.top());
/* 149 */       save.pop();
/*     */     } 
/* 151 */     save = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\Stack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */