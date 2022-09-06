/*     */ package SgJavaLib.sgSas;
/*     */ 
/*     */ import java.awt.Color;
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
/*     */ public class Mouse
/*     */ {
/*     */   SasApp app;
/*     */   private static Mouse instance;
/*     */   private int mouseX;
/*     */   private int mouseY;
/*     */   boolean clicked = false;
/*     */   boolean pressed = false;
/*     */   boolean doubleClicked = false;
/*     */   boolean dragged = false;
/*     */   
/*     */   public boolean isClicked() {
/*  29 */     return this.clicked;
/*     */   }
/*     */   
/*     */   public boolean isDragged() {
/*  33 */     return this.dragged;
/*     */   }
/*     */   
/*     */   public boolean isPressed() {
/*  37 */     return this.pressed;
/*     */   }
/*     */   
/*     */   public boolean isDoubleClicked() {
/*  41 */     return this.doubleClicked;
/*     */   }
/*     */   
/*     */   public void resetClicks() {
/*  45 */     this.clicked = false;
/*  46 */     this.doubleClicked = false;
/*     */   }
/*     */   
/*     */   private Mouse() {
/*  50 */     this.mouseX = 0;
/*  51 */     this.mouseY = 0;
/*     */   }
/*     */   
/*     */   public void saveXY(int pX, int pY) {
/*  55 */     this.mouseX = pX;
/*  56 */     this.mouseY = pY;
/*  57 */     if (this.app != null) {
/*  58 */       this.app.mouseMoved();
/*     */     }
/*     */   }
/*     */   
/*     */   public static Mouse getInstance() {
/*  63 */     if (instance == null) {
/*  64 */       instance = new Mouse();
/*     */     }
/*  66 */     return instance;
/*     */   }
/*     */   
/*     */   public int getX() {
/*  70 */     return this.mouseX;
/*     */   }
/*     */   
/*     */   public int getY() {
/*  74 */     return this.mouseY;
/*     */   }
/*     */   
/*     */   public void setClicked(boolean b) {
/*  78 */     this.clicked = b;
/*  79 */     if (b && this.app != null) {
/*  80 */       this.app.mouseClicked();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setPressed(boolean b) {
/*  85 */     this.pressed = b;
/*  86 */     if (b && this.app != null) {
/*  87 */       this.app.mousePressed();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setDoubleClick(boolean b) {
/*  92 */     this.doubleClicked = b;
/*     */   }
/*     */   
/*     */   void setApp(SasApp pApp) {
/*  96 */     this.app = pApp;
/*     */   }
/*     */   
/*     */   public void setDragged(boolean b) {
/* 100 */     this.dragged = b;
/* 101 */     if (b && this.app != null) {
/* 102 */       this.app.mouseDragged();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOnHexColor(String pColor) {
/* 108 */     return View.getInstance().getHexColorAt(this.mouseX, this.mouseY).equalsIgnoreCase(pColor);
/*     */   }
/*     */   
/*     */   public boolean isOnColor(Color pColor) {
/* 112 */     return (View.getInstance().getColorAt(this.mouseX, this.mouseY) == pColor);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Mouse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */