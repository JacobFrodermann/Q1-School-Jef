/*    */ package SgJavaLib.mars;
/*    */ 
/*    */ import SgJavaLib.mars.model.HamsterScene;
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
/*    */ public class meinAntrieb
/*    */ {
/* 16 */   static SpeedManager speed = SpeedManager.getInstance();
/* 17 */   static HamsterScene scene = HamsterScene.getInstance();
/*    */ 
/*    */ 
/*    */   
/*    */   public static void vorwärts() {
/* 22 */     scene.moveHamsterForward();
/* 23 */     scene.updateHamsterField();
/* 24 */     scene.updatePreHamsterField();
/*    */     
/* 26 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void nachLinksDrehen() {
/* 31 */     scene.turnHamsterLeft();
/* 32 */     scene.updateHamsterField();
/* 33 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static void nachRechtsDrehen() {
/* 37 */     scene.turnHamsterRight();
/* 38 */     scene.updateHamsterField();
/* 39 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void rückwärts() {
/* 44 */     scene.moveHamsterBackwards();
/* 45 */     scene.updateHamsterField();
/* 46 */     scene.updatePreHamsterField();
/* 47 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static void setzeGeschwindigkeit(int pWert) {
/* 51 */     SpeedManager.setSpeed(pWert);
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\meinAntrieb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */