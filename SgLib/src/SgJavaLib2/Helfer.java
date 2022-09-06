/*    */ package SgJavaLib2;
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
/*    */ public class Helfer
/*    */ {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void schlafe(int millis) {
/*    */     try {
/* 51 */       Thread.sleep(millis);
/* 52 */     } catch (InterruptedException e) {
                e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib2\Helfer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */