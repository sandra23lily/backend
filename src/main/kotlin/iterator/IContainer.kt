package iterator

import IIterator

interface IContainer<T> {
    fun createIterator(): IIterator<T>?
}

//Interface que debe implementar las clases que quieran ser iteradas,
// la interface tiene un tipo genérico con el fin de que sea más fácil para el cliente utilizar el iterador.