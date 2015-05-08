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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import com.j3a.assurance.model.ReglementSinistre;
import com.lowagie.text.Cell;

@Component
@Scope("request")
public class ManagedReglementInterventionPDF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String RESOURCE = "http://localhost:8080/Sherpa/resources/images/logo_j3a.jpg";
	private static Font smallText = new Font(Font.FontFamily.COURIER, 10,Font.NORMAL);
	private static Font normalText = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.BOLD);
	private File repectoire;
	private String nomFichier;
    private String regle;
    private static Font normalTitle = new Font(Font.FontFamily.TIMES_ROMAN, 9,Font.BOLD);
    private static Font TITRE3 = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.BOLD);
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	private static final String[] dizaineNames = {"","","vingt","trente","quarante","cinquante","soixante","soixante","quatre-vingt","quatre-vingt"};
	private BigDecimal resteApayer=new BigDecimal(0);
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
	
	
	  private static void addMetaData(Document document) {
			document.addTitle("Indemnisation Intervention");
			document.addSubject("Edition Pièces");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("J3A");
			document.addCreator("Foua Irene");

		}
	 public void editerRecu(ReglementSinistre reglementSinistre) throws DocumentException,IOException {
			// Créer le dosier de stockage des fichier générés
			repectoire = new File("c:/Etats/Reglement/Apporteur");
			repectoire.mkdirs();
			

			
			try {
				Document document = new Document(PageSize.A4.rotate());
				document.setMargins(20, 20, 20, 20);
				nomFichier = reglementSinistre.getId() + ".pdf";

				PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream(repectoire
						+ "/" + nomFichier));
				

				document.open();
				addMetaData(document);
				
				addContent(document,reglementSinistre);
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

	  
	  
	  private void addContent(Document document,ReglementSinistre reglementSinistre) throws DocumentException,
		MalformedURLException, IOException {
	// Ajout de logo
	Image logo = Image.getInstance(new URL(RESOURCE));
	logo.scalePercent(40f);
	document.add(logo);

	// Entête du document
	creerTitreDocument(document);
	createEteteDoc(document,reglementSinistre);

	// Tableau des reglements
	createTableAff(document,reglementSinistre);
    createsomme(document, reglementSinistre);
	
	// Emagement
	addEmagement(document);

}  
	  
	  public void createEteteDoc(Document document,ReglementSinistre reglementSinistre)
				throws DocumentException {
		  PdfPTable tableTotall = new PdfPTable(1);
			PdfPCell cell;
		  cell = new PdfPCell(new Phrase("N° Règlement: "+reglementSinistre.getId(), smallText));
			cell.setBorder(Rectangle.NO_BORDER);
			tableTotall.addCell(cell);

			cell = new PdfPCell(new Phrase("N° Sinistre: "+reglementSinistre.getRefIntervention().getCodeSinistre().getId(), smallText));
			cell.setBorder(Rectangle.NO_BORDER);
			tableTotall.addCell(cell);
			
			cell = new PdfPCell(new Phrase("N° Contrat: "+reglementSinistre.getRefIntervention().getCodeSinistre().getNumPolice().getId(), normalText));
			cell.setBorder(Rectangle.NO_BORDER);
			tableTotall.addCell(cell);
			

			cell = new PdfPCell(new Phrase("Date: "+sdf.format(Calendar.getInstance().getTime()), smallText));
			cell.setBorder(Rectangle.NO_BORDER);
			tableTotall.addCell(cell);
			
			tableTotall.setSpacingAfter(25);
			document.add(tableTotall);
			}

	 
	  
	// Titre du document
		public void creerTitreDocument(Document document) throws DocumentException {

			Paragraph titreDocument = new Paragraph(new Chunk("INDEMNISATION INTERVENANT", TITRE3));
			titreDocument.setAlignment(Element.ALIGN_CENTER);
			titreDocument.setSpacingAfter(30);
			document.add(titreDocument);
		}
	
	  private static void ajoutLigneVide(Paragraph paragraph, int number) {
			for (int i = 0; i < number; i++) {
				paragraph.add(new Paragraph(" "));}
			}
	  
	 
	
	  public void addEmagement(Document document) throws DocumentException {
			PdfPTable tabEmerg = new PdfPTable(3);
			tabEmerg.setWidthPercentage(100);
			PdfPCell cell;

			Chunk chunkSous = new Chunk("Assuré");
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

	  
	  private void createsomme(Document document, ReglementSinistre reglementSinistre) throws DocumentException {
			String quit = "Somme recue: "+ convert(reglementSinistre.getMontantReglement().longValue());
			PdfPTable tabEntete = new PdfPTable(1);

			PdfPCell cell = new PdfPCell();
			cell = new PdfPCell(new Phrase(quit, normalText));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			tabEntete.addCell(cell);
			document.add(tabEntete);
		}
	  
	  
	  
	  
	  public void createTableAff(Document document,ReglementSinistre reglementSinistre)
				throws DocumentException {
			PdfPTable monTableau = new PdfPTable(13);
			monTableau.setWidthPercentage(100);
			monTableau.setWidths(new int[] { 35, 35, 30, 30, 35, 35,35, 30, 30, 30, 30, 30,30 });// Fixer
																				// la
																				// taille
																				// du
																				// taleau
			PdfPCell cell;
			PdfPCell celFL2;

			// Libellé du tableau
			cell = new PdfPCell(new Phrase("Détail Intervenant", normalText));
			cell.setColspan(13);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			monTableau.addCell(cell);
			
			
			// Gerer la fusion des collones
						PdfPCell celFC4;
						celFC4 = new PdfPCell(new Phrase("Réference intervention", normalText));
						celFC4.setRowspan(2);
						celFC4.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFC4.setHorizontalAlignment(Cell.ALIGN_CENTER);
						monTableau.addCell(celFC4);
						
						celFL2 = new PdfPCell(new Phrase("Intervenant", normalText));
						celFL2.setColspan(3);
						celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFL2.setHorizontalAlignment(Cell.ALIGN_CENTER);
						monTableau.addCell(celFL2);

						celFL2 = new PdfPCell(new Phrase("Libellé intervention", normalText));
						celFL2.setRowspan(2);
						celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFL2.setHorizontalAlignment(Element.ALIGN_LEFT);
						monTableau.addCell(celFL2);
					
						celFL2 = new PdfPCell(new Phrase("Date Intervention", normalText));
						celFL2.setRowspan(2);
						celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFL2.setHorizontalAlignment(Cell.ALIGN_CENTER);
						monTableau.addCell(celFL2);

						celFL2 = new PdfPCell(new Phrase("Détails des frais", normalText));
						celFL2.setColspan(4);
						celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFL2.setHorizontalAlignment(Cell.ALIGN_CENTER);
						monTableau.addCell(celFL2);

						celFL2 = new PdfPCell(new Phrase("Solde", normalText));
						celFL2.setRowspan(2);
						celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFL2.setHorizontalAlignment(Element.ALIGN_LEFT);
						monTableau.addCell(celFL2);
						celFL2 = new PdfPCell(new Phrase("Montant payé", normalText));
						celFL2.setRowspan(2);
						celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
						celFL2.setHorizontalAlignment(Cell.ALIGN_CENTER);
						monTableau.addCell(celFL2);

			

			celFL2 = new PdfPCell(new Phrase("Reste", normalText));
			celFL2.setRowspan(2);
			celFL2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			celFL2.setHorizontalAlignment(Element.ALIGN_CENTER);
			monTableau.addCell(celFL2);
			//deuxième ligne
						cell = new PdfPCell(new Phrase("Code Intervenant", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						cell = new PdfPCell(new Phrase("Nom Intervenant", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						
						cell = new PdfPCell(new Phrase("Contact", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						
						cell = new PdfPCell(new Phrase("Charge Intervention", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						cell = new PdfPCell(new Phrase("Frais", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						
						cell = new PdfPCell(new Phrase("Taxe", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						cell = new PdfPCell(new Phrase("Montant TTC ", normalText));
						cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						monTableau.addCell(cell);
						
						
			// Troisième Ligne
			monTableau.addCell(new Phrase(reglementSinistre.getRefIntervention().getId(), normalText));
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getCodeIntervenant().getId(),smallText));// prime nette
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);

			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getCodeIntervenant().getNomIntervenant(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getCodeIntervenant().getContactIntervenant(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getLibelleIntervention(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getDateIntervention().toString(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getChargesIntervention().toString(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getFraisAnnexe().toString(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getTaxe().toString(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(reglementSinistre.getRefIntervention().getMontantTtc().toString(), smallText));														
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			
			List<ReglementSinistre> listReglement=new ArrayList<>(reglementSinistre.getRefIntervention().getReglementSinistres());
			if(listReglement.size()==0){
				resteApayer=reglementSinistre.getRefIntervention().getMontantTtc();
			}
			else if(listReglement.size()!=0){
			for( ReglementSinistre reglementSinistre1:listReglement){
				resteApayer=resteApayer.subtract(reglementSinistre1.getMontantReglement());
			System.out.println("listeeeeeeee"+resteApayer);
			}
			}
			
			
			cell = new PdfPCell(new Phrase(getResteApayer().toString(), smallText));			
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
		
		
			cell = new PdfPCell(new Phrase(reglementSinistre.getMontantReglement().toString(), smallText));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
			
			cell = new PdfPCell(new Phrase(getResteApayer().subtract(reglementSinistre.getMontantReglement()).toString(), smallText));// prime
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			monTableau.addCell(cell);
		
			monTableau.setSpacingAfter(25);
			document.add(monTableau);
		}

	public static Font getSmallText() {
		return smallText;
	}

	public static void setSmallText(Font smallText) {
		ManagedReglementInterventionPDF.smallText = smallText;
	}

	public static Font getNormalText() {
		return normalText;
	}

	public static void setNormalText(Font normalText) {
		ManagedReglementInterventionPDF.normalText = normalText;
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

	public static Font getNormalTitle() {
		return normalTitle;
	}

	public static void setNormalTitle(Font normalTitle) {
		ManagedReglementInterventionPDF.normalTitle = normalTitle;
	}

	public static Font getTITRE3() {
		return TITRE3;
	}

	public static void setTITRE3(Font tITRE3) {
		TITRE3 = tITRE3;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public BigDecimal getResteApayer() {
		return resteApayer;
	}

	public void setResteApayer(BigDecimal resteApayer) {
		this.resteApayer = resteApayer;
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
	  
	  
	  

	
	
}
