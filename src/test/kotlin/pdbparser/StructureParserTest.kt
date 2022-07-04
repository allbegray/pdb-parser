package pdbparser

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StructureParserTest {

    @Test
    fun parse() {
        val pdb = StructureParserTest::class.java.getResourceAsStream("/pdb/1voq.pdb")!!.reader().readText()
        val structureParser = StructureParser()
        val structure = structureParser.parse(pdb)
        println(structure)
    }

    @Test
    fun `1xh6`() {
        val pdb = StructureParserTest::class.java.getResourceAsStream("/pdb/1xh6.pdb")!!.reader().readText()
        val structureParser = StructureParser()
        val structure = structureParser.parse(pdb)
        println(structure)
    }
}