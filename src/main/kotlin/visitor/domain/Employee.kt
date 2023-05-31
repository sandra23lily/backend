package visitor.domain

import visitor.impl.IVisitable
import visitor.impl.IVisitor
import java.util.*
import javax.xml.bind.annotation.*

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
abstract class Employee : IVisitable {
    @XmlAttribute(name = "name")
    var name: String? = null

    @XmlAttribute(name = "price")
    var price = 0.0 // for Hour

    constructor()
    constructor(name: String?, price: Double) {
        this.name = name
        this.price = price
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.visit(this)
    }

    override fun hashCode(): Int {
        return Objects.hash(name)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val employee = other as Employee
        return name == employee.name
    }
}
