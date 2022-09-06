/*     */ package SgJavaLib.sgSas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import sas.Shapes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class egFactory
/*     */ {
/*     */   public static Circle getNewCircle() {
/*  17 */     return new Circle(10.0D, 10.0D, 50.0D, "blue");
/*     */   }
/*     */   
/*     */   public static Circle getNewCircle(double xp, double yp, double radius, String color) {
/*  21 */     return new Circle(xp, yp, radius, color);
/*     */   }
/*     */   
/*     */   public static Ellipse getNewEllipse() {
/*  25 */     return new Ellipse(10.0D, 10.0D, 50.0D, 30.0D, "blue");
/*     */   }
/*     */   
/*     */   public static Ellipse getNewEllipse(double xp, double yp, double width, double height, String color) {
/*  29 */     return new Ellipse(xp, yp, width, height, color);
/*     */   }
/*     */   
/*     */   public static Picture getNewPicture(String pDateiPfad) {
/*  33 */     return new Picture(10.0D, 10.0D, pDateiPfad);
/*     */   }
/*     */   
/*     */   public static Picture getNewPicture(double xp, double yp, String pDateiPfad) {
/*  37 */     return new Picture(xp, yp, pDateiPfad);
/*     */   }
/*     */   
/*     */   public static Polygon getNewPolygon(double pPx, double pPy) {
/*  41 */     return new Polygon(pPx, pPy, "blue");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Rectangle getNewRectangle() {
/*  47 */     return new Rectangle(10.0D, 10.0D, 50.0D, 30.0D, "blue");
/*     */   }
/*     */   
/*     */   public static Rectangle getNewRectangle(double xp, double yp, double width, double height, String color) {
/*  51 */     return new Rectangle(xp, yp, width, height, color);
/*     */   }
/*     */   
/*     */   public static Text getNewText(String pText) {
/*  55 */     return new Text(10.0D, 10.0D, pText, "black");
/*     */   }
/*     */   
/*     */   public static Text getNewText(double xp, double yp, String text) {
/*  59 */     return new Text(xp, yp, text);
/*     */   }
/*     */   
/*     */   public static Sprite getNewSprite() {
/*  63 */     return new Sprite();
/*     */   }
/*     */   
/*     */   public static Timer getNewTimer() {
/*  67 */     return new Timer();
/*     */   }
/*     */   
/*     */   public static Mouse getMouse() {
/*  71 */     return Mouse.getInstance();
/*     */   }
/*     */   
/*     */   public static Keyboard getKeyboard() {
/*  75 */     return Keyboard.getInstance();
/*     */   }
/*     */   
/*     */   public static View getView() {
/*  79 */     return View.getInstance();
/*     */   }
/*     */   
/*     */   public static Tool getTool() {
/*  83 */     return Tool.getInstance();
/*     */   }
/*     */ 
/*     */   
/*     */   public static Sprite getNewBird() {
/*  88 */     Ellipse koerper = new Ellipse(50.0D, 300.0D, 40.0D, 35.0D, "red");
/*  89 */     Ellipse fluegel = new Ellipse(54.0D, 311.0D, 18.0D, 13.0D, "white");
/*  90 */     Polygon schnabel = new Polygon(90.0D, 311.5D, "orange");
/*  91 */     schnabel.add(12.0D, 6.0D);
/*  92 */     schnabel.add(0.0D, 12.0D);
/*  93 */     Circle auge = new Circle(75.0D, 308.0D, 4.0D, "black");
/*  94 */     Sprite derVogel = new Sprite();
/*  95 */     derVogel.add(new Shapes[] { (Shapes)koerper, (Shapes)fluegel, (Shapes)schnabel, (Shapes)auge });
/*  96 */     return derVogel;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Color getColor(String pColor) {
/* 101 */     if (pColor.startsWith("#")) {
/* 102 */       Color c = Color.red;
/*     */       try {
/* 104 */         c = Color.decode(pColor);
/*     */       }
/* 106 */       catch (Exception e) {
/* 107 */         System.err.println("Fehlen: Farbe im falschen Format angegeben!");
/*     */       } 
/* 109 */       return c;
/*     */     } 
/*     */ 
/*     */     
/* 113 */     switch (pColor) { case "black":
/* 114 */         return Color.black;
/* 115 */       case "white": return Color.white;
/* 116 */       case "blue": return Color.blue;
/* 117 */       case "cyan": return Color.cyan;
/* 118 */       case "darkgray": return Color.darkGray;
/* 119 */       case "gray": return Color.gray;
/* 120 */       case "green": return Color.green;
/* 121 */       case "lightgrey": return Color.lightGray;
/* 122 */       case "magenta": return Color.magenta;
/* 123 */       case "orange": return Color.orange;
/* 124 */       case "pink": return Color.pink;
/* 125 */       case "red": return Color.red;
/* 126 */       case "yellow": return Color.yellow; }
/* 127 */      return Color.red;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getRandomHexColor() {
/* 135 */     int r = (int)(Math.random() * 256.0D);
/* 136 */     int g = (int)(Math.random() * 256.0D);
/* 137 */     int b = (int)(Math.random() * 256.0D);
/* 138 */     String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(r), Integer.valueOf(g), Integer.valueOf(b) });
/* 139 */     return hex;
/*     */   }
/*     */   
/*     */   public static Color getRandomColor() {
/* 143 */     int r = (int)(Math.random() * 256.0D);
/* 144 */     int g = (int)(Math.random() * 256.0D);
/* 145 */     int b = (int)(Math.random() * 256.0D);
/* 146 */     return new Color(r, g, b);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\sgSas\egFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */