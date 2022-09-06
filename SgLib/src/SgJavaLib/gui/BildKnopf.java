/*     */ package SgJavaLib.gui;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
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
/*     */ public class BildKnopf
/*     */   extends Komponente
/*     */ {
/*     */   ImageIcon dasBild;
/*     */   private JButton button;
/*     */   
/*     */   public BildKnopf(String pDateipfad) {
/*  34 */     final BildKnopf thisOne = this;
/*     */     try {
/*  36 */       BufferedImage myPicture = ImageIO.read(new File(pDateipfad));
/*  37 */       this.dasBild = new ImageIcon(myPicture);
/*     */     
/*     */     }
/*  40 */     catch (IOException ex) {
/*  41 */       System.err.println("Konnte Bild-Datei nicht laden. (Falscher Dateipfad?)");
/*  42 */       this.dasBild = new ImageIcon(getClass().getResource("/bilder/nichtGefunden.jpg"));
/*     */     } 
/*     */ 
/*     */     
/*  46 */     this.button = new JButton(this.dasBild);
/*  47 */     this.komp = this.button;
/*  48 */     this.komp.addMouseListener(Maus.getInstance());
/*  49 */     this.komp.addMouseMotionListener(Maus.getInstance());
/*  50 */     this.komp.addKeyListener(Tastatur.getInstance());
/*  51 */     this.komp.setSize(this.komp.getPreferredSize());
/*  52 */     this.komp.setLocation(0, 0);
/*  53 */     Fenster.getInstance().anheften(this);
/*  54 */     this.button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  56 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BildKnopf(String pDateipfad, int pX, int pY, int pBreite, int pHoehe) {
/*  70 */     final BildKnopf thisOne = this;
/*     */     try {
/*  72 */       BufferedImage myPicture = ImageIO.read(new File(pDateipfad));
/*  73 */       this.dasBild = new ImageIcon(myPicture);
/*     */     
/*     */     }
/*  76 */     catch (IOException ex) {
/*  77 */       System.err.println("Konnte Bild-Datei nicht laden. (Falscher Dateipfad?)");
/*  78 */       this.dasBild = new ImageIcon(getClass().getResource("/bilder/nichtGefunden.jpg"));
/*     */     } 
/*     */ 
/*     */     
/*  82 */     this.button = new JButton(this.dasBild);
/*  83 */     this.komp = this.button;
/*  84 */     this.komp.addMouseListener(Maus.getInstance());
/*  85 */     this.komp.addMouseMotionListener(Maus.getInstance());
/*  86 */     this.komp.addKeyListener(Tastatur.getInstance());
/*  87 */     this.komp.setSize(this.komp.getPreferredSize());
/*  88 */     platzieren(pX, pY, pBreite, pHoehe);
/*  89 */     Fenster.getInstance().anheften(this);
/*  90 */     this.button.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  92 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeGroesse(int pBreite, int pHoehe) {
/* 102 */     this.dasBild.setImage(this.dasBild.getImage().getScaledInstance(pBreite, pHoehe, 1));
/* 103 */     super.setzeGroesse(pBreite, pHoehe);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\BildKnopf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */