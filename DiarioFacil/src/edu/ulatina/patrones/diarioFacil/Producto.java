/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.patrones.diarioFacil;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Producto{
   
   int codProveedor=0;
   int codProducto=0;
   String nombreProd="";
   int stockMinimo=0;
   int stockActual=0;
   double precio=0;
   int codCategoria=0;
 boolean borrado= false;
String marca="";
boolean Promocion;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isPromocion() {
        return Promocion;
    }

    public void setPromocion(boolean Promocion) {
        this.Promocion = Promocion;
    }

   
   

  
    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
 
    public Producto() {
        
    }
  
 
   public Producto(int codProveedor, int codProd,String nom, int stockMin, int stockActual,double precio,int categoria,
           boolean borrado){
       this.codProducto=codProd;
       this.codProveedor=codProveedor;
       this.nombreProd=nom;
       this.stockActual=stockActual;
       this.stockMinimo=stockMin;
       this.codCategoria=categoria;
       this.precio=precio;
      
       this.borrado=borrado;
       
   }
     public Producto(int codProveedor, int codProd,String nom, int stockMin, int stockActual,double precio,int categoria,
           boolean borrado,boolean promo,String marca){
       this.codProducto=codProd;
       this.codProveedor=codProveedor;
       this.nombreProd=nom;
       this.stockActual=stockActual;
       this.stockMinimo=stockMin;
       this.codCategoria=categoria;
       this.precio=precio;
      this.marca=marca;
      this.Promocion=promo;
       this.borrado=borrado;
       
   }
   public Producto(int idProducto,String nombre,double precio,int stockActual,boolean promo,int stockMin){
       this.codProducto=idProducto;
       this.nombreProd=nombre;
       this.precio=precio;
       this.stockActual=stockActual;
       this.Promocion=promo;
       this.stockMinimo=stockMin;
       
   }
public Producto(int idProducto){
    this.codProducto=idProducto;
}
    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getCodProducto() {
        return codProducto;
    }

   
    
    
    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }


  

   
    
  
}
