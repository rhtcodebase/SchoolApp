/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolapp.certificates;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author prohit
 */
public class StudyCertificateGenerator {

    /**
     * Creates a PDF document.
     *
     * @param filename the path to the new PDF document
     * @throws DocumentException
     * @throws IOException
     */
    public void createPdf(StudyCertificateParams param,String filename)
            throws DocumentException, IOException {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter.getInstance(document, new java.io.FileOutputStream(filename));
        document.open();

        Paragraph header = new Paragraph();
        header.setAlignment(Element.ALIGN_CENTER);

        String admissionNo = param.getAdmissionNo();
        Paragraph admissionNumber = new Paragraph("Admission Number: " + admissionNo);
        admissionNumber.setAlignment(Element.ALIGN_LEFT);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //get current date time with Date()
        Date currentDate = new Date();
        String issueDate = dateFormat.format(currentDate);
        Paragraph date = new Paragraph("Date: " + issueDate);
        date.setAlignment(Element.ALIGN_RIGHT);

        Font fontbold = FontFactory.getFont("Times-Roman", 14, Font.BOLD);
        Font fontsmall = FontFactory.getFont("Times-Roman", 10, Font.COURIER);
        Font boldUnderLined = FontFactory.getFont("Times-Roman", 12, Font.BOLD | Font.UNDERLINE);
        
        Paragraph schoolDice=new Paragraph("School Dice: 29331026309",fontsmall);
        schoolDice.setAlignment(Element.ALIGN_RIGHT);
        
        
        Chunk ch1 = new Chunk("Chandrashekar Education Society's\n\n");
        header.add(ch1);

        Chunk ch2 = new Chunk("RAJESHWARI HIGHER PRIMARY ENGLISH MEDIUM SCHOOL YADGIRI\n", fontbold);
        header.add(ch2);

        Chunk ch3 = new Chunk("Dist. YADGIRI\n\n", fontsmall);
        header.add(ch3);

        Chunk ch4 = new Chunk("STUDY CERTIFICATE", boldUnderLined);
        header.add(ch4);

        Chunk ch5 = new Chunk("\n\n\n\n");
        header.add(ch5);

        PdfPTable headerTable = new PdfPTable(2);
        headerTable.setWidthPercentage(100);
        PdfPCell cell1 = new PdfPCell(admissionNumber);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setBorder(PdfPCell.NO_BORDER);
        cell1.setPadding(0);
        PdfPCell cell2 = new PdfPCell(date);
        cell2.setBorder(PdfPCell.NO_BORDER);
        cell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell2.setPadding(0);
        headerTable.addCell(cell1);
        headerTable.addCell(cell2);

        String fullName = param.getName();
        String fromDate = param.getStartDate();
        String endDate = param.getToDate();
        String startClass = param.getFromStd();
        String passedClass = param.getToStd();
        
        String conduct = param.getCharacter();
        String cnt = "\n\n\nThis is to certify that Sri./Miss. " + fullName 
                + " was the bonafide student of this institution/school during the year from "
                + fromDate + " to " + endDate + ", studied from " + startClass + " and he/she has passed " + passedClass  
                + ". During this period his/her character was found " + conduct + ".\n\n"
                + ".\n\n\n\nPlace: Yadgiri\n\n";

        Paragraph content = new Paragraph(cnt);
        content.setFirstLineIndent(5);
        content.setAlignment(Element.ALIGN_JUSTIFIED);

        PdfPTable footerTable = new PdfPTable(2);
        footerTable.setWidthPercentage(100);
        PdfPCell cell3 = new PdfPCell(date);
        cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell3.setBorder(PdfPCell.NO_BORDER);
        cell3.setPadding(0);
        PdfPCell cell4 = new PdfPCell(new Phrase("Headmaster", fontbold));
        cell4.setBorder(PdfPCell.NO_BORDER);
        cell4.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell4.setPadding(0);
        footerTable.addCell(cell3);
        footerTable.addCell(cell4);
        
        document.add(schoolDice);
        document.add(header);
        document.add(headerTable);
        document.add(content);
        document.add(footerTable);

        document.close();
    }

}
