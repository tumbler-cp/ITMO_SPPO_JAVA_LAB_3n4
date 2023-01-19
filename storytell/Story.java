package storytell;

import assets.creatures.Astronaut;
import assets.creatures.Dwarf;
import assets.creatures.Group;
import assets.creatures.Gender;
import assets.creatures.Health;
import assets.creatures.tech.IceBreaker;
import assets.creatures.tech.Propeller;
import assets.creatures.tech.WeightlessDevice;
import assets.environment.Space;
import assets.exceptions.WrongParameterException;

public class Story {
    public static void main(String[] args) throws WrongParameterException {
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
        int buff = 0;
        WeightlessDevice.turnOn(znayka, one, buff);
        cord.Attach(one);
        kant.checkVisibility(propeller);
        propeller.carry(Space.Moon.TUNNEL);
        WeightlessDevice.turnOff(znayka, one, buff);
        propeller.checkThrust();
        propeller.delPassengers(one);
        IceBreaker ice = new IceBreaker();
        one.use(ice, Space.Moon.GROTTO);
        one.move(Space.Moon.GROTTO);
        one.use(ice, Space.Moon.CAVE);
        one.move(Space.Moon.CAVE);
        Group two = new Group("2");
        znayka.splitGroup(one, two, znayka, zvezda, fuks, seld);
        neznayka.health = Health.SICK;
        System.out.println(neznayka +"" + neznayka.health);
        one.move(Space.Moon.SURFACE);
        Space.compareSystemLight();

    }
    
}
