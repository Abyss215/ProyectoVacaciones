/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Abarrote extends Producto{
    private String presentacion;
    
    Abarrote(double precio,String clave, String nombre,double existencia,String present){
        super(precio, clave, nombre, existencia);
        this.presentacion=present;
    }    
    //gets
    public String getPresentacion(){
        return presentacion;
    }
    ///sets   
    public void setPresent(String present){
        presentacion=present;
    }
    
    public String toString(){
        return "El producto abarrote: "+nombre+"\n Existencias: "+existencia+"\n Precio: "+precio+"\n Clave: "+clave+"\n Presentacion: "+presentacion;
    }
}
