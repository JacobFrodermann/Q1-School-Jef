/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.event.DocumentEvent;
/*    */ import javax.swing.event.DocumentListener;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TextEingabefeld
/*    */   extends Textkomponente
/*    */ {
/*    */   JTextField textfield;
/*    */   
/*    */   public TextEingabefeld(String pText, int pX, int pY, int pBreite, int pHoehe) {
/* 32 */     super(pText, pX, pY, pBreite, pHoehe);
/* 33 */     final TextEingabefeld thisOne = this;
/* 34 */     this.textfield = new JTextField(this.text);
/* 35 */     this.textfield.getDocument().addDocumentListener(new DocumentListener()
/*    */         {
/*    */           public void insertUpdate(DocumentEvent e) {
/* 38 */             TextEingabefeld.this.text = TextEingabefeld.this.textfield.getText();
/*    */           }
/*    */ 
/*    */           
/*    */           public void removeUpdate(DocumentEvent e) {
/* 43 */             TextEingabefeld.this.text = TextEingabefeld.this.textfield.getText();
/*    */           }
/*    */ 
/*    */           
/*    */           public void changedUpdate(DocumentEvent e) {
/* 48 */             TextEingabefeld.this.text = TextEingabefeld.this.textfield.getText();
/*    */           }
/*    */         });
/* 51 */     this.komp = this.textfield;
/* 52 */     this.komp.addMouseListener(Maus.getInstance());
/* 53 */     this.komp.addMouseMotionListener(Maus.getInstance());
/* 54 */     this.komp.addKeyListener(Tastatur.getInstance());
/* 55 */     platzieren(pX, pY, pBreite, pHoehe);
/* 56 */     Fenster.getInstance().anheften(this);
/* 57 */     this.textfield.addActionListener(new ActionListener()
/*    */         {
/*    */           public void actionPerformed(ActionEvent e) {
/* 60 */             Fenster.getInstance().setzeZuletztAngeklickt(thisOne);
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setzeText(String pText) {
/* 71 */     super.setzeText(pText);
/* 72 */     this.textfield.setText(this.text);
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
/*    */   public void aktivieren() {
/* 88 */     this.textfield.setEnabled(true);
/* 89 */     this.textfield.setEditable(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void deaktivieren() {
/* 98 */     this.textfield.setEnabled(false);
/* 99 */     this.textfield.setEditable(false);
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\TextEingabefeld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */