/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public abstract class Producto{
    protected double precio, existencia;
    protected String nombre, clave;
    
    Producto(double prec, String clave, String nombre, double exist){
        this.precio=prec;
        this.clave=clave;
        this.nombre=nombre;
        this.existencia=exist;
    }
    //gets
    public double getPrecio(){
        return precio;
    }
    
    public String getClave(){
        return clave;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getExistencia(){
        return existencia;
    }
    
    ///sets
    public void setPrecio(double pre){
        precio=pre;
    }
    
    public void setClave(String cla){
        clave=cla;
    }
    
    public void setNombre(String nom){
        nombre=nom;
    }
    
    public void setExistencia(double ex){
        existencia=ex;
    }
    //toString
    public abstract String toString();
}
