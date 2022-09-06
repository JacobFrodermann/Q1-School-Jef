/*     */ package SgJavaLib.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import javax.swing.JComponent;
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
/*     */ public class Komponente
/*     */ {
/*     */   protected JComponent komp;
/*     */   protected Fenster besitzer;
/*     */   protected int xPos;
/*     */   protected int yPos;
/*     */   protected int breite;
/*     */   protected int hoehe;
/*     */   
/*     */   public JComponent gibJavaKomp() {
/*  67 */     return this.komp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeGroesse(int pBreite, int pHoehe) {
/*  77 */     this.komp.setPreferredSize(new Dimension(pBreite, pHoehe));
/*  78 */     this.komp.setSize(new Dimension(pBreite, pHoehe));
/*  79 */     this.komp.setBounds(this.komp.getX(), this.komp.getY(), pBreite, pHoehe);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aktivieren() {
/*  86 */     this.komp.setEnabled(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deaktivieren() {
/*  93 */     this.komp.setEnabled(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void zeigen() {
/* 100 */     this.komp.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void verstecken() {
/* 107 */     this.komp.setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeFarbe(String pFarbe) {
/*     */     try {
/* 118 */       this.komp.setBackground(Color.decode(pFarbe));
/* 119 */     } catch (Exception e) {
/* 120 */       System.err.println("Fehler beim Verändern der Farbe. Falsches Format? (#FF00FF)");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzePosition(int pX, int pY) {
/* 130 */     this.komp.setLocation(pX, pY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void platzieren(int pX, int pY, int pBreite, int pHoehe) {
/* 141 */     this.komp.setBounds(pX, pY, pBreite, pHoehe);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeSchriftart(String pSchriftart) {
/* 150 */     Font f = this.komp.getFont();
/* 151 */     this.komp.setFont(new Font(pSchriftart, f.getStyle(), f.getSize()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeSchriftgroesse(int pGroesse) {
/* 159 */     Font f = this.komp.getFont();
/* 160 */     this.komp.setFont(new Font(f.getName(), f.getStyle(), pGroesse));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeSchriftfarbe(String pFarbe) {
/*     */     try {
/* 170 */       this.komp.setForeground(Color.decode(pFarbe));
/* 171 */     } catch (Exception e) {
/* 172 */       System.err.println("Fehler beim Verändern der Farbe. Falsches Format? (#FF00FF)");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeBesitzer(Fenster pFenster) {
/* 184 */     this.besitzer = pFenster;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int gibX() {
/* 191 */     return this.komp.getX();
/*     */   }
/*     */ 
/*     */   
/*     */   public int gibY() {
/* 196 */     return this.komp.getY();
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Komponente.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */