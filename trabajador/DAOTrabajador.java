package org.example.TEMA2.sql.aceituna.trabajador;


import org.example.TEMA2.sql.aceituna.FactoriaConexion;
import org.example.TEMA2.sql.aceituna.almazara.DAOAlmazara;
import org.example.TEMA2.sql.aceituna.cuadrilla.DAOCuadrilla;
import org.example.TEMA2.sql.aceituna.olivar.DAOOlivar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOTrabajador implements InterfaceTrabajador {
    private final Connection con=FactoriaConexion.getConnection();
    @Override
    public ArrayList<Trabajador> findAll() {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        String sql = "SELECT * FROM trabajador";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }

    @Override
    public Trabajador findById(int id) {
        Trabajador trabajador=null;
        String sql = "SELECT * FROM trabajador WHERE id = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajador;
    }

    @Override
    public ArrayList<Trabajador> findByNombre(String nombre) {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        String sql = "SELECT * FROM trabajador where nombre = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, nombre);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }

    @Override
    public ArrayList<Trabajador> findByEdad(int edad) {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        String sql = "SELECT * FROM trabajador where edad = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, edad);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }

    @Override
    public ArrayList<Trabajador> findByPuesto(String puesto) {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        String sql = "SELECT * FROM trabajador where puesto = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, puesto);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }

    @Override
    public ArrayList<Trabajador> findBySalario(double salario) {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        String sql = "SELECT * FROM trabajador where salario=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setDouble(1, salario);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }

    @Override
    public void save(Trabajador trabajador) {

    }

    @Override
    public void delete(Trabajador trabajador) {

    }

    @Override
    public void update(Trabajador trabajador) {

    }

    @Override
    public ArrayList<Trabajador> trabajadoresByCuadrilla(int id) {
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        String sql = "SELECT t.* FROM trabajador t inner join Cuadrilla_Trabajador ct on t.id=ct.trabajador_id where ct.cuadrilla_id=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Trabajador trabajador=new Trabajador();
                trabajador.setId(rs.getInt("id"));
                trabajador.setNombre(rs.getString("nombre"));
                trabajador.setEdad(rs.getInt("edad"));
                trabajador.setPuesto(rs.getString("puesto"));
                trabajador.setSalario(rs.getDouble("salario"));
                trabajadores.add(trabajador);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return trabajadores;
    }
}
