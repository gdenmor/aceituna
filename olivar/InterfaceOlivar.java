package org.example.TEMA2.sql.aceituna.olivar;

import java.util.ArrayList;

public interface InterfaceOlivar {
    ArrayList<Olivar> findAll();
    Olivar findById(int id);
    ArrayList<Olivar> findByUbicacion(String ubicacion);
    ArrayList<Olivar> findByHectareas(double hectareas);
    ArrayList<Olivar> findByProduccionAnual(double produccionAnual);
    void add(Olivar olivar);
    void update(Olivar olivar);
    void delete(Olivar olivar);
    ArrayList<Olivar> olivaresbyCuadrilla(int id);
}
