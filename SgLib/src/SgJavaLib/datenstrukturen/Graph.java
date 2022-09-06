/*     */ package SgJavaLib.datenstrukturen;
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
/*     */ public class Graph
/*     */ {
/*  32 */   private List<Vertex> vertices = new List<>();
/*  33 */   private List<Edge> edges = new List<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Vertex> getVertices() {
/*  41 */     List<Vertex> result = new List<>();
/*  42 */     this.vertices.toFirst();
/*  43 */     while (this.vertices.hasAccess()) {
/*  44 */       result.append(this.vertices.getContent());
/*  45 */       this.vertices.next();
/*     */     } 
/*     */     
/*  48 */     result.toFirst();
/*     */     
/*  50 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Edge> getEdges() {
/*  58 */     List<Edge> result = new List<>();
/*  59 */     this.edges.toFirst();
/*  60 */     while (this.edges.hasAccess()) {
/*  61 */       result.append(this.edges.getContent());
/*  62 */       this.edges.next();
/*     */     } 
/*     */     
/*  65 */     result.toFirst();
/*     */     
/*  67 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Vertex getVertex(String pID) {
/*  76 */     Vertex result = null;
/*  77 */     this.vertices.toFirst();
/*  78 */     while (this.vertices.hasAccess() && result == null) {
/*  79 */       if (((Vertex)this.vertices.getContent()).getID().equals(pID)) {
/*  80 */         result = this.vertices.getContent();
/*     */       }
/*  82 */       this.vertices.next();
/*     */     } 
/*     */ 
/*     */     
/*  86 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addVertex(Vertex pVertex) {
/*  96 */     if (pVertex != null && pVertex.getID() != null) {
/*     */       
/*  98 */       boolean freeID = true;
/*  99 */       this.vertices.toFirst();
/* 100 */       while (this.vertices.hasAccess() && freeID) {
/* 101 */         if (((Vertex)this.vertices.getContent()).getID().equals(pVertex.getID())) {
/* 102 */           freeID = false;
/*     */         }
/* 104 */         this.vertices.next();
/*     */       } 
/*     */ 
/*     */       
/* 108 */       if (freeID) {
/* 109 */         this.vertices.append(pVertex);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEdge(Edge pEdge) {
/* 120 */     if (pEdge != null) {
/* 121 */       Vertex[] vertexPair = pEdge.getVertices();
/*     */ 
/*     */       
/* 124 */       if (vertexPair[0] != null && vertexPair[1] != null && 
/* 125 */         getVertex(vertexPair[0].getID()) == vertexPair[0] && 
/* 126 */         getVertex(vertexPair[1].getID()) == vertexPair[1] && 
/* 127 */         getEdge(vertexPair[0], vertexPair[1]) == null && vertexPair[0] != vertexPair[1])
/*     */       {
/*     */         
/* 130 */         this.edges.append(pEdge);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeVertex(Vertex pVertex) {
/* 141 */     this.edges.toFirst();
/* 142 */     while (this.edges.hasAccess()) {
/* 143 */       Vertex[] akt = ((Edge)this.edges.getContent()).getVertices();
/* 144 */       if (akt[0] == pVertex || akt[1] == pVertex) {
/* 145 */         this.edges.remove(); continue;
/*     */       } 
/* 147 */       this.edges.next();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 152 */     this.vertices.toFirst();
/* 153 */     while (this.vertices.hasAccess() && this.vertices.getContent() != pVertex) {
/* 154 */       this.vertices.next();
/*     */     }
/* 156 */     if (this.vertices.hasAccess()) {
/* 157 */       this.vertices.remove();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeEdge(Edge pEdge) {
/* 167 */     this.edges.toFirst();
/* 168 */     while (this.edges.hasAccess()) {
/* 169 */       if (this.edges.getContent() == pEdge) {
/* 170 */         this.edges.remove(); continue;
/*     */       } 
/* 172 */       this.edges.next();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllVertexMarks(boolean pMark) {
/* 181 */     this.vertices.toFirst();
/* 182 */     while (this.vertices.hasAccess()) {
/* 183 */       ((Vertex)this.vertices.getContent()).setMark(pMark);
/* 184 */       this.vertices.next();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllEdgeMarks(boolean pMark) {
/* 192 */     this.edges.toFirst();
/* 193 */     while (this.edges.hasAccess()) {
/* 194 */       ((Edge)this.edges.getContent()).setMark(pMark);
/* 195 */       this.edges.next();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean allVerticesMarked() {
/* 203 */     boolean result = true;
/* 204 */     this.vertices.toFirst();
/* 205 */     while (this.vertices.hasAccess()) {
/* 206 */       if (!((Vertex)this.vertices.getContent()).isMarked()) {
/* 207 */         result = false;
/*     */       }
/* 209 */       this.vertices.next();
/*     */     } 
/* 211 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean allEdgesMarked() {
/* 218 */     boolean result = true;
/* 219 */     this.edges.toFirst();
/* 220 */     while (this.edges.hasAccess()) {
/* 221 */       if (!((Edge)this.edges.getContent()).isMarked()) {
/* 222 */         result = false;
/*     */       }
/* 224 */       this.edges.next();
/*     */     } 
/* 226 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Vertex> getNeighbours(Vertex pVertex) {
/* 235 */     List<Vertex> result = new List<>();
/*     */ 
/*     */     
/* 238 */     this.edges.toFirst();
/* 239 */     while (this.edges.hasAccess()) {
/*     */ 
/*     */       
/* 242 */       Vertex[] vertexPair = ((Edge)this.edges.getContent()).getVertices();
/* 243 */       if (vertexPair[0] == pVertex) {
/* 244 */         result.append(vertexPair[1]);
/*     */       }
/* 246 */       else if (vertexPair[1] == pVertex) {
/* 247 */         result.append(vertexPair[0]);
/*     */       } 
/*     */       
/* 250 */       this.edges.next();
/*     */     } 
/* 252 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Edge> getEdges(Vertex pVertex) {
/* 261 */     List<Edge> result = new List<>();
/*     */ 
/*     */     
/* 264 */     this.edges.toFirst();
/* 265 */     while (this.edges.hasAccess()) {
/*     */ 
/*     */       
/* 268 */       Vertex[] vertexPair = ((Edge)this.edges.getContent()).getVertices();
/* 269 */       if (vertexPair[0] == pVertex) {
/* 270 */         result.append(this.edges.getContent());
/*     */       }
/* 272 */       else if (vertexPair[1] == pVertex) {
/* 273 */         result.append(this.edges.getContent());
/*     */       } 
/*     */       
/* 276 */       this.edges.next();
/*     */     } 
/* 278 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Edge getEdge(Vertex pVertex, Vertex pAnotherVertex) {
/* 288 */     Edge result = null;
/*     */ 
/*     */     
/* 291 */     this.edges.toFirst();
/* 292 */     while (this.edges.hasAccess() && result == null) {
/*     */ 
/*     */       
/* 295 */       Vertex[] vertexPair = ((Edge)this.edges.getContent()).getVertices();
/* 296 */       if ((vertexPair[0] == pVertex && vertexPair[1] == pAnotherVertex) || (vertexPair[0] == pAnotherVertex && vertexPair[1] == pVertex))
/*     */       {
/*     */         
/* 299 */         result = this.edges.getContent();
/*     */       }
/* 301 */       this.edges.next();
/*     */     } 
/* 303 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 310 */     return this.vertices.isEmpty();
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\Graph.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */