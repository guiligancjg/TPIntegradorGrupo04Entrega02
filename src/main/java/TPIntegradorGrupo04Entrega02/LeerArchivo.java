package TPIntegradorGrupo04Entrega02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeerArchivo{

    public LeerArchivo(){}

    public List<String[]> registros(String archivo){
        List<String[]> lista = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            while(lectura != null){
                lista.add(lectura.split(";"));
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("No se pudo leer el Archivo...");
        }
        return lista;
    }

    public void escribirArchivo(String archivo, int indice, String nuevoTexto) {
        try{
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            ArrayList<String> contenidoArchivo = new ArrayList<>();
            String lineaActual = lector.readLine();
            while (lineaActual != null && !lineaActual.equals("")) {
                contenidoArchivo.add(lineaActual);
                lineaActual = lector.readLine();
            }
            lector.close();
            contenidoArchivo.set(indice, nuevoTexto);
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));
            for (String linea : contenidoArchivo) {
                escritor.write(linea);
                escritor.newLine();
            }
            escritor.close();

        }catch (Exception e){
            System.out.println("No se pudo escribir el Archivo...");
        }

    }
}
