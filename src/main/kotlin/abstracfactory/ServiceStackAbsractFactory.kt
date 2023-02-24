package abstractfactory

import properties.PropertiesUtil.loadProperty
import kotlin.reflect.full.createInstance

class  ServiceStackAbsractFactory {
    fun createServiceFactory(): IServiceStackAbstractFactory? {
        val property = loadProperty(
            "properties/abstractfactory"
        )
        val factoryClass = property!!.getProperty("serviceProductimplClass")
        return try {
            Class.forName(factoryClass).kotlin.createInstance()
                    as IServiceStackAbstractFactory
        } catch (e: Exception){
        e.printStackTrace()
        null
    }

    }

}