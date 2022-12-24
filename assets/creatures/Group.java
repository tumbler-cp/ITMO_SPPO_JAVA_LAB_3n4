package assets.creatures;

import assets.Actor;
import assets.creatures.tech.IceBreaker;
import assets.creatures.tech.Tech;
import assets.environment.Crystals;
import assets.environment.Moon;
import assets.environment.Place;

import java.util.ArrayList;
import java.util.List;

public class Group extends Actor implements LiveObjectInterface{
    public List<Astronaut> members = new ArrayList<>();
    public void addMembers(Astronaut ... astronauts){
        Place nPlace = currPlace;
        if(members.size()==0) {
            nPlace = astronauts[0].getCurrPlace();
            currPlace = nPlace;
        }
        for(Astronaut astronaut: astronauts){
            if(astronaut.getCurrPlace()!=nPlace){
                astronaut.move(nPlace);
            }
            System.out.println(astronaut + " вступает в группу " + this.name);
            members.add(astronaut);
        }
    }
    public void delMembers(Astronaut ... astronauts){
        for (Astronaut astronaut: astronauts){
            System.out.println(astronaut + " выходит из группы "+this.name);
            members.remove(astronaut);
        }
    }
    public void mine(Crystals crystals){
        if(currPlace!=Moon.CAVE){
            System.out.println("Кристаллы можно добывать только в пещере.");
            return;
        }
        System.out.println(this.name + " добывает "+ crystals);
    }
    public void move(Place place) {
        this.currPlace = place;
        for(Astronaut member: this.members){
            member.setCurrPlace(place);
        }
        System.out.println(this.name + " переместился в " + place);
    }
    public void use(Tech tech, Object a) {

        String buf = "";
        if(tech.stat) buf = "использует "+tech + " на "+ a;
        else buf = tech + " сломан(-а)!";
        System.out.println(this.name+" "+buf);
        if(tech.getTechType() == Tech.Type.TRANSPORT){
            System.out.println("На транспорте можно только ехать.");
            return;
        } else if (tech.getTechType() == Tech.Type.INSTRUMENT) {
            if(tech instanceof IceBreaker){
                ((IceBreaker) tech).makeWay((Place) a);
            }
        }

    }

    @Override
    public int hashCode() {
        return 5*members.size();
    }

    @Override
    public boolean equals(Object obj) {
        Group sec = (Group) obj;
        if(this.hashCode() == sec.hashCode()){
            return this.members.size()==sec.members.size() && this.mass == sec.mass;
        } else return false;
    }

    @Override
    public String toString() {
        return "Группа "+this.name+" (состоит из) "+members;
    }

    @Override
    public void printPlace() {
        System.out.println("Группа "+this.name+" находится в "+this.currPlace);
    }
    public Group(String Name){
        super(Name);
    }
    public Group(String Name, Astronaut ... astronauts){
        this(Name);
        this.addMembers(astronauts);
    }
}
