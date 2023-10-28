/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author AndreaTay
 */
public class PrestamosDTO {

     private Long id;
    private String id_libro;
    private String Usuario;
    private String fecha_pres;
    
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
     * @return the id_libro
     */
    public String getId_libro() {
        return id_libro;
    }

    /**
     * @param id_libro the id_libro to set
     */
    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
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
    
   
}
