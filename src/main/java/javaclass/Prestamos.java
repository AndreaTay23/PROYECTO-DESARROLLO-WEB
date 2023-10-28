/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass;

import DAO.ConsultasDAO;
import DAO.ConexionDAO;
import DTO.DevolucionesDTO;
import DTO.PrestamosDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author AndreaTay
 */

@ManagedBean (name="bkn_prestamo") //"bean administrado" 

public class Prestamos {
    
    private String idLibro;
    private String Usuario;
    private String fecha_pres;
    private List<PrestamosDTO> listaPres;
  private ConsultasDAO consulta = new ConsultasDAO();
  
  
  
     @PostConstruct
    public void init() {
        setListaPres(consulta.findAllPrestamos());
     
    }
    
public void listaPres() {
        ConexionDAO con = new ConexionDAO();
        ConsultasDAO consulta = new ConsultasDAO();

        try {
            setListaPres(consulta.findAllPrestamos());
            System.out.println("La conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + getListaPres().size());
            System.out.println("El id Prestamo es: " + getListaPres().get(0).getId());
        } catch (Exception ex) {
            System.out.println("Error al consumir el ws: " + ex);
        }
    }

public void insertarPrestamo() {
        try {
            
            if (getIdLibro() == null || getIdLibro().isEmpty() || getUsuario() == null || getUsuario().isEmpty() || getFecha_pres() == null || getFecha_pres().isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "TODOS los  campos son obligatorios.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }

            // Aquí debes insertar datos en la base de datos
            PrestamosDTO nuevoPres = new PrestamosDTO();
            
            nuevoPres.setId_libro(getIdLibro());
            nuevoPres.setUsuario(getUsuario());
            nuevoPres.setFecha_pres(getFecha_pres());
           
            
            ConsultasDAO consultas = new ConsultasDAO();
            consultas.insertarPres(nuevoPres);
            listaPres();

            // Puedes agregar un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Prestamo insertado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Limpia los campos del formulario después de insertarlos
            

            idLibro= "";
            Usuario = "";
            fecha_pres= "";
           
            
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la inserción en la base de datos
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar el prestamo: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(int idLibro) {
        this.setIdLibro(idLibro);
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the fecha_pres
     */
    public String getFecha_pres() {
        return fecha_pres;
    }

    /**
     * @param fecha_pres the fecha_pres to set
     */
    public void setFecha_pres(String fecha_pres) {
        this.fecha_pres = fecha_pres;
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
     * @return the idLibro
     */
    public String getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the listaPres
     */
    public List<PrestamosDTO> getListaPres() {
        return listaPres;
    }

    /**
     * @param listaPres the listaPres to set
     */
    public void setListaPres(List<PrestamosDTO> listaPres) {
        this.listaPres = listaPres;
    }

   
    
}
