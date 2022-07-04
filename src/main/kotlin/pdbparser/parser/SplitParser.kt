package pdbparser.parser

/*
COLUMNS        DATA TYPE     FIELD         DEFINITION
----------------------------------------------------------------------------------
 1 -  6        Record  name  "SPLIT "
 9 - 10        Continuation  continuation  Allows concatenation of multiple records.
12 - 15        IDcode        idCode        ID code of related entry.
17 - 20        IDcode        idCode        ID code of related entry.
22 - 25        IDcode        idCode        ID code of related entry.
27 – 30        IDcode        idCode        ID code of related entry.
32 - 35        IDcode        idCode        ID code of related entry.
37 - 40        IDcode        idCode        ID code of related entry.
42 - 45        IDcode        idCode        ID code of related entry.
47 - 50        IDcode        idCode        ID code of related entry.
52 - 55        IDcode        idCode        ID code of related entry.
57 - 60        IDcode        idCode        ID code of related entry.
62 - 65        IDcode        idCode        ID code of related entry.
67 - 70        IDcode        idCode        ID code of related entry.
72 - 75        IDcode        idCode        ID code of related entry.
77 - 80        IDcode        idCode        ID code of related entry.
 */
class SplitParser : AbstractParser<List<String>>() {

    override fun match(line: String): Boolean {
        return line.startsWith("SPLIT ")
    }

    override fun parser(): List<String> {
        return lines.flatMap { line ->
            line.substring(12 - 1)
                .split(" ")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
        }
    }
}