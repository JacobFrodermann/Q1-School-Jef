/*    */ package SgJavaLib.mars.gui;
/*    */ 
/*    */ import SgJavaLib.mars.model.HamsterField;
/*    */ import SgJavaLib.mars.model.HamsterWorld;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.GridLayout;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.JPanel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HamsterPlayground
/*    */   extends JPanel
/*    */ {
/* 28 */   Dimension boardSize = new Dimension(HamsterWorld.getSize() * 60, HamsterWorld.getSize() * 60);
/*    */   
/*    */   FieldPanel startPosition;
/*    */   
/* 32 */   FieldPanel[][] guiFields = new FieldPanel[HamsterWorld.getSize()][HamsterWorld.getSize()];
/*    */   int xAdjustment;
/*    */   int yAdjustment;
/*    */   
/*    */   public HamsterPlayground() {
/* 37 */     setPreferredSize(this.boardSize);
/*    */     
/* 39 */     setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
/* 40 */     GridLayout grid = new GridLayout(12, 12);
/* 41 */     grid.setHgap(0);
/* 42 */     grid.setVgap(0);
/* 43 */     setLayout(grid);
/* 44 */     setPreferredSize(this.boardSize);
/* 45 */     setSize(this.boardSize);
/* 46 */     setMinimumSize(this.boardSize);
/* 47 */     setMaximumSize(this.boardSize);
/* 48 */     setBounds(0, 0, this.boardSize.width, this.boardSize.height);
/*    */ 
/*    */ 
/*    */     
/* 52 */     for (int r = 0; r < HamsterWorld.getSize(); r++) {
/* 53 */       for (int c = 0; c < HamsterWorld.getSize(); c++) {
/* 54 */         FieldPanel fp = new FieldPanel(r, c);
/* 55 */         this.guiFields[r][c] = fp;
/* 56 */         add(fp);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void updateField(int pRow, int pColumn, HamsterField pHamsterField) {
/* 70 */     this.guiFields[pRow][pColumn].updateField(pHamsterField.isWallOnField(), pHamsterField.isHamsterOnField(), pHamsterField.getHamsterDirection(), pHamsterField.getNumberOfCorns(), pHamsterField.getLineOfSight());
/*    */   }
/*    */ 
/*    */   
/*    */   FieldPanel getField(int pRow, int pColumn) {
/* 75 */     return this.guiFields[pRow][pColumn];
/*    */   }
/*    */   
/*    */   Dimension getBoardSize() {
/* 79 */     return this.boardSize;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\gui\HamsterPlayground.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */