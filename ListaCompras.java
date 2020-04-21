/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
public class ListaCompras
{
    private ArrayList<Compra> listaC;
    private Iterator<Compra> itListaC;
    private ArrayList<ArrayList> dineroGastado=new ArrayList<ArrayList>(1);
    private Iterator<String> fecha;
    
    ListaCompras(){
        listaC=new ArrayList<Compra>(1);
        dineroGastado.add(new ArrayList<String>(1));
        dineroGastado.add(new ArrayList<Double>(1));
    }
    
    public void anadirCompra(Compra c){
        listaC.add(c);       
        if(dineroGastado.get(0).contains(c.getFecha())){
            int x=dineroGastado.get(0).indexOf(c.getFecha());
            dineroGastado.get(1).set(x,(c.getValorVenta()+(double)dineroGastado.get(1).get(x)));
        }else{
            dineroGastado.get(0).add(c.getFecha());
            dineroGastado.get(1).add(c.getValorVenta());
        }        
    }
    
    ///getValor por dia
    public double dineroCompraDia(String fecha){
        double gastado=0;
        if(dineroGastado.get(0).contains(fecha)){
            int x=dineroGastado.get(0).indexOf(fecha);
            gastado=(double)dineroGastado.get(1).get(x);
        }
        return gastado;
    }
    
    //obtener productos y cantidad de compra x dia
    public ArrayList productoCompraDia(String fecha,Inventario i){
        ArrayList<ArrayList> lista=new ArrayList<ArrayList>(1);
        lista.add(new ArrayList<Producto>(1));
        lista.add(new ArrayList(1));
        itListaC=listaC.iterator();
        while(itListaC.hasNext()){
            Compra c=itListaC.next();
            if(c.getFecha().equals(fecha)){
                Producto p=i.buscarClave(c.getClaveProducto());
                if(lista.get(0).contains(p)){
                    int x=lista.get(0).indexOf(p);
                    lista.get(1).set(x,(c.getCantidad()+(double)lista.get(1).get(x)));
                }else{
                    lista.get(0).add(p);
                    lista.get(1).add(c.getCantidad());
                }
            }
        }
        return lista;
    }
    //cantidad comprada de los productos
    public ArrayList productosCompra(Inventario i){
        ArrayList<ArrayList> lista=new ArrayList<ArrayList>(1);
        lista.add(new ArrayList<Producto>(1));
        lista.add(new ArrayList(1));
        itListaC=listaC.iterator();
        while(itListaC.hasNext()){
            Compra c=itListaC.next();            
            Producto p=i.buscarClave(c.getClaveProducto());
            if(lista.get(0).contains(p)){
                int x=lista.get(0).indexOf(p);
                lista.get(1).set(x,(c.getCantidad()+(double)lista.get(1).get(x)));
            }else{
                lista.get(0).add(p);
                lista.get(1).add(c.getCantidad());
            }            
        }
        return lista;
    }
    
    //persnas q compraron x producto
    public ArrayList<Cliente> personaComproX(ListaPersona lp, Inventario i, Producto p){
        ArrayList<Cliente> lista=new ArrayList<Cliente>(1);
        itListaC=listaC.iterator();         
        while(itListaC.hasNext()){
            Compra c=itListaC.next();
            Producto pro=i.buscarClave(c.getClaveProducto());
            if(pro==p){
                Persona per=lp.buscarConClave(c.getClaveVendedor());
                if(!lista.contains(per))lista.add((Cliente)per);
            }            
        }
        return lista;
    }
    ///compradores de el dia x
    public ArrayList<Cliente> clienteCompraDia(String fecha,ListaPersona lp){
        ArrayList<Cliente> lista=new ArrayList<Cliente>(1);
        itListaC=listaC.iterator();
        while(itListaC.hasNext()){
            Compra c=itListaC.next();
            if(c.getFecha().equals(fecha)){
                Persona p=lp.buscarConClave(c.getClaveVendedor());
                if(!lista.contains(p)){
                    lista.add((Cliente)p);
                }
            }
        }
        return lista;
    }
}
