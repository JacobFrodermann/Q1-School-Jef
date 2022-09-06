/*      */ package sas;
/*      */ 
/*      */ import SgJavaLib.sgSas.View;
/*      */ import SgJavaLib.sgSas.egFactory;
/*      */ import java.awt.AlphaComposite;
/*      */ import java.awt.Color;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Shape;
/*      */ import java.awt.TexturePaint;
/*      */ import java.awt.geom.AffineTransform;
/*      */ import java.awt.geom.Area;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.awt.image.ImageObserver;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import javax.imageio.ImageIO;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class Shapes
/*      */ {
/*      */   private double xPos;
/*      */   private double yPos;
/*      */   private double width;
/*      */   private double height;
/*      */   private double direction;
/*      */   private AffineTransform at;
/*      */   private boolean hidden = true;
/*      */   private Color color;
/*      */   private float alpha;
/*      */   protected Shape shape;
/*      */   protected ArrayList<Shapes> subSprites;
/*      */   protected Scene scene;
/*      */   protected TexturePaint ttPaint;
/*      */   protected int mouseX;
/*      */   protected int mouseY;
/*      */   protected boolean mouseClick;
/*      */   protected boolean mousePress;
/*      */   protected boolean mouseDrag;
/*      */   protected Picture backgroundPicture;
/*      */   private Thread parallelProcess;
/*      */   
/*      */   protected void setBackgroundPicture(Picture pBack) {
/*   60 */     this.backgroundPicture = pBack;
/*      */   }
/*      */ 
/*      */   
/*      */   protected Shapes(double xPos, double yPos, double width, double height, Color colour) {
/*   65 */     setColor(colour);
/*   66 */     this.direction = 90.0D;
/*   67 */     this.width = width;
/*   68 */     this.height = height;
/*   69 */     this.subSprites = new ArrayList<>();
/*   70 */     this.at = new AffineTransform();
/*   71 */     this.scene = View.getScene();
/*   72 */     this.ttPaint = null;
/*   73 */     this.xPos = xPos;
/*   74 */     this.yPos = yPos;
/*   75 */     this.alpha = 1.0F;
/*   76 */     this.mouseClick = false;
/*   77 */     this.mousePress = false;
/*   78 */     this.mouseDrag = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Shapes(double xPos, double yPos, double width, double height, String textur) {
/*   88 */     this(xPos, yPos, width, height, Color.blue);
/*   89 */     loadTexture(textur);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Color getColor() {
/*   97 */     return this.color;
/*      */   }
/*      */ 
/*      */   
/*      */   public void deleteMe() {
/*  102 */     getScene().remove(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColor(Color color) {
/*  108 */     this.color = color;
/*  109 */     getScene().repaint();
/*      */   }
/*      */   
/*      */   public String getShapeColor() {
/*  113 */     int r = this.color.getRed();
/*  114 */     int g = this.color.getGreen();
/*  115 */     int b = this.color.getBlue();
/*  116 */     String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(r), Integer.valueOf(g), Integer.valueOf(b) });
/*  117 */     return hex;
/*      */   }
/*      */   
/*      */   public void setHexColor(String pColor) {
/*  121 */     setColor(egFactory.getColor(pColor));
/*      */   }
/*      */   
/*      */   public String getHexColor() {
/*  125 */     Color c = getColor();
/*  126 */     int r = c.getRed();
/*  127 */     int g = c.getGreen();
/*  128 */     int b = c.getBlue();
/*  129 */     String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(r), Integer.valueOf(g), Integer.valueOf(b) });
/*  130 */     return hex;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected double getXPosition() {
/*  137 */     return this.xPos;
/*      */   }
/*      */ 
/*      */   
/*      */   protected double getYPosition() {
/*  142 */     return this.yPos;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setPosition(double x, double y) {
/*  147 */     this.xPos = x;
/*  148 */     this.yPos = y;
/*      */   }
/*      */ 
/*      */   
/*      */   protected double getWidth() {
/*  153 */     return this.width;
/*      */   }
/*      */ 
/*      */   
/*      */   protected double getHeight() {
/*  158 */     return this.height;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setSize(double width, double height) {
/*  163 */     this.width = width;
/*  164 */     this.height = height;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean hasTexture() {
/*  169 */     return (this.ttPaint != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public double getDirection() {
/*  174 */     return this.direction;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDirection(double direction) {
/*  179 */     this.direction = direction;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getShapeX() {
/*  189 */     Shape s = getAT().createTransformedShape(getShape());
/*  190 */     Rectangle2D r2d = s.getBounds2D();
/*  191 */     return r2d.getX();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getShapeY() {
/*  201 */     Shape s = getAT().createTransformedShape(getShape());
/*  202 */     Rectangle2D r2d = s.getBounds2D();
/*  203 */     return r2d.getY();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getShapeWidth() {
/*  213 */     Shape s = getAT().createTransformedShape(getShape());
/*  214 */     Rectangle2D r2d = s.getBounds2D();
/*  215 */     return r2d.getWidth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getShapeHeight() {
/*  225 */     Shape s = getAT().createTransformedShape(getShape());
/*  226 */     Rectangle2D r2d = s.getBounds2D();
/*  227 */     return r2d.getHeight();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHidden() {
/*  237 */     return this.hidden;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHidden(boolean hidden) {
/*  248 */     this.mouseClick = false;
/*  249 */     this.mousePress = false;
/*  250 */     this.mouseDrag = false;
/*  251 */     this.hidden = hidden;
/*  252 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */   
/*      */   protected Shape getShape() {
/*  257 */     return this.shape;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setShape(Shape shape) {
/*  262 */     this.shape = shape;
/*      */   }
/*      */ 
/*      */   
/*      */   protected Scene getScene() {
/*  267 */     return View.getScene();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getTransparency() {
/*  279 */     return this.alpha;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTransparency(float alpha) {
/*  290 */     this.alpha = alpha;
/*      */   }
/*      */ 
/*      */   
/*      */   protected ArrayList<Shapes> getSubSprites() {
/*  295 */     return this.subSprites;
/*      */   }
/*      */ 
/*      */   
/*      */   protected AffineTransform getAT() {
/*  300 */     return this.at;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setAT(AffineTransform at) {
/*  305 */     this.at = at;
/*      */   }
/*      */ 
/*      */   
/*      */   protected TexturePaint getTexture() {
/*  310 */     return this.ttPaint;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setTexture(TexturePaint ttp) {
/*  315 */     this.ttPaint = ttp;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadTexture(String fileName) {
/*  329 */     BufferedImage ttImage = null;
/*      */     try {
/*  331 */       ttImage = ImageIO.read(new File(fileName));
/*  332 */     } catch (IOException iOException) {}
/*      */     
/*      */     try {
/*  335 */       this
/*  336 */         .ttPaint = new TexturePaint(ttImage, new Rectangle(0, 0, ttImage.getWidth(), ttImage.getHeight()));
/*  337 */     } catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void delete(Shapes grafik) {
/*  346 */     if (this.subSprites.contains(grafik)) {
/*  347 */       this.subSprites.remove(grafik);
/*  348 */       getScene().repaint();
/*      */     } else {
/*  350 */       Iterator<Shapes> it = this.subSprites.iterator();
/*  351 */       while (it.hasNext()) {
/*  352 */         Shapes gr = it.next();
/*  353 */         gr.delete(grafik);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void zeichne(Graphics2D g2d) {
/*  363 */     if (!getHidden()) {
/*  364 */       g2d.setPaint(getColor());
/*  365 */       Shape s = getShape();
/*  366 */       AffineTransform atzeichne = getAT();
/*  367 */       g2d.setTransform(atzeichne);
/*  368 */       if (hasTexture()) {
/*  369 */         g2d.setPaint(this.ttPaint);
/*      */       }
/*  371 */       AlphaComposite alcom = AlphaComposite.getInstance(3, this.alpha);
/*      */       
/*  373 */       g2d.setComposite(alcom);
/*  374 */       g2d.draw(s);
/*  375 */       g2d.fill(s);
/*      */       
/*  377 */       if (this instanceof Text) {
/*  378 */         alcom = AlphaComposite.getInstance(3, 1.0F);
/*  379 */         g2d.setComposite(alcom);
/*  380 */         Text textgr = (Text)this;
/*  381 */         String str = textgr.getText();
/*  382 */         g2d.setFont(textgr.getFont());
/*  383 */         g2d.setColor(textgr.getFontColor());
/*  384 */         int h = (int)textgr.getHeight();
/*  385 */         FontMetrics fm = g2d.getFontMetrics();
/*  386 */         int ul = fm.getDescent();
/*  387 */         g2d.drawString(str, (int)textgr.getXPosition(), 
/*  388 */             (int)textgr.getYPosition() + h - ul);
/*  389 */       } else if (this instanceof Picture) {
/*  390 */         Picture iic = (Picture)this;
/*  391 */         alcom = AlphaComposite.getInstance(3, 1.0F);
/*      */         
/*  393 */         g2d.setComposite(alcom);
/*  394 */         BufferedImage img = iic.getImage();
/*  395 */         int x = (int)getXPosition();
/*  396 */         int y = (int)getYPosition();
/*  397 */         g2d.drawImage(img, x, y, (ImageObserver)null);
/*      */       } 
/*      */       
/*  400 */       Iterator<Shapes> it = getSubSprites().iterator();
/*  401 */       while (it.hasNext()) {
/*  402 */         Shapes gr = it.next();
/*  403 */         gr.zeichne(g2d);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getCenterX() {
/*  416 */     Shape sh = getAT().createTransformedShape(getShape());
/*  417 */     Rectangle2D r2d = sh.getBounds2D();
/*  418 */     double x = r2d.getX();
/*  419 */     double width = r2d.getWidth();
/*  420 */     return x + width / 2.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getCenterY() {
/*  430 */     Shape sh = getAT().createTransformedShape(getShape());
/*  431 */     Rectangle2D r2d = sh.getBounds2D();
/*  432 */     double y = r2d.getY();
/*  433 */     double height = r2d.getHeight();
/*  434 */     return y + height / 2.0D;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void turn(double angle) {
/*  445 */     double drehX = getCenterX();
/*  446 */     double drehY = getCenterY();
/*  447 */     turn(drehX, drehY, angle);
/*  448 */     setDirection(getDirection() + angle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void turnTo(double x, double y) {
/*  463 */     double direction = Tools.getDirection(getCenterX(), getCenterY(), x, y);
/*  464 */     double rotationAngle = direction - getDirection();
/*  465 */     turn(rotationAngle);
/*  466 */     setDirection(direction);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void turnTo(double angle) {
/*  479 */     double rotationAngle = angle - getDirection();
/*  480 */     turn(rotationAngle);
/*  481 */     setDirection(angle);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void turn(double x, double y, double angle) {
/*  498 */     AffineTransform atneu = new AffineTransform();
/*  499 */     atneu.setToRotation(Math.toRadians(angle), x, y);
/*  500 */     atneu.concatenate(getAT());
/*  501 */     setAT(atneu);
/*  502 */     rotateSubsprites(x, y, angle);
/*  503 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void rotateSubsprites(double dx, double dy, double winkel) {
/*  510 */     Iterator<Shapes> it = this.subSprites.iterator();
/*  511 */     while (it.hasNext()) {
/*  512 */       Shapes grf = it.next();
/*  513 */       AffineTransform atneu = new AffineTransform();
/*  514 */       atneu.setToRotation(Math.toRadians(winkel), dx, dy);
/*  515 */       AffineTransform atAlt = grf.getAT();
/*  516 */       atneu.concatenate(atAlt);
/*  517 */       grf.setAT(atneu);
/*  518 */       grf.rotateSubsprites(dx, dy, winkel);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void moveTo(double x, double y) {
/*  531 */     Shape shape = getAT().createTransformedShape(getShape());
/*  532 */     Rectangle2D rect2d = shape.getBounds2D();
/*  533 */     double xPos = rect2d.getX();
/*  534 */     double yPos = rect2d.getY();
/*  535 */     double dx = x - xPos;
/*  536 */     double dy = y - yPos;
/*  537 */     move(dx, dy);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void move(double dx, double dy) {
/*  551 */     AffineTransform atneu = new AffineTransform();
/*  552 */     atneu.translate(dx, dy);
/*  553 */     atneu.concatenate(getAT());
/*  554 */     setAT(atneu);
/*  555 */     moveSubsprites(dx, dy);
/*  556 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveSubsprites(double dx, double dy) {
/*  563 */     Iterator<Shapes> it = this.subSprites.iterator();
/*  564 */     while (it.hasNext()) {
/*  565 */       Shapes grf = it.next();
/*  566 */       AffineTransform atneu = new AffineTransform();
/*  567 */       atneu.translate(dx, dy);
/*  568 */       AffineTransform atAlt = grf.getAT();
/*  569 */       atneu.concatenate(atAlt);
/*  570 */       grf.setAT(atneu);
/*  571 */       grf.moveSubsprites(dx, dy);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void move(double d) {
/*  584 */     double dy = -d * Math.cos(Tools.degreeToRadian(this.direction));
/*  585 */     double dx = d * Math.sin(Tools.degreeToRadian(this.direction));
/*  586 */     move(dx, dy);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void scale(double sx, double sy) {
/*  600 */     double cx = getCenterX();
/*  601 */     double cy = getCenterY();
/*  602 */     AffineTransform atneu = new AffineTransform();
/*  603 */     atneu.scale(sx, sy);
/*  604 */     atneu.concatenate(getAT());
/*  605 */     setAT(atneu);
/*  606 */     scaleSubsprites(sx, sy);
/*  607 */     double cxneu = getCenterX();
/*  608 */     double cyneu = getCenterY();
/*  609 */     AffineTransform moveBack = new AffineTransform();
/*  610 */     moveBack.translate(-cxneu + cx, -cyneu + cy);
/*  611 */     moveBack.concatenate(atneu);
/*  612 */     setAT(moveBack);
/*  613 */     moveBackSubsprites(cx, cy, cxneu, cyneu);
/*  614 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void scaleSubsprites(double sx, double sy) {
/*  621 */     Iterator<Shapes> it = this.subSprites.iterator();
/*  622 */     while (it.hasNext()) {
/*  623 */       Shapes grf = it.next();
/*  624 */       AffineTransform atneu = new AffineTransform();
/*  625 */       atneu.scale(sx, sy);
/*  626 */       atneu.concatenate(grf.getAT());
/*  627 */       grf.setAT(atneu);
/*  628 */       grf.scaleSubsprites(sx, sy);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void moveBackSubsprites(double cx, double cy, double cxneu, double cyneu) {
/*  639 */     Iterator<Shapes> it = this.subSprites.iterator();
/*  640 */     while (it.hasNext()) {
/*  641 */       Shapes grf = it.next();
/*  642 */       AffineTransform moveBack = new AffineTransform();
/*  643 */       moveBack.translate(-cxneu + cx, -cyneu + cy);
/*  644 */       moveBack.concatenate(grf.getAT());
/*  645 */       grf.setAT(moveBack);
/*  646 */       grf.moveBackSubsprites(cx, cy, cxneu, cyneu);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void scaleTo(double width, double height) {
/*  661 */     Shape shape = getShape();
/*  662 */     Rectangle2D rect2d = shape.getBounds2D();
/*  663 */     scale(width / rect2d.getWidth(), height / rect2d.getHeight());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void flipHorizontal() {
/*  675 */     scale(-1.0D, 1.0D);
/*  676 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void flipVertical() {
/*  688 */     scale(1.0D, -1.0D);
/*  689 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(Shapes shape) {
/*  702 */     Area a1 = new Area(getAT().createTransformedShape(getShape()));
/*  703 */     Area a2 = new Area(shape.getAT().createTransformedShape(shape
/*  704 */           .getShape()));
/*  705 */     a1.intersect(a2);
/*  706 */     return a1.equals(a2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(double xPos, double yPos) {
/*  720 */     return getAT().createTransformedShape(getShape()).contains(xPos, yPos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean intersects(Shapes shape) {
/*  732 */     if (getHidden() || shape.getHidden()) {
/*  733 */       return false;
/*      */     }
/*  735 */     Area a1 = new Area(getAT().createTransformedShape(getShape()));
/*  736 */     Area a2 = new Area(shape.getAT().createTransformedShape(shape
/*  737 */           .getShape()));
/*  738 */     a1.intersect(a2);
/*  739 */     return !a1.isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean mousePressed() {
/*  752 */     if (this.hidden) {
/*  753 */       this.mousePress = false;
/*      */     }
/*  755 */     if (this.mousePress) {
/*  756 */       this.mousePress = false;
/*  757 */       return true;
/*      */     } 
/*  759 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean mouseClicked() {
/*  770 */     if (this.hidden) {
/*  771 */       this.mouseClick = false;
/*      */     }
/*  773 */     if (this.mouseClick) {
/*  774 */       this.mouseClick = false;
/*  775 */       return true;
/*      */     } 
/*  777 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setClick(int x, int y) {
/*  782 */     if (contains(x, y)) {
/*  783 */       View.getInstance().setLastClicked(this);
/*  784 */       this.mouseClick = true;
/*  785 */       this.mouseX = x;
/*  786 */       this.mouseY = y;
/*      */     } else {
/*  788 */       this.mouseClick = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setPressed(int x, int y) {
/*  794 */     if (contains(x, y)) {
/*  795 */       View.getInstance().setLastPressed(this);
/*  796 */       this.mousePress = true;
/*  797 */       this.mouseX = x;
/*  798 */       this.mouseY = y;
/*      */     } else {
/*  800 */       this.mousePress = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setDrag(int x, int y) {
/*  806 */     if (contains(x, y)) {
/*  807 */       this.mouseDrag = true;
/*  808 */       this.mouseX = x;
/*  809 */       this.mouseY = y;
/*      */     } else {
/*  811 */       this.mouseDrag = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void delDrag(int x, int y) {
/*  817 */     this.mouseDrag = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean mouseDragged() {
/*  828 */     if (this.hidden) {
/*  829 */       this.mouseDrag = false;
/*      */     }
/*  831 */     if (this.mouseDrag) {
/*  832 */       return true;
/*      */     }
/*  834 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMouseX() {
/*  846 */     return this.mouseX;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMouseY() {
/*  855 */     return this.mouseY;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Shapes getCollidingShape() {
/*  861 */     for (Iterator<Shapes> it = (View.getScene()).grafiken.iterator(); it.hasNext(); ) {
/*  862 */       Shapes s = it.next();
/*  863 */       if (s.intersects(this) && s != this) {
/*  864 */         return s;
/*      */       }
/*      */     } 
/*  867 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  873 */     AffineTransform at = new AffineTransform();
/*  874 */     at.setToIdentity();
/*  875 */     setAT(at);
/*  876 */     resetSubsprites();
/*  877 */     getScene().repaint();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void resetSubsprites() {
/*  883 */     Iterator<Shapes> it = this.subSprites.iterator();
/*  884 */     while (it.hasNext()) {
/*  885 */       Shapes grf = it.next();
/*  886 */       AffineTransform atneu = new AffineTransform();
/*  887 */       atneu.setToIdentity();
/*  888 */       grf.setAT(atneu);
/*  889 */       grf.resetSubsprites();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void backgroundTask() {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void startBackgroundTask() {
/*  902 */     this.parallelProcess = new Thread()
/*      */       {
/*      */         public void run() {
/*  905 */           Shapes.this.backgroundTask();
/*      */         }
/*      */       };
/*  908 */     this.parallelProcess.start();
/*      */   }
/*      */   
/*      */   public boolean backgroundTaskActive() {
/*  912 */     return !this.parallelProcess.isInterrupted();
/*      */   }
/*      */   
/*      */   public void stopBackgroundTask() {
/*  916 */     this.parallelProcess.interrupt();
/*      */   }
/*      */   
/*      */   public boolean isOnHexColor(String pColor) {
/*  920 */     setHidden(true);
/*  921 */     boolean b = View.getInstance().getHexColorAt((int)getCenterX(), (int)getCenterY()).equalsIgnoreCase(pColor);
/*  922 */     setHidden(false);
/*  923 */     return b;
/*      */   }
/*      */   
/*      */   public boolean isOnHexColor(String pColor, int pXoffset, int pYoffset) {
/*  927 */     setHidden(true);
/*  928 */     boolean b = View.getInstance().getHexColorAt((int)getCenterX() + pXoffset, (int)getCenterY() + pYoffset).equalsIgnoreCase(pColor);
/*  929 */     setHidden(false);
/*  930 */     return b;
/*      */   }
/*      */   
/*      */   public boolean isOnBackgroundHexColor(String pColor, int pXoffset, int pYoffset) {
/*  934 */     if (this.backgroundPicture != null) {
/*  935 */       int x = (int)(getCenterX() + pXoffset - this.backgroundPicture.getShapeX());
/*  936 */       int y = (int)(getCenterY() + pYoffset - this.backgroundPicture.getShapeY());
/*  937 */       if (this.backgroundPicture.contains(x, y))
/*      */       {
/*  939 */         int c = this.backgroundPicture.getImage().getRGB(x, y);
/*  940 */         int red = (c & 0xFF0000) >> 16;
/*  941 */         int green = (c & 0xFF00) >> 8;
/*  942 */         int blue = c & 0xFF;
/*      */ 
/*      */ 
/*      */         
/*  946 */         String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue) });
/*  947 */         return pColor.equalsIgnoreCase(hex);
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  953 */       System.out.println("Fehler beim Abfragen der Hintergrundfarbe: Du hast bei einem Objekt vergessen, das Hintergrund-Objekt festzulegen.");
/*      */     } 
/*      */     
/*  956 */     return false;
/*      */   }
/*      */   
/*      */   public String getBackgroundHexColor(int pX, int pY) {
/*  960 */     int x = pX;
/*  961 */     int y = pY;
/*      */ 
/*      */     
/*  964 */     if (this.backgroundPicture != null) {
/*      */ 
/*      */       
/*  967 */       if (this.backgroundPicture.contains(x, y)) {
/*      */ 
/*      */ 
/*      */         
/*  971 */         int c = this.backgroundPicture.getImage().getRGB(x, y);
/*  972 */         int red = (c & 0xFF0000) >> 16;
/*  973 */         int green = (c & 0xFF00) >> 8;
/*  974 */         int blue = c & 0xFF;
/*      */ 
/*      */ 
/*      */         
/*  978 */         String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(red), Integer.valueOf(green), Integer.valueOf(blue) });
/*  979 */         return hex;
/*      */       } 
/*      */ 
/*      */       
/*  983 */       System.out.println("Koordinaten Außerhalb");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  988 */     return "Background not set";
/*      */   }
/*      */   
/*      */   public boolean isOnColor(Color pColor) {
/*  992 */     setHidden(true);
/*  993 */     boolean b = (View.getInstance().getColorAt((int)getCenterX(), (int)getCenterY()) == pColor);
/*  994 */     setHidden(false);
/*  995 */     return b;
/*      */   }
/*      */   
/*      */   public boolean isOnColor(Color pColor, int pXoffset, int pYoffset) {
/*  999 */     setHidden(true);
/* 1000 */     boolean b = (View.getInstance().getColorAt((int)getCenterX() + pXoffset, (int)getCenterY() + pYoffset) == pColor);
/* 1001 */     setHidden(false);
/* 1002 */     return b;
/*      */   }
/*      */   
/*      */   public abstract Shapes clone();
/*      */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Shapes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */