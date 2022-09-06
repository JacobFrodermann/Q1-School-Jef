/*     */ package SgJavaLib.mars.model;
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
/*     */ public class HamsterField
/*     */ {
/*     */   boolean containsWall;
/*     */   boolean containsCorn;
/*     */   boolean containsHamster;
/*     */   int numberOfCorns;
/*     */   int rowNumber;
/*     */   int columnNumber;
/*     */   int hamsterDirection;
/*     */   int lineOfSight;
/*     */   
/*     */   public HamsterField(int pRow, int pColumn) {
/*  24 */     this.containsWall = false;
/*  25 */     this.containsHamster = false;
/*  26 */     this.numberOfCorns = 0;
/*  27 */     this.rowNumber = pRow;
/*  28 */     this.columnNumber = pColumn;
/*  29 */     this.hamsterDirection = -1;
/*  30 */     this.lineOfSight = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWallOnField() {
/*  37 */     return this.containsWall;
/*     */   }
/*     */   
/*     */   public boolean isCornOnField() {
/*  41 */     return (this.numberOfCorns > 0);
/*     */   }
/*     */   
/*     */   public boolean isHamsterOnField() {
/*  45 */     return this.containsHamster;
/*     */   }
/*     */   
/*     */   public void setWallOnField(boolean pSetThere) {
/*  49 */     this.containsWall = pSetThere;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHamsterOnField(boolean pSetThere) {
/*  54 */     this.containsHamster = pSetThere;
/*     */   }
/*     */   
/*     */   public int getNumberOfCorns() {
/*  58 */     return this.numberOfCorns;
/*     */   }
/*     */   
/*     */   public int getHamsterDirection() {
/*  62 */     return this.hamsterDirection;
/*     */   }
/*     */   
/*     */   public void setNumberOfCorns(int pNumber) {
/*  66 */     if (pNumber <= 6 && pNumber >= 0) {
/*  67 */       this.numberOfCorns = pNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setHamsterDirection(int pDirection) {
/*  72 */     if (pDirection == 0 || pDirection == 90 || pDirection == 180 || pDirection == 270) {
/*  73 */       this.hamsterDirection = pDirection;
/*     */     }
/*     */   }
/*     */   
/*     */   public void addOneCorn() {
/*  78 */     if (this.numberOfCorns <= 5 && this.numberOfCorns >= 0) {
/*  79 */       this.numberOfCorns++;
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeOneCorn() {
/*  84 */     if (this.numberOfCorns <= 6 && this.numberOfCorns >= 1) {
/*  85 */       this.numberOfCorns--;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowNumber() {
/*  92 */     return this.rowNumber;
/*     */   }
/*     */   
/*     */   public int getColumnNumber() {
/*  96 */     return this.columnNumber;
/*     */   }
/*     */   
/*     */   public void setLineOfSight(int pLineOfSight) {
/* 100 */     if (pLineOfSight == 0 || pLineOfSight == 90 || pLineOfSight == 180 || pLineOfSight == 270) {
/* 101 */       this.lineOfSight = pLineOfSight;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineOfSight() {
/* 108 */     return this.lineOfSight;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 112 */     return "HamsterFied: Zeile " + this.rowNumber + " Spalte " + this.columnNumber + " Hamster da = " + this.containsHamster;
/*     */   }
/*     */   
/*     */   public boolean isValidField() {
/* 116 */     if (this.lineOfSight != 0 && this.lineOfSight != 90 && this.lineOfSight != 180 && this.lineOfSight != 270 && this.lineOfSight != -1) {
/* 117 */       return false;
/*     */     }
/* 119 */     if (this.hamsterDirection != 0 && this.hamsterDirection != 90 && this.hamsterDirection != 180 && this.hamsterDirection != 270 && this.hamsterDirection != -1) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this.numberOfCorns < 0 || this.numberOfCorns > 6) {
/* 123 */       return false;
/*     */     }
/* 125 */     if (this.containsWall == true && this.containsHamster == true) {
/* 126 */       return false;
/*     */     }
/* 128 */     if (this.rowNumber < 0 || this.columnNumber < 0 || this.rowNumber >= HamsterWorld.getSize() || this.columnNumber >= HamsterWorld.getSize()) {
/* 129 */       return false;
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\model\HamsterField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */