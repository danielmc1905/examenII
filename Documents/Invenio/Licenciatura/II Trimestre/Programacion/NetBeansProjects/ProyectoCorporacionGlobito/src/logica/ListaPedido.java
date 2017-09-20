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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Gloriana
 */
public class ListaPedido implements Serializable {

    private ArrayList<Pedido> listPedido;

    public ListaPedido() {
        listPedido = new ArrayList();
    }

    public ArrayList<Pedido> getListPedido() {
        return listPedido;
    }

    public void setListPedido(ArrayList<Pedido> listPedido) {
        this.listPedido = listPedido;
    }

    public boolean existePedido(int vendedora, int perfume) {
        for (Pedido pedido : listPedido) {
            if (pedido.getVendedora() == vendedora
                    && pedido.getPerfume() == perfume) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarPedido(Pedido pedido) {
        if (!existePedido(pedido.getVendedora(), pedido.getPerfume())) {
            listPedido.add(pedido);
            return true;
        } else {
            return false;
        }
    }

    public TableModel imprimirTabla() {
        String etiquetas[] = new String[]{"VENDEDORA", "PERFUME", "CANTIDAD",
            "PRECIO", "TOTAL"};
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                etiquetas) {
                    boolean[] canEdit = new boolean[5];

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
        String fila[] = new String[5];
        for (Pedido pedido : listPedido) {
            fila[0] = "" + pedido.getVendedora();
            fila[1] = "" + pedido.getPerfume();
            fila[2] = "" + pedido.getCantidad();
            fila[3] = "" + pedido.getPrecio();
            fila[4] = "" + pedido.getTotal();
            modelo.addRow(fila);
        }
        return modelo;
    }

    public int posicionDe(int vendedora, int perfume) {
        for (Pedido pedido : listPedido) {
            if (pedido.getVendedora() == vendedora
                    && pedido.getPerfume() == perfume) {
                return (listPedido.indexOf(pedido));
            }
        }
        return -1;//No encontro la posicion
    }

    public void editarPedido(Pedido pedido) {
        int posicion = posicionDe(pedido.getVendedora(), pedido.getPerfume());
        listPedido.set(posicion, pedido);
    }

    public boolean quitarPedido(int vendedora, int perfume) {
        int posicionEliminar = posicionDe(vendedora, perfume);
        if (posicionEliminar != -1) {
            listPedido.remove(posicionEliminar);
            return true;
        } else {
            return false;
        }
    }

    public Pedido buscarPedido(int vendedora, int perfume) {
        for (Pedido pedido : listPedido) {
            if (pedido.getVendedora() == vendedora
                    && pedido.getPerfume() == perfume) {
                return pedido;
            }
        }
        return null;
    }

    public boolean existeVendedora(int vendedora) {
        for (Pedido pedido : listPedido) {
            if (pedido.getVendedora() == vendedora) {
                return true;
            }
        }
        return false;
    }

    public boolean existePerfume(int perfume) {
        for (Pedido pedido : listPedido) {
            if (pedido.getPerfume() == perfume) {
                return true;
            }
        }
        return false;
    }

    public void leerPedidos() {
        try {
            File fichero = new File("pedidos.txt");
            if (fichero.exists()) {
                ObjectInputStream ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
                listPedido = (ArrayList) ficheroEntrada.readObject();;
                ficheroEntrada.close();
            }
        } catch (ClassNotFoundException cnfe) {

        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
    }

    public void escribirPedidos() {
        String archivo = "pedidos.txt";
            try {
                ObjectOutputStream ficheroSalida = new ObjectOutputStream(
                        new FileOutputStream(new File(archivo)));
                ficheroSalida.writeObject(listPedido);
                ficheroSalida.flush();
                ficheroSalida.close();
                System.out.println("Datos de personas guardados correctamente en " + archivo + ".");
            } catch (FileNotFoundException fnfe) {
                System.out.println("Error: El fichero " + archivo + " no existe. ");
            } catch (IOException ioe) {
                System.out.println("Error: Falló la escritura en el fichero" + archivo + ". ");
            }
       
    }

    public int[] obtenerTotales() {
        int total[] = new int[2];
        for (Pedido pedido : listPedido) {
            total[0] += pedido.getCantidad();
            total[1] += pedido.getTotal();
        }
        return total;
    }

    public TableModel imprimirTabla(int id) {
        String etiquetas[] = new String[]{"VENDEDORA", "PERFUME", "CANTIDAD",
            "PRECIO", "TOTAL"};
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                etiquetas) {
                    boolean[] canEdit = new boolean[5];

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
        String fila[] = new String[5];
        for (Pedido pedido : listPedido) {
            if (pedido.getVendedora() == id) {
                fila[0] = "" + pedido.getVendedora();
                fila[1] = "" + pedido.getPerfume();
                fila[2] = "" + pedido.getCantidad();
                fila[3] = "" + pedido.getPrecio();
                fila[4] = "" + pedido.getTotal();
                modelo.addRow(fila);
            }
        }
        return modelo;
    }

    public void entregarPedido(int id) {
        Entrega entrega;
        Pedido pedido;
        Iterator<Pedido> it;
        it = listPedido.iterator();
        while (it.hasNext()) {
            pedido = it.next();
            if (pedido.getVendedora() == id) {
                entrega = new Entrega();
                entrega.setVendedora(pedido.getVendedora());
                entrega.setPerfume(pedido.getPerfume());
                entrega.setCantidad(pedido.getCantidad());
                entrega.setPrecio(pedido.getPrecio());
                entrega.setTotal(pedido.getTotal());
                Date now = new Date();
                DateFormat df1 = DateFormat.getDateInstance(DateFormat.SHORT);
                SimpleDateFormat format = new SimpleDateFormat("dd/M/y h:mm:ss a"); 
                
                entrega.setFecha(format.format(now));
                quitarPedido(id, pedido.getPerfume());
                Global.listaEntrega.getListEntrega().add(entrega);
                it = listPedido.iterator();
            }

        }

    }
}
