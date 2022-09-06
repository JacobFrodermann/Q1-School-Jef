/*     */ package sas;
/*     */ 
/*     */ import SgJavaLib.sgSas.Keyboard;
/*     */ import SgJavaLib.sgSas.Mouse;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Vector;
/*     */ import javax.swing.JPanel;
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
/*     */ public class Scene
/*     */   extends JPanel
/*     */ {
/*  36 */   protected List<Shapes> grafiken = Collections.synchronizedList(new ArrayList<>());
/*     */   
/*     */   private Graphics2D g2d;
/*     */   
/*     */   protected Vector<Character> keyBuffer;
/*     */   
/*     */   protected HashSet<Integer> gedrueckt;
/*     */   
/*     */   protected boolean mouseDown = false;
/*     */   
/*     */   protected boolean doubleClick = false;
/*     */   
/*     */   protected boolean mouseClicked = false;
/*     */   
/*     */   protected boolean mouseDragged = false;
/*     */   private int mouseX;
/*     */   private int mouseY;
/*     */   
/*     */   protected Scene() {
/*  55 */     setDoubleBuffered(true);
/*  56 */     setBackground(Color.white);
/*  57 */     addMouseListener(new MouseClicks());
/*  58 */     addMouseMotionListener(new MouseMotion());
/*  59 */     addKeyListener(new KeyReader());
/*     */     
/*  61 */     this.keyBuffer = new Vector<>();
/*  62 */     this.gedrueckt = new HashSet<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Scene getScene() {
/*  68 */     return this;
/*     */   }
/*     */   
/*     */   protected Graphics2D getGC() {
/*  72 */     return this.g2d;
/*     */   }
/*     */   
/*     */   protected void setGC(Graphics g) {
/*  76 */     this.g2d = (Graphics2D)g;
/*     */   }
/*     */   
/*     */   protected void setColor(Color pFarbe) {
/*  80 */     setBackground(pFarbe);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void insert(Shapes grafik) {
/*  89 */     if (grafik != null) {
/*  90 */       grafik.setHidden(false);
/*  91 */       remove(grafik);
/*  92 */       this.grafiken.add(grafik);
/*  93 */       repaint();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void remove(Shapes grafik) {
/* 103 */     if (grafik != null) {
/* 104 */       if (this.grafiken.contains(grafik)) {
/* 105 */         this.grafiken.remove(grafik);
/* 106 */         getScene().repaint();
/*     */       } else {
/* 108 */         synchronized (grafik.subSprites) {
/* 109 */           Iterator<Shapes> it = grafik.subSprites.iterator();
/* 110 */           while (it.hasNext()) {
/* 111 */             Shapes gr = it.next();
/* 112 */             gr.delete(grafik);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 126 */     super.paintComponent(g);
/* 127 */     this.g2d = (Graphics2D)g;
/* 128 */     this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */     
/* 130 */     this.g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*     */     
/* 132 */     synchronized (this.grafiken) {
/* 133 */       Iterator<Shapes> it = this.grafiken.iterator();
/* 134 */       while (it.hasNext()) {
/* 135 */         Shapes gr = it.next();
/* 136 */         gr.zeichne(this.g2d);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class MouseMotion
/*     */     extends MouseMotionAdapter
/*     */   {
/*     */     private MouseMotion() {}
/*     */ 
/*     */     
/*     */     public void mouseDragged(MouseEvent e) {
/* 150 */       Scene.this.saveXY(e.getX(), e.getY());
/* 151 */       Iterator<Shapes> grafIt = Scene.this.grafiken.iterator();
/* 152 */       while (grafIt.hasNext()) {
/* 153 */         Shapes s = grafIt.next();
/* 154 */         s.setDrag(e.getX(), e.getY());
/*     */       } 
/* 156 */       Scene.this.saveDragged(true);
/* 157 */       Scene.this.saveClicked(false);
/*     */     }
/*     */ 
/*     */     
/*     */     public void mouseMoved(MouseEvent e) {
/* 162 */       Scene.this.saveXY(e.getX(), e.getY());
/*     */     }
/*     */   }
/*     */   
/*     */   private class MouseClicks extends MouseAdapter {
/*     */     public void mouseEntered(MouseEvent e) {
/* 168 */       Scene.this.saveXY(e.getX(), e.getY());
/*     */     }
/*     */     
/*     */     public void mousePressed(MouseEvent e) {
/* 172 */       Scene.this.saveXY(e.getX(), e.getY());
/* 173 */       Iterator<Shapes> grafIt = Scene.this.grafiken.iterator();
/* 174 */       while (grafIt.hasNext()) {
/* 175 */         Shapes s = grafIt.next();
/* 176 */         s.setPressed(e.getX(), e.getY());
/*     */       } 
/* 178 */       Scene.this.saveClicked(false);
/* 179 */       Scene.this.saveDown(true);
/*     */     }
/*     */     private MouseClicks() {}
/*     */     public void mouseClicked(MouseEvent e) {
/* 183 */       Scene.this.saveXY(e.getX(), e.getY());
/* 184 */       Iterator<Shapes> grafIt = Scene.this.grafiken.iterator();
/* 185 */       while (grafIt.hasNext()) {
/* 186 */         Shapes s = grafIt.next();
/* 187 */         s.setClick(e.getX(), e.getY());
/*     */       } 
/* 189 */       Scene.this.saveClicked(true);
/* 190 */       Scene.this.saveDown(false);
/* 191 */       Scene.this.saveDragged(false);
/*     */     }
/*     */     
/*     */     public void mouseReleased(MouseEvent e) {
/* 195 */       Scene.this.saveXY(e.getX(), e.getY());
/* 196 */       Iterator<Shapes> grafIt = Scene.this.grafiken.iterator();
/* 197 */       while (grafIt.hasNext()) {
/* 198 */         Shapes s = grafIt.next();
/* 199 */         s.delDrag(e.getX(), e.getY());
/*     */       } 
/* 201 */       Scene.this.saveDown(false);
/* 202 */       Scene.this.saveDragged(false);
/* 203 */       if (e.getClickCount() > 1) {
/* 204 */         Scene.this.saveDoubleClick(true);
/*     */       } else {
/* 206 */         Scene.this.saveDoubleClick(false);
/*     */       } 
/*     */     } }
/*     */   
/*     */   protected int getMouseX() {
/* 211 */     return this.mouseX;
/*     */   }
/*     */   
/*     */   protected int getMouseY() {
/* 215 */     return this.mouseY;
/*     */   }
/*     */   
/*     */   protected boolean getDoubleClick() {
/* 219 */     return this.doubleClick;
/*     */   }
/*     */   
/*     */   protected boolean getMouseDown() {
/* 223 */     return this.mouseDown;
/*     */   }
/*     */   
/*     */   protected boolean getMouseClicked() {
/* 227 */     boolean b = this.mouseClicked;
/* 228 */     saveClicked(false);
/* 229 */     return b;
/*     */   }
/*     */   
/*     */   protected boolean getMouseDragged() {
/* 233 */     return this.mouseDragged;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void saveXY(int x, int y) {
/* 240 */     this.mouseX = x;
/* 241 */     this.mouseY = y;
/* 242 */     Mouse.getInstance().saveXY(x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void saveDoubleClick(boolean b) {
/* 249 */     this.doubleClick = b;
/* 250 */     Mouse.getInstance().setDoubleClick(b);
/*     */   }
/*     */   
/*     */   private void saveDown(boolean b) {
/* 254 */     this.mouseDown = b;
/* 255 */     Mouse.getInstance().setPressed(b);
/*     */   }
/*     */   
/*     */   private void saveClicked(boolean b) {
/* 259 */     this.mouseClicked = b;
/* 260 */     Mouse.getInstance().setClicked(b);
/*     */   }
/*     */ 
/*     */   
/*     */   private void saveDragged(boolean b) {
/* 265 */     this.mouseDragged = b;
/* 266 */     Mouse.getInstance().setDragged(b);
/*     */   }
/*     */   
/*     */   protected class KeyReader
/*     */     extends KeyAdapter {
/*     */     public void keyPressed(KeyEvent e) {
/* 272 */       int code = e.getKeyCode();
/* 273 */       Scene.this.gedrueckt.add(Integer.valueOf(code));
/* 274 */       Keyboard.getInstance().handleKeyPressed();
/*     */     }
/*     */     
/*     */     public void keyReleased(KeyEvent e) {
/* 278 */       int code = e.getKeyCode();
/* 279 */       Scene.this.gedrueckt.remove(Integer.valueOf(code));
/*     */     }
/*     */     
/*     */     public void keyTyped(KeyEvent e) {
/* 283 */       Keyboard.getInstance().handleKeyTyped();
/* 284 */       Character code = Character.valueOf(e.getKeyChar());
/* 285 */       Scene.this.saveKey(code);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void saveKey(Character code) {
/* 291 */     if (code.charValue() == '\033') {
/* 292 */       System.exit(0);
/*     */     } else {
/* 294 */       this.keyBuffer.removeAllElements();
/* 295 */       this.keyBuffer.add(0, code);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Vector<Character> getKeyBuffer() {
/* 301 */     return this.keyBuffer;
/*     */   }
/*     */   
/*     */   public Vector<Character> getBuffer() {
/* 305 */     return this.keyBuffer;
/*     */   }
/*     */   
/*     */   public HashSet<Integer> getGedrueckt() {
/* 309 */     return this.gedrueckt;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\sas\Scene.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */