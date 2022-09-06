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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class List<ContentType>
/*     */ {
/*     */   ListNode first;
/*     */   ListNode last;
/*     */   ListNode current;
/*     */   
/*     */   private class ListNode
/*     */   {
/*     */     private ContentType contentObject;
/*     */     private ListNode next;
/*     */     
/*     */     private ListNode(ContentType pContent) {
/*  40 */       this.contentObject = pContent;
/*  41 */       this.next = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ContentType getContentObject() {
/*  50 */       return this.contentObject;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setContentObject(ContentType pContent) {
/*  59 */       this.contentObject = pContent;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ListNode getNextNode() {
/*  68 */       return this.next;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNextNode(ListNode pNext) {
/*  78 */       this.next = pNext;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List() {
/*  98 */     this.first = null;
/*  99 */     this.last = null;
/* 100 */     this.current = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 111 */     return (this.first == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAccess() {
/* 122 */     return (this.current != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void next() {
/* 133 */     if (hasAccess()) {
/* 134 */       this.current = this.current.getNextNode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toFirst() {
/* 143 */     if (!isEmpty()) {
/* 144 */       this.current = this.first;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toLast() {
/* 153 */     if (!isEmpty()) {
/* 154 */       this.current = this.last;
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
/*     */   public ContentType getContent() {
/* 167 */     if (hasAccess()) {
/* 168 */       return this.current.getContentObject();
/*     */     }
/* 170 */     return null;
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
/*     */   public void setContent(ContentType pContent) {
/* 184 */     if (pContent != null && hasAccess()) {
/* 185 */       this.current.setContentObject(pContent);
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
/*     */   
/*     */   public void insert(ContentType pContent) {
/* 202 */     if (pContent != null) {
/* 203 */       if (hasAccess()) {
/*     */ 
/*     */         
/* 206 */         ListNode newNode = new ListNode(pContent);
/*     */         
/* 208 */         if (this.current != this.first) {
/* 209 */           ListNode previous = getPrevious(this.current);
/* 210 */           newNode.setNextNode(previous.getNextNode());
/* 211 */           previous.setNextNode(newNode);
/*     */         } else {
/* 213 */           newNode.setNextNode(this.first);
/* 214 */           this.first = newNode;
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 219 */       else if (isEmpty()) {
/*     */ 
/*     */         
/* 222 */         ListNode newNode = new ListNode(pContent);
/*     */         
/* 224 */         this.first = newNode;
/* 225 */         this.last = newNode;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(ContentType pContent) {
/* 243 */     if (pContent != null)
/*     */     {
/* 245 */       if (isEmpty()) {
/* 246 */         insert(pContent);
/*     */       }
/*     */       else {
/*     */         
/* 250 */         ListNode newNode = new ListNode(pContent);
/*     */         
/* 252 */         this.last.setNextNode(newNode);
/* 253 */         this.last = newNode;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void concat(List<ContentType> pList) {
/* 270 */     if (pList != this && pList != null && !pList.isEmpty()) {
/*     */ 
/*     */       
/* 273 */       if (isEmpty()) {
/* 274 */         this.first = pList.first;
/* 275 */         this.last = pList.last;
/*     */       } else {
/* 277 */         this.last.setNextNode(pList.first);
/* 278 */         this.last = pList.last;
/*     */       } 
/*     */ 
/*     */       
/* 282 */       pList.first = null;
/* 283 */       pList.last = null;
/* 284 */       pList.current = null;
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
/*     */   public void remove() {
/* 299 */     if (hasAccess() && !isEmpty()) {
/*     */       
/* 301 */       if (this.current == this.first) {
/* 302 */         this.first = this.first.getNextNode();
/*     */       } else {
/* 304 */         ListNode previous = getPrevious(this.current);
/* 305 */         if (this.current == this.last) {
/* 306 */           this.last = previous;
/*     */         }
/* 308 */         previous.setNextNode(this.current.getNextNode());
/*     */       } 
/*     */       
/* 311 */       ListNode temp = this.current.getNextNode();
/* 312 */       this.current.setContentObject(null);
/* 313 */       this.current.setNextNode(null);
/* 314 */       this.current = temp;
/*     */ 
/*     */       
/* 317 */       if (isEmpty()) {
/* 318 */         this.last = null;
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
/*     */ 
/*     */ 
/*     */   
/*     */   private ListNode getPrevious(ListNode pNode) {
/* 335 */     if (pNode != null && pNode != this.first && !isEmpty()) {
/* 336 */       ListNode temp = this.first;
/* 337 */       while (temp != null && temp.getNextNode() != pNode) {
/* 338 */         temp = temp.getNextNode();
/*     */       }
/* 340 */       return temp;
/*     */     } 
/* 342 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void printList() {
/* 350 */     int anzahl = 0;
/* 351 */     ListNode backupCurrent = this.current;
/*     */     
/* 353 */     toFirst();
/*     */     
/* 355 */     System.out.println("Inhalt der Liste --- Beginn");
/*     */     
/* 357 */     while (hasAccess()) {
/* 358 */       anzahl++;
/* 359 */       if (this.current == backupCurrent) {
/* 360 */         System.out.println("  -> " + anzahl + ": " + getContent().toString());
/*     */       } else {
/*     */         
/* 363 */         System.out.println("     " + anzahl + ": " + getContent().toString());
/*     */       } 
/* 365 */       next();
/*     */     } 
/*     */     
/* 368 */     System.out.println("Ende des Inhalt (" + anzahl + " Elemente)");
/*     */     
/* 370 */     toFirst();
/*     */     
/* 372 */     if (backupCurrent != null)
/* 373 */       while (hasAccess() && this.current != backupCurrent)
/* 374 */         next();  
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\List.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */