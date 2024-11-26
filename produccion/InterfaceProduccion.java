package org.example.TEMA2.sql.aceituna.produccion;

import java.sql.Date;
import java.util.ArrayList;


public interface InterfaceProduccion {
    ArrayList<Produccion> findAll();
    Produccion findById(int id);
    ArrayList<Produccion> findByCuadrilla(int id);
    ArrayList<Produccion> findByOlivar(int id);
    ArrayList<Produccion> findByAlmazara(int id);
    ArrayList<Produccion> findByFecha(Date fecha);
    ArrayList<Produccion> findByCantidad(double cantidad);
    void add(Produccion produccion);
    void remove(Produccion produccion);
    void update(Produccion produccion);
}
