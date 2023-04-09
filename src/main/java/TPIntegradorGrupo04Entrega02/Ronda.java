package TPIntegradorGrupo04Entrega02;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
    int nro;

    public Ronda(int nro) {
        this.nro = nro++;
    }

    public void partidos(List<Partido> partidos){
        System.out.println("\t\tRonda "+this.nro);
        System.out.format("%-10s%-5s%-10s\n","Equipos","vs","Equipos");
        for (int i = 0; i < partidos.size(); i++) {
            System.out.format("%-10s%-5s%-10s\n",partidos.get(i).equipo1.nombre,"",partidos.get(i).equipo2.nombre);
        }
        System.out.println("");
    }

    public int puntos(){

        return 0;
    }
}
