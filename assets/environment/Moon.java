package assets.environment;

public class Moon {
    public static float defaultAirPressure = 0.001f;
    public static float defaultGravitation = 1.2f;
    public static Place INNER_SURFACE = new Place("внутренная поверхность", false);
    public static Place TUNNEL = new Place("ледяной туннель", true);
    public static Place CAVE = new Place("пещера",true, false);
    public static Place GROTTO = new Place("сосульчатый гротт", true, false);
    public static Place SURFACE = new Place("поверхность", true);
    public static Crystals LUNIT = new Crystals("лунит");
    public static Crystals ANTILUNIT = new Crystals("антилунит");

}