package org.example.TEMA2.sql.aceituna.almazara;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Almazaras")
public class Almazaras {
    private ArrayList<Almazara> almazaras;
    @XmlElement(name = "Almazara")
    public ArrayList<Almazara> getAlmazara() {
        return almazaras;
    }

    public void setAlmazaras(ArrayList<Almazara> almazaras) {
        this.almazaras = almazaras;
    }

    public Almazaras() {
        this.almazaras = new ArrayList<Almazara>();
    }

    @Override
    public String toString() {
        return "Almazaras{" +
                "almazaras=" + almazaras +
                '}';
    }
}
