/*    */ package SgJavaLib.datenstrukturen;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Edge
/*    */ {
/*    */   private Vertex[] vertices;
/*    */   private double weight;
/*    */   private boolean mark;
/*    */   
/*    */   public Edge(Vertex pVertex, Vertex pAnotherVertex, double pWeight) {
/* 31 */     this.vertices = new Vertex[2];
/* 32 */     this.vertices[0] = pVertex;
/* 33 */     this.vertices[1] = pAnotherVertex;
/* 34 */     this.weight = pWeight;
/* 35 */     this.mark = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Vertex[] getVertices() {
/* 43 */     Vertex[] result = new Vertex[2];
/* 44 */     result[0] = this.vertices[0];
/* 45 */     result[1] = this.vertices[1];
/* 46 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setWeight(double pWeight) {
/* 53 */     this.weight = pWeight;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double getWeight() {
/* 60 */     return this.weight;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMark(boolean pMark) {
/* 67 */     this.mark = pMark;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isMarked() {
/* 74 */     return this.mark;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\Edge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */