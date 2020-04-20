/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public abstract class Producto{
    protected float precio, existencia;
    protected String nombre, clave;
    
    Producto(float prec, String clave, String nombre, float exist){
        this.precio=prec;
        this.clave=clave;
        this.nombre=nombre;
        this.existencia=exist;
    }
    //gets
    public float getPrecio(){
        return precio;
    }
    
    public String getClave(){
        return clave;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public float getExistencia(){
        return existencia;
    }
    
    ///sets
    public void setPrecio(float pre){
        precio=pre;
    }
    
    public void setClave(String cla){
        clave=cla;
    }
    
    public void setNombre(String nom){
        nombre=nom;
    }
    
    public void setExistencia(float ex){
        existencia=ex;
    }
    //toString
    public abstract String toString();
}
