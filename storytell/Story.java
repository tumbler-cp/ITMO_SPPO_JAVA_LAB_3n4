package storytell;

import assets.creatures.Astronaut;
import assets.creatures.Dwarf;
import assets.creatures.Group;
import assets.creatures.Astronaut.Gender;
import assets.creatures.Astronaut.health;
import assets.creatures.tech.IceBreaker;
import assets.creatures.tech.Propeller;
import assets.environment.Moon;

public class Story {
    public static void main(String[] args) {
        Moon moon = new Moon();
        Astronaut znayka = new Astronaut("Знайка", 40, Gender.MALE);
        Astronaut zvezda = new Astronaut("Пр. Звездочкин", 40, Gender.MALE);
        Astronaut fuks = new Astronaut("Фуксия", 40, Gender.FEMALE);
        Astronaut seld = new Astronaut("Селедочка", 40, Gender.FEMALE);
        Astronaut pilul = new Astronaut("Пильюлкин", 40, Gender.MALE);
        Astronaut neznayka = new Astronaut("Незнайка", 40, Gender.MALE);
        znayka.spacesuit.putOn();
        zvezda.spacesuit.putOn();
        fuks.spacesuit.putOn();
        seld.spacesuit.putOn();
        pilul.spacesuit.putOn();
        neznayka.spacesuit.putOn();
        Dwarf kant = new Dwarf("Кантик", 40, Gender.MALE);
        Dwarf kvant = new Dwarf("Квантик", 40, Gender.MALE);
        Dwarf alfa = new Dwarf("Альфа", 40, Gender.FEMALE);
        Dwarf memega = new Dwarf("Омега", 40, Gender.FEMALE);
        Propeller propeller = new Propeller(15, 5, 500);
        Propeller.nylonCord cord = propeller.new nylonCord();
        kant.help(znayka);
        kvant.help(znayka);
        alfa.help(znayka);
        memega.help(znayka);
        propeller.setDriver(znayka);
        Group one = new Group("1", znayka, zvezda, fuks, seld, pilul, neznayka);
        cord.Attach(one);
        kant.checkVisibility(propeller);
        propeller.carry(Moon.TUNNEL);
        propeller.delPassengers(one);
        IceBreaker ice = new IceBreaker();
        one.use(ice, Moon.GROTTO);
        one.move(Moon.GROTTO);
        one.use(ice, Moon.CAVE);
        one.move(Moon.CAVE);
        Group two = new Group("2");
        znayka.splitGroup(one, two, znayka, zvezda, fuks, seld);
        neznayka.Health = health.SICK;
        System.out.println(neznayka +"" + neznayka.Health);
        one.move(Moon.SURFACE);
        moon.compareLights();

    }
    
}
