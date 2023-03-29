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