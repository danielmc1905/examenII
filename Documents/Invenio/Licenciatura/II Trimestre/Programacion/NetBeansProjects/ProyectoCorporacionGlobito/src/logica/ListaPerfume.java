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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gloriana
 */
public class ListaPerfume  implements Serializable{

    private  ArrayList<Perfume> listPerfume;

    public ListaPerfume() {
            listPerfume = new ArrayList();
    }

    public  ArrayList<Perfume> getListPerfume() {
        return listPerfume;
    }

    public  void setListPerfume(ArrayList<Perfume> listPerfume) {
        this.listPerfume = listPerfume;
    }

    public boolean existePerfume(int id) {
        for (Perfume perfume : listPerfume) {
            if (perfume.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarPerfume(Perfume perfume) {
        if (!existePerfume(perfume.getId())) {
            listPerfume.add(perfume);
            return true;
        } else {
            return false;
        }
    }

    public TableModel imprimirTabla() {
        String etiquetas[] = new String[]{"ID", "NOMBRE", "CANTIDAD", "PRECIO"};
        DefaultTableModel modelo = new DefaultTableModel(etiquetas, 0);

        String fila[] = new String[4];
        for (Perfume perfume : listPerfume) {
            fila[0] = "" + perfume.getId();
            fila[1] = perfume.getNombre();
            fila[2] = "" + perfume.getCantidad();
            fila[3] = "" + perfume.getPrecio();
            modelo.addRow(fila);
        }
        return modelo;
    }

   

    public int posicionDe(int id) {
        for (Perfume perfume : listPerfume) {
            if (perfume.getId() == id) {
                return (listPerfume.indexOf(perfume));
            }
        }
        return -1;//No encontro la posicion
    }

    public void editarPerfume(Perfume perfume) {
        int posicion = posicionDe(perfume.getId());
        listPerfume.set(posicion, perfume);
    }

    public boolean quitarPerfume(int id) {
        int posicionEliminar = posicionDe(id);
        if (posicionEliminar != -1) {
            listPerfume.remove(posicionEliminar);
            return true;
        } else {
            return false;
        }
    }

    public Perfume buscarPerfume(int id) {
        for (Perfume perfume : listPerfume) {
            if (perfume.getId() == id) {
                return perfume;
            }
        }
        return null;
    }

    public void leerPerfumes() {
        try {
            File fichero = new File("perfumes.txt");
            if (fichero.exists()) {
                ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
                listPerfume= (ArrayList) ficheroEntrada.readObject();;
                ficheroEntrada.close();
            } 
        } catch (ClassNotFoundException cnfe) {

        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
    }
    
    public void escribirPerfumes(){
        String archivo = "perfumes.txt";
        if (!listPerfume.isEmpty()) {
            try {
                ObjectOutputStream ficheroSalida = new ObjectOutputStream(
                        new FileOutputStream(new File(archivo)));
                ficheroSalida.writeObject(listPerfume);
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

    public int[] obtenerTotales(){
        int total[]= new int[2];
        for (Perfume perfume : listPerfume) {
            total[0]+=perfume.getCantidad();
            total[1]+=(perfume.getCantidad()*perfume.getPrecio());
        }
        return total;
    }

    public void devolverPerfumes(int idPerfume, int cantidad) {
        Perfume perfume = buscarPerfume(idPerfume);
        if (perfume!=null) {
            perfume.setCantidad(perfume.getCantidad()+cantidad);
        }
    }
}
