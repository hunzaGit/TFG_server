/*package com.rodrigo.TFG_server.Negocio.Modulo_Empleado.Entidad;


import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

public class EmpleadoClassExtractor extends ClassExtractor {

    @Override
    public Class extractClassFromRow(Record record, Session session) {
        System.out.println("EmpleadoClassExtractor");
        if (null != record.get("@horasJornada")) {
            return EmpleadoTParcial.class;
        } else if (null != record.get("@antiguedad")) {
            return EmpleadoTCompleto.class;
        }
        return null;
    }


}*/