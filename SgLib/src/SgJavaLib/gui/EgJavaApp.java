/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import SgJavaLib2.Helfer;
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
/*    */ public class EgJavaApp
/*    */ {
/*    */   protected Fenster meinFenster;
/*    */   protected Maus meineMaus;
/*    */   protected Tastatur meineTastatur;
/*    */   protected Helfer meinHelfer;
/*    */   protected Timer meinTimer;
/*    */   
/*    */   public EgJavaApp() {
/* 23 */     this.meinFenster = Fenster.getInstance();
/* 24 */     this.meineMaus = Maus.getInstance();
/* 25 */     this.meineMaus.setzeFenster(this);
/* 26 */     this.meineTastatur = Tastatur.getInstance();
/* 27 */     this.meineTastatur.setzeFenster(this);
/* 28 */     this.meinHelfer = new Helfer();
/* 29 */     this.meinTimer = new Timer();
/* 30 */     this.meinTimer.setzeApp(this);
/* 31 */     this.meinFenster.anzeigen();
/*    */   }
/*    */   
/*    */   public EgJavaApp(String pTitel) {
/* 35 */     this.meinFenster = Fenster.getInstance();
/* 36 */     this.meineMaus = Maus.getInstance();
/* 37 */     this.meineMaus.setzeFenster(this);
/* 38 */     this.meineTastatur = Tastatur.getInstance();
/* 39 */     this.meineTastatur.setzeFenster(this);
/* 40 */     this.meinHelfer = new Helfer();
/* 41 */     this.meinTimer = new Timer();
/* 42 */     this.meinTimer.setzeApp(this);
/* 43 */     this.meinFenster.setzeTitel(pTitel);
/* 44 */     this.meinFenster.anzeigen();
/*    */   }
/*    */   
/*    */   public void mausGedrueckt() {}
/*    */   
/*    */   public void mausBewegt() {}
/*    */   
/*    */   public void tasteGedrueckt() {}
/*    */   
/*    */   public void timerAbgelaufen() {}
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\EgJavaApp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */