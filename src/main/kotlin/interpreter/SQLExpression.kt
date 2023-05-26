package interpreter

interface SQLExpression {
    @Throws(InterpreterException::class)
    fun interpret(context: Context): Any?
}