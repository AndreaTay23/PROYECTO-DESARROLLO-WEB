/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.AutoresDTO;
import DTO.DevolucionesDTO;
import DTO.LibrosDTO;
import DTO.PrestamosDTO;
import DTO.UsuariosDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author AndreaTay
 */
public class ConsultasDAO implements Serializable {
    
     ConexionDAO con = new ConexionDAO();

    //metodo para consultar datos de la base de datos
    public List<LibrosDTO> findAllLibro() {
        List<LibrosDTO> Lista = new ArrayList<LibrosDTO>();

        try {
            String query = "SELECT id, titulo, autor, categoria, editorial, aniopub, idioma FROM libros";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                LibrosDTO dato = new LibrosDTO();
                dato.setId(r.getLong("id"));
                dato.setTitulo(r.getString("titulo"));
                dato.setAutor(r.getString("autor"));
                dato.setCategoria(r.getString("categoria"));
                dato.setEditorial(r.getString("editorial"));
                dato.setAniopub(r.getString("aniopub"));
                dato.setIdioma(r.getString("idioma"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista Libro es: " + Lista.size());
        //System.out.println("nombre lista );
        return Lista;

    } 
    
    public List<AutoresDTO> findAllAutor() {
        List<AutoresDTO> Lista = new ArrayList<AutoresDTO>();

        try {
            String query = "SELECT id, nombre, fecha_nac, nacionalidad, categoria FROM autores";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                AutoresDTO dato = new AutoresDTO();
                dato.setId(r.getLong("id"));
                dato.setNombre(r.getString("nombre"));
                dato.setFecha_nac(r.getString("fecha_nac"));
                dato.setNacionalidad(r.getString("nacionalidad"));
                dato.setCategoria(r.getString("categoria"));

                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista Autor es: " + Lista.size());
        //System.out.println("nombre lista );
        return Lista;

    } 
    
    public List<UsuariosDTO> findAllUsuario() {
        List<UsuariosDTO> Lista = new ArrayList<UsuariosDTO>();

        try {
            String query = "SELECT id, nombre, correo, direccion, telefono FROM usuarios";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                UsuariosDTO dato = new UsuariosDTO();
                dato.setId(r.getLong("id"));
                dato.setNombre(r.getString("nombre"));
                dato.setCorreo(r.getString("correo"));
                dato.setDireccion(r.getString("direccion"));
                dato.setTelefono(r.getString("telefono"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista Usuario es: " + Lista.size());
        //System.out.println("nombre lista );
        return Lista;
    }
    
    public List<PrestamosDTO> findAllPrestamos() {
        List<PrestamosDTO> Lista = new ArrayList<PrestamosDTO>();

        try {
            String query = "SELECT id, id_libro, usuario, fecha_pres FROM prestamos";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                PrestamosDTO dato = new PrestamosDTO();
                dato.setId(r.getLong("id"));
                dato.setId_libro(r.getString("id_libro"));
                dato.setUsuario(r.getString("usuario"));
                dato.setFecha_pres(r.getString("fecha_pres"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista Prestamos es: " + Lista.size());
        //System.out.println("nombre lista );
        return Lista;
    }
    
     public List<DevolucionesDTO> findAllDev() {
        List<DevolucionesDTO> Lista = new ArrayList<DevolucionesDTO>();

        try {
            String query = "SELECT id, id_pres, usuario, fecha_dev FROM devoluciones";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                DevolucionesDTO dato = new DevolucionesDTO();
                dato.setId(r.getLong("id"));
                dato.setIdPres(r.getString("id_pres"));
                dato.setUsuario(r.getString("usuario"));
                dato.setFecha_dev(r.getString("fecha_pres"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista Devolucion es: " + Lista.size());
        //System.out.println("nombre lista );
        return Lista;

    }
    
    //Para ingresar datos a BD
   public void insertarLibro(LibrosDTO nuevoLibro) throws Exception   {
    try {
  
        //if (!con.conexionMysql().isClosed()){
        String query ="INSERT INTO libros (titulo, autor, categoria, editorial, aniopub, idioma) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
        
            preparedStatement.setString(1, nuevoLibro.getTitulo());
            preparedStatement.setString(2, nuevoLibro.getAutor ());
            preparedStatement.setString(3, nuevoLibro.getCategoria());
            preparedStatement.setString(4, nuevoLibro.getEditorial());
            preparedStatement.setString(5, nuevoLibro.getAniopub());
            preparedStatement.setString(6, nuevoLibro.getIdioma());

            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("EL LIBRO FUE INGRESDO CORRECTAMENTE EN LA BD.");
            } else {
                System.out.println("EL LIBRO NO SE LOGRÓ INGRESAR.");
            }
   
} catch (Exception ex) {
    System.out.println("ERROR AL INSERTAR EL CLIENTE" + ex.getMessage());
  }
 
}
   
   public void insertarAutor(AutoresDTO nuevoAutor) throws Exception   {
    try {
  
        //if (!con.conexionMysql().isClosed()){
        String query ="INSERT INTO autores (nombre, fecha_nac, nacionalidad, categoria) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
        
            preparedStatement.setString(1, nuevoAutor.getNombre());
            preparedStatement.setString(2, nuevoAutor.getFecha_nac());
            preparedStatement.setString(3, nuevoAutor.getNacionalidad());
            preparedStatement.setString(4, nuevoAutor.getCategoria());

            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("EL AUTOR FUE INGRESDO CORRECTAMENTE EN LA BD.");
            } else {
                System.out.println("EL AUTOR NO SE LOGRÓ INGRESAR.");
            }

} catch (Exception ex) {
    System.out.println("ERROR AL INSERTAR EL AUTOR" + ex.getMessage());
  }
   }
   
    public void insertarUsuario(UsuariosDTO nuevoUsuario) throws Exception   {
    try {
  
        //if (!con.conexionMysql().isClosed()){
        String query ="INSERT INTO usuarios (nombre, correo, direccion, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
        
            preparedStatement.setString(1, nuevoUsuario.getNombre());
            preparedStatement.setString(2, nuevoUsuario.getCorreo());
            preparedStatement.setString(3, nuevoUsuario.getDireccion());
            preparedStatement.setString(4, nuevoUsuario.getTelefono());

            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("EL USUARIO FUE INGRESDO CORRECTAMENTE EN LA BD.");
            } else {
                System.out.println("EL USUARIO NO SE LOGRÓ INGRESAR.");
            }
            
           // }
   
} catch (Exception ex) {
    System.out.println("ERROR AL INSERTAR EL USUARIO" + ex.getMessage());
  }
 
}
    
    public void insertarDev(DevolucionesDTO nuevoDev) throws Exception   {
    try {
  
        //if (!con.conexionMysql().isClosed()){
        String query ="INSERT INTO devoluciones (id_pres, usuario, fecha_dev) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
        
            preparedStatement.setString(1, nuevoDev.getIdPres());
            preparedStatement.setString(2, nuevoDev.getUsuario());
            preparedStatement.setString(3, nuevoDev.getFecha_dev());

            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("EL DEVOLUCION FUE INGRESADO CORRECTAMENTE EN LA BD.");
            } else {
                System.out.println("EL DEVOLUCION NO SE LOGRÓ INGRESAR.");
            }
            
} catch (Exception ex) {
    System.out.println("ERROR AL INSERTAR EL DEVOLUCION" + ex.getMessage());
  }
    }
    
    public void insertarPres(PrestamosDTO nuevoPres) throws Exception   {
    try {
  
        //if (!con.conexionMysql().isClosed()){
        String query ="INSERT INTO prestamos (id_libro, usuario, fecha_pres) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
        
            preparedStatement.setString(1, nuevoPres.getId_libro());
            preparedStatement.setString(2, nuevoPres.getUsuario());
            preparedStatement.setString(3, nuevoPres.getFecha_pres());

            int filasInsertadas = preparedStatement.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("EL PRESTAMO FUE INGRESADO CORRECTAMENTE EN LA BD.");
            } else {
                System.out.println("EL PRESTAMO NO SE LOGRÓ INGRESAR.");
            }
               
} catch (Exception ex) {
    System.out.println("ERROR AL INSERTAR EL PRESTAMO" + ex.getMessage());
  }
    
     
    }
    
     //para actualizar en BD
    public void actualizarLibro(LibrosDTO libro) throws Exception {
    try {
        String query = "UPDATE libros SET titulo = ?, autor = ?, categoria = ?, editorial = ? , aniopub = ?, idioma = ? WHERE id = ?";
        PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
       
        preparedStatement.setString(1, libro.getTitulo());
        preparedStatement.setString(2, libro.getAutor());
        preparedStatement.setString(3, libro.getCategoria());
        preparedStatement.setString(4, libro.getEditorial());
        preparedStatement.setString(5, libro.getAniopub());
        preparedStatement.setString(6, libro.getIdioma());
        
        // Establecemos el valor del ID en la cláusula WHERE de la consulta
        preparedStatement.setLong(7, libro.getId());

        int filasActualizadas = preparedStatement.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Libro actualizado correctamente en la base de datos.");
        } else {
            System.out.println("No se pudo actualizar el libro.");
        }
    } catch (Exception ex) {
        System.out.println("Error al actualizar el libro: " + ex.getMessage());
    }
}
    
     public void actualizarAutor(AutoresDTO Autor) throws Exception {
    try {
        String query = "UPDATE autores SET nombre = ?,  fecha_nac= ?, nacionalidad = ?, categoria = ?  WHERE id = ?";
        PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
       
            preparedStatement.setString(1, Autor.getNombre());
            preparedStatement.setString(2, Autor.getFecha_nac());
            preparedStatement.setString(3, Autor.getNacionalidad());
            preparedStatement.setString(4, Autor.getCategoria());

        
        // Establecemos el valor del ID en la cláusula WHERE de la consulta
        preparedStatement.setLong(5, Autor.getId());

        int filasActualizadas = preparedStatement.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Autor actualizado correctamente en la base de datos.");
        } else {
            System.out.println("No se pudo actualizar el Autor.");
        }
    } catch (Exception ex) {
        System.out.println("Error al actualizar el autor: " + ex.getMessage());
    }
}
    
     public void actualizarUsuario(UsuariosDTO Usuario) throws Exception {
    try {
        String query = "UPDATE usuarios SET nombre = ?,  correo= ?, direccion = ?, telefono = ?  WHERE id = ?";
        PreparedStatement preparedStatement = con.conexionMysql().prepareStatement(query);
       
            preparedStatement.setString(1, Usuario.getNombre());
            preparedStatement.setString(2, Usuario.getCorreo());
            preparedStatement.setString(3, Usuario.getDireccion());
            preparedStatement.setString(4, Usuario.getTelefono());

        
        // Establecemos el valor del ID en la cláusula WHERE de la consulta
        preparedStatement.setLong(5, Usuario.getId());

        int filasActualizadas = preparedStatement.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Usuario actualizado correctamente en la base de datos.");
        } else {
            System.out.println("No se pudo actualizar el Usuario.");
        }
    } catch (Exception ex) {
        System.out.println("Error al actualizar el Usuario: " + ex.getMessage());
    }
}
   
}
