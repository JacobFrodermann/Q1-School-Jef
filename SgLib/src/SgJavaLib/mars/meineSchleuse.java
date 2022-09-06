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
/*    */ public class meineSchleuse
/*    */ {
/* 16 */   static HamsterScene scene = HamsterScene.getInstance();
/*    */ 
/*    */ 
/*    */   
/*    */   public static void einKristallAufnehmen() {
/* 21 */     scene.takeCornFromFieldToHamster();
/* 22 */     scene.updateHamsterField();
/* 23 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static void einKristallAbgeben() {
/* 27 */     scene.addCornFromHamsterToField();
/* 28 */     scene.updateHamsterField();
/* 29 */     SpeedManager.sleepForSpeedAdjustment();
/*    */   }
/*    */   
/*    */   public static boolean keineKristalleImLager() {
/* 33 */     return scene.checkHamsterHasCorn();
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\meineSchleuse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */