package visitor.impl

import visitor.domain.Activity
import visitor.domain.Employee
import visitor.domain.Project

interface ProjectVisitor {
    fun visit(activity: Activity?)
    fun visit(employee: Employee?)
    fun visit(project: Project?)
}
