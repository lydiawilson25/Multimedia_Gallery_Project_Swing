package service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSmartCopy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.persistence.*;
import model.MediaDetail;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class MediaListService {

    private static final String homeDir = "C:\\Eclipse Projects\\Frugal_guiv5\\MediaStorage\\";
    private EntityManager manager;

    public MediaListService(EntityManager manager) {
        this.manager = manager;
    }

     public void createDirectory(int projectId) {
        boolean dirFlag = false;
        String directory = homeDir + projectId;
        File stockDir = new File(directory);
        try {
            dirFlag = stockDir.mkdir();
        } catch (SecurityException Se) {
            System.out.println("Error while creating directory in Java:" + Se);
        }
        if (dirFlag) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Directory was not created successfully");
        }
    }

    public static void storeXLSMedia(String mediaFile, String fileName, int projectId) {
        try {
            FileInputStream fileIn = new FileInputStream(mediaFile);

            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
            FileOutputStream fileOut
                    = new FileOutputStream(new File(homeDir + projectId + "//" + fileName));
            workbook.write(fileOut);
            fileIn.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Error in copying the XLS file"+e);
        }

    }

    public static void storePPTMedia(String mediaFile, String fileName, int projectId) {
        try {
            FileInputStream fileIn = new FileInputStream(mediaFile);

            //Get the ppt instance 
            XMLSlideShow ppt = new XMLSlideShow(fileIn);
            FileOutputStream fileOut
                    = new FileOutputStream(new File(homeDir + projectId + "//" + fileName));
            ppt.write(fileOut);
            fileIn.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Error in copying the PPT file"+e);
        }
    }

    public static void storeDOCMedia(String mediaFile, String fileName, int projectId) {
        try {
            FileInputStream fileIn = new FileInputStream(mediaFile);

            //Get the workbook instance for XLS file 
            XWPFDocument doc = new XWPFDocument(fileIn);
            FileOutputStream fileOut
                    = new FileOutputStream(new File(homeDir + projectId + "//" + fileName));
            doc.write(fileOut);
            fileIn.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println("Error in copying the DOC file:"+e);
        }

    }

    public static void storeOtherMedia(String mediaFile, String fileName, int projectId) {

        try {
            FileInputStream in = new FileInputStream(mediaFile);
            FileOutputStream out = new FileOutputStream(homeDir + projectId + "//" + fileName);
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = in.read(buf)) != -1) {
                out.write(buf, 0, i);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Error copying file" + e);
        }

    }

    public static void storePDFMedia(String mediaFile, String fileName, int projectId) {

        try {

            String destinationFileName = homeDir + projectId + "//" + fileName;
            Document document = null;
            PdfReader reader = null;
            InputStream inputStream = null;
            FileOutputStream outputStream = null;
            try {
                inputStream = new FileInputStream(new File(mediaFile));
                outputStream = new FileOutputStream(new File(destinationFileName));
                document = new Document();
                PdfCopy copy = new PdfSmartCopy(document, outputStream);
                document.open();
                reader = new PdfReader(inputStream);
                // loop over the pages in that document
                int pdfPageNo = reader.getNumberOfPages();
                for (int page = 0; page < pdfPageNo;) {
                    PdfImportedPage onePage = copy.getImportedPage(reader, ++page);
                    // duplicate each page N times
                    //for (int i = 0; i < COPIES; ++i) {
                    copy.addPage(onePage);
                    //}
                }
                copy.freeReader(reader);
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    reader.close();
                }
                if (document != null) {
                    document.close();
                }
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    // do nothing
                }
            }
        } catch (Exception e) {

        }
    }

    // method to read a record
    public MediaDetail readProject(int mediaId) {
        MediaDetail media = manager.find(MediaDetail.class, mediaId);
        return media;
    }

    // method to read all records
    public List<MediaDetail> readAll() {
        TypedQuery<MediaDetail> query = manager.createQuery("SELECT e FROM MediaDetail e", MediaDetail.class);
        List<MediaDetail> result = query.getResultList();
        return result;
    }

    // method to specific project records
    public List<MediaDetail> readMediaFiles(int projectId) {

        Query q = manager.createQuery("SELECT l FROM MediaDetail l WHERE l.projectId = :projectId");
        q.setParameter("projectId", projectId);

        List<MediaDetail> result = q.getResultList();

        return result;
    }

       public MediaDetail createMedia(int mediaId, int projectId, String mediaType, String mediaName, String description, String mediaFile) {
        MediaDetail media = new MediaDetail();
        media.setMediaId(mediaId);
        media.setProjectId(projectId);
        media.setMediaType(mediaType);
        media.setMediaName(mediaName);
        media.setDescription(description);
        String[] arr = mediaFile.split("\\.");

        String extension = null;

        int index = mediaFile.lastIndexOf("\\");
        String fileName = mediaFile.substring(index + 1);
        System.out.println("homeDir+projectId+\"\\\\\"+fileName:::"+homeDir+projectId+"\\"+fileName);
        media.setMediaFile(homeDir+projectId+"\\"+fileName);
        manager.persist(media);
        if (arr.length > 1 && arr[1] != null) {
            extension = arr[1];
        }
        createDirectory(projectId);
        if (extension != null && !("".equalsIgnoreCase(extension))) {
            if ("xls".equalsIgnoreCase(extension) || "xlsx".equalsIgnoreCase(extension)) {
                storeXLSMedia(mediaFile, fileName, projectId);
            } else if ("ppt".equalsIgnoreCase(extension) || "pptx".equalsIgnoreCase(extension)) {
                storePPTMedia(mediaFile, fileName, projectId);
            } else if ("doc".equalsIgnoreCase(extension) || "docx".equalsIgnoreCase(extension)) {
                storeDOCMedia(mediaFile, fileName, projectId);
            } else if ("pdf".equalsIgnoreCase(extension)) {
                storePDFMedia(mediaFile, fileName, projectId);
            } else {
                storeOtherMedia(mediaFile, fileName, projectId);
            }

        }
        return media;
    }

    // method to update a record
    public void updateMedia(int mediaId, int projectId, String mediaType, String mediaName, String description, String mediaFile) {
        MediaDetail media = manager.find(MediaDetail.class, mediaId);
        String[] arr = mediaFile.split("\\.");

        String extension = null;

        int index = mediaFile.lastIndexOf("\\");
        String fileName = mediaFile.substring(index + 1);
        if (media != null) {
            media.setMediaId(mediaId);
            media.setProjectId(projectId);
            media.setMediaType(mediaType);
            media.setMediaName(mediaName);
            media.setDescription(description);
            media.setMediaFile(homeDir+projectId+"\\"+fileName);
        }
        manager.merge(media);

        if (arr.length > 1 && arr[1] != null) {
            System.out.println("arr:" + arr[1]);
            extension = arr[1];
        }
        System.out.println("        createDirectory(projectId);"+projectId);
        createDirectory(projectId);
        if (extension != null && !("".equalsIgnoreCase(extension))) {
            if ("xls".equalsIgnoreCase(extension) || "xlsx".equalsIgnoreCase(extension)) {
                storeXLSMedia(mediaFile, fileName, projectId);
            } else if ("ppt".equalsIgnoreCase(extension) || "pptx".equalsIgnoreCase(extension)) {
                storePPTMedia(mediaFile, fileName, projectId);
            } else if ("doc".equalsIgnoreCase(extension) || "docx".equalsIgnoreCase(extension)) {
                storeDOCMedia(mediaFile, fileName, projectId);
            } else if ("pdf".equalsIgnoreCase(extension)) {
                storePDFMedia(mediaFile, fileName, projectId);
            } else {
                storeOtherMedia(mediaFile, fileName, projectId);
            }

        }

    }

    // method to delete a record
    public MediaDetail deleteMedia(int mediaId, String mediaFile) {
        MediaDetail media = manager.find(MediaDetail.class, mediaId);
        if (media != null) {
            manager.remove(media);
        }
        File f = new File(mediaFile);
        // Make sure the file or directory exists and isn't write protected
    if (!f.exists())
      throw new IllegalArgumentException(
          "Delete: no such file or directory: " + mediaFile);

    if (!f.canWrite())
      throw new IllegalArgumentException("Delete: write protected: "
          + mediaFile);

    // If it is a directory, make sure it is empty
    if (f.isDirectory()) {
      String[] files = f.list();
      if (files.length > 0)
        throw new IllegalArgumentException(
            "Delete: directory not empty: " + mediaFile);
    }

    // Attempt to delete it
    boolean success = f.delete();

    if (!success)
      throw new IllegalArgumentException("Delete: deletion failed");
        return media;
    }

}
