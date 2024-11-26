package org.example.TEMA2.sql.aceituna.produccion;

import org.example.TEMA2.sql.aceituna.almazara.Almazara;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Producciones")
public class Producciones {
    private ArrayList<Produccion> producciones;
    public Producciones() {
        this.producciones = new ArrayList<Produccion>();
    }

    @XmlElement(name = "Produccion")
    public ArrayList<Produccion> getProduccion() {
        return producciones;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }

    @Override
    public String toString() {
        return "Producciones{" +
                "producciones=" + producciones +
                '}';
    }
}
