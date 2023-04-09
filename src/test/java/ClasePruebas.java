import TPIntegradorGrupo04Entrega02.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class ClasePruebas {

    @Test
    public void sumarPuntos() {
        Pronostico pronosticos = new Pronostico();
        List<String> nombres;

        String arcResultados = "src/main/java/TPIntegradorGrupo04Entrega02/resultados.csv";
        LeerArchivo archivoResultados = new LeerArchivo();

        for (String[] partido : archivoResultados.registros(arcResultados)) {
            pronosticos.partidos.add(new Partido(Integer.parseInt(partido[0]), new Equipo(partido[1], ""), new Equipo(partido[4], ""), Integer.parseInt(partido[2]), Integer.parseInt(partido[3])));
        }


        String arcPronostico = "src/main/java/TPIntegradorGrupo04Entrega02/pronostico.csv";
        LeerArchivo archivoPronosticos = new LeerArchivo();
        for (String[] pronostico : archivoPronosticos.registros(arcPronostico)) {
            pronosticos.equipos.add(new Pronostico(new Equipo(pronostico[1], ""), new Equipo(pronostico[5], ""), pronostico[0], pronostico[2], pronostico[3], pronostico[4]));
        }

        nombres = pronosticos.puntaje(arcPronostico);

        System.out.println(nombres.get(3) + " = " + pronosticos.puntajePorpersona(nombres.get(3)));

        assertEquals(2, pronosticos.puntajePorpersona(nombres.get(3)), 0.001);
        //nombres.get(3) pertenece a Mariana que tiene 2 aciertos


      /*                 pronostico.csv
            Mariana;Argentina;x;;;Arabia Saudita;0
            Mariana;Polonia;x;;;México;0
            Marcos;Polonia;;x;;México;1
            Mariana;Brasil;x;;;Chile;1               -Gana Brasil un punto-
            Francisca;Arabia Saudita;;x;;Polonia;0
            Pedro;Argentina;x;;;Arabia Saudita;0
            Caro;Argentina;;;x;Arabia Saudita;1
            Pedro;Polonia;;;x;México;0
            Pedro;Alemania;x;;;Francia;0
            Pedro;Arabia Saudita;;;x;Polonia;1
            Jorge;Arabia Saudita;;;x;Polonia;1
            Mariana;Arabia Saudita;;;x;Polonia;1     -Gana Polonia un punto-

                         partidos.csv
            1;Argentina;1;2;Arabia Saudita
            1;Polonia;0;0;México
            1;Argentina;2;0;México
            1;Arabia Saudita;0;2;Polonia              -Gana Polonia
            1;Alemania;0;1;Francia
            1;Brasil;5;0;Chile                        -Gana Brasil-

    } */
    }
}
