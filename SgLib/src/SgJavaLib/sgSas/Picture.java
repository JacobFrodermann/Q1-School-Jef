/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Picture;
/*    */ import sas.Shapes;
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
/*    */ public class Picture
/*    */   extends Picture
/*    */ {
/*    */   String file;
/*    */   
/*    */   public Picture(double xp, double yp, String name) {
/* 22 */     super(xp, yp, name);
/* 23 */     this.file = name;
/*    */   }
/*    */   
/*    */   public Picture(double xp, double yp, double w, double h, String name) {
/* 27 */     super(xp, yp, w, h, name);
/* 28 */     this.file = name;
/*    */   }
/*    */   
/*    */   public Picture clone() {
/* 32 */     Picture p = new Picture(getShapeX(), getShapeY(), getWidth(), getHeight(), this.file);
/* 33 */     p.setDirection(getDirection());
/* 34 */     p.setTransparency(getTransparency());
/* 35 */     return p;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Picture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */