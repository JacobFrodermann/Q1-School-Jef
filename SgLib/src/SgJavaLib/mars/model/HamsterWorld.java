/*    */ package SgJavaLib.mars.model;
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
/*    */ public class HamsterWorld
/*    */ {
/*    */   private final HamsterField[][] fields;
/* 15 */   private static int size = 12;
/*    */   
/*    */   public static int getSize() {
/* 18 */     return size;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HamsterWorld(int pSize) {
/* 25 */     size = pSize;
/* 26 */     this.fields = new HamsterField[size][size];
/* 27 */     for (int r = 0; r < this.fields.length; r++) {
/* 28 */       for (int c = 0; c < (this.fields[0]).length; c++) {
/* 29 */         this.fields[r][c] = new HamsterField(r, c);
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
/*    */   public void setHamsterPosition(int pRow, int pColumn, int pDirection, int pLineOfSight) {
/* 42 */     if (pRow < size && pRow >= 0 && pColumn < size && pColumn >= 0) {
/* 43 */       this.fields[pRow][pColumn].setHamsterOnField(true);
/* 44 */       this.fields[pRow][pColumn].setHamsterDirection(pDirection);
/* 45 */       this.fields[pRow][pColumn].setLineOfSight(pLineOfSight);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWall(int pRow, int pColumn, boolean pWall) {
/* 51 */     if (pRow < size && pRow >= 0 && pColumn < size && pColumn >= 0) {
/* 52 */       this.fields[pRow][pColumn].setWallOnField(pWall);
/*    */     }
/*    */   }
/*    */   
/*    */   public void setCornsOnField(int pRow, int pColumn, int pNumberOfCorns) {
/* 57 */     if (pRow < size && pRow >= 0 && pColumn < size && pColumn >= 0 && pNumberOfCorns <= 6 && pNumberOfCorns >= 0) {
/* 58 */       this.fields[pRow][pColumn].setNumberOfCorns(pNumberOfCorns);
/*    */     }
/*    */   }
/*    */   
/*    */   HamsterField getField(int pRow, int pColumn) {
/* 63 */     if (pRow < size && pRow >= 0 && pColumn < size && pColumn >= 0) {
/* 64 */       return this.fields[pRow][pColumn];
/*    */     }
/*    */     
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   HamsterField[][] getFields() {
/* 73 */     return this.fields;
/*    */   }
/*    */   
/*    */   boolean checkWallOnField(int pRow, int pColumn) {
/* 77 */     return this.fields[pRow][pColumn].isWallOnField();
/*    */   }
/*    */   
/*    */   int getNumberOfCorns(int pRow, int pColumn) {
/* 81 */     return this.fields[pRow][pColumn].getNumberOfCorns();
/*    */   }
/*    */   
/*    */   void replaceField(int pRow, int pColumn, HamsterField pField) {
/* 85 */     this.fields[pRow][pColumn] = pField;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\model\HamsterWorld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */