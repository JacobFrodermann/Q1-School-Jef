/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Circle;
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
/*    */   extends Circle
/*    */ {
/*    */   public Circle(double xp, double yp, double radius, String color) {
/* 18 */     super(xp, yp, radius, egFactory.getColor(color));
/*    */   }
/*    */ 
/*    */   
/*    */   public Circle(double xp, double yp, double radius) {
/* 23 */     super(xp, yp, radius);
/*    */   }
/*    */   
/*    */   public void setShapeColor(String pColor) {
/* 27 */     setColor(egFactory.getColor(pColor));
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Circle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */