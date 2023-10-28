/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass;

import DAO.ConsultasDAO;
import DAO.ConexionDAO;
import DTO.AutoresDTO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaclass.InicioUI;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author rgonz
 */

@ManagedBean(name="bkn_Autor")
public class Autores implements Serializable {

    
    private Long Id;
    private String nombre;
    private String fecha_nac;
    private String nacionalidad;
    private String categoria;
    private String mensaje;
    private AutoresDTO AutorSeleccion;
    private List<AutoresDTO> listaAutores;
    ConsultasDAO consulta = new ConsultasDAO();
    
    
    
    public void listarAutores() {
        ConexionDAO con = new ConexionDAO();
        ConsultasDAO consulta = new ConsultasDAO();

        try {
            setListaAutores(consulta.findAllAutor());
            System.out.println("La conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + getListaAutores().size());
            System.out.println("El nombre es: " + getListaAutores().get(0).getNombre());
        } catch (Exception ex) {
            System.out.println("Error al consumir el ws: " + ex);
        }
    }
    
    public Autores() {
    AutorSeleccion = new AutoresDTO(); // Inicializa autorSeleccion con un objeto AutoresDTO vacío
}
    @PostConstruct
    public void init() {
        setListaAutores(consulta.findAllAutor());
     
    }
    
     public void insertarAutor() {
        try {
            
            if (getNombre() == null || getNombre().isEmpty() || getCategoria() == null || getCategoria().isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre y Categoria son campos obligatorios.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }
            // Aquí debes insertar datos en la base de datos
            AutoresDTO nuevoAutor = new AutoresDTO();
            
            nuevoAutor.setNombre(getNombre());
            nuevoAutor.setFecha_nac(getFecha_nac());
            nuevoAutor.setNacionalidad(getNacionalidad());
            nuevoAutor.setCategoria(getCategoria());
            
            ConsultasDAO consultas = new ConsultasDAO();
            consultas.insertarAutor(nuevoAutor);
            listarAutores ();

            // Puedes agregar un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Autor insertado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Limpia los campos del formulario después de insertarlos
            
            nombre= "";
            fecha_nac= "";
            categoria = "";
            nacionalidad = "";
            nacionalidad = "";
            
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la inserción en la base de datos
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar el autor: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
  public void actualizarAutor() {
    try {
        
        // Actualiza los datos del cliente seleccionado
            getAutorSeleccion().setId(getId());
            getAutorSeleccion().setNombre(getNombre());
            getAutorSeleccion().setFecha_nac(getFecha_nac());
            getAutorSeleccion().setNacionalidad(getCategoria());
            getAutorSeleccion().setCategoria(getCategoria());
    
        // Llama al método para actualizar en la base de datos
        ConsultasDAO consultas = new ConsultasDAO();
        consultas.actualizarAutor(getAutorSeleccion());
         listarAutores ();


        // Muestra un mensaje de éxito
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "El autor fue actualizado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        // Limpia los campos del formulario después de insertarlos
            nombre= "";
            fecha_nac= "";
            categoria = "";
            nacionalidad = "";
            
    } catch (Exception e) {
        // Maneja cualquier excepción que pueda ocurrir durante la actualización
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Error al actualizar el autor: " + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the Nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the FechaNacimiento
     */
    public String getFecha_nac() {
        return fecha_nac;
    }

    /**
     * @param fecha_nac the FechaNacimiento to set
     */
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    /**
     * @return the Nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param Nacionalidad the Nacionalidad to set
     */
    public void setNacionalidad(String Nacionalidad) {
        this.nacionalidad = Nacionalidad;
    }

    /**
     * @return the Categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the Categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the AutorSeleccion
     */
    public AutoresDTO getAutorSeleccion() {
        return AutorSeleccion;
    }

    /**
     * @param AutorSeleccion the AutorSeleccion to set
     */
    public void setAutorSeleccion(AutoresDTO AutorSeleccion) {
        this.AutorSeleccion = AutorSeleccion;
    }
    
    
    /**
     * @return the listaAutores
     */
    public List<AutoresDTO> getListaAutores() {
        return listaAutores;
    }

    /**
     * @param listaAutores the lista to set
     */
    public void setListaAutores(List<AutoresDTO> listaAutores) {
        this.listaAutores = listaAutores;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }
}
