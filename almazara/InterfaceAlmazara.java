package org.example.TEMA2.sql.aceituna.almazara;

import java.util.ArrayList;

public interface InterfaceAlmazara {
    Almazara findById(int id);
    ArrayList<Almazara> findByName(String nombre);
    ArrayList<Almazara> findByUbicacion(String ubicacion);
    ArrayList<Almazara> findByCapacidad(double capacidad);
    ArrayList<Almazara>findAll();
    void add(Almazara almazara);
    void update(Almazara almazara);
    void delete(Almazara almazara);
}
