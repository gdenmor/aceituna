package org.example.TEMA2.sql.aceituna.olivar;



import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrilla;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
@XmlRootElement(name = "Olivar")

public class Olivar {

    private int id;

    private String ubicacion;

    private double hectareas;

    private double produccionAnual;

    private ArrayList<Cuadrilla> cuadrillas;
    public Olivar() {}
    public Olivar(int id,String ubicacion, double hectareas, double produccionAnual,ArrayList<Cuadrilla> cuadrillas) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.hectareas = hectareas;
        this.produccionAnual = produccionAnual;
        this.cuadrillas = cuadrillas;
    }

    public Olivar(int id, String ubicacion, double hectareas, double produccionAnual) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.hectareas = hectareas;
        this.produccionAnual = produccionAnual;
    }

    @XmlElement(name = "Id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "Ubicacion")
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    @XmlElement(name = "Hectareas")
    public double getHectareas() {
        return hectareas;
    }
    public void setHectareas(double hectareas) {
        this.hectareas = hectareas;
    }
    @XmlElement(name = "ProduccionAnual")
    public double getProduccionAnual() {
        return produccionAnual;
    }
    public void setProduccionAnual(double produccionAnual) {
        this.produccionAnual = produccionAnual;
    }
    @XmlElementWrapper(name = "Cuadrillas")
    @XmlElement(name = "Cuadrilla")
    public ArrayList<Cuadrilla> getCuadrillas() {
        return cuadrillas;
    }
    public void setCuadrillas(ArrayList<Cuadrilla> cuadrilas) {
        this.cuadrillas = cuadrilas;
    }

    @Override
    public String toString() {
        return "Olivar{" +
                "id=" + id +
                ", ubicacion='" + ubicacion + '\'' +
                ", hectareas=" + hectareas +
                ", produccionAnual=" + produccionAnual +
                '}';
    }
}
