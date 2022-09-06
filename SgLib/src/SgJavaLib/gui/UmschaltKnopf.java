/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JToggleButton;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
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
/*    */ public class UmschaltKnopf
/*    */   extends Komponente
/*    */ {
/*    */   JToggleButton button;
/*    */   ImageIcon dasBild1;
/*    */   ImageIcon dasBild2;
/*    */   
/*    */   public UmschaltKnopf(String pDateipfadAktiviert, String pDateipfadDeaktiviert, int pX, int pY, int pBreite, int pHoehe) {
/* 29 */     final UmschaltKnopf thisOne = this;
/*    */     try {
/* 31 */       BufferedImage myPicture1 = ImageIO.read(new File(pDateipfadAktiviert));
/* 32 */       this.dasBild1 = new ImageIcon(myPicture1);
/*    */       
/* 34 */       BufferedImage myPicture2 = ImageIO.read(new File(pDateipfadDeaktiviert));
/* 35 */       this.dasBild2 = new ImageIcon(myPicture2);
/*    */     
/*    */     }
/* 38 */     catch (IOException ex) {
/* 39 */       System.err.println("Konnte Bild-Datei nicht laden. (Falscher Dateipfad?)");
/* 40 */       this.dasBild1 = new ImageIcon(getClass().getResource("/bilder/nichtGefunden.jpg"));
/* 41 */       this.dasBild2 = new ImageIcon(getClass().getResource("/bilder/nichtGefunden.jpg"));
/*    */     } 
/* 43 */     this.button = new JToggleButton(this.dasBild1);
/* 44 */     this.komp = this.button;
/* 45 */     this.komp.addMouseListener(Maus.getInstance());
/* 46 */     this.komp.addMouseMotionListener(Maus.getInstance());
/* 47 */     this.komp.addKeyListener(Tastatur.getInstance());
/* 48 */     this.button.setSelectedIcon(this.dasBild2);
/* 49 */     setzeGroesse(pBreite, pHoehe);
/* 50 */     platzieren(pX, pY, pBreite, pHoehe);
/* 51 */     Fenster.getInstance().anheften(this);
/*    */     
/* 53 */     ChangeListener changeListener = new ChangeListener() {
/*    */         public void stateChanged(ChangeEvent changeEvent) {
/* 55 */           Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*    */         }
/*    */       };
/* 58 */     this.button.addChangeListener(changeListener);
/*    */   }
/*    */   
/*    */   public void setzeGroesse(int pBreite, int pHoehe) {
/* 62 */     this.dasBild1.setImage(this.dasBild1.getImage().getScaledInstance(pBreite, pHoehe, 1));
/* 63 */     this.dasBild2.setImage(this.dasBild2.getImage().getScaledInstance(pBreite, pHoehe, 1));
/* 64 */     super.setzeGroesse(pBreite, pHoehe);
/*    */   }
/*    */   
/*    */   public boolean istAngekreuzt() {
/* 68 */     return this.button.isSelected();
/*    */   }
/*    */   
/*    */   public void setzeAngekreuzt(boolean pAngekreuzt) {
/* 72 */     this.button.setSelected(pAngekreuzt);
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\UmschaltKnopf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */