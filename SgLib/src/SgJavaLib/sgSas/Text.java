/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import sas.Text;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Text
/*    */   extends Text
/*    */ {
/*    */   public Text(double xp, double yp, String text, String fontColor) {
/* 17 */     super(xp, yp, text, egFactory.getColor(fontColor));
/*    */   }
/*    */   
/*    */   public Text(double xp, double yp, String text) {
/* 21 */     super(xp, yp, text);
/*    */   }
/*    */   
/*    */   public void setFontColor(String pColor) {
/* 25 */     setFontColor(egFactory.getColor(pColor));
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Text.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */