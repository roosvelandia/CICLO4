package com.mintic.backweb.modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorCSV {
	
	private char separador;
    private char comillas;
    
    public LectorCSV(char separador, char comillas){
        this.separador = separador;
        this.comillas = comillas;   
    }
    public List<Productos> LeerCSVSimple(String path) throws IOException{
        BufferedReader bufferlectura = new BufferedReader(new FileReader(path));
        String linea = bufferlectura.readLine();
        List<Productos> productos = new ArrayList<>();
        while(linea != null){
            String[] campos = linea.split(String.valueOf(this.separador));
            Productos pro = new Productos();
            pro.setCodigo(Integer.parseInt(campos[0]));
            pro.setNombre(campos[1]);
            pro.setNitproveedor(Integer.parseInt(campos[2]));
            pro.setPrecio_compra(Double.parseDouble(campos[3]));
            pro.setIva(Double.parseDouble(campos[4]));
            pro.setPrecio_venta(Double.parseDouble(campos[5]));
            productos.add(pro);
            System.out.println(Arrays.toString(campos));
            linea = bufferlectura.readLine();
        }
        if (bufferlectura != null){
            bufferlectura.close();
        }
        return productos;
    }
	

}
