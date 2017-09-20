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
public class ListaVendedora implements Serializable {

    private ArrayList<Vendedora> listVendedora;

    public ListaVendedora() {
        if (listVendedora == null) {
            listVendedora = new ArrayList();
        }
    }

    public ArrayList<Vendedora> getListVendedora() {
        return listVendedora;
    }

    public void setListVendedora(ArrayList<Vendedora> listVendedora) {
        this.listVendedora = listVendedora;
    }

    public boolean existeVendedora(int identificacion) {
        for (Vendedora vendedora : listVendedora) {
            if (vendedora.getIdentificacion() == identificacion) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarVendedora(Vendedora vendedora) {
        if (!existeVendedora(vendedora.getIdentificacion())) {
            listVendedora.add(vendedora);
            return true;
        } else {
            return false;
        }
    }

    public TableModel imprimirTabla() {
        String etiquetas[] = new String[]{"IDENTIFICACION", "NOMBRE", "SEXO"};
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                etiquetas) {
            boolean[] canEdit = new boolean[3];

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        String fila[] = new String[3];
        for (Vendedora vendedora : listVendedora) {
            fila[0] = "" + vendedora.getIdentificacion();
            fila[1] = vendedora.getNombre();
            fila[2] = "" + vendedora.getSexo();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public int posicionDe(int identificacion) {
        for (Vendedora vendedora : listVendedora) {
            if (vendedora.getIdentificacion() == identificacion) {
                return (listVendedora.indexOf(vendedora));
            }
        }
        return -1;//No encontro la posicion
    }

    public void editarVendedora(Vendedora vendedora) {
        int posicion = posicionDe(vendedora.getIdentificacion());
        listVendedora.set(posicion, vendedora);
    }

    public boolean quitarVendedora(int identificacion) {
        int posicionEliminar = posicionDe(identificacion);
        if (posicionEliminar != -1) {
            listVendedora.remove(posicionEliminar);
            return true;
        } else {
            return false;
        }
    }

    public Vendedora buscarVendedora(int identificacion) {
        for (Vendedora vendedora : listVendedora) {
            if (vendedora.getIdentificacion() == identificacion) {
                return vendedora;
            }
        }
        return null;
    }

    public void leerVendedoras() {
        try {
            File fichero = new File("vendedoras.txt");
            if (fichero.exists()) {
                ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
                listVendedora = (ArrayList) ficheroEntrada.readObject();;
                ficheroEntrada.close();
            }
        } catch (ClassNotFoundException cnfe) {

        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
    }

    public void escribirVendedoras() {
        String archivo = "vendedoras.txt";
        if (!listVendedora.isEmpty()) {
            try {
                ObjectOutputStream ficheroSalida = new ObjectOutputStream(
                        new FileOutputStream(new File(archivo)));
                ficheroSalida.writeObject(listVendedora);
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
