/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaclass;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import DAO.ConsultasDAO;
import DAO.ConexionDAO;
import DTO.LibrosDTO;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import org.primefaces.event.SelectEvent;
import javax.faces.context.FacesContext;

/**
 *
 * @author AndreaTay
 */
@ManagedBean (name="bkn_Libros") //"bean administrado" 
@ViewScoped
public class Libros implements Serializable{

   
  private Long Id;
  private String titulo;
  private String autor;
  private String categoria;
  private String editorial;
  private String aniopub;
  private String idioma;
  private String mensaje;
  private LibrosDTO LibroSeleccion;
  private List<LibrosDTO> listaLibros;
  ConsultasDAO consulta = new ConsultasDAO();

@PostConstruct
    public void init() {
        setListaLibros(consulta.findAllLibro());
     
    }

  
   public void listarLibros() {
        ConexionDAO con = new ConexionDAO();
        ConsultasDAO consulta = new ConsultasDAO();

        setMensaje("INGRESAR LIBRO: ");

        try {
            setListaLibros(consulta.findAllLibro());
            System.out.println("La conexion es: " + con.conexionMysql());
            System.out.println("La lista es: " + getListaLibros().size());
            System.out.println("El nombre es: " + getListaLibros().get(0).getTitulo());
        } catch (Exception ex) {
            System.out.println("Error al consumir el ws: " + ex);
        }
    }
   
   public Libros() {
    LibroSeleccion = new LibrosDTO(); // Inicializa clienteSeleccion con un objeto ClienteDTO vacío
}
    
   public void insertarLibro() {
        try {
            
            if (getTitulo() == null || getTitulo().isEmpty() || getAutor() == null || getAutor().isEmpty()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Titulo y Autor son campos obligatorios.");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }

            // Aquí debes insertar datos en la base de datos
            LibrosDTO nuevoLibro = new LibrosDTO();
            
            nuevoLibro.setTitulo(getTitulo());
            nuevoLibro.setAutor(getAutor());
            nuevoLibro.setCategoria(getCategoria());
            nuevoLibro.setEditorial(getEditorial());
            nuevoLibro.setAniopub(getAniopub());           
            nuevoLibro.setIdioma(getIdioma());
            
            ConsultasDAO consultas = new ConsultasDAO();
            consultas.insertarLibro(nuevoLibro);
            listarLibros ();

            // Puedes agregar un mensaje de éxito
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Libro insertado correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            // Limpia los campos del formulario después de insertarlos
            
           
            titulo= "";
            autor = "";
            categoria = "";
            editorial = "";
            aniopub="";
            idioma="";
            
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante la inserción en la base de datos
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al insertar el libro: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
       
    }
   public void actualizarLibro() {
    try {
        // Actualiza los datos del cliente seleccionado
            getLibroSeleccion().setId(getId());
            getLibroSeleccion().setTitulo(getTitulo());
            getLibroSeleccion().setAutor(getAutor());
            getLibroSeleccion().setCategoria(getCategoria());
            getLibroSeleccion().setEditorial(getEditorial());
            getLibroSeleccion().setAniopub(getAniopub());
            getLibroSeleccion().setIdioma(getIdioma());

        // Llama al método para actualizar en la base de datos
        ConsultasDAO consultas = new ConsultasDAO();
        consultas.actualizarLibro(getLibroSeleccion());
         listarLibros ();


        // Muestra un mensaje de éxito
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "CORRECTO", "El Libro fue actualizado correctamente.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        // Limpia los campos del formulario después de insertarlos
            titulo= "";
            autor = "";
            categoria = "";
            editorial = "";
            aniopub="";
            idioma="";
            
    } catch (Exception e) {
        // Maneja cualquier excepción que pueda ocurrir durante la actualización
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Error al actualizar el libro: " + e.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
   public void seleccionarLibro(LibrosDTO libro) {
    if (libro != null) {
        LibroSeleccion = libro;
      
        setId(libro.getId()); // Agrega esta línea para obtener el ID
        setTitulo(libro.getTitulo());
        setAutor(libro.getAutor());
        setCategoria(libro.getCategoria());
        setEditorial(libro.getEditorial());
        setAniopub(libro.getAniopub());
        setIdioma(libro.getIdioma());
    }
}
   
   public void VentanaCrear() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8081/BibliotecaProyecto/pages/Inicio/Autores.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Libros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
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
     * @return the Id
     */
    public Long getId() {
        return Id;
    }
    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
public String getAniopub() {
        return aniopub;
    }

    /**
     * @param aniopub the aniopub to set
     */
    public void setAniopub(String aniopub) {
        this.aniopub = aniopub;
    }
   

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
     public List<LibrosDTO> getListaLibros() {
        return listaLibros;
    }

    /**
     * @return the clienteSeleccion
     */
    public LibrosDTO getLibroSeleccion() {
        return LibroSeleccion;
    }

    /**
     * @param LibroSeleccion the clienteSeleccion to set
     */
    public void setClienteSeleccion(LibrosDTO LibroSeleccion) {
        this.LibroSeleccion = LibroSeleccion;
    }

    /**
     * @param listaLibros the lista to set
     */
    public void setListaLibros(List<LibrosDTO> listaLibros) {
        this.listaLibros = listaLibros;
    }

   
    /**
     * @return the lista
     */

    
   
}
