/*     */ package SgJavaLib.mars.model;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HamsterModell
/*     */ {
/*     */   private int collectedCorns;
/*     */   private HamsterField myPosition;
/*     */   private HamsterField myPrePosition;
/*     */   private int direction;
/*     */   private int lineOfSight;
/*     */   
/*     */   public int getLineOfSight() {
/*  19 */     return this.lineOfSight;
/*     */   }
/*     */   
/*     */   public void turnLineOfSightLeft() {
/*  23 */     this.lineOfSight = (this.lineOfSight + 90) % 360;
/*  24 */     this.myPosition.setLineOfSight(this.lineOfSight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HamsterModell() {
/*  32 */     this.collectedCorns = 10;
/*  33 */     this.direction = 0;
/*  34 */     this.lineOfSight = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCollectedCorns() {
/*  41 */     return this.collectedCorns;
/*     */   }
/*     */   
/*     */   public void setCollectedCorns(int pCorns) {
/*  45 */     this.collectedCorns = pCorns;
/*     */   }
/*     */   
/*     */   public void takeCorn() {
/*  49 */     this.collectedCorns++;
/*     */   }
/*     */   
/*     */   public void giveCorn() {
/*  53 */     if (this.collectedCorns > 0) {
/*  54 */       this.collectedCorns--;
/*     */     }
/*     */   }
/*     */   
/*     */   public HamsterField getPosition() {
/*  59 */     return this.myPosition;
/*     */   }
/*     */   
/*     */   public void setPosition(HamsterField pPosition) {
/*  63 */     this.myPosition = pPosition;
/*     */   }
/*     */   
/*     */   public HamsterField getPrePosition() {
/*  67 */     return this.myPrePosition;
/*     */   }
/*     */   
/*     */   public void setPrePosition(HamsterField pPosition) {
/*  71 */     this.myPrePosition = pPosition;
/*     */   }
/*     */   
/*     */   void turnLeft() {
/*  75 */     this.direction = (this.direction + 90) % 360;
/*  76 */     this.myPosition.setHamsterDirection(this.direction);
/*     */   }
/*     */   
/*     */   void turnRight() {
/*  80 */     this.direction = (this.direction + 90 + 180) % 360;
/*  81 */     this.myPosition.setHamsterDirection(this.direction);
/*     */   }
/*     */   
/*     */   int getDirection() {
/*  85 */     return this.direction;
/*     */   }
/*     */   
/*     */   public void moveRadarToDirection() {
/*  89 */     this.lineOfSight = this.direction;
/*  90 */     this.myPosition.setLineOfSight(this.lineOfSight);
/*     */   }
/*     */   
/*     */   void moveRadarToGround() {
/*  94 */     this.lineOfSight = 270;
/*  95 */     this.myPosition.setLineOfSight(this.lineOfSight);
/*     */   }
/*     */   
/*     */   void turnLineOfSightRight() {
/*  99 */     this.lineOfSight = (this.lineOfSight + 90 + 180) % 360;
/* 100 */     this.myPosition.setLineOfSight(this.lineOfSight);
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\model\HamsterModell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */