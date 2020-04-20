/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Proveedor extends Persona{
    
    Proveedor(String nom, String clave){
        super(nom,clave);
    }
    
    public String toString(){
        return "Proveedor: "+nombre+"\n clave de Proveedor(RFC): "+clave;
    }
    
}
