package proxy
//el cual es el encargado de ejecutar los
//procesos mediante el idProces. El usuario y password se utilizan para la
//autorización.

interface IProcessEjecutor {
    @Throws(Exception::class)
    fun ejecuteProcess(idProcess: Int, user: String?, password: String?)
}
//Interface que define la estructura de los ejecutores de procesos así como de los
//Proxys.