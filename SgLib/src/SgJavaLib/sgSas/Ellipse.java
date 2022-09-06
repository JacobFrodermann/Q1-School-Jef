/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Ellipse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ellipse
/*    */   extends Ellipse
/*    */ {
/*    */   public Ellipse(double xp, double yp, double width, double height, String color) {
/* 17 */     super(xp, yp, width, height, egFactory.getColor(color));
/*    */   }
/*    */   
/*    */   public Ellipse(double xp, double yp, double width, double height) {
/* 21 */     super(xp, yp, width, height);
/*    */   }
/*    */   
/*    */   public void setShapeColor(String pColor) {
/* 25 */     setColor(egFactory.getColor(pColor));
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Ellipse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */