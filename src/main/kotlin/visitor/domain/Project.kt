package visitor.domain

import visitor.impl.IVisitable
import visitor.impl.IVisitor
import java.util.*
import javax.xml.bind.annotation.*

@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
class Project : IVisitable {
    @XmlAttribute(name = "name")
    var name: String? = null

    @XmlElementWrapper(name = "Activities")
    @XmlElement(name = "Activity")
    var activities: List<Activity>? = null
        get() {
            if (field == null) {
                field = ArrayList()
            }
            return field
        }

    constructor()
    constructor(name: String?) {
        this.name = name
    }

    override fun accept(visitor: IVisitor<*>) {
        visitor.visit(this)
    }
}
