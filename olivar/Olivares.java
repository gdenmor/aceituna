package org.example.TEMA2.sql.aceituna.olivar;

import org.example.TEMA2.sql.aceituna.almazara.Almazara;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Olivares")
public class Olivares {
    private ArrayList<Olivar> olivares;
    public Olivares() {
        this.olivares = new ArrayList<Olivar>();
    }

    @XmlElement(name = "Olivar")
    public ArrayList<Olivar> getOlivar() {
        return olivares;
    }

    public void setOlivares(ArrayList<Olivar> olivares) {
        this.olivares = olivares;
    }

    @Override
    public String toString() {
        return "Olivares{" +
                "olivares=" + olivares +
                '}';
    }
}
