package pdbparser.parser

import pdbparser.model.Obslte

/*
COLUMNS       DATA  TYPE     FIELD         DEFINITION
---------------------------------------------------------------------------------------
 1 -  6       Record name   "OBSLTE"
 9 - 10       Continuation  continuation  Allows concatenation of multiple records
12 - 20       Date          repDate       Date that this entry was replaced.
22 - 25       IDcode        idCode        ID code of this entry.
32 - 35       IDcode        rIdCode       ID code of entry that replaced this one.
37 - 40       IDcode        rIdCode       ID code of entry that replaced this one.
42 - 45       IDcode        rIdCode       ID code of entry  that replaced this one.
47 - 50       IDcode        rIdCode       ID code of entry that replaced this one.
52 - 55       IDcode        rIdCode       ID code of entry that replaced this one.
57 - 60       IDcode        rIdCode       ID code of entry that replaced this one.
62 - 65       IDcode        rIdCode       ID code of entry that replaced this one.
67 - 70       IDcode        rIdCode       ID code of entry that replaced this one.
72 - 75       IDcode        rIdCode       ID code of entry that replaced this one.
 */
class ObslteParser : AbstractParser<List<Obslte>>() {

    override fun match(line: String): Boolean {
        return line.startsWith("OBSLTE")
    }

    override fun parser(): List<Obslte> {
        return lines
            .map { line ->
                val repDate = line.substring(12 - 1, 20)
                val idCode = line.substring(22 - 1, 25)
                val rIdCodes = line.substring(32 - 1)
                    .split(" ")
                    .map { it.trim() }
                    .filter { it.isNotEmpty() }
                Obslte(repDate, idCode, rIdCodes)
            }
    }
}