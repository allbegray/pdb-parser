package pdbparser

import pdbparser.model.Caveat
import pdbparser.model.Compnd
import pdbparser.model.Header
import pdbparser.model.Obslte

data class Structure(
    val header: Header? = null,
    val obsltes: List<Obslte> = emptyList(),
    val title: String? = null,
    val splits: List<String> = emptyList(),
    val caveats: List<Caveat> = emptyList(),
    val compnds: List<Pair<Compnd.Token, String>> = emptyList(),
)