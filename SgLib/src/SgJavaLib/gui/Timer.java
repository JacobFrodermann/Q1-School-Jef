/*    */ package SgJavaLib.gui;
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
/*    */ public class Timer
/*    */ {
/*    */   private EgJavaApp theApp;
/* 18 */   int time = 0;
/* 19 */   int remainingTime = 0;
/*    */   
/*    */   java.util.Timer timer;
/*    */   boolean running = false;
/*    */   
/*    */   public void setzeZeit(int pTime) {
/* 25 */     this.time = pTime;
/*    */   }
/*    */   
/*    */   public int gibZeit() {
/* 29 */     return this.time;
/*    */   }
/*    */   
/*    */   public void start() {
/* 33 */     this.running = true;
/* 34 */     TimerTask task = new TimerTask() {
/* 35 */         int seconds = Timer.this.time;
/* 36 */         int i = 0;
/*    */ 
/*    */         
/*    */         public void run() {
/* 40 */           this.i++;
/*    */           
/* 42 */           if (this.i % this.seconds == 0) {
/* 43 */             Timer.this.remainingTime = 0;
/* 44 */             Timer.this.running = false;
/* 45 */             if (Timer.this.theApp != null) {
/* 46 */               Timer.this.theApp.timerAbgelaufen();
/*    */             }
/*    */           } else {
/*    */             
/* 50 */             Timer.this.remainingTime = this.seconds - this.i % this.seconds;
/*    */           } 
/*    */         }
/*    */       };
/*    */     
/* 55 */     this.timer = new java.util.Timer();
/* 56 */     this.timer.schedule(task, 0L, 1000L);
/*    */   }
/*    */   
/*    */   public void stop() {
/* 60 */     this.timer.cancel();
/* 61 */     this.time = 0;
/* 62 */     this.remainingTime = 0;
/* 63 */     this.running = false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean laeuftNoch() {
/* 68 */     return this.running;
/*    */   }
/*    */   
/*    */   public int gibVerbleibendeZeit() {
/* 72 */     return this.remainingTime;
/*    */   }
/*    */   
/*    */   void setzeApp(EgJavaApp pApp) {
/* 76 */     this.theApp = pApp;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Timer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */