/*    */ package SgJavaLib.mars;
/*    */ 
/*    */ import SgJavaLib.mars.gui.HamsterMainFrame;
/*    */ import SgJavaLib.mars.model.HamsterScene;
/*    */ import java.awt.Component;
/*    */ import java.util.Random;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class meinBoardComputer
/*    */ {
/* 19 */   private static Random rand = new Random();
/*    */ 
/*    */ 
/*    */   
/*    */   public static void sendeNachricht(String pNachricht) {
/* 24 */     JOptionPane.showMessageDialog((Component)HamsterMainFrame.getInstance(), pNachricht, "MarsRover an Benutzer:", 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String empfangeText() {
/* 29 */     return HamsterMainFrame.getInstance().showInputDialogText();
/*    */   }
/*    */   
/*    */   public static int empfangeZahl() {
/* 33 */     return HamsterMainFrame.getInstance().showInputDialogNumber();
/*    */   }
/*    */   
/*    */   public static int gibZufallszahl(int pVon, int pBis) {
/* 37 */     int randomNum = rand.nextInt(pBis - pVon + 1) + pVon;
/*    */     
/* 39 */     return randomNum;
/*    */   }
/*    */   
/*    */   public static void initSystem() {
/* 43 */     HamsterScene.getInstance().loadFrameWithRecentWorld();
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\meinBoardComputer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */