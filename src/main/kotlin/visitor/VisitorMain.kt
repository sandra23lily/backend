package visitor
import visitor.domain.Activity
import visitor.domain.Project
import java.io.File
import javax.xml.bind.JAXBContext

object VisitorMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val xmlFilePath = "C:\\Users\\karlo\\OneDrive\\Escritorio\\backend-develop\\backend-develop\\src\\main\\kotlin\\visitor\\Project.xml"

        // Cargar el archivo XML
        val project: Project?
        try {
            val context = JAXBContext.newInstance(Project::class.java)
            val unmarshaller = context.createUnmarshaller()
            val file = File(xmlFilePath)
            project = unmarshaller.unmarshal(file) as Project
        } catch (e: Exception) {
            println("Error al cargar el archivo XML: ${e.message}")
            e.printStackTrace()
            return
        }

        println("Nombre del proyecto: ${project.name}")

        project.activities?.forEach { activitie: Activity ->
            println("Actividad: ${activitie.name}, Precio: ${activitie.price}")

            activitie.responsible?.let { responsible ->
                println("Responsable: ${responsible.name}, Precio: ${responsible.price}")
            }

            activitie.activities?.forEach { subactivitie: Activity ->
                println("Subactividad: ${subactivitie.name}, Precio: ${subactivitie.price}")

                subactivitie.responsible?.let { subResponsible ->
                    println("Responsable de subactividad: ${subResponsible.name}, Precio: ${subResponsible.price}")
                }
            }
        }
    }
}
