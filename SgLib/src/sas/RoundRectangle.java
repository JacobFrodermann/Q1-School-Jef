/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.RoundRectangle2D;
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
/*     */ public class RoundRectangle
/*     */   extends Shapes
/*     */ {
/*     */   int roundLength;
/*     */   
/*     */   public RoundRectangle(double xp, double yp, double width, double height, Color color, int pRoundLength) {
/*  32 */     super(xp, yp, width, height, color);
/*  33 */     RoundRectangle2D s = new RoundRectangle2D.Double(xp, yp, width, height, pRoundLength, pRoundLength);
/*  34 */     this.roundLength = pRoundLength;
/*  35 */     setShape(s);
/*  36 */     getScene().insert(this);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoundRectangle(double xp, double yp, double width, double height, int pRoundLength) {
/*  61 */     super(xp, yp, width, height, Color.black);
/*  62 */     RoundRectangle2D s = new RoundRectangle2D.Double(xp, yp, width, height, pRoundLength, pRoundLength);
/*  63 */     this.roundLength = pRoundLength;
/*  64 */     setShape(s);
/*  65 */     getScene().insert(this);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoundRectangle(double xp, double yp, double width, double height, int pRoundLength, String textur) {
/*  90 */     super(xp, yp, width, height, textur);
/*  91 */     RoundRectangle2D s = new RoundRectangle2D.Double(xp, yp, width, height, pRoundLength, pRoundLength);
/*  92 */     this.roundLength = pRoundLength;
/*  93 */     setShape(s);
/*  94 */     getScene().insert(this);
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
/*     */   public int getRoundLength() {
/* 106 */     return this.roundLength;
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
/*     */   public RoundRectangle clone() {
/* 122 */     RoundRectangle newGrafik = new RoundRectangle(getXPosition(), getYPosition(), getWidth(), getHeight(), getColor(), getRoundLength());
/* 123 */     Shape oldShape = getShape();
/* 124 */     Object newShape = ((RoundRectangle2D)oldShape).clone();
/* 125 */     newGrafik.setShape((RoundRectangle2D)newShape);
/* 126 */     newGrafik.setHidden(getHidden());
/* 127 */     newGrafik.setAT(getAT());
/* 128 */     newGrafik.setTexture(getTexture());
/* 129 */     newGrafik.setDirection(getDirection());
/* 130 */     newGrafik.setTransparency(getTransparency());
/* 131 */     getScene().insert(newGrafik);
/* 132 */     return newGrafik;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\RoundRectangle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */