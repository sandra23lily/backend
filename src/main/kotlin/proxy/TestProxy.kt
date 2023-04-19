package proxy

import proxy.ServiceFactory.createProcessEjecutor

object ProxyMain {
    @JvmStatic
    //configuran los parámetros para ejecutar el proceso.
    fun main(args: Array<String>) {
        val user = "lily"
        val password = "1234"
        val process = 1
        //se obtiene una instancia del Proxy por medio del Factory
        val processEjecutor = createProcessEjecutor()
        try {
            processEjecutor.ejecuteProcess(process, user, password)
        } catch (e: Exception) {
            //se ejecuta el proceso
            println(e.message)
        }
    }
}