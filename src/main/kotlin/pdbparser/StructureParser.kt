package pdbparser

import pdbparser.parser.*

class StructureParser {
    private val headerParser = HeaderParser()
    private val obslteParser = ObslteParser()
    private val titleParser = TitleParser()
    private val splitParser = SplitParser()
    private val caveatParser = CaveatParser()
    private val compndParser = CompndParser()

    fun parse(pdb: String): Structure {
        for (line in pdb.split("\n")) {
            headerParser.collect(line)
            obslteParser.collect(line)
            titleParser.collect(line)
            splitParser.collect(line)
            caveatParser.collect(line)
            compndParser.collect(line)
        }
        return Structure(
            headerParser.parser(),
            obslteParser.parser(),
            titleParser.parser(),
            splitParser.parser(),
            caveatParser.parser(),
            compndParser.parser(),
        )
    }
}