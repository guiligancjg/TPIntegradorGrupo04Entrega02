package TPIntegradorGrupo04Entrega02;

import java.util.*;

public class Pronostico{
    public List<Partido> partidos;
    public List<Pronostico> equipos;
    Equipo equipo1;
    Equipo equipo2;
    String nombre;
    String gana1;
    String empata;
    String gana2;
    ResultadoEnum resultado;


    public Pronostico(){
        this.partidos = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }

    public Pronostico(Equipo equipo1,Equipo equipo2, String nombre, String gana1, String empata, String gana2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.nombre = nombre;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
    }

    public int puntos(){
        if((resultado.equals(ResultadoEnum.GANADOR) && gana1.equals("x")) || (resultado.equals(ResultadoEnum.EMPATE) && empata.equals("x")) || (resultado.equals(ResultadoEnum.GANADOR) && gana2.equals("x"))){
            return 1;
        }
            return 0;
    }

    public List<String> puntaje(String archivo) {
        LeerArchivo archivoPronosticos = new LeerArchivo();
        List<String> nombres = new ArrayList<>();

        int i = 0;
        int indice = 0;

        for (int j = 0; j < equipos.size(); j++) {
            while (i < partidos.size()) {
                if(equipos.get(j).equipo1.nombre.equals(partidos.get(i).equipo1.nombre) && equipos.get(j).equipo2.nombre.equals(partidos.get(i).equipo2.nombre)){
                    if (equipos.get(j).gana1.equals("x") || equipos.get(j).empata.equals("x") || equipos.get(j).gana2.equals("x")) {//Gana1,Empata o Gana2
                        int golesEquipo1 = partidos.get(i).golesEquipo1;
                        int golesEquipo2 = partidos.get(i).golesEquipo2;
                        if (equipos.get(j).gana2.equals("x")) {
                            golesEquipo1 = partidos.get(i).golesEquipo2;
                            golesEquipo2 = partidos.get(i).golesEquipo1;
                        }
                        this.resultado = partidos.get(i).resultado(golesEquipo1, golesEquipo2);
                        this.gana1 = equipos.get(j).gana1;
                        this.empata = equipos.get(j).empata;
                        this.gana2 = equipos.get(j).gana2;
                        String nuevoTexto = equipos.get(j).nombre + ";" + equipos.get(j).equipo1.nombre + ";" + equipos.get(j).gana1 + ";" +
                                equipos.get(j).empata + ";" + equipos.get(j).gana2 + ";" + equipos.get(j).equipo2.nombre + ";" + puntos();
                        archivoPronosticos.escribirArchivo(archivo, indice, nuevoTexto);

                    }//cierre if Gana1,Gana2 y Empate
                }
                i++;
            }//cierre if
            if (i == partidos.size()) {
                i = 0;
            }
            nombres.add(equipos.get(j).nombre);
            indice++;
        }//cierre partidos
        Set<String> set = new HashSet<>(nombres);
        List<String> nombresSinDuplicados = new ArrayList<>(set);

        //nombresSinDuplicados.addAll(puntos);
        return nombresSinDuplicados;
    }


    public int puntajePorpersona(String nombre){
        String leerArchivoPuntos = "src/main/java/TPIntegradorGrupo04Entrega02/pronostico.csv";
        LeerArchivo archivoPronostico = new LeerArchivo();
        int total = 0;

         for (String[] punto : archivoPronostico.registros(leerArchivoPuntos)) {
             if(nombre.equals(punto[0]) && 7 == punto.length){
                 total += Integer.parseInt(punto[6]);
             }
         }

        return total;
    }

    public void tablaPronostico(String nombre){
        String leerArchivoPuntos = "src/main/java/TPIntegradorGrupo04Entrega02/pronostico.csv";
        LeerArchivo archivoPronostico = new LeerArchivo();


        System.out.format("\n"+"%-10s%-10s%-19s%-30s\n","Participante: ","("+nombre+")","Acertados","Equipo1                Equipo2");
        //System.out.format("%-18s\n",nombre);
        for (String[] punto : archivoPronostico.registros(leerArchivoPuntos)) {
            if(nombre.equals(punto[0]) && 7 == punto.length){
                    System.out.format("%-10s%-18s%-11s%-17s%-7s%-18s\n","","",punto[6],punto[1],"vs",punto[5]);

            }
        }
    }
}
