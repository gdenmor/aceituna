package org.example.TEMA2.sql.aceituna.trabajador;

import org.example.TEMA2.sql.aceituna.almazara.Almazara;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Trabajadores")
public class Trabajadores {
    private ArrayList<Trabajador> trabajadores;
    public Trabajadores() {
        this.trabajadores = new ArrayList<Trabajador>();
    }

    @XmlElement(name = "Trabajador")
    public ArrayList<Trabajador> getTrabajador() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public String toString() {
        return "Trabajadores{" +
                "trabajadores=" + trabajadores +
                '}';
    }
}
