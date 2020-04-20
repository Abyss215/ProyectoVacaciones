/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Compra extends Transaccion{
    private String claveProvedor;
    
    Compra(String fecha,String claveV,String clavePv, String claveP,float cant, Inventario i){
        super(fecha,claveV,claveP,cant,i);
        claveProvedor=clavePv;
        i.subirExistencia(claveProducto,cantidad);
        
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
