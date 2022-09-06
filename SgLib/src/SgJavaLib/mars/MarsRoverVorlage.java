/*    */ package SgJavaLib.mars;
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
/*    */ public class MarsRoverVorlage
/*    */ {
/*    */   public MarsRoverVorlage() {
/* 15 */     meinBoardComputer.initSystem();
/*    */   }
/*    */   
/*    */   public void sag(String pNachricht) {
/* 19 */     meinBoardComputer.sendeNachricht(pNachricht);
/*    */   }
/*    */ 
/*    */   
/*    */   public void vor() {
/* 24 */     meinAntrieb.vorwärts();
/*    */   }
/*    */   
/*    */   public void zurück() {
/* 28 */     meinAntrieb.rückwärts();
/*    */   }
/*    */   
/*    */   public void linksUm() {
/* 32 */     meinAntrieb.nachLinksDrehen();
/*    */   }
/*    */   
/*    */   public void rechtsUm() {
/* 36 */     meinAntrieb.nachRechtsDrehen();
/*    */   }
/*    */   
/*    */   public boolean vornFrei() {
/* 40 */     meinRadar.zurFahrtrichtung();
/* 41 */     return meinRadar.inRadarrichtungFrei();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean kristalleLeer() {
/* 46 */     return meineSchleuse.keineKristalleImLager();
/*    */   }
/*    */   
/*    */   public void gib() {
/* 50 */     meineSchleuse.einKristallAbgeben();
/*    */   }
/*    */   
/*    */   public void nimm() {
/* 54 */     meineSchleuse.einKristallAufnehmen();
/*    */   }
/*    */   
/*    */   public boolean kristallDa() {
/* 58 */     return meinRadar.kristallAufBoden();
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\MarsRoverVorlage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */