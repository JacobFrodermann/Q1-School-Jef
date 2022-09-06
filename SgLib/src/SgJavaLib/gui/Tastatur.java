/*     */ package SgJavaLib.gui;
/*     */ 
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
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
/*     */ public class Tastatur
/*     */   implements KeyListener
/*     */ {
/*     */   EgJavaApp parent;
/*     */   private KeyEvent lastKeyEvent;
/*     */   private static Tastatur instance;
/*     */   
/*     */   public static Tastatur getInstance() {
/*  23 */     if (instance == null) {
/*  24 */       instance = new Tastatur();
/*     */     }
/*  26 */     return instance;
/*     */   }
/*     */   
/*     */   void setzeFenster(EgJavaApp pParent) {
/*  30 */     this.parent = pParent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyTyped(KeyEvent e) {
/*  39 */     this.lastKeyEvent = e;
/*  40 */     this.parent.tasteGedrueckt();
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/*  45 */     this.lastKeyEvent = e;
/*  46 */     this.parent.tasteGedrueckt();
/*  47 */     this.lastKeyEvent = null;
/*     */   }
/*     */   
/*     */   public String gibTasteAlsString() {
/*  51 */     String key = "";
/*  52 */     switch (this.lastKeyEvent.getKeyCode()) { case 17:
/*  53 */         key = "STRG";
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
/*  83 */         return key;case 18: key = "ALT"; return key;case 65406: key = "ALTGR"; return key;case 32: key = "SPACE"; return key;case 37: key = "LEFT"; return key;case 39: key = "RIGHT"; return key;case 38: key = "UP"; return key;case 40: key = "DOWN"; return key;case 9: key = "TAB"; return key;case 16: key = "SHIFT"; return key;case 20: key = "CAPSLOCK"; return key;case 10: key = "ENTER"; return key;case 127: key = "DELETE"; return key;case 27: key = "ESCAPE"; return key;case 8: key = "BACKSPACE"; return key;case 112: key = "F1"; return key;case 113: key = "F2"; return key;case 114: key = "F3"; return key;case 115: key = "F4"; return key;case 116: key = "F5"; return key;case 117: key = "F6"; return key;case 118: key = "F7"; return key;case 119: key = "F8"; return key;case 120: key = "F9"; return key;case 121: key = "F10"; return key;case 122: key = "F11"; return key;case 123: key = "F12"; return key; }  key = "" + this.lastKeyEvent.getKeyChar(); return key;
/*     */   }
/*     */   
/*     */   public char gibTasteAlsChar() {
/*  87 */     if (this.lastKeyEvent != null) {
/*  88 */       return this.lastKeyEvent.getKeyChar();
/*     */     }
/*     */     
/*  91 */     return 'µ';
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/*  97 */     this.lastKeyEvent = null;
/*     */   }
/*     */   
/*     */   public boolean tasteGedrueckt(String pKey) {
/* 101 */     return pKey.equals(gibTasteAlsString());
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\gui\Tastatur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */