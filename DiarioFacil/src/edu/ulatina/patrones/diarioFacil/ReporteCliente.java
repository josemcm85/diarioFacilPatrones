/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.patrones.diarioFacil;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author wesli
 */
public class ReporteCliente {
    void verHistorial(int idCliente){
        boolean haComprado=false;
       ResultSet rs=null; 
        Statement stmt=null; 
        String listaOrdenes="                   "
                + "            "
                + "Historial de Compras \n";
        int idOrdenActual;

        String fechaActual;
        String fecha;
        String hora;
        double montoActual; 
        try{
            Conexion conexion=Conexion.getInstance();
            conexion.conectar();
            stmt=conexion.conn.createStatement();
            String sql; 
            sql=String.format("Select idOrden,cliente,fechaOrden,total from bdpatrones.orden"
                    + " where cliente="+idCliente);
            rs=stmt.executeQuery(sql);
            
            while(rs.next()){
                haComprado=true;
              idOrdenActual=rs.getInt("idOrden");
              
              fechaActual=rs.getString("fechaOrden");
              montoActual=rs.getDouble("total");
              fecha=fechaActual.substring(0,11);
              hora=fechaActual.substring(11,16);
              listaOrdenes=listaOrdenes+"# Factura: "+idOrdenActual+
               " Fecha: "+fecha+" Hora: "+hora+" Monto:₡ "+montoActual+"\n";
            }
            
            if(haComprado){
                JOptionPane.showMessageDialog(null,listaOrdenes);
            }else{
                    JOptionPane.showMessageDialog(null,"Usted no ha realizado ninguna compra aún");
            }
        
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
}
