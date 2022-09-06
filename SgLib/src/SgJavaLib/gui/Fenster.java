/*     */ package SgJavaLib.gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.LayoutManager;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fenster
/*     */ {
/*     */   private static Fenster instance;
/*     */   private JFrame dasFenster;
/*     */   private int breite;
/*     */   private int hoehe;
/*     */   private JFileChooser chooser;
/*     */   private Komponente zuletztAngeklickt;
/*     */   
/*     */   public static Fenster getInstance() {
/*  23 */     if (instance == null) {
/*  24 */       instance = new Fenster("EgJavaApp");
/*     */     }
/*  26 */     return instance;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Fenster(String pTitel) {
/*  42 */     this.dasFenster = new JFrame(pTitel);
/*  43 */     this.dasFenster.getContentPane().setLayout((LayoutManager)null);
/*  44 */     this.dasFenster.setDefaultCloseOperation(3);
/*  45 */     this.dasFenster.getContentPane().addMouseListener(Maus.getInstance());
/*  46 */     this.dasFenster.getContentPane().addMouseMotionListener(Maus.getInstance());
/*  47 */     this.dasFenster.addKeyListener(Tastatur.getInstance());
/*  48 */     this.zuletztAngeklickt = null;
/*  49 */     setzeGroesse(800, 600);
/*  50 */     zurMitte();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeTitel(String pTitel) {
/*  56 */     this.dasFenster.setTitle(pTitel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeProgrammEndeBeimSchliessen(boolean pProgEnde) {
/*  67 */     if (pProgEnde) {
/*  68 */       this.dasFenster.setDefaultCloseOperation(3);
/*     */     } else {
/*  70 */       this.dasFenster.setDefaultCloseOperation(1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void anheften(Komponente pKomp) {
/*  79 */     this.dasFenster.getContentPane().add(pKomp.gibJavaKomp());
/*  80 */     pKomp.setzeBesitzer(this);
/*  81 */     this.dasFenster.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void anzeigen() {
/*  91 */     aktualisiereGroesse();
/*  92 */     this.dasFenster.setVisible(true);
/*  93 */     this.dasFenster.toFront();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void verstecken() {
/* 100 */     this.dasFenster.setVisible(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeGroesse(int pBreite, int pHoehe) {
/* 109 */     this.breite = pBreite;
/* 110 */     this.hoehe = pHoehe;
/* 111 */     this.dasFenster.setSize(this.breite, this.hoehe);
/*     */   }
/*     */   
/*     */   private void aktualisiereGroesse() {
/* 115 */     this.dasFenster.setSize(this.breite, this.hoehe);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void zeigeFehlerDialog(String pTitel, String pNachricht) {
/* 124 */     JOptionPane.showMessageDialog(this.dasFenster, pNachricht, pTitel, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void zeigeInfoDialog(String pTitel, String pNachricht) {
/* 133 */     JOptionPane.showMessageDialog(this.dasFenster, pNachricht, pTitel, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean zeigeEntscheidungsDialog(String pTitel, String pNachricht) {
/* 143 */     int entscheidung = JOptionPane.showConfirmDialog(this.dasFenster, pNachricht, pTitel, 0);
/* 144 */     if (entscheidung == 0) {
/* 145 */       return true;
/*     */     }
/* 147 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String zeigeEingabeDialog(String pTitel, String pNachricht) {
/* 158 */     return JOptionPane.showInputDialog(this.dasFenster, pNachricht, pTitel, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void schliessen() {
/* 165 */     this.dasFenster.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeFarbe(String pFarbe) {
/*     */     try {
/* 174 */       this.dasFenster.getContentPane().setBackground(Color.decode(pFarbe));
/* 175 */       this.dasFenster.repaint();
/* 176 */     } catch (Exception e) {
/* 177 */       System.err.println("Fehler beim Verändern der Farbe. Falsches Format? (#FF00FF)");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzePosition(int pX, int pY) {
/* 188 */     this.dasFenster.setLocation(pX, pY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void zurMitte() {
/* 195 */     this.dasFenster.setLocationRelativeTo((Component)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeGroesseVeraenderbar(boolean b) {
/* 203 */     this.dasFenster.setResizable(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String waehleDatei() {
/* 211 */     this.chooser = new JFileChooser();
/* 212 */     String pfad = "";
/* 213 */     int returnVal = this.chooser.showOpenDialog(this.dasFenster);
/* 214 */     if (returnVal == 0) {
/* 215 */       pfad = this.chooser.getSelectedFile().getAbsolutePath();
/*     */     }
/* 217 */     this.chooser = null;
/* 218 */     return pfad;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String waehleDatei(String pDateiEndung) {
/* 228 */     this.chooser = new JFileChooser();
/* 229 */     String pfad = "";
/*     */     
/* 231 */     FileNameExtensionFilter filter = new FileNameExtensionFilter(pDateiEndung + "-Dateien", new String[] { pDateiEndung });
/*     */     
/* 233 */     this.chooser.setFileFilter(filter);
/*     */     
/* 235 */     int returnVal = this.chooser.showOpenDialog(this.dasFenster);
/* 236 */     if (returnVal == 0) {
/* 237 */       pfad = this.chooser.getSelectedFile().getAbsolutePath();
/*     */     }
/* 239 */     this.chooser = null;
/* 240 */     return pfad;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void beendeProgramm() {
/* 247 */     System.exit(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aktualisieren() {
/* 254 */     this.dasFenster.validate();
/*     */   }
/*     */   
/*     */   public Komponente gibZuletztAngeklickt() {
/* 258 */     return this.zuletztAngeklickt;
/*     */   }
/*     */   
/*     */   public void setzeZuletztAngeklickt(Komponente pKomp) {
/* 262 */     this.zuletztAngeklickt = pKomp;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Fenster.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */