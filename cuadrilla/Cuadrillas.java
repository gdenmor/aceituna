package org.example.TEMA2.sql.aceituna.cuadrilla;

import org.example.TEMA2.sql.aceituna.almazara.Almazara;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Cuadrillas")
public class Cuadrillas {
    private ArrayList<Cuadrilla> cuadrillas;
    public Cuadrillas() {
        this.cuadrillas = new ArrayList<Cuadrilla>();
    }

    @XmlElement(name = "Cuadrilla")
    public ArrayList<Cuadrilla> getCuadrilla() {
        return cuadrillas;
    }

    public void setCuadrillas(ArrayList<Cuadrilla> cuadrillas) {
        this.cuadrillas = cuadrillas;
    }

    @Override
    public String toString() {
        return "Cuadrillas{" +
                "cuadrillas=" + cuadrillas +
                '}';
    }
}
