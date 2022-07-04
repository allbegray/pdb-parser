package pdbparser.parser

import pdbparser.model.Caveat

/*
COLUMNS       DATA  TYPE    FIELD          DEFINITION
---------------------------------------------------------------------------------------
  1 - 6       Record name   "CAVEAT"
 9 - 10       Continuation  continuation   Allows concatenation of multiple records.
12 - 15       IDcode        idCode         PDB ID code of this entry.
20 - 79       String        comment        Free text giving the reason for the  CAVEAT.
 */
class CaveatParser : AbstractParser<List<Caveat>>() {

    override fun match(line: String): Boolean {
        return line.startsWith("CAVEAT")
    }

    override fun parser(): List<Caveat> {
        return lines.map { line ->
            val idCode = line.substring(12 - 1, 15)
            val comment = line.substring(20 - 1).trim()
            Caveat(idCode, comment)
        }
    }
}