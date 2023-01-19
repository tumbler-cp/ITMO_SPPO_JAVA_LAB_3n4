package assets.creatures.tech;

import assets.creatures.Astronaut;
import assets.creatures.Group;
import assets.exceptions.WrongParameterException;

public class WeightlessDevice extends Tech{
    public WeightlessDevice(){
        this.setName("прибор невесомости");
        this.techType = Type.INSTRUMENT;
    }
    public static void turnOn(Astronaut user, Group group, int buffer) throws WrongParameterException {
        buffer = group.getMass();
        group.setMass(0);
        System.out.println(user + " включил прибор невесомости.");
    }
    public static void turnOff(Astronaut user, Group group, int buffer) throws WrongParameterException {
        group.setMass(buffer);
        System.out.println(user + " выключил прибор невесомости.");
    }
}