/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public abstract class Transaccion
{
    protected String fecha, claveVendedor, claveProducto;
    protected double cantidad,valor;
    Transaccion(String fecha, String claveV,String claveP){
        this.fecha=fecha;
        claveVendedor=claveV;
        claveProducto=claveP;
        //cantidad=cant;        
        //valor=cantidad*i.buscarClave(claveP).getPrecio();
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
    public double getCantidad(){
        return cantidad;
    }
    public double getValorVenta(){
        return valor;
    }
    public abstract String toString();

}
