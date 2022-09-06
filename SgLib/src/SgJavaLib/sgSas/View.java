/*     */ package SgJavaLib.sgSas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.LinkedList;
/*     */ import javax.swing.JOptionPane;
/*     */ import sas.Shapes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class View
/*     */ {
/*     */   sas.View mySasView;
/*     */   private static View instance;
/*     */   Shapes lastClicked;
/*     */   Shapes lastPressed;
/*     */   
/*     */   public void setLastClicked(Shapes pShape) {
/*  32 */     this.lastClicked = pShape;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static View getInstance() {
/*  38 */     if (instance == null) {
/*  39 */       instance = new View();
/*     */     }
/*  41 */     return instance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private View() {
/*  47 */     this.mySasView = new sas.View(800, 600, "SaS-App");
/*     */   }
/*     */ 
/*     */   
/*     */   public Shapes getLastClicked() {
/*  52 */     Shapes s = this.lastClicked;
/*  53 */     this.lastClicked = null;
/*  54 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Shapes getLastPressed() {
/*  60 */     Shapes s = this.lastPressed;
/*  61 */     this.lastPressed = null;
/*  62 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public Color getColorAt(int pX, int pY) {
/*  67 */     return this.mySasView.getColorAt(pX, pY);
/*     */   }
/*     */   
/*     */   public String getHexColorAt(int pX, int pY) {
/*  71 */     return this.mySasView.getHexColorAt(pX, pY);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBackgroundHexColor(String pColor) {
/*  76 */     this.mySasView.setBackgroundColor(egFactory.getColor(pColor));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBackgroundColor(Color pColor) {
/*  81 */     this.mySasView.setBackgroundColor(pColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSize(int pWwidth, int pHeight) {
/*  86 */     this.mySasView.setSize(pWwidth, pHeight);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String pName) {
/*  91 */     this.mySasView.setName(pName);
/*     */   }
/*     */   
/*     */   public void wait(int pMillSec) {
/*  95 */     this.mySasView.wait(pMillSec);
/*     */   }
/*     */   
/*     */   public sas.View getSaSView() {
/*  99 */     return this.mySasView;
/*     */   }
/*     */   
/*     */   public void zeigeInfoDialog(String pNachricht) {
/* 103 */     JOptionPane.showMessageDialog(null, pNachricht, "Info", 1);
/*     */   }
/*     */   
/*     */   public String zeigeEingabeDialog(String pNachricht) {
/* 107 */     return JOptionPane.showInputDialog(null, pNachricht, "Eingabe erforderlich", -1);
/*     */   }
/*     */   
/*     */   public void beendeProgramm() {
/* 111 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void setLastPressed(Shapes pShape) {
/* 115 */     this.lastPressed = pShape;
/*     */   }
/*     */   
/*     */   public boolean appIsRunning() {
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   public Shapes getShapeAt(int pX, int pY) {
/* 123 */     return this.mySasView.getShapeAt(pX, pY);
/*     */   }
/*     */   
/*     */   public boolean collisionDetected() {
/* 127 */     return this.mySasView.collisionDetected();
/*     */   }
/*     */   
/*     */   public LinkedList<Shapes> getCollidingObjects() {
/* 131 */     return this.mySasView.getCollidingObjects();
/*     */   }
/*     */   
/*     */   public void setResizable(boolean pResizeable) {
/* 135 */     this.mySasView.setResizable(pResizeable);
/*     */   }
/*     */   
/*     */   public void toCenter() {
/* 139 */     this.mySasView.toCenter();
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 143 */     return sas.View.getView().getWidth();
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 147 */     return sas.View.getView().getHeigth();
/*     */   }
/*     */   
/*     */   public void hideMouse(boolean pNoMouse) {
/* 151 */     this.mySasView.hideMouse(pNoMouse);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\View.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */