/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Rectangle2D;
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
/*     */ public class Polygon
/*     */   extends Shapes
/*     */ {
/*     */   protected Path2D.Double p2d;
/*     */   protected Rectangle2D pathBounds;
/*     */   
/*     */   public Polygon(double xp, double yp, Color color) {
/*  33 */     super(xp, yp, 0.0D, 0.0D, color);
/*  34 */     this.p2d = new Path2D.Double();
/*  35 */     this.p2d.moveTo(xp, yp);
/*  36 */     setShape(this.p2d);
/*  37 */     getScene().insert(this);
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
/*     */   public Polygon(double xp, double yp) {
/*  55 */     super(xp, yp, 0.0D, 0.0D, Color.black);
/*  56 */     this.p2d = new Path2D.Double();
/*  57 */     this.p2d.moveTo(xp, yp);
/*  58 */     setShape(this.p2d);
/*  59 */     getScene().insert(this);
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
/*     */   public Polygon(double xp, double yp, String textur) {
/*  76 */     super(xp, yp, 0.0D, 0.0D, textur);
/*  77 */     this.p2d = new Path2D.Double();
/*  78 */     this.p2d.moveTo(xp, yp);
/*  79 */     setShape(this.p2d);
/*  80 */     getScene().insert(this);
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
/*     */   public void add(double px, double py) {
/*  96 */     this.p2d.lineTo(getXPosition() + px, getYPosition() + py);
/*  97 */     setShape(this.p2d);
/*  98 */     Rectangle2D r2d = this.p2d.getBounds2D();
/*  99 */     setSize(r2d.getWidth(), r2d.getHeight());
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
/*     */   public Polygon clone() {
/* 111 */     Polygon newGrafik = new Polygon(getXPosition(), getYPosition(), getColor());
/* 112 */     Shape oldShape = getShape();
/* 113 */     Object newShape = ((Path2D)oldShape).clone();
/* 114 */     newGrafik.setShape((Path2D)newShape);
/* 115 */     newGrafik.setHidden(getHidden());
/* 116 */     newGrafik.setAT(getAT());
/* 117 */     newGrafik.setTexture(getTexture());
/* 118 */     newGrafik.setDirection(getDirection());
/* 119 */     newGrafik.setTransparency(getTransparency());
/* 120 */     getScene().insert(newGrafik);
/* 121 */     return newGrafik;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Polygon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */