/*     */ package SgJavaLib.mars.gui;
/*     */ 
/*     */ import SgJavaLib.mars.model.HamsterScene;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseWheelEvent;
/*     */ import java.awt.event.MouseWheelListener;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.AbstractAction;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPopupMenu;
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
/*     */ public class FieldPanel
/*     */   extends JPanel
/*     */   implements MouseListener, MouseWheelListener
/*     */ {
/*     */   int row;
/*     */   int column;
/*     */   private Graphics combinedGraphic;
/*     */   BufferedImage picOne;
/*     */   BufferedImage picTwo;
/*     */   BufferedImage picThree;
/*     */   BufferedImage picFour;
/*     */   BufferedImage merged;
/*  46 */   JPopupMenu contextMenu = new JPopupMenu();
/*  47 */   JMenuItem hamsterMenuItem = new JMenuItem("MarsRover hier hin");
/*  48 */   JMenuItem wallMenuItem = new JMenuItem("Berg hin/weg");
/*  49 */   JMenuItem addCornMenuItem = new JMenuItem("Kristall hinzufügen");
/*  50 */   JMenuItem reomveCornMenuItem = new JMenuItem("Kristall entfernen");
/*     */   
/*     */   boolean wall = false;
/*     */   boolean hamster = false;
/*  54 */   int hamsterDirection = 0;
/*  55 */   int numberCorn = 0;
/*  56 */   int lineOfSight = 0;
/*     */   
/*     */   public FieldPanel(int pRow, int pColumn) {
/*  59 */     super(new BorderLayout());
/*  60 */     Dimension d = new Dimension(60, 60);
/*  61 */     setPreferredSize(d);
/*  62 */     setSize(d);
/*  63 */     setMinimumSize(d);
/*  64 */     setMaximumSize(d);
/*  65 */     this.row = pRow;
/*  66 */     this.column = pColumn;
/*  67 */     setBackground(Color.white);
/*  68 */     this.contextMenu.add(this.hamsterMenuItem);
/*  69 */     this.contextMenu.add(this.wallMenuItem);
/*  70 */     this.contextMenu.add(this.addCornMenuItem);
/*  71 */     this.contextMenu.add(this.reomveCornMenuItem);
/*  72 */     this.contextMenu.addMouseListener(this);
/*  73 */     final FieldPanel thisOne = this;
/*  74 */     addMouseWheelListener(this);
/*  75 */     this.hamsterMenuItem.addActionListener(new AbstractAction()
/*     */         {
/*     */           public void actionPerformed(ActionEvent e) {
/*  78 */             HamsterScene.getInstance().setHamsterPosition(FieldPanel.this.row, FieldPanel.this.column);
/*  79 */             FieldPanel.this.updateField(HamsterScene.getInstance().checkWallOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().checkHamsterOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getLineOfSight());
/*  80 */             HamsterScene.getInstance().setHamsterPositionInGui(thisOne);
/*  81 */             FieldPanel.this.updateGui();
/*     */           }
/*     */         });
/*     */     
/*  85 */     this.wallMenuItem.addActionListener(new AbstractAction() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  87 */             if (HamsterScene.getInstance().checkWallOnField(FieldPanel.this.row, FieldPanel.this.column)) {
/*  88 */               HamsterScene.getInstance().setWallOnField(FieldPanel.this.row, FieldPanel.this.column, false);
/*     */             } else {
/*  90 */               HamsterScene.getInstance().setWallOnField(FieldPanel.this.row, FieldPanel.this.column, true);
/*     */             } 
/*  92 */             FieldPanel.this.updateField(HamsterScene.getInstance().checkWallOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().checkHamsterOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getLineOfSight());
/*  93 */             FieldPanel.this.updateGui();
/*     */           }
/*     */         });
/*     */     
/*  97 */     this.addCornMenuItem.addActionListener(new AbstractAction() {
/*     */           public void actionPerformed(ActionEvent e) {
/*  99 */             HamsterScene.getInstance().addOneCornToField(FieldPanel.this.row, FieldPanel.this.column);
/* 100 */             FieldPanel.this.updateField(HamsterScene.getInstance().checkWallOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().checkHamsterOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getLineOfSight());
/* 101 */             FieldPanel.this.updateGui();
/*     */           }
/*     */         });
/*     */     
/* 105 */     this.addCornMenuItem.addActionListener(new AbstractAction() {
/*     */           public void actionPerformed(ActionEvent e) {
/* 107 */             HamsterScene.getInstance().removeOneCornFromField(FieldPanel.this.row, FieldPanel.this.column);
/* 108 */             FieldPanel.this.updateField(HamsterScene.getInstance().checkWallOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().checkHamsterOnField(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(FieldPanel.this.row, FieldPanel.this.column), HamsterScene.getInstance().getLineOfSight());
/* 109 */             FieldPanel.this.updateGui();
/*     */           }
/*     */         });
/*     */     
/* 113 */     addMouseListener(this);
/* 114 */     preparePainting();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void paintComponent(Graphics g) {
/* 119 */     super.paintComponent(g);
/* 120 */     g.drawImage(this.merged, 0, 0, null);
/*     */   }
/*     */   
/*     */   void updateField(boolean pWall, boolean pHamster, int pHamsterDirection, int pNumberCorn, int pLineOfSight) {
/* 124 */     this.wall = pWall;
/* 125 */     this.hamster = pHamster;
/* 126 */     this.hamsterDirection = pHamsterDirection;
/* 127 */     this.numberCorn = pNumberCorn;
/* 128 */     this.lineOfSight = pLineOfSight;
/* 129 */     updateGui();
/*     */   }
/*     */ 
/*     */   
/*     */   void preparePainting() {
/*     */     try {
/* 135 */       if (this.wall)
/*     */       {
/*     */         
/* 138 */         this.merged = ImageIO.read(getClass().getResource("/bilder60px/mauer.png"));
/*     */       
/*     */       }
/*     */       else
/*     */       {
/*     */         
/* 144 */         this.picOne = ImageIO.read(getClass().getResource("/bilder60px/kachel.jpg"));
/*     */         
/* 146 */         if (this.numberCorn > 0) {
/* 147 */           this.picTwo = ImageIO.read(getClass().getResource("/bilder60px/kristalle" + this.numberCorn + ".png"));
/*     */         }
/* 149 */         if (this.hamster) {
/* 150 */           this.picThree = ImageIO.read(getClass().getResource("/bilder60px/rocket" + this.hamsterDirection + ".png"));
/* 151 */           this.picFour = ImageIO.read(getClass().getResource("/bilder60px/radar" + this.lineOfSight + ".png"));
/*     */         } 
/*     */ 
/*     */         
/* 155 */         int w = this.picOne.getWidth();
/* 156 */         int h = this.picOne.getHeight();
/* 157 */         this.merged = new BufferedImage(w, h, 2);
/* 158 */         this.combinedGraphic = this.merged.getGraphics();
/*     */         
/* 160 */         this.combinedGraphic.drawImage(this.picOne, 0, 0, null);
/*     */         
/* 162 */         if (this.hamster) {
/*     */           
/* 164 */           this.combinedGraphic.drawImage(this.picFour, 0, 0, null);
/* 165 */           this.combinedGraphic.drawImage(this.picThree, 0, 0, null);
/*     */         } 
/* 167 */         if (this.numberCorn > 0) {
/* 168 */           this.combinedGraphic.drawImage(this.picTwo, 0, 0, null);
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 173 */     catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(MouseEvent e) {
/* 179 */     if (e.getButton() == 1) {
/* 180 */       if (HamsterScene.getInstance().checkWallOnField(this.row, this.column)) {
/* 181 */         HamsterScene.getInstance().setWallOnField(this.row, this.column, false);
/*     */       } else {
/* 183 */         HamsterScene.getInstance().setWallOnField(this.row, this.column, true);
/*     */       }
/*     */     
/* 186 */     } else if (e.getButton() == 3) {
/* 187 */       showMenu(e);
/*     */     }
/* 189 */     else if (e.getButton() == 2 && 
/* 190 */       HamsterScene.getInstance().getNumberOfCorns(this.row, this.column) < 6) {
/* 191 */       HamsterScene.getInstance().addOneCornToField(this.row, this.column);
/*     */     } 
/*     */     
/* 194 */     updateField(HamsterScene.getInstance().checkWallOnField(this.row, this.column), HamsterScene.getInstance().checkHamsterOnField(this.row, this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(this.row, this.column), HamsterScene.getInstance().getLineOfSight());
/* 195 */     updateGui();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mousePressed(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseReleased(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseExited(MouseEvent e) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void showMenu(MouseEvent e) {
/* 219 */     if (HamsterScene.getInstance().checkHamsterOnField(this.row, this.column)) {
/* 220 */       this.hamsterMenuItem.setEnabled(false);
/* 221 */       this.wallMenuItem.setEnabled(false);
/*     */     } else {
/* 223 */       this.hamsterMenuItem.setEnabled(true);
/*     */     } 
/* 225 */     if (HamsterScene.getInstance().checkWallOnField(this.row, this.column)) {
/* 226 */       this.wallMenuItem.setText("Berg entfernen");
/*     */     } else {
/* 228 */       this.wallMenuItem.setText("Berg einfügen");
/*     */     } 
/*     */     
/* 231 */     if (HamsterScene.getInstance().getNumberOfCorns(this.row, this.column) < 10) {
/* 232 */       this.addCornMenuItem.setText("Kristall hinzufügen");
/* 233 */       this.addCornMenuItem.setEnabled(true);
/*     */     } else {
/* 235 */       this.addCornMenuItem.setEnabled(false);
/*     */     } 
/*     */     
/* 238 */     if (HamsterScene.getInstance().getNumberOfCorns(this.row, this.column) > 0) {
/* 239 */       this.reomveCornMenuItem.setText("Kristall entfernen");
/* 240 */       this.reomveCornMenuItem.setEnabled(true);
/* 241 */       this.wallMenuItem.setEnabled(false);
/*     */     } else {
/* 243 */       this.reomveCornMenuItem.setEnabled(false);
/*     */     } 
/* 245 */     this.contextMenu.show(e.getComponent(), e.getX(), e.getY());
/* 246 */     this.contextMenu.setVisible(true);
/*     */   }
/*     */   
/*     */   public void setHamster(boolean b) {
/* 250 */     this.hamster = b;
/* 251 */     updateField(HamsterScene.getInstance().checkWallOnField(this.row, this.column), HamsterScene.getInstance().checkHamsterOnField(this.row, this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(this.row, this.column), HamsterScene.getInstance().getLineOfSight());
/* 252 */     updateGui();
/*     */   }
/*     */   
/*     */   public void updateGui() {
/* 256 */     preparePainting();
/* 257 */     repaint();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 261 */     return "Gui Field 2 String -> Row: " + this.row + " Col: " + this.column + " Hamster: " + this.hamster;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseWheelMoved(MouseWheelEvent e) {
/* 266 */     int movement = e.getWheelRotation();
/*     */     
/* 268 */     if (movement < 0) {
/* 269 */       if (HamsterScene.getInstance().getNumberOfCorns(this.row, this.column) < 6) {
/* 270 */         HamsterScene.getInstance().addOneCornToField(this.row, this.column);
/*     */       }
/*     */     }
/* 273 */     else if (HamsterScene.getInstance().getNumberOfCorns(this.row, this.column) > 0) {
/* 274 */       HamsterScene.getInstance().removeOneCornFromField(this.row, this.column);
/*     */     } 
/*     */ 
/*     */     
/* 278 */     updateField(HamsterScene.getInstance().checkWallOnField(this.row, this.column), HamsterScene.getInstance().checkHamsterOnField(this.row, this.column), HamsterScene.getInstance().getHamsterDirection(), HamsterScene.getInstance().getNumberOfCorns(this.row, this.column), HamsterScene.getInstance().getLineOfSight());
/* 279 */     updateGui();
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\gui\FieldPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */