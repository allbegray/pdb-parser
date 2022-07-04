package pdbparser.parser

import pdbparser.model.Compnd

/*
COLUMNS       DATA TYPE       FIELD         DEFINITION
----------------------------------------------------------------------------------
 1 -  6       Record name     "COMPND"
 8 - 10       Continuation    continuation  Allows concatenation of multiple records.
11 - 80       Specification   compound      Description of the molecular components.
              list
 */
class CompndParser : AbstractParser<List<Pair<Compnd.Token, String>>>() {

    override fun match(line: String): Boolean {
        return line.startsWith("COMPND")
    }

    override fun parser(): List<Pair<Compnd.Token, String>> {
        val tokens = Compnd.Token.values().map { it.name }.toSet()

        return mutableListOf<Pair<String, String>>().also { items ->
            for (line in lines) {
                val trim = line.substring(11 - 1).trim()
                var findToken: String = ""
                for (token in tokens) {
                    if (trim.startsWith("$token:")) {
                        findToken = token
                        break
                    }
                }
                if (findToken.isNotEmpty()) {
                    items.add(findToken to trim.substring(findToken.length + 1))
                } else {
                    val last = items.last()
                    items[items.lastIndex] = last.copy(second = last.second + " " + trim)
                }
            }
        }.map { (t, v) ->
            Compnd.Token.valueOf(t) to v.trim().let {
                if (it.last() == ';') {
                    it.dropLast(1)
                } else {
                    it
                }
            }
        }
    }
}