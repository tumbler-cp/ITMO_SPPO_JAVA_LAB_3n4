package assets.creatures.tech;

import assets.creatures.Astronaut;
import assets.creatures.Group;
import assets.environment.Moon;
import assets.environment.Place;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Tech implements TransportIF{
    private List<Astronaut> Passengers = new ArrayList<>();
    private final List<Place> bannedPlaces = new ArrayList<>();

    @Override
    public void addPassengers(Astronaut... astronauts) {
        Place mainPlace = this.currPlace;
        for (Astronaut astronaut: astronauts){
            if(astronaut.inTransport) {
                System.out.println(astronaut + " уже в другом ТС.");
                continue;
            }
            if(astronaut.getCurrPlace()!=mainPlace) astronaut.move(mainPlace);
            astronaut.inTransport = true;
            Passengers.add(astronaut);
            this.mass+=astronaut.getMass();
            System.out.println(astronaut+" сел в "+this.name);
        }
    }

    @Override
    public void delPassengers(Astronaut... astronauts) {
        for(Astronaut astronaut: astronauts){
            Passengers.remove(astronaut);
            this.mass-=astronaut.getMass();
        }
    }

    @Override
    public void addPassengers(Group astronauts) {
        Place mainPlace = this.currPlace;
        for (Astronaut astronaut: astronauts.members){
            if(astronaut.inTransport) {
                System.out.println(astronaut + " уже в другом ТС.");
                continue;
            }
            if(astronaut.getCurrPlace()!=mainPlace) astronaut.move(mainPlace);
            astronaut.inTransport = true;
            Passengers.add(astronaut);
            this.mass+=astronaut.getMass();
            System.out.println(astronaut+" сел в "+this.name);
        }
    }

    @Override
    public void delPassengers(Group astronauts) {
        for(Astronaut astronaut: astronauts.members){
            Passengers.remove(astronaut);
            this.mass-=astronaut.getMass();
        }
    }

    public void carry(Place goal)
    {
        System.out.println(this+" летает.");
    }

    @Override
    public int hashCode() {
        return this.mass * Passengers.size();
    }

    @Override
    public boolean equals(Object obj) {
        SpaceShip sec = (SpaceShip) obj;
        if(this.hashCode()==sec.hashCode())return this.Passengers==sec.Passengers&&this.stat==sec.stat;
        else return false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public SpaceShip(String Name){
        super(Name);
        this.techType = Type.TRANSPORT;
        this.stat = super.status();
        bannedPlaces.add(Moon.GROTTO);
        bannedPlaces.add(Moon.CAVE);
        bannedPlaces.add(Moon.TUNNEL);
        Passengers = new ArrayList<>();
    }
}
