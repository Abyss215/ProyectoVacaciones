/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Compra extends Transaccion{
    private String claveProvedor;
    
    Compra(String fecha,String claveV,String clavePv, String claveP,double cant, Inventario i){
        super(fecha,claveV,claveP);
        claveProvedor=clavePv;
        cantidad=i.subirExistencia(claveP,cant);        
        valor=cantidad*i.buscarClave(claveP).getPrecio();
        
        
    }
    
    //sets
    //gets
    public String getClaveProveedor(){
        return claveProvedor;
    }
    
    public String toString(){
        return "fecha: "+fecha+"\n clave del vendedor"+claveVendedor+"\n clave del proveedor"+claveProvedor+"\n clave del Producto:"+claveProducto+"\n cantidad de producto:"+cantidad+"\ncon un valor de: "+valor;
    }
}
