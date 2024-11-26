package org.example.TEMA2.sql.aceituna.olivar;



import org.example.TEMA2.sql.aceituna.FactoriaConexion;
import org.example.TEMA2.sql.aceituna.almazara.DAOAlmazara;
import org.example.TEMA2.sql.aceituna.cuadrilla.DAOCuadrilla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOOlivar implements InterfaceOlivar {
    private final Connection con=FactoriaConexion.getConnection();
    @Override
    public ArrayList<Olivar> findAll() {
        ArrayList<Olivar>olivares=new ArrayList<Olivar>();
        String sql="SELECT * FROM olivar";
        try (PreparedStatement stmt=con.prepareStatement(sql)){
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Olivar olivar=new Olivar();
                olivar.setId(rs.getInt("id"));
                olivar.setUbicacion(rs.getString("ubicacion"));
                olivar.setHectareas(rs.getDouble("hectareas"));
                olivar.setProduccionAnual(rs.getDouble("produccionAnual"));
                olivares.add(olivar);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return olivares;
    }

    @Override
    public Olivar findById(int id) {
        Olivar olivar=new Olivar();
        String sql="select * from olivar where id=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if (rs.next()){
                olivar.setId(rs.getInt("id"));
                olivar.setUbicacion(rs.getString("ubicacion"));
                olivar.setHectareas(rs.getDouble("hectareas"));
                olivar.setProduccionAnual(rs.getDouble("produccionAnual"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return olivar;
    }

    @Override
    public ArrayList<Olivar> findByUbicacion(String ubicacion) {
        ArrayList<Olivar>olivares=new ArrayList<Olivar>();
        String sql="SELECT * FROM olivar where ubicacion = ?";
        try (PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, ubicacion);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Olivar olivar=new Olivar();
                olivar.setId(rs.getInt("id"));
                olivar.setUbicacion(rs.getString("ubicacion"));
                olivar.setHectareas(rs.getDouble("hectareas"));
                olivar.setProduccionAnual(rs.getDouble("produccionAnual"));
                olivares.add(olivar);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return olivares;
    }

    @Override
    public ArrayList<Olivar> findByHectareas(double hectareas) {
        ArrayList<Olivar>olivares=new ArrayList<Olivar>();
        String sql="SELECT * FROM olivar where hectareas = ?";
        try (PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setDouble(1, hectareas);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Olivar olivar=new Olivar();
                olivar.setId(rs.getInt("id"));
                olivar.setUbicacion(rs.getString("ubicacion"));
                olivar.setHectareas(rs.getDouble("hectareas"));
                olivar.setProduccionAnual(rs.getDouble("produccionAnual"));
                olivares.add(olivar);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return olivares;
    }

    @Override
    public ArrayList<Olivar> findByProduccionAnual(double produccionAnual) {
        ArrayList<Olivar>olivares=new ArrayList<Olivar>();
        String sql="SELECT * FROM olivar where produccionAnual = ?";
        try (PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setDouble(1, produccionAnual);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Olivar olivar=new Olivar();
                olivar.setId(rs.getInt("id"));
                olivar.setUbicacion(rs.getString("ubicacion"));
                olivar.setHectareas(rs.getDouble("hectareas"));
                olivar.setProduccionAnual(rs.getDouble("produccionAnual"));
                olivares.add(olivar);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return olivares;
    }

    @Override
    public void add(Olivar olivar) {

    }

    @Override
    public void update(Olivar olivar) {

    }

    @Override
    public void delete(Olivar olivar) {

    }

    @Override
    public ArrayList<Olivar> olivaresbyCuadrilla(int id) {
        ArrayList<Olivar>olivares=new ArrayList<Olivar>();
        String sql="SELECT o.* FROM olivar o inner join Cuadrilla_Olivar co on o.id=co.olivar_id where co.cuadrilla_id=?";
        try (PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                Olivar olivar=new Olivar();
                olivar.setId(rs.getInt("id"));
                olivar.setUbicacion(rs.getString("ubicacion"));
                olivar.setHectareas(rs.getDouble("hectareas"));
                olivar.setProduccionAnual(rs.getDouble("produccionAnual"));
                olivares.add(olivar);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return olivares;
    }
}
