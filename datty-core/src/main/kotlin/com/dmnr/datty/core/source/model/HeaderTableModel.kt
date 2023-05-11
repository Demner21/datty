package com.dmnr.datty.core.source.model

import com.lowagie.text.Cell
import com.lowagie.text.Phrase
import java.awt.Color

data class HeaderTableModel(val nameColumn: String, val valueColumn: String) {
    fun getColumn(): Cell {
        return Cell(Phrase(nameColumn)).apply {
            isHeader = true
            backgroundColor = Color.LIGHT_GRAY
        }
    }

    fun getValue(): Cell {
        return Cell(Phrase(valueColumn))
    }
}