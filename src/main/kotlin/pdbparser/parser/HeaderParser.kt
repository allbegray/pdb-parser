package pdbparser.parser

import pdbparser.model.Header

/*
COLUMNS       DATA  TYPE     FIELD             DEFINITION
------------------------------------------------------------------------------------
 1 -  6       Record name    "HEADER"
11 - 50       String(40)     classification    Classifies the molecule(s).
51 - 59       Date           depDate           Deposition date. This is the date the
                                               coordinates  were received at the PDB.
63 - 66       IDcode         idCode            This identifier is unique within the PDB.
 */
class HeaderParser : AbstractParser<Header?>() {

    override fun match(line: String): Boolean {
        return line.startsWith("HEADER")
    }

    override fun parser(): Header? {
        val line = lines.firstOrNull() ?: return null
        val classification = line.substring(11 - 1, 50).trim()
        val depDate = line.substring(51 - 1, 59)
        val idCode = line.substring(63 - 1, 66)
        return Header(
            classification,
            depDate,
            idCode
        )
    }
}