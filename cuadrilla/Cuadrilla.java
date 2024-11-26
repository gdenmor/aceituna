package org.example.TEMA2.sql.aceituna.cuadrilla;


import org.example.TEMA2.sql.aceituna.olivar.Olivar;
import org.example.TEMA2.sql.aceituna.trabajador.Trabajador;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name = "Cuadrilla")
public class Cuadrilla {

    private int id;

    private String nombre;

    private Trabajador supervisor;

    private ArrayList<Trabajador> trabajadores;

    private ArrayList<Olivar> olivares;
    public Cuadrilla(int id, String nombre, Trabajador supervisor,ArrayList<Trabajador> trabajadores,ArrayList<Olivar> olivares) {
        this.id = id;
        this.nombre = nombre;
        this.supervisor = supervisor;
        this.trabajadores = trabajadores;
        this.olivares = olivares;
    }

    public Cuadrilla() {

    }

    public Cuadrilla(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Cuadrilla(int id, String nombre, Trabajador supervisorId, ArrayList<Trabajador> id1) {
        this.id = id;
        this.nombre = nombre;
        this.supervisor = supervisorId;
        this.trabajadores = id1;
    }
    @XmlElement(name = "Id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "Nombre")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @XmlElement(name = "Supervisor")
    public Trabajador getSupervisor() {
        return supervisor;
    }
    public void setSupervisor(Trabajador supervisor) {
        this.supervisor = supervisor;
    }
    @XmlElementWrapper(name = "Trabajadores")
    @XmlElement(name = "Trabajador")
    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }
    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    @XmlElement(name = "Olivares")
    public ArrayList<Olivar> getOlivares() {
        return olivares;
    }
    public void setOlivares(ArrayList<Olivar> olivares) {
        this.olivares = olivares;
    }

    @Override
    public String toString() {
        return "Cuadrilla{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", supervisor=" + supervisor +
                ", olivares=" + olivares +
                '}';
    }
}
