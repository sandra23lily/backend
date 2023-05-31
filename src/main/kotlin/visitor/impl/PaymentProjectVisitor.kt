package visitor.impl

import visitor.domain.Activity
import visitor.domain.Employee
import visitor.domain.EmployeePay
import visitor.domain.Project

class PaymentProjectVisitor : IVisitor<List<EmployeePay>> {
    private val employeePayment: MutableMap<String, Double> = HashMap()

    override fun visit(activity: Activity?) {
        activity?.responsible?.accept(this)
        activity?.activities?.forEach { subActivity ->
            subActivity.accept(this)
        }
    }

    override fun visit(employee: Employee?) {
        employee?.let {
            val resp: String = it.name ?: ""
            employeePayment[resp] = employeePayment.getOrDefault(resp, 0.0) + it.price
        }
    }

    override fun visit(project: Project?) {
        project?.activities?.forEach { activity ->
            activity.accept(this)
        }
    }

    override val result: List<EmployeePay>
        get() {
            val response: MutableList<EmployeePay> = ArrayList()
            employeePayment.forEach { (key, value) ->
                response.add(EmployeePay(key, value))
            }
            return response
        }
}
