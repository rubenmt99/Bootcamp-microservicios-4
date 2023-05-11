package clases;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class Test{
	
	public static void main(String[] args) {
	    List<Product> shopping = List.of(
	        new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
	        new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
	        new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
	        new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
	        new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
	        new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL)
	    );

	    BigDecimal precioTotal =
	    		// Calculamos los precios de los productos incluidos los impuestos
	    		shopping.stream().map(product -> product.getPrice().multiply(BigDecimal.valueOf(1 + (double) product.getTax().getPercent() / 100)))
	    		// Hacemos la suma de todos los BigDecimal
	    		.reduce(BigDecimal.ZERO, BigDecimal::add);
	    
	    precioTotal = precioTotal.setScale(0,RoundingMode.HALF_DOWN);
	    
	    System.out.println("Total de la compra redondeado: " + precioTotal);
	    

	 // Listar todos los productos que empiezan por "C" de manera ordenada en una lista separada por comas
        List<String> productosEmpezadosEnC= shopping.stream()
        		// Filtramos los productos que empiezan por "C"
                .filter(product -> product.getName().startsWith("C"))
                // Nuevo flujo que tiene solo el nombre de los productos
                .map(Product::getName)
                // Ordena los nombres de los productos
                .sorted()
                // Metemos los nombres en una lista
                .collect(Collectors.toList());
	    
        System.out.println("Lista de productos empezados por 'C': " + productosEmpezadosEnC);
	    
	}


}