/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
public class Inventario
{
    private ArrayList<Producto> almacen=new ArrayList<Producto>(1);
    private Iterator<Producto> itAlmacen;
    Inventario(){}
    
    public void agregarProducto(Producto p){
        almacen.add(p);
    }
    //modificar inventario
    public double subirExistencia(String clave, double c){
        Producto p=buscarClave(clave);
        c=reconfigurar(c,p);
        p.setExistencia(p.getExistencia()+c);
        return c;
    }
    public double bajarExistencia(String clave, double c){
        Producto p=buscarClave(clave);
        c=reconfigurar(c,p);
        p.setExistencia(p.getExistencia()-c);
        return c;
    }
    private double reconfigurar(double d, Producto p){
        if(p instanceof Abarrote)
            return d;
        else{            
            String x=Double.toString(d);
            String[] a=x.split(".");
            double e=Double.parseDouble(a[0]);
            double ex=Double.parseDouble(a[1]);
            if(ex>=.75) e+=.75;
            else if(ex>=.50) e+=.50;
            else if(ex>=.25) e+=.25;
            return e;
        }
    }
    //get
    public ArrayList<Producto> getProductos(){
        return almacen;
    }
    ///busquedas
    //clave
    public Producto buscarClave(String clave){
        Producto p;
        itAlmacen=almacen.iterator();
        while(itAlmacen.hasNext()){
            p=itAlmacen.next();
            if(p.getClave().equals(clave))
            return p;
        }
        return null;
    }
    //nombre
    public Producto buscarNombre(String nom){
        Producto p;
        itAlmacen=almacen.iterator();
        while(itAlmacen.hasNext()){
            p=itAlmacen.next();
            if(p.getNombre().equals(nom))
            return p;
        }
        return null;
    }
    //menor a x cantidad
    public ArrayList<Producto> menorK(double x){
        ArrayList<Producto> menoresK=new ArrayList<Producto>(1);
        Producto p;
        itAlmacen=almacen.iterator();
        while(itAlmacen.hasNext()){
            p=itAlmacen.next();
            if(p.getExistencia()<=x)
            menoresK.add(p);
        }
        return menoresK;
    }
    
    //pocicion x
    public Producto posicion(int x){
        if(x<0||x>almacen.size())
            return almacen.get(x);
        else
            return null;
    }
    
    //contador de invercion
    //valor del producto
    public double valorProducto(Producto p){
        return p.getExistencia()*p.getPrecio();
    }
    
    public double valorProducto(String clave){
        Producto p=buscarClave(clave);
        return p.getExistencia()*p.getPrecio();
    }
    
    //valor del inventario
    public double valorAlmacen(){
        double valor=0;
        Producto p;
        itAlmacen=almacen.iterator();
        while(itAlmacen.hasNext()){
            p=itAlmacen.next();
            valor+=valorProducto(p);
        }
        return valor;
    }
}
