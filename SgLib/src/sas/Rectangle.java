/*    */ package sas;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Shape;
/*    */ import java.awt.geom.Rectangle2D;
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
/*    */ 
/*    */ 
/*    */ public class Rectangle
/*    */   extends Shapes
/*    */ {
/*    */   public Rectangle(double xp, double yp, double width, double height, Color color) {
/* 30 */     super(xp, yp, width, height, color);
/* 31 */     Rectangle2D s = new Rectangle2D.Double(xp, yp, width, height);
/* 32 */     setShape(s);
/* 33 */     getScene().insert(this);
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
/*    */   public Rectangle(double xp, double yp, double width, double height) {
/* 48 */     super(xp, yp, width, height, Color.black);
/* 49 */     Rectangle2D s = new Rectangle2D.Double(xp, yp, width, height);
/* 50 */     setShape(s);
/* 51 */     getScene().insert(this);
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
/*    */   public Rectangle(double xp, double yp, double width, double height, String textur) {
/* 66 */     super(xp, yp, width, height, textur);
/* 67 */     Rectangle2D s = new Rectangle2D.Double(xp, yp, width, height);
/* 68 */     setShape(s);
/* 69 */     getScene().insert(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Rectangle clone() {
/* 80 */     Rectangle newGrafik = new Rectangle(getXPosition(), getYPosition(), getWidth(), getHeight(), getColor());
/* 81 */     Shape oldShape = getShape();
/* 82 */     Object newShape = ((Rectangle2D)oldShape).clone();
/* 83 */     newGrafik.setShape((Rectangle2D)newShape);
/* 84 */     newGrafik.setHidden(getHidden());
/* 85 */     newGrafik.setAT(getAT());
/* 86 */     newGrafik.setTexture(getTexture());
/* 87 */     newGrafik.setDirection(getDirection());
/* 88 */     newGrafik.setTransparency(getTransparency());
/* 89 */     getScene().insert(newGrafik);
/* 90 */     return newGrafik;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Rectangle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */