package pdbparser.parser

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ObslteParserTest {

    @Test
    fun parser() {
        val pdb = """
            HEADER    HYDROLASE                               19-MAY-15   4ZW4              
            OBSLTE     12-AUG-15 4ZW4      5CST                                             
            TITLE     STRUCTURE OF THE COMPLEX OF TYPE 1 RIBOSOME INACTIVATING PROTEIN FROM 
        """.trimIndent()

        val parser = ObslteParser()
        for (line in pdb.split("\n")) {
            parser.collect(line)
        }
        val result = parser.parser()
        println(result)
    }
}