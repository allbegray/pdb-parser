package pdbparser.parser

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TitleParserTest {

    @Test
    fun parser() {
        val pdb = """
            HEADER    TRANSFERASE/TRANSFERASE INHIBITOR       17-SEP-04   1XH6              
            TITLE     CRYSTAL STRUCTURES OF PROTEIN KINASE B SELECTIVE INHIBITORS           
            TITLE    2 IN COMPLEX WITH PROTEIN KINASE A AND MUTANTS                         
            COMPND    MOL_ID: 1;                                                            
        """.trimIndent()

        val parser = TitleParser()
        for (line in pdb.split("\n")) {
            parser.collect(line)
        }
        val result = parser.parser()
        println(result)
    }
}