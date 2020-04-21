
/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Venta extends Transaccion{
    private String claveCliente;
    
    Venta(String fecha, String claveC, String claveV, String claveP,double cant,Inventario i){
        super(fecha,claveV,claveP,cant,i);
        i.bajarExistencia(claveProducto,cantidad);
        
    } 
    //gets
    public String getClaveCliente(){
        return claveCliente;
    }
    
    public String toString(){
        return "fecha: "+fecha+"\n clave del vendedor"+claveVendedor+"\n clave del cliente"+claveCliente+"\n clave del Producto:"+claveProducto+"\n cantidad de producto:"+cantidad+"\ncon un valor de: "+valor;
    }
}
