package org.example.TEMA2.sql.aceituna.almazara;



import org.example.TEMA2.sql.aceituna.FactoriaConexion;
import org.example.TEMA2.sql.aceituna.olivar.DAOOlivar;
import org.example.TEMA2.sql.aceituna.trabajador.DAOTrabajador;

import java.sql.*;
import java.util.ArrayList;

public class DAOAlmazara implements InterfaceAlmazara{
    private final Connection con=FactoriaConexion.getConnection();
    @Override
    public Almazara findById(int id) {
        Almazara almazara = new Almazara();
        String sql = "SELECT * FROM almazara WHERE id = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                almazara.setId(rs.getInt("id"));
                almazara.setNombre(rs.getString("nombre"));
                almazara.setUbicacion(rs.getString("ubicacion"));
                almazara.setCapacidad(rs.getInt("capacidad"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return almazara;
    }

    @Override
    public ArrayList<Almazara> findByName(String nombre) {
        ArrayList<Almazara>almazaras = new ArrayList<Almazara>();
        String sql = "SELECT * FROM almazara WHERE nombre = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1,nombre);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Almazara almazara = new Almazara();
                almazara.setId(rs.getInt("id"));
                almazara.setNombre(rs.getString("nombre"));
                almazara.setUbicacion(rs.getString("ubicacion"));
                almazara.setCapacidad(rs.getInt("capacidad"));
                almazaras.add(almazara);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return almazaras;
    }

    @Override
    public ArrayList<Almazara> findByUbicacion(String ubicacion) {
        ArrayList<Almazara>almazaras = new ArrayList<Almazara>();
        String sql = "SELECT * FROM almazara WHERE ubicacion = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1,ubicacion);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Almazara almazara = new Almazara();
                almazara.setId(rs.getInt("id"));
                almazara.setNombre(rs.getString("nombre"));
                almazara.setUbicacion(rs.getString("ubicacion"));
                almazara.setCapacidad(rs.getInt("capacidad"));
                almazaras.add(almazara);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return almazaras;
    }

    @Override
    public ArrayList<Almazara> findByCapacidad(double capacidad) {
        ArrayList<Almazara>almazaras = new ArrayList<Almazara>();
        String sql = "SELECT * FROM almazara WHERE capacidad = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setDouble(1,capacidad);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Almazara almazara = new Almazara();
                almazara.setId(rs.getInt("id"));
                almazara.setNombre(rs.getString("nombre"));
                almazara.setUbicacion(rs.getString("ubicacion"));
                almazara.setCapacidad(rs.getInt("capacidad"));
                almazaras.add(almazara);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return almazaras;
    }

    @Override
    public ArrayList<Almazara> findAll() {
        ArrayList<Almazara>almazaras = new ArrayList<Almazara>();
        String sql = "SELECT * FROM almazara";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Almazara almazara = new Almazara();
                almazara.setId(rs.getInt("id"));
                almazara.setNombre(rs.getString("nombre"));
                almazara.setUbicacion(rs.getString("ubicacion"));
                almazara.setCapacidad(rs.getInt("capacidad"));
                almazaras.add(almazara);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return almazaras;
    }

    @Override
    public void add(Almazara almazara) {

    }

    @Override
    public void update(Almazara almazara) {

    }

    @Override
    public void delete(Almazara almazara) {

    }
}
