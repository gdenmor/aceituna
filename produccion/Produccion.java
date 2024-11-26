package org.example.TEMA2.sql.aceituna.produccion;



import org.example.TEMA2.sql.aceituna.almazara.Almazara;
import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrilla;
import org.example.TEMA2.sql.aceituna.olivar.Olivar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;

@XmlRootElement(name = "Produccion")
public class Produccion {

    private int idProduccion;

    private Cuadrilla cuadrilla;

    private Olivar olivar;

    private Almazara almazara;

    private Date fecha;

    private double cantidadRecolectada;

    public Produccion() {}
    public Produccion(int idProduccion,Cuadrilla cuadrilla,Olivar olivar,Almazara almazara, Date fecha,double cantidadRecolectada) {
        this.idProduccion = idProduccion;
        this.cuadrilla = cuadrilla;
        this.olivar = olivar;
        this.almazara = almazara;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
    }

    public Produccion(int id, Cuadrilla cuadrillaId, Object o, Date fecha, double cantidadRecolectada) {
        this.idProduccion = id;
        this.cuadrilla = cuadrillaId;
        this.olivar = (Olivar) o;
        this.almazara = (Almazara) o;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
    }

    public Produccion(int id, Cuadrilla cuadrillaId, Date fecha, double cantidadRecolectada) {
        this.idProduccion = id;
        this.cuadrilla = cuadrillaId;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
    }
    @XmlElement(name = "idProduccion")
    public int getIdProduccion() {
        return idProduccion;
    }
    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }
    @XmlElement(name = "Cuadrilla")
    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }
    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }
    @XmlElement(name = "Olivar")
    public Olivar getOlivar() {
        return olivar;
    }
    public void setOlivar(Olivar olivar) {
        this.olivar = olivar;
    }
    @XmlElement(name = "Almazara")
    public Almazara getAlmazara() {
        return almazara;
    }
    public void setAlmazara(Almazara almazara) {
        this.almazara = almazara;
    }
    @XmlElement(name = "Fecha")
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @XmlElement(name = "CantidadRecolectada")
    public double getCantidadRecolectada() {
        return cantidadRecolectada;
    }
    public void setCantidadRecolectada(double cantidadRecolectada) {
        this.cantidadRecolectada = cantidadRecolectada;
    }

    @Override
    public String toString() {
        return "Produccion{" +
                "idProduccion=" + idProduccion +
                ", cuadrilla=" + cuadrilla +
                ", olivar=" + olivar +
                ", almazara=" + almazara +
                ", fecha=" + fecha +
                ", cantidadRecolectada=" + cantidadRecolectada +
                '}';
    }
}
