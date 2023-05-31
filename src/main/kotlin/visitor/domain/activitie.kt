package visitor.domain

import visitor.impl.IVisitable
import visitor.impl.IVisitor
import java.util.*
import javax.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Activity::class)
abstract class Activity : IVisitable {
    @XmlAttribute(name = "name")
    var name: String? = null

    @XmlAttribute(name = "price")
    var price = 0.0

    @XmlElement(name = "Responsible")
    var responsible: Employee? = null

    @XmlElement(name = "Activities")
    var activities: List<Activity>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    constructor()
    constructor(name: String?, price: Double, responsible: Employee?) {
        this.name = name
        this.price = price
        this.responsible = responsible
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.visit(this)
    }
}

