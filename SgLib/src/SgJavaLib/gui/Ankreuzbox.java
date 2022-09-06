/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.event.ItemEvent;
/*    */ import java.awt.event.ItemListener;
/*    */ import javax.swing.JCheckBox;
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
/*    */ public class Ankreuzbox
/*    */   extends Komponente
/*    */ {
/*    */   JCheckBox dieBox;
/*    */   
/*    */   public Ankreuzbox(String pText) {
/* 24 */     final Ankreuzbox thisOne = this;
/* 25 */     this.dieBox = new JCheckBox(pText);
/* 26 */     this.komp = this.dieBox;
/* 27 */     this.komp.addMouseListener(Maus.getInstance());
/* 28 */     this.komp.addMouseMotionListener(Maus.getInstance());
/* 29 */     this.komp.addKeyListener(Tastatur.getInstance());
/* 30 */     this.komp.setSize(this.komp.getPreferredSize());
/* 31 */     this.komp.setLocation(0, 0);
/* 32 */     Fenster.getInstance().anheften(this);
/* 33 */     this.dieBox.addItemListener(new ItemListener() {
/*    */           public void itemStateChanged(ItemEvent e) {
/* 35 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*    */           }
/*    */         });
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Ankreuzbox(String pText, int pX, int pY, int pBreite, int pHoehe) {
/* 53 */     final Ankreuzbox thisOne = this;
/* 54 */     this.dieBox = new JCheckBox(pText);
/* 55 */     this.komp = this.dieBox;
/* 56 */     this.komp.addMouseListener(Maus.getInstance());
/* 57 */     this.komp.addMouseMotionListener(Maus.getInstance());
/* 58 */     this.komp.addKeyListener(Tastatur.getInstance());
/* 59 */     platzieren(pX, pY, pBreite, pHoehe);
/* 60 */     Fenster.getInstance().anheften(this);
/* 61 */     this.dieBox.addItemListener(new ItemListener() {
/*    */           public void itemStateChanged(ItemEvent e) {
/* 63 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*    */           }
/*    */         });
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
/*    */   public void setzeText(String pText) {
/* 77 */     this.dieBox.setText(pText);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean istAngekreuzt() {
/* 85 */     return this.dieBox.isSelected();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setzeKreuz(boolean pAngekreuzt) {
/* 93 */     this.dieBox.setSelected(pAngekreuzt);
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Ankreuzbox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */