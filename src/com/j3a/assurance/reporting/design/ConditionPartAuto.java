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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.j3a.assurance.model.ConduireVehicule;
import com.j3a.assurance.model.Garantie;
import com.j3a.assurance.model.GarantieChoisie;
import com.j3a.assurance.model.GarantieGarantieChoisie;
import com.j3a.assurance.model.SousCatVehicule;
import com.j3a.assurance.model.Vehicule;
import com.j3a.assurance.model.VehiculeZoneGeographique;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.reporting.bean.ReportingAuto;
import com.j3a.assurance.reporting.bean.factory.ReportFactoryAuto;
import com.lowagie.text.Cell;

/**
 * 
 * @author J3A-POSTE1-A.Lekerand Bean permettant d'editer une quittance
 * 
 */

@Component
public class ConditionPartAuto implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	// Injection par spring
	@Autowired
	ObjectService objectService;
	@Autowired
	ReportFactoryAuto reportFactoryAuto;
	@Autowired
	ReportingAuto reportingAuto;
	

	// Attribut d'instance
	private String idQuittance; // Détacher pour les tests (parametre d'edition)
	private File repectoire;
	private Float primeTTC = new Float(0);
	private String nomFichier;
	private BigDecimal totalAccessoir;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	public static final String RESOURCE = "http://localhost:8080/Sherpa/resources/images/logo_j3a.jpg";

	// Pour la mise en forme
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
	private static Font normalText1 = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL);
	private static Font normalText1Gras = new Font(Font.FontFamily.TIMES_ROMAN,
			12, Font.BOLD);

	private static Font normalTitle = new Font(Font.FontFamily.TIMES_ROMAN, 9,
			Font.BOLD);

	private static Font smallText = new Font(Font.FontFamily.COURIER, 8,
			Font.NORMAL);

	private static Font smallTextGras = new Font(Font.FontFamily.COURIER, 8,
			Font.BOLD);

	private static Font TITRE3 = new Font(Font.FontFamily.TIMES_ROMAN, 14,
			Font.BOLD);

	public void editerCondPart() throws IOException, Exception {
		editerConditionPart(getIdQuittance(),
				(HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest(),
				(HttpServletResponse) FacesContext.getCurrentInstance()
						.getExternalContext().getResponse());
	}

	public void editerConditionPart(String idQuittance,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		// Créer le dosier de stockage des fichier générés
		repectoire = new File("c:/Etats/Cond_Part/AUTO");
		repectoire.mkdirs();
		// Passer les info nécessaires à notre rapport à générer
		getReportFactoryAuto().setIdQuittance(idQuittance);
		setReportingAuto(getReportFactoryAuto().reportProvider());
		if(reportingAuto!=null){

		Document document = new Document(PageSize.A4);
		document.setMargins(20, 20, 20, 20);
		nomFichier = "CP-" + reportingAuto.getQuittance().getCodeQuittance() + ".pdf";
		// step 2
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		PdfWriter.getInstance(document, new FileOutputStream(repectoire + "/"
				+ nomFichier));

		// step 3
		document.open();

		for (Vehicule vehicule : getReportingAuto().getListVehiculeAssure()) {
			document.newPage();
			// Recuperer la sous catégorie
			SousCatVehicule sousCatVehicule = vehicule.getSousCatVehicule();

			// Recuperer la zone de geographie
			VehiculeZoneGeographique vehiculeZoneGeographique = getObjectService()
					.recupDerniereZoneGeo(vehicule.getCodeVehicule());

			// Recuperer le conducteur habituel
			ConduireVehicule conduireVehicule = getObjectService()
					.recupConducteur(vehicule.getCodeVehicule());

			// recuperer la derniere garantieChoisie
			GarantieChoisie garantieChoisie = getObjectService()
					.recuperGarantiChoisie(vehicule.getCodeVehicule(),
							getReportingAuto().getAvenant().getNumAvenant());

			// Recuperer la liste des gartgartchoisies
			List<GarantieGarantieChoisie> listgartieGartieChoisies = new ArrayList<GarantieGarantieChoisie>(
					getObjectService().recupGartGartChoisie(
							garantieChoisie.getCodeGarantieChoisie()));
			try {

				addContent(document, vehicule, garantieChoisie,
						listgartieGartieChoisies, vehiculeZoneGeographique,
						conduireVehicule);
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

		document.close();
		  // setting some response headers response.setHeader("Expires", "0");
		  response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
//		  response.setHeader("Pragma", "public"); // setting the content type
		  response.setContentType("application/pdf"); // the contentlength
		  response.setContentLength(baos.size()); // write ByteArrayOutputStream to the ServletOutputStream 
		  OutputStream os = response.getOutputStream(); 
		  baos.writeTo(os);
		  os.flush();
		  os.close();
		  }
	}

	private void addContent(Document document, Vehicule vehicule,
			GarantieChoisie garantieChoisie,
			List<GarantieGarantieChoisie> listgartieGartieChoisies,
			VehiculeZoneGeographique vehiculeZoneGeographique,
			ConduireVehicule conduireVehicule) throws DocumentException,
			MalformedURLException, IOException {
		// Ajout de logo
		Image logo = Image.getInstance(new URL(RESOURCE));
		logo.scalePercent(40f);
		document.add(logo);
		/*Paragraph saut = new Paragraph();
		addEmptyLine(saut, 1);
		document.add(sautLigne(1));*/
		//Ajout du nom de la societe d'assurance
		AjouterNomEntreprise(document);
		
		// Entête du document
		creerTitreDocument(document);

		// Information de la quittance
		creatTableInfo(document);

		// Titre du document
		ajoutTitre(document);

		// Information du vehicule
		identifierVehicule(document, vehicule, vehiculeZoneGeographique);

		// Tarif du vehicule
		tarifVehicule(document, vehicule, conduireVehicule);

		// Tableau de garantie
		creerTableauGaranties(document, listgartieGartieChoisies,
				garantieChoisie);

		// Recap de la prime
		createtableRecapPrime(document, garantieChoisie);

		// Emagement
		creerEmagement(document);

	}

	// Titre du document
	public void creerTitreDocument(Document document) throws DocumentException {

		Paragraph titreDocument = new Paragraph(new Chunk(
				"POLICE RISQUE AUTOMOBILE", TITRE3));
		titreDocument.setAlignment(Element.ALIGN_CENTER);
		titreDocument.setSpacingAfter(30);
		document.add(titreDocument);
	}

	private void creatTableInfo(Document document) throws DocumentException {
		// Info sur le Souscripteur
		PdfPTable tabSous = new PdfPTable(4);
		tabSous.setWidths(new int[] { 15, 20, 15, 20 });

		tabSous.getDefaultCell().setBorder(Cell.NO_BORDER);
		PdfPCell cell;

		// 1er ligne
		tabSous.addCell(new Phrase("Nom:", normalText));
		cell = new PdfPCell(new Phrase(reportingAuto.getNom(), smallText));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setColspan(3);
		tabSous.addCell(cell);

		// 2em ligne
		tabSous.addCell(new Phrase("Adresse:", normalText));
		cell = new PdfPCell(new Phrase(
				reportingAuto.getPersonne().getAdresse(), smallText));
		cell.setBorder(Rectangle.NO_BORDER);
		tabSous.addCell(cell);
		tabSous.addCell(new Phrase("Tel:", normalText));
		tabSous.addCell(new Phrase(reportingAuto.getPersonne().getTelephone(),
				smallText));

		// 3em ligne
		tabSous.addCell(new Phrase("Mail:", normalText));
		cell = new PdfPCell(new Phrase(reportingAuto.getPersonne().getEmail(),
				smallText));
		cell.setBorder(Rectangle.NO_BORDER);
		tabSous.addCell(cell);
		tabSous.addCell(new Phrase("Fax:", normalText));
		tabSous.addCell(new Phrase(reportingAuto.getPersonne().getFax(),
				smallText));

		// 4em ligne
		tabSous.addCell(new Phrase("Intermédiaire:", normalText));
		cell = new PdfPCell(new Phrase("non renseigné"));
		cell.setBorder(Rectangle.NO_BORDER);
		tabSous.addCell(cell);
		tabSous.addCell(new Phrase("Réseaux:", normalText));
		tabSous.addCell(new Phrase(reportingAuto.getPointVente()
				.getLibellePointVente(), smallText));

		// Tableau général information
		PdfPTable tabInfo = new PdfPTable(3);
		tabInfo.setWidthPercentage(100);
		tabInfo.setWidths(new int[] { 48, 1, 47 });

		// Entête du tableau
		PdfPCell cellTitre = new PdfPCell(new Phrase("SOUSCRIPTEUR",
				normalTitle));
		cellTitre.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabInfo.addCell(cellTitre);
		tabInfo.addCell("");
		cellTitre = new PdfPCell(new Phrase("REFFERENCES", normalTitle));
		cellTitre.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellTitre.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabInfo.addCell(cellTitre);

		// Info sur la quittance
		PdfPTable tabQuit = new PdfPTable(4);
		tabQuit.setWidths(new int[] { 21, 29, 21, 29 });
		tabQuit.getDefaultCell().setBorder(Cell.NO_BORDER);

		// 1er ligne
		tabQuit.addCell(new Phrase("Police:", normalText));
		tabQuit.addCell(new Phrase(reportingAuto.getContrat().getNumPolice(),smallText));

		tabQuit.addCell(new Phrase("Categorie:", normalText));
		tabQuit.addCell(new Phrase(reportingAuto.getRisque().getCodeRisque(), smallText));

		// 2em ligne
		tabQuit.addCell(new Phrase("Avenant:", normalText));
		cell = new PdfPCell(new Phrase(reportingAuto.getAvenant().getNumAvenant(),
				smallText));
		
		cell.setBorder(Rectangle.NO_BORDER);

		tabQuit.addCell(cell);
		tabQuit.addCell(new Phrase("Mouvement:", normalText));
		tabQuit.addCell(new Phrase(reportingAuto.getAvenant().getMouvement(),
				smallText));

		// 3e Ligne
		tabQuit.addCell(new Phrase("Effet:", normalText));
		cell = new PdfPCell(new Phrase(sdf.format(reportingAuto.getAvenant().getEffet()), smallText));
		cell.setBorder(Rectangle.NO_BORDER);

		tabQuit.addCell(cell);
		tabQuit.addCell(new Phrase("Echéance:", normalText));
		tabQuit.addCell(new Phrase(sdf.format(reportingAuto.getAvenant()
				.getEcheance()), smallText));

		// 4e Ligne
		tabQuit.addCell(new Phrase("Barème:", normalText));
		cell = new PdfPCell(new Phrase(reportingAuto.getContrat().getBareme(),
				smallText));
		cell.setBorder(Rectangle.NO_BORDER);

		tabQuit.addCell(cell);
		tabQuit.addCell(new Phrase("Durée:", normalText));
		tabQuit.addCell(new Phrase("" + reportingAuto.getAvenant().getDuree(),
				smallText));

		tabInfo.addCell(tabSous);
		cell = new PdfPCell(new Phrase(""));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		tabInfo.addCell(cell);
		tabInfo.addCell(tabQuit);
		tabInfo.addCell("Tab quittance");
		
		tabInfo.setSpacingAfter(15);
		document.add(tabInfo);
	}

	private static void ajoutTitre(Document document) throws DocumentException{
		Paragraph titre = new Paragraph();
		Paragraph paragraph = new Paragraph("CONDITIONS PARTICULIERES", TITRE3);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		titre.add(paragraph);
		titre.setSpacingAfter(20);
		document.add(titre);
	}
	
	
	public void AjouterNomEntreprise(Document document) throws DocumentException{
		Paragraph societeAssurance = new Paragraph(getReportingAuto().getSocieteAssurance().getAbrege());
		societeAssurance.setAlignment(Element.ALIGN_LEFT);
		document.add(societeAssurance);
	}

	public void identifierVehicule(Document document, Vehicule vehicule,
			VehiculeZoneGeographique vehiculeZoneGeographique)
			throws DocumentException {
		// Tableau général information
		PdfPTable tableauVehicul = new PdfPTable(6);
		tableauVehicul.setWidthPercentage(100);
		tableauVehicul.setWidths(new int[] { 16, 16, 16, 16, 16, 16 });

		// Contenu du tableau

		PdfPCell cell;
		PdfPCell cellLib;
		PdfPCell cellCont;

		// Titre tableau
		cell = new PdfPCell(new Phrase("INFORMATIONS SUR LE VEHICULE",
				normalTitle));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setColspan(6);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauVehicul.addCell(cell);

		// 1ere Ligne
		cellLib = new PdfPCell(new Phrase("Imatriculation", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getNumImmat(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("1° mis en circulation", normalText));
		cellCont = new PdfPCell(new Phrase(sdf.format(vehicule
				.getDatePremiereCirc()), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Charge utile", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getChargeUtile(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 2e Ligne
		cellLib = new PdfPCell(new Phrase("Marque", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getMarque(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Energie", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getEnergie(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("PTAC", normalText));
		cellCont = new PdfPCell(new Phrase(""
				+ vehicule.getPoidsVide().add(vehicule.getChargeUtile()),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 3e Ligne
		cellLib = new PdfPCell(new Phrase("Type", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getEnergie(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Puissance", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getPuissFisc(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Poid vide", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getPoidsVide(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 4e Ligne
		cellLib = new PdfPCell(new Phrase("Genre", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getGenre(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Puissance Réelle", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getPuissReelle(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Zone Geo", normalText));
		cellCont = new PdfPCell(new Phrase(vehiculeZoneGeographique
				.getZoneGeographique().getLibelleZoneGeo(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 5e Ligne
		cellLib = new PdfPCell(new Phrase("Carosserie", normalText));
		cellCont = new PdfPCell(
				new Phrase(vehicule.getCarrosserie(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("place cabine", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getNbrePlaceCab(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("places hors cabine", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getNbrePlaceHorscab(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 5e Ligne
		cellLib = new PdfPCell(new Phrase("N° chasis", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getChassis(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Valeur à neuf", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getValNeuf(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		cellLib = new PdfPCell(new Phrase("Valeur venale", normalText));
		cellCont = new PdfPCell(new Phrase("" + vehicule.getValVenale(),
				smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		document.add(tableauVehicul);
	}

	// Tableau detail Vehicule
	public void tarifVehicule(Document document, Vehicule vehicule,
			ConduireVehicule conduireVehicule) throws DocumentException {
		// Tableau général information
		PdfPTable tableauVehicul = new PdfPTable(6);
		tableauVehicul.setWidthPercentage(100);
		tableauVehicul.setWidths(new int[] { 16, 16, 16, 16, 16, 16 });

		// Contenu du tableau
		PdfPCell cellLib;
		PdfPCell cellCont;

		// 1ere colonne
		cellLib = new PdfPCell(new Phrase("Tarif", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getSousCatVehicule()
				.getTarif(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 2e colonne
		cellLib = new PdfPCell(new Phrase("Catégorie", normalText));
		cellCont = new PdfPCell(new Phrase(vehicule.getSousCatVehicule()
				.getTarif(), smallText));
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		// 3e colonne
		cellLib = new PdfPCell(new Phrase("Conducteur habituel", normalText));
		if (conduireVehicule != null) {
			cellCont = new PdfPCell(new Phrase(conduireVehicule
					.getConducteur().getNonCond(), smallText));
		} else {
			cellCont = new PdfPCell(new Phrase("", smallText));
		}
		tableauVehicul.addCell(cellLib);
		tableauVehicul.addCell(cellCont);

		tableauVehicul.setSpacingAfter(10);
		document.add(tableauVehicul);

	}

	// Tableau de recap des garanties
	public void creerTableauGaranties(Document document,
			List<GarantieGarantieChoisie> listGartGartChoisies,
			GarantieChoisie garantieChoisie) throws DocumentException {
		PdfPTable tableauGaranties = new PdfPTable(11);
		tableauGaranties.setWidthPercentage(100);
		tableauGaranties.setWidths(new int[] { 13, 10, 10, 10, 7, 7, 7, 7, 7,
				10, 12 });
		PdfPCell cell;
		PdfPCell cellLib;
		PdfPCell cellCont;

		// Titre du tableau
		cell = new PdfPCell(new Phrase("GARANTIES SOUSCRITES", normalTitle));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setColspan(12);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cell);

		// 1ere Ligne
		// Entête des colonnes
		cellLib = new PdfPCell(new Phrase("Nature risque", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellLib.setRowspan(2);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Somme garantie", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellLib.setRowspan(2);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Franchise", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellLib.setRowspan(2);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Prime Annuelle", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellLib.setRowspan(2);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Réduction & Majoration", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellLib.setColspan(5);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Prime nette annuelle", normalTitle));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setRowspan(2);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Prime comptant", normalTitle));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setRowspan(2);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Bonus", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Autre", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Flotte", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Malus", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		cellLib = new PdfPCell(new Phrase("Montant", normalText));
		cellLib.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cellLib.setHorizontalAlignment(Element.ALIGN_CENTER);
		tableauGaranties.addCell(cellLib);

		// Fonction de la taille des garanties souscrite
		for (GarantieGarantieChoisie occurenceGartGartChoisie : listGartGartChoisies) {
			// Recuperer la gartgartchoisie
			GarantieGarantieChoisie garantieGarantieChoisie = new GarantieGarantieChoisie();
			garantieGarantieChoisie = occurenceGartGartChoisie;
			// recup la garantie
			Garantie garantie = new Garantie();
			garantie = garantieGarantieChoisie.getGarantie();

			// Contenu
			// 1e Colonne
			cellCont = new PdfPCell(new Phrase(garantie.getLibelleGarantie(),
					smallText));// Garanties
			cellCont.setHorizontalAlignment(Element.ALIGN_LEFT);
			tableauGaranties.addCell(cellCont);

			// 2e Colonne
			cellCont = new PdfPCell(new Phrase(""
					+ garantieGarantieChoisie.getPrimeNetteProrata().setScale(
							2, BigDecimal.ROUND_HALF_UP), smallText));// Nature-Franchise
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 3e Colonne
			cellCont = new PdfPCell(new Phrase("" + garantie.getFranchise(),
					smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 4e Colonne
			cellCont = new PdfPCell(new Phrase(""
					+ garantieGarantieChoisie.getPrimeAnnuelle().setScale(2,
							BigDecimal.ROUND_HALF_UP), smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 5e Colonne
			cellCont = new PdfPCell(new Phrase(""
					+ garantieGarantieChoisie.getBonus().setScale(2,
							BigDecimal.ROUND_HALF_UP), smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 6e Colonne
			cellCont = new PdfPCell(new Phrase("non fourni", smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 7e Colonne
			cellCont = new PdfPCell(new Phrase("non fourni", smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 8e Colonne
			cellCont = new PdfPCell(new Phrase(""
					+ garantieGarantieChoisie.getMalus().setScale(2,
							BigDecimal.ROUND_HALF_UP), smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 9e Colonne
			cellCont = new PdfPCell(new Phrase("non fourni", smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 10e Colonne
			cellCont = new PdfPCell(new Phrase(""
					+ garantieGarantieChoisie.getPrimeNetteAnnuelle().setScale(
							2, BigDecimal.ROUND_HALF_UP), smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

			// 11e Colonne
			cellCont = new PdfPCell(new Phrase(""
					+ garantieGarantieChoisie.getPrimeNetteProrata().setScale(
							2, BigDecimal.ROUND_HALF_UP), smallText));
			cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableauGaranties.addCell(cellCont);

		}

		cellLib = new PdfPCell(new Phrase("Total", normalText));
		cellLib.setHorizontalAlignment(Element.ALIGN_LEFT);
		cellLib.setColspan(10);
		tableauGaranties.addCell(cellLib);

		cellCont = new PdfPCell(new Phrase(""
				+ garantieChoisie.getPrimeNetteProrata().setScale(2,
						BigDecimal.ROUND_HALF_UP), smallText));
		cellCont.setHorizontalAlignment(Element.ALIGN_RIGHT);
		tableauGaranties.addCell(cellCont);


		document.add(tableauGaranties);
	}

	// Recap de la prime
	public void createtableRecapPrime(Document document,
			GarantieChoisie garantieChoisie) throws DocumentException {
		PdfPTable tableTotall = new PdfPTable(2);
		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Prime nette:", normalText));
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);
		cell = new PdfPCell(new Phrase(""
				+ garantieChoisie.getPrimeNetteProrata(), smallTextGras));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);

		cell = new PdfPCell(new Phrase("Accessoire:", normalText));
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);
		cell = new PdfPCell(
				new Phrase(""
						+ reportingAuto.getQuittance().getAccessoire()
								.doubleValue()
						/ (reportingAuto.getListVehiculeAssure().size()),
						smallTextGras));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);

		cell = new PdfPCell(new Phrase("Taxe d'enregistrement:", normalText));
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);
		cell = new PdfPCell(new Phrase(""
				+ reportingAuto.getQuittance().getTaxes(), smallTextGras));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);

		cell = new PdfPCell(new Phrase("FGA:", normalText));
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);
		cell = new PdfPCell(new Phrase(""
				+ reportingAuto.getQuittance().getFga(), smallTextGras));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);

		cell = new PdfPCell(new Phrase("Prime TTC:", normalText));
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);
		cell = new PdfPCell(new Phrase(""
				+ reportingAuto.getQuittance().getNetAPayer(), smallTextGras));
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setBorder(Rectangle.NO_BORDER);
		tableTotall.addCell(cell);

		// Tableau général
		PdfPTable tabgeneral = new PdfPTable(3);
		tabgeneral.setWidthPercentage(100);
		tabgeneral.setWidths(new int[] { 30, 30, 40 });
		PdfPCell cellVide = new PdfPCell();
		cellVide.setBorder(Rectangle.NO_BORDER);
		tabgeneral.addCell(cellVide);
		tabgeneral.addCell(cellVide);
		// PdfPCell cellTotal = new PdfPCell();
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.addElement(tableTotall);
		tabgeneral.addCell(cell);

		tabgeneral.setSpacingBefore(2);
		document.add(tabgeneral);
	}

	// Emargement
	public void creerEmagement(Document document) throws DocumentException {

		Paragraph dateJour = new Paragraph(new Chunk("Fait en 3 exemplaires à "
				+ reportingAuto.getPointVente().getVille()
						.getLibelleVille() + ", le " + sdf.format(new Date())));
		dateJour.setIndentationLeft(200);

		PdfPTable tabEmerg = new PdfPTable(3);
		tabEmerg.setWidthPercentage(100);
		PdfPCell cell;

		Chunk chunkSous = new Chunk("Le souscripteur");
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
		document.add(dateJour);
		document.add(tabEmerg);
	}

	public static void addEmptyLine(Paragraph paragraph, int nbrLigne) {
		for (int i = 0; i < nbrLigne; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public Paragraph sautLigne(int number) {
		Paragraph saut = new Paragraph();
		for (int i = 0; i < number; i++) {
			saut.add(new Paragraph(" "));
		}
		return saut;
	}

	public void ouvrirFicher() {
		System.out.println("début ouverture du fichier pdf");// clean After
		try {

			if ((new File("C:\\Etats\\Cond_Part\\AUTO\\" + nomFichier + ""))
					.exists()) {

				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler "
								+ "C:\\Etats\\Cond_Part\\AUTO\\" + nomFichier
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

	public void printFile() {
		if (Desktop.isDesktopSupported()) {
			if (Desktop.getDesktop().isSupported(java.awt.Desktop.Action.PRINT)) {
				try {
					java.awt.Desktop.getDesktop().print(
							new File(repectoire + nomFichier));
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

	public ReportFactoryAuto getReportFactoryAuto() {
		return reportFactoryAuto;
	}

	public void setReportFactoryAuto(ReportFactoryAuto reportFactoryAuto) {
		this.reportFactoryAuto = reportFactoryAuto;
	}

	public ReportingAuto getReportingAuto() {
		return reportingAuto;
	}

	public void setReportingAuto(ReportingAuto reportingAuto) {
		this.reportingAuto = reportingAuto;
	}

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	

	

}
