package visitor.impl

import visitor.domain.Activity
import visitor.domain.Employee
import visitor.domain.Project

interface IVisitor<T> {
    fun visit(activity: Activity?)
    fun visit(employee: Employee?)
    fun visit(project: Project?)
    val result: T
}
