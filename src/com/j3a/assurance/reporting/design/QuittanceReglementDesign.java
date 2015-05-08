package com.j3a.assurance.reporting.design;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.j3a.assurance.reporting.bean.QuittanceReglementReport;
import com.lowagie.text.Cell;

/**
 * 
 * @author J3A-POSTE1-A.Lekerand Bean permettant d'editer une quittance
 * 
 */

@Component
public class QuittanceReglementDesign implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	QuittanceReglementReport  quittanceReglementReport;

	
	private String idQuittance;
	private BigDecimal totalAccessoir;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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

	public void editerQuittance(String idQuittance, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Créer le dosier de stockage des fichier générés
		repectoire = new File("c:/Etats/RECUS");
		repectoire.mkdirs();
		
		// Passer les info nécessaires à notre rapport à générer
		
		try {
			Document document = new Document(PageSize.A4);
			document.setMargins(20, 20, 20, 20);
			nomFichier = "RQ-"+quittanceReglementReport.getQuittance().getId() + ".pdf";

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, baos);
			PdfWriter.getInstance(document, new FileOutputStream(repectoire + "/" + nomFichier));

			document.open();
			addContent(document);
			document.close();
			
			// setting some response headers response.setHeader("Expires", "0");
			  response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
//			  response.setHeader("Pragma", "public"); // setting the content type
			  response.setContentType("application/pdf"); // the contentlength
			  response.setContentLength(baos.size()); // write ByteArrayOutputStream to the ServletOutputStream 
			  OutputStream os = response.getOutputStream(); 
			  baos.writeTo(os);
			  os.flush();
			  os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur1");
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur2");

		}
	//	openFile();
		}	

	private void addContent(Document document) throws DocumentException,
			MalformedURLException, IOException {
		// Ajout de logo
		Image logo = Image.getInstance(new URL(RESOURCE));
		logo.scalePercent(40f);
		document.add(logo);

		// Entête du document
		creerTitreDocument(document);
		createEteteDoc(document);

		// Information de la quittance
		creatTableInfo(document);

		// Tableau des commissions
		createTableReglement(document);
		// Emagement
		addEmagement(document);

	}

	// Titre du document
	public void creerTitreDocument(Document document) throws DocumentException {

		Paragraph titreDocument = new Paragraph(new Chunk("REGLEMENT DE QUITTANCE", TITRE3));
		titreDocument.setAlignment(Element.ALIGN_CENTER);
		titreDocument.setSpacingAfter(30);
		document.add(titreDocument);
	}

	private void createEteteDoc(Document document) throws DocumentException {
		PdfPTable tabEntete = new PdfPTable(2);
		tabEntete.setWidthPercentage(100);
		tabEntete.setWidths(new int[] { 10, 90 });
		tabEntete.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		PdfPCell cell = new PdfPCell();
		tabEntete.addCell(new Phrase("Quittance N°:", normalText));
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getQuittance().getId(), smallText));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		tabEntete.addCell(cell);
		
		// Souscripteur
		tabEntete.addCell(new Phrase("Souscripteur:", normalText));
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getPersonne().getNomRaisonSociale()+" "+quittanceReglementReport.getPersonPhysique().getPrenomPers(),smallText));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		tabEntete.addCell(cell);
		
		// Num Police
		tabEntete.addCell(new Phrase("Police:", normalText));
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getAvenant().getNumPolice().getId(),smallText));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		tabEntete.addCell(cell);
		
		// Num Police
		tabEntete.addCell(new Phrase("Avenant:", normalText));
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getAvenant().getId(),smallText));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		tabEntete.addCell(cell);
		
		//Prise en compte du tableau
		tabEntete.setSpacingAfter(25);
		document.add(tabEntete);
	}

	private void creatTableInfo(Document document) throws DocumentException {
		// Info sur le Souscripteur
		PdfPTable tabSous = new PdfPTable(4);
		tabSous.getDefaultCell().setBorder(Cell.NO_BORDER);
		PdfPCell cell;

		// 1er ligne
		tabSous.addCell(new Phrase("Nom & Prénoms:", normalText));
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getPersonne().getNomRaisonSociale() + quittanceReglementReport.getPersonPhysique().getPrenomPers() , smallText));
		cell.setBorder(Rectangle.NO_BORDER);
		tabSous.addCell(cell);

		// 2e ligne
		tabSous.addCell(new Phrase("Police:", normalText));
		tabSous.addCell(new Phrase(quittanceReglementReport.getContrat().getId(), smallText));

		// 3em ligne
		tabSous.addCell(new Phrase("Avenant:", normalText));
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getAvenant().getId(),
				smallText));
		cell.setBorder(Rectangle.NO_BORDER);

		tabSous.addCell(cell);
		tabSous.addCell(new Phrase("Mouvement:", normalText));
		tabSous.addCell(new Phrase(quittanceReglementReport.getAvenant().getMouvement(),
				smallText));

		// 3e Ligne
		tabSous.addCell(new Phrase("Effet:", normalText));
		cell = new PdfPCell(new Phrase(sdf.format(quittanceReglementReport.getAvenant().getEffet()), smallText));
		cell.setBorder(Rectangle.NO_BORDER);

		tabSous.addCell(cell);
		tabSous.addCell(new Phrase("Echéance:", normalText));
		tabSous.addCell(new Phrase(sdf.format(quittanceReglementReport.getAvenant().getEcheance()), smallText));
		
	}

	public void createTableReglement(Document document) throws DocumentException {
		PdfPTable tableauReglem = new PdfPTable(6);
		tableauReglem.setWidthPercentage(100);
		tableauReglem.setWidths(new int[] { 15, 15, 15, 15, 15, 25 });// Fixer la taille du taleau
		PdfPCell cell;

		// Libellé du tableau
		cell = new PdfPCell(new Phrase("Detail du règlement", normalText));
		cell.setColspan(6);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setBorder(Rectangle.NO_BORDER);
		tableauReglem.addCell(cell);

		// 1ere ligne
		cell = new PdfPCell(new Phrase("Prime TTC", normalText));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase("Accomptes anterieures", normalText));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase("Solde", normalText));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase("Règlement", normalText));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase("Reste à payer", normalText));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase("Observation", normalText));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauReglem.addCell(cell);

		// 2e Ligne
		cell = new PdfPCell(new Phrase(quittanceReglementReport.getQuittance().getNetAPayer().toString(), normalText));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase(""+getQuittanceReglementReport().getAcompte(), smallText));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase(""+quittanceReglementReport.getSolde(), smallText));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase(""+quittanceReglementReport.getMontantReglement(), smallText));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableauReglem.addCell(cell);
		
		cell = new PdfPCell(new Phrase(""+quittanceReglementReport.getResteApayer(), smallText));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableauReglem.addCell(cell);

		cell = new PdfPCell(new Phrase("Quittance "+quittanceReglementReport.getEtatQuittance().toLowerCase(), smallText));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauReglem.addCell(cell);
		
		tableauReglem.setSpacingAfter(15);

		document.add(tableauReglem);

	}


	public void addEmagement(Document document) throws DocumentException {
		//Date du jour
		Paragraph dateEdition = new Paragraph(new Phrase("Fait à "+ quittanceReglementReport.getUtilisateur().getCodePointVente().getCodeVille().getLibelleVille()+", le "+ sdf.format(Calendar.getInstance().getTime()), normalText));
		dateEdition.setIndentationLeft(400);
		document.add(dateEdition);
		
		//Date du jour
		Paragraph signatureCaisier = new Paragraph("La caisse", normalText);
		signatureCaisier.setIndentationLeft(440);
		document.add(signatureCaisier);
	}


	// Ouverture du fichier pdf de la quittance

	public void ouvrirFicher() {
		System.out.println("début ouverture du fichier pdf");// clean After
		try {

			if ((new File("C:\\Etats\\RECUS\\" + nomFichier + ""))
					.exists()) {

				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler "
								+ "C:\\Etats\\RECUS\\" + nomFichier
								+ "");
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

	public QuittanceReglementReport getQuittanceReglementReport() {
		return quittanceReglementReport;
	}

	public void setQuittanceReglementReport(
			QuittanceReglementReport quittanceReglementReport) {
		this.quittanceReglementReport = quittanceReglementReport;
	}


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

	
}
