package org.example.TEMA2.sql.aceituna.trabajador;

import java.util.ArrayList;

public interface InterfaceTrabajador {
    ArrayList<Trabajador> findAll();
    Trabajador findById(int id);
    ArrayList<Trabajador> findByNombre(String nombre);
    ArrayList<Trabajador> findByEdad(int edad);
    ArrayList<Trabajador> findByPuesto(String puesto);
    ArrayList<Trabajador> findBySalario(double salario);
    void save(Trabajador trabajador);
    void delete(Trabajador trabajador);
    void update(Trabajador trabajador);
    ArrayList<Trabajador> trabajadoresByCuadrilla(int id);
}
