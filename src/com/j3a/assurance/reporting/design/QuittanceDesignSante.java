package com.j3a.assurance.reporting.design;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Cell;

/**
 * 
 * @author J3A-POSTE1-A.Lekerand
 * Bean permettant d'editer une quittance 
 *
 */

@Component
@Scope("request")
public class QuittanceDesignSante implements Serializable {
		/**
		 * 
		 */
	//Injection Spring 
		private static final long serialVersionUID = 1L;
		@Autowired
		ReportFactorySante reportFactorySante;
		@Autowired
		ReportingSante reportingSante;
		
		
		// Attribut d'instance
		private String idQuittance;
		private BigDecimal totalAccessoir;
		private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		private File repectoire;
		private  String nomFichier;

		
		  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 28,
		      Font.BOLD);
		  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
		      Font.NORMAL, BaseColor.GREEN);
		  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
		      Font.BOLD);
		  
		  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			      Font.BOLD);
		  
		  private static Font normalText = new Font(Font.FontFamily.TIMES_ROMAN, 8,
		      Font.BOLD);
		  private static Font normalTitle = new Font(Font.FontFamily.TIMES_ROMAN, 9,
			      Font.BOLD);
		  
		  private static Font smallText = new Font(Font.FontFamily.COURIER,8,
				  Font.NORMAL);
		  
		  private static Font smallTextGras = new Font(Font.FontFamily.COURIER,8,
				  Font.BOLD);
		  
		  
		  public static final String RESOURCE = "http://localhost:8080/Sherpa/resources/images/logo_j3a.jpg";
		  
		  public void editionPage() throws IOException{
			  editerQuittance(idQuittance);
		  }
		  
		  public void editerQuittance(String idQuittance) throws IOException{
			  //Créer le dosier de stockage des fichier générés
			  repectoire = new File("c:/Etats/Quittances/SANTE");
			  repectoire.mkdirs();
			  //Passer les info nécessaires à notre rapport à générer
			 
			  getReportFactorySante().setIdQuittance(idQuittance);
			  reportingSante = getReportFactorySante().ReportProvider();
				System.out.println("<-----------Quittance id :"+ reportingSante.getQuittance().getId());//clean after
		  try {
			Document document = new Document(PageSize.A4);
			document.setMargins(20, 20, 20, 20);
			nomFichier ="QT"+ getReportFactorySante().getIdQuittance()+".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(repectoire+"/"+nomFichier));

			  document.open();
			  addMetaData(document);
			  addContent(document);
			  document.close();
			  ouvrirFicher();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur1");
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur2");
		}
		  }
		  

		  private static void addMetaData(Document document) {
		    document.addTitle("Quittance Faculté");
		    document.addSubject("Edition Pièces");
		    document.addKeywords("Java, PDF, iText");
		    document.addAuthor("A.Lekerand");
		    document.addCreator("A.Lekerand");
		    
		  }
		  
		  
		

			  private void addContent(Document document) throws DocumentException, MalformedURLException, IOException {
				  // Ajout de logo
					Image logo = Image.getInstance(new URL(RESOURCE));
					logo.scalePercent(40f);
					document.add(logo);
					
				 //Entête du document
				  createEteteDoc(document);
				  Paragraph saut1 = new Paragraph();
				  addEmptyLine(saut1, 1);
				  document.add(saut1);
				  
				  //Information de la quittance
				  creatTableInfo(document);
				  Paragraph saut2 = new Paragraph();
				  addEmptyLine(saut2, 1);
				  document.add(saut2);
				  
				 
				  //Table prime
				  createTableDetailPrime(document);
				  
				  Paragraph saut3 = new Paragraph();
				  addEmptyLine(saut3, 1);
				  document.add(saut3);
				  
				 //Tableau des commissions
				  	createTableCommis(document);
				  	
				  //Tableau de primeRecap				  	
				  	createtableRecapPrime(document);
				  	
				//Emagement
				  	addEmagement(document);
				  
			  }
			  
			  
			  private void createEteteDoc(Document document) throws DocumentException {
				  String quittance = "Quittance N° "+reportingSante.getQuittance().getId();
				  PdfPTable tabEntete = new PdfPTable(3);
				
				  PdfPCell cell = new PdfPCell(new Phrase(quittance, normalTitle)); 
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabEntete.addCell(cell);
				  document.add(tabEntete);
				  
				//Date d'emission de la quittance
				  cell = new PdfPCell(new Phrase("Date: ", normalText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabEntete.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(sdf.format(reportingSante.getAvenant().getDateEmission()),smallText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabEntete.addCell(cell);
				  
				  document.add(tabEntete);
			  }

			  private  void creatTableInfo(Document document) throws DocumentException{
				//Info sur le Souscripteur
				  PdfPTable tabSous = new PdfPTable(4);
				  tabSous.setWidths(new int[]{15,20,15,20});

				  tabSous.getDefaultCell().setBorder(Cell.NO_BORDER);
				  PdfPCell cell;

				  //1er ligne
				  tabSous.addCell(new Phrase("Nom:", normalText));
				  cell = new PdfPCell(new Phrase(reportingSante.getNom(),smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  cell.setColspan(3);
				  tabSous.addCell(cell);

				  //2em ligne
				  tabSous.addCell(new Phrase("Adresse:", normalText));
				   cell = new PdfPCell(new Phrase(reportingSante.getPersonne().getAdresse(),smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabSous.addCell(cell);
				  tabSous.addCell(new Phrase("Tel:",normalText));
				  tabSous.addCell(new Phrase(reportingSante.getPersonne().getTelephone(),smallText));
				//3em ligne
				  tabSous.addCell(new Phrase("Mail:", normalText));
				   cell = new PdfPCell(new Phrase(reportingSante.getPersonne().getEmail(),smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabSous.addCell(cell);
				  tabSous.addCell(new Phrase("Fax:",normalText));
				  tabSous.addCell(new Phrase(reportingSante.getPersonne().getFax(),smallText));
				//4em ligne
				  tabSous.addCell(new Phrase("Intermédiaire:", normalText));
				   cell = new PdfPCell(new Phrase("IntermédiaireIci",smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabSous.addCell(cell);
				  tabSous.addCell(new Phrase("Réseaux:",normalText));
				  tabSous.addCell(new Phrase("ReseauxICI",smallText));
				  
				  
				  //Tableau général information
				  PdfPTable tabInfo = new PdfPTable(3);
				  tabInfo.setWidthPercentage(100);
				  tabInfo.setWidths(new int[]{48,1,47});

				//Entête du tableau
				  PdfPCell cellTitre = new PdfPCell(new Phrase("SOUSCRIPTEUR",normalTitle));
				  cellTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tabInfo.addCell(cellTitre);
				  tabInfo.addCell("");
				  cellTitre = new PdfPCell(new Phrase("REFFERENCES",normalTitle));
				  cellTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tabInfo.addCell(cellTitre);
				  
				//Info sur la quittance
				  PdfPTable tabQuit = new PdfPTable(4);
				  tabQuit.setWidths(new int[]{21,29,21,29});
				  tabQuit.getDefaultCell().setBorder(Cell.NO_BORDER);

				  
				  
					//1er ligne
				  tabQuit.addCell(new Phrase("Police:",normalText));
				  tabQuit.addCell(new Phrase(reportingSante.getContrat().getId(),smallText));
				  
				  tabQuit.addCell(new Phrase("Categorie:",normalText));
				  tabQuit.addCell(new Phrase(reportingSante.getRisque().getLibelleRisque(),smallText));
				  
				
				  
				//2em ligne
				  tabQuit.addCell(new Phrase("Avenant:", normalText));
				   cell = new PdfPCell(new Phrase(reportingSante.getAvenant().getId(),smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  
				  tabQuit.addCell(cell);
				  tabQuit.addCell(new Phrase("Mouvement:",normalText));
				  tabQuit.addCell(new Phrase(reportingSante.getAvenant().getMouvement(),smallText));
				  
				  //3e Ligne
				  tabQuit.addCell(new Phrase("Effet:", normalText));
				   cell = new PdfPCell(new Phrase(sdf.format(reportingSante.getAvenant().getEffet()),smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  
				  tabQuit.addCell(cell);
				  tabQuit.addCell(new Phrase("Echéance:",normalText));
				  tabQuit.addCell(new Phrase(sdf.format(reportingSante.getAvenant().getEcheance()),smallText));
				  
				  //4e Ligne
				  tabQuit.addCell(new Phrase("Barème:", normalText));
				   cell = new PdfPCell(new Phrase(reportingSante.getContrat().getBareme(),smallText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  
				  tabQuit.addCell(cell);
				  tabQuit.addCell(new Phrase("Durée:",normalText));
				  tabQuit.addCell(new Phrase(""+reportingSante.getAvenant().getDuree(),smallText));
				  
				  tabInfo.addCell(tabSous);
				  tabInfo.addCell("////");
				  tabInfo.addCell(tabQuit);
				  tabInfo.addCell("Tab quittance");

				  document.add(tabInfo);
			  }
			  
			  @SuppressWarnings("unused")
			public void createTableDetailPrime(Document document) throws DocumentException{				  
				  PdfPTable monTableau = new PdfPTable(8);
				  monTableau.setWidthPercentage(100);
				  monTableau.setWidths(new int[]{30,10,10,10,10,10,10,10});//Fixer la taille du taleau
				  PdfPCell  cell; 
				  PdfPCell celFL2;
				  
				  //Libellé du tableau
				  cell = new PdfPCell(new Phrase("Detail de la Prime",normalText));
				  cell.setColspan(8);
				  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				  cell.setBorder(Rectangle.NO_BORDER);
				  monTableau.addCell(cell);
				  
				  celFL2 = new PdfPCell(new Phrase("Libéllé garantie",normalText));
				  celFL2.setRowspan(2);
				  celFL2.setHorizontalAlignment(Element.ALIGN_LEFT);
				  monTableau.addCell(celFL2);
				  
				  celFL2 = new PdfPCell(new Phrase("Prime nette",normalText));
				  celFL2.setRowspan(2);
				  celFL2.setHorizontalAlignment(Element.ALIGN_CENTER);
				  monTableau.addCell(celFL2);
				  
				  //Gerer la fusion des collones
				  PdfPCell	celFC4;
				  celFC4 = new PdfPCell(new Phrase("Accesoires",normalText));
				  celFC4.setColspan(4);
				  celFC4.setHorizontalAlignment(Cell.ALIGN_CENTER);
				  monTableau.addCell(celFC4);
				  	
				  	celFL2 = new PdfPCell(new Phrase("Taxes",normalText));
					celFL2.setRowspan(2);
					celFL2.setHorizontalAlignment(Cell.ALIGN_CENTER);
				  	monTableau.addCell(celFL2);
				  	
				  	celFL2 = new PdfPCell(new Phrase("Prime Total",normalText));
					celFL2.setRowspan(2);
					celFL2.setHorizontalAlignment(Cell.ALIGN_CENTER);
				  	monTableau.addCell(celFL2);
				  	// deuxieme ligne
				  	cell = new PdfPCell(new Phrase("CNie",normalText));
				  	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  	monTableau.addCell(cell);
				  	cell = new PdfPCell(new Phrase("Interméd.",normalText));
				  	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  	monTableau.addCell(cell);
				  	cell = new PdfPCell(new Phrase("Gest°",normalText));
				  	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  	monTableau.addCell(cell);
				  	cell = new PdfPCell(new Phrase("Total",normalText));
				  	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  	monTableau.addCell(cell);
				  	
				  // Troisième Ligne
				  	monTableau.addCell(new Phrase(reportingSante.getRisque().getLibelleRisque(),normalText));
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getPrimeNette().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				  	monTableau.addCell(cell);
				  	
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccCnie().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccIntrerm().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccGestionnaire().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
				  	
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccessoire().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getTaxes().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
				  	cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getNetAPayer().toString(),smallText));
				  	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
				  	
				  	//Quatrième Lignes
				  	cell = new PdfPCell(new Phrase("Total",normalText));
					cell.setHorizontalAlignment(Rectangle.LEFT);
				  	monTableau.addCell(cell);
		
					cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getPrimeNette().toString(),smallTextGras));//Total prime nette
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
					cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccCnie().toString(),smallTextGras));//total compagnie
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
					cell = new PdfPCell(new Phrase("",smallText));// total intermediaire
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
					cell = new PdfPCell(new Phrase("",smallText));// toal gestion
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
					cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccessoire().toString(),smallTextGras));//Total
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
					cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getNetAPayer().toString(),smallTextGras));//Total taxe
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);
				  	
					cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getNetAPayer().toString(),smallTextGras));//Total général
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  	monTableau.addCell(cell);

				  	document.add(monTableau);
			  }
			  
			  
			  public void createTableCommis(Document document) throws DocumentException{
				  PdfPTable tableau = new PdfPTable(6);
				  tableau.setWidthPercentage(100);
				  tableau.setWidths(new int[]{25,15,15,15,15,15});//Fixer la taille du taleau
				  PdfPCell  cell; 
				  
				//Libellé du tableau
				  cell = new PdfPCell(new Phrase("Detail des commissions",normalText));
				  cell.setColspan(6);
				  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableau.addCell(cell);
				  
				  
				  //1ere ligne
				  cell = new PdfPCell(new Phrase("Libéllé de la catégorie",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Commission intermédiaire",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Commission conseiller",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Commission gestionnaire",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Commission d'apérition",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Total commision",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  tableau.addCell(cell);
				  
				  //2e Ligne
				  cell = new PdfPCell(new Phrase(reportingSante.getRisque().getLibelleRisque(),normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getComConseil().toString(),smallText));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getComConseil().toString(),smallText));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getComGestionnaire().toString(),smallText));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getComAperition().toString(),smallText));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  tableau.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getCommision().toString(),smallText));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  tableau.addCell(cell);
				  document.add(tableau);
				  
			  }
			  
			  
			  public  void createtableRecapPrime(Document document) throws DocumentException{
				  PdfPTable tableTotall = new PdfPTable(2);
				  PdfPCell cell;
				  
				  cell = new PdfPCell(new Phrase("Prime nette:",normalText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getPrimeNette().toString(),smallTextGras));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Accessoire:",normalText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getAccessoire().toString(),smallTextGras));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Taxe d'enregistrement:",normalText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getTaxes().toString(),smallTextGras));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  
				  cell = new PdfPCell(new Phrase("Prime TTC:",normalText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  cell = new PdfPCell(new Phrase(reportingSante.getQuittance().getNetAPayer().toString(),smallTextGras));
				  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tableTotall.addCell(cell);
				  
				  
				  //Tableau général
				  PdfPTable tabgeneral = new PdfPTable(3);
				  tabgeneral.setWidthPercentage(100);
				  tabgeneral.setWidths(new int[]{30,30,40});
				  PdfPCell cellVide = new PdfPCell();
				  cellVide.setBorder(Rectangle.NO_BORDER);
				  tabgeneral.addCell(cellVide);
				  tabgeneral.addCell(cellVide);
				  PdfPCell cellTotal = new PdfPCell();
				  cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				  cell.addElement(tableTotall);
				  tabgeneral.addCell(cell);
				  tabgeneral.setSpacingBefore(2);
				  document.add(tabgeneral); 
			  }
			  
			  
			  public  void addEmagement(Document document) throws DocumentException{
				  PdfPTable tabEmerg = new PdfPTable(3);
				  tabEmerg.setWidthPercentage(100);
				  PdfPCell cell;
				  
				  cell = new PdfPCell(new Phrase("L'Assuré(e)",normalText));
				  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabEmerg.addCell(cell);
				  cell = new PdfPCell(new Phrase(""));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabEmerg.addCell(cell);
				  cell = new PdfPCell(new Phrase("Pour la Compagnie",normalText));
				  cell.setBorder(Rectangle.NO_BORDER);
				  tabEmerg.addCell(cell);
				  
				  tabEmerg.setSpacingBefore(15);
				  document.add(tabEmerg);
			  }
			  
			  public void addEmptyLine(Paragraph paragraph, int number) {
			    for (int i = 0; i < number; i++) {
			      paragraph.add(new Paragraph(" "));
			    }
			  }
			    
			  
			  //Ouverture du fichier pdf de la quittance
			  
			  public void ouvrirFicher(){
				  System.out.println("début ouverture du fichier pdf");//clean After
				  try {
					  
						if ((new File("C:\\Etats\\Quittances\\SANTE\\"+nomFichier+"")).exists()) {
				 
							Process p = Runtime
							   .getRuntime()
							   .exec("rundll32 url.dll,FileProtocolHandler "+"C:\\Etats\\Quittances\\SANTE\\"+nomFichier+"");
							p.waitFor();
				 
						} else {
				 
							System.out.println("File is not exists");
				 
						}
				 
						System.out.println("Done");
				 
				  	  } catch (Exception ex) {
						ex.printStackTrace();
					  }
		
				  System.out.println("Fin ouverture du fichier pdf");
					
			  }
			  
			  
			  public void printFile(){
				  if(Desktop.isDesktopSupported()){
						if(Desktop.getDesktop().isSupported(java.awt.Desktop.Action.PRINT)){
						try {
							java.awt.Desktop.getDesktop().print(new File(repectoire+nomFichier));
						} catch (IOException ex) {
						    //Traitement de l'exception
						}
						} else {
							//La fonction n'est pas supportée par votre système d'exploitation
						}
					}else {
						//Desktop pas supportée par votre système d'exploitation
					}
			  }

			  
			  
			  
			  
		/*********************************ACCESSEURS****************************************/

			public BigDecimal getTotalAccessoir() {
				return totalAccessoir;
			}



			public void setTotalAccessoir(BigDecimal totalAccessoir) {
				this.totalAccessoir = totalAccessoir;
			}


			public String getIdQuittance() {
				return idQuittance;
			}

			public void setIdQuittance(String idQuittance) {
				this.idQuittance = idQuittance;
			}


			public ReportingSante getReportingSante() {
				return reportingSante;
			}

			public void setReportingSante(ReportingSante reportingSante) {
				this.reportingSante = reportingSante;
			}

			public ReportFactorySante getReportFactorySante() {
				return reportFactorySante;
			}

			public void setReportFactorySante(ReportFactorySante reportFactorySante) {
				this.reportFactorySante = reportFactorySante;
			}
			  
}
