/*     */ package SgJavaLib.datenbank;
/*     */ 
/*     */ import SgJavaLib.datenstrukturen.Queue;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
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
/*     */ public class DatabaseConnector
/*     */ {
/*     */   private Connection connection;
/*  25 */   private QueryResult currentQueryResult = null;
/*  26 */   private String message = null;
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
/*     */   public DatabaseConnector(String ip, int port, String db, String user, String pw) {
/*     */     try {
/*  40 */       Class.forName("org.sqlite.JDBC");
/*     */ 
/*     */       
/*  43 */       this.connection = DriverManager.getConnection("jdbc:sqlite:" + db);
/*     */     }
/*  45 */     catch (Exception e) {
/*  46 */       this.message = e.getMessage();
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
/*     */   public void executeStatement(String pSQLStatement) {
/*  59 */     this.currentQueryResult = null;
/*  60 */     this.message = null;
/*     */ 
/*     */     
/*     */     try {
/*  64 */       Statement statement = this.connection.createStatement();
/*     */ 
/*     */       
/*  67 */       if (statement.execute(pSQLStatement))
/*     */       {
/*     */         
/*  70 */         ResultSet resultset = statement.getResultSet();
/*     */ 
/*     */         
/*  73 */         int columnCount = resultset.getMetaData().getColumnCount();
/*     */ 
/*     */         
/*  76 */         String[] resultColumnNames = new String[columnCount];
/*  77 */         String[] resultColumnTypes = new String[columnCount];
/*  78 */         for (int i = 0; i < columnCount; i++) {
/*  79 */           resultColumnNames[i] = resultset.getMetaData().getColumnLabel(i + 1);
/*  80 */           resultColumnTypes[i] = resultset.getMetaData().getColumnTypeName(i + 1);
/*     */         } 
/*     */ 
/*     */         
/*  84 */         Queue<String[]> rows = new Queue();
/*     */ 
/*     */         
/*  87 */         int rowCount = 0;
/*  88 */         while (resultset.next()) {
/*  89 */           String[] resultrow = new String[columnCount];
/*  90 */           for (int s = 0; s < columnCount; s++) {
/*  91 */             resultrow[s] = resultset.getString(s + 1);
/*     */           }
/*  93 */           rows.enqueue(resultrow);
/*  94 */           rowCount++;
/*     */         } 
/*     */ 
/*     */         
/*  98 */         String[][] resultData = new String[rowCount][columnCount];
/*  99 */         int j = 0;
/* 100 */         while (!rows.isEmpty()) {
/* 101 */           resultData[j] = (String[])rows.front();
/* 102 */           rows.dequeue();
/* 103 */           j++;
/*     */         } 
/*     */ 
/*     */         
/* 107 */         statement.close();
/* 108 */         this.currentQueryResult = new QueryResult(resultData, resultColumnNames, resultColumnTypes);
/*     */       }
/*     */       else
/*     */       {
/* 112 */         statement.close();
/*     */       }
/*     */     
/* 115 */     } catch (Exception e) {
/*     */       
/* 117 */       this.message = e.getMessage();
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
/*     */   public QueryResult getCurrentQueryResult() {
/* 129 */     return this.currentQueryResult;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getErrorMessage() {
/* 137 */     return this.message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 145 */       this.connection.close();
/* 146 */     } catch (Exception e) {
/* 147 */       this.message = e.getMessage();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\datenbank\DatabaseConnector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */