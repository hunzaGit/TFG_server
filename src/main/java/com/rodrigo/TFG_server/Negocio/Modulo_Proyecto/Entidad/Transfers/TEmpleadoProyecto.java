package com.rodrigo.TFG_server.Negocio.Modulo_Proyecto.Entidad.Transfers;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author Rodrigo de Miguel González
 * @Date 2017-2018
 * TFG - Atravesando las Capas de una Aplicación Empresarial: Demostrador Tecnológico J2EE
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TEmpleadoProyecto {



    private Long empleado;


    private Long proyecto;


    private int horas;




    public TEmpleadoProyecto() {}


    public TEmpleadoProyecto(Long empleado, Long proyecto, int horas) {
        this.empleado = empleado;
        this.proyecto = proyecto;
        this.horas = horas;
    }


    public Long getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Long empleado) {
        this.empleado = empleado;
    }

    public Long getProyecto() {
        return proyecto;
    }

    public void setProyecto(Long proyecto) {
        this.proyecto = proyecto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }


    @Override
    public String toString() {
        return "TEmpleadoProyecto{" +
                "empleado=" + empleado +
                ", proyecto=" + proyecto +
                ", horas=" + horas +
                '}';
    }
}
