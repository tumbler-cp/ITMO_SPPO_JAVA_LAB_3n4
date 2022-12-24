package assets.environment;

public class Moon {
    public static float airPressure = 0.001f;
    public static float gravitation = 1.2f;
    public static Place TUNNEL = new Place("ледяной туннель");
    public static Place CAVE = new Place("пещера", false);
    public static Place GROTTO = new Place("сосульчатый гротт", false);
    public static Place SURFACE = new Place("поверхность");
    public static Crystals LUNIT = new Crystals("лунит");
    public static Crystals ANTILUNIT = new Crystals("антилунит");

}