/*     */ package SgJavaLib.datenstrukturen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BinaryTree<ContentType>
/*     */ {
/*     */   private BTNode<ContentType> node;
/*     */   
/*     */   private class BTNode<CT>
/*     */   {
/*     */     private CT content;
/*     */     private BinaryTree<CT> left;
/*     */     private BinaryTree<CT> right;
/*     */     
/*     */     public BTNode(CT pContent) {
/*  39 */       this.content = pContent;
/*  40 */       this.left = new BinaryTree<>();
/*  41 */       this.right = new BinaryTree<>();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BinaryTree() {
/*  54 */     this.node = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public BinaryTree(ContentType pContent) {
/*  67 */     if (pContent != null) {
/*  68 */       this.node = new BTNode<>(pContent);
/*     */     } else {
/*  70 */       this.node = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BinaryTree(ContentType pContent, BinaryTree<ContentType> pLeftTree, BinaryTree<ContentType> pRightTree) {
/*  90 */     if (pContent != null) {
/*  91 */       this.node = new BTNode<>(pContent);
/*  92 */       if (pLeftTree != null) {
/*  93 */         this.node.left = pLeftTree;
/*     */       } else {
/*  95 */         this.node.left = new BinaryTree();
/*     */       } 
/*  97 */       if (pRightTree != null) {
/*  98 */         this.node.right = pRightTree;
/*     */       } else {
/* 100 */         this.node.right = new BinaryTree();
/*     */       } 
/*     */     } else {
/*     */       
/* 104 */       this.node = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 115 */     return (this.node == null);
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
/*     */   
/*     */   public void setContent(ContentType pContent) {
/* 129 */     if (pContent != null) {
/* 130 */       if (isEmpty()) {
/* 131 */         this.node = new BTNode<>(pContent);
/* 132 */         this.node.left = new BinaryTree();
/* 133 */         this.node.right = new BinaryTree();
/*     */       } 
/* 135 */       this.node.content = (CT)pContent;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentType getContent() {
/* 147 */     if (isEmpty()) {
/* 148 */       return null;
/*     */     }
/* 150 */     return (ContentType)this.node.content;
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
/*     */   public void setLeftTree(BinaryTree<ContentType> pTree) {
/* 163 */     if (!isEmpty() && pTree != null) {
/* 164 */       this.node.left = pTree;
/*     */     }
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
/*     */   public void setRightTree(BinaryTree<ContentType> pTree) {
/* 177 */     if (!isEmpty() && pTree != null) {
/* 178 */       this.node.right = pTree;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BinaryTree<ContentType> getLeftTree() {
/* 190 */     if (!isEmpty()) {
/* 191 */       return this.node.left;
/*     */     }
/* 193 */     return null;
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
/*     */   public BinaryTree<ContentType> getRightTree() {
/* 205 */     if (!isEmpty()) {
/* 206 */       return this.node.right;
/*     */     }
/* 208 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\BinaryTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */