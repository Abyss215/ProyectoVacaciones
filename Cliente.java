/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
public class Cliente extends Persona{
    
    Cliente(String nom, String numClie){
        super(nom, numClie);
    }
    
    public String toString(){
        return "Cliente: "+nombre+"\n nmero de cliente: "+clave;
    }
    
    //comprar;
}
