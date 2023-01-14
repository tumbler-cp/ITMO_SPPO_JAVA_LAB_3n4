package storytell;

import assets.creatures.Astronaut;
import assets.creatures.Group;
import assets.creatures.tech.IceBreaker;
import assets.creatures.tech.Propeller;
import assets.creatures.tech.SpaceShip;
import assets.environment.Crystals;
import assets.environment.Moon;
import assets.environment.Place;
import assets.environment.Planet;

public class Story {
    public static Planet moon = new Planet(){
        public static float defaultAirPressure = 0.001f;
        public static float defaultGravitation = 1.2f;
        public static Place INNER_SURFACE = new Place("внутренная поверхность", false);
        public static Place TUNNEL = new Place("ледяной туннель", true);
        public static Place CAVE = new Place("пещера",true, false);
        public static Place GROTTO = new Place("сосульчатый гротт", true, false);
        public static Place SURFACE = new Place("поверхность", true);
        public static Crystals LUNIT = new Crystals("лунит");
        public static Crystals ANTILUNIT = new Crystals("антилунит");
    };
    public static void main(String[] args) {
        SpaceShip nip = new SpaceShip("НИП");
        Astronaut znayka = new Astronaut("Знайка", 40, Astronaut.Gender.MALE);
        Astronaut zvezda = new Astronaut("Звездочкин", 45, Astronaut.Gender.MALE);
        Astronaut fuxia = new Astronaut("Фуксия", 35, Astronaut.Gender.FEMALE);
        Astronaut seledka = new Astronaut("Селедочка", 37, Astronaut.Gender.FEMALE);
        Astronaut other1 = new Astronaut("Другой1", 44, Astronaut.Gender.MALE);
        Astronaut other2 = new Astronaut("Другой2", 50, Astronaut.Gender.MALE);
        Group alfa = new Group("Альфа", znayka, zvezda, fuxia, seledka, other2, other1);
        alfa.printPlace();
        Propeller propeller = new Propeller(666, 0.7f, 600);
        Propeller.nylonCord cord = propeller.new nylonCord();
        IceBreaker iceBreaker = new IceBreaker();
        cord.Attach(alfa);
        propeller.carry(Moon.TUNNEL);
        alfa.use(iceBreaker, Moon.GROTTO);
        alfa.move(Moon.GROTTO);
        alfa.use(iceBreaker, Moon.CAVE);
        alfa.move(Moon.CAVE);
        Group beta = new Group("Бета");
        znayka.splitGroup(alfa, beta, other1, other2);
        alfa.move(Moon.SURFACE);
        beta.mine(Moon.LUNIT);
        beta.mine(Moon.ANTILUNIT);
        alfa.check(nip, alfa);
    }
}
