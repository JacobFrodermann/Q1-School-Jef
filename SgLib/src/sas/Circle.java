/*    */ package sas;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Shape;
/*    */ import java.awt.geom.Ellipse2D;
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
/*    */ public class Circle
/*    */   extends Shapes
/*    */ {
/*    */   public Circle(double xp, double yp, double radius, Color color) {
/* 26 */     super(xp, yp, 2.0D * radius, 2.0D * radius, color);
/* 27 */     Ellipse2D s = new Ellipse2D.Double(xp, yp, 2.0D * radius, 2.0D * radius);
/* 28 */     setShape(s);
/* 29 */     getScene().insert(this);
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
/*    */   public Circle(double xp, double yp, double radius) {
/* 42 */     super(xp, yp, 2.0D * radius, 2.0D * radius, Color.black);
/* 43 */     Ellipse2D s = new Ellipse2D.Double(xp, yp, 2.0D * radius, 2.0D * radius);
/* 44 */     setShape(s);
/* 45 */     getScene().insert(this);
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
/*    */   public Circle(double xp, double yp, double radius, String textur) {
/* 61 */     super(xp, yp, 2.0D * radius, 2.0D * radius, textur);
/* 62 */     Ellipse2D s = new Ellipse2D.Double(xp, yp, 2.0D * radius, 2.0D * radius);
/* 63 */     setShape(s);
/* 64 */     getScene().insert(this);
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
/*    */   public Circle clone() {
/* 76 */     Circle newGrafik = new Circle(getXPosition(), getYPosition(), getWidth() / 2.0D, getColor());
/* 77 */     Shape oldShape = getShape();
/* 78 */     Object newShape = ((Ellipse2D)oldShape).clone();
/* 79 */     newGrafik.setShape((Ellipse2D)newShape);
/* 80 */     newGrafik.setHidden(getHidden());
/* 81 */     newGrafik.setAT(getAT());
/* 82 */     newGrafik.setTexture(getTexture());
/* 83 */     newGrafik.setDirection(getDirection());
/* 84 */     newGrafik.setTransparency(getTransparency());
/* 85 */     getScene().insert(newGrafik);
/* 86 */     return newGrafik;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Circle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */