/*     */ package SgJavaLib.netzwerk;
/*     */ 
/*     */ import SgJavaLib.datenstrukturen.List;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.ServerSocket;
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
/*     */ public abstract class Server
/*     */ {
/*     */   private NewConnectionHandler connectionHandler;
/*     */   private List<ClientMessageHandler> messageHandlers;
/*     */   
/*     */   private class NewConnectionHandler
/*     */     extends Thread
/*     */   {
/*     */     private ServerSocket serverSocket;
/*     */     private boolean active;
/*     */     
/*     */     public NewConnectionHandler(int pPort) {
/*     */       try {
/*  45 */         this.serverSocket = new ServerSocket(pPort);
/*  46 */         start();
/*  47 */         this.active = true;
/*     */       }
/*  49 */       catch (Exception e) {
/*     */         
/*  51 */         this.serverSocket = null;
/*  52 */         this.active = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*  58 */       while (this.active) {
/*     */ 
/*     */         
/*     */         try {
/*     */           
/*  63 */           Socket clientSocket = this.serverSocket.accept();
/*     */ 
/*     */           
/*  66 */           Server.this.addNewClientMessageHandler(clientSocket);
/*  67 */           Server.this.processNewConnection(clientSocket.getInetAddress().getHostAddress(), clientSocket.getPort());
/*     */         
/*     */         }
/*  70 */         catch (IOException iOException) {}
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
/*     */     public void close() {
/*  82 */       this.active = false;
/*  83 */       if (this.serverSocket != null) {
/*     */         
/*     */         try {
/*  86 */           this.serverSocket.close();
/*     */         }
/*  88 */         catch (IOException iOException) {}
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class ClientMessageHandler
/*     */     extends Thread
/*     */   {
/*     */     private ClientSocketWrapper socketWrapper;
/*     */     
/*     */     private boolean active;
/*     */ 
/*     */     
/*     */     private class ClientSocketWrapper
/*     */     {
/*     */       private Socket clientSocket;
/*     */       
/*     */       private BufferedReader fromClient;
/*     */       
/*     */       private PrintWriter toClient;
/*     */ 
/*     */       
/*     */       public ClientSocketWrapper(Socket pSocket) {
/*     */         try {
/* 113 */           this.clientSocket = pSocket;
/* 114 */           this.toClient = new PrintWriter(this.clientSocket.getOutputStream(), true);
/* 115 */           this.fromClient = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
/*     */         }
/* 117 */         catch (IOException e) {
/*     */           
/* 119 */           this.clientSocket = null;
/* 120 */           this.toClient = null;
/* 121 */           this.fromClient = null;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public String receive() {
/* 127 */         if (this.fromClient != null) {
/*     */           
/*     */           try {
/* 130 */             return this.fromClient.readLine();
/*     */           }
/* 132 */           catch (IOException iOException) {}
/*     */         }
/*     */         
/* 135 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public void send(String pMessage) {
/* 140 */         if (this.toClient != null)
/*     */         {
/* 142 */           this.toClient.println(pMessage);
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public String getClientIP() {
/* 148 */         if (this.clientSocket != null) {
/* 149 */           return this.clientSocket.getInetAddress().getHostAddress();
/*     */         }
/* 151 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public int getClientPort() {
/* 156 */         if (this.clientSocket != null) {
/* 157 */           return this.clientSocket.getPort();
/*     */         }
/* 159 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public void close() {
/* 164 */         if (this.clientSocket != null) {
/*     */           
/*     */           try {
/* 167 */             this.clientSocket.close();
/*     */           }
/* 169 */           catch (IOException iOException) {}
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
/*     */     private ClientMessageHandler(Socket pClientSocket) {
/* 182 */       this.socketWrapper = new ClientSocketWrapper(pClientSocket);
/* 183 */       if (pClientSocket != null) {
/*     */         
/* 185 */         start();
/* 186 */         this.active = true;
/*     */       }
/*     */       else {
/*     */         
/* 190 */         this.active = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 196 */       String message = null;
/* 197 */       while (this.active) {
/*     */         
/* 199 */         message = this.socketWrapper.receive();
/* 200 */         if (message != null) {
/* 201 */           Server.this.processMessage(this.socketWrapper.getClientIP(), this.socketWrapper.getClientPort(), message);
/*     */           continue;
/*     */         } 
/* 204 */         ClientMessageHandler aMessageHandler = Server.this.findClientMessageHandler(this.socketWrapper.getClientIP(), this.socketWrapper.getClientPort());
/* 205 */         if (aMessageHandler != null) {
/*     */           
/* 207 */           aMessageHandler.close();
/* 208 */           Server.this.removeClientMessageHandler(aMessageHandler);
/* 209 */           Server.this.processClosingConnection(this.socketWrapper.getClientIP(), this.socketWrapper.getClientPort());
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void send(String pMessage) {
/* 217 */       if (this.active) {
/* 218 */         this.socketWrapper.send(pMessage);
/*     */       }
/*     */     }
/*     */     
/*     */     public void close() {
/* 223 */       if (this.active) {
/*     */         
/* 225 */         this.active = false;
/* 226 */         this.socketWrapper.close();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String getClientIP() {
/* 232 */       return this.socketWrapper.getClientIP();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getClientPort() {
/* 237 */       return this.socketWrapper.getClientPort();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Server(int pPort) {
/* 244 */     this.connectionHandler = new NewConnectionHandler(pPort);
/* 245 */     this.messageHandlers = new List();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 250 */     return this.connectionHandler.active;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConnectedTo(String pClientIP, int pClientPort) {
/* 255 */     ClientMessageHandler aMessageHandler = findClientMessageHandler(pClientIP, pClientPort);
/* 256 */     if (aMessageHandler != null) {
/* 257 */       return aMessageHandler.active;
/*     */     }
/* 259 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void send(String pClientIP, int pClientPort, String pMessage) {
/* 264 */     ClientMessageHandler aMessageHandler = findClientMessageHandler(pClientIP, pClientPort);
/* 265 */     if (aMessageHandler != null) {
/* 266 */       aMessageHandler.send(pMessage);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendToAll(String pMessage) {
/* 271 */     synchronized (this.messageHandlers) {
/*     */       
/* 273 */       this.messageHandlers.toFirst();
/* 274 */       while (this.messageHandlers.hasAccess()) {
/*     */         
/* 276 */         ((ClientMessageHandler)this.messageHandlers.getContent()).send(pMessage);
/* 277 */         this.messageHandlers.next();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeConnection(String pClientIP, int pClientPort) {
/* 284 */     ClientMessageHandler aMessageHandler = findClientMessageHandler(pClientIP, pClientPort);
/* 285 */     if (aMessageHandler != null) {
/*     */       
/* 287 */       processClosingConnection(pClientIP, pClientPort);
/* 288 */       aMessageHandler.close();
/* 289 */       removeClientMessageHandler(aMessageHandler);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 296 */     this.connectionHandler.close();
/*     */     
/* 298 */     synchronized (this.messageHandlers) {
/*     */ 
/*     */       
/* 301 */       this.messageHandlers.toFirst();
/* 302 */       while (this.messageHandlers.hasAccess()) {
/*     */         
/* 304 */         ClientMessageHandler aMessageHandler = (ClientMessageHandler)this.messageHandlers.getContent();
/* 305 */         processClosingConnection(aMessageHandler.getClientIP(), aMessageHandler.getClientPort());
/* 306 */         aMessageHandler.close();
/* 307 */         this.messageHandlers.remove();
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
/*     */   private void addNewClientMessageHandler(Socket pClientSocket) {
/* 320 */     synchronized (this.messageHandlers) {
/*     */       
/* 322 */       this.messageHandlers.append(new ClientMessageHandler(pClientSocket));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeClientMessageHandler(ClientMessageHandler pClientMessageHandler) {
/* 328 */     synchronized (this.messageHandlers) {
/*     */       
/* 330 */       this.messageHandlers.toFirst();
/* 331 */       while (this.messageHandlers.hasAccess()) {
/*     */         
/* 333 */         if (pClientMessageHandler == this.messageHandlers.getContent()) {
/*     */           
/* 335 */           this.messageHandlers.remove();
/*     */           
/*     */           return;
/*     */         } 
/* 339 */         this.messageHandlers.next();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ClientMessageHandler findClientMessageHandler(String pClientIP, int pClientPort) {
/* 346 */     synchronized (this.messageHandlers) {
/*     */ 
/*     */       
/* 349 */       this.messageHandlers.toFirst();
/*     */       
/* 351 */       while (this.messageHandlers.hasAccess()) {
/*     */         
/* 353 */         ClientMessageHandler aMessageHandler = (ClientMessageHandler)this.messageHandlers.getContent();
/* 354 */         if (aMessageHandler.getClientIP().equals(pClientIP) && aMessageHandler.getClientPort() == pClientPort)
/* 355 */           return aMessageHandler; 
/* 356 */         this.messageHandlers.next();
/*     */       } 
/* 358 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract void processNewConnection(String paramString, int paramInt);
/*     */   
/*     */   public abstract void processMessage(String paramString1, int paramInt, String paramString2);
/*     */   
/*     */   public abstract void processClosingConnection(String paramString, int paramInt);
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\netzwerk\Server.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */