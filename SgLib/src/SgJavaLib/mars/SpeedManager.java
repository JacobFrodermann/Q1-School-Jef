/*    */ package SgJavaLib.mars;
/*    */ 
/*    */ import SgJavaLib.mars.gui.HamsterMainFrame;
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
/*    */ public class SpeedManager
/*    */ {
/*    */   static int speed;
/*    */   private static SpeedManager instance;
/*    */   
/*    */   private SpeedManager() {
/* 23 */     speed = 5;
/*    */   }
/*    */   
/*    */   public static SpeedManager getInstance() {
/* 27 */     if (instance == null) {
/* 28 */       instance = new SpeedManager();
/*    */     }
/* 30 */     return instance;
/*    */   }
/*    */   
/*    */   public static void setSpeed(int pSpeed) {
/* 34 */     if (pSpeed <= 10 && pSpeed >= 1) {
/* 35 */       speed = pSpeed;
/*    */     }
/*    */   }
/*    */   
/*    */   public static void sleepForSpeedAdjustment() {
/* 40 */     int sleepTime = 0;
/*    */     
/* 42 */     switch (speed) {
/*    */       case 1:
/* 44 */         sleepTime = 5000;
/*    */         break;
/*    */       case 2:
/* 47 */         sleepTime = 4000;
/*    */         break;
/*    */       case 3:
/* 50 */         sleepTime = 3000;
/*    */         break;
/*    */       case 4:
/* 53 */         sleepTime = 2000;
/*    */         break;
/*    */       case 5:
/* 56 */         sleepTime = 1000;
/*    */         break;
/*    */       case 6:
/* 59 */         sleepTime = 500;
/*    */         break;
/*    */       case 7:
/* 62 */         sleepTime = 250;
/*    */         break;
/*    */       case 8:
/* 65 */         sleepTime = 100;
/*    */         break;
/*    */       case 9:
/* 68 */         sleepTime = 10;
/*    */         break;
/*    */       case 10:
/* 71 */         sleepTime = 0;
/*    */         break;
/*    */       default:
/* 74 */         sleepTime = 1000;
/*    */         break;
/*    */     } 
/*    */     
/*    */     try {
/* 79 */       Thread.sleep(sleepTime);
/* 80 */     } catch (InterruptedException ex) {
/* 81 */       HamsterMainFrame.getInstance().showTechnicalErrorMessage("Fehler beim Verzögern in Speedmanager\n" + ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\SpeedManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */