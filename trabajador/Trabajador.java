package org.example.TEMA2.sql.aceituna.trabajador;

import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrilla;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
@XmlRootElement(name = "Trabajador")
public class Trabajador {

    private int id;

    private String nombre;

    private int edad;

    private String puesto;

    private double salario;

    private ArrayList<Cuadrilla>cuadrillas;

    public Trabajador() {}
    public Trabajador(int id, String nombre, int edad, String puesto, double salario,ArrayList<Cuadrilla> cuadrillas) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
        this.cuadrillas = cuadrillas;
    }

    public Trabajador(int id, String nombre, int edad, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;

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
    @XmlElement(name = "Edad")
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @XmlElement(name = "Puesto")
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    @XmlElement(name = "Salario")
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
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
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}'+"\n";
    }
}
