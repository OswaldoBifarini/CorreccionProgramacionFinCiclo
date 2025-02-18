/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareascorreccionmvc.modelo;

/**
 *
 * @author DELL
 */
 import java.io.*;
public class GestorTareas {
    private final int tamanioVector = 10;
    private Tarea[] tareas = new Tarea[tamanioVector];
    private int cont = 0;
    private final String archivo = "tareas.txt";

    public String agregarTarea(Tarea tarea) {
        if (cont < tareas.length) {
            tarea.setId(cont);
            tareas[cont] = tarea;
            guardarEnArchivo(tarea);
            cont++;
            return "Tarea agregada exitosamente.";
        } else {
            return "No se pueden agregar más tareas. El límite es " + tamanioVector + ".";
        }
    }

    private void guardarEnArchivo(Tarea tarea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(tarea.getId() + "," + tarea.getTitulo() + "," + tarea.getDescripcion() + "," + tarea.getEstado());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tarea[] listarTareas() {
        return cargarDesdeArchivo();
    }

    private Tarea[] cargarDesdeArchivo() {
        Tarea[] lista = new Tarea[tamanioVector];
        int index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null && index < tamanioVector) {
                String[] partes = linea.split(",");
                lista[index] = new Tarea(Integer.parseInt(partes[0]), partes[1], partes[2], Boolean.parseBoolean(partes[3]));
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
    

