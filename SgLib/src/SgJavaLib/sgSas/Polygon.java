/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Polygon;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Polygon
/*    */   extends Polygon
/*    */ {
/*    */   public Polygon(double xp, double yp, String color) {
/* 17 */     super(xp, yp, egFactory.getColor(color));
/*    */   }
/*    */   
/*    */   public Polygon(double xp, double yp) {
/* 21 */     super(xp, yp);
/*    */   }
/*    */   
/*    */   public void setShapeColor(String pColor) {
/* 25 */     setColor(egFactory.getColor(pColor));
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Polygon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */