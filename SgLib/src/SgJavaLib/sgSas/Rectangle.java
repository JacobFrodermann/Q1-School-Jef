/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Rectangle;
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
/*    */   extends Rectangle
/*    */ {
/*    */   public Rectangle(double xp, double yp, double width, double height, String color) {
/* 19 */     super(xp, yp, width, height, egFactory.getColor(color));
/*    */   }
/*    */   
/*    */   public Rectangle(double xp, double yp, double width, double height) {
/* 23 */     super(xp, yp, width, height);
/*    */   }
/*    */   
/*    */   public void setShapeColor(String pColor) {
/* 27 */     setColor(egFactory.getColor(pColor));
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Rectangle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */