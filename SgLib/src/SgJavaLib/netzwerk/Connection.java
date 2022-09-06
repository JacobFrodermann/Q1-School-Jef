/*    */ package SgJavaLib.netzwerk;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.PrintWriter;
/*    */ import java.net.Socket;
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
/*    */ 
/*    */ public class Connection
/*    */ {
/*    */   private Socket socket;
/*    */   private BufferedReader fromServer;
/*    */   private PrintWriter toServer;
/*    */   
/*    */   public Connection(String pServerIP, int pServerPort) {
/*    */     try {
/* 39 */       this.socket = new Socket(pServerIP, pServerPort);
/* 40 */       this.toServer = new PrintWriter(this.socket.getOutputStream(), true);
/* 41 */       this.fromServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
/*    */     }
/* 43 */     catch (Exception e) {
/*    */ 
/*    */ 
/*    */       
/* 47 */       this.socket = null;
/* 48 */       this.toServer = null;
/* 49 */       this.fromServer = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String receive() {
/* 55 */     if (this.fromServer != null) {
/*    */       
/*    */       try {
/* 58 */         return this.fromServer.readLine();
/*    */       }
/* 60 */       catch (IOException iOException) {}
/*    */     }
/*    */     
/* 63 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void send(String pMessage) {
/* 68 */     if (this.toServer != null)
/*    */     {
/* 70 */       this.toServer.println(pMessage);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void close() {
/* 77 */     if (this.socket != null && !this.socket.isClosed())
/*    */       
/*    */       try {
/* 80 */         this.socket.close();
/*    */       }
/* 82 */       catch (IOException iOException) {} 
/*    */   }
/*    */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\netzwerk\Connection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */