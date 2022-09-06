/*     */ package SgJavaLib.mars;
/*     */ 
/*     */ import SgJavaLib.mars.gui.HamsterMainFrame;
/*     */ import SgJavaLib.mars.model.HamsterField;
/*     */ import SgJavaLib.mars.model.HamsterScene;
/*     */ import java.awt.Component;
/*     */ import java.io.File;
/*     */ import java.util.Random;
/*     */ import javax.swing.JOptionPane;
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
/*     */ public class HamsterSave
/*     */ {
/*     */   HamsterMainFrame frame;
/*     */   HamsterScene scene;
/*     */   public Radar meinRadar;
/*     */   public Antrieb meinAntrieb;
/*     */   public Schleuse meineSchleuse;
/*     */   public BoardComputer meinBoardComputer;
/*     */   
/*     */   public static void showErrorMsg(String pMessage) {
/*  31 */     JOptionPane.showMessageDialog((Component)HamsterMainFrame.getInstance(), pMessage, "Fehler!", 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HamsterSave() {
/*  37 */     this.frame = HamsterMainFrame.getInstance();
/*  38 */     this.frame.setVisible(true);
/*     */     
/*  40 */     this.scene = HamsterScene.getInstance();
/*  41 */     this.meinAntrieb = new Antrieb();
/*  42 */     this.meinRadar = new Radar();
/*  43 */     this.meineSchleuse = new Schleuse();
/*  44 */     this.meinBoardComputer = new BoardComputer();
/*     */     
/*  46 */     tryToLoadRecentWorld();
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateHamsterField() {
/*  51 */     HamsterField position = this.scene.getHamsterField();
/*     */     
/*  53 */     this.frame.updateField(position.getRowNumber(), position.getColumnNumber(), position);
/*     */   }
/*     */ 
/*     */   
/*     */   private void updatePreHamsterField() {
/*  58 */     HamsterField position = this.scene.getPreHamsterField();
/*  59 */     if (position != null) {
/*  60 */       this.frame.updateField(position.getRowNumber(), position.getColumnNumber(), position);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void tryToLoadRecentWorld() {
/*  66 */     File f = new File("letzteWelt.xml");
/*  67 */     if (f.exists() && f.canRead()) {
/*  68 */       HamsterScene.getInstance().loadWorldFromXml(f.getAbsolutePath(), true);
/*  69 */       HamsterMainFrame.getInstance().updateHamsterWorld();
/*     */     } else {
/*  71 */       HamsterScene.getInstance().loadBuildInWorld("Welt-01");
/*  72 */       HamsterMainFrame.getInstance().updateHamsterWorld();
/*  73 */       HamsterScene.getInstance().saveWorldToRecentFile();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Radar
/*     */   {
/*     */     public void zurFahrtrichtung() {
/*  84 */       HamsterSave.this.scene.resetRadarToDirection();
/*  85 */       HamsterSave.this.updateHamsterField();
/*  86 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public void nachLinksDrehen() {
/*  90 */       HamsterSave.this.scene.moveRadarLeft();
/*  91 */       HamsterSave.this.updateHamsterField();
/*  92 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public void nachRechtsDrehen() {
/*  96 */       HamsterSave.this.scene.moveRadarRight();
/*  97 */       HamsterSave.this.updateHamsterField();
/*  98 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public boolean inRadarrichtungFrei() {
/* 102 */       return HamsterSave.this.scene.checkFreeForForward();
/*     */     }
/*     */     
/*     */     public boolean kristallAufBoden() {
/* 106 */       return HamsterSave.this.scene.checkCornOnHamsterField();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class Antrieb
/*     */   {
/* 116 */     SpeedManager speed = SpeedManager.getInstance();
/*     */ 
/*     */     
/*     */     public void vorwärts() {
/* 120 */       HamsterSave.this.scene.moveHamsterForward();
/* 121 */       HamsterSave.this.updateHamsterField();
/* 122 */       HamsterSave.this.updatePreHamsterField();
/*     */       
/* 124 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */ 
/*     */     
/*     */     public void nachLinksDrehen() {
/* 129 */       HamsterSave.this.scene.turnHamsterLeft();
/* 130 */       HamsterSave.this.updateHamsterField();
/* 131 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public void nachRechtsDrehen() {
/* 135 */       HamsterSave.this.scene.turnHamsterRight();
/* 136 */       HamsterSave.this.updateHamsterField();
/* 137 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */ 
/*     */     
/*     */     public void rückwärts() {
/* 142 */       HamsterSave.this.scene.moveHamsterBackwards();
/* 143 */       HamsterSave.this.updateHamsterField();
/* 144 */       HamsterSave.this.updatePreHamsterField();
/* 145 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public void setGeschwindigkeit(int pWert) {
/* 149 */       SpeedManager.setSpeed(pWert);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class BoardComputer
/*     */   {
/* 158 */     private Random rand = new Random();
/*     */ 
/*     */     
/*     */     public void sendeNachricht(String pNachricht) {
/* 162 */       JOptionPane.showMessageDialog((Component)HamsterMainFrame.getInstance(), pNachricht, "Hamster an Benutzer:", 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public int gibZufallszahl(int pVon, int pBis) {
/* 167 */       int randomNum = this.rand.nextInt(pBis - pVon + 1) + pVon;
/*     */       
/* 169 */       return randomNum;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class Schleuse
/*     */   {
/*     */     public void einKristallAufnehmen() {
/* 179 */       HamsterSave.this.scene.takeCornFromFieldToHamster();
/* 180 */       HamsterSave.this.updateHamsterField();
/* 181 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public void einKristallAbgeben() {
/* 185 */       HamsterSave.this.scene.addCornFromHamsterToField();
/* 186 */       HamsterSave.this.updateHamsterField();
/* 187 */       SpeedManager.sleepForSpeedAdjustment();
/*     */     }
/*     */     
/*     */     public boolean keineKristalleImLager() {
/* 191 */       return HamsterSave.this.scene.checkHamsterHasCorn();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\HamsterSave.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */