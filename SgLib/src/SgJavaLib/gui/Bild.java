/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
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
/*    */ public class Bild
/*    */   extends Komponente
/*    */ {
/*    */   ImageIcon dasBild;
/*    */   
/*    */   public Bild(String pDateipfad) {
/*    */     try {
/* 27 */       BufferedImage myPicture = ImageIO.read(new File(pDateipfad));
/* 28 */       this.dasBild = new ImageIcon(myPicture);
/*    */     }
/* 30 */     catch (IOException ex) {
/* 31 */       System.err.println("Konnte Bild-Datei nicht laden. (Falscher Dateipfad?)");
/* 32 */       this.dasBild = new ImageIcon(getClass().getResource("/bilder/nichtGefunden.jpg"));
/*    */     } 
/* 34 */     this.komp = new JLabel(this.dasBild);
/* 35 */     this.komp.setSize(this.komp.getPreferredSize());
/* 36 */     this.komp.setLocation(0, 0);
/* 37 */     Fenster.getInstance().anheften(this);
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
/*    */   public Bild(String pDateipfad, int pX, int pY, int pBreite, int pHoehe) {
/*    */     try {
/* 51 */       BufferedImage myPicture = ImageIO.read(new File(pDateipfad));
/* 52 */       this.dasBild = new ImageIcon(myPicture);
/*    */     }
/* 54 */     catch (IOException ex) {
/* 55 */       System.err.println("Konnte Bild-Datei nicht laden. (Falscher Dateipfad?)");
/* 56 */       this.dasBild = new ImageIcon(getClass().getResource("/bilder/nichtGefunden.jpg"));
/*    */     } 
/* 58 */     this.komp = new JLabel(this.dasBild);
/* 59 */     this.komp.setSize(this.komp.getPreferredSize());
/* 60 */     this.komp.setLocation(0, 0);
/* 61 */     platzieren(pX, pY, pBreite, pHoehe);
/* 62 */     Fenster.getInstance().anheften(this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setzeGroesse(int pBreite, int pHoehe) {
/* 68 */     this.dasBild.setImage(this.dasBild.getImage().getScaledInstance(pBreite, pHoehe, 1));
/* 69 */     super.setzeGroesse(pBreite, pHoehe);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void skaliereBild(double pFaktor) {
/* 78 */     int breite = (int)(this.komp.getWidth() * pFaktor);
/* 79 */     int hoehe = (int)(this.komp.getHeight() * pFaktor);
/* 80 */     this.dasBild.setImage(this.dasBild.getImage().getScaledInstance(breite, hoehe, 1));
/* 81 */     super.setzeGroesse(breite, hoehe);
/*    */   }
/*    */ 
/*    */   
/*    */   public void platzieren(int pX, int pY, int pBreite, int pHoehe) {
/* 86 */     this.dasBild.setImage(this.dasBild.getImage().getScaledInstance(pBreite, pHoehe, 1));
/* 87 */     super.platzieren(pX, pY, pBreite, pHoehe);
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Bild.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */