/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Ellipse2D;
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
/*     */ public class Ellipse
/*     */   extends Shapes
/*     */ {
/*     */   public Ellipse(double xp, double yp, double width, double height, Color color) {
/*  31 */     super(xp, yp, width, height, color);
/*  32 */     Ellipse2D s = new Ellipse2D.Double(xp, yp, width, height);
/*  33 */     setShape(s);
/*  34 */     getScene().insert(this);
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
/*     */   public Ellipse(double xp, double yp, double width, double height) {
/*  53 */     super(xp, yp, width, height, Color.black);
/*  54 */     Ellipse2D s = new Ellipse2D.Double(xp, yp, width, height);
/*  55 */     setShape(s);
/*  56 */     getScene().insert(this);
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
/*     */   public Ellipse(double xp, double yp, double width, double height, String textur) {
/*  76 */     super(xp, yp, width, height, textur);
/*  77 */     Ellipse2D s = new Ellipse2D.Double(xp, yp, width, height);
/*  78 */     setShape(s);
/*  79 */     getScene().insert(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ellipse clone() {
/*  90 */     Ellipse newGrafik = new Ellipse(getXPosition(), getYPosition(), getWidth(), getHeight(), getColor());
/*  91 */     Shape oldShape = getShape();
/*  92 */     Object newShape = ((Ellipse2D)oldShape).clone();
/*  93 */     newGrafik.setShape((Ellipse2D)newShape);
/*  94 */     newGrafik.setHidden(getHidden());
/*  95 */     newGrafik.setAT(getAT());
/*  96 */     newGrafik.setTexture(getTexture());
/*  97 */     newGrafik.setDirection(getDirection());
/*  98 */     newGrafik.setTransparency(getTransparency());
/*  99 */     getScene().insert(newGrafik);
/* 100 */     return newGrafik;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Ellipse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */