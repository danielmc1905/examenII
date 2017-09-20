/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Gloriana
 */
public class ListaEntrega implements Serializable{

    private  ArrayList<Entrega> listEntrega;

    public ListaEntrega() {
        listEntrega = new ArrayList();
    }

    public  ArrayList<Entrega> getListEntrega() {
        return listEntrega;
    }

    public  void setListEntrega(ArrayList<Entrega> listEntrega) {
        this.listEntrega = listEntrega;
    }

    public TableModel imprimirTabla() {
        String etiquetas[] = new String[]{"VENDEDORA", "PERFUME", "CANTIDAD",
            "PRECIO", "TOTAL", "FECHA"};
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                etiquetas) {
                    boolean[] canEdit = new boolean[6];

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
        String fila[] = new String[6];
        for (Entrega entrega : listEntrega) {
            fila[0] = "" + entrega.getVendedora();
            fila[1] = "" + entrega.getPerfume();
            fila[2] = "" + entrega.getCantidad();
            fila[3] = "" + entrega.getPrecio();
            fila[4] = "" + entrega.getTotal();
            fila[5] = "" + entrega.getFecha();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public void agregarEntrega(Entrega entrega) {
        listEntrega.add(entrega);
    }

    public void leerEntregas() {
        try {
            File fichero = new File("entregas.txt");
            if (fichero.exists()) {
                ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
                listEntrega = (ArrayList) ficheroEntrada.readObject();;
                ficheroEntrada.close();
            }
        } catch (ClassNotFoundException cnfe) {

        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
    }

    public void escribirEntregas() {
        String archivo = "entregas.txt";
        if (!listEntrega.isEmpty()) {
            try {
                ObjectOutputStream ficheroSalida = new ObjectOutputStream(
                        new FileOutputStream(new File(archivo)));
                ficheroSalida.writeObject(listEntrega);
                ficheroSalida.flush();
                ficheroSalida.close();
                System.out.println("Datos de personas guardados correctamente en " + archivo + ".");
            } catch (FileNotFoundException fnfe) {
                System.out.println("Error: El fichero " + archivo + " no existe. ");
            } catch (IOException ioe) {
                System.out.println("Error: Falló la escritura en el fichero" + archivo + ". ");
            }
        } else {
            System.out.println("No hay datos que guardar. La lista está vacía. ");
        }
    }
}
