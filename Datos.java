package org.example.TEMA2.sql.aceituna;

import org.example.TEMA2.sql.aceituna.almazara.Almazara;
import org.example.TEMA2.sql.aceituna.almazara.Almazaras;
import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrilla;
import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrillas;
import org.example.TEMA2.sql.aceituna.olivar.Olivar;
import org.example.TEMA2.sql.aceituna.olivar.Olivares;
import org.example.TEMA2.sql.aceituna.produccion.Produccion;
import org.example.TEMA2.sql.aceituna.produccion.Producciones;
import org.example.TEMA2.sql.aceituna.trabajador.Trabajador;
import org.example.TEMA2.sql.aceituna.trabajador.Trabajadores;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name = "Datos")
@XmlType(propOrder = {"almazaras", "cuadrillas", "olivares", "producciones", "trabajadores"})
public class Datos {

    private ArrayList<Almazaras> almazaras;

    private ArrayList<Cuadrillas> cuadrillas;

    private ArrayList<Olivares> olivares;

    private ArrayList<Producciones> producciones;

    private ArrayList<Trabajadores> trabajadores;
    public Datos() {
        this.almazaras = new ArrayList<>();
        this.cuadrillas = new ArrayList<>();
        this.olivares = new ArrayList<>();
        this.producciones = new ArrayList<>();
        this.trabajadores = new ArrayList<>();
    }

    @XmlElement(name = "Almazaras")
    public ArrayList<Almazaras> getAlmazaras() {
        return almazaras;
    }
    public void setalmazaras(ArrayList<Almazaras> almazaras) {
        this.almazaras = almazaras;
    }
    @XmlElement(name = "Cuadrillas")
    public ArrayList<Cuadrillas> getCuadrillas() {
        return cuadrillas;
    }
    public void setcuadrillas(ArrayList<Cuadrillas> cuadrilas) {
        this.cuadrillas = cuadrilas;
    }
    @XmlElement(name = "Olivares")
    public ArrayList<Olivares> getOlivares() {
        return olivares;
    }
    public void setolivares(ArrayList<Olivares> olivas) {
        this.olivares = olivas;
    }
    @XmlElement(name = "Producciones")
    public ArrayList<Producciones> getProducciones() {
        return producciones;
    }
    public void setproducciones(ArrayList<Producciones> producciones) {
        this.producciones = producciones;
    }
    @XmlElement(name = "Trabajadores")
    public ArrayList<Trabajadores> getTrabajadores() {
        return trabajadores;
    }
    public void settrabajadores(ArrayList<Trabajadores> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "almazaras=" + almazaras +
                ", cuadrillas=" + cuadrillas +
                ", olivares=" + olivares +
                ", producciones=" + producciones +
                ", trabajadores=" + trabajadores +
                '}';
    }
}
