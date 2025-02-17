/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareascorreccionmvc.modelo;

/**
 *
 * @author DELL
 */
public class GestorTareas {

    int tamanioVector = 10;
    Tarea[] tareas = new Tarea[tamanioVector];
    int cont = 0;

    public String agregarTarea(Tarea tarea) {
        String mensaje = "Ingreso exitoso";
        if (cont < tareas.length) {

            for (int i = 0; i < tareas.length; i++) {
                if (tareas[i] == null) {
                    //inicializar el objeto
                    tareas[i] = new Tarea();
                    tareas[i].setId(i);
                    tareas[i].setTitulo(tarea.getTitulo());
                    tareas[i].setDescripcion(tarea.getDescripcion());
                    tareas[i].setEstado(tarea.getEstado());
                    cont++;
                    //con esto me aseguro que los datos solo se ingresen una vez en el vector. 
                    return mensaje;
                }
            }
        } else {
            mensaje = "Ingreso no permitido, el vector esta lleno";
        }
        return mensaje;
    }

    public Tarea[] listarTareas() {

        Tarea[] auxTareas = new Tarea[tamanioVector];
        for (int i = 0; i < cont; i++) {

            if (tareas[i].getEstado()) {
                auxTareas[i] = new Tarea();
                auxTareas[i].setId(tareas[i].getId());
                auxTareas[i].setTitulo(tareas[i].getTitulo());
                auxTareas[i].setDescripcion(tareas[i].getDescripcion());
                auxTareas[i].setEstado(tareas[i].getEstado());
                System.out.println("Modelo-listarTarea" + auxTareas[i].getEstado());
            }
        }
        return auxTareas;
    }
}
