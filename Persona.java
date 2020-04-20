/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public abstract class Persona{
    protected String nombre, clave;
    
    Persona(String nom,String clave){
        nombre=nom;
        this.clave=clave;
    }
    ///gets
    public String getNombre(){
        return nombre;
    }
    public String getClave(){
        return clave;
    }
    ///sets
    public void setNombre(String nom){
        nombre=nom;
    }
    public void setClave(String clav){
        clave=clav;
    }
    
    public abstract String toString();
}
