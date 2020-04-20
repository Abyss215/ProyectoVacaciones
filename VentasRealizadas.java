/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
public class VentasRealizadas
{
    private ArrayList<Venta> listaV;
    private Iterator<Venta> itListaV;
    private ArrayList<ArrayList> gananciaDiaria=new ArrayList<ArrayList>(1);
    private Iterator<String> fecha;
    
    VentasRealizadas(){
        listaV=new ArrayList<Venta>(1);
        gananciaDiaria.add(new ArrayList<String>(1));
        gananciaDiaria.add(new ArrayList(1));
    }
    
    public void anadirVenta(Venta v){
        listaV.add(v);       
        if(gananciaDiaria.get(0).contains(v.getFecha())){
            int x=gananciaDiaria.get(0).indexOf(v.getFecha());
            gananciaDiaria.get(1).set(x,(v.getValorVenta()+(float)gananciaDiaria.get(1).get(x)));
        }else{
            gananciaDiaria.get(0).add(v.getFecha());
            gananciaDiaria.get(1).add(v.getValorVenta());
        }        
    }
    
    ///getValor por dia
    public float dineroVentaDia(String fecha){
        float ganancia=0;
        if(gananciaDiaria.get(0).contains(fecha)){
            int x=gananciaDiaria.get(0).indexOf(fecha);
            ganancia=(float)gananciaDiaria.get(1).get(x);
        }
        return ganancia;
    }
    
    //obtener productos y cantidad de venta x dia
    public ArrayList productoVentaDia(String fecha,Inventario i){
        ArrayList<ArrayList> lista=new ArrayList<ArrayList>(1);
        lista.add(new ArrayList<Producto>(1));
        lista.add(new ArrayList(1));
        itListaV=listaV.iterator();
        Venta v;
        while(itListaV.hasNext()){
            v=itListaV.next();
            if(v.getFecha().equals(fecha)){
                Producto p=i.buscarClave(v.getClaveProducto());
                if(lista.get(0).contains(p)){
                    int x=lista.get(0).indexOf(p);
                    lista.get(1).set(x,(v.getCantidad()+(float)lista.get(1).get(x)));
                }else{
                    lista.get(0).add(p);
                    lista.get(1).add(v.getCantidad());
                }
            }
        }
        return lista;
    }
    //cantidad vendida de los productos
    public ArrayList productosVentas(Inventario i){
        ArrayList<ArrayList> lista=new ArrayList<ArrayList>(1);
        lista.add(new ArrayList<Producto>(1));
        lista.add(new ArrayList(1));
        itListaV=listaV.iterator();
        Venta v;
        while(itListaV.hasNext()){
            v=itListaV.next();            
            Producto p=i.buscarClave(v.getClaveProducto());
            if(lista.get(0).contains(p)){
                int x=lista.get(0).indexOf(p);
                lista.get(1).set(x,(v.getCantidad()+(float)lista.get(1).get(x)));
            }else{
                lista.get(0).add(p);
                lista.get(1).add(v.getCantidad());
            }            
        }
        return lista;
    }
    
    //persnas q vendieron x producto
    public ArrayList<Vendedor> personaVendioX(ListaPersona lp, Inventario i, Producto p){
        ArrayList<Vendedor> lista=new ArrayList<Vendedor>(1);
        itListaV=listaV.iterator();         
        while(itListaV.hasNext()){
            Venta v=itListaV.next();
            Producto pro=i.buscarClave(v.getClaveProducto());
            if(pro==p){
                Persona per=lp.buscarConClave(v.getClaveVendedor());
                if(!lista.contains(per))lista.add((Vendedor)per);
            }            
        }
        return lista;
    }
    ///vendedor de el dia
    public ArrayList<Vendedor> VendedorVentaDia(String fecha,ListaPersona lp){
        ArrayList<Vendedor> lista=new ArrayList<Vendedor>(1);
        itListaV=listaV.iterator();
        while(itListaV.hasNext()){
            Venta v=itListaV.next();
            if(v.getFecha().equals(fecha)){
                Persona p=lp.buscarConClave(v.getClaveVendedor());
                if(!lista.contains(p)){
                    lista.add((Vendedor)p);
                }
            }
        }
        return lista;
    }
    
    
}
