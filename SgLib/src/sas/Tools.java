/*     */ package sas;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tools
/*     */ {
/*     */   public static int randomNumber(int von, int bis) {
/*  29 */     int randomNr = von + (int)(Math.random() * (bis - von + 1));
/*  30 */     return randomNr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double degreeToRadian(double angl) {
/*  42 */     return Math.PI * angl / 180.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int stringToInt(String zahlString) {
/*  53 */     int value = Integer.parseInt(zahlString);
/*  54 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getDirection(double x1, double y1, double x2, double y2) {
/*  72 */     double radianAngle = Math.atan((y2 - y1) / (x2 - x1));
/*  73 */     double angleDegree = 90.0D + radianAngle * 180.0D / Math.PI;
/*  74 */     if (x2 < x1) {
/*  75 */       angleDegree += 180.0D;
/*     */     }
/*  77 */     return angleDegree;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getHour() {
/* 101 */     Date date = new Date();
/* 102 */     Calendar cal = Calendar.getInstance();
/*     */     
/* 104 */     cal.setTime(date);
/* 105 */     return cal.get(11);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getMinute() {
/* 114 */     Date date = new Date();
/* 115 */     Calendar cal = Calendar.getInstance();
/*     */     
/* 117 */     cal.setTime(date);
/* 118 */     return cal.get(12);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getSecond() {
/* 127 */     Date date = new Date();
/* 128 */     Calendar cal = Calendar.getInstance();
/*     */     
/* 130 */     cal.setTime(date);
/* 131 */     return cal.get(13);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getStartTime() {
/* 140 */     return System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getElapsedTimeString(long startTime) {
/* 153 */     long time = System.currentTimeMillis();
/* 154 */     float time2 = (float)((time - startTime) / 100L);
/* 155 */     float time3 = time2 / 10.0F;
/* 156 */     return String.format("%.1f", new Object[] { Float.valueOf(time3) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float getElapsedTime(long startTime) {
/* 170 */     long time = System.currentTimeMillis();
/* 171 */     float time2 = (float)((time - startTime) / 10L);
/* 172 */     float time3 = time2 / 100.0F;
/* 173 */     return time3;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Tools.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */