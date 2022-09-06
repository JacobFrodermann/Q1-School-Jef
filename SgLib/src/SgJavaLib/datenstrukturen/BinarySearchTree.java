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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BinarySearchTree<ContentType extends ComparableContent<ContentType>>
/*     */ {
/*     */   private BSTNode<ContentType> node;
/*     */   
/*     */   private class BSTNode<CT extends ComparableContent<CT>>
/*     */   {
/*     */     private CT content;
/*     */     private BinarySearchTree<CT> left;
/*     */     private BinarySearchTree<CT> right;
/*     */     
/*     */     public BSTNode(CT pContent) {
/*  50 */       this.content = pContent;
/*  51 */       this.left = new BinarySearchTree<>();
/*  52 */       this.right = new BinarySearchTree<>();
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
/*     */   public BinarySearchTree() {
/*  65 */     this.node = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  76 */     return (this.node == null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insert(ContentType pContent) {
/*  94 */     if (pContent != null) {
/*  95 */       if (isEmpty()) {
/*  96 */         this.node = new BSTNode<>(pContent);
/*  97 */       } else if (pContent.isLess((ComparableContent)this.node.content)) {
/*  98 */         this.node.left.insert(pContent);
/*  99 */       } else if (pContent.isGreater((ComparableContent)this.node.content)) {
/* 100 */         this.node.right.insert(pContent);
/*     */       } 
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
/*     */   public BinarySearchTree<ContentType> getLeftTree() {
/* 114 */     if (isEmpty()) {
/* 115 */       return null;
/*     */     }
/* 117 */     return this.node.left;
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
/*     */   public ContentType getContent() {
/* 130 */     if (isEmpty()) {
/* 131 */       return null;
/*     */     }
/* 133 */     return (ContentType)this.node.content;
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
/*     */   public BinarySearchTree<ContentType> getRightTree() {
/* 146 */     if (isEmpty()) {
/* 147 */       return null;
/*     */     }
/* 149 */     return this.node.right;
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
/*     */   
/*     */   public void remove(ContentType pContent) {
/* 164 */     if (isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 169 */     if (pContent.isLess((ComparableContent)this.node.content)) {
/*     */       
/* 171 */       this.node.left.remove(pContent);
/* 172 */     } else if (pContent.isGreater((ComparableContent)this.node.content)) {
/*     */       
/* 174 */       this.node.right.remove(pContent);
/*     */     
/*     */     }
/* 177 */     else if (this.node.left.isEmpty()) {
/* 178 */       if (this.node.right.isEmpty()) {
/*     */         
/* 180 */         this.node = null;
/*     */       } else {
/*     */         
/* 183 */         this.node = getNodeOfRightSuccessor();
/*     */       } 
/* 185 */     } else if (this.node.right.isEmpty()) {
/*     */       
/* 187 */       this.node = getNodeOfLeftSuccessor();
/*     */     
/*     */     }
/* 190 */     else if ((getNodeOfRightSuccessor()).left.isEmpty()) {
/*     */       
/* 192 */       this.node.content = (getNodeOfRightSuccessor()).content;
/* 193 */       this.node.right = (getNodeOfRightSuccessor()).right;
/*     */     } else {
/*     */       
/* 196 */       BinarySearchTree<ContentType> previous = this.node.right.ancestorOfSmallRight();
/* 197 */       BinarySearchTree<ContentType> smallest = previous.node.left;
/* 198 */       this.node.content = smallest.node.content;
/* 199 */       previous.remove((ContentType)smallest.node.content);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ContentType search(ContentType pContent) {
/* 217 */     if (isEmpty() || pContent == null)
/*     */     {
/* 219 */       return null;
/*     */     }
/* 221 */     ContentType content = getContent();
/* 222 */     if (pContent.isLess(content))
/*     */     {
/* 224 */       return getLeftTree().search(pContent); } 
/* 225 */     if (pContent.isGreater(content))
/*     */     {
/* 227 */       return getRightTree().search(pContent); } 
/* 228 */     if (pContent.isEqual(content))
/*     */     {
/* 230 */       return content;
/*     */     }
/*     */     
/* 233 */     return null;
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
/*     */   private BinarySearchTree<ContentType> ancestorOfSmallRight() {
/* 247 */     if ((getNodeOfLeftSuccessor()).left.isEmpty()) {
/* 248 */       return this;
/*     */     }
/* 250 */     return this.node.left.ancestorOfSmallRight();
/*     */   }
/*     */ 
/*     */   
/*     */   private BSTNode<ContentType> getNodeOfLeftSuccessor() {
/* 255 */     return this.node.left.node;
/*     */   }
/*     */   
/*     */   private BSTNode<ContentType> getNodeOfRightSuccessor() {
/* 259 */     return this.node.right.node;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenstrukturen\BinarySearchTree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */