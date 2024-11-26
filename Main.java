package org.example.TEMA2.sql.aceituna;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.TEMA2.sql.aceituna.almazara.Almazara;
import org.example.TEMA2.sql.aceituna.almazara.Almazaras;
import org.example.TEMA2.sql.aceituna.almazara.DAOAlmazara;
import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrilla;
import org.example.TEMA2.sql.aceituna.cuadrilla.Cuadrillas;
import org.example.TEMA2.sql.aceituna.cuadrilla.DAOCuadrilla;
import org.example.TEMA2.sql.aceituna.olivar.DAOOlivar;
import org.example.TEMA2.sql.aceituna.olivar.Olivar;
import org.example.TEMA2.sql.aceituna.olivar.Olivares;
import org.example.TEMA2.sql.aceituna.produccion.DAOProduccion;
import org.example.TEMA2.sql.aceituna.produccion.Produccion;
import org.example.TEMA2.sql.aceituna.produccion.Producciones;
import org.example.TEMA2.sql.aceituna.trabajador.DAOTrabajador;
import org.example.TEMA2.sql.aceituna.trabajador.Trabajador;
import org.example.TEMA2.sql.aceituna.trabajador.Trabajadores;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FactoriaConexion.createTrigger();
        Scanner sc = new Scanner(System.in);
        DAOAlmazara daoAlmazara = new DAOAlmazara();
        DAOCuadrilla daoCuadrilla = new DAOCuadrilla();
        DAOOlivar daoOlivar = new DAOOlivar();
        DAOProduccion daoProduccion = new DAOProduccion();
        DAOTrabajador daoTrabajador = new DAOTrabajador();
        Menu(sc,daoAlmazara,daoCuadrilla,daoOlivar,daoProduccion,daoTrabajador);
    }



    public static void Menu(Scanner scanner,DAOAlmazara daoAlmazara,DAOCuadrilla daoCuadrilla,DAOOlivar daoOlivar,DAOProduccion daoProduccion,DAOTrabajador daoTrabajador) throws IOException {
        int opc=0;
        do{
            System.out.println("**** Menu ***\n");
            System.out.println("1. Mostrar trabajadores de una determinada cuadrilla");
            System.out.println("2. Mostrar las cuadrillas que supervisa un determinado trabajador");
            System.out.println("3. Mostrar los olivares donde trabaja una determinada cuadrilla.");
            System.out.println("4. Mostrar las cuadrillas que trabajan en un determinado olivar.");
            System.out.println("5. Mostrar las almazaras donde lleva aceituna una determinada cuadrilla");
            System.out.println("6. Mostrar la producción en una fecha concreta, de una cuadrilla concreta en una almazara concreta.");
            System.out.println("7. Mostrar la producción hasta una determinada fecha, de una determinada almazara.");
            System.out.println("8. Mostrar la producción hasta una determinada fecha, de un determinado olivar");
            System.out.println("9. Mostrar la producción hasta una determinada fecha, de una cuadrilla determinada");
            System.out.println("10. Guardar datos en XML");
            System.out.println("11. Sacar datos XML");
            System.out.println("12. Guardar datos JSON");
            System.out.println("13. Sacar datos JSON");
            System.out.println("14. Salir");
            opc=scanner.nextInt();
            if (opc<1||opc>14){
                System.out.println("Opción no valida");
            }else{
                switch (opc){
                    case 1:
                        System.out.println("Introduzca el id de la cuadrilla");
                        int id=scanner.nextInt();
                        ArrayList<Trabajador>trabajadores=daoTrabajador.trabajadoresByCuadrilla(id);
                        for (Trabajador t: trabajadores){
                            ArrayList<Cuadrilla> cuadrillasTrabajador=daoCuadrilla.cuadrillasbyTrabajador(t.getId());
                            for (Cuadrilla c:cuadrillasTrabajador){
                                c.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(c.getId()));
                                c.setOlivares(daoOlivar.olivaresbyCuadrilla(c.getId()));
                            }
                            t.setCuadrillas(cuadrillasTrabajador);
                            System.out.println(t);
                        }
                        break;
                    case 2:
                        System.out.println("Introduce el id del trabajador");
                        int idtrab=scanner.nextInt();
                        ArrayList<Cuadrilla>cuadrillas=daoCuadrilla.cuadrillasbyTrabajador(idtrab);
                        for (Cuadrilla c:cuadrillas){
                            c.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(c.getId()));
                            c.setOlivares(daoOlivar.olivaresbyCuadrilla(c.getId()));
                            System.out.println(c);
                        }
                        break;
                    case 3:
                        System.out.println("Introduce el id de la cuadrilla");
                        int idcuadrilla=scanner.nextInt();
                        ArrayList<Olivar>olivares=daoOlivar.olivaresbyCuadrilla(idcuadrilla);
                        for (Olivar o:olivares){
                            o.setCuadrillas(daoCuadrilla.cuadrillasbyOlivar(o.getId()));
                            System.out.println(o);
                        }
                        break;
                    case 4:
                        System.out.println("Introduce el id del olivar");
                        int idolivar=scanner.nextInt();
                        ArrayList<Cuadrilla>cuadrillas1=daoCuadrilla.cuadrillasbyOlivar(idolivar);
                        for (Cuadrilla c:cuadrillas1){
                            c.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(c.getId()));
                            c.setOlivares(daoOlivar.olivaresbyCuadrilla(c.getId()));
                            System.out.println(c);
                        }
                        break;
                    case 5:
                        System.out.println("Introduce el id de la cuadrilla");
                        int idcuadrila=scanner.nextInt();
                        ArrayList<Produccion>producciones=daoProduccion.findByCuadrilla(idcuadrila);
                        for (Produccion p:producciones){
                            Cuadrilla cuadrilla=p.getCuadrilla();
                            cuadrilla.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(cuadrilla.getId()));
                            cuadrilla.setOlivares(daoOlivar.olivaresbyCuadrilla(cuadrilla.getId()));
                            System.out.println(p);
                        }
                        break;
                    case 6:
                        System.out.println("Introduce la fecha");
                        String fecha=scanner.next();
                        Date fechaConsulta = Date.valueOf(fecha);
                        ArrayList<Produccion>producciones2=daoProduccion.findByFecha(fechaConsulta);
                        for (Produccion p:producciones2){
                            Cuadrilla cuadrilla=p.getCuadrilla();
                            cuadrilla.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(cuadrilla.getId()));
                            cuadrilla.setOlivares(daoOlivar.olivaresbyCuadrilla(cuadrilla.getId()));
                            System.out.println(p);
                        }
                        break;
                    case 7:
                        System.out.println("Introduce la fecha");
                        String fecha2=scanner.next();
                        Date fechaConsulta2 = Date.valueOf(fecha2);
                        System.out.println("Introduce el id de la almazara");
                        int id_almazara=scanner.nextInt();
                        ArrayList<Produccion>producciones3=daoProduccion.produccionhastaFechayAlmazara(id_almazara,fechaConsulta2);
                        for (Produccion p:producciones3){
                            Cuadrilla cuadrilla=p.getCuadrilla();
                            cuadrilla.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(cuadrilla.getId()));
                            cuadrilla.setOlivares(daoOlivar.olivaresbyCuadrilla(cuadrilla.getId()));
                            System.out.println(p);
                        }
                        break;
                    case 8:
                        System.out.println("Introduce la fecha");
                        String fecha3=scanner.next();
                        Date fechaConsulta3 = Date.valueOf(fecha3);
                        System.out.println("Introduce el id del olivar");
                        int id_olivar=scanner.nextInt();
                        ArrayList<Produccion>producciones4=daoProduccion.produccionhastaFechayOlivar(id_olivar,fechaConsulta3);
                        for (Produccion p:producciones4){
                            Cuadrilla cuadrilla=p.getCuadrilla();
                            cuadrilla.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(cuadrilla.getId()));
                            cuadrilla.setOlivares(daoOlivar.olivaresbyCuadrilla(cuadrilla.getId()));
                            System.out.println(p);
                        }
                        break;
                    case 9:
                        System.out.println("Introduce la fecha");
                        String fecha4=scanner.next();
                        Date fechaConsulta4 = Date.valueOf(fecha4);
                        System.out.println("Introduce el id de la cuadrilla");
                        int id_cuadrilla=scanner.nextInt();
                        ArrayList<Produccion>producciones5=daoProduccion.produccionhastaFechayCuadrilla(id_cuadrilla,fechaConsulta4);
                        for (Produccion p:producciones5){
                            Cuadrilla cuadrilla=p.getCuadrilla();
                            cuadrilla.setTrabajadores(daoTrabajador.trabajadoresByCuadrilla(cuadrilla.getId()));
                            cuadrilla.setOlivares(daoOlivar.olivaresbyCuadrilla(cuadrilla.getId()));
                            System.out.println(p);
                        }
                        break;
                    case 10:
                        try{
                            ArrayList<Almazaras>almazaras1=new ArrayList<Almazaras>();
                            ArrayList<Olivares>olivares2=new ArrayList<Olivares>();
                            ArrayList<Cuadrillas>cuadrillas2=new ArrayList<Cuadrillas>();
                            ArrayList<Producciones>produccione=new ArrayList<Producciones>();
                            ArrayList<Trabajadores>trabajadores2=new ArrayList<Trabajadores>();

                            Almazaras almazaras=new Almazaras();
                            almazaras.setAlmazaras(daoAlmazara.findAll());
                            almazaras1.add(almazaras);
                            Olivares olivares1=new Olivares();
                            olivares1.setOlivares(daoOlivar.findAll());
                            olivares2.add(olivares1);
                            Cuadrillas cuadrilla1=new Cuadrillas();
                            cuadrilla1.setCuadrillas(daoCuadrilla.findAll());
                            cuadrillas2.add(cuadrilla1);
                            Producciones producciones1=new Producciones();
                            producciones1.setProducciones(daoProduccion.findAll());
                            produccione.add(producciones1);
                            Trabajadores trabajador1=new Trabajadores();
                            trabajador1.setTrabajadores(daoTrabajador.findAll());
                            trabajadores2.add(trabajador1);
                            Datos datos1=new Datos();
                            datos1.settrabajadores(trabajadores2);
                            datos1.setalmazaras(almazaras1);
                            datos1.setolivares(olivares2);
                            datos1.setcuadrillas(cuadrillas2);
                            datos1.setproducciones(produccione);
                            JAXBContext context = JAXBContext.newInstance(Datos.class);

                            // Crear un Marshaller para convertir el objeto a XML
                            Marshaller marshaller = context.createMarshaller();

                            // Hacer que el XML sea legible (con saltos de línea y tabulaciones)
                            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                            marshaller.marshal(datos1, new File("datosaceituna.xml"));
                        }catch (JAXBException e){
                            e.printStackTrace();
                        }

                        break;
                    case 11:
                        try {
                            // Crear un contexto JAXB para la clase Datos
                            JAXBContext context = JAXBContext.newInstance(Datos.class);

                            // Crear el Unmarshaller
                            Unmarshaller unmarshaller = context.createUnmarshaller();

                            // Deserializar el archivo XML en un objeto Datos
                            File xmlFile = new File("datosaceituna.xml");
                            Datos datos1 = (Datos) unmarshaller.unmarshal(xmlFile);

                            // Ahora puedes trabajar con el objeto "datos1" que contiene los datos deserializados
                            System.out.println("Datos deserializados correctamente:");
                            System.out.println("Almazaras: " + datos1.getAlmazaras());
                            System.out.println("Olivares: " + datos1.getOlivares());
                            System.out.println("Cuadrillas: " + datos1.getCuadrillas());
                            System.out.println("Producciones: " + datos1.getProducciones());
                            System.out.println("Trabajadores: " + datos1.getTrabajadores());
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 12:
                        ObjectMapper mapper = new ObjectMapper();
                        ArrayList<Almazaras>almazaras1=new ArrayList<Almazaras>();
                        ArrayList<Olivares>olivares2=new ArrayList<Olivares>();
                        ArrayList<Cuadrillas>cuadrillas2=new ArrayList<Cuadrillas>();
                        ArrayList<Producciones>produccione=new ArrayList<Producciones>();
                        ArrayList<Trabajadores>trabajadores2=new ArrayList<Trabajadores>();

                        Almazaras almazaras=new Almazaras();
                        almazaras.setAlmazaras(daoAlmazara.findAll());
                        almazaras1.add(almazaras);
                        Olivares olivares1=new Olivares();
                        olivares1.setOlivares(daoOlivar.findAll());
                        olivares2.add(olivares1);
                        Cuadrillas cuadrilla1=new Cuadrillas();
                        cuadrilla1.setCuadrillas(daoCuadrilla.findAll());
                        cuadrillas2.add(cuadrilla1);
                        Producciones producciones1=new Producciones();
                        producciones1.setProducciones(daoProduccion.findAll());
                        produccione.add(producciones1);
                        Trabajadores trabajador1=new Trabajadores();
                        trabajador1.setTrabajadores(daoTrabajador.findAll());
                        trabajadores2.add(trabajador1);
                        Datos datos1=new Datos();
                        datos1.settrabajadores(trabajadores2);
                        datos1.setalmazaras(almazaras1);
                        datos1.setolivares(olivares2);
                        datos1.setcuadrillas(cuadrillas2);
                        datos1.setproducciones(produccione);
                        mapper.writeValue(new File("aceituna.json"),datos1);
                        break;
                    case 13:
                        ObjectMapper mapper2 = new ObjectMapper();
                        Datos datos=mapper2.readValue(new File("aceituna.json"), Datos.class);
                        System.out.println(datos);
                        break;
                }
            }
        }while (opc!=14);

    }
}
