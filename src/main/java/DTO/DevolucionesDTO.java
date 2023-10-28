/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.ConsultasDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author AndreaTay
 */

public class DevolucionesDTO {
    
     private Long id;
    private String idPres;
    private String usuario;
    private String fecha_dev;
    
    

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

    
    
   
}
