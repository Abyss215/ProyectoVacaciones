/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Perecedero extends Producto{
    
    Perecedero(float precio,String clave, String nombre,float existencia){
        super(precio, clave, nombre, existencia);
    }
    
    public String toString(){
        return "El producto perecedero: "+nombre+"\n Existencias: "+existencia+"\n Precio: "+precio+"\n Clave: "+clave;
    }
}
