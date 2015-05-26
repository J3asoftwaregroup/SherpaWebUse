package com.j3a.assurance.managedBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.j3a.assurance.model.ActeMedical;
import com.j3a.assurance.model.Intervenant;
import com.j3a.assurance.model.Intervention;
import com.j3a.assurance.model.Sinistre;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.IdGenerateur;


@Component
public class ManagedSoumission {
	//Injection Spring
		@Autowired
		ObjectService objectService;
		@Autowired
		IdGenerateur idGenerateur;
		
		private UploadedFile filePv;
		private UploadedFile fileRap;
		private UploadedFile fileActMed;
		private UIComponent buttonadd;
		
		private boolean bPv, bRap, bActMed;
		private boolean etatPv=true, etatRap=true, etatActMed=true;
		private Sinistre sinistre = new Sinistre();
		private Intervention intervention = new Intervention();
		private Intervenant intervenant = new Intervenant();
		private ActeMedical acteMedical = new ActeMedical();
		private static String FILE = "c:/upload/temp/default.pdf";
		private String destination = "c:\\upload\\temp\\";
		private java.lang.String typeRapport;
		private String nomfichier;
		private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
				Font.BOLD);
		private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
				Font.NORMAL, BaseColor.RED);
		private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
				Font.BOLD);
		private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
				Font.BOLD);

		
		public void soumettre(){
			if(isEtatPv()==true){
				AjouPv();
			}
			
			if(isEtatRap()==true){
				AjouRap();
			}
			
			if(isEtatActMed()==true){
				AjouActMed();
			}
		}
		
		public void ChangeValueChexBox(){
			//bouton PV
			if (isbPv()==true ){
				setEtatPv(false);
			}
			else{
				setEtatPv(true);
			}
			 //bouton rapport
			if (isbRap()==true){
				setEtatRap(false);
			}
			else{
				setEtatRap(true);
			}
			
			//Bouton Acte
			if(isbActMed()==true){
				setEtatActMed(false);
			}
			else{
				setEtatActMed(true);
			}
		}
		
		public void AjouPv(){
			intervention.setRefIntervention(getIdGenerateur().getIdIntervention(getSinistre()));
			intervention.setTypeRapport("Rapport Intervenant");
			
			handleFileUploadpv();
		}
		
public void AjouActMed(){
			acteMedical.setReferenceActe(getIdGenerateur().getIdActeMed(getSinistre()));
			handleFileUploadActeMed();
		}
		
		public void AjouRap(){
			handleFileUploadRap();
		}
		
		public void handleFileUploadpv() {
			byte[] bFile = new byte[102400];
			if (filePv != null) {
				try {
					// copyFile(file.getFileName(), file.getInputstream());
					String nom = filePv.getFileName();
					setNomfichier(nom);
					System.out.print("file.getFileName()" + filePv.getFileName());
					System.out.print("nomfichier" + nomfichier);

					if (copyFile(nom, filePv.getInputstream())) {
						FacesMessage msg = new FacesMessage("Succès téléchargement fichier! ",
								filePv.getFileName() + " a été téléchargé!");
						FacesContext.getCurrentInstance().addMessage(null, msg);
						typeRapport = nom;
					} else {
						FacesMessage msg = new FacesMessage("Failure! ");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				File fileupload = new File(destination + nomfichier);
				bFile = filePv.toString().getBytes();
				try {
					FileInputStream fileInputStream = new FileInputStream(
							fileupload);
					// convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				creerPdf();
				File fileupload = new File(destination + "default.pdf");
				bFile = fileupload.toString().getBytes();
				try {
					FileInputStream fileInputStream = new FileInputStream(
							fileupload);
					// convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				typeRapport = "default.pdf";
			}
		}
		
		public void handleFileUploadRap() {
			byte[] bFile = new byte[102400];
			if (fileRap != null) {
				try {
					// copyFile(file.getFileName(), file.getInputstream());
					String nom = fileRap.getFileName();
					setNomfichier(nom);
					System.out.print("file.getFileName()" + fileRap.getFileName());
					System.out.print("nomfichier" + nomfichier);

					if (copyFile(nom, fileRap.getInputstream())) {
						FacesMessage msg = new FacesMessage("Succès téléchargement fichier! ",
								fileRap.getFileName() + " a été téléchargé!");
						FacesContext.getCurrentInstance().addMessage(null, msg);
						typeRapport = nom;
					} else {
						FacesMessage msg = new FacesMessage("Failure! ");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				File fileupload = new File(destination + nomfichier);
				bFile = fileRap.toString().getBytes();
				try {
					FileInputStream fileInputStream = new FileInputStream(
							fileupload);
					// convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				creerPdf();
				File fileupload = new File(destination + "default.pdf");
				bFile = fileupload.toString().getBytes();
				try {
					FileInputStream fileInputStream = new FileInputStream(
							fileupload);
					// convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				typeRapport = "default.pdf";
			}
		}
		
		public void handleFileUploadActeMed() {
			byte[] bFile = new byte[102400];
			if (fileActMed != null) {
				try {
					// copyFile(file.getFileName(), file.getInputstream());
					String nom = fileActMed.getFileName();
					setNomfichier(nom);
					System.out.print("file.getFileName()" + fileActMed.getFileName());
					System.out.print("nomfichier" + nomfichier);

					if (copyFile(nom, fileActMed.getInputstream())) {
						FacesMessage msg = new FacesMessage("Succès téléchargement fichier! ",
								fileActMed.getFileName() + " a été téléchargé!");
						FacesContext.getCurrentInstance().addMessage(null, msg);
						typeRapport = nom;
					} else {
						FacesMessage msg = new FacesMessage("Failure! ");
						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				File fileupload = new File(destination + nomfichier);
				bFile = fileActMed.toString().getBytes();
				try {
					FileInputStream fileInputStream = new FileInputStream(
							fileupload);
					// convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				creerPdf();
				File fileupload = new File(destination + "default.pdf");
				bFile = fileupload.toString().getBytes();
				try {
					FileInputStream fileInputStream = new FileInputStream(
							fileupload);
					// convert file into array of bytes
					fileInputStream.read(bFile);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				typeRapport = "default.pdf";
			}
		}
		public void creerPdf() {
			File dir = new File("c:\\upload\\temp\\");
			dir.mkdirs();
			try {
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(FILE));
				document.open();
				addMetaData(document);
				addTitlePage(document);
				// addContent(document);
				document.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private static void addMetaData(Document document) {
			document.addTitle("My first PDF");
			document.addSubject("Using iText");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("Lars Vogel");
			document.addCreator("Lars Vogel");
		}

		private static void addTitlePage(Document document)
				throws DocumentException {
			Paragraph preface = new Paragraph();
			// We add one empty line

			// Lets write a big header
			preface.add(new Paragraph(
					"Vous n'avez pas encore  importer un fichier! ", catFont));

			document.add(preface);
			// Start a new page
			document.newPage();
		}
		
		public boolean copyFile(String fileName, InputStream in) {

			try {
				File dir = new File("c:\\upload\\temp\\");
				dir.mkdirs();

				// FileWriter newJsp = new FileWriter("c:\\upload\\temp\\test.txt");

				OutputStream out = new FileOutputStream(new File(destination
						+ fileName));

				// ExternalContext
				// extContext=FacesContext.getCurrentInstance().getExternalContext();
				// destination = "//resources//file//" +file.getFileName();
				// File dir = new File(extContext.getRealPath(destination));
				// dir.mkdirs();
				// OutputStream out = new FileOutputStream(new File(destination));
				int read = 0;

				byte[] bytes = new byte[1024];

				while ((read = in.read(bytes)) != -1) {

					out.write(bytes, 0, read);

				}

				in.close();

				out.flush();

				out.close();

				System.out
						.println("Un nouveau fichier a été ajouté dans le dossier c:\\upload\\temp\\ !");
				return true;

			} catch (IOException e) {

				System.out.println(e.getMessage());
				return false;

			}

		}

		
		
		 
	    public UploadedFile getFilePv() {
	        return filePv;
	    }
	 
	    public void setFilePv(UploadedFile filePv) {
	        this.filePv = filePv;
	    }

		public ObjectService getObjectService() {
			return objectService;
		}

		public void setObjectService(ObjectService objectService) {
			this.objectService = objectService;
		}

		public UploadedFile getFileRap() {
			return fileRap;
		}

		public void setFileRap(UploadedFile fileRap) {
			this.fileRap = fileRap;
		}

		public UploadedFile getFileActMed() {
			return fileActMed;
		}

		public void setFileActMed(UploadedFile fileActMed) {
			this.fileActMed = fileActMed;
		}

		public boolean isbPv() {
			return bPv;
		}

		public void setbPv(boolean bPv) {
			this.bPv = bPv;
		}

		public boolean isbRap() {
			return bRap;
		}

		public void setbRap(boolean bRap) {
			this.bRap = bRap;
		}

		public boolean isbActMed() {
			return bActMed;
		}

		public void setbActMed(boolean bActMed) {
			this.bActMed = bActMed;
		}

		public boolean isEtatPv() {
			return etatPv;
		}

		public void setEtatPv(boolean etatPv) {
			this.etatPv = etatPv;
		}

		public boolean isEtatRap() {
			return etatRap;
		}

		public void setEtatRap(boolean etatRap) {
			this.etatRap = etatRap;
		}

		public boolean isEtatActMed() {
			return etatActMed;
		}

		public void setEtatActMed(boolean etatActMed) {
			this.etatActMed = etatActMed;
		}

		public Sinistre getSinistre() {
			return sinistre;
		}

		public void setSinistre(Sinistre sinistre) {
			this.sinistre = sinistre;
		}

		public Intervention getIntervention() {
			return intervention;
		}

		public void setIntervention(Intervention intervention) {
			this.intervention = intervention;
		}

		public Intervenant getIntervenant() {
			return intervenant;
		}

		public void setIntervenant(Intervenant intervenant) {
			this.intervenant = intervenant;
		}

		public ActeMedical getActeMedical() {
			return acteMedical;
		}

		public void setActeMedical(ActeMedical acteMedical) {
			this.acteMedical = acteMedical;
		}

		public IdGenerateur getIdGenerateur() {
			return idGenerateur;
		}

		public void setIdGenerateur(IdGenerateur idGenerateur) {
			this.idGenerateur = idGenerateur;
		}

		public java.lang.String getTypeRapport() {
			return typeRapport;
		}

		public void setTypeRapport(java.lang.String typeRapport) {
			this.typeRapport = typeRapport;
		}

		public String getNomfichier() {
			return nomfichier;
		}

		public void setNomfichier(String nomfichier) {
			this.nomfichier = nomfichier;
		}

		public UIComponent getButtonadd() {
			return buttonadd;
		}

		public void setButtonadd(UIComponent buttonadd) {
			this.buttonadd = buttonadd;
		}
	
}
