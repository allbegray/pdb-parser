package pdbparser.model

// https://www.wwpdb.org/documentation/file-format-content/format33/sect2.html#HEADER
data class Header(val classification: String, val depDate: String, val idCode: String)

// https://www.wwpdb.org/documentation/file-format-content/format33/sect2.html#OBSLTE
data class Obslte(val repDate: String, val idCode: String, val rIdCode: List<String>)

// https://www.wwpdb.org/documentation/file-format-content/format33/sect2.html#CAVEAT
data class Caveat(val idCode: String, val comment: String)

data class Compnd(val token: Token, val value: String) {
    enum class Token {
        MOL_ID, MOLECULE, CHAIN, FRAGMENT, SYNONYM, EC, ENGINEERED, MUTATION, OTHER_DETAILS
    }
}