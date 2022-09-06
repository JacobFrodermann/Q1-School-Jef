/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.Point;
/*    */ import java.awt.event.MouseEvent;
/*    */ import java.awt.event.MouseListener;
/*    */ import java.awt.event.MouseMotionListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Maus
/*    */   implements MouseMotionListener, MouseListener
/*    */ {
/*    */   private static Maus instance;
/*    */   Point mausAction;
/*    */   EgJavaApp parent;
/*    */   int buttonNo;
/*    */   
/*    */   static Maus getInstance() {
/* 22 */     if (instance == null) {
/* 23 */       instance = new Maus();
/*    */     }
/* 25 */     return instance;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Maus() {
/* 34 */     this.mausAction = new Point(0, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   void setzeFenster(EgJavaApp pParent) {
/* 39 */     this.parent = pParent;
/*    */   }
/*    */ 
/*    */   
/*    */   public int gibX() {
/* 44 */     return this.mausAction.x;
/*    */   }
/*    */   
/*    */   public int gibY() {
/* 48 */     return this.mausAction.y;
/*    */   }
/*    */   
/*    */   public int gibMaustaste() {
/* 52 */     return this.buttonNo;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseDragged(MouseEvent e) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void mouseMoved(MouseEvent e) {
/* 62 */     this.mausAction = e.getPoint();
/* 63 */     this.parent.mausBewegt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void mouseClicked(MouseEvent e) {
/* 68 */     this.mausAction = e.getPoint();
/* 69 */     this.buttonNo = e.getButton();
/* 70 */     this.parent.mausGedrueckt();
/* 71 */     Fenster.getInstance().setzeZuletztAngeklickt(null);
/*    */   }
/*    */   
/*    */   public void mousePressed(MouseEvent e) {}
/*    */   
/*    */   public void mouseReleased(MouseEvent e) {}
/*    */   
/*    */   public void mouseEntered(MouseEvent e) {}
/*    */   
/*    */   public void mouseExited(MouseEvent e) {}
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Maus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */