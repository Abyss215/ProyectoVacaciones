/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Vendedor extends Persona{
    
    Vendedor(String nom, String clave){
        super(nom, clave);
    }
    
    public String toString(){
        return "Vendedor: "+nombre+"\n clave de Proveedor(RFC): "+clave;
    }
    
    //comprar
    public String comprar(String fecha,Proveedor pro,Producto p,float cant, Inventario i,ListaCompras lc){
        Compra comp =new Compra(fecha,clave,pro.getClave(),p.getClave(),cant,i);
        lc.anadirCompra(comp);
        return comp.toString();
    }
    //vender
    public String vender(String fecha,Cliente cli,Producto p,float cant, Inventario i,VentasRealizadas vr){
        Venta vent =new Venta(fecha,clave,cli.getClave(),p.getClave(),cant,i);
        vr.anadirVenta(vent);
        return vent.toString();
    }
}
