
/**
 * Write a description of class Tienda here.
 * 
 * @Criss_215 (Cristian Rdz) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
public class Tienda
{
    private Inventario i;
    private ListaPersona lp;
    private VentasRealizadas vr;
    private ListaCompras lc;
    
    Tienda(Inventario i,ListaPersona lp,VentasRealizadas vr,ListaCompras lc){
        this.i=i;
        this.lp=lp;
        this.vr=vr;
        this.lc=lc;
    }
    private ArrayList<String> listaNombres(ArrayList<Persona> arr){
        Iterator<Persona> it=arr.iterator();
        ArrayList<String> lista=new ArrayList<String>(1);
        while(it.hasNext()){
            Persona p=it.next();
            lista.add(p.getNombre());
        }
        return lista;
    }
    private ArrayList<String> listaNom(ArrayList<Producto> arr){
        Iterator<Producto> it=arr.iterator();
        ArrayList<String> lista=new ArrayList<String>(1);
        while(it.hasNext()){
            Producto p=it.next();
            lista.add(p.getNombre());
        }
        return lista;
    }
    private Producto seleccionarProducto(){
        int resp=0;
        Object[] opciones3=listaNom(i.getProductos()).toArray();
        String ress = (String) JOptionPane.showInputDialog(null, "Seleccione Producto", "Producto", JOptionPane.QUESTION_MESSAGE, null, opciones3, opciones3[0]);
        for(int x=0;x<opciones3.length;x++){
            if(opciones3[x].equals(ress)){
            resp=x;
            break;}
        }
        Producto p=i.getProductos().get(resp);
        return p;
    }
    
    public String realizarCompra(){
        ArrayList<Persona> person=lp.obtenerVendedores();
        Object[] opciones=listaNombres(person).toArray();
        int resp = JOptionPane.showOptionDialog(null, "Seleccione Vendedor", "Vendedor", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        Vendedor vend=(Vendedor)person.get(resp);
        
        person=lp.obtenerProveedores();
        Object[] opciones2=listaNombres(person).toArray();
        resp = JOptionPane.showOptionDialog(null, "Seleccione Proveedor", "Proveedor", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);
        Proveedor pro=(Proveedor)person.get(resp);
        
        
        Producto p=seleccionarProducto();
        String fecha= JOptionPane.showInputDialog("Fecha de compra", "DD/MM/AA");
        double cantidad=Double.parseDouble(JOptionPane.showInputDialog("cantidad de compra", "00.00"));
        return vend.comprar(fecha,pro,p,cantidad,i,lc);
    }
    
    public String realizarVenta(){
        ArrayList<Persona> person=lp.obtenerVendedores();
        Object[] opciones=listaNombres(person).toArray();
        int resp = JOptionPane.showOptionDialog(null, "Seleccione Vendedor", "Vendedor", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        Vendedor vend=(Vendedor)person.get(resp);
        
        person=lp.obtenerClientes();
        Object[] opciones2=listaNombres(person).toArray();
        resp = JOptionPane.showOptionDialog(null, "Seleccione Cliente", "Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones2, opciones2[0]);
        Cliente cli=(Cliente)person.get(resp);
        
        
        Producto p=seleccionarProducto();
        String fecha= JOptionPane.showInputDialog("Fecha de compra", "DD/MM/AA");
        double cantidad=Double.parseDouble(JOptionPane.showInputDialog("cantidad de compra", "00.00"));
        return vend.vender(fecha,cli,p,cantidad,i,vr);
    }
    //inventario
    public ArrayList<Producto> obtenerProductosMenoresQueX(){
        double cantidad=Double.parseDouble(JOptionPane.showInputDialog("cantidad de minima de almacen", "00.00"));
        return i.menorK(cantidad);
    }
    
    public double valorProducto(){
        Producto p=seleccionarProducto();
        return i.valorProducto(p);
    }
    
    public double valorAlmacen(){
        return i.valorAlmacen();
    }
    ///ventas
    public double ingresosDelDiaX(){
        String fecha= JOptionPane.showInputDialog("Fecha de venta", "DD/MM/AA");
        return vr.dineroVentaDia(fecha);
    }
    
    public ArrayList cantidadProductosVendidosEnDiaX(){
        String fecha= JOptionPane.showInputDialog("Fecha de venta", "DD/MM/AA");
        return vr.productoVentaDia(fecha, i);
    }
    
    public ArrayList cantidadProductosVendidos(){
        return vr.productosVentas(i);
    }
    
    public ArrayList<Vendedor> vendedorDProductoX(){
        Producto p=seleccionarProducto();
        return vr.personaVendioX(lp,i,p);
    }
    
    public ArrayList<Vendedor> vendedoresQueVendieronDiaX(){
        String fecha= JOptionPane.showInputDialog("Fecha de venta", "DD/MM/AA");
        return vr.VendedorVentaDia(fecha,lp);
    }
    //compras
    public double gastosDelDiaX(){
        String fecha= JOptionPane.showInputDialog("Fecha de compra", "DD/MM/AA");
        return lc.dineroCompraDia(fecha);
    }
    
    public ArrayList cantidadProductosCopradosEnDiaX(){
        String fecha= JOptionPane.showInputDialog("Fecha de compra", "DD/MM/AA");
        return lc.productoCompraDia(fecha, i);
    }
    
    public ArrayList cantidadProductosComprados(){
        return lc.productosCompra(i);
    }
    
    public ArrayList<Cliente> clientesCompranProductoX(){
        Producto p=seleccionarProducto();
        return lc.personaComproX(lp,i,p);
    }
    
    public ArrayList<Cliente> clientesQueCompraronDiaX(){
        String fecha= JOptionPane.showInputDialog("Fecha de compra", "DD/MM/AA");
        return lc.clienteCompraDia(fecha,lp);
    }
}
