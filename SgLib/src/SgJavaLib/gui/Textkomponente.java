/*     */ package SgJavaLib.gui;
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
/*     */ public class Textkomponente
/*     */   extends Komponente
/*     */ {
/*  15 */   String text = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Textkomponente(String pText) {
/*  22 */     this.text = pText;
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
/*     */   public Textkomponente(String pText, int pX, int pY, int pBreite, int pHoehe) {
/*  34 */     this.text = pText;
/*  35 */     this.xPos = pX;
/*  36 */     this.yPos = pY;
/*  37 */     this.breite = pBreite;
/*  38 */     this.hoehe = pHoehe;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setzeText(String pText) {
/*  46 */     this.text = pText;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String gibText() {
/*  54 */     return this.text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void haengeAn(Object o) {
/*  62 */     this.text += o.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean inhaltIstGanzeZahl() {
/*     */     try {
/*  71 */       Integer.parseInt(this.text);
/*  72 */     } catch (NumberFormatException e) {
/*  73 */       return false;
/*     */     } 
/*  75 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean inhaltIstDezimalZahl() {
/*     */     try {
/*  84 */       Double.parseDouble(this.text);
/*  85 */     } catch (NumberFormatException e) {
/*  86 */       return false;
/*     */     } 
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int inhaltAlsGanzeZahl() {
/*     */     try {
/*  97 */       return Integer.parseInt(this.text);
/*  98 */     } catch (NumberFormatException e) {
/*  99 */       System.err.println("Fehler: Inhalt ist keine Ganzzahl!");
/* 100 */       return 42;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double inhaltAlsDezimalZahl() {
/*     */     try {
/* 111 */       return Double.parseDouble(this.text);
/* 112 */     } catch (NumberFormatException e) {
/* 113 */       return 42.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hatInhalt() {
/* 122 */     return !this.text.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int gibLaenge() {
/* 130 */     return this.text.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ersetzeText(String pAlt, String pNeu) {
/* 139 */     this.text = this.text.replaceAll(pAlt, pNeu);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Textkomponente.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */