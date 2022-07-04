package pdbparser.parser

/*
COLUMNS       DATA  TYPE     FIELD         DEFINITION
----------------------------------------------------------------------------------
 1 -  6       Record name    "TITLE "
 9 - 10       Continuation   continuation  Allows concatenation of multiple records.
11 - 80       String         title         Title of the  experiment.
 */
class TitleParser : AbstractParser<String?>() {

    override fun match(line: String): Boolean {
        return line.startsWith("TITLE ")
    }

    override fun parser(): String? {
        return lines.joinToString(" ") { line ->
            line.substring(11 - 1).trim()
        }.ifBlank { null }
    }
}