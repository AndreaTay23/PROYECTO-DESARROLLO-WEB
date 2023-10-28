/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author AndreaTay
 */

    @ManagedBean(name = "bkn_Inicio")
@RequestScoped
public class InicioUI implements Serializable {

    //nos permite ir a la ventana de clientes
    

    //ventana de producto
    public void VentanaLibro() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/LibroNuevo.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana de ordenes
    public void VentanaActLibro() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/ActualizarLibro.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana de detalle de Ordenes
    public void VentanaCatLibro() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/CatalogoLibro.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ventana de detalle de Ordenes
    public void VentanaAutor() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/Autores.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ventana de detalle de Ordenes
    public void VentanaActAutor() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/ActualizarAutor.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ventana de detalle de Ordenes
    public void VentanaCatAutor() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/Listado.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ventana de detalle de Ordenes
    public void VentanaUsuarios() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/Usuarios.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VentanaActUsuarios() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/ActualizarUsuarios.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VentanaCatUsuarios() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/ListarUsuarios.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VentanaPrestamos() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/Prestamos.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void VentanaDevoluciones() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/Devoluciones.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //ventana principal
    public void VentanaPrincipal() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/InicioUI.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(InicioUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
