interface IIterator<T> {
    operator fun hasNext(): Boolean
    operator fun next(): T
}
//Interface que define los métodos mínimos que un iterador debe tener. Se define un tipo genérico el cual será sobrescrito por la implementación.