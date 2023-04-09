package TPIntegradorGrupo04Entrega02;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        Pronostico pronosticos = new Pronostico();
        Ronda rondas = new Ronda(0);
        List<String> nombres;

        String arcResultados = "src/main/java/TPIntegradorGrupo04Entrega02/resultados.csv";
        LeerArchivo archivoResultados = new LeerArchivo();

        for (String[] partido : archivoResultados.registros(arcResultados)) {
            pronosticos.partidos.add(new Partido(Integer.parseInt(partido[0]), new Equipo(partido[1], ""), new Equipo(partido[4], ""), Integer.parseInt(partido[2]), Integer.parseInt(partido[3])));
        }

        rondas.partidos(pronosticos.partidos);

        String arcPronostico = "src/main/java/TPIntegradorGrupo04Entrega02/pronostico.csv";
        LeerArchivo archivoPronosticos = new LeerArchivo();
        for (String[] pronostico : archivoPronosticos.registros(arcPronostico)) {
            pronosticos.equipos.add(new Pronostico(new Equipo(pronostico[1],""), new Equipo(pronostico[5],""),pronostico[0],pronostico[2],pronostico[3],pronostico[4]));
        }


        nombres = pronosticos.puntaje(arcPronostico);

        for (int i = 0; i < nombres.size(); i++) {
            System.out.println(nombres.get(i)+ " = "+ pronosticos.puntajePorpersona(nombres.get(i)));
        }

        System.out.println("\n\t\t\t-Cantidad de pronósticos acertados y equivocados-");
        for (int i = 0; i < nombres.size(); i++) {
            pronosticos.tablaPronostico(nombres.get(i));
        }


     }
}