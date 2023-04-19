package proxy
import java.text.SimpleDateFormat
import java.util.*

class AuditService() {
    fun auditServiceUsed(user: String, service: String) {
        val formater = SimpleDateFormat("dd/MM/YYYY hh:mm:ss")
        println(
            user + " utilizo el servicio > "
                    + service + ", a las " + formater.format(Date())
        )
    }
}
//Simular el funcionamiento de un servicio de Auditoria, el cual
//recibe el usuario y el proceso que ejecutó. El servicio únicamente imprime en
//pantalla el registro de la ejecución junto con la fecha y hora.