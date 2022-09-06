/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.MediaTracker;
/*     */ import java.awt.Shape;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Area;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.PathIterator;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Picture
/*     */   extends Shapes
/*     */ {
/*     */   private BufferedImage imicBuffered;
/*     */   private MediaTracker tracker;
/*     */   
/*     */   public Picture(double xp, double yp, String name) {
/*  46 */     super(xp, yp, 100.0D, 100.0D, Color.blue);
/*  47 */     setTransparency(0.0F);
/*  48 */     this.tracker = new MediaTracker(getScene());
/*  49 */     Image imic = Toolkit.getDefaultToolkit().getImage(name);
/*  50 */     this.tracker.addImage(imic, 0);
/*     */     
/*     */     try {
/*  53 */       this.tracker.waitForAll();
/*  54 */     } catch (InterruptedException e) {
/*  55 */       e.printStackTrace();
/*     */     } 
/*  57 */     double width = imic.getWidth(null);
/*  58 */     double height = imic.getHeight(null);
/*  59 */     if (width > 0.0D) {
/*  60 */       setSize(width, height);
/*  61 */       this.imicBuffered = new BufferedImage((int)width, (int)height, 2);
/*     */ 
/*     */       
/*  64 */       Graphics gbi = this.imicBuffered.createGraphics();
/*  65 */       gbi.drawImage(imic, 0, 0, null);
/*  66 */       if (width <= 400.0D && height <= 400.0D) {
/*  67 */         Area ar = buildPath(xp, yp);
/*  68 */         AffineTransform at = new AffineTransform();
/*  69 */         at.setToIdentity();
/*  70 */         PathIterator pi = ar.getPathIterator(at);
/*  71 */         Path2D.Double p2d = new Path2D.Double();
/*  72 */         p2d.append(pi, true);
/*  73 */         setShape(p2d);
/*  74 */         setSize(p2d.getBounds2D().getWidth(), p2d.getBounds2D().getHeight());
/*     */       } else {
/*  76 */         Rectangle2D.Double rect = new Rectangle2D.Double(xp, yp, width, height);
/*  77 */         setShape(rect);
/*  78 */         setSize(width, height);
/*     */       } 
/*     */     } else {
/*     */       
/*  82 */       width = 100.0D;
/*  83 */       height = 30.0D;
/*  84 */       Rectangle2D rect = new Rectangle2D.Double(xp, yp, width, height);
/*  85 */       setShape(rect);
/*  86 */       setSize(width, height);
/*  87 */       this.imicBuffered = new BufferedImage((int)width, (int)height, 2);
/*  88 */       Graphics gbi = this.imicBuffered.createGraphics();
/*  89 */       gbi.setColor(Color.red);
/*  90 */       gbi.drawString("Nicht gefunden", 5, 10);
/*     */     } 
/*  92 */     getScene().insert(this);
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
/*     */ 
/*     */   
/*     */   public Picture(double xp, double yp, double w, double h, String name) {
/* 118 */     super(xp, yp, 100.0D, 100.0D, Color.blue);
/* 119 */     setTransparency(0.0F);
/* 120 */     this.tracker = new MediaTracker(getScene());
/* 121 */     Image imic = Toolkit.getDefaultToolkit().getImage(name);
/*     */     
/* 123 */     this.tracker.addImage(imic, 0);
/*     */     
/*     */     try {
/* 126 */       this.tracker.waitForAll();
/* 127 */     } catch (InterruptedException e) {
/* 128 */       e.printStackTrace();
/*     */     } 
/* 130 */     double width = imic.getWidth(null);
/* 131 */     if (width > 0.0D) {
/* 132 */       Image imgSmall = imic.getScaledInstance((int)w, (int)h, 4);
/* 133 */       this.tracker.addImage(imgSmall, 0);
/*     */       
/*     */       try {
/* 136 */         this.tracker.waitForAll();
/* 137 */       } catch (InterruptedException e) {
/* 138 */         e.printStackTrace();
/*     */       } 
/* 140 */       this.imicBuffered = new BufferedImage((int)w, (int)h, 2);
/*     */       
/* 142 */       Graphics gbi = this.imicBuffered.createGraphics();
/* 143 */       gbi.drawImage(imgSmall, 0, 0, null);
/* 144 */       if (w <= 400.0D && h <= 400.0D) {
/* 145 */         Area ar = buildPath(xp, yp);
/* 146 */         AffineTransform at = new AffineTransform();
/* 147 */         at.setToIdentity();
/* 148 */         PathIterator pi = ar.getPathIterator(at);
/* 149 */         Path2D.Double p2d = new Path2D.Double();
/* 150 */         p2d.append(pi, true);
/* 151 */         setShape(p2d);
/* 152 */         setSize(p2d.getBounds2D().getWidth(), p2d.getBounds2D().getHeight());
/*     */       } else {
/* 154 */         Rectangle2D.Double rect = new Rectangle2D.Double(xp, yp, w, h);
/* 155 */         setShape(rect);
/* 156 */         setSize(w, h);
/*     */       } 
/*     */     } else {
/*     */       
/* 160 */       width = 100.0D;
/* 161 */       double height = 30.0D;
/* 162 */       Rectangle2D rect = new Rectangle2D.Double(xp, yp, width, height);
/* 163 */       setShape(rect);
/* 164 */       setSize(width, height);
/* 165 */       this.imicBuffered = new BufferedImage((int)width, (int)height, 2);
/* 166 */       Graphics gbi = this.imicBuffered.createGraphics();
/* 167 */       gbi.setColor(Color.red);
/* 168 */       gbi.drawString("Nicht gefunden", 5, 10);
/*     */     } 
/* 170 */     getScene().insert(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Area buildPath(double x, double y) {
/* 179 */     BufferedImage bi = this.imicBuffered;
/* 180 */     int width = bi.getWidth();
/* 181 */     int height = bi.getHeight();
/* 182 */     Area ar = new Area();
/* 183 */     for (int col = 0; col < width; col++) {
/* 184 */       for (int row = 0; row < height; row++) {
/* 185 */         int farbWert = bi.getRGB(col, row);
/* 186 */         int alpha = farbWert >> 24 & 0xFF;
/* 187 */         if (alpha != 0) {
/* 188 */           ar.add(new Area(new Rectangle2D.Double(x + col, y + row, 1.0D, 1.0D)));
/*     */         }
/*     */       } 
/*     */     } 
/* 192 */     return ar;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Picture(double xp, double yp, BufferedImage image) {
/* 197 */     super(xp, yp, image.getWidth(null), image.getHeight(null), Color.white);
/* 198 */     setImage(image);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BufferedImage getImage() {
/* 205 */     return this.imicBuffered;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setImage(BufferedImage img) {
/* 212 */     this.imicBuffered = img;
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
/*     */   public Picture clone() {
/* 224 */     Picture newGrafik = new Picture(getXPosition(), getYPosition(), getImage());
/* 225 */     Shape oldShape = getShape();
/* 226 */     Object newShape = ((Rectangle2D)oldShape).clone();
/* 227 */     newGrafik.setShape((Rectangle2D)newShape);
/* 228 */     newGrafik.setHidden(getHidden());
/* 229 */     newGrafik.setAT(getAT());
/* 230 */     newGrafik.ttPaint = this.ttPaint;
/* 231 */     getScene().insert(newGrafik);
/* 232 */     return newGrafik;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Picture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */