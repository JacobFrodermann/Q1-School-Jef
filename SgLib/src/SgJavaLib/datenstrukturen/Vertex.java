/*    */ package SgJavaLib.datenstrukturen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Vertex
/*    */ {
/*    */   private String id;
/*    */   private boolean mark;
/*    */   
/*    */   public Vertex(String pID) {
/* 27 */     this.id = pID;
/* 28 */     this.mark = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getID() {
/* 35 */     return new String(this.id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMark(boolean pMark) {
/* 42 */     this.mark = pMark;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isMarked() {
/* 49 */     return this.mark;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\Vertex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */