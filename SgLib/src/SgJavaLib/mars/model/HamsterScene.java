/*     */ package SgJavaLib.mars.model;
/*     */ 
/*     */ import SgJavaLib.mars.gui.FieldPanel;
/*     */ import SgJavaLib.mars.gui.HamsterMainFrame;
/*     */ import SgJavaLib.mars.xml.XmlTool;
/*     */ import java.io.File;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HamsterScene
/*     */ {
/*     */   private static HamsterScene instance;
/*     */   HamsterWorld theWorld;
/*     */   HamsterModell theHamster;
/*     */   FieldPanel hamsterField;
/*     */   
/*     */   public void loadFrameWithRecentWorld() {
/*  22 */     HamsterMainFrame.getInstance().setVisible(true);
/*  23 */     tryToLoadRecentWorld();
/*     */   }
/*     */   
/*     */   public static HamsterScene getInstance() {
/*  27 */     if (instance == null) {
/*  28 */       instance = new HamsterScene();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  33 */     return instance;
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
/*     */   private HamsterScene() {
/*  46 */     this.theWorld = new HamsterWorld(12);
/*  47 */     this.theHamster = new HamsterModell();
/*     */   }
/*     */   
/*     */   public void buildStandardScene() {
/*  51 */     createEmptyScene();
/*  52 */     setHamsterStartPosition(0, 2);
/*  53 */     this.theWorld.setWall(0, 4, true);
/*  54 */     this.theWorld.setWall(0, 5, true);
/*     */   }
/*     */   
/*     */   public void createEmptyScene() {
/*  58 */     this.theWorld = new HamsterWorld(12);
/*  59 */     this.theHamster = new HamsterModell();
/*     */   }
/*     */   
/*     */   public void loadRecentWorld() {
/*  63 */     createEmptyScene();
/*  64 */     loadWorldFromXml("letzteWelt.xml", true);
/*     */   }
/*     */   
/*     */   public void loadExternalWorld(String pPathToWorld) {
/*  68 */     createEmptyScene();
/*  69 */     loadWorldFromXml(pPathToWorld, true);
/*     */   }
/*     */   
/*     */   public void loadBuildInWorld(String pWorldName) {
/*  73 */     createEmptyScene();
/*  74 */     loadWorldFromXml(pWorldName, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadWorldFromXml(String pPathToWorld, boolean pExternal) {
/*  79 */     XmlTool x = new XmlTool();
/*  80 */     if (x.loadWorldFromXmlFile(pPathToWorld, pExternal)) {
/*  81 */       while (x.hasUnloadedFields()) {
/*  82 */         HamsterField newField = x.getOneField();
/*  83 */         this.theWorld.replaceField(newField.getRowNumber(), newField.getColumnNumber(), newField);
/*  84 */         if (newField.containsHamster) {
/*  85 */           this.theHamster.setPosition(newField);
/*  86 */           this.theHamster.setPrePosition(newField);
/*  87 */           setHamsterStartPosition(newField.getRowNumber(), newField.getColumnNumber());
/*     */         } 
/*     */       } 
/*     */       
/*  91 */       x.unloadWorld();
/*     */     }
/*     */     else {
/*     */       
/*  95 */       buildStandardScene();
/*  96 */       HamsterMainFrame.getInstance().showTechnicalErrorMessage("Error bei loadFromXml, standard scene build");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public HamsterField[][] getFields() {
/* 102 */     return this.theWorld.getFields();
/*     */   }
/*     */   
/*     */   public boolean checkInFrontOfWorldEnd() {
/* 106 */     int y = this.theHamster.getPosition().getRowNumber();
/* 107 */     int x = this.theHamster.getPosition().getColumnNumber();
/*     */     
/* 109 */     if (this.theHamster.getDirection() == 0) {
/* 110 */       return (this.theWorld.getField(y, x + 1) == null);
/*     */     }
/* 112 */     if (this.theHamster.getDirection() == 180) {
/* 113 */       return (this.theWorld.getField(y, x - 1) == null);
/*     */     }
/* 115 */     if (this.theHamster.getDirection() == 270) {
/* 116 */       return (this.theWorld.getField(y + 1, x) == null);
/*     */     }
/* 118 */     if (this.theHamster.getDirection() == 90) {
/* 119 */       return (this.theWorld.getField(y - 1, x) == null);
/*     */     }
/*     */     
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean checkWallOnField(int pRow, int pColumn) {
/* 127 */     return this.theWorld.checkWallOnField(pRow, pColumn);
/*     */   }
/*     */   
/*     */   public void setWallOnField(int pRow, int pColumn, boolean pWall) {
/* 131 */     this.theWorld.setWall(pRow, pColumn, pWall);
/*     */   }
/*     */   
/*     */   public boolean checkFreeForForward() {
/* 135 */     int y = this.theHamster.getPosition().getRowNumber();
/* 136 */     int x = this.theHamster.getPosition().getColumnNumber();
/*     */     
/* 138 */     if (this.theHamster.getLineOfSight() == 0) {
/* 139 */       if (this.theWorld.getField(y, x + 1) != null) {
/* 140 */         if (!this.theWorld.getField(y, x + 1).isWallOnField()) {
/* 141 */           return true;
/*     */         }
/* 143 */         return false;
/*     */       } 
/*     */       
/* 146 */       return false;
/*     */     } 
/*     */     
/* 149 */     if (this.theHamster.getLineOfSight() == 180) {
/* 150 */       if (this.theWorld.getField(y, x - 1) != null) {
/* 151 */         if (!this.theWorld.getField(y, x - 1).isWallOnField()) {
/* 152 */           return true;
/*     */         }
/* 154 */         return false;
/*     */       } 
/*     */       
/* 157 */       return false;
/*     */     } 
/*     */     
/* 160 */     if (this.theHamster.getLineOfSight() == 270) {
/* 161 */       if (this.theWorld.getField(y + 1, x) != null) {
/* 162 */         if (!this.theWorld.getField(y + 1, x).isWallOnField()) {
/* 163 */           return true;
/*     */         }
/* 165 */         return false;
/*     */       } 
/*     */       
/* 168 */       return false;
/*     */     } 
/*     */     
/* 171 */     if (this.theHamster.getLineOfSight() == 90) {
/* 172 */       if (this.theWorld.getField(y - 1, x) != null) {
/* 173 */         if (!this.theWorld.getField(y - 1, x).isWallOnField()) {
/* 174 */           return true;
/*     */         }
/* 176 */         return false;
/*     */       } 
/*     */       
/* 179 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 183 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveHamsterForward() {
/* 192 */     int y = this.theHamster.getPosition().getRowNumber();
/* 193 */     int x = this.theHamster.getPosition().getColumnNumber();
/*     */     
/* 195 */     if (this.theHamster.getDirection() == 0) {
/* 196 */       if (this.theWorld.getField(y, x + 1) != null) {
/* 197 */         if (!this.theWorld.getField(y, x + 1).isWallOnField()) {
/* 198 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 199 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 200 */           this.theWorld.setHamsterPosition(y, x + 1, 0, this.theHamster.getLineOfSight());
/* 201 */           this.theHamster.setPosition(this.theWorld.getField(y, x + 1));
/* 202 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 204 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 207 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       }
/*     */     
/* 210 */     } else if (this.theHamster.getDirection() == 180) {
/* 211 */       if (this.theWorld.getField(y, x - 1) != null) {
/* 212 */         if (!this.theWorld.getField(y, x - 1).isWallOnField()) {
/* 213 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 214 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 215 */           this.theWorld.setHamsterPosition(y, x - 1, 180, this.theHamster.getLineOfSight());
/* 216 */           this.theHamster.setPosition(this.theWorld.getField(y, x - 1));
/* 217 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 219 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 222 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       }
/*     */     
/* 225 */     } else if (this.theHamster.getDirection() == 270) {
/* 226 */       if (this.theWorld.getField(y + 1, x) != null) {
/* 227 */         if (!this.theWorld.getField(y + 1, x).isWallOnField()) {
/* 228 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 229 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 230 */           this.theWorld.setHamsterPosition(y + 1, x, 270, this.theHamster.getLineOfSight());
/* 231 */           this.theHamster.setPosition(this.theWorld.getField(y + 1, x));
/* 232 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 234 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 237 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       }
/*     */     
/* 240 */     } else if (this.theHamster.getDirection() == 90) {
/*     */       
/* 242 */       if (this.theWorld.getField(y - 1, x) != null) {
/* 243 */         if (!this.theWorld.getField(y - 1, x).isWallOnField()) {
/* 244 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 245 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 246 */           this.theWorld.setHamsterPosition(y - 1, x, 90, this.theHamster.getLineOfSight());
/* 247 */           this.theHamster.setPosition(this.theWorld.getField(y - 1, x));
/* 248 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 250 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 253 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void turnHamsterLeft() {
/* 260 */     this.theHamster.turnLeft();
/*     */   }
/*     */   
/*     */   public boolean checkHamsterHasCorn() {
/* 264 */     return (this.theHamster.getCollectedCorns() == 0);
/*     */   }
/*     */   
/*     */   public boolean checkCornOnHamsterField() {
/* 268 */     return this.theHamster.getPosition().isCornOnField();
/*     */   }
/*     */   
/*     */   public void addCornFromHamsterToField() {
/* 272 */     if (this.theHamster.getPosition().getNumberOfCorns() < 6) {
/* 273 */       if (this.theHamster.getCollectedCorns() > 0) {
/* 274 */         this.theHamster.giveCorn();
/* 275 */         this.theHamster.getPosition().addOneCorn();
/*     */       } else {
/*     */         
/* 278 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Keine Kristalle zum Ablegen mehr vorhanden!");
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 283 */       HamsterMainFrame.getInstance().showErrorMsg("Fehler: Hier liegen bereits 6 Kristalle. Feld ist voll!");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void takeCornFromFieldToHamster() {
/* 289 */     if (this.theHamster.getPosition().isCornOnField()) {
/* 290 */       this.theHamster.takeCorn();
/* 291 */       this.theHamster.getPosition().removeOneCorn();
/*     */     } else {
/*     */       
/* 294 */       HamsterMainFrame.getInstance().showErrorMsg("Fehler: Kein Kristall zum Aufnehmen vorhanden!");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfCorns(int pRow, int pColumn) {
/* 300 */     return this.theWorld.getNumberOfCorns(pRow, pColumn);
/*     */   }
/*     */   
/*     */   public void addOneCornToField(int row, int column) {
/* 304 */     this.theWorld.setCornsOnField(row, column, this.theWorld.getNumberOfCorns(row, column) + 1);
/*     */   }
/*     */   
/*     */   public boolean checkHamsterOnField(int pRow, int pColumn) {
/* 308 */     return (this.theHamster.getPosition().getColumnNumber() == pColumn && this.theHamster.getPosition().getRowNumber() == pRow);
/*     */   }
/*     */   
/*     */   public int getHamsterDirection() {
/* 312 */     return this.theHamster.getDirection();
/*     */   }
/*     */   
/*     */   public void setHamsterStartPosition(int row, int column) {
/* 316 */     this.theHamster.setPosition(this.theWorld.getField(row, column));
/* 317 */     this.theHamster.setPrePosition(this.theWorld.getField(row, column));
/* 318 */     this.theWorld.setHamsterPosition(row, column, this.theHamster.getDirection(), this.theHamster.getLineOfSight());
/* 319 */     setHamsterStartField(HamsterMainFrame.getInstance().getField(row, column));
/*     */   }
/*     */   
/*     */   public void setHamsterPosition(int row, int column) {
/* 323 */     this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 324 */     if (this.hamsterField != null) {
/* 325 */       this.hamsterField.setHamster(false);
/*     */     }
/* 327 */     this.theWorld.setHamsterPosition(row, column, this.theHamster.getDirection(), this.theHamster.getLineOfSight());
/* 328 */     this.theHamster.setPosition(this.theWorld.getField(row, column));
/*     */   }
/*     */   
/*     */   public void removeOneCornFromField(int row, int column) {
/* 332 */     this.theWorld.setCornsOnField(row, column, this.theWorld.getNumberOfCorns(row, column) - 1);
/*     */   }
/*     */   
/*     */   public void setHamsterPositionInGui(FieldPanel pField) {
/* 336 */     this.theHamster.getPrePosition().setHamsterOnField(false);
/* 337 */     this.theHamster.getPrePosition().setHamsterDirection(-1);
/* 338 */     this.theHamster.getPrePosition().setLineOfSight(-1);
/*     */     
/* 340 */     this.hamsterField.setHamster(false);
/* 341 */     this.hamsterField.updateGui();
/*     */     
/* 343 */     this.hamsterField = pField;
/* 344 */     this.hamsterField.setHamster(true);
/* 345 */     this.hamsterField.updateGui();
/*     */   }
/*     */   
/*     */   public void setHamsterStartField(FieldPanel field) {
/* 349 */     this.hamsterField = field;
/* 350 */     this.hamsterField.setHamster(true);
/*     */   }
/*     */   
/*     */   public int getLineOfSight() {
/* 354 */     return this.theHamster.getLineOfSight();
/*     */   }
/*     */   
/*     */   public void moveRadarLeft() {
/* 358 */     this.theHamster.turnLineOfSightLeft();
/*     */   }
/*     */   
/*     */   public HamsterField getHamsterField() {
/* 362 */     return this.theHamster.getPosition();
/*     */   }
/*     */   
/*     */   public HamsterField getPreHamsterField() {
/* 366 */     return this.theHamster.getPrePosition();
/*     */   }
/*     */   
/*     */   public void resetRadarToDirection() {
/* 370 */     this.theHamster.moveRadarToDirection();
/*     */   }
/*     */   
/*     */   public void resetRadarToGround() {
/* 374 */     this.theHamster.moveRadarToGround();
/*     */   }
/*     */   
/*     */   public void saveWorldToExternalFile(String absolutePath) {
/* 378 */     XmlTool x = new XmlTool();
/* 379 */     if (!x.saveCurrentWorldToExternalFile(absolutePath, getFields()))
/*     */     {
/*     */       
/* 382 */       HamsterMainFrame.getInstance().showTechnicalErrorMessage("Error bei saveWorldToExternalFile");
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveWorldToRecentFile() {
/* 387 */     XmlTool x = new XmlTool();
/* 388 */     x.saveCurrentWorld(getFields());
/*     */   }
/*     */   
/*     */   public void moveRadarRight() {
/* 392 */     this.theHamster.turnLineOfSightRight();
/*     */   }
/*     */   
/*     */   public void turnHamsterRight() {
/* 396 */     this.theHamster.turnRight();
/*     */   }
/*     */ 
/*     */   
/*     */   public void moveHamsterBackwards() {
/* 401 */     int y = this.theHamster.getPosition().getRowNumber();
/* 402 */     int x = this.theHamster.getPosition().getColumnNumber();
/*     */     
/* 404 */     if (this.theHamster.getDirection() == 0) {
/* 405 */       if (this.theWorld.getField(y, x - 1) != null) {
/* 406 */         if (!this.theWorld.getField(y, x - 1).isWallOnField()) {
/* 407 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 408 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 409 */           this.theWorld.setHamsterPosition(y, x - 1, 0, this.theHamster.getLineOfSight());
/* 410 */           this.theHamster.setPosition(this.theWorld.getField(y, x - 1));
/* 411 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 413 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 416 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       }
/*     */     
/* 419 */     } else if (this.theHamster.getDirection() == 180) {
/* 420 */       if (this.theWorld.getField(y, x + 1) != null) {
/* 421 */         if (!this.theWorld.getField(y, x + 1).isWallOnField()) {
/* 422 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 423 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 424 */           this.theWorld.setHamsterPosition(y, x + 1, 180, this.theHamster.getLineOfSight());
/* 425 */           this.theHamster.setPosition(this.theWorld.getField(y, x + 1));
/* 426 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 428 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 431 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       }
/*     */     
/* 434 */     } else if (this.theHamster.getDirection() == 270) {
/* 435 */       if (this.theWorld.getField(y - 1, x) != null) {
/* 436 */         if (!this.theWorld.getField(y - 1, x).isWallOnField()) {
/* 437 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 438 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 439 */           this.theWorld.setHamsterPosition(y - 1, x, 270, this.theHamster.getLineOfSight());
/* 440 */           this.theHamster.setPosition(this.theWorld.getField(y - 1, x));
/* 441 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 443 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 446 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       }
/*     */     
/* 449 */     } else if (this.theHamster.getDirection() == 90) {
/*     */       
/* 451 */       if (this.theWorld.getField(y + 1, x) != null) {
/* 452 */         if (!this.theWorld.getField(y + 1, x).isWallOnField()) {
/* 453 */           this.theHamster.setPrePosition(this.theHamster.getPosition());
/* 454 */           this.theWorld.getField(y, x).setHamsterOnField(false);
/* 455 */           this.theWorld.setHamsterPosition(y + 1, x, 90, this.theHamster.getLineOfSight());
/* 456 */           this.theHamster.setPosition(this.theWorld.getField(y + 1, x));
/* 457 */           setHamsterPositionInGui(HamsterMainFrame.getInstance().getField(this.theHamster.getPosition().getRowNumber(), this.theHamster.getPosition().getColumnNumber()));
/*     */         } else {
/* 459 */           HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor die Wand gelaufen!");
/*     */         } 
/*     */       } else {
/* 462 */         HamsterMainFrame.getInstance().showErrorMsg("Fehler: Bin vor das Ende der Welt gelaufen!");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateHamsterField() {
/* 469 */     HamsterField position = getHamsterField();
/*     */     
/* 471 */     HamsterMainFrame.getInstance().updateField(position.getRowNumber(), position.getColumnNumber(), position);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updatePreHamsterField() {
/* 476 */     HamsterField position = getPreHamsterField();
/* 477 */     if (position != null) {
/* 478 */       HamsterMainFrame.getInstance().updateField(position.getRowNumber(), position.getColumnNumber(), position);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void tryToLoadRecentWorld() {
/* 484 */     File f = new File("letzteWelt.xml");
/* 485 */     if (f.exists() && f.canRead()) {
/* 486 */       getInstance().loadWorldFromXml(f.getAbsolutePath(), true);
/* 487 */       HamsterMainFrame.getInstance().updateHamsterWorld();
/*     */     } else {
/* 489 */       getInstance().loadBuildInWorld("Welt-01");
/* 490 */       HamsterMainFrame.getInstance().updateHamsterWorld();
/* 491 */       getInstance().saveWorldToRecentFile();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\model\HamsterScene.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */