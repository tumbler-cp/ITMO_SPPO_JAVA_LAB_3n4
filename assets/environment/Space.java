package assets.environment;
import assets.Actor;
import assets.creatures.*;
import assets.creatures.tech.SpaceShip;
import assets.creatures.tech.techHealth;




public class Space {
    public static void checkForDanger(Astronaut actor) {
        if (actor.getCurrPlace() == Moon.SURFACE) {
            System.out.println(actor + " под действием косм. лучей");
        } else {
            System.out.println(actor + " в безопасности");
        }
    }

    public static void checkForDanger(Group group) {
        if (group.getCurrPlace() == Moon.SURFACE) {
            System.out.println(group + " под действием косм. лучей");
        } else {
            System.out.println(group + " в безопасности");
        }
    }

    public static void checkForDanger(SpaceShip tech) {
        if (tech.getHealth() == techHealth.BROKEN) {
            System.out.println(tech + " скорее всего сломан из-за метеоров");
        }
    }

    public static void compareSystemLight() {
        System.out.println("Свет отражаемы Солнцем Землёй в " + (Earth.reflectedEmission / Moon.reflectedEmission) + " раз болше чем у Луны.");
    }

    static class Earth {
        static final int reflectedEmission = 90;
    };

    public static class Moon {
        static final int reflectedEmission = 1;
        public static float defaultAirPressure = 0.001f;
        public static float defaultGravitation = 1.2f;
        public static Place INNER_SURFACE = new Place("внутренная поверхность", false);
        public static Place TUNNEL = new Place("ледяной туннель", true);
        public static Place CAVE = new Place("пещера", true, false);
        public static Place GROTTO = new Place("сосульчатый гротт", true, false);
        public static Place SURFACE = new Place("поверхность", true);
        public static Crystals LUNIT = new Crystals("лунит");
        public static Crystals ANTILUNIT = new Crystals("антилунит");
        public double Light = -0.8d;
    }
}
