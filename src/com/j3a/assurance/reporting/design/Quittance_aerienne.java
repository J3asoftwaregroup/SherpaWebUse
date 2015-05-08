package com.j3a.assurance.reporting.design;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.j3a.assurance.objetService.ObjectService;
import com.lowagie.text.Cell;

public class Quittance_aerienne {
	ObjectService objectService;
	private static Logger logger = Logger.getLogger(Quittance_aerienne.class);
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
	//private QuittanceReportFactory quittanceReportFactory;
	//private static QuittanceReport reportField;	
	private static Font textFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.ITALIC);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.BOLDITALIC, BaseColor.BLACK);
	private static int compteur;
	private String chemainPDF;
	private static final String[] dizaineNames = {"","","vingt","trente","quarante","cinquante","soixante","soixante","quatre-vingt","quatre-vingt"};

	  private static final String[] uniteNames1 = { "","un","deux","trois","quatre","cinq","six","sept","huit","neuf","dix","onze","douze", "treize",
	    "quatorze","quinze","seize","dix-sept","dix-huit","dix-neuf"};

	  private static final String[] uniteNames2 = { "","","deux","trois","quatre","cinq","six","sept","huit","neuf","dix"};

	  private static String convertZeroToHundred(int number) {

	    int laDizaine = number / 10;
	    int lUnite = number % 10;
	    String resultat = "";

	    switch (laDizaine) {
	    case 1 :
	    case 7 :
	    case 9 :
	      lUnite = lUnite + 10;
	      break;
	    default:
	    } // séparateur "-" "et"  ""
	    String laLiaison = "";
	    if (laDizaine > 1) {
	      laLiaison = "-";
	    }
	    // cas particuliers
	    switch (lUnite) {
	    case 0:
	      laLiaison = "";
	      break;
	    case 1 :
	      if (laDizaine == 8) {
	        laLiaison = "-";
	      }
	      else {
	        laLiaison = " et ";
	      }
	      break;
	    case 11 :
	      if (laDizaine==7) {
	        laLiaison = " et ";
	      }
	      break;
	    default:
	    }

	    // dizaines en lettres
	    switch (laDizaine) {
	    case 0:
	      resultat = uniteNames1[lUnite];
	      break;
	    case 8 :
	      if (lUnite == 0) {
	        resultat = dizaineNames[laDizaine];
	      }
	      else {
	        resultat = dizaineNames[laDizaine] 
	                                + laLiaison + uniteNames1[lUnite];
	      }
	      break;
	    default :
	      resultat = dizaineNames[laDizaine] 
	                              + laLiaison + uniteNames1[lUnite];
	    }
	    return resultat;
	  }

	  private static String convertLessThanOneThousand(int number) {

	    int lesCentaines = number / 100;
	    int leReste = number % 100;
	    String sReste = convertZeroToHundred(leReste);

	    String resultat;
	    switch (lesCentaines) {
	    case 0:
	      resultat = sReste;
	      break;
	    case 1 :
	      if (leReste > 0) {
	        resultat = "cent " + sReste;
	      }
	      else {
	        resultat = "cent";
	      }
	      break;
	    default :
	      if (leReste > 0) {
	        resultat = uniteNames2[lesCentaines] + " cent " + sReste;
	      }
	      else {
	        resultat = uniteNames2[lesCentaines] + " cents";
	      }
	    }
	    return resultat;
	  }

	  public static String convert(long number) {
	    // 0 à 999 999 999 999
	    if (number == 0) { return "zéro"; }

	    String snumber = Long.toString(number);

	    // pad des "0"
	    String mask = "000000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(number);

	    // XXXnnnnnnnnn 
	    int lesMilliards = Integer.parseInt(snumber.substring(0,3));
	    // nnnXXXnnnnnn
	    int lesMillions  = Integer.parseInt(snumber.substring(3,6)); 
	    // nnnnnnXXXnnn
	    int lesCentMille = Integer.parseInt(snumber.substring(6,9)); 
	    // nnnnnnnnnXXX
	    int lesMille = Integer.parseInt(snumber.substring(9,12));    

	    String tradMilliards;
	    switch (lesMilliards) {
	    case 0:
	      tradMilliards = "";
	      break;
	    case 1 :
	      tradMilliards = convertLessThanOneThousand(lesMilliards) 
	      + " milliard ";
	      break;
	    default :
	      tradMilliards = convertLessThanOneThousand(lesMilliards) 
	      + " milliards ";
	    }
	    String resultat =  tradMilliards;

	    String tradMillions;
	    switch (lesMillions) {
	    case 0:
	      tradMillions = "";
	      break;
	    case 1 :
	      tradMillions = convertLessThanOneThousand(lesMillions) 
	      + " million ";
	      break;
	    default :
	      tradMillions = convertLessThanOneThousand(lesMillions) 
	      + " millions ";
	    }
	    resultat =  resultat + tradMillions;

	    String tradCentMille;
	    switch (lesCentMille) {
	    case 0:
	      tradCentMille = "";
	      break;
	    case 1 :
	      tradCentMille = "mille ";
	      break;
	    default :
	      tradCentMille = convertLessThanOneThousand(lesCentMille) 
	      + " mille ";
	    }
	    resultat =  resultat + tradCentMille;

	    String tradMille;
	    tradMille = convertLessThanOneThousand(lesMille);
	    resultat =  resultat + tradMille;

	    return resultat;
	  }

	
	public void generateRapport()throws DocumentException,IOException{
		System.out.println("****************************************");
		
		
		File dir = new File("c:/reports/quittances");
		dir.mkdirs();
		try {
			// On instancie le nouveau "Document"
			Document document = new Document(PageSize.A4);
			// On instancie le nouveau "PdfWriter"
			
			
			PdfWriter writer= PdfWriter.getInstance(document,new FileOutputStream("d:/report.pdf"));
			
			// On ouvre notre "Document"
			document.open();
			//on cree le document
			
			ajoutTitre(document);
			essaie(document);
			Paragraph paragraph = new Paragraph();
			ajoutLigneVide(paragraph, 0);
			document.add(paragraph);
			Paragraph paragraph1 = new Paragraph();
			ajoutLigneVide(paragraph1, 0);
			document.add(paragraph1);
			ajoutTab2(document);
			ajoutTab3(document);
			ajout(document);
			ajout1(document);
			ajout3(document);
			PdfContentByte cb = writer.getDirectContent();
			 Barcode128 code128 = new Barcode128();
			    code128.setCodeType(code128.CODE128);
			    code128.setCodeType(Calendar.DATE);
			    Image imageEAN = code128.createImageWithBarcode(cb, null, null);
			    document.add(new Chunk(imageEAN, 0, 0));
			document.close();
			System.out.println("rapport généré");
			logger.info("quittance générée");
		
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			logger.error("erreur de génération de la quittance");
			e.printStackTrace();
		}
	}         
	  
	
	private static void ajoutTitre(Document document) throws DocumentException {
		PdfPTable table = new PdfPTable(3);
		table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Facture N°:"));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setColspan(3);
		table.addCell(cell);
		table.setSpacingAfter(8);
		document.add(table);
	}
	private static void ajout(Document document) throws DocumentException {
		PdfPTable table = new PdfPTable(3);
		table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("PRIME TOTALE A PAYER:"));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setColspan(3);
		table.addCell(cell);
		table.setSpacingAfter(8);
		document.add(table);
	}
	private static void essaie(Document document) throws DocumentException{
	    PdfPTable conteneur= new PdfPTable(1);
		PdfPTable table = new PdfPTable(2);
		 table.getDefaultCell().setBorder(Cell.NO_BORDER);
		 PdfPCell cell;
			
		//1ere ligne
		cell=new PdfPCell(createCell((Phrase) ajoutElement("Phrase","Assuré ou Souscripteur",smallBold),1));
	    cell.setRowspan(2);
	    conteneur.addCell(cell);
	    cell=new PdfPCell(new Phrase(""));
		cell.setColspan(2);
	  //2ième ligne
		table.addCell(new Phrase("N° Souscripteur", smallBold));
		cell = new PdfPCell(new Phrase("",smallBold));
		cell.setBorder(cell.NO_BORDER);
	    table.addCell(cell);
	    
	    //3ième
		table.addCell(new Phrase( "Souscripteur", smallBold));
		cell = new PdfPCell(new Phrase("",smallBold));
		cell.setBorder(cell.NO_BORDER);
	    table.addCell(cell);
		conteneur.addCell(table);
		conteneur.setSpacingAfter(8);
		document.add(conteneur);
	}
	
	private static void ajoutLigneVide(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));}
		}
         
	private void ajout1(Document document) throws DocumentException {
		
		PdfPTable table1 = new PdfPTable(2);
		 table1.getDefaultCell().setBorder(Cell.NO_BORDER);
		PdfPCell cell;
		cell=new PdfPCell(new Phrase(""));
		cell.setColspan(2);
		
		table1.addCell(new Phrase("Arrêté la Présente facture à la somme de :", textFont));
		table1.addCell(new Phrase(convert(1510885),textFont));
		//table1.addCell(table1);
		table1.setSpacingAfter(8);
		document.add(table1);
	}
	
	
	
	private void ajout3(Document document) throws DocumentException {
		PdfPTable conteneur=new PdfPTable(1);
		conteneur.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		conteneur.setHorizontalAlignment(Element.ALIGN_RIGHT);
		conteneur.setWidthPercentage(30);
		PdfPCell cell;
		cell=new PdfPCell(new Phrase(""));
		cell.setColspan(2);
		
		document.add(new Phrase("Conformément à l'Article 13 du Code CIMA, la prime est payable au comptant A défaut de paiement de la présente" +
				" prime dans la limite des 10 jours au plus tard après l'échéance de la facture, nous serons dans l'obligation de vous envoyer une " +
				"mise en demeure valant suspension de la garantie 30 jours après.",textFont));
		document.add(new Paragraph("PS: Dans le cas où vous auriez déjà fait parvenir votre paiement, veuillez considérer que ce rappel est sans objet.", textFont));
		document.add(new Paragraph("PJ: Double de notre facture N°:..........", textFont));
		document.add(new Paragraph("La prise d'éffet du contrat est subordonnée au paiement de la prime par l'assuré.", textFont));
		conteneur.setSpacingBefore(12);
		conteneur.addCell(new Phrase("Fait à Abidjan ,le"+Calendar.getInstance().getTime()+"",textFont));
		conteneur.addCell(new Phrase(""));
		conteneur.addCell(new Phrase("Pour la Compagnie"));
		conteneur.addCell(new Phrase(""));
		conteneur.addCell(new Phrase(""));
		conteneur.addCell(new Phrase("j3A"));
		//cell.setColspan(2);
		document.add(conteneur);
	}
	

	private void ajoutTab2(Document document) throws DocumentException {
		PdfPTable conteneur=new PdfPTable(1);
		conteneur.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
	
		PdfPTable table1 = new PdfPTable(4);
		table1.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		 table1.getDefaultCell().setBorder(Cell.NO_BORDER);
		PdfPCell cell;
		cell=new PdfPCell(createCell((Phrase) ajoutElement("Phrase", "Références police et périodicité",smallBold), 1));
		cell.setColspan(4);
		conteneur.addCell(cell);
		
		cell=new PdfPCell(new Phrase(""));
		cell.setColspan(4);
		
		table1.addCell(new Phrase("Au titre de la police", smallBold));
		table1.addCell(new Phrase("",textFont));
		table1.addCell(new Phrase("Numéro", smallBold));
		table1.addCell(new Phrase("",textFont));
		table1.addCell(new Phrase ("Avenant", smallBold));
		table1.addCell(new Phrase("",textFont));
		table1.addCell(new Phrase( "Pour la période allant du", smallBold));
		table1.addCell(new Phrase("" , textFont));
		table1.addCell(new Phrase( "Au", smallBold));
		table1.addCell(new Phrase("", textFont));
		table1.setSpacingAfter(8);
		conteneur.addCell(table1);
		conteneur.setSpacingAfter(8);
		document.add(conteneur);
		System.out.println("tableau 2 ajouté");

	}

	

	private void ajoutTab3(Document document) throws DocumentException {
		PdfPTable conteneur=new PdfPTable(1);
		conteneur.setWidthPercentage(50);
		PdfPTable table = new PdfPTable(2);
		table.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);

		table.getDefaultCell().setBorder(Cell.NO_BORDER);
		PdfPCell cell;
		cell = new PdfPCell(createCell((Phrase) ajoutElement("Phrase","Détail de facture", smallBold), 1));
		cell.setColspan(2);
		conteneur.addCell(cell);
		cell=new PdfPCell(new Phrase(""));
		cell.setColspan(2);
		table.addCell(new Phrase("Prime Nette", smallBold));
		table.addCell(new Phrase("", textFont));
		table.addCell(new Phrase( "Accessoires", smallBold));
		table.addCell(new Phrase("", textFont));
		table.addCell(new Phrase( "Taxes d'enregistrement", smallBold));
		table.addCell(new Phrase( "",textFont));
		table.addCell(new Phrase( "Prime TTC", smallBold));
		table.addCell(new Phrase("", smallBold));
		//table.
		conteneur.addCell(table);
		conteneur.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
		conteneur.setSpacingAfter(8);
		document.add(conteneur);
		System.out.println("tableau 3 ajouté");
	}

	/* Aide à la création d'une cellule */
	private static PdfPCell createCell(Phrase phrase, int colspan) {
		PdfPCell cell = new PdfPCell(phrase);
		cell.setBorder(Rectangle.NO_BORDER);
		
		cell.setColspan(colspan);
		// cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		return cell;
	}

	/* construction d'un element */
	private static Element ajoutElement(String elementType, String elementName,
			Font font) {
		if (elementType.equals("Phrase")) {
			Phrase phrase = new Phrase();
			phrase.setFont(font);
			Chunk chunk = new Chunk(elementName);
			phrase.add(chunk);
			return phrase;
		}
		if (elementType.equals("Paragraph")) {
			Paragraph paragraph = new Paragraph();
			Chunk chunk = new Chunk(elementName);
			paragraph.add(chunk);
			paragraph.setFont(font);
			return paragraph;
		}

		return null;
	}
	
	public void convertnombre(){}
	
		public static Font getCatFont() {
			return catFont;
		}


		public static void setCatFont(Font catFont) {
			Quittance_aerienne.catFont = catFont;
		}


		public static Font getSubFont() {
			return subFont;
		}


		public static void setSubFont(Font subFont) {
			Quittance_aerienne.subFont = subFont;
		}


		public static Font getSmallBold() {
			return smallBold;
		}


		public static void setSmallBold(Font smallBold) {
			Quittance_aerienne.smallBold = smallBold;
		}


		public ObjectService getObjectService() {
			return objectService;
		}


		public void setObjectService(ObjectService objectService) {
			this.objectService = objectService;
		}



		


		public String getChemainPDF() {
			return chemainPDF;
		}


		public void setChemainPDF(String chemainPDF) {
			this.chemainPDF = chemainPDF;
		}


		public static int getCompteur() {
			return compteur;
		}


		public static void setCompteur(int compteur) {
			Quittance_aerienne.compteur = compteur;
		}
		
		
}


