package visitor.impl

import visitor.domain.Activity
import visitor.domain.Employee
import visitor.domain.Project

class PriceProjectVisitor : IVisitor<Number> {
    private var totalPrice = 0.0

    override fun visit(activity: Activity?) {
        totalPrice += activity?.price ?: 0.0
        activity?.activities?.forEach { subActivity ->
            subActivity.accept(this)
        }
    }

    override fun visit(employee: Employee?) {
        // No es relevante para este visitor
    }

    override fun visit(project: Project?) {
        project?.activities?.forEach { activity ->
            activity.accept(this)
        }
    }

    override val result: Number
        get() = totalPrice
}
