package proxy

class ProcessEjecutorProxy : IProcessEjecutor {
    @Throws(Exception::class)
    //se realiza la validación de los privilegios del
    //usuario, si el usuario no existe o no tiene los privilegios suficientes el proceso
    //terminará sin haber llegado a la acción real.
    override fun ejecuteProcess(idProcess: Int, user: String?, password: String?) {
        val securityService = SecurityService()
        if (!securityService.authorization(user!!, password!!)) {
            throw Exception(
                "El usuario '" + user
                        + "' no tiene privilegios para ejecutar el proceso"
            )
        }
        // ejecución del proceso
        val ejecutorProcess = DefaultProcessEjecutor()
        ejecutorProcess.ejecuteProcess(idProcess, user, password)
        //e realiza la auditoria del proceso
        val audit = AuditService()
        audit.auditServiceUsed(user, DefaultProcessEjecutor::class.java.name)
    }
}
//Clase utilizada como Proxy, esta clase hereda de IProcessEjecutor al igual que
//DefaultProcessEjecutor, sin embargo, ésta no realiza realmente la tarea, en su
//lugar, valida los privilegios del usuario y luego delega la ejecución del proceso a
//DefaultProcessEjecutor y finalmente audita la ejecución.