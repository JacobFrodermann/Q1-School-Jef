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
/*    */ public class SasApp
/*    */ {
/*    */   public View myView;
/*    */   public Mouse myMouse;
/*    */   public Tool myTool;
/*    */   public Keyboard myKeyboard;
/*    */   public Timer myTimer;
/*    */   
/*    */   public SasApp() {
/* 22 */     this.myView = View.getInstance();
/* 23 */     this.myMouse = Mouse.getInstance();
/* 24 */     this.myMouse.setApp(this);
/* 25 */     this.myKeyboard = Keyboard.getInstance();
/* 26 */     this.myKeyboard.setApp(this);
/* 27 */     this.myView.setSize(800, 450);
/* 28 */     this.myView.setName("Meine Sas-App");
/* 29 */     this.myTimer = new Timer();
/* 30 */     this.myTimer.setApp(this);
/* 31 */     this.myTool = Tool.getInstance();
/* 32 */     startApp();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void startApp() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyPressed() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void keyTyped() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseClicked() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mousePressed() {}
/*    */ 
/*    */   
/*    */   public void mouseMoved() {}
/*    */ 
/*    */   
/*    */   public void exit() {
/* 60 */     System.exit(0);
/*    */   }
/*    */   
/*    */   public void wait(int millSec) {
/*    */     try {
/* 65 */       Thread.sleep(millSec);
/* 66 */     } catch (InterruptedException ex) {
/* 67 */       System.err.println("Error in Method wait (SasApp)");
/* 68 */       System.err.println(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   public void mouseDragged() {}
/*    */   
/*    */   public void timerFinished() {}
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\SasApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */