package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
	
	//Attributes
	
	private static int numeroPedidos = 0;
	private static int idPedido = 1;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido;
	
	//Constructor 
	
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		itemsPedido = new ArrayList<Producto> ();
	}
	
	
	//Methods
	
	public void agregarProducto(Producto nuevoItem) {
		
		itemsPedido.add(nuevoItem);
		numeroPedidos +=1;
		
	}
	
	public String generarTextoFactura() {
		
		String mensaje = "=================";
		      mensaje += "     Factura     ";
		      mensaje += "=================";
		      mensaje += "\n id de la factura " + idPedido;
		      mensaje += "\n A nombre de: " + nombreCliente;
		      mensaje += "\n Lugar destino: " + direccionCliente;
		
		int precio = 0;
		
		for (Producto producto: itemsPedido) {
			mensaje += "\n";
			mensaje += producto.generarTextoFactura() + " ";
			mensaje += "\n";
			precio += producto.getPrecio();
			
		}
		
		mensaje += "\n Precio Neto: " + precio + " cop \n";
		double precioDecimal = precio * 0.19;
		mensaje += "IVA (19%): " + precioDecimal + " cop \n";
		double total = precio + precioDecimal;
		mensaje += "Precio Total: " + total + " cop \n";
		
		return mensaje;
	}
	
	public void guardarFactura (String textoFactura) {
		
		
		try {
		File archivo = new File("Pedido "+ idPedido);
		FileWriter writerArchivo = new FileWriter("Pedido "+ idPedido);
		
		
		archivo.createNewFile();
		writerArchivo.write(textoFactura);
		
		
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		numeroPedidos = 0;
		idPedido += 1;
	}
	
	
	//Getters
	
	public int getIdPedido() {
		return idPedido;	
	}

	
	
	
	
	
	
	
	
}
