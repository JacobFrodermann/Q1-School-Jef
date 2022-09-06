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
/*    */ public class meinRadar
/*    */ {
/* 16 */   static HamsterScene scene = HamsterScene.getInstance();
/*    */ 
/*    */ 
/*    */   
/*    */   public static void zurFahrtrichtung() {
/* 21 */     scene.resetRadarToDirection();
/* 22 */     scene.updateHamsterField();
/* 23 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static void nachLinksDrehen() {
/* 27 */     scene.moveRadarLeft();
/* 28 */     scene.updateHamsterField();
/* 29 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static void nachRechtsDrehen() {
/* 33 */     scene.moveRadarRight();
/* 34 */     scene.updateHamsterField();
/* 35 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static boolean inRadarrichtungFrei() {
/* 39 */     return scene.checkFreeForForward();
/*    */   }
/*    */   
/*    */   public static boolean kristallAufBoden() {
/* 43 */     return scene.checkCornOnHamsterField();
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\meinRadar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */