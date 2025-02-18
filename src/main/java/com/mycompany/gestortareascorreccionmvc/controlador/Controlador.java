/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareascorreccionmvc.controlador;

import com.mycompany.gestortareascorreccionmvc.modelo.GestorTareas;
import com.mycompany.gestortareascorreccionmvc.modelo.Tarea;
import com.mycompany.gestortareascorreccionmvc.vista.InterfaceGrafica;
import com.mycompany.gestortareascorreccionmvc.vista.VentanaListarTareas;

/**
 *
 * @author DELL
 */
public class Controlador {

    private InterfaceGrafica interfaceGrafica;
    private GestorTareas gestorTarea;
    private VentanaListarTareas ventanaListarTareas;

    public Controlador(InterfaceGrafica interfaceGrafica, VentanaListarTareas ventanaListarTareas) {
        this.interfaceGrafica = interfaceGrafica;
        this.ventanaListarTareas = ventanaListarTareas;
        this.gestorTarea = new GestorTareas();
    }

    public void agregarTarea() {
        try {
            String titulo = interfaceGrafica.getTitulo();
            String descripcion = interfaceGrafica.getDescripcion();
            boolean estado = interfaceGrafica.getEstado();

            if (titulo.isEmpty() || descripcion.isEmpty()) {
                interfaceGrafica.error("Por favor, complete todos los campos.");
                return;
            }

            Tarea objTarea = new Tarea();
            objTarea.setTitulo(titulo);
            objTarea.setDescripcion(descripcion);
            objTarea.setEstado(estado);

            String mensaje = gestorTarea.agregarTarea(objTarea);
            interfaceGrafica.error(mensaje); // Muestra el mensaje de éxito o error

            // Actualiza la lista de productos
            listarTarea();
        } catch (Exception e) {
            interfaceGrafica.error("Error al agregar la tarea: " + e.getMessage());
        }
    }

    public void listarTarea() {
        try {
            Tarea[] tareas = gestorTarea.listarTareas();
            StringBuilder lista = new StringBuilder();
            for (Tarea tarea : tareas) {
                if (tarea != null) {
                    lista.append("ID: ").append(tarea.getId()).append("\n")
                         .append("Título: ").append(tarea.getTitulo()).append("\n")
                         .append("Descripción: ").append(tarea.getDescripcion()).append("\n")
                         .append("Estado: ").append(tarea.getEstado() ? "Disponible" : "Agotado").append("\n\n");
                }
            }
            ventanaListarTareas.mostrarDatos(lista.toString());
        } catch (Exception e) {
            interfaceGrafica.error("Error al listar las tareas: " + e.getMessage());
        }
    }
}
