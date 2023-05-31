package visitor.impl

interface IVisitable {
    fun accept(visitor: IVisitor<*>)
}
