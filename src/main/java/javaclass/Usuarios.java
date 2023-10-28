/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass;


import DAO.ConsultasDAO;
import DAO.ConexionDAO;
import DTO.UsuariosDTO;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;


/**
 *
 * @author yordi
 */
//esto es una notacion, para llamarlo dedede el xhtml
@ManagedBean(name="bkn_usuarios")
public class Usuarios implements Serializable{

    
    private Long id;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String mensaje;
    private UsuariosDTO UsuarioSeleccion;
    private List<UsuariosDTO> listaUsuarios;
    private ConsultasDAO consulta = new ConsultasDAO();

    @PostConstruct
    public void init() {
        setListaUsuarios(consulta.findAllUsuario());
    }
    
     public void listarUsuarios() {
        ConexionDAO con = new ConexionDAO();
        ConsultasDAO consulta = new ConsultasDAO();

        setMensaje("INGRESAR USUARIO: ");

        try {
            setListaUsuarios(consulta.findAllUsuario());
            System.out.println("La conexion es: " + con.conexionMysql());
            System.out.println("La lista Usuario es: " + getListaUsuarios().size());
            System.out.println("El nombre es: " + getListaUsuarios().get(0).getNombre());
        } catch (Exception ex) {
            System.out.println("Error al consumir el ws: " + ex);
        }
    }
   
   public Usuarios() {
   UsuarioSeleccion = new UsuariosDTO(); // Inicializa clienteSeleccion con un objeto ClienteDTO vacío
}
    
   public void insertarUsuario() {
        try {
            
            if (getNombre() == null || getNombre().isEmpty() || getTelefono() == null || getTelefono().isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre y Telefono son campos obligatorios.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }

            // Aquí debes insertar datos en la base de datos
           UsuariosDTO nuevoUsuario = new UsuariosDTO();
            
            nuevoUsuario.setNombre(getNombre());
            nuevoUsuario.setCorreo(getCorreo());
            nuevoUsuario.setDireccion(getDireccion());
            nuevoUsuario.setTelefono(getTelefono());
          
            
            ConsultasDAO consultas = new ConsultasDAO();
            consultas.insertarUsuario(nuevoUsuario);
            listarUsuarios ();

            // Puedes agregar un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Usuario insertado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Limpia los campos del formulario después de insertarlos
            

           nombre= "";
           correo = "";
           telefono = "";
           direccion = "";
            
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la inserción en la base de datos
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar el Usuario: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
   public void actualizarUsuario() {
    try {
        // Actualiza los datos del cliente seleccionado
            getUsuarioSeleccion().setId(getId());
            getUsuarioSeleccion().setNombre(getNombre());
            getUsuarioSeleccion().setCorreo(getCorreo());
            getUsuarioSeleccion().setDireccion(getDireccion());
            getUsuarioSeleccion().setTelefono(getTelefono());
            

        // Llama al método para actualizar en la base de datos
        ConsultasDAO consultas = new ConsultasDAO();
        consultas.actualizarUsuario(getUsuarioSeleccion());
         listarUsuarios();


        // Muestra un mensaje de éxito
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "El Usuario fue actualizado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        // Limpia los campos del formulario después de insertarlos
           nombre= "";
           correo = "";
           telefono = "";
            direccion = "";
    } catch (Exception e) {
        // Maneja cualquier excepción que pueda ocurrir durante la actualización
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Error al actualizar el Usuario: " + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
      

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
      
  

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    /**
     * @return the consulta
     */
    public ConsultasDAO getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(ConsultasDAO consulta) {
        this.consulta = consulta;
    }

    /**
     * @return the listaUsuarios
     */
    public List<UsuariosDTO> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(List<UsuariosDTO> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
     * @return the UsuarioSeleccion
     */
    public UsuariosDTO getUsuarioSeleccion() {
        return UsuarioSeleccion;
    }

    /**
     * @param UsuarioSeleccion the UsuarioSeleccion to set
     */
    public void setUsuarioSeleccion(UsuariosDTO UsuarioSeleccion) {
        this.UsuarioSeleccion = UsuarioSeleccion;
    }
  
}