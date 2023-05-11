package com.dmnr.datty.core

import com.dmnr.datty.core.source.data.HeaderTableSource
import com.dmnr.datty.core.source.data.TitleSource
import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import com.lowagie.text.pdf.PdfWriter
import java.io.FileOutputStream

fun main() {

    // 1) Create a FileOutputStream object with the path and name of the file
    val pdfOutputFile = FileOutputStream("./sample1.pdf")

    //2) Instance a object from the class com.lowagie.text.Document
    val myPDFDoc = Document()

    //3) Now we get a file writer instance from the class com.lowagie.text.pdf.PdfWriter
    val pdfWriter = PdfWriter.getInstance(myPDFDoc, pdfOutputFile)

    //4) Once the Filewritter is set up we can open
    //   the document and start adding content
    myPDFDoc.apply {
        open() // Open the Document
        TitleSource.insertData()
            .forEach { add(it) }
        add(Paragraph(Chunk.NEWLINE))
        add(HeaderTableSource.createTable())
        add(Paragraph(Chunk.NEWLINE))
        add(HeaderTableSource.createTableWithStudentInfo())
        add(Paragraph(Chunk.NEWLINE))
        add(HeaderTableSource.getOtherTable())
        // Add a text within a Paragraph
        // (we can add objects from classes
        // implementing the interface com.lowagie.text.Element )
        add(Paragraph("This is a simple PDF created with openPDF"))
        close() // Close the Document
    }
    pdfWriter.close() // close the File writer
}