package org.example.TEMA2.sql.aceituna.produccion;

import org.example.TEMA2.sql.aceituna.FactoriaConexion;
import org.example.TEMA2.sql.aceituna.almazara.DAOAlmazara;
import org.example.TEMA2.sql.aceituna.cuadrilla.DAOCuadrilla;
import org.example.TEMA2.sql.aceituna.olivar.DAOOlivar;

import java.sql.*;
import java.util.ArrayList;

public class DAOProduccion implements InterfaceProduccion {
    private final Connection con=FactoriaConexion.getConnection();
    @Override
    public ArrayList<Produccion> findAll() {
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while(rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    @Override
    public Produccion findById(int id) {
        Produccion produccion=null;
        String sql="SELECT * FROM PRODUCCION WHERE id=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            if(rs.next()){
                produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return produccion;
    }

    @Override
    public ArrayList<Produccion> findByCuadrilla(int id) {
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where cuadrilla_id=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while(rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    @Override
    public ArrayList<Produccion> findByOlivar(int id) {
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where olivar_id=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while(rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    @Override
    public ArrayList<Produccion> findByAlmazara(int id) {
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where almazara_id=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while(rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    @Override
    public ArrayList<Produccion> findByFecha(Date fecha) {
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where fecha=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setDate(1, fecha);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while(rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    @Override
    public ArrayList<Produccion> findByCantidad(double cantidad) {
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where cantidad=?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setDouble(1, cantidad);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while(rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    @Override
    public void add(Produccion produccion) {

    }

    @Override
    public void remove(Produccion produccion) {

    }

    @Override
    public void update(Produccion produccion) {

    }

    public ArrayList<Produccion>produccionhastaFechayAlmazara(int id_almazara,Date fecha){
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where almazara_id=? and fecha < ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id_almazara);
            stmt.setDate(2, fecha);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while (rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }
    public ArrayList<Produccion>produccionhastaFechayOlivar(int id_olivar,Date fecha){
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where olivar_id=? and fecha < ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id_olivar);
            stmt.setDate(2, fecha);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while (rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }

    public ArrayList<Produccion>produccionhastaFechayCuadrilla(int id_cuadrilla,Date fecha){
        ArrayList<Produccion>producciones=new ArrayList<Produccion>();
        String sql = "SELECT * FROM produccion where cuadrilla_id=? and fecha < ?";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1, id_cuadrilla);
            stmt.setDate(2, fecha);
            ResultSet rs=stmt.executeQuery();
            DAOCuadrilla daoCuadrilla=new DAOCuadrilla();
            DAOOlivar daoOlivar=new DAOOlivar();
            DAOAlmazara daoAlmazara=new DAOAlmazara();
            while (rs.next()){
                Produccion produccion=new Produccion();
                produccion.setIdProduccion(rs.getInt("id"));
                produccion.setCuadrilla(daoCuadrilla.findById(rs.getInt("cuadrilla_id")));
                produccion.setOlivar(daoOlivar.findById(rs.getInt("olivar_id")));
                produccion.setAlmazara(daoAlmazara.findById(rs.getInt("almazara_id")));
                produccion.setFecha(rs.getDate("fecha"));
                produccion.setCantidadRecolectada(rs.getDouble("cantidadRecolectada"));
                producciones.add(produccion);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producciones;
    }
}
