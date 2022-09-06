/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.AffineTransform;
/*     */ import java.awt.geom.Path2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Sprite
/*     */   extends Shapes
/*     */ {
/*     */   boolean empty;
/*     */   
/*     */   public Sprite(Shapes shape) {
/*  24 */     super(0.0D, 0.0D, 0.0D, 0.0D, Color.white);
/*  25 */     getSubSprites().clear();
/*  26 */     AffineTransform at = new AffineTransform();
/*  27 */     at.setToIdentity();
/*  28 */     setAT(at);
/*  29 */     this.empty = true;
/*  30 */     add(shape);
/*  31 */     getScene().insert(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite() {
/*  39 */     super(0.0D, 0.0D, 0.0D, 0.0D, Color.white);
/*  40 */     getSubSprites().clear();
/*  41 */     setShape(new Rectangle2D.Double(0.0D, 0.0D, 0.0D, 0.0D));
/*  42 */     AffineTransform at = new AffineTransform();
/*  43 */     at.setToIdentity();
/*  44 */     this.empty = true;
/*  45 */     setAT(at);
/*  46 */     setTransparency(0.0F);
/*  47 */     getScene().insert(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Shapes shape) {
/*  57 */     if (!this.empty) {
/*  58 */       Shape shapeOld = getShape();
/*  59 */       AffineTransform atOld = getAT();
/*     */       
/*  61 */       Path2D newPath = (Path2D)atOld.createTransformedShape(shapeOld);
/*  62 */       AffineTransform atShape = shape.getAT();
/*  63 */       Shape shapeTransformed = atShape.createTransformedShape(shape.getShape());
/*  64 */       newPath.append(shapeTransformed, true);
/*  65 */       setShape(newPath);
/*  66 */       getAT().setToIdentity();
/*  67 */       Rectangle2D r2d = newPath.getBounds2D();
/*  68 */       setPosition(r2d.getX(), r2d.getY());
/*  69 */       setSize(r2d.getWidth(), r2d.getHeight());
/*  70 */       delete(shape);
/*     */     } else {
/*  72 */       setShape(shape.getShape());
/*  73 */       setPosition(shape.getShapeX(), shape.getShapeY());
/*  74 */       setSize(shape.getShapeWidth(), shape.getShapeHeight());
/*  75 */       getAT().setToIdentity();
/*     */       
/*  77 */       this.empty = false;
/*     */     } 
/*  79 */     getScene().remove(shape);
/*     */     
/*  81 */     getSubSprites().add(shape);
/*     */     
/*  83 */     setTransparency(0.0F);
/*  84 */     getScene().repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sprite clone() {
/*  95 */     System.out.println("Clone");
/*  96 */     Sprite newGrafik = new Sprite();
/*  97 */     Shape oldShape = getShape();
/*  98 */     Path2D newShape = (Path2D)((Path2D)oldShape).clone();
/*  99 */     Rectangle2D r2d = newShape.getBounds2D();
/* 100 */     newGrafik.setSize(r2d.getWidth(), r2d.getHeight());
/* 101 */     newGrafik.setPosition(r2d.getX(), r2d.getY());
/* 102 */     newGrafik.setShape(newShape);
/* 103 */     newGrafik.setHidden(getHidden());
/* 104 */     newGrafik.setAT(getAT());
/* 105 */     newGrafik.setDirection(getDirection());
/* 106 */     newGrafik.setTransparency(getTransparency());
/* 107 */     cloneSubsprites(newGrafik);
/* 108 */     getScene().insert(newGrafik);
/*     */     
/* 110 */     return newGrafik;
/*     */   }
/*     */   
/*     */   protected void cloneSubsprites(Sprite newGrf) {
/* 114 */     System.out.println("Clone Subsprites");
/* 115 */     Iterator<Shapes> it = getSubSprites().iterator();
/* 116 */     while (it.hasNext()) {
/* 117 */       System.out.println("Subsprite gefunden");
/* 118 */       Shapes gr = it.next();
/* 119 */       newGrf.add(gr.clone());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Sprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */