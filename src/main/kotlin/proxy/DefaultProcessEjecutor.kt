package proxy

class DefaultProcessEjecutor : IProcessEjecutor {
    @Throws(Exception::class)
    override fun ejecuteProcess(idProcess: Int, user: String?, password: String?) {
        println("procesos $idProcess en ejecución")
        println("procesos $idProcess terminado")
    }
}
//ejecutar los procesos, sin embargo,
//controlaremos su creación por medio del Factory para asegurarnos de regresarle
//un proxy en lugar de una instancia de esta clase. La clase hereda de
//IProcessEjecutor.