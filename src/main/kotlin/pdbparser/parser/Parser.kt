package pdbparser.parser

interface Parser<T> {
    fun collect(line: String)
    fun parser(): T
}

abstract class AbstractParser<T> : Parser<T> {

    protected val lines = mutableListOf<String>()

    override fun collect(line: String) {
        if (match(line)) {
            lines.add(line)
        }
    }

    protected abstract fun match(line: String): Boolean
}