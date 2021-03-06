/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulatina.patrones.diarioFacil;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class MenuCategorias {
   public static Dao categoria;
   public void menu(){
       categoria=new CategoriaDao();
       int opcion=0;
       int id=0;
       boolean invalido; 
       String nombre;
       StringBuffer s=new StringBuffer(); 
        s.append("Ingrese una opción:\n");
        s.append("1.Nueva categoría \n");
        s.append("2.Ver categorías \n");
        s.append("3. Buscar categoría por id \n");
        s.append("4.Ver productos por categoría \n");
        s.append("5.Modificar categoría \n");
        s.append("6.Borrar categoría \n");
        s.append("7.Volver");
        String strOp;
        boolean cancelo1=false;
        do{
            do{
                invalido=false;
                try{
                    strOp=JOptionPane.showInputDialog(s);
                    if(strOp==null){
                        cancelo1=true;
                        break;
                    }
                    opcion=Integer.parseInt(strOp);
                     
                     
                }catch(NumberFormatException nfe){
                    invalido=true;
                }
                      
            }while(invalido==true);
            
            if(cancelo1){
                break;
            }
            switch(opcion){
                case 1: 
                    String strId;
                    boolean repetido=false;
                    try{
                        strId=JOptionPane.showInputDialog("Ingrese el id "
                             + "de la categoría");
                        if(strId==null){
                            break;
                        }
                        id=Integer.parseInt(strId);
                   
                      List<Categoria> lst=categoria.getAll();
                      for(Categoria cat:lst){
                          if(cat.getCodCategoria()==id){
                              repetido=true;
                          }
                      }
                      if(repetido==true){
                      JOptionPane.showMessageDialog(null,"El id ingresado ya existe");
                      break;      
                      }
                    }catch(NumberFormatException nfe){
                        break;
                    }
                   nombre=JOptionPane.showInputDialog("Ingrese el nombre de "
                           + "la categoría");
                   if(nombre==null){
                       break;
                   }
                   Categoria c=new Categoria(id,nombre,false);
                   categoria.save(c);
                   break;
                case 2:
                    boolean entro=false; 
                    List<Categoria> lst=categoria.getAll();
                    String categorias="Lista de categorías \n";
                    for(Categoria cate:lst){
                        if(cate.isBorrado()==false){
                            entro=true; 
                        categorias=categorias+"Código:"+cate.getCodCategoria()+
                                " Nombre: "+cate.getNombreCategoria()+"\n";    
                        }
                        
                    }
                    if(lst.isEmpty()||entro==false){
                        categorias="No hay ninguna categoría registrada";
                    }
                    JOptionPane.showMessageDialog(null,categorias);
                    break;
                case 3:
                    String strIdBusca;
                    try{
                        strIdBusca=JOptionPane.showInputDialog("Ingrese el id de "
                               + " la categoría que quiere ver ");
                        
                        if(strIdBusca==null){
                            break;
                        }
                        id=Integer.parseInt(strIdBusca);
                     
                       Optional<Categoria> opCat=categoria.get(id);
                       if(opCat.isPresent()==false || opCat.get().isBorrado()==true){
                           
                       JOptionPane.showMessageDialog(null,"El id ingresado no corresponde con ninguna categoría");    
                       
                       break;    
                       
                       }else{
                           String categoriaId="Código: "+opCat.get().getCodCategoria()
                                   +" Nombre: "+opCat.get().getNombreCategoria();
                           JOptionPane.showMessageDialog(null,categoriaId);
                       }
                       
                     
                            
                  
                    }catch(NumberFormatException nfe){
                        break;
                    
                    }
                    break; 
                case 4: 
                   String strBuscaProd;
                  try{
                      strBuscaProd=JOptionPane.showInputDialog("Ingrese el id de "
                               + " la categoría de la cual quiere consultar sus productos ");
                      
                      if(strBuscaProd==null){
                          break;
                      }
                      
                      id=Integer.parseInt(strBuscaProd);
                    
                       Optional<Categoria> opCat=categoria.get(id);
                       if(opCat.isPresent()==false || opCat.get().isBorrado()==true){
                       JOptionPane.showMessageDialog(null,"El id ingresado no corresponde con ninguna categoría");    
                       break;    
                       }else{
                            String productosStr="Lista de productos de la categoría "+
                                    opCat.get().getNombreCategoria()+"\n";
                            
                           Dao prod=new ProductoDao();
                           Dao prove=new ProveedorDao();
                           Optional<Proveedor> opProve;
                           List<Producto> productos=prod.getAll();
                           for(Producto p:productos){
                               if(p.getCodCategoria()==id){
                               opProve=prove.get(p.getCodProveedor());  
                                 if(opProve.isPresent()==true && p.isBorrado()==false){
                                    
                                     
                                   productosStr=productosStr+"Código:"+p.getCodProducto()+
                                           " Nombre: "+p.getNombreProd()+
                                           " Precio: "+p.getPrecio()+
                                           " Stock Actual: "+p.getStockActual()+
                                           " Stock mínimo: "+p.getStockMinimo()+
                                           " Proveedor: "+opProve.get().getNombre()+"\n";  
                                 }
                                   
                                                   
                               }
                           }
                           
                           if(productos.isEmpty()){
                               productosStr="La categoría elegida no contiene ningún "
                                       + "producto";
                           }
                           JOptionPane.showMessageDialog(null,productosStr);
                        
                       }
                       
                     
                            
                  
                    }catch(NumberFormatException nfe){
                        break;
                    
                    }
                    break;   
                case 5:
                    String strIdMod;
                   try{
                       strIdMod=JOptionPane.showInputDialog("Ingrese el id"
                              + " de la categoría a modificar");
                       if(strIdMod==null){
                           break;
                       }
                       id=Integer.parseInt(strIdMod);
                
                      Optional<Categoria> opCat=categoria.get(id);
                      
                    
                      if(opCat.isPresent()==false || opCat.get().isBorrado()==true){
                       JOptionPane.showMessageDialog(null,"El id ingresado no corresponde"
                               + " con ninguna categoría");
                      break;   
                      }else{
                          String nom;
                         
                          nom=JOptionPane.showInputDialog("Ingrese el nuevo nombre"
                                  + " de la categoría \n (Si deja el espacio en blanco, se"
                                  + " mantendrá el actual)");
                          if(nom==null){
                              break;
                          }
                         if(nom.equalsIgnoreCase("")){
                             nom=opCat.get().getNombreCategoria();
                         }
                         
                         String[] actualiza=new String[]{nom};
                         Categoria catAux=new Categoria(id,nom,true);
                         categoria.update(catAux, actualiza);
                         
                       
                         
                      }
                      
                    }catch(NumberFormatException nfe){
                        break;
                    }
                    break; 
                case 6:
                    String strIdBorra;
                    try{
                        strIdBorra=JOptionPane.showInputDialog("Ingrese el id"
                            + " de la categoría a borrar");
                        if(strIdBorra==null){
                            break;
                        }
                        id=Integer.parseInt(strIdBorra);
             
                    Optional <Categoria> opCat=categoria.get(id);
                    
                    if(opCat.isPresent()==false || opCat.get().isBorrado()==true){
                    JOptionPane.showMessageDialog(null,"El id ingresado no corresponde con ninguna categoría");  
                    break;
                    }else{
                        Categoria catDel=new Categoria(id,"",false);
                    categoria.delete(catDel);
                    
                       
                        
                    }
                    
                    }catch(NumberFormatException nfe){
                        break;
                    }
                    break;
                case 7:
                    break;
            }
        }while(opcion!=7);
   }
}
