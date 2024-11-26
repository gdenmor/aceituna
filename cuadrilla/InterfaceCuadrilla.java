package org.example.TEMA2.sql.aceituna.cuadrilla;

import java.util.ArrayList;

public interface InterfaceCuadrilla {
    Cuadrilla findById(int id);
    ArrayList<Cuadrilla> findByNombre(String nombre);
    ArrayList<Cuadrilla> findBySupervisor(int id);
    ArrayList<Cuadrilla> findAll();
    void add(Cuadrilla cuadrilla);
    void update(Cuadrilla cuadrilla);
    void delete(Cuadrilla cuadrilla);
    ArrayList<Cuadrilla> cuadrillasbyOlivar(int id);
    ArrayList<Cuadrilla> cuadrillasbyTrabajador(int id);
}
