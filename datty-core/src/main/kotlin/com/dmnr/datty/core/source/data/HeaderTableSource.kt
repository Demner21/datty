package com.dmnr.datty.core.source.data

import com.dmnr.datty.core.source.model.HeaderTableModel
import com.lowagie.text.Cell
import com.lowagie.text.Element
import com.lowagie.text.Paragraph
import com.lowagie.text.Table
import com.lowagie.text.pdf.PdfCell
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import java.awt.Color


class HeaderTableSource {
    companion object {
        //1) Let's create a Table object
        private val myTable = Table(2).apply {
            padding = 0.1f
            width = 90f
        }

        //2) Create the header of the table
        fun createTable(): Table {
            listOf(
                getFirstTable(),
                getSecondTable(),
            ).forEach {
                myTable.insertTable(it)
            }
            return myTable
        }

        private fun getFirstTable(): Table {
            val innerTable = Table(2).apply {
                padding = 0f
                spacing = 0.1f
                width = 75f
            }
            listOf(
                HeaderTableModel("DRE", "CUSCO"),
                HeaderTableModel("NIVEL", "INICIAL"),
                HeaderTableModel("IE O PROGRAMA EDUCATIVO", "NIÑOS DEL ARCO IRIS"),
                HeaderTableModel("DNI", "90373031")
            )
                .forEach {
                    innerTable.addCell(it.getColumn())
                    innerTable.addCell(it.getValue())
                }
            return innerTable;
        }

        private fun getSecondTable(): Table {
            val innerTable = Table(2).apply {
                padding = 0f
                spacing = 0.1f
                width = 75f
            }
            listOf(
                HeaderTableModel("UGEL", "URUBAMBA"),
                HeaderTableModel("CÓDIGO MODULAR", "1771864-0"),
                HeaderTableModel("EDAD", ""),
                HeaderTableModel("SECCIÓN", "A")
            )
                .forEach {
                    innerTable.addCell(it.getColumn())
                    innerTable.addCell(it.getValue())
                }
            return innerTable;
        }

        fun getOtherTable(): PdfPTable {
            val table = PdfPTable(2)
            var cell: PdfPCell
            val p = Paragraph("Quick brown fox jumps over the lazy dog. Quick brown fox jumps over the lazy dog.")
            table.addCell("default alignment")
            cell = PdfPCell(p)
            table.addCell(cell)
            table.addCell("centered alignment")
            cell = PdfPCell(p)
            cell.horizontalAlignment = Element.ALIGN_CENTER
            table.addCell(cell)
            table.addCell("right alignment")
            cell = PdfPCell(p)
            cell.horizontalAlignment = Element.ALIGN_RIGHT
            table.addCell(cell)
            table.addCell("justified alignment")
            cell = PdfPCell(p)
            cell.horizontalAlignment = Element.ALIGN_JUSTIFIED
            table.addCell(cell)
            table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
            table.defaultCell.verticalAlignment = Element.ALIGN_BASELINE
            table.addCell("baseline")
            table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
            table.defaultCell.verticalAlignment = Element.ALIGN_BOTTOM
            table.addCell("bottom")
            table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
            table.defaultCell.verticalAlignment = Element.ALIGN_MIDDLE
            table.addCell("middle")
            table.addCell("blah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\nblah\n")
            table.defaultCell.verticalAlignment = Element.ALIGN_TOP
            table.addCell("top")
            return table
        }

        fun createTableWithStudentInfo(): PdfPTable {
            val table = PdfPTable(2)
            table.widthPercentage = 95f

            listOf(
                HeaderTableModel("Estudiante", "ALAGON HUAMAN, LEYDI SAYURI"),
                HeaderTableModel("Docente", "RANDALL FLAGG"),
            ).forEach {
                table.addCell(
                    PdfPCell(Paragraph(it.nameColumn)).apply {
                        this.backgroundColor = Color.LIGHT_GRAY
                    }
                )
                table.addCell(
                    PdfPCell(Paragraph(it.valueColumn)).apply {
                        this.backgroundColor = Color.WHITE
                    }
                )
            }
            return table
        }


    }
}