/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.View;
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
/*    */ public class Keyboard
/*    */ {
/*    */   View myView;
/*    */   SasApp app;
/*    */   private static Keyboard instance;
/*    */   
/*    */   public static Keyboard getInstance() {
/* 21 */     if (instance == null) {
/* 22 */       instance = new Keyboard();
/*    */     }
/* 24 */     return instance;
/*    */   }
/*    */   
/*    */   private Keyboard() {
/* 28 */     this.myView = View.getInstance().getSaSView();
/*    */   }
/*    */   
/*    */   public boolean keyBackspacePressed() {
/* 32 */     return this.myView.keyBackspacePressed();
/*    */   }
/*    */   
/*    */   public boolean keyEnterPressed() {
/* 36 */     return this.myView.keyEnterPressed();
/*    */   }
/*    */   
/*    */   public String keyGetChar() {
/* 40 */     return this.myView.keyGetChar() + "";
/*    */   }
/*    */   
/*    */   public boolean keyPressed(String pT) {
/* 44 */     return this.myView.keyPressed(pT.charAt(0));
/*    */   }
/*    */   
/*    */   public boolean keyPressed() {
/* 48 */     return this.myView.keyPressed();
/*    */   }
/*    */   
/*    */   public boolean keyLeftPressed() {
/* 52 */     return this.myView.keyLeftPressed();
/*    */   }
/*    */   
/*    */   public boolean keyUpPressed() {
/* 56 */     return this.myView.keyUpPressed();
/*    */   }
/*    */   
/*    */   public boolean keyDownPressed() {
/* 60 */     return this.myView.keyDownPressed();
/*    */   }
/*    */   
/*    */   public boolean keyRightPressed() {
/* 64 */     return this.myView.keyRightPressed();
/*    */   }
/*    */   
/*    */   public void keyBufferDelete() {
/* 68 */     this.myView.keyBufferDelete();
/*    */   }
/*    */   
/*    */   void setApp(SasApp pApp) {
/* 72 */     this.app = pApp;
/*    */   }
/*    */   
/*    */   public void handleKeyTyped() {
/* 76 */     if (this.app != null) {
/* 77 */       this.app.keyPressed();
/*    */     }
/*    */   }
/*    */   
/*    */   public void handleKeyPressed() {
/* 82 */     if (this.app != null)
/* 83 */       this.app.keyTyped(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Keyboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */