/*     */ package SgJavaLib.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.JLabel;
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
/*     */ public class Etikett
/*     */   extends Textkomponente
/*     */ {
/*     */   private JLabel dasLabel;
/*     */   
/*     */   public Etikett(String pText) {
/*  28 */     super(pText);
/*  29 */     this.komp = new JLabel(this.text);
/*  30 */     final Etikett thisOne = this;
/*  31 */     this.komp.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseClicked(MouseEvent e) {
/*  34 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*     */           }
/*     */         });
/*  37 */     this.dasLabel = (JLabel)this.komp;
/*  38 */     this.komp.addMouseListener(Maus.getInstance());
/*  39 */     this.komp.addMouseMotionListener(Maus.getInstance());
/*  40 */     this.komp.addKeyListener(Tastatur.getInstance());
/*     */     
/*  42 */     this.dasLabel.setSize(this.dasLabel.getPreferredSize());
/*  43 */     this.dasLabel.setLocation(0, 0);
/*  44 */     Fenster.getInstance().anheften(this);
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
/*     */   public Etikett(String pText, int pX, int pY, int pBreite, int pHoehe) {
/*  56 */     super(pText);
/*  57 */     this.komp = new JLabel(this.text);
/*  58 */     final Etikett thisOne = this;
/*  59 */     this.komp.addMouseListener(new MouseAdapter()
/*     */         {
/*     */           public void mouseClicked(MouseEvent e) {
/*  62 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*     */           }
/*     */         });
/*  65 */     this.dasLabel = (JLabel)this.komp;
/*  66 */     this.komp.addMouseListener(Maus.getInstance());
/*  67 */     this.komp.addMouseMotionListener(Maus.getInstance());
/*  68 */     this.komp.addKeyListener(Tastatur.getInstance());
/*     */     
/*  70 */     this.dasLabel.setSize(this.dasLabel.getPreferredSize());
/*  71 */     this.dasLabel.setLocation(pX, pY);
/*  72 */     this.dasLabel.setBounds(pX, pY, pBreite, pHoehe);
/*  73 */     Fenster.getInstance().anheften(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeText(String pText) {
/*  81 */     super.setzeText(pText);
/*  82 */     this.dasLabel.setText(this.text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void haengeAn(Object o) {
/*  90 */     super.haengeAn(o);
/*  91 */     this.dasLabel.setText(this.text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ersetzeText(String pAlt, String pNeu) {
/* 100 */     super.ersetzeText(pAlt, pNeu);
/* 101 */     this.dasLabel.setText(this.text);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setzeFarbe(String pFarbe) {
/*     */     try {
/* 107 */       this.dasLabel.setBackground(Color.decode(pFarbe));
/* 108 */       this.dasLabel.setOpaque(true);
/* 109 */     } catch (Exception e) {
/* 110 */       System.err.println("Fehler beim Verändern der Farbe. Falsches Format? (#FF00FF)");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void zentriereText() {
/* 115 */     this.dasLabel.setHorizontalAlignment(0);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Etikett.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */