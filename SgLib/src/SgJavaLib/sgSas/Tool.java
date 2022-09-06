/*    */ package SgJavaLib.sgSas;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import sas.Tools;
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
/*    */ public class Tool
/*    */   extends Tools
/*    */ {
/*    */   private static Tool instance;
/*    */   
/*    */   public static Tool getInstance() {
/* 23 */     if (instance == null) {
/* 24 */       instance = new Tool();
/*    */     }
/* 26 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRandomStringColor() {
/* 31 */     int r = (int)(Math.random() * 256.0D);
/* 32 */     int g = (int)(Math.random() * 256.0D);
/* 33 */     int b = (int)(Math.random() * 256.0D);
/* 34 */     String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(r), Integer.valueOf(g), Integer.valueOf(b) });
/* 35 */     return hex;
/*    */   }
/*    */   
/*    */   public String getRandomHexColor() {
/* 39 */     return getRandomStringColor();
/*    */   }
/*    */   
/*    */   public Color getRandomColor() {
/* 43 */     int r = (int)(Math.random() * 256.0D);
/* 44 */     int g = (int)(Math.random() * 256.0D);
/* 45 */     int b = (int)(Math.random() * 256.0D);
/* 46 */     return new Color(r, g, b);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getRandomNumber(int von, int bis) {
/* 51 */     int randomNr = von + (int)(Math.random() * (bis - von + 1));
/* 52 */     return randomNr;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getIntFromString(String zahlString) {
/* 57 */     int value = Integer.parseInt(zahlString);
/* 58 */     return value;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\Tool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */