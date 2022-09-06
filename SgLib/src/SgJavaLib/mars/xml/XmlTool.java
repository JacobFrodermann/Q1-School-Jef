/*     */ package SgJavaLib.mars.xml;
/*     */ 
/*     */ import SgJavaLib.mars.gui.HamsterMainFrame;
/*     */ import SgJavaLib.mars.model.HamsterField;
/*     */ import java.io.File;
/*     */ import java.io.InputStream;
/*     */ import java.util.LinkedList;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ public class XmlTool
/*     */ {
/*  39 */   private final LinkedList<HamsterField> loadedFieldsList = new LinkedList<>();
/*     */   private boolean worldLoadedFromXml = false;
/*  41 */   private String nameLoadedWorld = "";
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveCurrentWorld(HamsterField[][] pFields) {
/*  46 */     boolean saved = writeWorldToXmlFile("letzteWelt.xml", "Letzte Welt", pFields);
/*  47 */     if (!saved) {
/*  48 */       HamsterMainFrame.getInstance().showTechnicalErrorMessage("Fehler beim Speichern der aktuellen Welt.");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean saveCurrentWorldToExternalFile(String pFileLocation, HamsterField[][] pFields) {
/*  53 */     return writeWorldToXmlFile(pFileLocation, "Eigene Welt", pFields);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean writeWorldToXmlFile(String pFileLocation, String pWorldName, HamsterField[][] pFields) {
/*  58 */     DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
/*     */     
/*     */     try {
/*  61 */       DocumentBuilder icBuilder = icFactory.newDocumentBuilder();
/*  62 */       Document doc = icBuilder.newDocument();
/*     */       
/*  64 */       Element world = doc.createElement("welt");
/*  65 */       world.setAttribute("name", pWorldName);
/*  66 */       doc.appendChild(world);
/*     */       
/*  68 */       for (int r = 0; r < pFields.length; r++) {
/*  69 */         for (int c = 0; c < (pFields[0]).length; c++) {
/*  70 */           HamsterField currentField = pFields[r][c];
/*     */ 
/*     */           
/*  73 */           Element field = doc.createElement("field");
/*  74 */           field.setAttribute("row", currentField.getRowNumber() + "");
/*  75 */           field.setAttribute("column", currentField.getColumnNumber() + "");
/*  76 */           if (currentField.isHamsterOnField()) {
/*  77 */             field.setAttribute("hamster", "1");
/*     */           } else {
/*     */             
/*  80 */             field.setAttribute("hamster", "0");
/*     */           } 
/*  82 */           field.setAttribute("hamsterDir", currentField.getHamsterDirection() + "");
/*  83 */           field.setAttribute("hamsterSight", currentField.getLineOfSight() + "");
/*  84 */           if (currentField.isWallOnField()) {
/*  85 */             field.setAttribute("wall", "1");
/*     */           } else {
/*     */             
/*  88 */             field.setAttribute("wall", "0");
/*     */           } 
/*  90 */           field.setAttribute("corn", currentField.getNumberOfCorns() + "");
/*     */           
/*  92 */           world.appendChild(field);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 100 */       TransformerFactory transformerFactory = TransformerFactory.newInstance();
/* 101 */       Transformer transformer = transformerFactory.newTransformer();
/*     */       
/* 103 */       transformer.setOutputProperty("indent", "yes");
/* 104 */       DOMSource source = new DOMSource(doc);
/*     */ 
/*     */       
/* 107 */       StreamResult file = new StreamResult(new File(pFileLocation));
/*     */ 
/*     */       
/* 110 */       transformer.transform(source, file);
/*     */     }
/* 112 */     catch (Exception e) {
/* 113 */       HamsterMainFrame.getInstance().showTechnicalErrorMessage("Fehler beim Speichern der aktuellen Welt. writeWorldToXmlFile\n" + e.getMessage());
/*     */     } 
/*     */     
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean loadWorldFromXmlFile(String pWorld, boolean pExternalWorld) {
/* 126 */     this.worldLoadedFromXml = false;
/*     */     
/*     */     try {
/* 129 */       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
/* 130 */       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
/* 131 */       Document doc = null;
/*     */       
/* 133 */       if (pExternalWorld) {
/* 134 */         File worldFile = new File(pWorld);
/* 135 */         doc = dBuilder.parse(worldFile);
/*     */       } else {
/*     */         
/* 138 */         String worldPath = "/EgJavaLib2/mars/worlds/" + pWorld + ".xml";
/* 139 */         InputStream in = getClass().getResourceAsStream(worldPath);
/* 140 */         doc = dBuilder.parse(in);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 145 */       doc.getDocumentElement().normalize();
/*     */ 
/*     */       
/* 148 */       Node nameNode = doc.getDocumentElement();
/* 149 */       this.nameLoadedWorld = nameNode.getAttributes().getNamedItem("name").getNodeValue();
/*     */       
/* 151 */       int numberHamster = 0;
/*     */       
/* 153 */       NodeList nList = doc.getElementsByTagName("field");
/* 154 */       for (int temp = 0; temp < nList.getLength(); temp++) {
/*     */         
/* 156 */         Node nNode = nList.item(temp);
/* 157 */         int row = Integer.parseInt(nNode.getAttributes().getNamedItem("row").getNodeValue());
/*     */         
/* 159 */         int column = Integer.parseInt(nNode.getAttributes().getNamedItem("column").getNodeValue());
/*     */         
/* 161 */         boolean hamster = (Integer.parseInt(nNode.getAttributes().getNamedItem("hamster").getNodeValue()) == 1);
/*     */         
/* 163 */         int dir = Integer.parseInt(nNode.getAttributes().getNamedItem("hamsterDir").getNodeValue());
/*     */         
/* 165 */         int sight = Integer.parseInt(nNode.getAttributes().getNamedItem("hamsterSight").getNodeValue());
/*     */         
/* 167 */         boolean wall = (Integer.parseInt(nNode.getAttributes().getNamedItem("wall").getNodeValue()) == 1);
/*     */         
/* 169 */         int corn = Integer.parseInt(nNode.getAttributes().getNamedItem("corn").getNodeValue());
/*     */ 
/*     */         
/* 172 */         HamsterField f = new HamsterField(row, column);
/* 173 */         f.setHamsterOnField(hamster);
/* 174 */         f.setHamsterDirection(dir);
/* 175 */         f.setLineOfSight(sight);
/* 176 */         f.setWallOnField(wall);
/* 177 */         f.setNumberOfCorns(corn);
/*     */         
/* 179 */         if (hamster) {
/* 180 */           numberHamster++;
/*     */         }
/*     */         
/* 183 */         if (f.isValidField()) {
/* 184 */           this.loadedFieldsList.add(f);
/*     */         } else {
/*     */           
/* 187 */           return false;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       if (numberHamster == 1 && !this.loadedFieldsList.isEmpty()) {
/* 199 */         this.worldLoadedFromXml = true;
/* 200 */         return true;
/*     */       } 
/*     */       
/* 203 */       return false;
/*     */ 
/*     */     
/*     */     }
/* 207 */     catch (Exception e) {
/* 208 */       HamsterMainFrame.getInstance().showTechnicalErrorMessage("Fehler beim Laden der aktuellen Welt. loadWorldToXmlFile\n" + e.getMessage());
/* 209 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HamsterField getOneField() {
/* 217 */     if (this.worldLoadedFromXml) {
/* 218 */       HamsterField f = this.loadedFieldsList.getFirst();
/* 219 */       this.loadedFieldsList.removeFirst();
/* 220 */       return f;
/*     */     } 
/*     */     
/* 223 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getNameLoadedWorld() {
/* 228 */     if (this.worldLoadedFromXml) {
/* 229 */       return this.nameLoadedWorld;
/*     */     }
/*     */     
/* 232 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasUnloadedFields() {
/* 237 */     if (this.worldLoadedFromXml) {
/* 238 */       return !this.loadedFieldsList.isEmpty();
/*     */     }
/*     */     
/* 241 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void unloadWorld() {
/* 247 */     this.loadedFieldsList.clear();
/* 248 */     this.worldLoadedFromXml = false;
/* 249 */     this.nameLoadedWorld = "";
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\xml\XmlTool.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */