/*    */ package SgJavaLib.datenbank;
/*    */ 
/*    */ public class QueryResult
/*    */ {
/*    */   public String[][] data;
/*    */   private String[] columnNames;
/*    */   private String[] columnTypes;
/*    */   
/*    */   QueryResult(String[][] pData, String[] pColumnNames, String[] pColumnTypes) {
/* 28 */     this.data = pData;
/* 29 */     this.columnNames = pColumnNames;
/* 30 */     this.columnTypes = pColumnTypes;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[][] getData() {
/* 39 */     return this.data;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getColumnNames() {
/* 47 */     return this.columnNames;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getColumnTypes() {
/* 55 */     return this.columnTypes;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getRowCount() {
/* 62 */     if (this.data != null) {
/* 63 */       return this.data.length;
/*    */     }
/* 65 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getColumnCount() {
/* 72 */     if (this.data != null && this.data.length > 0 && this.data[0] != null) {
/* 73 */       return (this.data[0]).length;
/*    */     }
/* 75 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenbank\QueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */