/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Shapes;
/*    */ import sas.Sprite;
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
/*    */ public class Sprite
/*    */   extends Sprite
/*    */ {
/*    */   public Sprite(Shapes shape) {
/* 20 */     super(shape);
/*    */   }
/*    */ 
/*    */   
/*    */   public Sprite() {}
/*    */ 
/*    */   
/*    */   public void add(Shapes... shapeInput) {
/* 28 */     for (Shapes theShape : shapeInput) {
/* 29 */       add(theShape);
/*    */     }
/*    */   }
/*    */   
/*    */   public void setShapeColor(String pColor) {
/* 34 */     setColor(egFactory.getColor(pColor));
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Sprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */