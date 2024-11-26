package org.example.TEMA2.sql.aceituna.cuadrilla;

import org.example.TEMA2.sql.aceituna.FactoriaConexion;
import org.example.TEMA2.sql.aceituna.olivar.DAOOlivar;
import org.example.TEMA2.sql.aceituna.trabajador.DAOTrabajador;
import org.example.TEMA2.sql.profesores_asignaturas.Conexion;


import java.sql.*;
import java.util.ArrayList;

public class DAOCuadrilla implements InterfaceCuadrilla{
    private final Connection con=FactoriaConexion.getConnection();
    @Override
    public Cuadrilla findById(int id) {
        Cuadrilla cuadrilla = null;
        String sql="SELECT * FROM cuadrilla WHERE id = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOTrabajador daoTrabajador=new DAOTrabajador();
            if(rs.next()){
                cuadrilla=new Cuadrilla();
                cuadrilla.setId(rs.getInt("id"));
                cuadrilla.setNombre(rs.getString("nombre"));
                cuadrilla.setSupervisor(daoTrabajador.findById(rs.getInt("supervisor_id")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuadrilla;
    }

    @Override
    public ArrayList<Cuadrilla> findByNombre(String nombre) {
        ArrayList<Cuadrilla>cuadrillas=new ArrayList<Cuadrilla>();
        String sql="SELECT * FROM cuadrilla WHERE nombre = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setString(1, nombre);
            ResultSet rs=stmt.executeQuery();
            DAOTrabajador daoTrabajador=new DAOTrabajador();
            while (rs.next()){
                Cuadrilla cuadrilla=new Cuadrilla();
                cuadrilla.setId(rs.getInt("id"));
                cuadrilla.setNombre(rs.getString("nombre"));
                cuadrilla.setSupervisor(daoTrabajador.findById(rs.getInt("supervisor_id")));
                cuadrillas.add(cuadrilla);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuadrillas;
    }

    @Override
    public ArrayList<Cuadrilla> findBySupervisor(int id) {
        ArrayList<Cuadrilla>cuadrillas=new ArrayList<Cuadrilla>();
        String sql="SELECT * FROM cuadrilla WHERE supervisor_id = ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOTrabajador daoTrabajador=new DAOTrabajador();
            while (rs.next()){
                Cuadrilla cuadrilla=new Cuadrilla();
                cuadrilla.setId(rs.getInt("id"));
                cuadrilla.setNombre(rs.getString("nombre"));
                cuadrilla.setSupervisor(daoTrabajador.findById(rs.getInt("supervisor_id")));
                cuadrillas.add(cuadrilla);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuadrillas;
    }

    @Override
    public ArrayList<Cuadrilla> findAll() {
        ArrayList<Cuadrilla>cuadrillas=new ArrayList<Cuadrilla>();
        String sql="SELECT * FROM cuadrilla";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            ResultSet rs=stmt.executeQuery();
            DAOTrabajador daoTrabajador=new DAOTrabajador();
            while (rs.next()){
                Cuadrilla cuadrilla=new Cuadrilla();
                cuadrilla.setId(rs.getInt("id"));
                cuadrilla.setNombre(rs.getString("nombre"));
                cuadrilla.setSupervisor(daoTrabajador.findById(rs.getInt("supervisor_id")));
                cuadrillas.add(cuadrilla);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuadrillas;
    }

    @Override
    public void add(Cuadrilla cuadrilla) {

    }

    @Override
    public void update(Cuadrilla cuadrilla) {

    }

    @Override
    public void delete(Cuadrilla cuadrilla) {

    }

    @Override
    public ArrayList<Cuadrilla> cuadrillasbyOlivar(int id) {
        ArrayList<Cuadrilla>cuadrillas=new ArrayList<Cuadrilla>();
        String sql="SELECT c.* from cuadrilla c inner join Cuadrilla_Olivar co on c.id=co.cuadrilla_id where co.olivar_id= ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOTrabajador daoTrabajador=new DAOTrabajador();
            while (rs.next()){
                Cuadrilla cuadrilla=new Cuadrilla();
                cuadrilla.setId(rs.getInt("id"));
                cuadrilla.setNombre(rs.getString("nombre"));
                cuadrilla.setSupervisor(daoTrabajador.findById(rs.getInt("supervisor_id")));
                cuadrillas.add(cuadrilla);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuadrillas;
    }

    @Override
    public ArrayList<Cuadrilla> cuadrillasbyTrabajador(int id) {
        ArrayList<Cuadrilla>cuadrillas=new ArrayList<Cuadrilla>();
        String sql="SELECT c.* from cuadrilla c inner join Cuadrilla_Trabajador ct on c.id=ct.cuadrilla_id where ct.trabajador_id= ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOTrabajador daoTrabajador=new DAOTrabajador();
            while (rs.next()){
                Cuadrilla cuadrilla=new Cuadrilla();
                cuadrilla.setId(rs.getInt("id"));
                cuadrilla.setNombre(rs.getString("nombre"));
                cuadrilla.setSupervisor(daoTrabajador.findById(rs.getInt("supervisor_id")));
                cuadrillas.add(cuadrilla);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cuadrillas;
    }
}
