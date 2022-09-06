/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
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
/*    */ 
/*    */ public class Knopf
/*    */   extends Komponente
/*    */ {
/*    */   JButton button;
/*    */   
/*    */   public Knopf(String pBeschriftung) {
/* 24 */     final Knopf thisOne = this;
/* 25 */     this.button = new JButton(pBeschriftung);
/* 26 */     this.button.addActionListener(new ActionListener()
/*    */         {
/*    */           public void actionPerformed(ActionEvent e) {
/* 29 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*    */           }
/*    */         });
/*    */     
/* 33 */     this.komp = this.button;
/* 34 */     this.komp.addMouseListener(Maus.getInstance());
/* 35 */     this.komp.addMouseMotionListener(Maus.getInstance());
/* 36 */     this.komp.addKeyListener(Tastatur.getInstance());
/*    */     
/* 38 */     this.komp.setSize(this.komp.getPreferredSize());
/* 39 */     this.komp.setLocation(0, 0);
/* 40 */     Fenster.getInstance().anheften(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Knopf(String pBeschriftung, int pX, int pY, int pBreite, int pHoehe) {
/* 52 */     final Knopf thisOne = this;
/* 53 */     this.button = new JButton(pBeschriftung);
/*    */     
/* 55 */     this.komp = this.button;
/*    */     
/* 57 */     this.komp.addMouseListener(Maus.getInstance());
/* 58 */     this.komp.addMouseMotionListener(Maus.getInstance());
/* 59 */     this.komp.addKeyListener(Tastatur.getInstance());
/* 60 */     platzieren(pX, pY, pBreite, pHoehe);
/* 61 */     Fenster.getInstance().anheften(this);
/* 62 */     this.button.addActionListener(new ActionListener()
/*    */         {
/*    */           public void actionPerformed(ActionEvent e) {
/* 65 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*    */           }
/*    */         });
/*    */     
/* 69 */     Fenster.getInstance().anheften(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setzeText(String pText) {
/* 78 */     this.button.setText(pText);
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Knopf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */