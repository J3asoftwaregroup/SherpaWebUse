package com.j3a.assurance.reporting.design;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.j3a.assurance.model.AffaireApporteur;
import com.lowagie.text.Cell;


@Component
@Scope("request")
public class ReglementApporteurCommission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String regle;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
	private File repectoire;
	private String nomFichier;
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

	private static Font smallText = new Font(Font.FontFamily.COURIER, 8,
			Font.NORMAL);

	private static Font smallTextGras = new Font(Font.FontFamily.COURIER, 8,
			Font.BOLD);

	private static Font TITRE3 = new Font(Font.FontFamily.TIMES_ROMAN, 14,
			Font.BOLD);

	public static final String RESOURCE = "http://localhost:8080/Sherpa/resources/images/logo_j3a.jpg";
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
	
	
	  public void editerRecu(AffaireApporteur affaireApporteur) throws DocumentException,IOException {
			// Créer le dosier de stockage des fichier générés
			repectoire = new File("c:/Etats/Reglement/Apporteur");
			repectoire.mkdirs();
			

			
			try {
				Document document = new Document(PageSize.A4);
				document.setMargins(20, 20, 20, 20);
				nomFichier = affaireApporteur.getId() + ".pdf";

				PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream(repectoire
						+ "/" + nomFichier));
				

				document.open();
				
				
				addContent(document,affaireApporteur);
				document.close();

				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Erreur1");
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erreur2");

			}
			openFile();
			}
		
	  
	  public void openFile() {

			if (Desktop.isDesktopSupported()) {
				if (Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)) {
					try {
						java.awt.Desktop.getDesktop().open(
								new File(repectoire + "/" + nomFichier));
					} catch (IOException ex) {
						// Traitement de l'exception
					}
				} else {
					// La fonction n'est pas supportée par votre système
					// d'exploitation
				}
			} else {
				// Desktop pas supportée par votre système d'exploitation
			}
		}

	  
	  
	  private void addContent(Document document,AffaireApporteur affaireApporteur) throws DocumentException,
		MalformedURLException, IOException {
	// Ajout de logo
	Image logo = Image.getInstance(new URL(RESOURCE));
	logo.scalePercent(40f);
	document.add(logo);

	// Entête du document
	creerTitreDocument(document);
	createEteteDoc(document,affaireApporteur);

	// Information de la quittance
	creatTableInfo(document,affaireApporteur);

	// Tableau des commissions
	createTableAff(document,affaireApporteur);
    createsomme(document, affaireApporteur);
	
	// Emagement
	addEmagement(document);

}  
	  private void createEteteDoc(Document document,AffaireApporteur affaireApporteur) throws DocumentException {
			String quit = "Règlement N° "+ affaireApporteur.getId();
			PdfPTable tabEntete = new PdfPTable(1);

			PdfPCell cell = new PdfPCell();
			cell = new PdfPCell(new Phrase(quit, smallText));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			tabEntete.addCell(cell);


			cell = new PdfPCell(new Phrase("Date: "+ sdf.format(affaireApporteur.getDateAff()),smallText));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			tabEntete.addCell(cell);
			tabEntete.setSpacingAfter(25);
			document.add(tabEntete);
		}
	  
	// Titre du document
		public void creerTitreDocument(Document document) throws DocumentException {

			Paragraph titreDocument = new Paragraph(new Chunk("REGLEMENT", TITRE3));
			titreDocument.setAlignment(Element.ALIGN_CENTER);
			titreDocument.setSpacingAfter(30);
			document.add(titreDocument);
		}
	
	  private static void ajoutLigneVide(Paragraph paragraph, int number) {
			for (int i = 0; i < number; i++) {
				paragraph.add(new Paragraph(" "));}
			}
	  
	  
	  private void creatTableInfo(Document document,AffaireApporteur affaireApporteur) throws DocumentException {
			// Info sur le Souscripteur
			PdfPTable tabSous = new PdfPTable(4);
			tabSous.setWidths(new int[] { 15, 20, 15, 20 });

			tabSous.getDefaultCell().setBorder(Cell.NO_BORDER);
			PdfPCell cell;

			// 1er ligne
			tabSous.addCell(new Phrase("Nom:", normalText));
			cell = new PdfPCell(new Phrase(affaireApporteur.getCodeApporteur().getLibelleApporteur(), smallText));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setColspan(3);
			tabSous.addCell(cell);

			// 2em ligne
			tabSous.addCell(new Phrase("Adresse:", normalText));
			cell = new PdfPCell(new Phrase(
					affaireApporteur.getCodeApporteur().getAdresseApporteur(), smallText));
			cell.setBorder(Rectangle.NO_BORDER);
			tabSous.addCell(cell);
			tabSous.addCell(new Phrase("Tel:", normalText));
			tabSous.addCell(new Phrase(affaireApporteur.getCodeApporteur().getContactApporteur(),
					smallText));
			

			// Tableau général information
			PdfPTable tabInfo = new PdfPTable(3);
			tabInfo.setWidthPercentage(100);
			tabInfo.setWidths(new int[] { 48, 1, 47 });

			// Entête du tableau
			PdfPCell cellTitre = new PdfPCell(new Phrase("APPORTEUR",
					normalTitle));
			cellTitre.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cellTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabInfo.addCell(cellTitre);
			tabInfo.addCell("");
			cellTitre = new PdfPCell(new Phrase("COMPTE", normalTitle));
			cellTitre.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cellTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
			tabInfo.addCell(cellTitre);

			// Info sur la quittance
			PdfPTable tabQuit = new PdfPTable(4);
			tabQuit.setWidths(new int[] { 21, 29, 21, 29 });
			tabQuit.getDefaultCell().setBorder(Cell.NO_BORDER);

			// 1er ligne
			tabQuit.addCell(new Phrase("N°:", normalText));
			tabQuit.addCell(new Phrase(affaireApporteur.getCodeApporteur().getCodeCompteApp().getId(),
					smallText));

			tabQuit.addCell(new Phrase("Reste à payer:", normalText));
			tabQuit.addCell(new Phrase(affaireApporteur.getCodeApporteur().getCodeCompteApp().getResteComPaye().toString(), smallText));

			// 2em ligne
			tabQuit.addCell(new Phrase("Montant commission:", normalText));
			cell = new PdfPCell(new Phrase(affaireApporteur.getCodeApporteur().getCodeCompteApp().getTotalComApp().toString(),
					smallText));
			cell.setBorder(Rectangle.NO_BORDER);

			tabQuit.addCell(cell);
			tabQuit.addCell(new Phrase("Montant Recu:", normalText));
			tabQuit.addCell(new Phrase(affaireApporteur.getCodeApporteur().getCodeCompteApp().getTotalComPaye().toString(),
					smallText));
			tabInfo.addCell(tabSous);

			cell = new PdfPCell(new Phrase(""));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tabInfo.addCell(cell);
			tabInfo.addCell(tabQuit);
			tabInfo.addCell("Tab quittance");

			tabInfo.setSpacingAfter(25);
			document.add(tabInfo);
		} 
	  
	  
	  
	  public void createTableAff(Document document,AffaireApporteur affaireApporteur) throws DocumentException {
			PdfPTable tableau = new PdfPTable(6);
			tableau.setWidthPercentage(100);
			tableau.setWidths(new int[] { 10, 20, 25, 15, 15, 15 });// Fixer la
																	// taille du
																	// taleau
			PdfPCell cell;

			// Libellé du tableau
			cell = new PdfPCell(new Phrase("Detail de l'affaire", normalText));
			cell.setColspan(6);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			tableau.addCell(cell);

			// 1ere ligne
			cell = new PdfPCell(new Phrase("Code", normalText));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase("N° Police", normalText));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase("N° Avenant", normalText));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase("Montant Commission", normalText));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase("Date", normalText));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase("Mouvement", normalText));
			cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableau.addCell(cell);

			// 2e Ligne
			cell = new PdfPCell(new Phrase(affaireApporteur.getId(),
					normalText));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase(affaireApporteur.getNumeroPoliceAff(), smallText));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase(affaireApporteur.getNumAvenantAff(), smallText));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase(affaireApporteur.getComAff().toString(), smallText));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase(sdf.format(affaireApporteur.getDateAff())));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableau.addCell(cell);

			cell = new PdfPCell(new Phrase(affaireApporteur.getMouvementAffApp().toString(), smallText));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableau.addCell(cell);
			document.add(tableau);

		}

	  public void addEmagement(Document document) throws DocumentException {
			PdfPTable tabEmerg = new PdfPTable(3);
			tabEmerg.setWidthPercentage(100);
			PdfPCell cell;

			Chunk chunkSous = new Chunk("L'Apporteur");
			chunkSous.setUnderline(0.1f, -2f);
			cell = new PdfPCell(new Phrase(chunkSous));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Rectangle.NO_BORDER);
			tabEmerg.addCell(cell);

			cell = new PdfPCell(new Phrase(""));
			cell.setBorder(Rectangle.NO_BORDER);
			tabEmerg.addCell(cell);

			Chunk chunkComp = new Chunk("Pour la Compagnie");
			chunkComp.setUnderline(0.1f, -2);
			cell = new PdfPCell(new Phrase(chunkComp));
			cell.setBorder(Rectangle.NO_BORDER);
			tabEmerg.addCell(cell);

			tabEmerg.setSpacingBefore(15);
			// document.add(dateJour);
			document.add(tabEmerg);

		}

	  
	  private void createsomme(Document document, AffaireApporteur affaireApporteur) throws DocumentException {
			String quit = "Somme recue: "+ convert(affaireApporteur.getComAff().longValue());
			PdfPTable tabEntete = new PdfPTable(1);

			PdfPCell cell = new PdfPCell();
			cell = new PdfPCell(new Phrase(quit, normalText));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			tabEntete.addCell(cell);
			document.add(tabEntete);
		}

	public static Font getCatFont() {
		return catFont;
	}

	public static void setCatFont(Font catFont) {
		ReglementApporteurCommission.catFont = catFont;
	}

	public static Font getRedFont() {
		return redFont;
	}

	public static void setRedFont(Font redFont) {
		ReglementApporteurCommission.redFont = redFont;
	}

	public static Font getSubFont() {
		return subFont;
	}

	public static void setSubFont(Font subFont) {
		ReglementApporteurCommission.subFont = subFont;
	}

	public static Font getSmallBold() {
		return smallBold;
	}

	public static void setSmallBold(Font smallBold) {
		ReglementApporteurCommission.smallBold = smallBold;
	}

	public static Font getNormalText() {
		return normalText;
	}

	public static void setNormalText(Font normalText) {
		ReglementApporteurCommission.normalText = normalText;
	}

	public static Font getNormalTitle() {
		return normalTitle;
	}

	public static void setNormalTitle(Font normalTitle) {
		ReglementApporteurCommission.normalTitle = normalTitle;
	}

	public static Font getSmallText() {
		return smallText;
	}

	public static void setSmallText(Font smallText) {
		ReglementApporteurCommission.smallText = smallText;
	}

	public static Font getSmallTextGras() {
		return smallTextGras;
	}

	public static void setSmallTextGras(Font smallTextGras) {
		ReglementApporteurCommission.smallTextGras = smallTextGras;
	}

	public static Font getTITRE3() {
		return TITRE3;
	}

	public static void setTITRE3(Font tITRE3) {
		TITRE3 = tITRE3;
	}

	public static String getResource() {
		return RESOURCE;
	}

	public static String[] getDizainenames() {
		return dizaineNames;
	}

	public static String[] getUnitenames1() {
		return uniteNames1;
	}

	public static String[] getUnitenames2() {
		return uniteNames2;
	}

	

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public File getRepectoire() {
		return repectoire;
	}

	public void setRepectoire(File repectoire) {
		this.repectoire = repectoire;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	public String getRegle() {
		return regle;
	}

	public void setRegle(String regle) {
		this.regle = regle;
	}
	
	
}
