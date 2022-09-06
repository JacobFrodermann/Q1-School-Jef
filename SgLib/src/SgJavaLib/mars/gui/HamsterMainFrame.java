/*     */ package SgJavaLib.mars.gui;
/*     */ import SgJavaLib.mars.model.HamsterField;
/*     */ import SgJavaLib.mars.model.HamsterScene;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ 
/*     */ public class HamsterMainFrame extends JFrame {
/*     */   private static HamsterMainFrame instance;
/*     */   private JButton btnLoadCustomWorld;
/*     */   private JButton btnLoadSelectedWorld;
/*     */   private JButton btnQuickSave;
/*     */   private JButton btnSaveCustomWorld;
/*     */   private JComboBox<String> cmboWorldSelection;
/*     */   private Box.Filler filler1;
/*     */   
/*     */   public static HamsterMainFrame getInstance() {
/*  31 */     if (instance == null) {
/*  32 */       instance = new HamsterMainFrame();
/*     */     }
/*  34 */     return instance;
/*     */   }
/*     */   private Box.Filler filler2; private Box.Filler filler3; private Box.Filler filler5; private HamsterPlayground hamsterPlayground1; private JPanel jPanel1; private JLabel lblCaption; private JPanel mainPanel;
/*     */   public void showErrorMsg(String pMessage) {
/*  38 */     JOptionPane.showMessageDialog(this, pMessage, "Fehler!", 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HamsterMainFrame() {
/*  46 */     initComponents();
/*  47 */     this.mainPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
/*  48 */     this.hamsterPlayground1.setSize(this.hamsterPlayground1.getBoardSize());
/*  49 */     this.hamsterPlayground1.setPreferredSize(this.hamsterPlayground1.getBoardSize());
/*  50 */     this.hamsterPlayground1.setMinimumSize(this.hamsterPlayground1.getBoardSize());
/*  51 */     this.hamsterPlayground1.setMaximumSize(this.hamsterPlayground1.getBoardSize());
/*  52 */     this.cmboWorldSelection.setModel(new DefaultComboBoxModel<>(new String[] { "Welt-01", "Welt-02", "Welt-03", "Welt-04", "Welt-05", "Welt-06", "Welt-07", "Welt-08", "Welt-09", "Welt-10" }));
/*  53 */     this.lblCaption.requestFocusInWindow();
/*  54 */     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
/*  55 */     double height = screenSize.getHeight();
/*  56 */     int middlePosition = (int)(height / 2.0D - getSize().getHeight() / 2.0D);
/*  57 */     setLocation(75, middlePosition);
/*  58 */     setTitle("Probleme auf dem Mars");
/*  59 */     setResizable(false);
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
/*     */   private void initComponents() {
/*  71 */     this.mainPanel = new JPanel();
/*  72 */     this.hamsterPlayground1 = new HamsterPlayground();
/*  73 */     this.filler5 = new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
/*  74 */     this.jPanel1 = new JPanel();
/*  75 */     this.lblCaption = new JLabel();
/*  76 */     this.filler1 = new Box.Filler(new Dimension(20, 0), new Dimension(20, 0), new Dimension(20, 32767));
/*  77 */     this.cmboWorldSelection = new JComboBox<>();
/*  78 */     this.btnLoadSelectedWorld = new JButton();
/*  79 */     this.filler2 = new Box.Filler(new Dimension(50, 0), new Dimension(50, 0), new Dimension(50, 32767));
/*  80 */     this.btnQuickSave = new JButton();
/*  81 */     this.btnSaveCustomWorld = new JButton();
/*  82 */     this.btnLoadCustomWorld = new JButton();
/*  83 */     this.filler3 = new Box.Filler(new Dimension(0, 10), new Dimension(0, 10), new Dimension(32767, 10));
/*     */     
/*  85 */     setDefaultCloseOperation(3);
/*  86 */     addWindowListener(new WindowAdapter() {
/*     */           public void windowClosing(WindowEvent evt) {
/*  88 */             HamsterMainFrame.this.formWindowClosing(evt);
/*     */           }
/*     */         });
/*     */     
/*  92 */     this.mainPanel.setLayout(new BoxLayout(this.mainPanel, 3));
/*  93 */     this.mainPanel.add(this.hamsterPlayground1);
/*  94 */     this.mainPanel.add(this.filler5);
/*     */     
/*  96 */     this.lblCaption.setFont(new Font("Tahoma", 1, 18));
/*  97 */     this.lblCaption.setText("Probleme auf dem Mars");
/*  98 */     this.lblCaption.addMouseListener(new MouseAdapter() {
/*     */           public void mouseClicked(MouseEvent evt) {
/* 100 */             HamsterMainFrame.this.lblCaptionMouseClicked(evt);
/*     */           }
/*     */         });
/* 103 */     this.jPanel1.add(this.lblCaption);
/* 104 */     this.jPanel1.add(this.filler1);
/*     */     
/* 106 */     this.cmboWorldSelection.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 107 */     this.jPanel1.add(this.cmboWorldSelection);
/*     */     
/* 109 */     this.btnLoadSelectedWorld.setText("laden");
/* 110 */     this.btnLoadSelectedWorld.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 112 */             HamsterMainFrame.this.btnLoadSelectedWorldActionPerformed(evt);
/*     */           }
/*     */         });
/* 115 */     this.jPanel1.add(this.btnLoadSelectedWorld);
/* 116 */     this.jPanel1.add(this.filler2);
/*     */     
/* 118 */     this.btnQuickSave.setText("Quicksave");
/* 119 */     this.btnQuickSave.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 121 */             HamsterMainFrame.this.btnQuickSaveActionPerformed(evt);
/*     */           }
/*     */         });
/* 124 */     this.jPanel1.add(this.btnQuickSave);
/*     */     
/* 126 */     this.btnSaveCustomWorld.setText("Welt speichern unter");
/* 127 */     this.btnSaveCustomWorld.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 129 */             HamsterMainFrame.this.btnSaveCustomWorldActionPerformed(evt);
/*     */           }
/*     */         });
/* 132 */     this.jPanel1.add(this.btnSaveCustomWorld);
/*     */     
/* 134 */     this.btnLoadCustomWorld.setText("Welt laden");
/* 135 */     this.btnLoadCustomWorld.addActionListener(new ActionListener() {
/*     */           public void actionPerformed(ActionEvent evt) {
/* 137 */             HamsterMainFrame.this.btnLoadCustomWorldActionPerformed(evt);
/*     */           }
/*     */         });
/* 140 */     this.jPanel1.add(this.btnLoadCustomWorld);
/*     */     
/* 142 */     this.mainPanel.add(this.jPanel1);
/* 143 */     this.mainPanel.add(this.filler3);
/*     */     
/* 145 */     getContentPane().add(this.mainPanel, "First");
/*     */     
/* 147 */     pack();
/*     */   }
/*     */   
/*     */   private void lblCaptionMouseClicked(MouseEvent evt) {
/* 151 */     JOptionPane.showMessageDialog(this, "Version 1.0,\nJohannes Kuhaupt,\nJohannesKuhaupt@posteo.de", "Infos über Probleme auf dem Mars", 1);
/*     */   }
/*     */   
/*     */   private void formWindowClosing(WindowEvent evt) {
/* 155 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private void btnLoadCustomWorldActionPerformed(ActionEvent evt) {
/* 159 */     JFileChooser chooser = new JFileChooser();
/* 160 */     FileNameExtensionFilter filter = new FileNameExtensionFilter("XML-Welten", new String[] { "xml" });
/*     */     
/* 162 */     chooser.setFileFilter(filter);
/* 163 */     int returnVal = chooser.showOpenDialog(this);
/* 164 */     if (returnVal == 0) {
/* 165 */       HamsterScene.getInstance().loadExternalWorld(chooser.getSelectedFile().getAbsolutePath());
/* 166 */       updateHamsterWorld();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void btnLoadSelectedWorldActionPerformed(ActionEvent evt) {
/* 175 */     String selection = (String)this.cmboWorldSelection.getSelectedItem();
/* 176 */     HamsterScene.getInstance().loadBuildInWorld(selection);
/* 177 */     updateHamsterWorld();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void btnSaveCustomWorldActionPerformed(ActionEvent evt) {
/* 183 */     JFileChooser chooser = new JFileChooser();
/* 184 */     FileNameExtensionFilter filter = new FileNameExtensionFilter("XML-Welten", new String[] { "xml" });
/*     */     
/* 186 */     chooser.setFileFilter(filter);
/* 187 */     int returnVal = chooser.showSaveDialog(this);
/* 188 */     if (returnVal == 0) {
/* 189 */       String filePath = chooser.getSelectedFile().getAbsolutePath();
/* 190 */       if (filePath.endsWith(".xml")) {
/* 191 */         HamsterScene.getInstance().saveWorldToExternalFile(filePath);
/*     */       } else {
/*     */         
/* 194 */         HamsterScene.getInstance().saveWorldToExternalFile(filePath + ".xml");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void btnQuickSaveActionPerformed(ActionEvent evt) {
/* 201 */     HamsterScene.getInstance().saveWorldToRecentFile();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateField(int pRow, int pColumn, HamsterField pHamsterField) {
/* 226 */     this.hamsterPlayground1.updateField(pRow, pColumn, pHamsterField);
/*     */   }
/*     */   
/*     */   public FieldPanel getField(int pRow, int pColumn) {
/* 230 */     return this.hamsterPlayground1.getField(pRow, pColumn);
/*     */   }
/*     */   
/*     */   public void updateHamsterWorld() {
/* 234 */     HamsterField[][] fields = HamsterScene.getInstance().getFields();
/* 235 */     for (int r = 0; r < fields.length; r++) {
/* 236 */       for (int c = 0; c < (fields[0]).length; c++) {
/* 237 */         updateField(r, c, fields[r][c]);
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
/*     */   public void showTechnicalErrorMessage(String pMessage) {
/* 249 */     JOptionPane.showMessageDialog(getInstance(), pMessage, "Fehler!", 0);
/*     */   }
/*     */   
/*     */   public String showInputDialogText() {
/* 253 */     String text = JOptionPane.showInputDialog(this, "Die foglende Text-Nachricht wird an den MarsRover gesendet:", "Text versenden", -1);
/* 254 */     if (text == null) {
/* 255 */       return "";
/*     */     }
/*     */     
/* 258 */     return text;
/*     */   }
/*     */   
/*     */   public int showInputDialogNumber() {
/*     */     int number;
/* 263 */     String s = JOptionPane.showInputDialog(this, "Die foglende Zahl wird an den MarsRover gesendet:", "Zahl versenden", -1);
/*     */ 
/*     */     
/*     */     try {
/* 267 */       number = Integer.parseInt(s);
/*     */     }
/* 269 */     catch (NumberFormatException ex) {
/* 270 */       number = 0;
/*     */     } 
/*     */     
/* 273 */     return number;
/*     */   }
/*     */ }


/* Location:              C:\Users\jacob.frodermann\Desktop\SgJavaLib.jar!\SgJavaLib\mars\gui\HamsterMainFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */