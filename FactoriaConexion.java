package org.example.TEMA2.sql.aceituna;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class FactoriaConexion {
    private static Connection conn=null;

    private FactoriaConexion() {

    }

    public static Connection getConnection() {
        if (conn == null) {
            try (FileInputStream fis = new FileInputStream("db.properties")) {
                Properties prop = new Properties();
                prop.load(fis);
                if (prop.getProperty("driver").equals("MySQL")) {
                    conn = DriverManager.getConnection(
                            "jdbc:mysql://" + prop.getProperty("host") + ":" +
                                    prop.getProperty("port") +
                                    "/" + prop.getProperty("database"),
                            prop);
                } else {
                    System.out.println("Driver no soportado");
                }
            } catch (SQLException e) {
                //System.out.println("FactoriaConexion::Error de sintaxis en el código SQL");
                e.printStackTrace();
            } catch (ClassCastException e) {
                System.out.println("FactoriaConexion::Driver no encontrado");
            } catch (IOException e) {
                System.out.println("FactoriaConexion::Archivo de configuración no encontrado");
            }
        }
        return conn;
    }

    public static void createTrigger() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Código SQL para crear el trigger
            String sql = "DROP TRIGGER IF EXISTS `trigger_produccion`";
            statement.execute(sql);

            sql = "CREATE TRIGGER trigger_produccion\n" +
                    "BEFORE INSERT ON produccion\n" +
                    "FOR EACH ROW\n" +
                    "BEGIN\n" +
                    "    IF NEW.cantidadRecolectada < 0 THEN\n" +
                    "        SET NEW.cantidadRecolectada = 0;\n" +
                    "    END IF;\n" +
                    "END";
            statement.execute(sql);

            System.out.println("Disparadores creados correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al crear los disparadores. "+ e.getMessage());
        }
    }

}
