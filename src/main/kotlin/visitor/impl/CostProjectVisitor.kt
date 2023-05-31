package visitor.impl

import visitor.domain.Activity
import visitor.domain.Employee
import visitor.domain.Project

class CostProjectVisitor : IVisitor<Double> {
    override var result: Double = 0.0

    override fun visit(activity: Activity?) {
        activity?.responsible?.accept(this)
        activity?.activities?.forEach { subActivity ->
            subActivity.accept(this)
        }
    }

    override fun visit(employee: Employee?) {
        employee?.let { result += it.price }
    }

    override fun visit(project: Project?) {
        project?.activities?.forEach { activity ->
            activity.accept(this)
        }
    }
}
