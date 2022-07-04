package pdbparser.parser

import org.junit.jupiter.api.Test

internal class HeaderParserTest {

    @Test
    fun parser() {
        val pdb = """
            HEADER    LIGASE/TRANSFERASE                      08-OCT-11   4A4C              
            TITLE     STRUCTURE OF PHOSPHOTYR371-C-CBL-UBCH5B-ZAP-70 COMPLEX                
            COMPND    MOL_ID: 1;
        """.trimIndent()

        val parser = HeaderParser()
        for (line in pdb.split("\n")) {
            parser.collect(line)
        }
        val result = parser.parser()
        println(result)
    }
}