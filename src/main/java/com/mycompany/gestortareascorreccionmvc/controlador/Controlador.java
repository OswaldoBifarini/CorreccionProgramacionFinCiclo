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
    private Tarea tarea;

    public Controlador(InterfaceGrafica interfaceGrafica, VentanaListarTareas ventanaListarTareas, Tarea tarea) {
        this.interfaceGrafica = interfaceGrafica;
        this.ventanaListarTareas = ventanaListarTareas;
        this.tarea = tarea;
        this.gestorTarea = new GestorTareas();
    }

    public Controlador(InterfaceGrafica aThis) {
    }

    public void agregarTarea() {

        try {
            if (this.interfaceGrafica != null) {
                Tarea objTarea = new Tarea();
                objTarea.setTitulo(this.interfaceGrafica.getTitulo());
                objTarea.setDescripcion(this.interfaceGrafica.getDescripcion());
                objTarea.setEstado(this.interfaceGrafica.getEstado());
                String mensaje = gestorTarea.agregarTarea(objTarea);
                interfaceGrafica.error(mensaje);

            } else {
                interfaceGrafica.error("Completa los datos!");
            }
        } catch (Exception e) {
            interfaceGrafica.error("Error controlado:" + e);
        }
    }

    public void listarTarea() {

        try {
            String mensaje = "";
            Tarea[] tareas = new Tarea[5];
            tareas = gestorTarea.listarTareas();
            if (tareas != null) {
                String lista = "";
                for (int i = 0; i < tareas.length; i++) {
                    if (tareas[i] != null) {
                        lista = lista + "id:" + tareas[i].getId() + "\n"
                                + "Titulo:" + tareas[i].getTitulo() + "\n"
                                + "Descripcion:" + tareas[i].getDescripcion() + "\n"
                                + "Estado:" + tareas[i].getEstado() + "\n";
                    }
                }
                mensaje = lista;
            } else {
                mensaje = "No hay datos para mostrar";
            }
            ventanaListarTareas.mostrarDatos(mensaje);
            

        } catch (Exception e) {
            System.out.println("Error Controlador-listarTarea: " + e);
        }
    }

    public void prueba(Tarea objTarea) {
        System.out.println("Titulo: " + objTarea.getTitulo());
        System.out.println("Descripcion: " + objTarea.getDescripcion());
        System.out.println("Estado: " + objTarea.getEstado());
    }
}
