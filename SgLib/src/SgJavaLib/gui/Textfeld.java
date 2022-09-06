/*     */ package SgJavaLib.gui;
/*     */ 
/*     */ import java.awt.Font;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.event.DocumentEvent;
/*     */ import javax.swing.event.DocumentListener;
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
/*     */ public class Textfeld
/*     */   extends Textkomponente
/*     */ {
/*     */   JTextArea dieTextArea;
/*     */   JScrollPane scrollPane;
/*     */   
/*     */   public Textfeld(int pZeilen) {
/*  27 */     super("");
/*  28 */     this.dieTextArea = new JTextArea(pZeilen, 10);
/*  29 */     this.dieTextArea.setTabSize(3);
/*  30 */     this.scrollPane = new JScrollPane(this.dieTextArea);
/*  31 */     this.komp = this.scrollPane;
/*     */     
/*  33 */     this.komp.setSize(this.komp.getPreferredSize());
/*  34 */     this.komp.setLocation(0, 0);
/*  35 */     Fenster.getInstance().anheften(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Textfeld(String pText) {
/*  43 */     super(pText);
/*  44 */     this.dieTextArea = new JTextArea(this.text);
/*  45 */     this.dieTextArea.setTabSize(3);
/*  46 */     this.dieTextArea.getDocument().addDocumentListener(new DocumentListener() {
/*     */           public void insertUpdate(DocumentEvent e) {
/*  48 */             Textfeld.this.text = Textfeld.this.dieTextArea.getText();
/*     */           }
/*     */           
/*     */           public void removeUpdate(DocumentEvent e) {
/*  52 */             Textfeld.this.text = Textfeld.this.dieTextArea.getText();
/*     */           }
/*     */           
/*     */           public void changedUpdate(DocumentEvent e) {
/*  56 */             Textfeld.this.text = Textfeld.this.dieTextArea.getText();
/*     */           }
/*     */         });
/*  59 */     this.scrollPane = new JScrollPane(this.dieTextArea);
/*  60 */     this.komp = this.scrollPane;
/*     */     
/*  62 */     this.komp.setSize(this.komp.getPreferredSize());
/*  63 */     this.komp.setLocation(0, 0);
/*  64 */     Fenster.getInstance().anheften(this);
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
/*     */   public Textfeld(String pText, int pX, int pY, int pBreite, int pHoehe) {
/*  76 */     super("", pX, pY, pBreite, pHoehe);
/*  77 */     this.dieTextArea = new JTextArea(this.text);
/*  78 */     this.dieTextArea.setTabSize(3);
/*  79 */     this.dieTextArea.getDocument().addDocumentListener(new DocumentListener() {
/*     */           public void insertUpdate(DocumentEvent e) {
/*  81 */             Textfeld.this.text = Textfeld.this.dieTextArea.getText();
/*     */           }
/*     */           
/*     */           public void removeUpdate(DocumentEvent e) {
/*  85 */             Textfeld.this.text = Textfeld.this.dieTextArea.getText();
/*     */           }
/*     */           
/*     */           public void changedUpdate(DocumentEvent e) {
/*  89 */             Textfeld.this.text = Textfeld.this.dieTextArea.getText();
/*     */           }
/*     */         });
/*  92 */     this.scrollPane = new JScrollPane(this.dieTextArea);
/*  93 */     this.komp = this.scrollPane;
/*  94 */     platzieren(pX, pY, pBreite, pHoehe);
/*  95 */     Fenster.getInstance().anheften(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeText(String pText) {
/* 104 */     super.setzeText(pText);
/* 105 */     this.dieTextArea.setText(this.text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void haengeAn(Object o) {
/* 114 */     super.haengeAn(o);
/* 115 */     this.dieTextArea.setText(this.text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ersetzeText(String pAlt, String pNeu) {
/* 125 */     super.ersetzeText(pAlt, pNeu);
/* 126 */     this.dieTextArea.setText(this.text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeEditierbar(boolean pEditierbar) {
/* 134 */     this.dieTextArea.setEditable(pEditierbar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fuegeNeueZeileHinzu(String pText) {
/* 142 */     if (this.text.isEmpty()) {
/* 143 */       this.text += pText;
/*     */     } else {
/*     */       
/* 146 */       this.text += "\n" + pText;
/*     */     } 
/* 148 */     this.dieTextArea.setText(this.text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int gibAnzahlZeilen() {
/* 157 */     String[] lines = this.text.split("\r\n|\r|\n");
/* 158 */     return lines.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setzeSchriftgroesse(int pGroesse) {
/* 163 */     Font f = this.dieTextArea.getFont();
/* 164 */     this.dieTextArea.setFont(new Font(f.getName(), f.getStyle(), pGroesse));
/*     */   }
/*     */   
/*     */   public String gibMarkierung() {
/* 168 */     return this.dieTextArea.getSelectedText();
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Textfeld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */