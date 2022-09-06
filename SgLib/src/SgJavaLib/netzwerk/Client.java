/*     */ package SgJavaLib.netzwerk;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.Socket;
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
/*     */ public abstract class Client
/*     */ {
/*     */   private MessageHandler messageHandler;
/*     */   
/*     */   private class MessageHandler
/*     */     extends Thread
/*     */   {
/*     */     private SocketWrapper socketWrapper;
/*     */     private boolean active;
/*     */     
/*     */     private class SocketWrapper
/*     */     {
/*     */       private Socket socket;
/*     */       private BufferedReader fromServer;
/*     */       private PrintWriter toServer;
/*     */       
/*     */       public SocketWrapper(String pServerIP, int pServerPort) {
/*     */         try {
/*  53 */           this.socket = new Socket(pServerIP, pServerPort);
/*  54 */           this.toServer = new PrintWriter(this.socket.getOutputStream(), true);
/*  55 */           this.fromServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
/*     */         }
/*  57 */         catch (IOException e) {
/*     */           
/*  59 */           this.socket = null;
/*  60 */           this.toServer = null;
/*  61 */           this.fromServer = null;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public String receive() {
/*  67 */         if (this.fromServer != null) {
/*     */           
/*     */           try {
/*  70 */             return this.fromServer.readLine();
/*     */           }
/*  72 */           catch (IOException iOException) {}
/*     */         }
/*     */         
/*  75 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public void send(String pMessage) {
/*  80 */         if (this.toServer != null)
/*     */         {
/*  82 */           this.toServer.println(pMessage);
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public void close() {
/*  88 */         if (this.socket != null) {
/*     */           
/*     */           try {
/*  91 */             this.socket.close();
/*     */           }
/*  93 */           catch (IOException iOException) {}
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private MessageHandler(String pServerIP, int pServerPort) {
/* 106 */       this.socketWrapper = new SocketWrapper(pServerIP, pServerPort);
/* 107 */       start();
/* 108 */       if (this.socketWrapper.socket != null) {
/* 109 */         this.active = true;
/*     */       }
/*     */     }
/*     */     
/*     */     public void run() {
/* 114 */       String message = null;
/* 115 */       while (this.active) {
/*     */         
/* 117 */         message = this.socketWrapper.receive();
/* 118 */         if (message != null) {
/* 119 */           Client.this.processMessage(message); continue;
/*     */         } 
/* 121 */         close();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void send(String pMessage) {
/* 127 */       if (this.active) {
/* 128 */         this.socketWrapper.send(pMessage);
/*     */       }
/*     */     }
/*     */     
/*     */     private void close() {
/* 133 */       if (this.active) {
/*     */         
/* 135 */         this.active = false;
/* 136 */         this.socketWrapper.close();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Client(String pServerIP, int pServerPort) {
/* 143 */     this.messageHandler = new MessageHandler(pServerIP, pServerPort);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnected() {
/* 148 */     return this.messageHandler.active;
/*     */   }
/*     */ 
/*     */   
/*     */   public void send(String pMessage) {
/* 153 */     this.messageHandler.send(pMessage);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 158 */     this.messageHandler.close();
/*     */   }
/*     */   
/*     */   public abstract void processMessage(String paramString);
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\netzwerk\Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */