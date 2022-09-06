/*     */ package sas;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Point;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.HierarchyBoundsListener;
/*     */ import java.awt.event.HierarchyEvent;
/*     */ import java.awt.event.HierarchyListener;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JFrame;
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
/*     */ public final class View
/*     */ {
/*  41 */   private static int instances = 0;
/*  42 */   private static Scene scene = new Scene();
/*     */ 
/*     */   
/*     */   private JFrame frame;
/*     */ 
/*     */   
/*     */   private Vector<Character> buffer;
/*     */   
/*     */   private HashSet<Integer> gedrueckt;
/*     */   
/*     */   private static View view;
/*     */ 
/*     */   
/*     */   public View() {
/*  56 */     if (instances == 1) {
/*  57 */       throw new RuntimeException();
/*     */     }
/*  59 */     instances++;
/*  60 */     int width = 600;
/*  61 */     int height = 400;
/*  62 */     String name = "SaS-Programm";
/*  63 */     this.frame = new JFrame(name);
/*     */     
/*  65 */     Container jp = this.frame.getContentPane();
/*     */ 
/*     */     
/*  68 */     scene.setPreferredSize(new Dimension(width, height));
/*  69 */     scene.setFocusable(true);
/*  70 */     jp.add(scene, "Center");
/*     */     
/*  72 */     this.frame.setDefaultCloseOperation(3);
/*  73 */     this.frame.setResizable(false);
/*  74 */     this.frame.pack();
/*  75 */     this.frame.setLocationRelativeTo((Component)null);
/*  76 */     this.frame.setVisible(true);
/*  77 */     scene.requestFocus();
/*  78 */     this.buffer = getScene().getBuffer();
/*  79 */     this.gedrueckt = getScene().getGedrueckt();
/*  80 */     this.frame.addHierarchyListener(new HierarchyListener() {
/*     */           public void hierarchyChanged(HierarchyEvent e) {
/*  82 */             long flags = e.getChangeFlags();
/*  83 */             if ((flags & 0x4L) == 4L) {
/*  84 */               View.this.probablyExit();
/*     */             }
/*     */           }
/*     */         });
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
/*     */   public View(String name) {
/* 102 */     if (instances == 1) {
/* 103 */       throw new RuntimeException();
/*     */     }
/* 105 */     instances++;
/* 106 */     int width = 600;
/* 107 */     int height = 400;
/* 108 */     this.frame = new JFrame(name);
/*     */     
/* 110 */     Container jp = this.frame.getContentPane();
/*     */ 
/*     */     
/* 113 */     scene.setPreferredSize(new Dimension(width, height));
/* 114 */     scene.setFocusable(true);
/* 115 */     jp.add(scene, "Center");
/*     */     
/* 117 */     this.frame.setDefaultCloseOperation(3);
/* 118 */     this.frame.setResizable(false);
/* 119 */     this.frame.pack();
/* 120 */     this.frame.setLocationRelativeTo((Component)null);
/* 121 */     this.frame.setVisible(true);
/* 122 */     scene.requestFocus();
/* 123 */     this.buffer = getScene().getBuffer();
/* 124 */     this.gedrueckt = getScene().getGedrueckt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     this.frame.addHierarchyListener(new HierarchyListener() {
/*     */           public void hierarchyChanged(HierarchyEvent e) {
/* 134 */             long flags = e.getChangeFlags();
/* 135 */             if ((flags & 0x4L) == 4L) {
/* 136 */               View.this.probablyExit();
/*     */             }
/*     */           }
/*     */         });
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
/*     */   public View(int width, int height) {
/* 155 */     if (instances == 1) {
/* 156 */       throw new RuntimeException();
/*     */     }
/* 158 */     instances++;
/* 159 */     int w = width;
/* 160 */     int h = height;
/* 161 */     this.frame = new JFrame("sas-Programm");
/*     */     
/* 163 */     Container jp = this.frame.getContentPane();
/*     */ 
/*     */     
/* 166 */     scene.setPreferredSize(new Dimension(w, h));
/* 167 */     scene.setFocusable(true);
/* 168 */     jp.add(scene, "Center");
/*     */     
/* 170 */     this.frame.setDefaultCloseOperation(3);
/* 171 */     this.frame.setResizable(false);
/* 172 */     this.frame.pack();
/* 173 */     this.frame.setLocationRelativeTo((Component)null);
/* 174 */     this.frame.setVisible(true);
/* 175 */     scene.requestFocus();
/* 176 */     this.buffer = getScene().getBuffer();
/* 177 */     this.gedrueckt = getScene().getGedrueckt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     this.frame.addHierarchyListener(new HierarchyListener() {
/*     */           public void hierarchyChanged(HierarchyEvent e) {
/* 187 */             long flags = e.getChangeFlags();
/* 188 */             if ((flags & 0x4L) == 4L) {
/* 189 */               View.this.probablyExit();
/*     */             }
/*     */           }
/*     */         });
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
/*     */   public View(int width, int height, String name) {
/* 210 */     if (instances == 1) {
/* 211 */       throw new RuntimeException();
/*     */     }
/* 213 */     instances++;
/* 214 */     int w = width;
/* 215 */     int h = height;
/* 216 */     this.frame = new JFrame(name);
/*     */     
/* 218 */     Container jp = this.frame.getContentPane();
/*     */ 
/*     */     
/* 221 */     scene.setPreferredSize(new Dimension(w, h));
/* 222 */     scene.setFocusable(true);
/* 223 */     jp.add(scene, "Center");
/*     */     
/* 225 */     this.frame.setDefaultCloseOperation(3);
/* 226 */     this.frame.setResizable(false);
/* 227 */     this.frame.pack();
/* 228 */     this.frame.setLocationRelativeTo((Component)null);
/* 229 */     this.frame.setVisible(true);
/* 230 */     scene.requestFocus();
/* 231 */     this.buffer = getScene().getBuffer();
/* 232 */     this.gedrueckt = getScene().getGedrueckt();
/* 233 */     this.frame.addHierarchyListener(new HierarchyListener() {
/*     */           public void hierarchyChanged(HierarchyEvent e) {
/* 235 */             long flags = e.getChangeFlags();
/* 236 */             if ((flags & 0x4L) == 4L) {
/* 237 */               View.this.probablyExit();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private JFrame getFrame() {
/* 246 */     return this.frame;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void probablyExit() {
/* 251 */     if (!this.frame.isShowing()) {
/* 252 */       this.frame.dispatchEvent(new WindowEvent(this.frame, 201));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static View getView() {
/* 259 */     if (instances == 0) {
/* 260 */       view = new View();
/*     */     }
/* 262 */     return view;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static Scene getScene() {
/* 269 */     return scene;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(Shapes grafik) {
/* 280 */     scene.remove(grafik);
/* 281 */     scene.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackgroundColor(Color col) {
/* 292 */     scene.setColor(col);
/* 293 */     scene.repaint();
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
/*     */   public void setSize(int width, int height) {
/* 306 */     scene.setPreferredSize(new Dimension(width, height));
/* 307 */     getFrame().pack();
/* 308 */     getFrame().getContentPane()
/* 309 */       .addHierarchyBoundsListener(new HierarchyBoundsListener() {
/*     */           public void ancestorMoved(HierarchyEvent e) {
/* 311 */             View.scene.repaint();
/*     */           }
/*     */ 
/*     */           
/*     */           public void ancestorResized(HierarchyEvent e) {
/* 316 */             View.scene.repaint();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(String name) {
/* 323 */     getFrame().setTitle(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyBackspacePressed() {
/* 333 */     if (this.gedrueckt.contains(Integer.valueOf(8))) {
/* 334 */       return true;
/*     */     }
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyEnterPressed() {
/* 344 */     if (this.gedrueckt.contains(Integer.valueOf(10))) {
/* 345 */       return true;
/*     */     }
/* 347 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char keyGetChar() {
/* 358 */     char c = ' ';
/* 359 */     while (this.buffer.size() == 0);
/*     */ 
/*     */     
/* 362 */     c = ((Character)this.buffer.get(0)).charValue();
/* 363 */     this.buffer.remove(0);
/* 364 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyPressed(char pT) {
/* 375 */     int pTCode = pT;
/* 376 */     if (pT >= 'a' && pT <= 'z') {
/* 377 */       pTCode -= 32;
/*     */     }
/* 379 */     if (this.gedrueckt.contains(Integer.valueOf(pTCode))) {
/* 380 */       return true;
/*     */     }
/* 382 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyPressed() {
/* 389 */     return !this.gedrueckt.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyLeftPressed() {
/* 397 */     if (this.gedrueckt.contains(Integer.valueOf(37))) {
/* 398 */       return true;
/*     */     }
/* 400 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyUpPressed() {
/* 408 */     if (this.gedrueckt.contains(Integer.valueOf(38))) {
/* 409 */       return true;
/*     */     }
/* 411 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyDownPressed() {
/* 419 */     if (this.gedrueckt.contains(Integer.valueOf(40))) {
/* 420 */       return true;
/*     */     }
/* 422 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean keyRightPressed() {
/* 430 */     if (this.gedrueckt.contains(Integer.valueOf(39))) {
/* 431 */       return true;
/*     */     }
/* 433 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyBufferDelete() {
/* 440 */     this.buffer.removeAllElements();
/* 441 */     this.gedrueckt.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void wait(int millSec) {
/*     */     try {
/* 449 */       Thread.sleep(millSec);
/* 450 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getColorAt(int pX, int pY) {
/*     */     try {
/* 460 */       BufferedImage awtImage = new BufferedImage(getScene().getWidth(), getScene().getHeight(), 1);
/* 461 */       Graphics g = awtImage.getGraphics();
/* 462 */       getScene().printAll(g);
/*     */       
/* 464 */       if (pX >= 0 && pX <= awtImage.getWidth() && pY >= 0 && pY <= awtImage.getHeight()) {
/* 465 */         int rgbColor = awtImage.getRGB(pX, pY);
/*     */         
/* 467 */         return new Color(rgbColor);
/*     */       } 
/* 469 */       return Color.BLACK;
/*     */     }
/* 471 */     catch (Exception e) {
/* 472 */       return Color.BLACK;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHexColorAt(int pX, int pY) {
/* 480 */     Color c = getColorAt(pX, pY);
/*     */     
/* 482 */     int r = c.getRed();
/* 483 */     int g = c.getGreen();
/* 484 */     int b = c.getBlue();
/* 485 */     String hex = String.format("#%02x%02x%02x", new Object[] { Integer.valueOf(r), Integer.valueOf(g), Integer.valueOf(b) });
/* 486 */     return hex;
/*     */   }
/*     */ 
/*     */   
/*     */   public Shapes getShapeAt(int pX, int pY) {
/* 491 */     for (Iterator<Shapes> it = (getScene()).grafiken.iterator(); it.hasNext(); ) {
/* 492 */       Shapes s = it.next();
/* 493 */       if (s.contains(pX, pY)) {
/* 494 */         return s;
/*     */       }
/*     */     } 
/* 497 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean collisionDetected() {
/* 502 */     for (Shapes start : (getScene()).grafiken) {
/* 503 */       for (Shapes s : (getScene()).grafiken) {
/* 504 */         if (start != s && start.intersects(s)) {
/* 505 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 510 */     return false;
/*     */   }
/*     */   
/*     */   public LinkedList<Shapes> getCollidingObjects() {
/* 514 */     LinkedList<Shapes> col = new LinkedList<>();
/* 515 */     for (Shapes start : (getScene()).grafiken) {
/* 516 */       for (Shapes s : (getScene()).grafiken) {
/* 517 */         if (start != s && start.intersects(s)) {
/* 518 */           if (!col.contains(s)) {
/* 519 */             col.addLast(s);
/*     */           }
/*     */           
/* 522 */           if (!col.contains(start)) {
/* 523 */             col.addLast(start);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 530 */     return col;
/*     */   }
/*     */   
/*     */   public void setResizable(boolean pResizeable) {
/* 534 */     this.frame.setResizable(pResizeable);
/*     */   }
/*     */   
/*     */   public void toCenter() {
/* 538 */     this.frame.setLocationRelativeTo((Component)null);
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 542 */     return this.frame.getWidth();
/*     */   }
/*     */   
/*     */   public int getHeigth() {
/* 546 */     return this.frame.getHeight();
/*     */   }
/*     */   
/*     */   public void hideMouse(boolean pNoMouse) {
/* 550 */     if (pNoMouse) {
/* 551 */       BufferedImage cursorImg = new BufferedImage(16, 16, 2);
/* 552 */       Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
/*     */       
/* 554 */       this.frame.getContentPane().setCursor(blankCursor);
/*     */     } else {
/*     */       
/* 557 */       this.frame.getContentPane().setCursor(Cursor.getDefaultCursor());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\View.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */