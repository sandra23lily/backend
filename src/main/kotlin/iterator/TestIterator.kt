import iterator.Employee

//Clase principal de la aplicación desde la cual probaremos la efectividad del patrón Iterator.
object TestIterator {
    @JvmStatic
    fun main(args: Array<String>) {
        val employee = Employee(
            "Juan", "CEO",
            Employee(
                "Pedro", "President",
                Employee(
                    "Liliana", "VP",
                    Employee(
                        "Oscar", "Manager",
                        Employee("Mario", "Developer"),
                        Employee("Rodolfo", "Developer")
                    ),
                    Employee(
                        "Sofia", "Manager",
                        Employee("Adrian", "Sr Developer"),
                        Employee("Rebeca", "Developer")
                    )
                )
            )
        )
        val empIterator: IIterator<Employee?>? = employee.createIterator()
        while (empIterator?.hasNext() == true) {
            val emp: Employee? = empIterator.next()
            println("emp > $emp")
        }
    }
}

//En la pantalla podremos ver que todos los empleados creados en forma de árbol son recorridos de forma lineal y esto lo hicimos sin saber cómo es que está implementada
// la estructura de datos internamente, sólo fue necesario crear el iterador e iterar los elementos.