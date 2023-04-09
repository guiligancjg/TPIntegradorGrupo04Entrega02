package TPIntegradorGrupo04Entrega02;

public class Partido {
    int ronda;
    Equipo equipo1;
    Equipo equipo2;
    int golesEquipo1;
    int golesEquipo2;

    public Partido(){}

    public Partido(int ronda, Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2) {
        this.ronda = ronda;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public ResultadoEnum resultado(int equipo1, int equipo2) {
        return switch (Integer.compare(equipo1, equipo2)) {
            case 0 -> ResultadoEnum.EMPATE;
            case 1 -> ResultadoEnum.GANADOR;
            default -> ResultadoEnum.PERDEDOR;
        };
    }
}
