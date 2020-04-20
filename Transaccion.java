/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public abstract class Transaccion
{
    protected String fecha, claveVendedor, claveProducto;
    protected float cantidad,valor;
    
    Transaccion(String fecha, String claveV,String claveP,float cant,Inventario i){
        this.fecha=fecha;
        claveVendedor=claveV;
        claveProducto=claveP;
        cantidad=cant;
        valor=cantidad*i.buscarClave(claveProducto).getPrecio();
    }
    
    //gets
    public String getFecha(){
        return fecha;
    }
    public String getClaveVendedor(){
        return claveVendedor;
    }
    public String getClaveProducto(){
        return claveProducto;
    }
    public float getCantidad(){
        return cantidad;
    }
    public float getValorVenta(){
        return valor;
    }
    
    public abstract String toString();
}
