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
/*    */ public class SimpleSasApp
/*    */ {
/*    */   public View myView;
/*    */   public Mouse myMouse;
/*    */   public Tool myTool;
/*    */   public Keyboard myKeyboard;
/*    */   public Timer myTimer;
/*    */   public Stopwatch myStopper;
/*    */   
/*    */   public SimpleSasApp() {
/* 23 */     this.myView = View.getInstance();
/* 24 */     this.myMouse = Mouse.getInstance();
/* 25 */     this.myKeyboard = Keyboard.getInstance();
/* 26 */     this.myView.setSize(800, 450);
/* 27 */     this.myView.setName("Meine Sas-App");
/* 28 */     this.myTimer = new Timer();
/* 29 */     this.myTool = Tool.getInstance();
/* 30 */     this.myStopper = new Stopwatch();
/* 31 */     startApp();
/*    */   }
/*    */   
/*    */   public void startApp() {}
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\SimpleSasApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */