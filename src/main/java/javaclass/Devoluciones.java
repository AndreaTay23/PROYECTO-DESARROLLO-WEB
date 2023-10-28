/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass;

import DAO.ConexionDAO;
import DAO.ConsultasDAO;
import DTO.DevolucionesDTO;
import DTO.LibrosDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author AndreaTay
 */

@ManagedBean (name="bkn_Dev") //"bean administrado" 
public class Devoluciones {
    
    private Long id;
    private String idPres;
    private String usuario;
    private String fecha_dev;
    private DevolucionesDTO DevSeleccion;
  private List<DevolucionesDTO> listaDev;
  private ConsultasDAO consulta = new ConsultasDAO();
    
  @PostConstruct
    public void init() {
        setListaDev(consulta.findAllDev());
     
    }
    
    public void listaDev() {
        ConexionDAO con = new ConexionDAO();
        ConsultasDAO consulta = new ConsultasDAO();

        try {
            setListaDev(consulta.findAllDev());
            System.out.println("La conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + getListaDev().size());
            System.out.println("El id es: " + getListaDev().get(0).getId());
        } catch (Exception ex) {
            System.out.println("Error al consumir el ws: " + ex);
        }
    }
    
    public void insertarDev() {
        try {
            
            if (getIdPres() == null || getIdPres().isEmpty() || getUsuario() == null || getUsuario().isEmpty() 
                    || getFecha_dev() == null || getFecha_dev().isEmpty() ) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "TODOS los  campos son obligatorios..");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }

            // Aquí debes insertar datos en la base de datos
            DevolucionesDTO nuevoDev = new DevolucionesDTO();
            
            nuevoDev.setIdPres(getIdPres());
            nuevoDev.setUsuario(getUsuario());
            nuevoDev.setFecha_dev(getFecha_dev());
           
            
            ConsultasDAO consultas = new ConsultasDAO();
            consultas.insertarDev(nuevoDev);
            listaDev();

            // Puedes agregar un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Devolucion insertado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Limpia los campos del formulario después de insertarlos
            

            idPres= "";
            usuario = "";
            fecha_dev= "";
           
            
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la inserción en la base de datos
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar la devolucion: " + e.getMessage());
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
     * @return the idPres
     */
    public String getIdPres() {
        return idPres;
    }

    /**
     * @param idPres the idPres to set
     */
    public void setIdPres(String idPres) {
        this.idPres = idPres;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the fecha_dev
     */
    public String getFecha_dev() {
        return fecha_dev;
    }

    /**
     * @param fecha_dev the fecha_dev to set
     */
    public void setFecha_dev(String fecha_dev) {
        this.fecha_dev = fecha_dev;
    }

    /**
     * @return the DevSeleccion
     */
    public DevolucionesDTO getDevSeleccion() {
        return DevSeleccion;
    }

    /**
     * @param DevSeleccion the DevSeleccion to set
     */
    public void setDevSeleccion(DevolucionesDTO DevSeleccion) {
        this.DevSeleccion = DevSeleccion;
    }

    /**
     * @return the listaDev
     */
    public List<DevolucionesDTO> getListaDev() {
        return listaDev;
    }

    /**
     * @param listaDev the listaDev to set
     */
    public void setListaDev(List<DevolucionesDTO> listaDev) {
        this.listaDev = listaDev;
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
    
    
}
