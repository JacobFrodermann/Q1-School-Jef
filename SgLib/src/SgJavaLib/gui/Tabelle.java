/*    */ package SgJavaLib.gui;
/*    */ 
/*    */ import java.awt.FlowLayout;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTable;
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
/*    */ public class Tabelle
/*    */   extends Komponente
/*    */ {
/*    */   JTable tabelle;
/*    */   JScrollPane scrollPane;
/*    */   String[] kopfzeile;
/*    */   Object[][] tabellenInhalt;
/*    */   
/*    */   public Tabelle(int pX, int pY, int pBreite, int pHoehe) {
/* 34 */     this.komp = new JPanel(new FlowLayout());
/*    */     
/* 36 */     this.komp.setBounds(pX, pY, pBreite, pHoehe);
/* 37 */     String[] tabKopf = { "Spalte1", "Spalte2", "Spalte3" };
/* 38 */     Object[][] data = { { "Item1", "Item2", "Item3" }, { "Item1", "Item2", "Item3" } };
/*    */     
/* 40 */     this.tabelle = new JTable(data, (Object[])tabKopf);
/*    */ 
/*    */     
/* 43 */     this.scrollPane = new JScrollPane(this.tabelle);
/* 44 */     this.tabelle.setFillsViewportHeight(true);
/*    */ 
/*    */     
/* 47 */     this.komp.add(this.scrollPane);
/* 48 */     Fenster.getInstance().anheften(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void aktualisiereTabelle() {
/* 53 */     setzeInhalt(this.kopfzeile, this.tabellenInhalt);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setzeInhalt(String[] pKopfzeile, Object[][] pInhalt) {
/* 58 */     if (pKopfzeile.length == (pInhalt[0]).length) {
/* 59 */       this.kopfzeile = pKopfzeile;
/* 60 */       this.tabellenInhalt = pInhalt;
/*    */       
/* 62 */       this.komp.remove(0);
/*    */       
/* 64 */       this.tabelle = new JTable(this.tabellenInhalt, (Object[])this.kopfzeile);
/* 65 */       this.scrollPane = new JScrollPane(this.tabelle);
/* 66 */       this.tabelle.setFillsViewportHeight(true);
/* 67 */       this.komp.add(this.scrollPane);
/*    */ 
/*    */       
/* 70 */       Fenster.getInstance().aktualisieren();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Tabelle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */