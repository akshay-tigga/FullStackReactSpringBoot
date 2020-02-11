package com.akki.ispdemo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfGenerator {
    private static final Logger logger = LoggerFactory.getLogger(PdfGenerator.class);

    synchronized public static ByteArrayInputStream generatePdf(IspEntity ispEntity) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph(ispEntity.getName()));
            document.add(new Paragraph("Rating - " + ispEntity.getRating()));
            String imageUrl = ispEntity.getImage();
            imageUrl = imageUrl.substring(0, imageUrl.lastIndexOf("/"));
            imageUrl = imageUrl + "/300x300";
            document.add(Image.getInstance(new URL(imageUrl)));
            document.add(new Paragraph("Max Speed - " + ispEntity.getMaxSpeed()));
            document.add(new Paragraph("Starting Price - " + ispEntity.getLowestPrice()));
            document.add(new Paragraph(ispEntity.getDescription()));
            document.add(new Paragraph("Contact - " + ispEntity.getContact()));
            document.add(new Paragraph("Email - " + ispEntity.getEmail()));
            document.add(new Paragraph("Website - " + ispEntity.getIspUrl()));
            document.close();
        } catch (DocumentException e) {
            logger.error("Failed to generate pdf file. Document exception: " + e);
        } catch (MalformedURLException e) {
            logger.error("Failed to generate pdf file. MalformedURLException exception: " + e);
        } catch (IOException e) {
            logger.error("Failed to generate pdf file. IOException exception: " + e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
