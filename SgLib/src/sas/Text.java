/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.image.BufferedImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Text
/*     */   extends Shapes
/*     */ {
/*     */   private Font font;
/*     */   private String text;
/*     */   private Color fontColor;
/*  23 */   private static Graphics g1 = (new BufferedImage(1, 1, 10)).createGraphics();
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
/*     */   public Text(double xp, double yp, String text, Color fontColor) {
/*  43 */     super(xp, yp, 100.0D, 30.0D, Color.white);
/*  44 */     setTransparency(0.0F);
/*  45 */     this.text = text;
/*  46 */     this.fontColor = fontColor;
/*  47 */     this.font = new Font("Serif", 1, 24);
/*  48 */     g1.setFont(this.font);
/*  49 */     FontMetrics fm = g1.getFontMetrics();
/*  50 */     double w = fm.stringWidth(text);
/*  51 */     double h = fm.getHeight();
/*     */ 
/*     */     
/*  54 */     Rectangle2D rect = new Rectangle2D.Double(getXPosition(), getYPosition(), w, h);
/*  55 */     setShape(rect);
/*  56 */     setSize(w, h);
/*  57 */     getScene().insert(this);
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
/*     */   public Text(double xp, double yp, String text) {
/*  77 */     super(xp, yp, 100.0D, 30.0D, Color.white);
/*  78 */     setTransparency(0.0F);
/*  79 */     this.text = text;
/*  80 */     this.fontColor = Color.black;
/*  81 */     this.font = new Font("Serif", 1, 24);
/*  82 */     g1.setFont(this.font);
/*  83 */     FontMetrics fm = g1.getFontMetrics();
/*  84 */     double w = fm.stringWidth(text);
/*  85 */     double h = fm.getHeight();
/*     */     
/*  87 */     Rectangle2D rect = new Rectangle2D.Double(getXPosition(), getYPosition(), w, h);
/*  88 */     setShape(rect);
/*  89 */     setSize(w, h);
/*  90 */     getScene().insert(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Text clone() {
/* 101 */     Text newGrafik = new Text(getXPosition(), getYPosition(), getText(), getFontColor());
/* 102 */     Shape oldShape = getShape();
/* 103 */     Object newShape = ((Rectangle2D)oldShape).clone();
/* 104 */     newGrafik.setShape((Shape)newShape);
/* 105 */     newGrafik.setHidden(getHidden());
/* 106 */     newGrafik.setAT(getAT());
/* 107 */     newGrafik.setTexture(getTexture());
/* 108 */     newGrafik.setDirection(getDirection());
/* 109 */     newGrafik.setTransparency(getTransparency());
/* 110 */     newGrafik.setFont(getFont());
/* 111 */     getScene().insert(newGrafik);
/* 112 */     getScene().repaint();
/* 113 */     return newGrafik;
/*     */   }
/*     */   
/*     */   private void setNewFont(String name, int style, int size) {
/* 117 */     this.font = new Font(name, style, size);
/* 118 */     g1.setFont(this.font);
/* 119 */     FontMetrics fm = g1.getFontMetrics();
/* 120 */     double w = fm.stringWidth(this.text);
/* 121 */     double h = fm.getHeight();
/*     */     
/* 123 */     Rectangle2D rect = new Rectangle2D.Double(getXPosition(), getYPosition(), w, h);
/* 124 */     setShape(rect);
/* 125 */     getScene().repaint();
/* 126 */     setSize(w, h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 134 */     return this.text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Font getFont() {
/* 141 */     return this.font;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setFont(Font ft) {
/* 148 */     this.font = ft;
/* 149 */     g1.setFont(this.font);
/* 150 */     FontMetrics fm = g1.getFontMetrics();
/* 151 */     double w = fm.stringWidth(this.text);
/* 152 */     double h = fm.getHeight();
/*     */     
/* 154 */     Rectangle2D rect = new Rectangle2D.Double(getXPosition(), getYPosition(), w, h);
/* 155 */     setShape(rect);
/* 156 */     setSize(w, h);
/* 157 */     getScene().repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setText(String text) {
/* 168 */     this.text = text;
/* 169 */     FontMetrics fm = g1.getFontMetrics();
/* 170 */     double w = fm.stringWidth(text);
/* 171 */     double h = fm.getHeight();
/*     */     
/* 173 */     Rectangle2D rect = new Rectangle2D.Double(getXPosition(), getYPosition(), w, h);
/* 174 */     setShape(rect);
/* 175 */     setSize(w, h);
/* 176 */     getScene().repaint();
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
/*     */   public void setFontSerif(boolean bold, int size) {
/* 191 */     setNewFont("Serif", 1, size);
/* 192 */     getScene().repaint();
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
/*     */   public void setFontSansSerif(boolean bold, int size) {
/* 206 */     setNewFont("SansSerif", 1, size);
/* 207 */     getScene().repaint();
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
/*     */   public void setFontMonospaced(boolean bold, int size) {
/* 221 */     setNewFont("Monospaced", 1, size);
/* 222 */     getScene().repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontColor(Color color) {
/* 232 */     this.fontColor = color;
/* 233 */     getScene().repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getFontColor() {
/* 242 */     return this.fontColor;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Text.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */