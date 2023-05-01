package com.dmnr.datty.core

import com.lowagie.text.Chunk
import com.lowagie.text.Element
import com.lowagie.text.Font
import com.lowagie.text.Paragraph
import java.awt.Color
import java.time.LocalDate

class TitleSource {

    companion object {
        fun insertData(): List<Paragraph> {
            val titleFont = Font(Font.HELVETICA, 15f, Font.BOLD, Color.BLACK)

            return mutableListOf(
                Paragraph(title, titleFont).apply {
                    // 4) Element class provides properties to align
                    // Content elements within the document
                    alignment = Element.ALIGN_CENTER
                },
                // 5) Adding an empty line
                Paragraph(Chunk.NEWLINE)
            )

        }

        val title = "INFORME DE PROGRESO DE LAS COMPETENCIAS DEL ESTUDIANTE – INICIAL ${LocalDate.now().year}"


    }
}