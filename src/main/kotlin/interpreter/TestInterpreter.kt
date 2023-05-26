package interpreter

import interpreter.nonterminals.SelectExpression
import java.text.SimpleDateFormat
import java.util.*


fun main(){
    val select: SelectExpression? = InterpreterMain.getById()//InterpreterMain.findByTwoID(arrayOf(5,9))//InterpreterMain.findByDate("07/12/1974")//InterpreterMain.getById(15)
    println(select.toString())

    val context = Context("C:\\Users\\sandr\\Downloads\\backend-main\\backend-main\\src\\main\\kotlin\\interpreter\\Employees.xls")
    context.setDateFormat(SimpleDateFormat("dd/MM/yyyy"))
    try {
        val output = select!!.interpret(context)
        for (`object` in output!!) {

            println(Arrays.toString(`object`))
        }
    } catch (e: InterpreterException) {
        e.printStackTrace()
    } finally {
        context.destroy()
    }
}