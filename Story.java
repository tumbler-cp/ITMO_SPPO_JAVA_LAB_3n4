import assets.creatures.Astronaut;
import assets.creatures.Group;
import assets.creatures.tech.IceBreaker;
import assets.creatures.tech.Propeller;
import assets.creatures.tech.SpaceShip;
import assets.environment.Moon;

public class Story {
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
        Propeller propeller = new Propeller(15, 0.7f, 600);
        IceBreaker iceBreaker = new IceBreaker();
        propeller.addPassengers(alfa);
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
        alfa.check(nip);
    }
}
