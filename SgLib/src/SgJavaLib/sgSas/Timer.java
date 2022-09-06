/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import java.util.TimerTask;
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
/*    */ public class Timer
/*    */ {
/*    */   SasApp app;
/* 19 */   int time = 0;
/* 20 */   int remainingTime = 0;
/*    */   
/*    */   java.util.Timer timer;
/*    */   boolean running = false;
/*    */   
/*    */   public void setTime(int pTime) {
/* 26 */     this.time = pTime;
/*    */   }
/*    */   
/*    */   public int getTime() {
/* 30 */     return this.time;
/*    */   }
/*    */   
/*    */   public void start() {
/* 34 */     this.running = true;
/* 35 */     TimerTask task = new TimerTask() {
/* 36 */         int seconds = Timer.this.time;
/* 37 */         int i = 0;
/*    */ 
/*    */         
/*    */         public void run() {
/* 41 */           this.i++;
/*    */           
/* 43 */           if (this.i % this.seconds == 0) {
/* 44 */             Timer.this.remainingTime = 0;
/* 45 */             Timer.this.running = false;
/* 46 */             if (Timer.this.app != null) {
/* 47 */               Timer.this.app.timerFinished();
/*    */             }
/*    */           } else {
/*    */             
/* 51 */             Timer.this.remainingTime = this.seconds - this.i % this.seconds;
/*    */           } 
/*    */         }
/*    */       };
/*    */     
/* 56 */     this.timer = new java.util.Timer();
/* 57 */     this.timer.schedule(task, 0L, 1000L);
/*    */   }
/*    */   
/*    */   public void stop() {
/* 61 */     this.timer.cancel();
/* 62 */     this.time = 0;
/* 63 */     this.remainingTime = 0;
/* 64 */     this.running = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isRunning() {
/* 69 */     return this.running;
/*    */   }
/*    */   
/*    */   public int getRemainingTime() {
/* 73 */     return this.remainingTime;
/*    */   }
/*    */   
/*    */   void setApp(SasApp pApp) {
/* 77 */     this.app = pApp;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Timer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */