/*    */ package SgJavaLib.sgSas;
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
/*    */ public class Stopwatch
/*    */ {
/* 19 */   long time = 0L;
/* 20 */   long start = 0L;
/*    */ 
/*    */   
/*    */   boolean running = false;
/*    */ 
/*    */ 
/*    */   
/*    */   public long getTime() {
/* 28 */     if (isRunning()) {
/* 29 */       this.time = System.currentTimeMillis() - this.start;
/* 30 */       return this.time;
/*    */     } 
/*    */     
/* 33 */     return this.time;
/*    */   }
/*    */   
/*    */   public void start() {
/* 37 */     this.running = true;
/* 38 */     this.time = 0L;
/* 39 */     this.start = 0L;
/* 40 */     this.start = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public void stop() {
/* 44 */     this.time = System.currentTimeMillis() - this.start;
/* 45 */     this.running = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRunning() {
/* 50 */     return this.running;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Stopwatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */