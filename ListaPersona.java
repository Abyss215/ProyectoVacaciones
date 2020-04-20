/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
public class ListaPersona
{
    private ArrayList<Persona> listaP;
    private Iterator<Persona> itListaP;
    
    ListaPersona(){
        listaP=new ArrayList<Persona>(1);
    }
    
    public void agregarGente(Persona p){
        listaP.add(p);
    }
    
    //bucar 
    //clave
    public String darClave(Persona p){
        return p.getClave();
    }
    //por clave
    public Persona buscarConClave(String clave){
        itListaP=listaP.iterator();
        while(itListaP.hasNext()){
            Persona p=itListaP.next();
            if(p.getClave().equals(clave))
            return p;
        }
        return null;
    }
    //posicion
    public Persona posicion(int x){
        if(x<0||x>listaP.size())
            return listaP.get(x);
        else
            return null;
    }
    //regresar todos los Proveedores
    public ArrayList<Persona> obtenerProveedores(){
        ArrayList<Persona> prove=new ArrayList<Persona>(1);
        itListaP=listaP.iterator();
        while(itListaP.hasNext()){
            Persona p=itListaP.next();
            if(p instanceof Proveedor){
                prove.add((Proveedor)p);
            }
        }
        return prove;
    }
    //regresar todos los Vendedores
    public ArrayList<Persona> obtenerVendedores(){
        ArrayList<Persona> vende=new ArrayList<Persona>(1);
        itListaP=listaP.iterator();
        while(itListaP.hasNext()){
            Persona p=itListaP.next();
            if(p instanceof Vendedor){
                vende.add((Vendedor)p);
            }
        }
        return vende;
    }
    //regresar todos los Clientes
    public ArrayList<Persona> obtenerClientes(){
        ArrayList<Persona> clie=new ArrayList<Persona>(1);
        itListaP=listaP.iterator();
        while(itListaP.hasNext()){
            Persona p=itListaP.next();
            if(p instanceof Cliente){
                clie.add((Cliente)p);
            }
        }
        return clie;
    }
}
